package aslib.document.bra;

import aslib.document.Document;
import aslib.document.DocumentInternalUtil;
import aslib.document.DocumentUtils;
import aslib.document.exception.NullDocumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Implementation of the Brazilian CPF document.
 * </p>
 *
 * <p>
 * Get its instance through the {@link Document#brazil()} method or directly
 * through the {@link BrazilianDocument#cpf()} method.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class CPF implements DocumentInternalUtil {

    private final int length                   = 11;
    private final int verificationDigitsLength = 2;

    private final DocumentUtils utils = new DocumentUtils(length, verificationDigitsLength);


    CPF() {}


    @Override
    public List<Integer> calculateVerificationDigits(List<Integer> digits) {
        List<Integer> temp = digits.size() == length
                             ? utils.removeVerificationDigits(digits)
                             : new ArrayList<>(digits);

        // First digit
        int control = 10;
        int vd      = 0;

        for (int digit : temp) {
            vd += (digit * control--);
        }

        vd *= 10;
        vd %= 11;
        temp.add(vd == 10 ? 0 : vd);


        // Second digit
        control = 11;
        vd      = 0;

        for (int digit : temp) {
            vd += (digit * control--);
        }

        vd *= 10;
        vd %= 11;
        temp.add(vd == 10 ? 0 : vd);

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
                .insert(3, '.')
                .insert(7, '.')
                .insert(11, '/')
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


        int sum = digits.stream()
                        .reduce(Integer::sum)
                        .orElse(0);

        if (sum < 0) return false;
        if (sum > 99) return false;
        if (sum % 11 != 0) return false;


        List<Integer> calculatedVD = calculateVerificationDigits(digits);

        return utils.extractVerificationDigits(digits)
                    .equals(calculatedVD);
    }
}
