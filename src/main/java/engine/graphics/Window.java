package engine.graphics;

import engine.io.output.SLF4JErrorCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private long windowHandle;


    //=============
    // CONSTRUCTOR
    //=============
    public Window(int width, int height, String title) {

        initialize(width, height, title);

    }//End of Constructor


    //==========================
    // WINDOW INITIALIZE METHOD
    //==========================
    private void initialize(int width, int height, String title) {

        GLFWErrorCallback.createPrint(System.err).set();
        glfwSetErrorCallback(new SLF4JErrorCallback());

        if (!glfwInit()) {

            throw new IllegalStateException("Unable to initialize GLFW");

        }//End of If Statement

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        //Create the window
        windowHandle = glfwCreateWindow(width, height, title, NULL, NULL);

        if (windowHandle == NULL) {

            throw new RuntimeException("Failed to create the GLFW window");

        }//End of If Statement

        /*
        This is where the key listeners will be added for the mouse and keyboard keys
         */

        try (MemoryStack stack = MemoryStack.stackPush()) {

            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(windowHandle, pWidth, pHeight);

            //Get the resolution of the primary monitor
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            assert vidMode != null;
            glfwSetWindowPos(windowHandle,
                    (vidMode.width() - pWidth.get()) / 2,
                    (vidMode.height() - pHeight.get()) / 2);

            glfwMakeContextCurrent(windowHandle);
            glfwSwapInterval(1);
            glfwShowWindow(windowHandle);

        }//End of Try Statement

        createCapabilities();

    }//End of Method


    //=========================
    // GAME-WIDE UPDATE METHOD
    //=========================
    public void update() {

        glfwPollEvents();
        glfwSwapBuffers(windowHandle);

    }//End of Method


    //============================================================
    // METHOD TO DETERMINE WHETHER THE WINDOW SHOULD CLOSE OR NOT
    //============================================================
    public boolean shouldClose() {

        return glfwWindowShouldClose(windowHandle);

    }//End of Method


    //================================
    // METHOD TO TERMINATE THE WINDOW
    //================================
    public void terminate() {

        glfwFreeCallbacks(windowHandle);
        glfwDestroyWindow(windowHandle);

        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }//End of Method

}//End of Class