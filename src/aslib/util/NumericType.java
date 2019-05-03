package aslib.util;

/**
 * <p> Contains the options for all numeric class in Java. </p>
 *
 * <table style="width:150px" summary="">
 * <tr>
 * <th> Type </th>
 * <th> Class </th>
 * </tr>
 * <tr>
 * <td> Byte </td>
 * <td> Byte.class </td>
 * </tr>
 * <tr>
 * <td> Short </td>
 * <td> Short.class </td>
 * </tr><tr>
 * <td> Integer </td>
 * <td> Integer.class </td>
 * </tr><tr>
 * <td> Long </td>
 * <td> Long.class </td>
 * </tr><tr>
 * <td> Float </td>
 * <td> Float.class </td>
 * </tr><tr>
 * <td> Double </td>
 * <td> Double.class </td>
 * </tr>
 * </table>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public enum NumericType {
    BYTE(Byte.class),
    SHORT(Short.class),
    INTEGER(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class);

    public final Class numericClass;

    NumericType(Class numericClass) {
        this.numericClass = numericClass;
    }
}
