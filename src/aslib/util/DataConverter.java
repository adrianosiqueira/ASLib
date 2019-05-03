package aslib.util;

/**
 * <p> Contains the functions to convert between data types. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class DataConverter {
    /**
     * <p> Converts a single byte to a string. </p>
     *
     * @param b Byte to be converted.
     * @return The string represented by that byte.
     */
    public static String byteToString(byte b) {
        return String.format("%02x", b);
    }

    /**
     * <p> Converts an array of bytes to a string. </p>
     *
     * @param bytes Array of bytes to be converted.
     * @return The string represented byte those bytes.
     */
    public static String byteToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        for (byte b : bytes)
            builder.append(byteToString(b));

        return builder.toString();
    }
}