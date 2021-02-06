package aslib.security;

import aslib.util.DataConverter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * <p> Provides several ways to calculate the hash checksum. </p>
 *
 * @author Adriano Siqueira
 * @version 2.0.1
 * @since 9.0.0
 */
public class HashCalculator {

    /**
     * <p> Creates a {@link HashCalculator} instance. </p>
     *
     * @since 2.0.0
     */
    public HashCalculator() {
    }

    /**
     * <p> Calculates the hash checksum from an array of bytes. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param bytes   Array which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, byte[] bytes)
    throws NullPointerException {
        Objects.requireNonNull(shaType, "ShaType can not be null.");

        try {
            MessageDigest digest = MessageDigest.getInstance(shaType.getName());
            byte[]        result = digest.digest(bytes);
            return DataConverter.byteToString(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * <p> Calculates the hash checksum from a {@link File}. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param file    File which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, File file)
    throws NullPointerException {
        Objects.requireNonNull(shaType, "ShaType can not be null.");

        int    bufferSize  = 2048;
        byte[] bytesBuffer = new byte[bufferSize];

        try (
                BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file),
                                                                     bufferSize)
        ) {
            MessageDigest digest = MessageDigest.getInstance(shaType.getName());
            int           read;

            while ((read = stream.read(bytesBuffer)) > -1) {
                digest.update(bytesBuffer, 0, read);
            }

            byte[] result = digest.digest();
            return DataConverter.byteToString(result);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * <p> Calculates the hash checksum from a {@link Path}. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param path    Path which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, Path path)
    throws NullPointerException {
        return calculate(shaType, path.toFile());
    }

    /**
     * <p> Calculates the hash checksum from a {@link String}. </p>
     *
     * @param shaType Defines which hash algorithm will be used.
     * @param string  String which will be used to calculate the hash.
     *
     * @return The calculated hash in a String format.
     *
     * @throws NullPointerException If shaType is null.
     * @since 2.0.0
     */
    public final String calculate(SHAType shaType, String string)
    throws NullPointerException {
        return calculate(shaType, string.getBytes());
    }
}