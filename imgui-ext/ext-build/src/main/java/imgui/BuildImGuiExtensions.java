package imgui;

import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.LinuxTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BuildImGuiExtensions {

    public static void main(String[] args) throws Exception {
        build();
    }

    private static void build() throws IOException {
        String imguiPath = new File("./../../imgui").getCanonicalPath().replace("\\", "/");
        String extensionsPath = new File("./../../extensions").getCanonicalPath().replace("\\", "/");
        String idlPath = imguiPath + "/imgui-build/src/main/cpp/imgui.idl";
        IDLReader imguiIDLReader = IDLReader.readIDL(idlPath);
        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiPath, extensionsPath));
            targets.add(getEmscriptenBuildTarget(imguiPath, extensionsPath, idlPath));
//            targets.add(getAndroidBuildTarget());
        }
        if(BuildTarget.isUnix()) {
            targets.add(getLinuxBuildTarget(imguiPath, extensionsPath));
        }

        String libName = "imgui";
        String basePackage = "imgui";

        String imguiBasePath = imguiPath + "/imgui-base";
        String imguiBuildPath = imguiPath + "/imgui-build";
        String imguiCorePath = imguiPath + "/imgui-core";
        String imguiTeavmPath = imguiPath + "/imgui-teavm";

        String buildCPPPath = imguiBuildPath + "/build/c++";
        String cppSourceDir = imguiBuildPath + "/build/imgui";
        String baseJavaDir = imguiBasePath + "/src/main/java";
        String libsDir = buildCPPPath + "/libs/";
        String cppDestinationPath = buildCPPPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imgui";

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, buildCPPPath, libsDir, libName);
        JBuilder.build(buildConfig, targets);
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiPath, String extensionsPath) throws IOException {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        WindowsTarget glueTarget = new WindowsTarget();
        glueTarget.libDirSuffix += "ext/";
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui/");
        glueTarget.headerDirs.add("-I" + imguiCppPath + "/src/jniglue");
        glueTarget.linkerFlags.add(imguiCppPath + "/libs/windows/imgui64.a");
        glueTarget.cppInclude.add(imguiCppPath + "/src/jniglue/JNIGlue.cpp");

        {
            // ImLayout extension
            String imlayoutCPPPath = extensionsPath + "/imlayout/imlayout-build/build/c++";
            glueTarget.headerDirs.add("-I" + imlayoutCPPPath + "/src/imlayout/");
            glueTarget.headerDirs.add("-I" + imlayoutCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(imlayoutCPPPath + "/libs/windows/imlayout64.a");
            glueTarget.headerDirs.add("-include" + imlayoutCPPPath + "/src/jniglue/JNIGlue.h");
        }
        {
            // ImGuiColorTextEdit extension
            String textEditCPPPath = extensionsPath + "/ImGuiColorTextEdit/textedit-build/build/c++";
            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(textEditCPPPath + "/libs/windows/textedit64.a");
            glueTarget.headerDirs.add("-include" + textEditCPPPath + "/src/jniglue/JNIGlue.h");
        }
        {
            // imgui-node-editor extension
            String nodeeditorCPPPath = extensionsPath + "/imgui-node-editor/nodeeditor-build/build/c++";
            glueTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor/");
            glueTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(nodeeditorCPPPath + "/libs/windows/nodeeditor64.a");
            glueTarget.headerDirs.add("-include" + nodeeditorCPPPath + "/src/jniglue/JNIGlue.h");
        }

        multiTarget.add(glueTarget);
        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(String imguiPath, String extensionsPath, String imguiIDLReaderPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";
        IDLReader idlReaderCombined = IDLReader.readIDL(imguiIDLReaderPath);

        // Compile glue code and link to make js file
        EmscriptenTarget linkTarget = new EmscriptenTarget(idlReaderCombined);
        linkTarget.libDirSuffix += "ext/";
        linkTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        linkTarget.headerDirs.add("-include" + imguiCppPath + "/src/imgui/ImGuiCustom.h");
        linkTarget.linkerFlags.add(imguiCppPath + "/libs/emscripten/imgui.a");

        {
            // ImLayout extension
            String imlayoutCppPath = extensionsPath + "/imlayout/imlayout-build/build/c++";
            String imlayoutIdlPath = extensionsPath + "/imlayout/imlayout-build/src/main/cpp/imlayout.idl";
            IDLReader.addIDL(idlReaderCombined, imlayoutIdlPath);
            linkTarget.headerDirs.add("-I" + imlayoutCppPath + "/src/imlayout");
            linkTarget.headerDirs.add("-include" + imlayoutCppPath + "/src/imlayout/ImLayoutCustom.h");
            linkTarget.linkerFlags.add(imlayoutCppPath + "/libs/emscripten/imlayout.a");
        }
        {
            // ImGuiColorTextEdit extension
            String texteditCppPath = extensionsPath + "/ImGuiColorTextEdit/textedit-build/build/c++";
            String texteditIdlPath = extensionsPath + "/ImGuiColorTextEdit/textedit-build/src/main/cpp/ColorTextEdit.idl";
            IDLReader.addIDL(idlReaderCombined, texteditIdlPath);
            linkTarget.headerDirs.add("-I" + texteditCppPath + "/src/textedit");
            linkTarget.headerDirs.add("-include" + texteditCppPath + "/src/textedit/TextEditCustom.h");
            linkTarget.linkerFlags.add(texteditCppPath + "/libs/emscripten/textedit.a");
        }
        {
            // imgui-node-editor extension
            String nodeeditorCppPath = extensionsPath + "/imgui-node-editor/nodeeditor-build/build/c++";
            String nodeeditorIdlPath = extensionsPath + "/imgui-node-editor/nodeeditor-build/src/main/cpp/nodeeditor.idl";
            IDLReader.addIDL(idlReaderCombined, nodeeditorIdlPath);
            linkTarget.headerDirs.add("-I" + nodeeditorCppPath + "/src/nodeeditor");
            linkTarget.headerDirs.add("-include" + nodeeditorCppPath + "/src/nodeeditor/NodeEditorCustom.h");
            linkTarget.linkerFlags.add(nodeeditorCppPath + "/libs/emscripten/nodeeditor.a");
        }
        multiTarget.add(linkTarget);

        return multiTarget;
    }

    private static BuildMultiTarget getLinuxBuildTarget(String imguiPath, String extensionsPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        LinuxTarget glueTarget = new LinuxTarget();
        glueTarget.libDirSuffix += "ext/";
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui/");
        glueTarget.headerDirs.add("-I" + imguiCppPath + "/src/jniglue");
        glueTarget.linkerFlags.add(imguiCppPath + "/libs/linux/libimgui64.a");

        glueTarget.cppInclude.add(imguiCppPath + "/src/jniglue/JNIGlue.cpp");

        {
            // ImLayout extension
            String imlayoutCPPPath = extensionsPath + "/imlayout/imlayout-build/build/c++";
            glueTarget.headerDirs.add("-I" + imlayoutCPPPath + "/src/imlayout/");
            glueTarget.headerDirs.add("-I" + imlayoutCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(imlayoutCPPPath + "/libs/linux/libimlayout64.a");
            glueTarget.headerDirs.add("-include" + imlayoutCPPPath + "/src/jniglue/JNIGlue.h");
        }
        {
            // ImGuiColorTextEdit extension
            String textEditCPPPath = extensionsPath + "/ImGuiColorTextEdit/textedit-build/build/c++";
            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(textEditCPPPath + "/libs/linux/libtextedit64.a");
            glueTarget.headerDirs.add("-include" + textEditCPPPath + "/src/jniglue/JNIGlue.h");
        }
        {
            // imgui-node-editor extension
            String nodeeditorCPPPath = extensionsPath + "/imgui-node-editor/nodeeditor-build/build/c++";
            glueTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/nodeeditor/");
            glueTarget.headerDirs.add("-I" + nodeeditorCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(nodeeditorCPPPath + "/libs/linux/libnodeeditor64.a");
            glueTarget.headerDirs.add("-include" + nodeeditorCPPPath + "/src/jniglue/JNIGlue.h");
        }

        multiTarget.add(glueTarget);
        return multiTarget;
    }

}
