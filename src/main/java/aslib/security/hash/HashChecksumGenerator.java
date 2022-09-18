package aslib.security.hash;

import java.io.File;
import java.nio.file.Path;
import java.security.MessageDigest;

/**
 * <p style="text-align:justify">
 * Entry point for the hash checksum API. This class provides access to the
 * supported algorithms as well as the hash generator methods.
 * </p>
 *
 * <p style="text-align:justify">
 * The supported algorithms is accessed through the static methods of this
 * class, which will return an instance of this class that can be used to
 * generate the hashes.
 * </p>
 *
 * <p style="text-align:justify">
 * <b>Samples:</b>
 * </p>
 *
 * <pre>
 *     HashChecksumGenerator generator = HashChecksumGenerator.md5();
 *     String md5Hash = generator.generate(input);
 *
 *     HashChecksumGenerator generator = HashChecksumGenerator.getByLength(64);
 *     String sha256Hash = generator.generate(input);
 * </pre>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class HashChecksumGenerator {

    private String algorithm;


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} class.
     * </p>
     *
     * @param algorithm Algorithm used to create the instance of the
     *                  {@link MessageDigest}.
     *
     * @since 1.0.0
     */
    private HashChecksumGenerator(String algorithm) {
        this.algorithm = algorithm;
    }


    /**
     * <p style="text-align:justify">
     * Attemps to retrieve the hash algorithm through the provided length. When
     * succeed this method returns an instance of {@link HashChecksumGenerator}
     * that uses the detected algorithm, otherwise it will throw a
     * {@link AlgorithmNotFoundException}.
     * </p>
     *
     * @param length Length used to retrieve the algorithm.
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @throws AlgorithmNotFoundException If the length is not valid.
     * @since 1.0.0
     */
    public static HashChecksumGenerator getByLength(int length)
    throws AlgorithmNotFoundException {
        switch (length) {
            case 32:
                return md5();
            case 40:
                return sha1();
            case 56:
                return sha224();
            case 64:
                return sha256();
            case 96:
                return sha384();
            case 128:
                return sha512();
            default:
                throw new AlgorithmNotFoundException("The length is not valid: '" + length + '\'');
        }
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} that uses the
     * <a href="https://en.wikipedia.org/wiki/MD5">MD5</a> algorithm
     * implementation.
     * </p>
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @since 1.0.0
     */
    public static HashChecksumGenerator md5() {
        return new HashChecksumGenerator("md5");
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} that uses the
     * <a href="https://en.wikipedia.org/wiki/SHA-1">SHA-1</a> algorithm
     * implementation.
     * </p>
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @since 1.0.0
     */
    public static HashChecksumGenerator sha1() {
        return new HashChecksumGenerator("sha-1");
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} that uses the
     * <a href="https://en.wikipedia.org/wiki/SHA-2">SHA-224</a> algorithm
     * implementation.
     * </p>
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @since 1.0.0
     */
    public static HashChecksumGenerator sha224() {
        return new HashChecksumGenerator("sha-224");
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} that uses the
     * <a href="https://en.wikipedia.org/wiki/SHA-2">SHA-256</a> algorithm
     * implementation.
     * </p>
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @since 1.0.0
     */
    public static HashChecksumGenerator sha256() {
        return new HashChecksumGenerator("sha-256");
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} that uses the
     * <a href="https://en.wikipedia.org/wiki/SHA-2">SHA-384</a> algorithm
     * implementation.
     * </p>
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @since 1.0.0
     */
    public static HashChecksumGenerator sha384() {
        return new HashChecksumGenerator("sha-384");
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link HashChecksumGenerator} that uses the
     * <a href="https://en.wikipedia.org/wiki/SHA-2">SHA-512</a> algorithm
     * implementation.
     * </p>
     *
     * @return An instance of HashChecksumGenerator.
     *
     * @since 1.0.0
     */
    public static HashChecksumGenerator sha512() {
        return new HashChecksumGenerator("sha-512");
    }


    /**
     * <p style="text-align:justify">
     * Generates the hash checksum of the input object.
     * </p>
     *
     * @param input Object from which the hash will be generated.
     *
     * @return The hash checksum in lower case.
     *
     * @see Generator#generate
     * @since 1.0.0
     */
    public String generate(String input) {
        return new StringGenerator().generate(algorithm, input);
    }

    /**
     * <p style="text-align:justify">
     * Generates the hash checksum of the input object.
     * </p>
     *
     * @param input Object from which the hash will be generated.
     *
     * @return The hash checksum in lower case.
     *
     * @see Generator#generate
     * @since 1.0.0
     */
    public String generate(File input) {
        return new FileGenerator().generate(algorithm, input);
    }

    /**
     * <p style="text-align:justify">
     * Generates the hash checksum of the input object.
     * </p>
     *
     * @param input Object from which the hash will be generated.
     *
     * @return The hash checksum in lower case.
     *
     * @see Generator#generate
     * @since 1.0.0
     */
    public String generate(Path input) {
        return new PathGenerator().generate(algorithm, input);
    }

    /**
     * <p style="text-align:justify">
     * Generates the hash checksum of the input object.
     * </p>
     *
     * @param input Object from which the hash will be generated.
     *
     * @return The hash checksum in lower case.
     *
     * @see Generator#generate
     * @since 1.0.0
     */
    public String generate(byte[] input) {
        return new BytesGenerator().generate(algorithm, input);
    }
}
