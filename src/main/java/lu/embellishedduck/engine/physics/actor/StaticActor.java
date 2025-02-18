package lu.embellishedduck.engine.physics.actor;

import lu.embellishedduck.engine.physics.geometry.vector.StaticVector3D;

/**
 * Can be used to represent virtually anything that doesn't move in the game world, can also be used for breakable objects
 * like trees, cobbles, some grass, etc.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public class StaticActor extends Actor {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private StaticVector3D position;


    //=============
    // CONSTRUCTOR
    //=============
    public StaticActor(String identifier, StaticVector3D position) {

        super(identifier);
        this.position = position;

    }//End of Constructor



    @Override
    public void update() {



    }//End of Method

    @Override
    public void render() {



    }//End of Method

}//End of Class