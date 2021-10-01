package aslib.util;

/**
 * <p> Generalizes the parser classes. </p>
 *
 * @param <T> Type of object that the implementation class will work with.
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 8.0.0
 * @deprecated Use {@link aslib.future.util.BiParsable} instead.
 */
@Deprecated
public interface Parser<T> {
    T fromString(String s);

    String toString(T t);
}
