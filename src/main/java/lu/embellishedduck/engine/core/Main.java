package lu.embellishedduck.engine.core;

import lombok.extern.java.Log;
import lu.embellishedduck.engine.graphics.render.Renderer;
import lu.embellishedduck.engine.graphics.render.window.Window;
import lu.embellishedduck.engine.graphics.texture.TextureHandler;

/**
 * The {@code Main} class contains the logic to start the program, it's literally that simple.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
@Log
public class Main {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private Window window;
    private Renderer renderer;


    //=======================================
    // METHOD TO RUN BUT NOT LAUNCH THE GAME
    //=======================================
    public void run() {

        log.info("Starting EMBELLISHED DUCK ENGINE!");
        log.info("This engine is running on " + System.getProperty("os.name"));
        log.info("Powered by Java " + Runtime.version());
        log.info("Hello from LWJGL " + org.lwjgl.Version.getVersion());

        window = new Window(600, 800, "Quarklus");
        renderer = new Renderer(window);

        while(!window.shouldClose()) {

            renderer.render();
            window.update();

        }//End of While Loop

        window.cleanup();

    }//End of Method


    //=============
    // MAIN METHOD
    //=============
    public static void main(String[] args) {

        new Main().run();

    }//End of Main Method

}//End of Class