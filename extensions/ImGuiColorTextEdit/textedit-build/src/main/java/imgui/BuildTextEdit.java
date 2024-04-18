package imgui;

import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
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
import java.nio.file.Path;
import java.util.ArrayList;

public class BuildTextEdit {

    public static void main(String[] args) throws Exception {
        build();
    }

    private static void build() throws Exception {
        boolean idlFlag = JParser.CREATE_IDL_HELPER;
        JParser.CREATE_IDL_HELPER = false;

        String libName = "textedit";
        String basePackage = "imgui.extension.textedit";

        String imguiPath = new File("./../../../imgui/").getCanonicalPath().replace("\\", "/");
        String textEditPath = new File("./../").getCanonicalPath().replace("\\", "/");

        String textEditBasePath = textEditPath + "/textedit-base";
        String textEditBuildPath = textEditPath + "/textedit-build";
        String textEditCorePath = textEditPath + "/textedit-core";
        String textEditTeavmPath = textEditPath + "/textedit-teavm";

        String textEditCPPPath = textEditBuildPath + "/build/c++";

        String idlPath = textEditBuildPath + "/src/main/cpp/ColorTextEdit.idl";
        String cppSourceDir = textEditBuildPath + "/build/ImGuiColorTextEdit";
        String baseJavaDir = textEditBasePath + "/src/main/java";

        IDLReader idlReader = IDLReader.readIDL(idlPath);

        String libsDir = textEditCPPPath + "/libs/";
        String cppDestinationPath = textEditCPPPath + "/src";

        String libDestinationPath = cppDestinationPath + "/textedit";
        String customSourceDir = textEditBuildPath + "/src/main/cpp/custom/";

        FileHelper.copyDir(cppSourceDir, libDestinationPath);

        Path copyOut = new File(libDestinationPath).toPath();
        FileHelper.copyDir(new File(textEditBuildPath + "/src/main/cpp/cpp-source/custom").toPath(), copyOut);

        {
            // Generate C++ classes
            CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath, true);
            CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
            cppParser.generateClass = true;
            JParser.generate(cppParser, baseJavaDir, textEditCorePath + "/src/main/java");
        }
        {
            // Generate TeaVM classes
            String teavmLibname = "imgui";
            TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, teavmLibname, basePackage, cppSourceDir);
            JParser.generate(teavmParser, baseJavaDir, textEditTeavmPath + "/src/main/java/");
        }

        ArrayList<BuildMultiTarget> targets = new ArrayList<>();
        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiPath, textEditCPPPath));
            targets.add(getEmscriptenBuildTarget(imguiPath, textEditCPPPath));
        }
        if(BuildTarget.isUnix()) {
            targets.add(getLinuxBuildTarget(imguiPath, textEditCPPPath));
        }
        if(BuildTarget.isMac()) {
            targets.add(getMacBuildTarget(imguiPath, textEditCPPPath));
        }

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, textEditCPPPath, libsDir, libName);
        JBuilder.build(buildConfig, targets);

        JParser.CREATE_IDL_HELPER = idlFlag;
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiPath, String textEditCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        windowsTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
        windowsTarget.cppInclude.add(textEditCPPPath + "/**/textedit/*.cpp");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(String imguiPath, String textEditCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(null);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        libTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit");
        libTarget.cppInclude.add(textEditCPPPath + "/src/textedit/*.cpp");
        multiTarget.add(libTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getLinuxBuildTarget(String imguiPath, String textEditCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        LinuxTarget linuxTarget = new LinuxTarget();
        linuxTarget.isStatic = true;
        linuxTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        linuxTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
        linuxTarget.cppInclude.add(textEditCPPPath + "/**/textedit/*.cpp");
        multiTarget.add(linuxTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getMacBuildTarget(String imguiPath, String textEditCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        MacTarget macTarget = new MacTarget();
        macTarget.isStatic = true;
        macTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        macTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
        macTarget.cppInclude.add(textEditCPPPath + "/**/textedit/*.cpp");
        multiTarget.add(macTarget);

        MacTarget macArmTarget = new MacTarget(true);
        macArmTarget.isStatic = true;
        macArmTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        macArmTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
        macArmTarget.cppInclude.add(textEditCPPPath + "/**/textedit/*.cpp");
        multiTarget.add(macArmTarget);

        return multiTarget;
    }
}