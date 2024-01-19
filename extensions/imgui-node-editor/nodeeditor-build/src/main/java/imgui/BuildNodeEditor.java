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

public class BuildNodeEditor {

    public static void main(String[] args) throws Exception {
        build();
    }

    private static void build() throws Exception {
        boolean idlFlag = JParser.CREATE_IDL_HELPER;
        JParser.CREATE_IDL_HELPER = false;

        String libName = "nodeeditor";
        String basePackage = "imgui.extension.nodeeditor";

        String imguiPath = new File("./../../../imgui/").getCanonicalPath().replace("\\", "/");
        String nodeeditorPath = new File("./../").getCanonicalPath().replace("\\", "/");

        String nodeeditorBasePath = nodeeditorPath + "/nodeeditor-base";
        String nodeeditorBuildPath = nodeeditorPath + "/nodeeditor-build";
        String nodeeditorCorePath = nodeeditorPath + "/nodeeditor-core";
        String nodeeditorTeavmPath = nodeeditorPath + "/nodeeditor-teavm";

        String nodeEditorCPPPath = nodeeditorBuildPath + "/build/c++";

        String idlPath = nodeeditorBuildPath + "/src/main/cpp/nodeeditor.idl";
        String cppSourceDir = nodeeditorBuildPath + "/build/imgui-node-editor";
        String baseJavaDir = nodeeditorBasePath + "/src/main/java";

        IDLReader idlReader = IDLReader.readIDL(idlPath);

        String libsDir = nodeEditorCPPPath + "/libs/";
        String cppDestinationPath = nodeEditorCPPPath + "/src";

        String libDestinationPath = cppDestinationPath + "/nodeeditor";
        String customSourceDir = nodeeditorBuildPath + "/src/main/cpp/custom/";

        FileHelper.copyDir(cppSourceDir, libDestinationPath);

        Path copyOut = new File(libDestinationPath).toPath();
        FileHelper.copyDir(new File(nodeeditorBuildPath + "/src/main/cpp/cpp-source/custom").toPath(), copyOut);

        {
            // Generate C++ classes
            CppGenerator cppGenerator = new NativeCPPGenerator(libDestinationPath, true);
            CppCodeParser cppParser = new CppCodeParser(cppGenerator, idlReader, basePackage, cppSourceDir);
            cppParser.generateClass = true;
            JParser.generate(cppParser, baseJavaDir, nodeeditorCorePath + "/src/main/java");
        }
        {
            // Generate TeaVM classes
            String teavmLibname = "imgui";
            TeaVMCodeParser teavmParser = new TeaVMCodeParser(idlReader, teavmLibname, basePackage, cppSourceDir);
            JParser.generate(teavmParser, baseJavaDir, nodeeditorTeavmPath + "/src/main/java/");
        }

        ArrayList<BuildMultiTarget> targets = new ArrayList<>();
        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiPath, nodeEditorCPPPath));
            targets.add(getEmscriptenBuildTarget(imguiPath, nodeEditorCPPPath));
        }
        if(BuildTarget.isUnix()) {
            targets.add(getLinuxBuildTarget(imguiPath, nodeEditorCPPPath));
        }
        if(BuildTarget.isMac()) {
            targets.add(getMacBuildTarget(imguiPath, nodeEditorCPPPath));
        }

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, nodeEditorCPPPath, libsDir, libName);
        JBuilder.build(buildConfig, targets);

        JParser.CREATE_IDL_HELPER = idlFlag;
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiPath, String nodeeditorCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        windowsTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor/");
        windowsTarget.cppInclude.add(nodeeditorCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(String imguiPath, String nodeeditorCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(null);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        libTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor");
        libTarget.cppInclude.add(nodeeditorCPPPath + "/src/nodeeditor/*.cpp");
        multiTarget.add(libTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getLinuxBuildTarget(String imguiPath, String nodeeditorCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        LinuxTarget linuxTarget = new LinuxTarget();
        linuxTarget.isStatic = true;
        linuxTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        linuxTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor/");
        linuxTarget.cppInclude.add(nodeeditorCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(linuxTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getMacBuildTarget(String imguiPath, String nodeeditorCPPPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();

        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        MacTarget macTarget = new MacTarget();
        macTarget.isStatic = true;
        macTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        macTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor/");
        macTarget.cppInclude.add(nodeeditorCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(macTarget);

        MacTarget macArmTarget = new MacTarget(true);
        macArmTarget.isStatic = true;
        macArmTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        macArmTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor/");
        macArmTarget.cppInclude.add(nodeeditorCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(macArmTarget);

        return multiTarget;
    }
}