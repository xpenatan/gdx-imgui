package imgui;

import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.LinuxTarget;
import com.github.xpenatan.jparser.builder.targets.MacTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.builder.tool.BuildToolListener;
import com.github.xpenatan.jparser.builder.tool.BuildToolOptions;
import com.github.xpenatan.jparser.builder.tool.BuilderTool;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.io.File;
import java.util.ArrayList;

public class BuildNodeEditor {

    public static void main(String[] args) throws Exception {
        String libName = "nodeeditor";
        String modulePrefix = "nodeeditor";
        String basePackage = "imgui.extension.nodeeditor";
        String sourceDir =  "/build/imgui-node-editor";
        BuildToolOptions op = new BuildToolOptions(libName, basePackage, modulePrefix, sourceDir, args);
        op.moduleName = "imgui";
        op.idlName = "nodeeditor";
        JParser.CREATE_IDL_HELPER = false;
        String imguiPath = new File("./../../../imgui/").getCanonicalPath().replace("\\", "/");
        BuilderTool.build(op, new BuildToolListener() {
            @Override
            public void onAddTarget(BuildToolOptions op, IDLReader idlReader, ArrayList<BuildMultiTarget> targets) {
                if(op.teavm) {
                    targets.add(getTeaVMTarget(op, imguiPath));
                }
                if(op.windows64) {
                    targets.add(getWindowTarget(op, imguiPath));
                }
                if(op.linux64) {
                    targets.add(getLinuxTarget(op, imguiPath));
                }
                if(op.mac64) {
                    targets.add(getMacTarget(op, false, imguiPath));
                }
                if(op.macArm) {
                    targets.add(getMacTarget(op, true, imguiPath));
                }
//                if(op.android) {
//                    targets.add(getAndroidTarget(op, imguiPath));
//                }
//                if(op.iOS) {
//                    targets.add(getIOSTarget(op, imguiPath));
//                }
            }
        });
    }

    private static BuildMultiTarget getWindowTarget(BuildToolOptions op, String imguiPath) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();
        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        WindowsTarget windowsTarget = new WindowsTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        windowsTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/nodeeditor/");
        windowsTarget.cppInclude.add(libBuildCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getLinuxTarget(BuildToolOptions op, String imguiPath) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();
        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        LinuxTarget linuxTarget = new LinuxTarget();
        linuxTarget.isStatic = true;
        linuxTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        linuxTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/nodeeditor/");
        linuxTarget.cppInclude.add(libBuildCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(linuxTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getMacTarget(BuildToolOptions op, boolean isArm, String imguiPath) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();
        String imguiBuildPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        MacTarget macTarget = new MacTarget(isArm);
        macTarget.isStatic = true;
        macTarget.headerDirs.add("-I" + imguiBuildPath + "/src/imgui");
        macTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/nodeeditor/");
        macTarget.cppInclude.add(libBuildCPPPath + "/**/nodeeditor/*.cpp");
        multiTarget.add(macTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getTeaVMTarget(BuildToolOptions op, String imguiPath) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(null);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        libTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/nodeeditor");
        libTarget.cppInclude.add(libBuildCPPPath + "/src/nodeeditor/*.cpp");
        multiTarget.add(libTarget);

        return multiTarget;
    }
}