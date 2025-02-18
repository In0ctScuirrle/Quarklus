package lu.embellishedduck.engine.graphics.render.scene;

/**
 * Holds game objects, physics handles, render, etc. Also defines a couple of methods that will be used by the various implementations of this class.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public abstract class Scene {

    //=====================
    // DEFAULT CONSTRUCTOR
    //=====================
    public Scene() {}


    public abstract void update(float deltaTime );

}//End of Abstract Class