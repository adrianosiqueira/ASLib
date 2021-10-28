package aslib.security;

import aslib.parse.BytesToStringParser;
import aslib.parse.PrimitiveWrapperArrayParser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Dedicated class for calculating hash checksums.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.2
 * @since 9.0.0
 */
public class HashCalculator {

    /**
     * <p>Creates an instance of the {@link HashCalculator} class.</p>
     *
     * @since 2.0.0
     */
    public HashCalculator() {
    }


    /**
     * <p>Calculates the hash checksum from a {@link Path}.</p>
     *
     * @param shaType Defines which hash algorithm will be used. Not null.
     * @param path    Path to a regular file which will be used to calculate the
     *                hash.
     *
     * @return The calculated hash in a String format.
     *
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, Path path) {
        return calculate(shaType, path.toFile());
    }

    /**
     * <p>Calculates the hash checksum from a {@link File}.</p>
     *
     * @param shaType Defines which hash algorithm will be used. Not null.
     * @param file    Regular file which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, File file) {
        int    bufferSize  = 2048;
        byte[] bytesBuffer = new byte[bufferSize];

        try (
                BufferedInputStream stream = new BufferedInputStream(
                        new FileInputStream(file),
                        bufferSize
                )
        ) {
            MessageDigest digest = MessageDigest.getInstance(shaType.getName());
            int           read;

            while ((read = stream.read(bytesBuffer)) > -1) {
                digest.update(bytesBuffer, 0, read);
            }

            Byte[] result = PrimitiveWrapperArrayParser
                    .toWrapper(digest.digest());

            return new BytesToStringParser().parse(result);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * <p>Calculates the hash checksum from a {@link String}.</p>
     *
     * @param shaType Defines which hash algorithm will be used. Not null.
     * @param string  String which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, String string) {
        return calculate(shaType, string.getBytes());
    }

    /**
     * <p>Calculates the hash checksum from an array of bytes.</p>
     *
     * @param shaType Defines which hash algorithm will be used. Not null.
     * @param bytes   Array which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, byte[] bytes) {
        try {
            MessageDigest digest = MessageDigest.getInstance(shaType.getName());

            Byte[] result = PrimitiveWrapperArrayParser
                    .toWrapper(digest.digest(bytes));

            return new BytesToStringParser().parse(result);
        } catch (NoSuchAlgorithmException ignored) {
            return "";
        }
    }
}
