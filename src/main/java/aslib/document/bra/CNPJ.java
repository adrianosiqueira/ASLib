package aslib.document.bra;

import aslib.document.Document;
import aslib.document.DocumentInternalUtil;
import aslib.document.DocumentUtils;
import aslib.document.NullDocumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Implementation of the Brazilian CNPJ document.
 * </p>
 *
 * <p>
 * Get its instance through the {@link Document#brazil()} method or directly
 * through the {@link BrazilianDocument#cnpj()} method.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 12.0.0
 */
class CNPJ implements DocumentInternalUtil {

    private final int length                   = 14;
    private final int verificationDigitsLength = 2;

    private final DocumentUtils utils = new DocumentUtils(length, verificationDigitsLength);


    CNPJ() {}


    @Override
    public List<Integer> calculateVerificationDigits(List<Integer> digits) {
        List<Integer> temp = digits.size() == length
                             ? utils.removeVerificationDigits(digits)
                             : new ArrayList<>(digits);

        // First digit
        int control = 5;
        int vd      = 0;

        for (int digit : temp) {
            vd += (digit * control--);

            // Restart the counter before it reaches 1
            if (control == 1) control = 9;
        }

        vd %= 11;
        temp.add(vd < 2 ? 0 : 11 - vd);


        // Second digit
        control = 6;
        vd      = 0;

        for (int digit : temp) {
            vd += (digit * control--);

            // Restart the counter before it reaches 1
            if (control == 1) control = 9;
        }

        vd %= 11;
        temp.add(vd < 2 ? 0 : 11 - vd);

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
                .insert(6, '.')
                .insert(10, '/')
                .insert(15, '-')
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
