package aslib.document.br;

import aslib.document.DigitsExtractor;
import aslib.document.DigitsJoiner;
import aslib.document.DocumentUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Implementation of the {@link DocumentUtils} class, dedicated to operations
 * involving the Brazilian CPF.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public final class CPFUtils extends DocumentUtils {

    private static final int LENGTH          = 11;
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
     * <p>Creates an instance of the {@link CPFUtils} class.</p>
     *
     * @since 2.0.0
     */
    public CPFUtils() {
        super(LENGTH, V_DIGITS_LENGTH, KNOWN_INVALIDS);
    }


    /**
     * <p>Format the CPF by adding separators in the correct places and filling
     * in the digits if necessary.</p>
     *
     * @param cpf CPF that will be formatted.
     *
     * @return A string containing the properly formatted CPF.
     *
     * @since 2.0.0
     */
    @Override
    public String format(String cpf) {
        return new StringBuilder(
                super.fill(
                        super.removeNonDigits(cpf)
                )
        ).insert(3, '.')
         .insert(7, '.')
         .insert(11, '/')
         .toString();
    }

    /**
     * <p>Generate a new CPF. This method ensures that the generated document
     * is mathematically valid.</p>
     *
     * @return A string containing the generated CPF.
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
     * to the digits of the CPF.</p>
     *
     * @param digits List containing only the digits of the CPF. Not null.
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
        int control = 10;
        int vDigit  = 0;

        for (Integer digit : temp) {
            vDigit += (digit * control--);
        }

        vDigit *= 10;
        vDigit %= 11;
        temp.add(vDigit == 10 ? 0 : vDigit);


        // Second digit
        control = 11;
        vDigit = 0;

        for (Integer digit : temp) {
            vDigit += (digit * control--);
        }

        vDigit *= 10;
        vDigit %= 11;
        temp.add(vDigit == 10 ? 0 : vDigit);

        return super.extractVerificationDigits(temp);
    }

    /**
     * <p>Checks if the CPF is mathematically valid.</p>
     *
     * @param cpf CPF that will be verified. Not null.
     *
     * @return True if valid and False otherwise.
     *
     * @since 2.0.0
     */
    @Override
    public boolean isValid(String cpf) {
        List<Integer> digits = new DigitsExtractor().parse(cpf);


        // Check if digits are known invalids
        boolean knownInvalid = super.isKnownInvalid(digits);


        // Check length
        boolean lengthValid = digits.size() == super.length;


        // Check digits sum
        int sum = digits.stream()
                        .reduce(Integer::sum)
                        .orElse(0);
        boolean sumValid = (sum >= 0) &&
                           (sum <= 99) &&
                           ((sum % 11) == 0);


        // Check verification digits
        List<Integer> vDigits = this.generateVerificationDigits(digits);
        boolean vDigitsValid = super.extractVerificationDigits(digits)
                                    .equals(vDigits);


        return !knownInvalid && lengthValid && sumValid && vDigitsValid;
    }
}
