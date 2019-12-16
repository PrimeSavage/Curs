package sample.classes;

/**
 * Class ClockGenerator
 */
public class ClockGenerator {
    /**
     * Variable time
     */
    private static int time;

    /**
     * Increase in time by tact
     * @param tact Increase in time
     */
    public static void incTime(final int tact) {
        time += tact;
    }

    /**
     * Increase in time by 1
     */

    public static void incTime() {
        time++;
    }

    /**
     * Get time
     * @return time
     */
    public static int getTime() {
        return time;
    }
}
