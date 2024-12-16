package engine.io.input;

import lombok.Getter;
import lombok.Setter;
import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;

public enum KeyboardInputHandler {

    //====================
    // INSTANCE VARIABLES
    //====================
    INSTANCE;


    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    @Getter
    private static boolean shiftPressed = false;
    @Getter
    private static boolean altPressed = false;
    @Getter
    private static boolean ctrlPressed = false;
    @Getter
    private static boolean capsLockPressed = false;
    @Getter
    private static boolean superPressed = false;
    @Getter
    private static boolean numLockPressed = false;


    //============================================
    // METHOD TO GENERATE CALLBACKS FOR KEY INPUT
    //============================================
    public static void keyCallback(long window, int key, int scancode, int action, int mods) {

        for (Keybinding keybinding : Keybinding.values()) {

            if (key == keybinding.getKeyCode() && validateModifiers(keybinding) && action == GLFW.GLFW_PRESS) {

                keybinding.getAction().run();

            }//End of If Statement

        }//End of For Each Loop

        //Update modifier states
        shiftPressed = (mods & GLFW.GLFW_MOD_SHIFT) != 0;
        ctrlPressed = (mods & GLFW.GLFW_MOD_CONTROL) != 0;
        altPressed = (mods & GLFW.GLFW_MOD_ALT) != 0;
        superPressed = (mods & GLFW.GLFW_MOD_SUPER) != 0;
        capsLockPressed = (mods & GLFW.GLFW_MOD_CAPS_LOCK) != 0;
        numLockPressed = (mods & GLFW.GLFW_MOD_NUM_LOCK) != 0;

    }//End of Method


    //=========================================
    // HELPER METHOD TO VALIDATE KEY MODIFIERS
    //=========================================
    private static boolean validateModifiers(Keybinding keybinding) {

        return (!keybinding.hasModifiers() ||
                ((keybinding.getKeyModifiers() & GLFW.GLFW_MOD_SHIFT) == 0 || KeyboardInputHandler.isShiftPressed()) &&
                        ((keybinding.getKeyModifiers() & GLFW_MOD_ALT) == 0 || KeyboardInputHandler.isAltPressed()) &&
                        ((keybinding.getKeyModifiers() & GLFW_MOD_CONTROL) == 0 || KeyboardInputHandler.isCtrlPressed()) &&
                        ((keybinding.getKeyModifiers() & GLFW_MOD_CAPS_LOCK) == 0 || KeyboardInputHandler.isCapsLockPressed()) &&
                        ((keybinding.getKeyModifiers() & GLFW_MOD_SUPER) == 0 || KeyboardInputHandler.isSuperPressed()) &&
                        (keybinding.getKeyModifiers() & GLFW_MOD_NUM_LOCK) == 0 || KeyboardInputHandler.isNumLockPressed());

    }//End of Helper Method

}//End of Class