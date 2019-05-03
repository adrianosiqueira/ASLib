package aslib.security;

import aslib.exceptions.InvalidEnumSearchArgumentException;

/**
 * <p> Contains the hash options with their names and unique lengths. </p>
 *
 * <h2> Names and lengths </h2>
 * <table style="width:120px" summary="">
 * <tr>
 * <th> Name </th>
 * <th> Length </th>
 * </tr>
 * <tr>
 * <td> MD5 </td>
 * <td> 32 </td>
 * </tr><tr>
 * <td> SHA-1 </td>
 * <td> 40 </td>
 * </tr><tr>
 * <td> SHA-224 </td>
 * <td> 56 </td>
 * </tr><tr>
 * <td> SHA-256 </td>
 * <td> 64 </td>
 * </tr><tr>
 * <td> SHA-384 </td>
 * <td> 96 </td>
 * </tr><tr>
 * <td> SHA-512 </td>
 * <td> 128 </td>
 * </tr>
 * </table>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.1
 */
public enum SHAType {
    MD5("MD5", 32),
    SHA1("SHA-1", 40),
    SHA224("SHA-224", 56),
    SHA256("SHA-256", 64),
    SHA384("SHA-384", 96),
    SHA512("SHA-512", 128);

    public final String name;
    public final int length;

    SHAType(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * <p> Every hash name has a unique length of bytes that are generated.
     * It works like a finger print, so it is possible to use that length value
     * to search by an name.</p>
     *
     * @param length The length of the name to search.
     * @return The name that its length matches the argument.
     * @throws InvalidEnumSearchArgumentException If the length does not match wth the optionn of the enum.
     */
    public static SHAType getByLength(int length) throws InvalidEnumSearchArgumentException {
        for (SHAType value : values())
            if (value.length == length)
                return value;

        throw new InvalidEnumSearchArgumentException("Length value does not exists.");
    }
}
