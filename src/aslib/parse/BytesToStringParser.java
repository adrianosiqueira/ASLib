package aslib.parse;

import aslib.util.Parsable;

import java.util.Arrays;

/**
 * <p>Handles conversion from bytes to string.</p>
 *
 * <p>Bytes must be in hexadecimal format. They are usually obtained through
 * low-level data processing, such as in the case of hashing.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class BytesToStringParser implements Parsable<Byte[], String> {

    /**
     * <p>Converts input bytes to a string.</p>
     *
     * @param bytes Bytes in hexadecimal format that will be converted.
     *
     * @return A string representation of the supplied bytes.
     *
     * @since 1.0.0
     */
    @Override
    public String parse(Byte... bytes) {
        return Arrays.stream(bytes)
                     .map(aByte -> String.format("%02x", aByte))
                     .reduce(String::concat)
                     .orElse("");
    }
}
