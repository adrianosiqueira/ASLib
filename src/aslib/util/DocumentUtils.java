package aslib.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * <p> Encapsulates all operations involving documents. It contains the methods
 * to format, generate and validate. </p>
 *
 * @author Adriano Siqueira
 * @version 1.1.0
 * @since 9.0.0
 */
public abstract class DocumentUtils {

    /**
     * <p> Standard number of digits of the document without separators. </p>
     *
     * @since 1.0.0
     */
    public final int length;

    /**
     * <p> Pattern of the document when it contains the separators. </p>
     *
     * @since 1.0.0
     */
    public final String regexWithSeparator;

    /**
     * <p> Pattern of the document when it does not contains the separators. </p>
     *
     * @since 1.0.0
     */
    public final String regexWithoutSeparator;


    /**
     * <p> Initializes the attributes of the class. </p>
     *
     * @param length             Number of digits of the document without the separators.
     * @param regexWithSeparator Pattern of the document when it contains the separators.
     *
     * @since 1.0.0
     */
    protected DocumentUtils(int length, String regexWithSeparator) {
        this(length, regexWithSeparator, "\\d{" + length + "}");
    }

    /**
     * <p> Initializes the attributes of the class. </p>
     *
     * @param length                Number of digits of the document without the separators.
     * @param regexWithSeparator    Pattern of the document when it contains the separators.
     * @param regexWithoutSeparator Pattern of the document when it does not contains the separators.
     *
     * @since 1.1.0
     */
    protected DocumentUtils(int length, String regexWithSeparator, String regexWithoutSeparator) {
        this.length = length;
        this.regexWithSeparator = regexWithSeparator;
        this.regexWithoutSeparator = regexWithoutSeparator;
    }


    /**
     * <p> Formats the document by placing the separators in the appropriate
     * places. </p>
     *
     * <p> If the number of digits is less than the size, the document will be
     * padded with leading zeros. </p>
     *
     * <p> If the number of digits is greater than the size, the document will
     * be truncated at the end. </p>
     *
     * @param input Document to be formatted.
     *
     * @return The document properly formatted.
     *
     * @throws NullPointerException If the input string is null.
     * @since 1.0.0
     */
    public abstract String format(String input) throws NullPointerException;

    /**
     * <p> Generates a new document that is mathematically valid and properly
     * formatted. </p>
     *
     * @return A new document.
     *
     * @since 1.0.0
     */
    public abstract String generate();

    /**
     * <p> Checks if the document is mathematically valid. </p>
     *
     * @param input Document to be checked.
     *
     * @return TRUE if it is valid. FALSE otherwise.
     *
     * @throws NullPointerException If the input string is null.
     * @since 1.0.0
     */
    public abstract boolean isValid(String input) throws NullPointerException;


    /**
     * <p> Generates an array with a certain number of random numbers with
     * values between 0 (inclusive) and 9 (inclusive). </p>
     *
     * @param amount Number of digits to generate.
     *
     * @return An array with random numbers.
     *
     * @since 1.0.0
     */
    protected int[] generateRandomDigits(int amount) {
        amount = Math.abs(amount);

        Random random = new Random();
        int[] result = new int[amount];

        for (int i = 0; i < amount; i++) {
            result[i] = random.nextInt(10);
        }

        return result;
    }

    /**
     * <p> Merges the first array with the second. </p>
     *
     * @param first  First array.
     * @param second Second array. It will be appended with the first.
     *
     * @return A new array with values of both arrays.
     *
     * @throws NullPointerException If any array is null.
     * @since 1.0.0
     */
    protected int[] getDigits(int[] first, int... second) throws NullPointerException {
        if (first == null || second == null) {
            throw new NullPointerException("Arrays can not be null.");
        }

        int[] result = Arrays.copyOf(first, first.length + second.length);

        for (int i = 0, j = first.length; i < second.length; i++, j++) {
            result[j] = second[i];
        }

        return result;
    }

    /**
     * <p> Converts the input string into an array of numbers. The string must
     * consist of numbers only. Each character will be an element in the array. </p>
     *
     * @param input String to be converted.
     *
     * @return An array with the numbers of the string.
     *
     * @throws IllegalArgumentException If the input string contains non-numeric character.
     * @throws NullPointerException     If the input string is null.
     * @since 1.0.0
     */
    protected int[] getDigits(String input) throws IllegalArgumentException, NullPointerException {
        if (input == null) {
            throw new NullPointerException("Input string can not be null.");
        } else if (!isNumberOnly(input)) {
            throw new IllegalArgumentException("Input string must consist of numbers only.");
        }

        int[] result = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i) - '0';
        }

        return result;
    }

    /**
     * <p> Converts the array into a string. The string will consist of all the
     * elements of the array concatenated with each other. </p>
     *
     * @param input Array to be converted.
     *
     * @return A string with all the elements of the array.
     *
     * @throws NullPointerException If the array is null.
     * @since 1.0.0
     */
    protected String getDigits(int... input) throws NullPointerException {
        if (input == null) {
            throw new NullPointerException("Input array can not be null.");
        }

        StringBuilder result = new StringBuilder();

        for (int digit : input) {
            result.append(digit);
        }

        return result.toString();
    }


    /**
     * <p> Checks if the input string consists os numbers only. </p>
     *
     * <p> If the input string is null or empty, then FALSE will be returned. </p>
     *
     * @param input String to be checked.
     *
     * @return TRUE if it is number only. FALSE otherwise.
     *
     * @since 1.0.0
     */
    protected boolean isNumberOnly(String input) {
        if (input == null) {
            return false;
        }

        return input.matches("\\d+");
    }

    /**
     * <p> Checks if the input string consists of the same characters. </p>
     *
     * <p> If the input string is null or empty, then FALSE is returned. </p>
     *
     * @param input String to be checked.
     *
     * @return TRUE if all the characters are the same. FALSE otherwise.
     *
     * @since 1.0.0
     */
    protected boolean isSameDigits(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return input.matches(input.charAt(0) + "+");
    }


    /**
     * <p> Removes all non-numeric characters of the input string. </p>
     *
     * @param input String to be manipulated.
     *
     * @return A string without non-numeric characters.
     *
     * @throws NullPointerException If the input string is null.
     * @since 1.0.0
     */
    protected String removeNonNumericCharacter(String input) throws NullPointerException {
        Objects.requireNonNull(input, "Input string can not be null.");
        return input.replaceAll("\\D", "");
    }

    /**
     * <p> Removes the separators of the input string. </p>
     *
     * @param input String to be manipulated.
     *
     * @return A string without the separators.
     *
     * @throws NullPointerException If the input string is null.
     * @since 1.0.0
     */
    protected String removeSeparator(String input) throws NullPointerException {
        Objects.requireNonNull(input, "Input string can not be null.");
        return input.replaceAll("[-./ ]", "");
    }
}