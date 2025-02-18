package lu.embellishedduck.engine.physics.geometry.vector;

import lombok.Getter;
import lombok.Setter;

/**
 * The class {@code DynamicVector3D} is an implementation of the {@code AbstractVector3D} interface and is used for moving or
 * "dynamic" points in the world. More specifically with {@code LivingEntity} actors and other things that can move or be influenced
 * by the environment or other actors.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
@Getter
@Setter
public class DynamicVector3D implements AbstractVector3D {

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
        this.z = z;

    }//End of Constructor

}//End of Class