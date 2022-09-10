package aslib.document.bra;

import aslib.document.DocumentInternal;
import aslib.document.DocumentUtils;
import aslib.document.NullDocumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Implementation of the Brazilian PIS document.
 * </p>
 *
 * <p>
 * Get its instance through the {@link BrazilianDocument#pis()} method.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.2
 * @since 12.0.0
 */
class PIS implements DocumentInternal {

    private final int length                   = 11;
    private final int verificationDigitsLength = 1;

    private final DocumentUtils utils = new DocumentUtils(length, verificationDigitsLength);


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link PIS} class.
     * </p>
     *
     * @since 1.0.0
     */
    PIS() {}


    @Override
    public List<Integer> calculateVerificationDigits(List<Integer> digits) {
        List<Integer> temp = digits.size() == length
                             ? utils.removeVerificationDigits(digits)
                             : new ArrayList<>(digits);

        int control = 3;
        int vd      = 0;

        for (int digit : temp) {
            vd += (digit * control--);

            if (control == 1) control = 9;
        }

        vd = 11 - (vd % 11);
        temp.add((vd == 10 || vd == 11) ? 0 : vd);

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
                .insert(2, '.')
                .insert(9, '.')
                .insert(12, '-')
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


        List<Integer> calculatedVD = calculateVerificationDigits(digits);

        return utils.extractVerificationDigits(digits)
                    .equals(calculatedVD);
    }
}
