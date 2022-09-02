package aslib.document.bra;

import aslib.document.Document;
import aslib.document.DocumentInternalUtil;
import aslib.document.DocumentUtils;
import aslib.document.NullDocumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p style="text-align:justify">
 * Implementation of the Brazilian Voter Title document.
 * </p>
 *
 * <p style="text-align:justify">
 * Get its instance through the {@link Document#brazil()} method or directly
 * through the {@link BrazilianDocument#voterTitle()} method.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 12.0.0
 */
class VoterTitle implements DocumentInternalUtil {

    private final int length                   = 12;
    private final int verificationDigitsLength = 2;

    private final DocumentUtils utils = new DocumentUtils(length, verificationDigitsLength);


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link VoterTitle} class.
     * </p>
     *
     * @since 1.0.0
     */
    VoterTitle() {}


    /**
     * <p style="text-align:justify">
     * Gets the federative unit of the document.
     * </p>
     *
     * @param digits Digits of the document.
     *
     * @return Digit that represents the federative unit.
     *
     * @since 1.0.0
     */
    private int getFederativeUnit(List<Integer> digits) {
        return digits.get(8) * 10 +
               digits.get(9);
    }


    @Override
    public List<Integer> calculateVerificationDigits(List<Integer> digits) {
        List<Integer> temp = digits.size() == length
                             ? utils.removeVerificationDigits(digits)
                             : new ArrayList<>(digits);


        int federativeUnit = getFederativeUnit(digits);


        // First digit
        int control = 2;
        int vd      = 0;

        for (int i = 0; i < temp.size() - 2; i++) {
            vd += (temp.get(i) * control++);
        }

        vd %= 11;

        if (vd == 10) {
            vd = 0;
        } else if (vd == 0 && (federativeUnit == 1 || federativeUnit == 2)) {
            vd = 1;
        }

        temp.add(vd);


        // Second digit
        control = 7;
        vd      = 0;

        for (int i = 8; i < temp.size(); i++) {
            vd += (temp.get(i) * control++);
        }

        vd %= 11;

        if (vd == 10) {
            vd = 0;
        } else if (vd == 0 && (federativeUnit == 1 || federativeUnit == 2)) {
            vd = 1;
        }

        temp.add(vd);

        return utils.extractVerificationDigits(temp);
    }

    @Override
    public String format(String document) {
        document = Optional.ofNullable(document)
                           .map(utils::removeNonDigits)
                           .map(utils::removeTrailingDigits)
                           .map(utils::insertLeadingZeros)
                           .orElseThrow(NullDocumentException::new);

        return new StringBuilder(document)
                .insert(4, ' ')
                .insert(9, ' ')
                .insert(12, ' ')
                .toString();
    }

    @Override
    public String generate() {
        List<Integer> digits = utils.generateRandomDigits(length - verificationDigitsLength);
        digits.addAll(calculateVerificationDigits(digits));

        String document = utils.joinDigits(digits);

        return isValid(document)
               ? format(document)
               : generate();
    }

    @Override
    public boolean isValid(String document) {
        List<Integer> digits = Optional.ofNullable(document)
                                       .map(utils::extractDigits)
                                       .orElseThrow(NullDocumentException::new);


        if (digits.size() != length) return false;
        if (invalids(length).contains(digits)) return false;


        int federativeUnit = getFederativeUnit(digits);

        if (federativeUnit < 1) return false;
        if (federativeUnit > 28) return false;


        List<Integer> calculatedVD = calculateVerificationDigits(digits);

        return utils.extractVerificationDigits(digits)
                    .equals(calculatedVD);
    }
}
