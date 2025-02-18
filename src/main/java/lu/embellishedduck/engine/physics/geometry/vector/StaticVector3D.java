package lu.embellishedduck.engine.physics.geometry.vector;

/**
 * The {@code StaticVector3D} is an implementation of the {@code AbstractVector3D} interface and is use for fixed or static points in the world,
 * specifically for actors with a fixed or "static" position. This is useful for things that wouldn't move or be influenced by the actions of
 * a {@code LivingEntity}, but can still be broken by them. Thus, the particular implementation benefits from the simplicity of the {@code Record} class type
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 *
 * @param x
 * @param y
 * @param z
 */
public record StaticVector3D(double x, double y, double z) implements AbstractVector3D {

    //=========
    // GETTERS
    //=========
    @Override
    public double getX() {return this.x;}
    @Override
    public double getY() {return this.y;}
    @Override
    public double getZ() {return this.z;}

}//End of Record