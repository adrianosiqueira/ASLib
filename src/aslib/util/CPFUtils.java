package aslib.util;

import java.util.Objects;

/**
 * <p> Handles the operations involving CPF, such as formatting, generating and validating. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public abstract class CPFUtils extends DocumentUtils {

    /**
     * <p> Provides basic validation. It ignores all non-numeric characters and
     * <b> does not </b> ensures that the CPF is mathematically valid. </p>
     *
     * @since 1.0.0
     */
    public static final CPFUtils BASIC = new CPFUtils() {
        @Override
        public boolean isValid(String cpf) {
            Objects.requireNonNull(cpf, "CPF can not be null.");
            cpf = removeNonNumericCharacter(cpf);

            return cpf.length() == length && !isSameDigits(cpf);
        }
    };

    /**
     * <p> Provides full validation. It ignores separators and ensures that the
     * CPF is mathematically valid. It is the ideal option to use. </p>
     *
     * @since 1.0.0
     */
    public static final CPFUtils PERMISSIVE = new CPFUtils() {
        @Override
        public boolean isValid(String cpf) {
            Objects.requireNonNull(cpf, "CPF can not be null.");
            cpf = removeSeparator(cpf);

            if (!cpf.matches(regexWithoutSeparator) ||
                    isSameDigits(cpf)) {
                return false;
            }

            int[] digits = getDigits(cpf);
            int[] verification = calculateVerification(digits);

            boolean checkDigit = cpf.endsWith(getDigits(verification));
            boolean checkSum = checkSum(digits);

            return checkDigit && checkSum;
        }
    };

    /**
     * <p> Provides full validation. It ignore nothing. The validation is only
     * successful if the CPF is mathematically valid and has the correct
     * formatting. </p>
     *
     * @since 1.0.0
     */
    public static final CPFUtils STRICT = new CPFUtils() {
        @Override
        public boolean isValid(String cpf) {
            Objects.requireNonNull(cpf, "CPF can not be null.");

            return cpf.matches(regexWithSeparator) &&
                    PERMISSIVE.isValid(cpf);
        }
    };


    /**
     * <p> Fills the attributes and prevents this class to be instantiated. </p>
     *
     * @since 1.0.0
     */
    private CPFUtils() {
        super(11, "(\\d{3}\\.){2}\\d{3}/\\d{2}");
    }


    @Override
    public String format(String cpf) {
        Objects.requireNonNull(cpf, "CPF can not be null.");
        cpf = removeNonNumericCharacter(cpf);

        StringBuilder result = new StringBuilder(cpf);

        while (result.length() < length) {
            result.insert(0, "0");
        }

        while (result.length() > length) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.insert(3, ".")
                .insert(7, ".")
                .insert(11, "/")
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
     * <p> Calculates the verification digits of the CPF. </p>
     *
     * @param digits The digits of the CPF. It may or may not contain the verification digits.
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

        for (int i = 0, j = 10; j >= 2; i++, j--) {
            temp += (digits[i] * j);
        }

        temp = (temp * 10) % 11;
        result[0] = (temp != 10) ? temp : 0;
        temp = 0;

        for (int i = 0, j = 11; j >= 3; i++, j--) {
            temp += (digits[i] * j);
        }

        temp += (result[0] * 2);
        temp = (temp * 10) % 11;
        result[1] = (temp != 10) ? temp : 0;

        return result;
    }

    /**
     * <p> Checks the sum of the digits. </p>
     *
     * @param digits The digits of the CPF.
     *
     * @return TRUE if the sum is correct. FALSE otherwise.
     *
     * @throws IllegalArgumentException If the length of the digits is invalid.
     * @throws NullPointerException     If the digits is null.
     * @since 1.0.0
     */
    protected boolean checkSum(int[] digits) throws IllegalArgumentException, NullPointerException {
        if (digits == null) {
            throw new NullPointerException("Digits can not be null.");
        } else if (digits.length != length) {
            throw new IllegalArgumentException("Digits length must be " + length);
        }

        int result = 0;

        for (int digit : digits) {
            result += digit;
        }

        return result % 11 == 0;
    }
}