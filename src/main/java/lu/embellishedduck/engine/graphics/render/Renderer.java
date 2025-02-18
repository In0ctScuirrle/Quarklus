package lu.embellishedduck.engine.graphics.render;

import lu.embellishedduck.engine.graphics.render.window.Window;
import org.lwjgl.opengl.GL11;

/**
 * This class is the ultimate destination for all renderer's and their individual render methods. It's done this
 * way to make management of different renderers simple. All of them can be turned on or off in the hard code like a switch.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public class Renderer {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private Window window;


    //=============
    // CONSTRUCTOR
    //=============
    public Renderer(Window window) {

        this.window = window;
        init();

    }//End of Constructor


    //===================================
    // METHOD TO INITIALIZE THE RENDERER
    //===================================
    public void init() {

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

    }//End of Method


    //============================================================
    // ULTIMATE RENDER METHOD WHICH CALLS ALL RENDERER'S METHODS!
    //============================================================
    public void render() {

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

    }//End of Method

}//End of Class