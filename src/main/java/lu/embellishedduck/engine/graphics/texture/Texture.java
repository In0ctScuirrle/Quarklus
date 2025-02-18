package lu.embellishedduck.engine.graphics.texture;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL12C.GL_TEXTURE_WRAP_R;
import static org.lwjgl.opengl.GL30C.glGenerateMipmap;
import static org.lwjgl.stb.STBImage.stbi_image_free;
import static org.lwjgl.stb.STBImage.stbi_load;

/**
 * Holder for texture atlas data, holds data for one image which contains multiple sub images.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
@Getter
@Slf4j
public class Texture {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final int identifier;
    private int width;
    private int height;


    //=============
    // CONSTRUCTOR
    //=============
    public Texture(String filePath) {

        ByteBuffer byteBuffer = loadTexture(filePath);

        // Generate texture ID
        this.identifier = glGenTextures();

        // Bind the texture
        glBindTexture(GL_TEXTURE_2D, identifier);

        // Upload the texture data
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, getWidth(), getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, byteBuffer);

        // Generate MipMap
        glGenerateMipmap(GL_TEXTURE_2D);

        // Set texture parameters
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_R, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        // Free the loaded image memory
        stbi_image_free(byteBuffer);

    }//End of Constructor


    /**
     * Loads a texture from a specified location into a usable byte buffer.
     *
     * @param filePath The string literal file path relative to Intellij.
     * @return A byte buffer containing the image data.
     */
    private ByteBuffer loadTexture(String filePath) {

        try(MemoryStack stack = MemoryStack.stackPush()) {

            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            ByteBuffer image = stbi_load(filePath, w, h, comp, 4);

            if (image == null) {

                log.error("Failed to load texture {}", STBImage.stbi_failure_reason());

            }//End of If Statement

            this.width = w.get();
            this.height = h.get();

            return image;

        }//End of Try Statement

    }//End of Method


    /**
     * Binds the texture to openGL
     */
    public void bind() {

        glBindTexture(GL_TEXTURE_2D, identifier);

    }//End of Method


    public float[] getTextureCoords(int x, int y, int spriteWidth, int spriteHeight) {

        float u = (float) x / width;
        float v = (float) y / height;
        float u2 = u + (float) spriteWidth / width;
        float v2 = v + (float) spriteHeight / height;

        return new float[]{u, v, u2, v2};

    }//End of Method

    /*
    Example of an implementation

    glBegin(GL_QUADS);
            glTexCoord2f(texCoords[0], texCoords[1]); glVertex2f(0, 0);
            glTexCoord2f(texCoords[2], texCoords[1]); glVertex2f(64, 0);
            glTexCoord2f(texCoords[2], texCoords[3]); glVertex2f(64, 64);
            glTexCoord2f(texCoords[0], texCoords[3]); glVertex2f(0, 64);
            glEnd();
     */

}//End of Class