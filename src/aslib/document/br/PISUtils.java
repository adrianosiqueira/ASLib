package aslib.document.br;

import aslib.document.DigitsExtractor;
import aslib.document.DigitsJoiner;
import aslib.document.DocumentUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Implementation of the {@link DocumentUtils} class, dedicated to operations
 * involving the Brazilian PIS.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public final class PISUtils extends DocumentUtils {

    private static final int LENGTH          = 11;
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
     * <p>Creates an instance of the {@link PISUtils} class.</p>
     *
     * @since 2.0.0
     */
    public PISUtils() {
        super(LENGTH, V_DIGITS_LENGTH, KNOWN_INVALIDS);
    }


    /**
     * <p>Format the PIS by adding separators in the correct places and filling
     * in the digits if necessary.</p>
     *
     * @param pis PIS that will be formatted.
     *
     * @return A string containing the properly formatted PIS.
     *
     * @since 2.0.0
     */
    @Override
    public String format(String pis) {
        return new StringBuilder(
                super.fill(
                        super.removeNonDigits(pis)
                )
        ).insert(3, '.')
         .insert(9, '.')
         .insert(12, '-')
         .toString();
    }

    /**
     * <p>Generate a new PIS. This method ensures that the generated document
     * is mathematically valid.</p>
     *
     * @return A string containing the generated PIS.
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
     * to the digits of the PIS.</p>
     *
     * @param digits List containing only the digits of the PIS. Not null.
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
        int control = 3;
        int vDigit  = 0;

        for (Integer digit : temp) {
            vDigit += (digit * control--);

            if (control == 1) control = 9;
        }

        vDigit = 11 - (vDigit % 11);
        temp.add((vDigit == 10 || vDigit == 11) ? 0 : vDigit);

        return super.extractVerificationDigits(temp);
    }

    /**
     * <p>Checks if the PIS is mathematically valid.</p>
     *
     * @param pis PIS that will be verified. Not null.
     *
     * @return True if valid and False otherwise.
     *
     * @since 2.0.0
     */
    @Override
    public boolean isValid(String pis) {
        List<Integer> digits = new DigitsExtractor().parse(pis);


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
