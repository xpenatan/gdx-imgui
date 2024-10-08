import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.targets.AndroidTarget;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.LinuxTarget;
import com.github.xpenatan.jparser.builder.targets.MacTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsMSVCTarget;
import com.github.xpenatan.jparser.builder.tool.BuildToolListener;
import com.github.xpenatan.jparser.builder.tool.BuildToolOptions;
import com.github.xpenatan.jparser.builder.tool.BuilderTool;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.util.ArrayList;

public class BuildImGui {

    public static void main(String[] args) {
        String libName = "imgui";
        String modulePrefix = "imgui";
        String basePackage = "imgui";
        String sourceDir =  "/build/imgui";
        BuildToolOptions op = new BuildToolOptions(modulePrefix, libName, basePackage, sourceDir, args);
        BuilderTool.build(op, new BuildToolListener() {
            @Override
            public void onAddTarget(BuildToolOptions op, IDLReader idlReader, ArrayList<BuildMultiTarget> targets) {
                if(op.teavm) {
                    targets.add(getTeaVMTarget(op, idlReader));
                }
                if(op.windows64) {
                    targets.add(getWindowTarget(op));
                }
                if(op.linux64) {
                    targets.add(getLinuxTarget(op));
                }
                if(op.mac64) {
                    targets.add(getMacTarget(op, false));
                }
                if(op.macArm) {
                    targets.add(getMacTarget(op, true));
                }
                if(op.android) {
                    // TODO fix android input and ui scale (Widgets are too small)
                    targets.add(getAndroidTarget(op));
                }
//                if(op.iOS) {
//                    targets.add(getIOSTarget(op));
//                }
            }
        });
    }

    private static BuildMultiTarget getWindowTarget(BuildToolOptions op) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        WindowsMSVCTarget windowsTarget = new WindowsMSVCTarget();
        windowsTarget.isStatic = true;
        windowsTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui/");
        windowsTarget.cppInclude.add(libBuildCPPPath + "/**/imgui/*.cpp");
        multiTarget.add(windowsTarget);

        // Compile glue code and link
        WindowsMSVCTarget linkTarget = new WindowsMSVCTarget();
        linkTarget.addJNIHeaders();
        linkTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui/");
        linkTarget.linkerFlags.add(libBuildCPPPath + "/libs/windows/vc/imgui64_.lib");
        linkTarget.cppInclude.add(libBuildCPPPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getLinuxTarget(BuildToolOptions op) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        LinuxTarget linuxTarget = new LinuxTarget();
        linuxTarget.isStatic = true;
        linuxTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui/");
        linuxTarget.cppInclude.add(libBuildCPPPath + "/**/imgui/*.cpp");
        multiTarget.add(linuxTarget);

        // Compile glue code and link
        LinuxTarget linkTarget = new LinuxTarget();
        linkTarget.addJNIHeaders();
        linkTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui/");
        linkTarget.linkerFlags.add(libBuildCPPPath + "/libs/linux/libimgui64_.a");
        linkTarget.cppInclude.add(libBuildCPPPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getMacTarget(BuildToolOptions op, boolean isArm) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        MacTarget macTarget = new MacTarget(isArm);
        macTarget.isStatic = true;
        macTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui/");
        macTarget.cppInclude.add(libBuildCPPPath + "/**/imgui/*.cpp");
        multiTarget.add(macTarget);

        // Compile glue code and link
        MacTarget linkTarget = new MacTarget(isArm);
        linkTarget.addJNIHeaders();
        linkTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui/");
        if(isArm) {
            linkTarget.linkerFlags.add(libBuildCPPPath + "/libs/mac/arm/libimgui64_.a");
        }
        else {
            linkTarget.linkerFlags.add(libBuildCPPPath + "/libs/mac/libimgui64_.a");
        }
        linkTarget.cppInclude.add(libBuildCPPPath + "/src/jniglue/JNIGlue.cpp");
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getTeaVMTarget(BuildToolOptions op, IDLReader idlReader) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        // Make a static library
        EmscriptenTarget libTarget = new EmscriptenTarget(idlReader);
        libTarget.isStatic = true;
        libTarget.compileGlueCode = false;
        libTarget.headerDirs.add("-I" + libBuildCPPPath + "/src/imgui");
        libTarget.cppInclude.add(libBuildCPPPath + "/**/imgui/*.cpp");
        libTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
        libTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
        multiTarget.add(libTarget);

        // Compile glue code and link
        EmscriptenTarget linkTarget = new EmscriptenTarget(idlReader);
        linkTarget.headerDirs.add("-include" + libBuildCPPPath + "/src/imgui/ImGuiCustom.h");
        linkTarget.linkerFlags.add(libBuildCPPPath + "/libs/emscripten/imgui_.a");
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getAndroidTarget(BuildToolOptions op) {
        String libBuildCPPPath = op.getModuleBuildCPPPath();

        BuildMultiTarget multiTarget = new BuildMultiTarget();

        AndroidTarget androidTarget = new AndroidTarget();
        androidTarget.addJNIHeaders();
        androidTarget.headerDirs.add(libBuildCPPPath + "/src/imgui");
        androidTarget.cppInclude.add(libBuildCPPPath + "/**/imgui/*.cpp");
        androidTarget.cppFlags.add("-Wno-error=format-security");
        androidTarget.cppFlags.add("-DIMGUI_DISABLE_FILE_FUNCTIONS");
        androidTarget.cppFlags.add("-DIMGUI_DEFINE_MATH_OPERATORS");
        multiTarget.add(androidTarget);
        return multiTarget;
    }
}