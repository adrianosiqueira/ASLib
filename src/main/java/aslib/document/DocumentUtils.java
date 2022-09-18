package aslib.document;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * Contains a set of utility methods that perform common tasks within the API.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class DocumentUtils {

    private final int length;
    private final int verificationDigitsLength;


    /**
     * <p>
     * Creates an instance of the {@link DocumentUtils} class with the required
     * data.
     * </p>
     *
     * <p>
     * As the class performs tasks shared across the API, it is necessary to
     * provide some information specific to the document that is using it.
     * </p>
     *
     * @param length                   Document length including all digits.
     * @param verificationDigitsLength Amount of verification digits in the
     *                                 document.
     *
     * @since 3.0.0
     */
    public DocumentUtils(int length, int verificationDigitsLength) {
        this.length                   = length;
        this.verificationDigitsLength = verificationDigitsLength;
    }


    /**
     * <p>
     * Extracts the digits from the document. Non-numeric values will be removed.
     * </p>
     *
     * @param document Document from which the digits will be extracted.
     *
     * @return A list containing the extracted digits from the document.
     *
     * @since 3.0.0
     */
    public List<Integer> extractDigits(String document) {
        return Stream.of(document)
                     .map(s -> s.split(""))
                     .flatMap(Stream::of)
                     .filter(s -> s.matches("\\d"))
                     .map(Integer::valueOf)
                     .collect(Collectors.toList());
    }

    /**
     * <p>
     * Extracts the verification digits. If the digits do not have the correct
     * length, the result will be wrong.
     * </p>
     *
     * @param digits Digits from which the verification digits will be extracted.
     *
     * @return A list containing only the verification digits.
     *
     * @since 3.0.0
     */
    public List<Integer> extractVerificationDigits(List<Integer> digits) {
        return digits.subList(digits.size() - verificationDigitsLength,
                              digits.size());
    }

    /**
     * <p>
     * Generates random digits between 0 (inclusive) and 9 (inclusive).
     * </p>
     *
     * @param amount Amount of digits to generate.
     *
     * @return A list containing random digits.
     *
     * @since 3.0.0
     */
    public List<Integer> generateRandomDigits(int amount) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return Stream.generate(() -> random.nextInt(10))
                     .limit(amount)
                     .collect(Collectors.toList());
    }

    /**
     * <p>
     * Inserts leading zeros in the document until it reaches the correct
     * length. If the document length is greater or equals to length, then it
     * will do nothing.
     * </p>
     *
     * @param document Document that will be filled.
     *
     * @return The document filled with leading zeros.
     *
     * @since 3.0.0
     */
    public String insertLeadingZeros(String document) {
        int diff = length - document.length();

        if (diff <= 0) return document;

        return "0".repeat(diff) + document;
    }

    /**
     * <p>
     * Joins the digits into a single string.
     * </p>
     *
     * @param digits Digits that will be joined.
     *
     * @return A string containing all digits joined.
     *
     * @since 3.0.0
     */
    public String joinDigits(List<Integer> digits) {
        return digits.stream()
                     .map(String::valueOf)
                     .collect(Collectors.joining());
    }

    /**
     * <p>
     * Removes non-numeric digits from the document.
     * </p>
     *
     * @param document Document from which the non-numeric digits will be
     *                 removed.
     *
     * @return The document without non-numeric digits.
     *
     * @since 3.0.0
     */
    public String removeNonDigits(String document) {
        return document.replaceAll("\\D", "");
    }

    /**
     * <p>
     * Removes trailing digits from the document until it reaches the correct
     * length. If the document length is lower or equals to length, then it
     * will do nothing.
     * </p>
     *
     * @param document Document that will be truncated.
     *
     * @return The document truncated in the end.
     *
     * @since 3.0.0
     */
    public String removeTrailingDigits(String document) {
        int diff = length - document.length();

        if (diff >= 0) return document;

        return document.substring(0, document.length() + diff);
    }

    /**
     * <p>
     * Removes the verification digits from the list.
     * </p>
     *
     * @param digits Digits from which the verification digits will be removed.
     *
     * @return A list of digits without the verification digits.
     *
     * @since 3.0.0
     */
    public List<Integer> removeVerificationDigits(List<Integer> digits) {
        return new ArrayList<>(digits.subList(0, digits.size() - verificationDigitsLength));
    }
}
