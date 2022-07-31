package aslib.security.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Defines the contract of the classes that handles hash checksum generation.
 * </p>
 *
 * @param <T> Type of the object that will generate the hash.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public interface Generator<T> {

    /**
     * <p style="text-align:justify">
     * Converts the hexadecimal byte array to a String. This string will be in
     * lower case.
     * </p>
     *
     * @param bytes Array that will be converted.
     *
     * @return String generated from the byte array.
     *
     * @throws NullPointerException If the array is null.
     * @since 1.0.0
     */
    default String convertHexadecimalToString(byte[] bytes)
    throws NullPointerException {
        if (bytes == null) throw new NullPointerException("Array cannot be null.");

        return Stream.iterate(0, i -> i < bytes.length, i -> ++i)
                     .map(i -> bytes[i])
                     .map(i -> String.format("%02x", i))
                     .map(String::toLowerCase)
                     .collect(Collectors.joining());
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link MessageDigest} using the provided algorithm.
     * </p>
     *
     * @param algorithm Algorithm used by the message digest.
     *
     * @return An instance of MessageDigest.
     *
     * @throws AlgorithmNotFoundException If the algorithm is not found.
     * @since 1.0.0
     */
    default MessageDigest createMessageDigest(String algorithm)
    throws AlgorithmNotFoundException {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException | NullPointerException e) {
            throw new AlgorithmNotFoundException(e.getMessage(), e.getCause());
        }
    }

    /**
     * <p style="text-align:justify">
     * Generates the hash checksum for the provided object. The result will be
     * converted from hexadecimal to string, ready to be used. The result will
     * be in lower case.
     * </p>
     *
     * @param algorithm Algorithm used to generate the hash.
     * @param input     Object from which the hash will be generated.
     *
     * @return The hash checksum of the object.
     *
     * @throws NullPointerException If any parameters is null.
     */
    String generate(String algorithm, T input)
    throws NullPointerException;
}
