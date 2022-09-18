package aslib.security.hash;

/**
 * <p style="text-align:justify">
 * Handles the hash checksum generation from a String.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class StringGenerator implements Generator<String> {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link StringGenerator} class.
     * </p>
     *
     * @since 1.0.0
     */
    StringGenerator() {}


    @Override
    public String generate(String algorithm, String input) {
        if (algorithm == null) throw new NullPointerException("Algorithm cannot be null.");
        if (input == null) throw new NullPointerException("Input cannot be null.");

        return new BytesGenerator().generate(algorithm, input.getBytes());
    }
}
