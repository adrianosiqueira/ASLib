package aslib.security;

import aslib.exceptions.ExecutionNotDoneException;
import aslib.exceptions.FileNotFoundException;
import aslib.util.DataConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p> Contains the functions to calculate the hash of some file. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class FileHashCalculator implements HashCalculator, Runnable {
    private Path path;
    private SHAType algorithm;
    private String hash;

    /**
     * <p> Creates an instance of {@link FileHashCalculator} class. </p>
     *
     * <p> All class' attributes must be initialized using the set() methods in
     * order to the functions to work properly. </p>
     */
    public FileHashCalculator() {
    }

    /**
     * <p> Creates an instance of {@link FileHashCalculator} class. </p>
     *
     * @param file      File to be calculated
     * @param algorithm Algorithm to be used to calculate.
     */
    public FileHashCalculator(File file, SHAType algorithm) {
        this(file.toPath(), algorithm);
    }

    /**
     * <p> Creates an instance of {@link FileHashCalculator} class. </p>
     *
     * @param path      File to be calculated
     * @param algorithm Algorithm to be used to calculate.
     */
    public FileHashCalculator(Path path, SHAType algorithm) {
        this.path = path;
        this.algorithm = algorithm;
    }

    /**
     * <p> Calculates the hash of the file. </p>
     *
     * <p> In order to it works, all class' attributes must be properly initialized. </p>
     *
     * @throws FileNotFoundException If the file does not exists.
     * @throws NullPointerException  If some class' attributes is null.
     */
    @Override
    public void run() throws FileNotFoundException, NullPointerException {
        if (path == null)
            throw new NullPointerException("File can not be null.");
        else if (Files.notExists(path))
            throw new FileNotFoundException("File does not exists.");
        else if (algorithm == null)
            throw new NullPointerException("Algorithm can not be null.");

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm.name);
            digest.update(Files.readAllBytes(path));
            hash = DataConverter.byteToString(digest.digest());
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public SHAType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SHAType algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String getHash() throws ExecutionNotDoneException {
        if (hash != null)
            return hash;
        else
            throw new ExecutionNotDoneException("Hash code is not calculated yet.");
    }
}
