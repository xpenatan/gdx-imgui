package imgui;

import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.LinuxTarget;
import com.github.xpenatan.jparser.builder.targets.MacTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsMSVCTarget;
import com.github.xpenatan.jparser.builder.tool.BuildToolListener;
import com.github.xpenatan.jparser.builder.tool.BuildToolOptions;
import com.github.xpenatan.jparser.builder.tool.BuilderTool;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BuildImLayout {

    public static void main(String[] args) throws IOException {
        String libName = "imlayout";
        String basePackage = "imgui.extension.imlayout";
        String modulePrefix = "imlayout";
        String sourceDir =  "/src/main/cpp/source";
        BuildToolOptions op = new BuildToolOptions(libName, basePackage, modulePrefix, sourceDir, args);
        op.idlName = "imlayout";
        op.moduleName = "imgui";
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
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        WindowsMSVCTarget windowsTarget = new WindowsMSVCTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        windowsTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imlayout/");
        windowsTarget.cppInclude.add(libBuildCPPPath + "/**/imlayout/*.cpp");
        multiTarget.add(windowsTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getLinuxTarget(BuildToolOptions op, String imguiPath) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        LinuxTarget linuxTarget = new LinuxTarget();
        linuxTarget.isStatic = true;
        linuxTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        linuxTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imlayout/");
        linuxTarget.cppInclude.add(libBuildCPPPath + "/**/imlayout/*.cpp");
        multiTarget.add(linuxTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getMacTarget(BuildToolOptions op, boolean isArm, String imguiPath) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        MacTarget macTarget = new MacTarget(isArm);
        macTarget.isStatic = true;
        macTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        macTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imlayout/");
        macTarget.cppInclude.add(libBuildCPPPath + "/**/imlayout/*.cpp");
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
        libTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imlayout");
        libTarget.cppInclude.add(libBuildCPPPath + "/src/imlayout/*.cpp");
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