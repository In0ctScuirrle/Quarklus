package engine.io.input;

import lombok.Getter;
import lombok.Setter;
import org.lwjgl.glfw.GLFW;

@Getter
public enum Keybinding {

    UP("MoveForward", GLFW.GLFW_KEY_W, GLFW.GLFW_KEY_W, () -> System.out.println("Up!")),
    LEFT("MoveLeft", GLFW.GLFW_KEY_A, GLFW.GLFW_KEY_A, () -> System.out.println("Left!")),
    DOWN("MoveBackward", GLFW.GLFW_KEY_S, GLFW.GLFW_KEY_S, () -> System.out.println("Down!")),
    RIGHT("MoveRight", GLFW.GLFW_KEY_D, GLFW.GLFW_KEY_D, () -> System.out.println("Right!"));

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final String identifier;

    @Setter
    private int keyCode;
    private final int defaultKeyCode;

    @Setter
    private int keyModifiers;
    private int defaultKeyModifiers;

    private final Runnable action;


    //=============
    // CONSTRUCTOR
    //=============
    Keybinding(String identifier, int keyCode, int defaultKeyCode, Runnable action) {

        this.identifier = identifier;
        this.keyCode = keyCode;
        this.defaultKeyCode = defaultKeyCode;
        this.action = action;

    }//End of Constructor

    Keybinding(String identifier, int keyCode, int keyModifiers, int defaultKeyModifiers, Runnable action) {

        this.identifier = identifier;
        this.keyCode = keyCode;
        this.defaultKeyCode = keyCode;
        this.keyModifiers = keyModifiers;
        this.defaultKeyModifiers = defaultKeyModifiers;
        this.action = action;

    }//End of Constructor


    //===============================================================
    // METHOD TO DETERMINE WHETHER A KEYBINDING HAS MODIFIERS OR NOT
    //===============================================================
    public boolean hasModifiers() {

        return keyModifiers != 0;

    }//End of Method

}//End of Class