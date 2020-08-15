package aslib.util;

import java.util.Objects;

/**
 * <p> Handles the operations involving Voter Registration, such as formatting,
 * generating and validating. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public abstract class VoterRegistrationUtils extends DocumentUtils {

    /**
     * <p> Provides basic validation. It ignores all non-numeric characters and
     * <b> does not </b> ensures that the Voter Registration is mathematically
     * valid. </p>
     *
     * @since 1.0.0
     */
    public static final VoterRegistrationUtils BASIC = new VoterRegistrationUtils() {
        @Override
        public boolean isValid(String registration) {
            Objects.requireNonNull(registration, "Registration can not be null.");
            registration = removeNonNumericCharacter(registration);

            return registration.length() == length && !isSameDigits(registration);
        }
    };

    /**
     * <p> Provides full validation. It ignores separators and ensures that the
     * Voter Registration is mathematically valid. It is the ideal option to use. </p>
     *
     * @since 1.0.0
     */
    public static final VoterRegistrationUtils PERMISSIVE = new VoterRegistrationUtils() {
        @Override
        public boolean isValid(String registration) {
            Objects.requireNonNull(registration, "Registration can not be null.");
            registration = removeSeparator(registration);

            if (!registration.matches(regexWithoutSeparator) ||
                    isSameDigits(registration)) {
                return false;
            }

            int[] digits = getDigits(registration);
            int[] verification = calculateVerification(digits);

            boolean checkDigit = registration.endsWith(getDigits(verification));
            boolean fu = checkFU(digits);

            return checkDigit && fu;
        }
    };

    /**
     * <p> Provides full validation. It ignore nothing. The validation is only
     * successful if the Voter Registration is mathematically valid and has the
     * correct formatting. </p>
     *
     * @since 1.0.0
     */
    public static final VoterRegistrationUtils STRICT = new VoterRegistrationUtils() {
        @Override
        public boolean isValid(String registration) {
            Objects.requireNonNull(registration, "Registration can not be null.");

            return registration.matches(regexWithSeparator) &&
                    PERMISSIVE.isValid(registration);
        }
    };


    /**
     * <p> Fills the attributes and prevents this class to be instantiated. </p>
     *
     * @since 1.0.0
     */
    private VoterRegistrationUtils() {
        super(12, "\\d{4} \\d{4} \\d{4}");
    }


    @Override
    public String format(String registration) {
        Objects.requireNonNull(registration, "Registration can not be null.");
        registration = removeNonNumericCharacter(registration);

        StringBuilder result = new StringBuilder(registration);

        while (result.length() < length) {
            result.insert(0, "0");
        }

        while (result.length() > length) {
            result.deleteCharAt(result.length() - 1);
        }

        // 1111 1111 1111
        // 012345678901234567890

        return result.insert(4, " ")
                .insert(9, " ")
                .toString();
    }

    @Override
    public String generate() {
        int[] digits;
        int[] fu;
        int[] verification;

        String result;

        do {
            digits = generateRandomDigits(length - 4);
            fu = generateRandomDigits(2);
            digits = getDigits(digits, fu);
            verification = calculateVerification(digits);

            digits = getDigits(digits, verification);
            result = getDigits(digits);
        } while (!PERMISSIVE.isValid(result));

        return format(result);
    }


    /**
     * <p> Calculates the verification digits of the Voter Registration. </p>
     *
     * @param digits The digits of the Voter Registration. It may or may not contain the verification digits.
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

        for (int i = 0, j = 2; i < length - 4; i++, j++) {
            temp += (digits[i] * j);
        }

        temp = temp % 11;
        result[0] = (temp != 10) ? temp : 0;
        temp = 0;

        for (int i = 8, j = 7; i < length - 2; i++, j++) {
            temp += (digits[i] * j);
        }

        temp += (result[0] * 9);
        temp = temp % 11;
        result[1] = (temp != 10) ? temp : 0;

        return result;
    }

    /**
     * <p> Checks the Federal Unit of the document. </p>
     *
     * @param digits The digits of the Voter Registration.
     *
     * @return TRUE if the sum is correct. FALSE otherwise.
     *
     * @throws IllegalArgumentException If the length of the digits is invalid.
     * @throws NullPointerException     If the digits is null.
     * @since 1.0.0
     */
    protected boolean checkFU(int[] digits) throws IllegalArgumentException, NullPointerException {
        if (digits == null) {
            throw new NullPointerException("Digits can not be null.");
        } else if (digits.length != length) {
            throw new IllegalArgumentException("Digits length must be " + length);
        }

        int result = (digits[8] * 10) + digits[9];

        return result >= 1 && result <= 28;
    }
}