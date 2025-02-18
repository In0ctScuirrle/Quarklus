package lu.embellishedduck.engine.io.input;

import org.lwjgl.glfw.GLFW;

/**
 * An enumerated style singleton which handles keyboard input for the program, it's literally that simple.
 *
 * @author Will Blanchard
 *
 * @since 1.0.0
 */
public enum KeyListener {

    //======================
    // INSTANCE VARIABLE(S)
    //======================
    INSTANCE;


    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private boolean[] keyPressed = new boolean[350];


    public static void keyCallback(long window, int key, int scancode, int action, int mods) {

        if (action == GLFW.GLFW_PRESS) {

            INSTANCE.keyPressed[key] = true;

        } else if (action == GLFW.GLFW_RELEASE) {

            INSTANCE.keyPressed[key] = false;

        }//End of If-Else-If Statement

    }//End of Method


    /**
     * This has no error handling because if the player passes in some junk then it might be something wrong with the program. Primarily thanks to the large scope of
     * keys which is covered by the keyPressed array. If junk is passed in then it will chuck an ArrayOutOfBounds exception.
     *
     * @param key A key code
     * @return If the key is pressed
     */
    public static boolean isKeyPressed(int key) {return INSTANCE.keyPressed[key];}

}//End of Class