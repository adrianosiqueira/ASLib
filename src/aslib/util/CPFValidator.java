package aslib.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Contains the function to validate CPF. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class CPFValidator {
    private static final int CPF_LENGTH = 11;

    private String cpf;

    private int[] digits;
    private List<String> invalidCPF;

    /**
     * <p> Initializes the fields with default values. </p>
     *
     * <p> It is necessary to call setCPF method, otherwise the validate
     * function will throw a nullpointerexception. </p>
     */
    public CPFValidator() {
        this.digits = new int[CPF_LENGTH];
        this.invalidCPF = new ArrayList<>();

        for (int i = 0; i <= 9; ++i) {
            String s = String.valueOf(i);
            this.invalidCPF.add(s + s + s + s + s + s + s + s + s + s + s);
        }
    }

    /**
     * <p> Creates an instance of {@link CPFValidator} class. </p>
     *
     * @param cpf CPF to ba checked.
     */
    public CPFValidator(String cpf) {
        this();
        setCpf(cpf);
    }

    /**
     * <p> Runs the validation methods. </p>
     *
     * @return [ T ] If cpf is valid <br> [ F ] otherwise.
     */
    public boolean validate() {
        if (cpf == null)
            throw new NullPointerException("CPF not initialized.");
        else if (cpf.length() != CPF_LENGTH)
            return false;
        else if (invalidCPF.contains(cpf))
            return false;

        for (int i = 0; i < CPF_LENGTH; ++i) {
            if (Character.isDigit(cpf.charAt(i)))
                digits[i] = Character.getNumericValue(cpf.charAt(i));
            else
                return false;
        }

        return checkVerificationDigits() && checkSumDigits();
    }

    /**
     * <p> Performs the first verification sequence. </p>
     *
     * @return [ T ] If cpf pass in the test <br> [ F ] Otherwise.
     */
    private boolean checkVerificationDigits() {
        int initial1 = 10;
        int initial2 = 11;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 9; ++i) {
            sum1 += digits[i] * initial1;
            --initial1;
        }

        for (int i = 0; i < 10; ++i) {
            sum2 += digits[i] * initial2;
            --initial2;
        }

        return (sum1 * 10) % 11 == digits[9] &&
                (sum2 * 10) % 11 == digits[10];
    }

    /**
     * <p> Performs the second verification sequence. </p>
     *
     * @return [ T ] If cpf pass int the test <br> [ F ] Otherwise
     */
    private boolean checkSumDigits() {
        int sum = 0;

        for (int digit : digits)
            sum += digit;

        String string = String.valueOf(sum);
        return string.charAt(0) == string.charAt(1);
    }

    /**
     * <p> Sets the cpf number. </p>
     *
     * <p> All redundant characters will be removed </p>
     *
     * @param cpf CPF to be seted up.
     */
    public void setCpf(String cpf) {
        if (cpf != null) {
            this.cpf = cpf.replaceAll("\\.", "");
            this.cpf = this.cpf.replaceAll("-", "");
            this.cpf = this.cpf.replaceAll("/", "");
        }
    }
}
