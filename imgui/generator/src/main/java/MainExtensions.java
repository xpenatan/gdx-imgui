import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainExtensions {

    public static void main(String[] args) throws Exception {
        String idlPath = new File("src/main/cpp/imgui.idl").getCanonicalPath();
        IDLReader idlReader = IDLReader.readIDL(idlPath);
        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget());
//            targets.add(getAndroidBuildTarget());
        }
//        targets.add(getEmscriptenBuildTarget(idlReader));
//
        Main.generateAndBuild(idlReader, targets, false);
    }

    private static BuildMultiTarget getWindowBuildTarget() throws IOException {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String libBuildPath = new File("./build/c++/").getCanonicalPath().replace("\\", "/");
        String textEditCPPPath = new File("../../extensions/ImGuiColorTextEdit/textedit-build/build/c++").getCanonicalPath().replace("\\", "/");

        WindowsTarget glueTarget = new WindowsTarget();
        glueTarget.libDirSuffix += "ext/";
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + libBuildPath + "/src/imgui/");
        glueTarget.headerDirs.add("-I" + libBuildPath + "/src/jniglue");
        glueTarget.linkerFlags.add(libBuildPath + "/libs/windows/imgui64.a");
        glueTarget.cppInclude.add(libBuildPath + "/src/jniglue/JNIGlue.cpp");

        {
            // add library ImGuiColorTextEdit
            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(textEditCPPPath + "/libs/windows/textedit64.a");
            glueTarget.headerDirs.add("-include" + textEditCPPPath + "/src/jniglue/JNIGlue.h");
        }

        multiTarget.add(glueTarget);
        return multiTarget;
    }
}
