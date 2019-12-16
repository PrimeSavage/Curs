package sample.classes;

import java.util.Random;

/**
 * Class Utils
 */
public class Utils {
    /**
     * Variable random
     */
    private static Random random = new Random();

    /**
     * Get random number
     * @param size size
     * @return random number
     */
    public static int getRandomInteger(final int size) {
        return random.nextInt(size + 1);
    }

    /**
     * Get random number
     * @param left left limit
     * @param right right limit
     * @return random number
     */
    public static int getRandomInteger(final int left, final int right) {
        return left + random.nextInt(right - left + 1);
    }
}
