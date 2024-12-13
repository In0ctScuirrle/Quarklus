package engine.io.output;

import lombok.extern.slf4j.Slf4j;
import org.lwjgl.glfw.GLFWErrorCallback;

@Slf4j
public class SLF4JErrorCallback extends GLFWErrorCallback {

    //===============================
    // METHOD TO INVOKE THE CALLBACK
    //===============================
    @Override
    public void invoke(int error, long description) {

        log.error("GLFW error [{}]: {}", error, description);

    }//End of Method

}//End of Class