package aslib.document.br;

import aslib.document.DigitsExtractor;
import aslib.document.DigitsJoiner;
import aslib.document.DocumentUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>Implementation of the {@link DocumentUtils} class, dedicated to operations
 * involving the Brazilian Voter Title.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public class VoterTitleUtils extends DocumentUtils {

    private static final int LENGTH          = 12;
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
     * <p>Creates an instance of the {@link VoterTitleUtils} class.</p>
     *
     * @since 2.0.0
     */
    public VoterTitleUtils() {
        super(LENGTH, V_DIGITS_LENGTH, KNOWN_INVALIDS);
    }


    /**
     * <p>Extracts the digits referring to the federative unit.</p>
     *
     * <p>Internal use only.</p>
     *
     * @param digits List with all digits of the document. Not null.
     *
     * @return An integer with the number of the federative unit.
     *
     * @since 2.0.0
     */
    private int getFederativeUnit(List<Integer> digits) {
        return digits.get(8) * 10 + digits.get(9);
    }


    /**
     * <p>Format the title number by adding separators in the correct places and
     * filling in the digits if necessary.</p>
     *
     * @param title Title number that will be formatted.
     *
     * @return A string containing the properly formatted title number.
     *
     * @since 2.0.0
     */
    @Override
    public String format(String title) {
        return new StringBuilder(
                super.fill(
                        super.removeNonDigits(title)
                )
        ).insert(4, ' ')
         .insert(9, ' ')
         .insert(12, ' ')
         .toString();
    }

    /**
     * <p>Generate a new title number. This method ensures that the generated
     * document is mathematically valid.</p>
     *
     * @return A string containing the generated title number.
     *
     * @since 2.0.0
     */
    @Override
    public String generate() {
        List<Integer> digits = super.generateDigits(super.length - super.vDigitsLength - 2);

        int federativeUnit = new Random().nextInt(27) + 1;

        // Add the federative unit digits separately
        digits.add(federativeUnit / 10);
        digits.add(federativeUnit % 10);

        digits.addAll(generateVerificationDigits(digits));

        String document = new DigitsJoiner().parse(digits);

        return isValid(document)
               ? document
               : generate();
    }

    /**
     * <p>Generates the verification digits by applying the mathematical formula
     * to the digits of the title number.</p>
     *
     * @param digits List containing only the digits of the title number. Not null.
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


        // Gets the federative unit
        int federativeUnit = getFederativeUnit(digits);


        // First digit
        int control = 2;
        int vDigit  = 0;

        for (int i = 0; i < temp.size() - 2; i++) {
            vDigit += (temp.get(i) * control++);
        }

        vDigit %= 11;

        if (vDigit == 10) {
            vDigit = 0;
        } else if (vDigit == 0 && (federativeUnit == 1 || federativeUnit == 2)) {
            vDigit = 1;
        }

        temp.add(vDigit);


        // Second digit
        control = 7;
        vDigit = 0;

        for (int i = 8; i < temp.size(); i++) {
            vDigit += (temp.get(i) * control++);
        }

        vDigit %= 11;

        if (vDigit == 10) {
            vDigit = 0;
        } else if (vDigit == 0 && (federativeUnit == 1 || federativeUnit == 2)) {
            vDigit = 1;
        }

        temp.add(vDigit);

        return super.extractVerificationDigits(temp);
    }

    /**
     * <p>Checks if the title number is mathematically valid.</p>
     *
     * @param title Title number that will be verified. Not null.
     *
     * @return True if valid and False otherwise.
     *
     * @since 2.0.0
     */
    @Override
    public boolean isValid(String title) {
        List<Integer> digits = new DigitsExtractor().parse(title);


        // Check if digits are known invalids
        boolean knownInvalid = super.isKnownInvalid(digits);


        // Check length
        boolean lengthValid = digits.size() == super.length;


        // Check federative unit
        int     federativeUnit      = getFederativeUnit(digits);
        boolean federativeUnitValid = (federativeUnit >= 1) && (federativeUnit <= 28);


        // Check verification digits
        List<Integer> vDigits = this.generateVerificationDigits(digits);
        boolean vDigitsValid = super.extractVerificationDigits(digits)
                                    .equals(vDigits);


        return !knownInvalid && lengthValid && federativeUnitValid && vDigitsValid;
    }
}
