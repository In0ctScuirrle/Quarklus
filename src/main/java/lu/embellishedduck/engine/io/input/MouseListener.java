package lu.embellishedduck.engine.io.input;

import lombok.Getter;
import org.lwjgl.glfw.GLFW;

/**
 * An enumerated style singleton, it handles everything related to mouse input including the cursor position, mouse buttons which are pressed, and the scroll wheel. It can
 * also determine whether the player is executing a drag click.
 *
 * @author Will Blanchard
 *
 * @since 1.0.0
 */
@Getter
public enum MouseListener {

    //======================
    // INSTANCE VARIABLE(S)
    //======================
    INSTANCE;


    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private double scrollX;
    private double scrollY;

    private double xPosition;
    private double yPosition;
    private double lastX;
    private double lastY;

    private boolean isDragging;
    private boolean[] mouseButtonPressed = new boolean[3];


    //================
    // CONSTRUCTOR(S)
    //================
    MouseListener() {

        scrollX = 0.0;
        scrollY = 0.0;

        xPosition = 0.0;
        yPosition = 0.0;
        lastX = 0.0;
        lastY = 0.0;

    }//End of Constructor


    public static void mousePosCallback(long window, double xPos, double yPos) {

        INSTANCE.lastX = INSTANCE.xPosition;
        INSTANCE.lastY = INSTANCE.yPosition;

        INSTANCE.xPosition = xPos;
        INSTANCE.yPosition = yPos;

        INSTANCE.isDragging = INSTANCE.mouseButtonPressed[0] || INSTANCE.mouseButtonPressed[1] || INSTANCE.mouseButtonPressed[2];

    }//End of Method


    public static void mouseButtonCallback(long window, int button, int action, int mods) {

        if (action == GLFW.GLFW_PRESS) {

            if (button < INSTANCE.mouseButtonPressed.length) {INSTANCE.mouseButtonPressed[button] = true;}//Also handles the case for fancy gaming mice

        } else if (action == GLFW.GLFW_RELEASE) {

            if (button < INSTANCE.mouseButtonPressed.length) {

                INSTANCE.mouseButtonPressed[button] = false;
                INSTANCE.isDragging = false;//We know this because if the button was released it was no longer dragging

            }//End of If Statement

        }//End of If-Else-If Statement

    }//End of Method


    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {

        INSTANCE.scrollX = xOffset;
        INSTANCE.scrollY = yOffset;

    }//End of Method


    /**
     * This method resets all the variables at the end of a frame. This prevents all kinds of wierd bugs that I probably would've been highly frustrated about later on.
     * <p>Also sets the {@code lastX} and {@code lastY} to the current positions so they can be used in the next frame.</p>
     *
     * @param window The currently active GLFW window
     */
    public static void endFrame(long window) {

        INSTANCE.scrollX = 0.0;
        INSTANCE.scrollY = 0.0;

        INSTANCE.lastX = INSTANCE.xPosition;
        INSTANCE.lastY = INSTANCE.yPosition;

    }//End of Method


    /**
     * These methods give the amount of elapsed exposition in the current frame.
     */
    public static float getDeltaX() {return (float)(INSTANCE.lastX - INSTANCE.xPosition);}
    public static float getDeltaY() {return (float)(INSTANCE.lastY - INSTANCE.yPosition);}


    public static boolean mouseButtonDown(int button) {

        if (button < INSTANCE.mouseButtonPressed.length) {

            return INSTANCE.mouseButtonPressed[button];

        } else {return false;}//End of If-Else Statement

    }//End of Method

}//End of Class