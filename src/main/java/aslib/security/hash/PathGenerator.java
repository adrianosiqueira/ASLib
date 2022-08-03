package aslib.security.hash;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

/**
 * <p style="text-align:justify">
 * Handles the hash checksum generation from a {@link Path}.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class PathGenerator implements Generator<Path> {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link PathGenerator} class.
     * </p>
     *
     * @since 1.0.0
     */
    PathGenerator() {}


    @Override
    public String generate(String algorithm, Path input) {
        if (algorithm == null) throw new NullPointerException("Algorithm cannot be null.");
        if (input == null) throw new NullPointerException("Input cannot be null.");

        MessageDigest messageDigest = createMessageDigest(algorithm);

        try (InputStream stream = Files.newInputStream(input)) {
            int    read;
            int    size   = 1024;
            byte[] buffer = new byte[size];

            while ((read = stream.read(buffer)) > -1) {
                messageDigest.update(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] digest = messageDigest.digest();
        return convertHexadecimalToString(digest);
    }
}
