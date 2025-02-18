package lu.embellishedduck.engine;

import lombok.extern.java.Log;
import lu.embellishedduck.engine.graphics.render.window.Window;
import lu.embellishedduck.engine.util.Time;

/**
 * The {@code Main} class contains the code to start the program, it's literally that simple.
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
    public static float beginTime = Time.getTime();
    public static float endTime;
    public static float deltaTime = -1.0f;

    public static Window window;

    /**
     * Holds the main loop for the game, anything that isn't managed by the renderer or updater, will have to be manually added here.
     */
    public void run() {

        log.info("Starting EMBELLISHED DUCK ENGINE!");
        log.info("This engine is running on " + System.getProperty("os.name"));
        log.info("Powered by Java " + Runtime.version());
        log.info("Hello from LWJGL " + org.lwjgl.Version.getVersion());

        window = new Window(600, 800, "Quarklus");

        log.info("Quarklus Launched Successfully!");

        while (!window.shouldClose()) {

            window.update();

            endTime = Time.getTime();
            deltaTime = endTime - beginTime;
            beginTime = endTime;//This is placed at the end to detect lag spikes and whatnot

        }//End of While Loop

        log.info("Stopping EMBELLISHED DUCK ENGINE");
        window.cleanup();
        log.info("EMBELLISHED DUCK ENGINE has stopped!");

    }//End of Method


    //=============
    // MAIN METHOD
    //=============
    public static void main(String[] args) {

        new Main().run();

    }//End of Main Method

}//End of Class