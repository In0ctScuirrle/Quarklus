package lu.embellishedduck.engine.physics.geometry.vector;

/**
 * This interface serves as a contract for the {@code DynamicVector3D} and {@code StaticVector3D} classes, since they share
 * similar functions but have different employments.
 *
 * @since 1.0.0
 * @author Will Blanchard
 */
public interface AbstractVector3D {

    //=========
    // GETTERS
    //=========
    double getX();
    double getY();
    double getZ();

}//End of Interface