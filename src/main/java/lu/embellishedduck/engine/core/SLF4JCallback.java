package lu.embellishedduck.engine.core;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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