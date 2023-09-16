package imgui;


import com.github.xpenatan.jparser.builder.BuildConfig;
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
import com.github.xpenatan.jparser.idl.parser.IDLDefaultCodeParser;
import com.github.xpenatan.jparser.teavm.TeaVMCodeParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class BuildImLayout {

    public static void main(String[] args) throws Exception {
        generate();




//        String libName = "imlayout";
//
//        String cppPath = new File("../imlayout-base/").getCanonicalPath();
//        String genDir = new File("../imlayout-core/").getCanonicalPath();
//
//        String genJavaDir = genDir + "/src/main/java/";
//        String jniDir = genDir + "/build/c++/";
//        String sourceDir = "../imlayout-base/src/main/java/";
//        String sharedlibCppPath = new File("../../../cpp/build/c++/").getCanonicalPath();
//
//        FileCopyHelper.copyDir(cppPath + "/cpp-source", jniDir);
//
//        //Generate CPP
//        ImGuiCppParser cppParser = new ImGuiCppParser(ImGuiCppParser.getClassPath("imlayout", "core", "gdx-1", "gdx-jnigen-loader", "jParser"), jniDir);
//        JParser.generate(cppParser, sourceDir, genJavaDir);
//        CPPBuildHelper.build(libName, jniDir, "libs", null, sharedlibCppPath, "/src/", "imgui-cpp64", false);
    }

    public static void generate() throws Exception {
        String basePackage = "imgui.imlayout";
        String idlPath = new File("src/main/cpp/imlayout.idl").getCanonicalPath();
        String cppSourceDir = new File("./src/main/cpp/source/").getCanonicalPath();
        String baseJavaDir = new File(".").getAbsolutePath() + "./imlayout-base/src/main/java";
        IDLReader idlReader = IDLReader.readIDL(idlPath, cppSourceDir);

//        generateClassOnly(idlReader, basePackage, baseJavaDir);
        generateAndBuild(idlReader, basePackage, baseJavaDir, cppSourceDir, idlPath);
    }

    private static void generateClassOnly(
            IDLReader idlReader,
            String basePackage,
            String baseJavaDir
    ) throws Exception {
        IDLDefaultCodeParser idlParser = new IDLDefaultCodeParser(basePackage, "C++", idlReader);
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
        String emscriptenCustomCodePath = new File("src/main/cpp/emscripten").getCanonicalPath();

        String libsDir = new File("./build/c++/libs/").getCanonicalPath();
        String genDir = "../imlayout-core/src/main/java";
        String libBuildPath = new File("./build/c++/").getCanonicalPath();
        String cppDestinationPath = libBuildPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imlayout";

        CppGenerator cppGenerator = new NativeCPPGenerator(cppSourceDir, libDestinationPath);
        CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage);
        cppParser.generateClass = true;
        JParser.generate(cppParser, baseJavaDir, genDir);

        BuildConfig buildConfig = new BuildConfig(
                cppDestinationPath,
                libBuildPath,
                libsDir,
                libName,
                emscriptenCustomCodePath
        );

        String teaVMgenDir = "../imlayout-teavm/src/main/java/";
        TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, libName, basePackage);
        JParser.generate(teavmParser, baseJavaDir, teaVMgenDir);

//        Path copyOut = new File(libDestinationPath).toPath();
//        Path copyJNIOut = new File(cppDestinationPath + "/jniglue").toPath();
//        FileHelper.copyDir(new File("src/main/cpp/cpp-source/custom").toPath(), copyOut);
//        FileHelper.copyDir(new File("src/main/cpp/cpp-source/jni").toPath(), copyJNIOut);


        ArrayList<BuildTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget());
//            targets.add(getAndroidBuildTarget());
        }
//        targets.add(getEmscriptenBuildTarget(idlPath));

        JBuilder.build(buildConfig, targets);

    }

    private static BuildTarget getWindowBuildTarget() throws IOException {
        String imguiPath = new File("../../../imgui/generator/build/c++/src/imgui").getCanonicalPath();
        String imguiPath2 = new File("../../../imgui/generator/build/c++/libs/").getCanonicalPath();

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.headerDirs.add("-I" + imguiPath);
        windowsTarget.headerDirs.add("-Isrc/imlayout/");
        windowsTarget.cppIncludes.add("**/imlayout/*.cpp");
//        windowsTarget.linkerFlags.add("-Wl,-rpath=. -L" + imguiPath2.replace("\\" ,"/"));
        windowsTarget.linkerFlags.add("-L" + imguiPath2.replace("\\" ,"/"));
        windowsTarget.linkerFlags.add("-l:imgui64.dll");
        return windowsTarget;
    }

//    private static BuildTarget getEmscriptenBuildTarget(String idlPath) {
//        EmscriptenTarget teaVMTarget = new EmscriptenTarget(idlPath);
//        teaVMTarget.headerDirs.add("-Isrc/imgui");
//        teaVMTarget.headerDirs.add("-includesrc/jsglue/Imgui_lib.h");
////        teaVMTarget.headerDirs.add("-includesrc/imgui/imgui.h");
////        teaVMTarget.headerDirs.add("-includesrc/jsglue/custom_glue.cpp");
//        teaVMTarget.cppIncludes.add("**/imgui/*.cpp");
//        teaVMTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
//        teaVMTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
//        return teaVMTarget;
//    }
//
//    private static BuildTarget getAndroidBuildTarget() {
//        AndroidTarget androidTarget = new AndroidTarget();
//        androidTarget.headerDirs.add("src/imgui");
//        androidTarget.cppIncludes.add("**/imgui/*.cpp");
//        androidTarget.cppFlags.add("-Wno-error=format-security");
//        return androidTarget;
//    }
}