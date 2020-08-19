package aslib.util;

import java.util.Objects;

/**
 * <p> Handles the operations involving RG, such as formatting, generating and
 * validating. </p>
 *
 * <p><b> Warning: </b> It only works for SSP RGs and the RG must have 9 digits
 * to work correctly. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 9.0.0
 */
public abstract class RGUtils extends DocumentUtils {

    /**
     * <p> Provides basic validation. It ignores all non-numeric characters and
     * <b> does not </b> ensures that the RG is mathematically valid. </p>
     *
     * @since 1.0.0
     */
    public static final RGUtils BASIC = new RGUtils() {
        @Override
        public boolean isValid(String rg) {
            Objects.requireNonNull(rg, "RG can not be null.");
            rg = removeNonNumericCharacter(rg);
            rg = fillDocument(rg);

            return rg.length() == length && !isSameDigits(rg);
        }
    };

    /**
     * <p> Provides full validation. It ignores separators and ensures that the
     * RG is mathematically valid. It is the ideal option to use. </p>
     *
     * @since 1.0.0
     */
    public static final RGUtils PERMISSIVE = new RGUtils() {
        @Override
        public boolean isValid(String rg) {
            Objects.requireNonNull(rg, "RG can not be null.");
            rg = removeSeparator(rg);
            rg = fillDocument(rg);

            if (!rg.matches(regexWithoutSeparator) ||
                    isSameDigits(rg)) {
                return false;
            }

            int[] digits = getDigits(rg);
            int verification = calculateVerification(digits);

            boolean checkDigit = rg.endsWith(getDigits(verification));
            boolean checkMod = checkMod(digits);

            return checkDigit && checkMod;
        }
    };

    /**
     * <p> Provides full validation. It ignore nothing. The validation is only
     * successful if the RG is mathematically valid and has the correct
     * formatting. </p>
     *
     * @since 1.0.0
     */
    public static final RGUtils STRICT = new RGUtils() {
        @Override
        public boolean isValid(String rg) {
            Objects.requireNonNull(rg, "RG can not be null.");

            return rg.matches(regexWithSeparator) &&
                    PERMISSIVE.isValid(rg);
        }
    };


    /**
     * <p> Fills the attributes and prevents this class to be instantiated. </p>
     *
     * @since 1.0.0
     */
    private RGUtils() {
        super(9, "\\d{2}(\\.\\d{3}){2}-[\\dxX]", "\\d{8}[\\dxX]");
    }


    @Override
    public String format(String rg) {
        Objects.requireNonNull(rg, "RG can not be null.");
        rg = removeNonNumericCharacter(rg);

        StringBuilder result = new StringBuilder(rg);

        while (result.length() < length) {
            result.insert(0, "0");
        }

        while (result.length() > length) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.insert(2, ".")
                .insert(6, ".")
                .insert(10, "-")
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

    @Override
    protected int[] getDigits(String input) throws IllegalArgumentException, NullPointerException {
        if (input == null) {
            throw new NullPointerException("Input string can not be null.");
        }

        int[] result = new int[input.length()];
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);

            if (c == 'x' || c == 'X') {
                result[i] = 10;
            } else if (Character.isDigit(c)) {
                result[i] = c - '0';
            } else {
                throw new IllegalArgumentException("Input string must consist of numbers only.");
            }
        }

        return result;
    }

    @Override
    protected String getDigits(int... input) throws NullPointerException {
        if (input == null) {
            throw new NullPointerException("Input array can not be null.");
        }

        StringBuilder result = new StringBuilder();

        for (int i : input) {
            if (i != 10) {
                result.append(i);
            } else {
                result.append("X");
            }
        }

        return result.toString();
    }


    /**
     * <p> Calculates the verification digits of the RG. </p>
     *
     * @param digits The digits of the RG. It may or may not contain the verification digits.
     *
     * @return An array containing the two verification digits.
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

        for (int i = 0, j = 2; i < length - 1; i++, j++) {
            temp += (digits[i] * j);
        }

        temp = 11 - (temp % 11);
        result = (temp != 11) ? temp : 0;

        return result;
    }

    /**
     * <p> Checks the sum of the digits. </p>
     *
     * @param digits The digits of the RG.
     *
     * @return TRUE if the sum is correct. FALSE otherwise.
     *
     * @throws IllegalArgumentException If the length of the digits is invalid.
     * @throws NullPointerException     If the digits is null.
     * @since 1.0.0
     */
    protected boolean checkMod(int[] digits) throws IllegalArgumentException, NullPointerException {
        if (digits == null) {
            throw new NullPointerException("Digits can not be null.");
        } else if (digits.length != length) {
            throw new IllegalArgumentException("Digits length must be " + length);
        }

        int result = 0;

        for (int i = 0, j = 2; i < length - 1; i++, j++) {
            result += (digits[i] * j);
        }

        result += (digits[length - 1] * 100);

        return result % 11 == 0;
    }
}