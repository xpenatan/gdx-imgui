package imgui.extension.textedit;

import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.core.util.FileHelper;
import com.github.xpenatan.jparser.cpp.CppCodeParser;
import com.github.xpenatan.jparser.cpp.CppGenerator;
import com.github.xpenatan.jparser.cpp.NativeCPPGenerator;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class BuildTextEdit {

    public static void build() throws Exception {
        boolean idlFlag = JParser.CREATE_IDL_HELPER;
        JParser.CREATE_IDL_HELPER = false;

        String libName = "textedit";
        String basePackage = "imgui.extension.textedit";

        String imguiBuildPath = new File("./build/c++/").getCanonicalPath().replace("\\", "/");
        String textEditPath = new File("../../extensions/ImGuiColorTextEdit").getCanonicalPath().replace("\\", "/");
        String textEditBuildPath = textEditPath + "/textedit-build";
        String textEditCPPPath = textEditBuildPath + "/build/c++";

        String idlPath = new File(textEditBuildPath + "/src/main/cpp/ColorTextEdit.idl").getCanonicalPath();
        IDLReader idlReader = IDLReader.readIDL(idlPath);
        String baseJavaDir = textEditBuildPath + "/../textedit-base/src/main/java";

        String cppSourceDir = new File(textEditBuildPath + "/build/ImGuiColorTextEdit/").getCanonicalPath();
        String libsDir = new File(textEditCPPPath + "/libs/").getCanonicalPath();
        String cppDestinationPath = textEditCPPPath + "/src";
        String libDestinationPath = cppDestinationPath + "/textedit";

        FileHelper.copyDir(cppSourceDir, libDestinationPath);

        Path copyOut = new File(libDestinationPath).toPath();
        FileHelper.copyDir(new File(textEditBuildPath + "/src/main/cpp/cpp-source/custom").toPath(), copyOut);

        CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath, false);
        CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
        cppParser.generateClass = true;
        JParser.generate(cppParser, baseJavaDir, textEditPath + "/textedit-core/src/main/java");

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, textEditCPPPath, libsDir, libName);

        ArrayList<BuildMultiTarget> targets = new ArrayList<>();
        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiBuildPath, textEditCPPPath));
        }

        JBuilder.build(buildConfig, targets);

        JParser.CREATE_IDL_HELPER = idlFlag;
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiBuildPath, String textEditCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        windowsTarget.headerDirs.add("-I" + imguiBuildPath + "/src/jniglue");
        windowsTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
//        windowsTarget.headerDirs.add("-I" + textEditCPPPath + "/src/jniglue/");
        windowsTarget.cppInclude.add(textEditCPPPath + "/**/textedit/*.cpp");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }
}