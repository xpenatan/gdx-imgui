package imgui.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.github.xpenatan.webgpu.WGPUTextureView;
import com.monstrous.gdx.webgpu.graphics.WgShaderProgram;
import com.monstrous.gdx.webgpu.graphics.WgTexture;
import imgui.ImDrawData;
import imgui.ImFontAtlas;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.ImGuiImpl;
import imgui.idl.helper.IDLByteArray;
import imgui.idl.helper.IDLIntArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author xpenatan
 */
public class ImGuiGdxWGPUImpl implements ImGuiImpl {

    private WgShaderProgram imguiShader;

    private int g_FontTexture = 0;

    public ImGuiGdxWGPUImpl() {


        imguiShader = new WgShaderProgram("imgui", shader_wgsl, "");

        System.out.println();

    }

    @Override
    public void newFrame() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        int backBufferWidth = Gdx.graphics.getBackBufferWidth();
        int backBufferHeight = Gdx.graphics.getBackBufferHeight();

        if(g_FontTexture == 0) {
            prepareFont();
        }

        ImGui.UpdateDisplayAndInputAndFrame(deltaTime, width, height, backBufferWidth, backBufferHeight);
    }

    @Override
    public void render(ImDrawData drawData) {
    }

    @Override
    public void dispose() {
        imguiShader.dispose();
    }

    private void prepareFont() {
        IDLIntArray width = new IDLIntArray(1);
        IDLIntArray height = new IDLIntArray(1);
        IDLByteArray bytesArray = new IDLByteArray(1);

        ImGuiIO io = ImGui.GetIO();
        ImFontAtlas fonts = io.get_Fonts();
        fonts.GetTexDataAsRGBA32(bytesArray, width, height);
        int widthValue = width.getValue(0);
        int heightValue = height.getValue(0);

        int size = bytesArray.getSize();
        ByteBuffer buffer = ByteBuffer.allocateDirect(size);
        buffer.order(ByteOrder.BIG_ENDIAN);
        for(int i = 0; i < size; i++) {
            buffer.put(i, bytesArray.getValue(i));
        }
        buffer.position(0);
        buffer.limit(size);

        Pixmap pixmap = new Pixmap(widthValue, heightValue, Pixmap.Format.RGBA8888);
        pixmap.setPixels(buffer);
        WgTexture texture = new WgTexture(pixmap);
        pixmap.dispose();

        WGPUTextureView textureView = texture.getTextureView();
        g_FontTexture = (int)textureView.native_address;
        io.SetFontTexID(g_FontTexture);
    }

    public String shader_wgsl =
            "struct VertexOutput {\n" +
            "    @builtin(position) position: vec4<f32>,\n" +
            "    @location(0) color: vec4<f32>,\n" +
            "    @location(1) uv: vec2<f32>,\n" +
            "};\n" +
            "struct VertexInput {\n" +
            "    @location(0) position: vec2<f32>,\n" +
            "    @location(1) uv: vec2<f32>,\n" +
            "    @location(2) color: vec4<f32>,\n" +
            "};\n" +
            "struct Uniforms {\n" +
            "    mvp: mat4x4<f32>,\n" +
            "    gamma: f32,\n" +
            "};\n" +
            "@group(0) @binding(0) var<uniform> uniforms: Uniforms;\n" +
            "@group(0) @binding(1) var s: sampler;\n" +
            "@group(1) @binding(0) var t: texture_2d<f32>;\n" +
            "@fragment\n" +
            "fn fs_main(in: VertexOutput) -> @location(0) vec4<f32> {\n" +
            "    let color = in.color * textureSample(t, s, in.uv);\n" +
            "    let corrected_color = pow(color.rgb, vec3<f32>(uniforms.gamma));\n" +
            "    return vec4<f32>(corrected_color, color.a);\n" +
            "}\n" +
            "@vertex\n" +
            "fn vs_main(in: VertexInput) -> VertexOutput {\n" +
            "    var out: VertexOutput;\n" +
            "    out.position = uniforms.mvp * vec4<f32>(in.position, 0.0, 1.0);\n" +
            "    out.color = in.color;\n" +
            "    out.uv = in.uv;\n" +
            "    return out;\n" +
            "}\n";
}