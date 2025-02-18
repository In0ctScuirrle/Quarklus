package lu.embellishedduck.engine.physics.actor;

import lombok.Getter;
import lombok.Setter;
import lu.embellishedduck.engine.physics.geometry.vector.DynamicVector3D;
import lu.embellishedduck.engine.physics.geometry.vector.StaticVector3D;

/**
 * The {@code HitBox} class is used to define a collision zone for actors, it contains two types of position vectors, relative and literal.
 * The relative position is a fixed point relative to the origin point of the hit box, it is used to determine the size of the hit box which
 * may not necessarily be equal to the size of the actor's sprite. The origin point of the hit box is always the bottom left position of the box
 * and these vector variables are final because they do not change.
 *
 * <p>On the other hand the literal position vectors are used to determine where in the world the hit box's associated bounds are. This is updated when or if
 * the actor is moved, therefore it is not required that these vectors be final. Additionally, they are never given a hardcoded value, this is because when the player
 * saves the game it saves the positions of all actors within render distance. It should be noted that this property also makes them semi-volatile.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
@Getter
@Setter
public abstract class HitBox {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private double width;
    private double height;
    private double area = width * height;

    private DynamicVector3D literalTopLeft;
    private DynamicVector3D literalTopRight;
    private DynamicVector3D literalBottomLeft;
    private DynamicVector3D literalBottomRight;

    private final StaticVector3D relativeTopLeft;
    private final StaticVector3D relativeTopRight;
    private final StaticVector3D relativeBottomRight;
    private final StaticVector3D originPosition = new StaticVector3D(0, 0, 0);// Also known as relativeBottomLeft


    //=============
    // CONSTRUCTOR
    //=============
    public HitBox(StaticVector3D relativeTopLeft, StaticVector3D relativeTopRight, StaticVector3D relativeBottomRight) {

        this.relativeTopLeft = relativeTopLeft;
        this.relativeTopRight = relativeTopRight;
        this.relativeBottomRight = relativeBottomRight;

    }//End of Constructor


    //==========================================================================
    // METHOD TO DETERMINE WHETHER THIS HIT BOX IS INTERSECTING ANOTHER HIT BOX
    //==========================================================================
    public boolean intersects(HitBox hitBox) {

        return true;

    }//End of Method

    //I need to consult with the maths professor on whether I need to calculate the magnitude (or absolute value) and then subtract or if my current way is correct.
    //It's probably the other way.

}//End of Abstract Class