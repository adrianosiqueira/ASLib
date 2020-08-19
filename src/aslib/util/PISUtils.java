package aslib.util;

import java.util.Objects;

/**
 * <p> Handles the operations involving PIS, such as formatting, generating and
 * validating. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public abstract class PISUtils extends DocumentUtils {

    /**
     * <p> Provides basic validation. It ignores all non-numeric characters and
     * <b> does not </b> ensures that the PIS is mathematically valid. </p>
     *
     * @since 1.0.0
     */
    public static final PISUtils BASIC = new PISUtils() {
        @Override
        public boolean isValid(String pis) {
            Objects.requireNonNull(pis, "PIS can not be null.");
            pis = removeNonNumericCharacter(pis);
            pis = fillDocument(pis);

            return pis.length() == length && !isSameDigits(pis);
        }
    };

    /**
     * <p> Provides full validation. It ignores separators and ensures that the
     * PIS is mathematically valid. It is the ideal option to use. </p>
     *
     * @since 1.0.0
     */
    public static final PISUtils PERMISSIVE = new PISUtils() {
        @Override
        public boolean isValid(String pis) {
            Objects.requireNonNull(pis, "PIS can not be null.");
            pis = removeSeparator(pis);
            pis = fillDocument(pis);

            if (!pis.matches(regexWithoutSeparator) ||
                    isSameDigits(pis)) {
                return false;
            }

            int[] digits = getDigits(pis);
            int verification = calculateVerification(digits);

            return pis.endsWith(getDigits(verification));
        }
    };

    /**
     * <p> Provides full validation. It ignore nothing. The validation is only
     * successful if the PIS is mathematically valid and has the correct
     * formatting. </p>
     *
     * @since 1.0.0
     */
    public static final PISUtils STRICT = new PISUtils() {
        @Override
        public boolean isValid(String pis) {
            Objects.requireNonNull(pis, "PIS can not be null.");

            return pis.matches(regexWithSeparator) &&
                    PERMISSIVE.isValid(pis);
        }
    };


    /**
     * <p> Fills the attributes and prevents this class to be instantiated. </p>
     *
     * @since 1.0.0
     */
    private PISUtils() {
        super(11, "\\d{3}\\.\\d{7}\\.\\d");
    }


    @Override
    public String format(String cnpj) {
        Objects.requireNonNull(cnpj, "PIS can not be null.");
        cnpj = removeNonNumericCharacter(cnpj);

        StringBuilder result = new StringBuilder(cnpj);

        while (result.length() < length) {
            result.insert(0, "0");
        }

        while (result.length() > length) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.insert(3, ".")
                .insert(11, ".")
                .toString();
    }

    @Override
    public String generate() {
        int[] digits;
        int verification;

        String result;

        do {
            digits = generateRandomDigits(length - 1);
            verification = calculateVerification(digits);

            digits = getDigits(digits, verification);
            result = getDigits(digits);
        } while (!PERMISSIVE.isValid(result));

        return format(result);
    }


    /**
     * <p> Calculates the verification digits of the PIS. </p>
     *
     * @param digits The digits of the PIS. It may or may not contain the verification digits.
     *
     * @return The verification digit.
     *
     * @throws IllegalArgumentException If the length of the digits is invalid.
     * @throws NullPointerException     If the digits is null.
     * @since 1.0.0
     */
    protected int calculateVerification(int[] digits) throws IllegalArgumentException, NullPointerException {
        if (digits == null) {
            throw new NullPointerException("Digits can not be null.");
        } else if (digits.length != length && digits.length != length - 1) {
            throw new IllegalArgumentException("Digits length must be " + length + " or " + (length - 1));
        }

        int result;
        int temp = 0;

        for (int i = 0, j = 3; i < length - 1; i++, j = (j == 2) ? 9 : j - 1) {
            temp += (digits[i] * j);
        }

        temp %= 11;
        result = 11 - temp;

        return result;
    }
}