package aslib.document.bra;

import aslib.document.DocumentInternal;
import aslib.document.DocumentUtils;
import aslib.document.NullDocumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Implementation of the Brazilian RG document.
 * </p>
 *
 * <p style="text-align:justify">
 * Get its instance through the {@link BrazilianDocument#rg()} method.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.2
 * @since 12.0.0
 */
class RG implements DocumentInternal {

    private final int length                   = 9;
    private final int verificationDigitsLength = 1;

    /*
     * It is necessary to override these methods because some RGs have the 'X'
     * as a valid digit that has to be processed.
     */
    private final DocumentUtils utils = new DocumentUtils(length, verificationDigitsLength) {
        @Override
        public List<Integer> extractDigits(String document) {
            return Stream.of(document)
                         .map(s -> s.split(""))
                         .flatMap(Stream::of)
                         .filter(s -> s.matches("[\\dxX]"))
                         .map(s -> s.equalsIgnoreCase("x") ? 10 : Integer.parseInt(s))
                         .collect(Collectors.toList());
        }

        @Override
        public String joinDigits(List<Integer> digits) {
            return digits.stream()
                         .map(String::valueOf)
                         .map(s -> s.equals("10") ? "X" : s)
                         .collect(Collectors.joining());
        }

        @Override
        public String removeNonDigits(String document) {
            return document.replaceAll("[^\\dxX]", "");
        }
    };


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link RG} class.
     * </p>
     *
     * @since 1.0.0
     */
    RG() {}


    @Override
    public List<Integer> calculateVerificationDigits(List<Integer> digits) {
        List<Integer> temp = digits.size() == length
                             ? utils.removeVerificationDigits(digits)
                             : new ArrayList<>(digits);

        int control = 2;
        int vd      = 0;

        for (int i : temp) {
            vd += i * control++;
        }

        vd = 11 - (vd % 11);
        temp.add(vd == 11 ? 0 : vd);

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
                .insert(10, '-')
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
