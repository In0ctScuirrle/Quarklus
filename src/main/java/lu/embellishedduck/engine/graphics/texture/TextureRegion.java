package lu.embellishedduck.engine.graphics.texture;

import lombok.Getter;

/**
 * Holds image data from a specific region of an atlas texture as if it was its own texture.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
@Getter
public class TextureRegion {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final Texture texture;

    private final float[] textureCoords;


    //=============
    // CONSTRUCTOR
    //=============
    public TextureRegion(Texture texture, float x, float y, float width, float height) {

        this.texture = texture;
        this.textureCoords = texture.getTextureCoords((int) x, (int) y, (int) width, (int) height);

    }//End of Constructor

}//End of Class