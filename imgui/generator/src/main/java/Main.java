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
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        generate();
    }

    public static void generate() throws Exception {
        String basePackage = "imgui";
        String emscriptenCustomCodePath = new File("src/main/cpp/emscripten").getCanonicalPath();
        String idlPath = new File(emscriptenCustomCodePath + "/imgui.idl").getCanonicalPath();
        String cppSourceDir = new File("./build/imgui/").getCanonicalPath();
        String baseJavaDir = new File(".").getAbsolutePath() + "./base/src/main/java";
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
        String genDir = "../core/src/main/java";
        JParser.generate(idlParser, baseJavaDir, genDir);
    }

    private static void generateAndBuild(
            IDLReader idlReader,
            String basePackage,
            String baseJavaDir,
            String cppSourceDir,
            String idlPath
    ) throws Exception {
        String libName = "imgui";

        String emscriptenCustomCodePath = new File("src/main/cpp/emscripten").getCanonicalPath();

        String libsDir = new File("./build/c++/libs/").getCanonicalPath();
        String genDir = "../core/src/main/java";
        String libBuildPath = new File("./build/c++/").getCanonicalPath();
        String cppDestinationPath = libBuildPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imgui";

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

        String teaVMgenDir = "../teavm/src/main/java/";
        TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, libName, basePackage);
        JParser.generate(teavmParser, baseJavaDir, teaVMgenDir);

        Path copyOut = new File(libDestinationPath).toPath();
        Path copyJNIOut = new File(cppDestinationPath + "/jniglue").toPath();
        FileHelper.copyDir(new File("src/main/cpp/cpp-source/custom").toPath(), copyOut);
        FileHelper.copyDir(new File("src/main/cpp/cpp-source/jni").toPath(), copyJNIOut);


        ArrayList<BuildTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
//            targets.add(getWindowBuildTarget());
            targets.add(getAndroidBuildTarget());
        }
        targets.add(getEmscriptenBuildTarget(idlPath));

        JBuilder.build(buildConfig, targets);

//
//        String path = "..\\core-build\\src\\main\\resources\\imgui.idl";
//        IDLReader idlReader = IDLReader.readIDL(path);
//
//        String cppPath = new File("../core/").getCanonicalPath();
//        String teaVMPath = new File("../core-teavm/").getCanonicalPath();
//
//        String jniDir = cppPath + "/build/c++/";
//        String sourceDir = "../core-base/src/main/java/";
//        String cppGenDir = cppPath + "/src/main/java/";
//        String teaVMGenDir = teaVMPath + "/src/main/java/";
//        String imguiCppBase = new File("../../cpp/build/c++").getCanonicalPath();
//
//        //Generate CPP
//        String classPaths = ImGuiCppParser.getClassPath("core", "gdx-1", "gdx-jnigen-loader", "jParser");
//        ImGuiCppParser cppParser = new ImGuiCppParser(idlReader, classPaths, jniDir);
//        JParser.generate(cppParser, sourceDir, cppGenDir);
////        CPPBuildHelper.DEBUG_BUILD = true;
//        CPPBuildHelper.build(libName, jniDir, null, imguiCppBase, "imgui-cpp64", true);
//
//        //Generate Javascript
//        ImGuiTeaVMParser teaVMParser = new ImGuiTeaVMParser(idlReader);
//        JParser.generate(teaVMParser, sourceDir, teaVMGenDir);
    }

    private static BuildTarget getWindowBuildTarget() {
        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.headerDirs.add("-Isrc/imgui/");
        windowsTarget.cppIncludes.add("**/imgui/*.cpp");
        return windowsTarget;
    }

    private static BuildTarget getEmscriptenBuildTarget(String idlPath) {
        EmscriptenTarget teaVMTarget = new EmscriptenTarget(idlPath);
        teaVMTarget.headerDirs.add("-Isrc/imgui");
        teaVMTarget.headerDirs.add("-includesrc/jsglue/Imgui_lib.h");
//        teaVMTarget.headerDirs.add("-includesrc/imgui/imgui.h");
//        teaVMTarget.headerDirs.add("-includesrc/jsglue/custom_glue.cpp");
        teaVMTarget.cppIncludes.add("**/imgui/*.cpp");
        teaVMTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
        teaVMTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
        return teaVMTarget;
    }

    private static BuildTarget getAndroidBuildTarget() {
        AndroidTarget androidTarget = new AndroidTarget();
        androidTarget.headerDirs.add("src/imgui");
        androidTarget.cppIncludes.add("**/imgui/*.cpp");
        androidTarget.cppFlags.add("-Wno-error=format-security");
        return androidTarget;
    }
}