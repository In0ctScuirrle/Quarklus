package lu.embellishedduck.engine.physics.actor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lu.embellishedduck.engine.graphics.texture.TextureRegion;

/**
 * Serves as the ultimate abstraction for anything interactable in the game world (besides the base world itself). Is the parent for a lot of other classes.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Actor {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final String identifier;

    private TextureRegion textureRegion;


    //=============
    // CONSTRUCTOR
    //=============
    public Actor(String identifier) {

        this.identifier = identifier;

    }//End of Constructor


    /**
     * Abstract update method where all actor updating logic will be executed.
     */
    public abstract void update();


    /**
     * Abstract render method which will handle the rendering of a specific actor instance.
     */
    public abstract void render();

}//End of Abstract Class