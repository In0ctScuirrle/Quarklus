package lu.embellishedduck.engine.physics.geometry;

/**
 * The class {@code DynamicVector3D} is an implementation of the {@code AbstractVector3D} interface and is used for moving or
 * "dynamic" points in the world. More specifically with {@code LivingEntity} actors and other things that can move or be influenced
 * by the environment or other actors.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public class DynamicVector3D {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private double x = 0;
    private double y = 0;
    private double z = 0;


    //=============
    // CONSTRUCTOR
    //=============
    public DynamicVector3D(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = y;

    }//End of Constructor


    //==============================
    // METHOD TO TRANSLATE A VECTOR
    //==============================
    public static DynamicVector3D translate(DynamicVector3D initialPosition, DynamicVector3D velocityVector) {

        return new DynamicVector3D(initialPosition.x + velocityVector.x, initialPosition.y + velocityVector.y, initialPosition.z + velocityVector.z);

    }//End of Method


    //===============================================
    // METHOD TO CALCULATE THE NORMAL OF THIS VECTOR
    //===============================================
    public static DynamicVector3D normalize(DynamicVector3D positionVector, DynamicVector3D pointVector) {

        double normalizedX = (positionVector.y * pointVector.z) - (positionVector.z * pointVector.y);
        double normalizedY = (positionVector.z * pointVector.x) - (positionVector.x * pointVector.z);
        double normalizedZ = (positionVector.x * pointVector.y) - (positionVector.y * pointVector.x);

        return new DynamicVector3D(normalizedX, normalizedY, normalizedZ);

    }//End of Method

}//End of Class