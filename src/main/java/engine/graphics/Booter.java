package engine.graphics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Booter {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private static Window window;


    //===========================
    // METHOD TO LAUNCH THE GAME
    //===========================
    public void run() {

        log.info("Booting up Game");
        window  = new Window(800, 600, "Quarklus");
        loop();
        window.terminate();
        cleanUp();

    }//End of Method


    //==========================================================
    // METHOD WHICH LOOPS INDEFINITELY UNTIL THE GAME IS CLOSED
    //==========================================================
    public void loop() {

        //Validate the window
        if (window == null) {

            throw new IllegalStateException("Invalid window handle");

        }//End of If Statement

        while (!window.shouldClose()) {

            window.update();

        }//End of While Loop

    }//End of Method


    //===========================
    // METHOD TO CLEAN RESOURCES
    //===========================
    private void cleanUp() {

        log.info("Cleaning Up...");
        log.info("All Clean!");

    }//End of Method


}//End of Class