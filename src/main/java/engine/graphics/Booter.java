package engine.graphics;

import lombok.extern.slf4j.Slf4j;

import static engine.io.both.KeybindingManager.loadKeybindings;

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
        loadResources();
        window  = new Window(800, 600, "Quarklus");
        loop();
        window.terminate();
        cleanUp();

    }//End of Method


    //====================================
    // METHOD TO LOAD RESOURCES ON LAUNCH
    //====================================
    private void loadResources() {

        log.info("Loading resources...");

        loadKeybindings();

        log.info("Resources ready to go!");

    }//End of Method


    //==========================================================
    // METHOD WHICH LOOPS INDEFINITELY UNTIL THE GAME IS CLOSED
    //==========================================================
    private void loop() {

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