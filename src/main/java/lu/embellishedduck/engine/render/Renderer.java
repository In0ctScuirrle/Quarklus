package lu.embellishedduck.engine.render;

import lu.embellishedduck.engine.render.window.Window;
import org.lwjgl.opengl.GL11;

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