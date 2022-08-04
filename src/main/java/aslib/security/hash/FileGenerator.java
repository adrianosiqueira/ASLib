package aslib.security.hash;

import java.io.File;

/**
 * <p style="text-align:justify">
 * Handles the hash checksum generation from a {@link File}.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class FileGenerator implements Generator<File> {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileGenerator} class.
     * </p>
     *
     * @since 1.0.0
     */
    FileGenerator() {}


    @Override
    public String generate(String algorithm, File input) {
        if (algorithm == null) throw new NullPointerException("Algorithm cannot be null.");
        if (input == null) throw new NullPointerException("Input cannot be null.");

        return new PathGenerator().generate(algorithm, input.toPath());
    }
}
