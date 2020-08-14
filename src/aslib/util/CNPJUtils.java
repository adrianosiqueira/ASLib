package aslib.util;

import java.util.Objects;

/**
 * <p> Handles the operations involving CNPJ, such as formatting, generating
 * and validating. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public abstract class CNPJUtils extends DocumentUtils {

    /**
     * <p> Provides basic validation. It ignores all non-numeric characters and
     * <b> does not </b> ensures that the CNPJ is mathematically valid. </p>
     *
     * @since 1.0.0
     */
    public static final CNPJUtils BASIC = new CNPJUtils() {
        @Override
        public boolean isValid(String cnpj) {
            Objects.requireNonNull(cnpj, "CNPJ can not be null.");
            cnpj = removeNonNumericCharacter(cnpj);

            return cnpj.length() == length && !isSameDigits(cnpj);
        }
    };

    /**
     * <p> Provides full validation. It ignores separators and ensures that the
     * CNPJ is mathematically valid. It is the ideal option to use. </p>
     *
     * @since 1.0.0
     */
    public static final CNPJUtils PERMISSIVE = new CNPJUtils() {
        @Override
        public boolean isValid(String cnpj) {
            Objects.requireNonNull(cnpj, "CNPJ can not be null.");
            cnpj = removeSeparator(cnpj);

            if (!cnpj.matches(regexWithoutSeparator) ||
                    isSameDigits(cnpj)) {
                return false;
            }

            int[] digits = getDigits(cnpj);
            int[] verification = calculateVerification(digits);

            return cnpj.endsWith(getDigits(verification));
            /*boolean checkDigit = cnpj.endsWith(getDigits(verification));

            digits = getDigits(cnpj);
            boolean checkSum = checkSum(digits);

            return checkDigit && checkSum;*/
        }
    };

    /**
     * <p> Provides full validation. It ignore nothing. The validation is only
     * successful if the CNPJ is mathematically valid and has the correct
     * formatting. </p>
     *
     * @since 1.0.0
     */
    public static final CNPJUtils STRICT = new CNPJUtils() {
        @Override
        public boolean isValid(String cnpj) {
            Objects.requireNonNull(cnpj, "CNPJ can not be null.");

            return cnpj.matches(regexWithSeparator) &&
                    PERMISSIVE.isValid(cnpj);
        }
    };


    /**
     * <p> Fills the attributes and prevents this class to be instantiated. </p>
     *
     * @since 1.0.0
     */
    private CNPJUtils() {
        super(14, "\\d{2}(\\.\\d{3}){2}/\\d{4}-\\d{2}");
    }


    @Override
    public String format(String cnpj) {
        Objects.requireNonNull(cnpj, "CNPJ can not be null.");
        cnpj = removeNonNumericCharacter(cnpj);

        StringBuilder result = new StringBuilder(cnpj);

        while (result.length() < length) {
            result.insert(0, "0");
        }

        while (result.length() > length) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.insert(2, ".")
                .insert(6, ".")
                .insert(10, "/")
                .insert(15, "-")
                .toString();
    }

    @Override
    public String generate() {
        int[] digits;
        int[] verification;

        String result;

        do {
            digits = generateRandomDigits(length - 2);
            verification = calculateVerification(digits);

            digits = getDigits(digits, verification);
            result = getDigits(digits);
        } while (!PERMISSIVE.isValid(result));

        return format(result);
    }


    /**
     * <p> Calculates the verification digits of the CNPJ. </p>
     *
     * @param digits The digits of the CNPJ. It may or may not contain the verification digits.
     *
     * @return An array containing the two verification digits.
     *
     * @throws IllegalArgumentException If the length of the digits is invalid.
     * @throws NullPointerException     If the digits is null.
     * @since 1.0.0
     */
    protected int[] calculateVerification(int[] digits) throws IllegalArgumentException, NullPointerException {
        if (digits == null) {
            throw new NullPointerException("Digits can not be null.");
        } else if (digits.length != length && digits.length != length - 2) {
            throw new IllegalArgumentException("Digits length must be " + length + " or " + (length - 2));
        }

        int[] result = new int[2];
        int temp = 0;

        for (int i = 0, j = 5; i < length - 2; i++, j = (j == 2) ? 9 : j - 1) {
            temp += (digits[i] * j);
        }

        temp %= 11;
        result[0] = (temp < 2) ? 0 : 11 - temp;
        temp = 0;

        for (int i = 0, j = 6; i < length - 2; i++, j = (j == 2) ? 9 : j - 1) {
            temp += (digits[i] * j);
        }

        temp += (result[0] * 2);
        temp %= 11;
        result[1] = (temp < 2) ? 0 : 11 - temp;

        return result;
    }
}