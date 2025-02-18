package lu.embellishedduck.engine.physics.actor;

import lu.embellishedduck.engine.physics.geometry.vector.DynamicVector3D;

public class Player extends Actor {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    public static DynamicVector3D position;
    public static DynamicVector3D velocity;


    //=============
    // CONSTRUCTOR
    //=============
    public Player(double x, double y, double z) {

        super("player");
        position = new DynamicVector3D(x, y, z);

    }//End of Constructor


    //===============================
    // OVERRIDDEN METHOD FROM PARENT
    //===============================
    @Override
    public void update() {

        // Handle input here for now

    }

    //===============================
    // OVERRIDDEN METHOD FROM PARENT
    //===============================
    @Override
    public void render() {

    }
}//End of Class