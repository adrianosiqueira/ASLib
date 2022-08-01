package aslib.security.hash;

/**
 * <p style="text-align:justify">
 * Handles the hash checksum generation from a bytes array.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class BytesGenerator implements Generator<byte[]> {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link BytesGenerator} class.
     * </p>
     *
     * @since 1.0.0
     */
    BytesGenerator() {}


    @Override
    public String generate(String algorithm, byte[] input) {
        if (algorithm == null) throw new NullPointerException("Algorithm cannot be null.");
        if (input == null) throw new NullPointerException("Input cannot be null.");

        byte[] digest = createMessageDigest(algorithm).digest(input);
        return convertHexadecimalToString(digest);
    }
}
