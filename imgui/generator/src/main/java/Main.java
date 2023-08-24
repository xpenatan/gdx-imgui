import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.idl.IDLReader;
import com.github.xpenatan.jparser.idl.parser.IDLDefaultCodeParser;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        generate();
    }

    public static void generate() throws Exception {
        String basePackage = "imgui";
        String emscriptenCustomCodePath = new File("src\\main\\cpp\\emscripten").getCanonicalPath();
        String idlPath = new File(emscriptenCustomCodePath + "\\imgui.idl").getCanonicalPath();
        String emscriptenDir = new File("./build/bullet/").getCanonicalPath();
        String cppSourceDir = new File(emscriptenDir + "/imgui/src/").getCanonicalPath();
        String baseJavaDir = new File(".").getAbsolutePath() + "./base/src/main/java";
        IDLReader idlReader = IDLReader.readIDL(idlPath, cppSourceDir);

        generateClassOnly(idlReader, basePackage, baseJavaDir);
//        generateAndBuild();
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
//        String libName = "imgui-core";
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
}