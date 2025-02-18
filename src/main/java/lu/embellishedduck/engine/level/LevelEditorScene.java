package lu.embellishedduck.engine.level;

import lu.embellishedduck.engine.Main;
import lu.embellishedduck.engine.graphics.render.scene.Scene;
import lu.embellishedduck.engine.graphics.render.window.Window;

import java.awt.event.KeyEvent;

import static lu.embellishedduck.engine.io.input.KeyListener.isKeyPressed;

/**
 * Implementation of scene which allows us to edit the current level of the world. Will allow us to place things like objects and whatnot inside the level.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public class LevelEditorScene extends Scene {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private float timeToChange = 2.0f;

    private boolean changingScene = false;


    //=====================
    // DEFAULT CONSTRUCTOR
    //=====================
    public LevelEditorScene() {System.out.println("Inside Level Editor");}


    @Override
    public void update(float deltaTime ) {

        System.out.println("" + (1.0f / deltaTime) + " FPS");

        if (!changingScene && isKeyPressed(KeyEvent.VK_SPACE)) {changingScene = true;}

        if (changingScene && timeToChange > 0.0f) {

             timeToChange -= deltaTime;
            Main.window.r -= deltaTime * 5.0f;
            Main.window.g -= deltaTime * 5.0f;
            Main.window.b -= deltaTime * 5.0f;

        } else if (changingScene) {Window.changeScene(1);}//End of If-Else-If Statement

    }//End of Method

}//End of Class