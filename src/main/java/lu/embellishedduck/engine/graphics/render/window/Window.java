package lu.embellishedduck.engine.graphics.render.window;

import lombok.Getter;
import lu.embellishedduck.engine.core.SLF4JCallback;
import lu.embellishedduck.engine.graphics.texture.TextureHandler;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;
import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

@Getter
public class Window {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final long windowHandle;


    //=============
    // CONSTRUCTOR
    //=============
    public Window(int height, int width, String title) {

        // Give GLFW an error callback to use
        SLF4JCallback.setGLFWErrorCallback();

        // Initialize GLFW
        if (!glfwInit()) {

            throw new IllegalStateException("Unable to initialize GLFW");

        }//End of If Statement

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        // Create the window
        windowHandle = glfwCreateWindow(width, height, title, NULL, NULL);

        //Error Handling
        if (windowHandle == NULL) {

            throw new IllegalStateException("Unable to create the GLFW window");

        }//End of If Statement

        // Set window position to the center of the screen
        try (MemoryStack stack = MemoryStack.stackPush()) {

            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(windowHandle, pWidth, pHeight);

            // Get the current monitor
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            assert vidMode != null;
            glfwSetWindowPos(windowHandle, (vidMode.width() - pWidth.get(0)) / 2, (vidMode.height() - pHeight.get(0)) / 2);

        }//End of Try Statement

        // Make the window the current context
        glfwMakeContextCurrent(windowHandle);

        //Setting the GLFW swap interval
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(windowHandle);

        // Creating the GL capabilities
        GL.createCapabilities();

    }//End of Constructor


    //============================================================
    // METHOD TO DETERMINE WHETHER THE WINDOW SHOULD CLOSE OR NOT
    //============================================================
    public boolean shouldClose() {

        return glfwWindowShouldClose(windowHandle);

    }//End of Method


    //=============================
    // METHOD TO UPDATE THE WINDOW
    //=============================
    public void update() {

        glfwSwapBuffers(windowHandle);
        glfwPollEvents();

    }//End of Method


    //========================================================
    // METHOD TO CLEAN UP RESOURCES AFTER PROGRAM TERMINATION
    //========================================================
    public void cleanup() {

        // Release all textures from memory
        TextureHandler.INSTANCE.dispose();

        // Releasing leftover memory
        glfwFreeCallbacks(windowHandle);
        glfwDestroyWindow(windowHandle);
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();

    }//End of Method

}//End of Class