package lu.embellishedduck.engine.graphics.render.window;

import lombok.Getter;
import lu.embellishedduck.engine.Main;
import lu.embellishedduck.engine.graphics.render.scene.Scene;
import lu.embellishedduck.engine.io.input.KeyListener;
import lu.embellishedduck.engine.io.input.MouseListener;
import lu.embellishedduck.engine.level.LevelEditorScene;
import lu.embellishedduck.engine.level.LevelScene;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;
import java.util.Objects;

import static lu.embellishedduck.engine.io.input.KeyListener.isKeyPressed;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.glClear;
import static org.lwjgl.opengl.GL11C.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;

@Getter
public class Window {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final long windowHandle;

    private static Scene currentScene;

    public float r, g, b, a;


    //=============
    // CONSTRUCTOR
    //=============
    public Window(int height, int width, String title) {

        r = 1;
        g = 1;
        b = 1;
        a = 1;

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

        //Setup Input Callbacks
        glfwSetCursorPosCallback(windowHandle, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(windowHandle, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(windowHandle, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(windowHandle, KeyListener::keyCallback);

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

        //Enabling V-Sync (This could be determined by a configuration setting later down the line)
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(windowHandle);

        // Creating the GL capabilities
        GL.createCapabilities();

        changeScene(0);

    }//End of Constructor


    public static void changeScene(int newScene) {

        switch (newScene) {

            case 0:
                currentScene = new LevelEditorScene();
                //currentScene.init()
                break;

            case 1:
                currentScene = new LevelScene();
                //currentScene.init()
                break;

            default:
                assert false : "Unknown scene type: '" + newScene + "'";
                break;

        }//End of Switch-Case Statement

    }//End of Method


    public boolean shouldClose() {

        return glfwWindowShouldClose(windowHandle);

    }//End of Method


    public void update() {

        //Poll Events
        glfwPollEvents();

        glClearColor(r, g, b, a);
        glClear(GL11.GL_COLOR_BUFFER_BIT);

        if (Main.deltaTime >= 0.0f) {

            currentScene.update(Main.deltaTime);

        }//End of If Statement

        //Swap Buffers
        glfwSwapBuffers(windowHandle);

    }//End of Method


    public void cleanup() {

        // Release all textures from memory
        //TextureHandler.INSTANCE.dispose();

        // Releasing leftover memory
        glfwFreeCallbacks(windowHandle);
        glfwDestroyWindow(windowHandle);
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();

    }//End of Method


    /**
     * The {@code SLF4JCallback} class is our method of utilizing SLF4J as an error callback for GLFW. This is done
     * to unify all logging under one framework rather than using two or three different ones just for different aspects
     * of the engine.
     *
     * @since 1.0.0
     *
     * @author Will Blanchard
     */
    public static class SLF4JCallback {

        //=======================
        // INSTANTIATE VARIABLES
        //=======================
        private static final Logger logger = LoggerFactory.getLogger(SLF4JCallback.class);


        public static void setGLFWErrorCallback() {

            GLFWErrorCallback.create((error, description) -> {

                logger.error("GLFW error [{}]: {}", error, description);

            }).set();

        }//End of Method

    }//End of Nested Class

}//End of Class