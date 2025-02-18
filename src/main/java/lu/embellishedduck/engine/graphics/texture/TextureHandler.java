package lu.embellishedduck.engine.graphics.texture;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11C.glDeleteTextures;

/**
 * Enum style singleton which handles the loading, unloading, and fetching the texture region. This increases the efficiency at which the program can operate because
 * it only ever loads the textures once, and then they're readily available for the program to use.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public enum TextureHandler {

    //====================
    // INSTANCE VARIABLES
    //====================
    INSTANCE;


    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final Map<String, Texture> textures = new HashMap<>();


    /**
     * Loads a texture from a specified file path
     *
     * @param fileName String literal of the relative file path in Intellij
     * @return The loaded texture
     */
    public Texture loadTexture(String fileName) {

        if (!textures.containsKey(fileName)) {

            textures.put(fileName, new Texture(fileName));

        }//End of If Statement

        return textures.get(fileName);

    }//End of Method


    /**
     * Retrieves the specific region of a specified texture.
     *
     * @param fileName The String literal of the relative file path in Intellij
     * @param x The top left x coordinate of the sprite in the texture atlas
     * @param y The top left y coordinate of the sprite in the texture atlas
     * @param width Width of the sprite's texture
     * @param height Height of the sprite's texture
     * @return A texture region of the atlas texture
     */
    public TextureRegion getTextureRegion(String fileName, float x, float y, float width, float height) {

        return new TextureRegion(loadTexture(fileName), x, y, width, height);

    }//End of Method


    /**
     * Disposes of all textures once the program is closed.
     */
    public void dispose() {

        for (Texture texture : textures.values()) {

            glDeleteTextures(texture.getIdentifier());

        }//End of For-Each Loop

    }//End of Method

}//End of Class