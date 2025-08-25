package imgui.gdx;

import com.monstrous.gdx.webgpu.graphics.WgShaderProgram;
import imgui.ImDrawData;
import imgui.ImGuiImpl;

/**
 * @author xpenatan
 */
public class ImGuiGdxWGPUImpl implements ImGuiImpl {

    WgShaderProgram imguiShader;

    public ImGuiGdxWGPUImpl() {


        imguiShader = new WgShaderProgram("imgui", shader_wgsl, "");

        System.out.println();

    }

    @Override
    public void newFrame() {
    }

    @Override
    public void render(ImDrawData drawData) {
    }

    @Override
    public void dispose() {
        imguiShader.dispose();
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