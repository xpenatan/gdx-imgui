# jDear-imgui

jDear-imgui is small pure java binding for C++ [dear-imgui](https://github.com/ocornut/imgui). No Kotlin ! <br>
It's meant to be small and close 1-1 to C++. 

For rendering it use libgdx. Your free to use any other rendering frameworks. DrawData object gives you all the vertices/indexes you need to render it (Java side). 

Try out gdx-imgui-demo and see it working.


**Usage:** <br>
Use the following classes For methods that requires checking UI state: <br>
**ImGuiBoolean**, **ImGuiInt**; **ImGuiDouble**; **ImGuiFloat**; 

## Build
### Gradle

```groovy
// TODO

```

### Eclipse

To build with eclipse you need:<br>
1: Configure [MinGW](https://github.com/libgdx/libgdx/wiki/jnigen) <br>
2: Import "jDear-imgui" project <br>
3: Download imgui sources C++ files and put them in "jDear-imgui/jni/src/" <br>
4: Run "Build.java" class in "com.xpenatan.imgui.generate" package <br>

The compiled native jar will be at "Dear-imgui\libs" 

Note: You will also need "gdx-jnigen" project from libgdx souce (or import as a jar lib). The project will give a error at first import because native lib dont exist (remove and readd after its generated).

### Screenshot of how it will looks when you build it
<p align="center"><img src="https://i.imgur.com/dSTEWl0.png"/></p>

To run demo you need to have the source project sources: "gdx" and "gdx-backend-lwjgl" (or import as jar lib)



## Screenshot
<p align="center"><img src="https://i.imgur.com/ekZu3lS.png"/></p>