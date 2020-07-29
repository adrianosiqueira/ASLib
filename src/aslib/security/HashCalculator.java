package aslib.security;

import aslib.util.DataConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * <p> Provides several ways to calculate the hash checksum. </p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public class HashCalculator {

    /**
     * <p> Creates an {@link HashCalculator} instance. </p>
     *
     * @since 2.0.0
     */
    public HashCalculator() {
    }

    /**
     * <p> Calculates the hash checksum from a {@link File}. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param file    What will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, File file) throws NullPointerException {
        Objects.requireNonNull(shaType, "ShaType can not be null.");

        return calculate(shaType, file.toPath());
    }

    /**
     * <p> Calculates the hash checksum from a {@link Path}. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param path    What will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, Path path) throws NullPointerException {
        Objects.requireNonNull(shaType, "ShaType can not be null.");

        try {
            return calculate(shaType, Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p> Calculates the hash checksum from a {@link String}. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param string  What will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, String string) throws NullPointerException {
        Objects.requireNonNull(shaType, "ShaType can not be null.");

        return calculate(shaType, string.getBytes());
    }

    /**
     * <p> Calculates the hash checksum from an array of bytes. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param bytes   What will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, byte[] bytes) throws NullPointerException {
        Objects.requireNonNull(shaType, "ShaType can not be null.");

        try {
            MessageDigest digest = MessageDigest.getInstance(shaType.name);
            byte[] result = digest.digest(bytes);
            return DataConverter.byteToString(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
