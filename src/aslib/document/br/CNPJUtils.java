package aslib.document.br;

import aslib.document.DigitsExtractor;
import aslib.document.DigitsJoiner;
import aslib.document.DocumentUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Implementation of the {@link DocumentUtils} class, dedicated to operations
 * involving the Brazilian CNPJ.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public class CNPJUtils extends DocumentUtils {

    private static final int LENGTH          = 14;
    private static final int V_DIGITS_LENGTH = 2;

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
     * <p>Creates an instance of the {@link CNPJUtils} class.</p>
     *
     * @since 2.0.0
     */
    public CNPJUtils() {
        super(LENGTH, V_DIGITS_LENGTH, KNOWN_INVALIDS);
    }


    /**
     * <p>Format the CNPJ by adding separators in the correct places and filling
     * in the digits if necessary.</p>
     *
     * @param cnpj CNPJ that will be formatted.
     *
     * @return A string containing the properly formatted CNPJ.
     *
     * @since 2.0.0
     */
    @Override
    public String format(String cnpj) {
        return new StringBuilder(
                super.fill(
                        super.removeNonDigits(cnpj)
                )
        ).insert(2, '.')
         .insert(6, '.')
         .insert(10, '/')
         .insert(15, '-')
         .toString();
    }

    /**
     * <p>Generate a new CNPJ. This method ensures that the generated document
     * is mathematically valid.</p>
     *
     * @return A string containing the generated CNPJ.
     *
     * @since 2.0.0
     */
    @Override
    public String generate() {
        List<Integer> digits = super.generateDigits(super.length - super.vDigitsLength);
        digits.addAll(this.generateVerificationDigits(digits));

        String document = new DigitsJoiner().parse(digits);

        return isValid(document)
               ? document
               : generate();
    }

    /**
     * <p>Generates the verification digits by applying the mathematical formula
     * to the digits of the CNPJ.</p>
     *
     * @param digits List containing only the digits of the CNPJ. Not null.
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
        int control = 5;
        int vDigit  = 0;

        for (Integer digit : temp) {
            vDigit += (digit * control--);

            // Restart the counter before it reaches 1
            if (control == 1) control = 9;
        }

        vDigit %= 11;
        temp.add(vDigit < 2 ? 0 : 11 - vDigit);


        // Second digit
        control = 6;
        vDigit = 0;

        for (Integer digit : temp) {
            vDigit += (digit * control--);

            // Restart the counter before it reaches 1
            if (control == 1) control = 9;
        }

        vDigit %= 11;
        temp.add(vDigit < 2 ? 0 : 11 - vDigit);

        return super.extractVerificationDigits(temp);
    }

    /**
     * <p>Checks if the CNPJ is mathematically valid.</p>
     *
     * @param cnpj CNPJ that will be verified. Not null.
     *
     * @return True if valid and False otherwise.
     *
     * @since 2.0.0
     */
    @Override
    public boolean isValid(String cnpj) {
        List<Integer> digits = new DigitsExtractor().parse(cnpj);


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
