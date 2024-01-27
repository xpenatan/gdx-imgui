import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
import com.github.xpenatan.jparser.builder.targets.AndroidTarget;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.LinuxTarget;
import com.github.xpenatan.jparser.builder.targets.MacTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.core.util.FileHelper;
import com.github.xpenatan.jparser.cpp.CppCodeParser;
import com.github.xpenatan.jparser.cpp.CppGenerator;
import com.github.xpenatan.jparser.cpp.NativeCPPGenerator;
import com.github.xpenatan.jparser.idl.IDLReader;
import com.github.xpenatan.jparser.teavm.TeaVMCodeParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class BuildImGui {

    public static void main(String[] args) throws Exception {
        String imguiPath = new File("./../").getCanonicalPath().replace("\\", "/");

        String idlPath = new File("src/main/cpp/imgui.idl").getCanonicalPath();
        IDLReader idlReader = IDLReader.readIDL(idlPath);
        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiPath));
//            targets.add(getAndroidBuildTarget(imguiPath));
//            targets.add(getEmscriptenBuildTarget(imguiPath, idlReader));
        }
        if(BuildTarget.isUnix()) {
//            targets.add(getLinuxBuildTarget(imguiPath));
        }
        if(BuildTarget.isMac()) {
//            targets.add(getMacBuildTarget(imguiPath));
        }

        generateAndBuild(imguiPath, idlReader, targets, true);
    }

    public static void generateAndBuild(String imguiPath, IDLReader idlReader, ArrayList<BuildMultiTarget> targets, boolean generate) throws Exception {
        String libName = "imgui";
        String basePackage = "imgui";

        String imguiBasePath = imguiPath + "/imgui-base";
        String imguiBuildPath = imguiPath + "/imgui-build";
        String imguiCorePath = imguiPath + "/imgui-core";
        String imguiTeavmPath = imguiPath + "/imgui-teavm";

        String buildCPPPath = imguiBuildPath + "/build/c++";
        String cppSourceDir = imguiBuildPath + "/build/imgui";
        String baseJavaDir = imguiBasePath + "/src/main/java";
        String libsDir = buildCPPPath + "/libs/";
        String cppDestinationPath = buildCPPPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imgui";

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, buildCPPPath, libsDir, libName);

        if(generate) {
            FileHelper.copyDir(cppSourceDir, libDestinationPath);
            CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath, true);
            CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
            cppParser.generateClass = true;
            JParser.generate(cppParser, baseJavaDir, imguiCorePath + "/src/main/java");

            TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, libName, basePackage, cppSourceDir);
            JParser.generate(teavmParser, baseJavaDir, imguiTeavmPath + "/src/main/java/");

            Path copyOut = new File(libDestinationPath).toPath();
            Path copyJNIOut = new File(cppDestinationPath + "/jniglue").toPath();
            FileHelper.copyDir(new File(imguiBuildPath + "/src/main/cpp/cpp-source/custom").toPath(), copyOut);
            FileHelper.copyDir(new File(imguiBuildPath + "/src/main/cpp/cpp-source/jni").toPath(), copyJNIOut);
        }
        JBuilder.build(buildConfig, targets);
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiPath) throws IOException {
        String libBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        windowsTarget.cppInclude.add(libBuildPath + "/**/imgui/*.cpp");
        multiTarget.add(windowsTarget);

        // Compile glue code and link
        WindowsTarget glueTarget = new WindowsTarget();
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        glueTarget.linkerFlags.add(libBuildPath + "/libs/windows/imgui64.a");
        glueTarget.cppInclude.add(libBuildPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(glueTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(String imguiPath, IDLReader idlReader) {
        String libBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(idlReader);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui");
        libTarget.cppInclude.add(libBuildPath + "/**/imgui/*.cpp");
        libTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
        libTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
        multiTarget.add(libTarget);

        // Compile glue code and link
        EmscriptenTarget linkTarget = new EmscriptenTarget(idlReader);
        linkTarget.headerDirs.add("-include" + libBuildPath + "/src/imgui/ImGuiCustom.h");
        linkTarget.linkerFlags.add(libBuildPath + "/libs/emscripten/imgui.a");
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getAndroidBuildTarget(String imguiPath) {
        String libBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        AndroidTarget androidTarget = new AndroidTarget();
        androidTarget.addJNIHeaders();
        androidTarget.headerDirs.add(libBuildPath + "/src/imgui");
        androidTarget.cppInclude.add(libBuildPath + "/**/imgui/*.cpp");
        androidTarget.cppFlags.add("-Wno-error=format-security");
        androidTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
        androidTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
        multiTarget.add(androidTarget);
        return multiTarget;
    }

    private static BuildMultiTarget getLinuxBuildTarget(String imguiPath) {
        String libBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        LinuxTarget linuxTarget = new LinuxTarget();
        linuxTarget.isStatic = true;
        linuxTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        linuxTarget.cppInclude.add(libBuildPath + "/**/imgui/*.cpp");
        multiTarget.add(linuxTarget);

        // Compile glue code and link
        LinuxTarget glueTarget = new LinuxTarget();
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        glueTarget.linkerFlags.add(libBuildPath + "/libs/linux/libimgui64.a");
        glueTarget.cppInclude.add(libBuildPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(glueTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getMacBuildTarget(String imguiPath) {
        String libBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        MacTarget macTarget = new MacTarget();
        macTarget.isStatic = true;
        macTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        macTarget.cppInclude.add(libBuildPath + "/**/imgui/*.cpp");
        multiTarget.add(macTarget);

        // Compile glue code and link
        MacTarget glueTarget = new MacTarget();
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        glueTarget.linkerFlags.add(libBuildPath + "/libs/mac/libimgui64.a");
        glueTarget.cppInclude.add(libBuildPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(glueTarget);

        // Make a static library
        MacTarget macArmTarget = new MacTarget(true);
        macArmTarget.isStatic = true;
        macArmTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        macArmTarget.cppInclude.add(libBuildPath + "/**/imgui/*.cpp");
        multiTarget.add(macArmTarget);

        // Compile glue code and link
        MacTarget glueArmTarget = new MacTarget(true);
        glueArmTarget.addJNIHeaders();
        glueArmTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        glueArmTarget.linkerFlags.add(libBuildPath + "/libs/mac/arm/libimgui64.a");
        glueArmTarget.cppInclude.add(libBuildPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(glueArmTarget);

        return multiTarget;
    }
}