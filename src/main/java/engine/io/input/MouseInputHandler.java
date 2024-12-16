package engine.io.input;

import lombok.Getter;
import org.lwjgl.glfw.GLFW;

@Getter
public enum MouseInputHandler {

    //====================
    // INSTANCE VARIABLES
    //====================
    INSTANCE;


    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private double scrollX, scrollY;
    private double posX, posY, lastX, lastY;

    private boolean[] mouseButtons = new boolean[5];
    private boolean isDragging = false;


    //=============
    // CONSTRUCTOR
    //=============
    MouseInputHandler() {

        scrollX = 0.0;
        scrollY = 0.0;
        posX = 0.0;
        posY = 0.0;
        lastX = 0.0;
        lastY = 0.0;

    }//End of Constructor


    //==================================================
    // CALLBACK METHOD TO GET THE POSITION OF THE MOUSE
    //==================================================
    public static void cursorPositionCallback(long window, double x, double y) {

        INSTANCE.lastX = INSTANCE.posX;
        INSTANCE.lastY = INSTANCE.posY;
        INSTANCE.posX = x;
        INSTANCE.posY = y;
        INSTANCE.isDragging = INSTANCE.mouseButtons[0] || INSTANCE.mouseButtons[1] || INSTANCE.mouseButtons[2] || INSTANCE.mouseButtons[3] || INSTANCE.mouseButtons[4];

    }//End of Method


    //===================================
    // CALLBACK METHOD FOR MOUSE BUTTONS
    //===================================
    public static void mouseButtonCallback(long window, int button, int action, int mods) {

        if (action == GLFW.GLFW_PRESS) {

            //Handling mouse buttons which are not included in the program
            if (button < INSTANCE.mouseButtons.length) {

                INSTANCE.mouseButtons[button] = true;

            }//End of If Statement

        } else if (action == GLFW.GLFW_RELEASE) {

            if (button < INSTANCE.mouseButtons.length) {

                INSTANCE.mouseButtons[button] = false;
                INSTANCE.isDragging = false;

            }//End of If Statement

        }//End of If-Else-If Statement

    }//End of Method


    //============================================
    // CALLBACK METHOD FOR THE MOUSE SCROLL WHEEL
    //============================================
    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {

        INSTANCE.scrollX = xOffset;
        INSTANCE.scrollY = yOffset;

    }//End of Method


    //=============================================
    // METHOD TO END THE FRAME FOR MOUSE SCROLLING
    //=============================================
    public static void endFrame() {

        INSTANCE.scrollX = 0.0;
        INSTANCE.scrollY = 0.0;
        INSTANCE.lastX = INSTANCE.posX;
        INSTANCE.lastY = INSTANCE.posY;

    }//End of Method


    //============================================================
    // METHOD TO DETERMINE IF THE MOUSE BUTTON IS BEING HELD DOWN
    //============================================================
    public static boolean mouseButtonDown(int button) {

        if (button < INSTANCE.mouseButtons.length) {

            return INSTANCE.mouseButtons[button];

        } else {

            return false;

        }//End of If-Else Statement

    }//End of Method

}//End of Class