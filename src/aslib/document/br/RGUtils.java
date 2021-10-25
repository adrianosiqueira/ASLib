package aslib.document.br;

import aslib.document.DigitsExtractor;
import aslib.document.DigitsJoiner;
import aslib.document.DocumentUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Implementation of the {@link DocumentUtils} class, dedicated to operations
 * involving the Brazilian RG.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public final class RGUtils extends DocumentUtils {

    private static final int LENGTH          = 9;
    private static final int V_DIGITS_LENGTH = 1;

    private static final List<List<Integer>> KNOWN_INVALIDS = new ArrayList<>(10);

    // Generates known invalid digits.
    static {
        for (int i = 0; i <= 9; i++) {
            List<Integer> list = new ArrayList<>(LENGTH);
            for (int j = 0; j < LENGTH; j++) list.add(i);

            KNOWN_INVALIDS.add(list);
        }
    }


    /**
     * <p>Creates an instance of the {@link RGUtils} class.</p>
     *
     * @since 2.0.0
     */
    public RGUtils() {
        super(LENGTH, V_DIGITS_LENGTH, KNOWN_INVALIDS);
    }


    /**
     * <p>Format the RG by adding separators in the correct places and filling
     * in the digits if necessary.</p>
     *
     * @param rg RG that will be formatted.
     *
     * @return A string containing the properly formatted RG.
     *
     * @since 2.0.0
     */
    @Override
    public String format(String rg) {
        return new StringBuilder(
                super.fill(
                        this.removeNonDigits(rg)
                )
        ).insert(2, '.')
         .insert(6, '.')
         .insert(10, '-')
         .toString();
    }

    /**
     * <p>Custom implementation of {@link DocumentUtils#removeNonDigits} to be
     * able to handle the 'X' special character.</p>
     *
     * <p>It will remove all non-numeric characters except 'X'.</p>
     *
     * @param document String that will be processed.
     *
     * @return The same string with only numeric characters. The string can be
     * empty, but it will never be null.
     *
     * @since 2.0.0
     */
    @Override
    protected String removeNonDigits(String document) {
        StringBuilder result = new StringBuilder();

        for (char c : document.toCharArray()) {
            if (Character.isDigit(c) || c == 'x' || c == 'X') {
                result.append(c);
            }
        }

        return result.toString();
    }

    /**
     * <p>Generates the verification digits by applying the mathematical formula
     * to the digits of the RG.</p>
     *
     * @param digits List containing only the digits of the RG. Not null.
     *
     * @return A list containing only the calculated verification digits.
     *
     * @since 2.0.0
     */
    @Override
    protected List<Integer> generateVerificationDigits(List<Integer> digits) {
        // Automatically recognizes when verification digits need to be removed.
        List<Integer> temp = new ArrayList<>(
                digits.size() == super.length
                ? super.removeVerificationDigits(digits)
                : digits
        );


        // First digit
        int control = 2;
        int vDigit  = 0;

        for (Integer digit : temp) {
            vDigit += (digit * control++);
        }

        vDigit = 11 - (vDigit % 11);
        temp.add(vDigit == 11 ? 0 : vDigit);

        return super.extractVerificationDigits(temp);
    }

    /**
     * <p>Generate a new RG. This method ensures that the generated document
     * is mathematically valid.</p>
     *
     * @return A string containing the generated RG.
     *
     * @since 2.0.0
     */
    @Override
    public String generate() {
        List<Integer> digits = super.generateDigits(super.length - super.vDigitsLength);
        digits.addAll(this.generateVerificationDigits(digits));

        /*
         * Custom implementation of DigitsJoiner to be able to handle the 'X'
         * special character.
         */
        String document = new DigitsJoiner() {
            @Override
            public String parse(List<Integer> integers) {
                StringBuilder result = new StringBuilder();

                integers.forEach(integer -> {
                    if (integer != 10) {
                        result.append(integer);
                    } else {
                        result.append('X');
                    }
                });

                return result.toString();
            }
        }.parse(digits);

        return isValid(document)
               ? document
               : generate();
    }

    /**
     * <p>Checks if the RG is mathematically valid.</p>
     *
     * @param rg RG that will be verified. Not null.
     *
     * @return True if valid and False otherwise.
     *
     * @since 2.0.0
     */
    @Override
    public boolean isValid(String rg) {
        /*
         * Custom implementation of DigitsExtractor to be able to handle the 'X'
         * special character.
         */
        List<Integer> digits = new DigitsExtractor() {
            @Override
            public List<Integer> parse(String s) {
                List<Integer> result = new ArrayList<>();

                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) {
                        result.add(Character.getNumericValue(c));
                    } else if (c == 'x' || c == 'X') {
                        result.add(10);
                    }
                }

                return result;
            }
        }.parse(rg);


        // Check if digits are known invalids
        boolean knownInvalid = super.isKnownInvalid(digits);


        // Check length
        boolean lengthValid = digits.size() == super.length;


        // Check verification digits
        List<Integer> vDigits = this.generateVerificationDigits(digits);
        boolean vDigitsValid = super.extractVerificationDigits(digits)
                                    .equals(vDigits);


        return !knownInvalid && lengthValid && vDigitsValid;
    }
}
