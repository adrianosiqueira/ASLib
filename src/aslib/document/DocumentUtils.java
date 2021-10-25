package aslib.document;

import aslib.util.Formattable;
import aslib.util.Generable;
import aslib.util.Validatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>Model class for the other classes that will work with documents.</p>
 *
 * <p>This class has built-in methods for various common operations involving
 * processing the digits of the document. For example, extraction and removal
 * of verification digits, generation of random numbers, among others.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public abstract class DocumentUtils
        implements Formattable<String, String>, Generable<String>, Validatable<String> {


    /**
     * <p>Total amount of digits.</p>
     *
     * @since 1.0.0
     */
    protected final int length;

    /**
     * <p>Amount of verification digits.</p>
     *
     * @since 2.0.0
     */
    protected final int vDigitsLength;

    /**
     * <p>Known invalids are numerical combinations that are mathematically
     * valid, but cannot be used.</p>
     */
    protected final List<List<Integer>> knownInvalids;


    /**
     * <p>Initializes the attributes needed for various operations.</p>
     *
     * @param length        Total amount of digits.
     * @param vDigitsLength Amount of verification digits.
     * @param knownInvalids List of digits that are known invalid. If the
     *                      document has no known invalids, it can be null or an
     *                      empty list.
     *
     * @since 2.0.0
     */
    public DocumentUtils(int length, int vDigitsLength, List<List<Integer>> knownInvalids) {
        this.length = length;
        this.vDigitsLength = vDigitsLength;
        this.knownInvalids = Optional.ofNullable(knownInvalids)
                                     .orElse(new ArrayList<>());
    }


    /**
     * @return The length attribute.
     *
     * @since 2.0.0
     */
    public int getLength() {
        return length;
    }

    /**
     * @return The verification digits length attribute.
     *
     * @since 2.0.0
     */
    public int getVDigitsLength() {
        return vDigitsLength;
    }

    /**
     * @return The known invalids digits attribute.
     *
     * @since 2.0.0
     */
    public List<List<Integer>> getKnownInvalids() {
        return knownInvalids;
    }


    /**
     * <p>Extracts and returns only the verification digits from the list of
     * digits.</p>
     *
     * @param digits List containing all digits. Not null.
     *
     * @return A list containing only the verification digits.
     *
     * @since 2.0.0
     */
    protected List<Integer> extractVerificationDigits(List<Integer> digits) {
        return new ArrayList<>(digits.subList(digits.size() - vDigitsLength, digits.size()));
    }

    /**
     * <p>Adds or removes zeros to make the document have the correct number of
     * digits.</p>
     *
     * @param document The document in string format. Numbers only. Not null.
     *
     * @return A string containing the document number with the correct number
     * of digits. The string will never be null.
     *
     * @since 2.0.0
     */
    protected String fill(String document) {
        StringBuilder builder = new StringBuilder(document);

        while (builder.length() < length) builder.insert(0, 0);
        while (builder.length() > length) builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    /**
     * <p>Generates a certain amount of random numbers between 0 (inclusive) and
     * 9 (inclusive).</p>
     *
     * @param amount Amount of numbers to be generated.
     *
     * @return A list containing the generated numbers. The list can be empty,
     * but it will never be null.
     *
     * @since 2.0.0
     */
    protected List<Integer> generateDigits(int amount) {
        return new Random()
                .ints(amount, 0, 10)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * <p>Checks if the digits are known invalid.</p>
     *
     * @param digits Digits that will be checked. Not null.
     *
     * @return TRUE if it is known invalid. FALSE otherwise.
     *
     * @since 2.0.0
     */
    protected boolean isKnownInvalid(List<Integer> digits) {
        for (List<Integer> knownInvalid : knownInvalids) {
            if (knownInvalid.equals(digits)) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>Removes non-numeric characters from the string.</p>
     *
     * @param document String that will be processed.
     *
     * @return The same string with only numeric characters. The string can be
     * empty, but it will never be null.
     *
     * @since 2.0.0
     */
    protected String removeNonDigits(String document) {
        return document.replaceAll("\\D", "");
    }

    /**
     * <p>Removes verification digits from the digit list.</p>
     *
     * @param digits List containing all digits. Not null.
     *
     * @return A list containing the digits of the document without the verification
     * digits.
     *
     * @since 2.0.0
     */
    protected List<Integer> removeVerificationDigits(List<Integer> digits) {
        return new ArrayList<>(digits.subList(0, digits.size() - vDigitsLength));
    }


    /**
     * <p>Generates the verification digits by applying the mathematical formula
     * to the digits of the document.</p>
     *
     * @param digits List containing only the digits of the document. Not null.
     *
     * @return A list containing only the calculated verification digits.
     *
     * @since 2.0.0
     */
    protected abstract List<Integer> generateVerificationDigits(List<Integer> digits);
}
