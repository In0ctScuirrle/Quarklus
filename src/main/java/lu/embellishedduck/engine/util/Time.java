package lu.embellishedduck.engine.util;

/**
 * Really simple class used exclusively for the Delta Time variable.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 *
 */
public class Time {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    public static float timeStarted = System.nanoTime();


    /**
     * Calculates the time since the program has started and then converts the difference from nanoseconds to seconds
     *
     * @return The time in seconds
     */
    public static float getTime() {return (float) ((System.nanoTime() - timeStarted) * 1e-9);}

}//End of Class