import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
import com.github.xpenatan.jparser.builder.targets.AndroidTarget;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
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
        String idlPath = new File("src/main/cpp/imgui.idl").getCanonicalPath();
        IDLReader idlReader = IDLReader.readIDL(idlPath);
        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget());
//            targets.add(getAndroidBuildTarget());
        }
        targets.add(getEmscriptenBuildTarget(idlReader));

        generateAndBuild(idlReader, targets, true);
    }

    public static void generateAndBuild(IDLReader idlReader, ArrayList<BuildMultiTarget> targets, boolean generate) throws Exception {
        String libName = "imgui";

        String basePackage = "imgui";
        String cppSourceDir = new File("./build/imgui/").getCanonicalPath();
        String baseJavaDir = new File(".").getAbsolutePath() + "./base/src/main/java";

        String libsDir = new File("./build/c++/libs/").getCanonicalPath();
        String genDir = "../core/src/main/java";
        String libBuildPath = new File("./build/c++/").getCanonicalPath();
        String cppDestinationPath = libBuildPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imgui";

        BuildConfig buildConfig = new BuildConfig(
                cppDestinationPath,
                libBuildPath,
                libsDir,
                libName
        );

        if(generate) {
            FileHelper.copyDir(cppSourceDir, libDestinationPath);
            CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath, false);
            CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
            cppParser.generateClass = true;
            JParser.generate(cppParser, baseJavaDir, genDir);

            String teaVMgenDir = "../teavm/src/main/java/";
            TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, libName, basePackage, cppSourceDir);
            JParser.generate(teavmParser, baseJavaDir, teaVMgenDir);

            Path copyOut = new File(libDestinationPath).toPath();
            Path copyJNIOut = new File(cppDestinationPath + "/jniglue").toPath();
            FileHelper.copyDir(new File("src/main/cpp/cpp-source/custom").toPath(), copyOut);
            FileHelper.copyDir(new File("src/main/cpp/cpp-source/jni").toPath(), copyJNIOut);
        }
        JBuilder.build(buildConfig, targets);
    }

    private static BuildMultiTarget getWindowBuildTarget() throws IOException {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String libBuildPath = new File("./build/c++/").getCanonicalPath().replace("\\", "/");

        // Make a static library
        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-Isrc/imgui/");
        windowsTarget.cppInclude.add("**/imgui/*.cpp");
        multiTarget.add(windowsTarget);

        // Compile glue code and link
        WindowsTarget glueTarget = new WindowsTarget();
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-Isrc/imgui/");
        glueTarget.linkerFlags.add("../../libs/windows/imgui64.a");
        glueTarget.cppInclude.add(libBuildPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(glueTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(IDLReader idlReader) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(idlReader);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-Isrc/imgui");
        libTarget.cppInclude.add("**/imgui/*.cpp");
        libTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
        libTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
        multiTarget.add(libTarget);

        // Compile glue code and link
        EmscriptenTarget linkTarget = new EmscriptenTarget(idlReader);
        linkTarget.headerDirs.add("-includesrc/imgui/ImGuiCustom.h");
        linkTarget.linkerFlags.add("../../libs/emscripten/imgui.a");
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getAndroidBuildTarget() {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        AndroidTarget androidTarget = new AndroidTarget();
        androidTarget.addJNIHeaders();
        androidTarget.headerDirs.add("src/imgui");
        androidTarget.cppInclude.add("**/imgui/*.cpp");
        androidTarget.cppFlags.add("-Wno-error=format-security");
        multiTarget.add(androidTarget);
        return multiTarget;
    }
}