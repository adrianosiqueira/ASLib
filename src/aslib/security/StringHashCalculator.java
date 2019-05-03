package aslib.security;

import aslib.exceptions.ExecutionNotDoneException;
import aslib.util.DataConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p> Contains the function to calculate the hash of some string. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class StringHashCalculator implements HashCalculator, Runnable {
    private String input;
    private SHAType algorithm;
    private String hash;

    /**
     * <p> Creates an instance of {@link StringHashCalculator} class. </p>
     *
     * <p> All class' attributes must be initialized using the set() methods in
     * order to the functions to work properly. </p>
     */
    public StringHashCalculator() {
    }

    /**
     * <p> Creates an instance of {@link StringHashCalculator} class. </p>
     *
     * @param input     String to be calculated.
     * @param algorithm Algorithm used to calculate.
     */
    public StringHashCalculator(String input, SHAType algorithm) {
        this.input = input;
        this.algorithm = algorithm;
    }

    /**
     * <p> Calculates the hash of the string. </p>
     *
     * <p> In order to it works, all class' attributes must be properly initialized. </p>
     *
     * @throws NullPointerException If some class' attributes is null.
     */
    @Override
    public void run() throws NullPointerException {
        if (input == null)
            throw new NullPointerException("Input string can not be null.");
        else if (algorithm == null)
            throw new NullPointerException("Algorithm can not be null.");

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm.name);
            digest.update(input.getBytes());
            hash = DataConverter.byteToString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
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
