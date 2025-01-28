package lu.embellishedduck.engine.physics.geometry;

/**
 * This interface serves as a contract for the {@code DynamicVector3D} and {@code StaticVector3D} classes, since they share
 * similar functions but have different employments.
 *
 * @since 1.0.0
 * @author Will Blanchard
 */
public interface AbstractVector3D {

    double distanceFromPoint(AbstractVector3D pointA, AbstractVector3D pointB);

    //=========
    // GETTERS
    //=========
    double getX();
    double getY();
    double getZ();

}//End of Interface