package aslib.parse;

/**
 * <p>Handles various types of array conversions between primitive and wrapper
 * types.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class PrimitiveWrapperArrayParser {

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static boolean[] toPrimitive(Boolean... array) {
        boolean[] result = new boolean[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static byte[] toPrimitive(Byte... array) {
        byte[] result = new byte[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static char[] toPrimitive(Character... array) {
        char[] result = new char[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static double[] toPrimitive(Double... array) {
        double[] result = new double[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static float[] toPrimitive(Float... array) {
        float[] result = new float[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static int[] toPrimitive(Integer... array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static long[] toPrimitive(Long... array) {
        long[] result = new long[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a primitive type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of primitive type with the same values.
     */
    public static short[] toPrimitive(Short... array) {
        short[] result = new short[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }


    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Boolean[] toWrapper(boolean... array) {
        Boolean[] result = new Boolean[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Byte[] toWrapper(byte... array) {
        Byte[] result = new Byte[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Character[] toWrapper(char... array) {
        Character[] result = new Character[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Double[] toWrapper(double... array) {
        Double[] result = new Double[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Float[] toWrapper(float... array) {
        Float[] result = new Float[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Integer[] toWrapper(int... array) {
        Integer[] result = new Integer[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Long[] toWrapper(long... array) {
        Long[] result = new Long[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }

    /**
     * <p>Converts the given array to a wrapper type array.</p>
     *
     * @param array Array to be converted. Not null.
     *
     * @return An array of wrapper type with the same values.
     */
    public static Short[] toWrapper(short... array) {
        Short[] result = new Short[array.length];

        for (int i = 0; i < array.length; i++) result[i] = array[i];

        return result;
    }
}
