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
        generate();
    }

    public static void generate() throws Exception {
        String basePackage = "imgui.imlayout";
        String idlPath = new File("src/main/cpp/imlayout.idl").getCanonicalPath();
        String cppSourceDir = new File("./src/main/cpp/source/").getCanonicalPath();
        String baseJavaDir = new File(".").getAbsolutePath() + "./imlayout-base/src/main/java";

//        JParser.CREATE_IDL_HELPER = false;
        IDLReader idlReader = IDLReader.readIDL(idlPath);

        String s = idlReader.mergeIDLFiles();

//        generateClassOnly(idlReader, basePackage, baseJavaDir, cppSourceDir);
        generateAndBuild(idlReader, basePackage, baseJavaDir, cppSourceDir, idlPath);
    }

    private static void generateClassOnly(
            IDLReader idlReader,
            String basePackage,
            String baseJavaDir,
            String cppSourceDir
    ) throws Exception {
        IDLDefaultCodeParser idlParser = new IDLDefaultCodeParser(basePackage, "C++", idlReader, cppSourceDir);
        idlParser.generateClass = true;
        String genDir = "../imlayout-core/src/main/java";
        JParser.generate(idlParser, baseJavaDir, genDir);
    }

    private static void generateAndBuild(
            IDLReader idlReader,
            String basePackage,
            String baseJavaDir,
            String cppSourceDir,
            String idlPath
    ) throws Exception {

        String libName = "imlayout";

        String libsDir = new File("./build/c++/libs/").getCanonicalPath();
        String genDir = "../imlayout-core/src/main/java";
        String libBuildPath = new File("./build/c++/").getCanonicalPath();
        String cppDestinationPath = libBuildPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imlayout";
        String customSourceDir = new File("./src/main/cpp/custom/").getCanonicalPath();

        FileHelper.copyDir(cppSourceDir, libDestinationPath);

        // Move custom code to destination build directory
        FileHelper.copyDir(customSourceDir, libDestinationPath);

        CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath);
        CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
        cppParser.generateClass = true;
        JParser.generate(cppParser, baseJavaDir, genDir);

        BuildConfig buildConfig = new BuildConfig(
                cppDestinationPath,
                libBuildPath,
                libsDir,
                libName
        );

        String teaVMgenDir = "../imlayout-teavm/src/main/java/";
        TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, libName, basePackage, cppSourceDir);
        JParser.generate(teavmParser, baseJavaDir, teaVMgenDir);

        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget());
//            targets.add(getAndroidBuildTarget());
        }
        targets.add(getEmscriptenBuildTarget(idlReader));

        JBuilder.build(buildConfig, targets);
    }

    private static BuildMultiTarget getWindowBuildTarget() throws IOException {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiPath = new File("../../../imgui/generator/build/c++/src/imgui").getCanonicalPath();
        String imguiPath2 = new File("../../../imgui/generator/build/c++/libs/windows").getCanonicalPath();

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.headerDirs.add("-I" + imguiPath);
        windowsTarget.headerDirs.add("-Isrc/imlayout/");
        windowsTarget.cppIncludes.add("**/imlayout/*.cpp");
//        windowsTarget.linkerFlags.add("-Wl,-rpath=. -L" + imguiPath2.replace("\\" ,"/"));
        windowsTarget.linkerFlags.add("-L" + imguiPath2.replace("\\" ,"/"));
        windowsTarget.linkerFlags.add("-l:imgui64.dll");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(IDLReader idlReader) throws IOException {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiCppPath = new File("../../../imgui/generator/build/c++").getCanonicalPath();
        String idlPath = new File("../../../imgui/generator/src/main/cpp/imgui.idl").getCanonicalPath();
        IDLReader.addIDL(idlReader, idlPath);

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(idlReader);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-Isrc/imlayout");
        libTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        libTarget.cppIncludes.add("**/imlayout/*.cpp");
        multiTarget.add(libTarget);

        // Compile glue code and link to make js file
        EmscriptenTarget linkTarget = new EmscriptenTarget(idlReader);
        linkTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        linkTarget.headerDirs.add("-includesrc/imlayout/ImLayoutCustom.h");
        linkTarget.headerDirs.add("-include" + imguiCppPath + "/src/imgui/ImGuiCustom.h");
        linkTarget.linkerFlags.add("../../libs/emscripten/imlayout.a");
        linkTarget.linkerFlags.add(imguiCppPath + "/libs/emscripten/imgui.a");
        multiTarget.add(linkTarget);

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