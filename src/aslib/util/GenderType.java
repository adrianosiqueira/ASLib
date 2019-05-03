package aslib.util;

import aslib.exceptions.InvalidEnumSearchArgumentException;

/**
 * <p> Contains the options to represent the code of a person. </p>
 *
 * <h2> Codes </h2>
 * <table style="width:120px" summary="">
 * <tr>
 * <th> Type </th>
 * <th> Code </th>
 * </tr>
 * <tr>
 * <td> Invalid </td>
 * <td> -1 </td>
 * </tr>
 * <tr>
 * <td> Undefined </td>
 * <td> 0 </td>
 * </tr>
 * <tr>
 * <td> Feminine </td>
 * <td> 1 </td>
 * </tr>
 * <tr>
 * <td> Masculine </td>
 * <td> 2 </td>
 * </tr>
 * <tr>
 * <td> Lesbian </td>
 * <td> 3 </td>
 * </tr>
 * <tr>
 * <td> Gay </td>
 * <td> 4 </td>
 * </tr>
 * <tr>
 * <td> Transgender </td>
 * <td> 5 </td>
 * </tr>
 * </table>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.0
 */
public enum GenderType {
    INVALID(-1),
    UNDEFINED(0),
    FEMININE(1),
    MASCULINE(2),
    LESBIAN(3),
    GAY(4),
    TRANSGENDER(5);

    public final int code;

    GenderType(int code) {
        this.code = code;
    }

    /**
     * <p> Search for the option whose code matches the argument. </p>
     *
     * @param code Code to return as an option of enum.
     * @return The enum option that matches the code.
     * @throws InvalidEnumSearchArgumentException If the code not exists.
     */
    public static GenderType getByCode(int code) throws InvalidEnumSearchArgumentException {
        for (GenderType value : values())
            if (value.code == code)
                return value;

        throw new InvalidEnumSearchArgumentException("The code provided is invalid!");
    }
}
