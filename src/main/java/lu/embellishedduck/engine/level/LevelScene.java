package lu.embellishedduck.engine.level;

import lu.embellishedduck.engine.Main;
import lu.embellishedduck.engine.graphics.render.scene.Scene;

public class LevelScene extends Scene {

    //=====================
    // DEFAULT CONSTRUCTOR
    //=====================
    public LevelScene() {

        System.out.println("Inside Level");
        Main.window.r = 1;
        Main.window.g = 1;
        Main.window.b = 1;

    }//End of Constructor


    @Override
    public void update(float deltaTime ) {



    }//End of Method

}//End of Class