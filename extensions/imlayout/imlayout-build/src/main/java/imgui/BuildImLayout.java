package imgui;


import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.core.util.FileHelper;
import com.github.xpenatan.jparser.cpp.CppCodeParser;
import com.github.xpenatan.jparser.cpp.CppGenerator;
import com.github.xpenatan.jparser.cpp.NativeCPPGenerator;
import com.github.xpenatan.jparser.idl.IDLReader;
import com.github.xpenatan.jparser.idl.parser.IDLDefaultCodeParser;
import com.github.xpenatan.jparser.teavm.TeaVMCodeParser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BuildImLayout {

    public static void main(String[] args) throws Exception {
        build();
    }

    private static void build() throws Exception {
        boolean idlFlag = JParser.CREATE_IDL_HELPER;
        JParser.CREATE_IDL_HELPER = false;

        String libName = "imlayout";
        String basePackage = "imgui.extension.imlayout";

        String imguiPath = new File("./../../../imgui/").getCanonicalPath().replace("\\", "/");
        String imlayoutPath = new File("./../").getCanonicalPath().replace("\\", "/");

        String imguiBasePath = imguiPath + "/imgui-base";
        String imguiBuildPath = imguiPath + "/imgui-build";
        String imguiCorePath = imguiPath + "/imgui-core";
        String imguiTeavmPath = imguiPath + "/imgui-teavm";

        String imLayoutBasePath = imlayoutPath + "/imlayout-base";
        String imLayoutBuildPath = imlayoutPath + "/imlayout-build";
        String imLayoutCorePath = imlayoutPath + "/imlayout-core";
        String imLayoutTeavmPath = imlayoutPath + "/imlayout-teavm";

        String imLayoutCPPPath = imLayoutBuildPath + "/build/c++";

        String idlPath = imLayoutBuildPath + "/src/main/cpp/imlayout.idl";
        String cppSourceDir = imLayoutBuildPath + "/src/main/cpp/source/";
        String baseJavaDir = imLayoutBasePath + "/src/main/java";

        IDLReader idlReader = IDLReader.readIDL(idlPath);

        String libsDir = imLayoutCPPPath + "/libs/";
        String cppDestinationPath = imLayoutCPPPath + "/src";

        String libDestinationPath = cppDestinationPath + "/imlayout";
        String customSourceDir = imLayoutBuildPath + "/src/main/cpp/custom/";
        FileHelper.copyDir(cppSourceDir, libDestinationPath);
        // Move custom code to destination build directory
        FileHelper.copyDir(customSourceDir, libDestinationPath);

        CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath);
        CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
        cppParser.generateClass = true;
        JParser.generate(cppParser, baseJavaDir, imLayoutCorePath + "/src/main/java");

        // Generate ImLayout classes
        String teavmLibname = "imgui";
        TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, teavmLibname, basePackage, cppSourceDir);
        JParser.generate(teavmParser, baseJavaDir, imLayoutTeavmPath + "/src/main/java/");

        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiPath, imLayoutCPPPath));
//            targets.add(getAndroidBuildTarget());
            targets.add(getEmscriptenBuildTarget(imguiPath, imLayoutCPPPath));
        }

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, imLayoutCPPPath, libsDir, libName);
        JBuilder.build(buildConfig, targets);
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiPath, String imLayoutCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        windowsTarget.headerDirs.add("-I" + imLayoutCPPPath + "/src/imlayout/");
        windowsTarget.cppInclude.add(imLayoutCPPPath + "/**/imlayout/*.cpp");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(String imguiPath, String imLayoutCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(null);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        libTarget.headerDirs.add("-I" + imLayoutCPPPath + "/src/imlayout");
        libTarget.cppInclude.add(imLayoutCPPPath + "/src/imlayout/*.cpp");
        multiTarget.add(libTarget);

        return multiTarget;
    }

//
//    private static BuildTarget getAndroidBuildTarget() {
//        AndroidTarget androidTarget = new AndroidTarget();
//        androidTarget.headerDirs.add("src/imgui");
//        androidTarget.cppIncludes.add("**/imgui/*.cpp");
//        androidTarget.cppFlags.add("-Wno-error=format-security");
//        return androidTarget;
//    }
}