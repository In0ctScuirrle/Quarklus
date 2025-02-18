package lu.embellishedduck.engine.core;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code SLF4JCallback} class is our method of utilizing SLF4J as an error callback for GLFW. This is done
 * to unify all logging under one framework rather than using two or three different ones just for different aspects
 * of the engine.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public class SLF4JCallback {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private static final Logger logger = LoggerFactory.getLogger(SLF4JCallback.class);


    //====================================================
    // METHOD TO SET SLF4J AS THE ERROR CALLBACK FOR GLFW
    //====================================================
    public static void setGLFWErrorCallback() {

        GLFWErrorCallback.create((error, description) -> {

           logger.error("GLFW error [{}]: {}", error, description);

        }).set();

    }//End of Method

}//End of Class