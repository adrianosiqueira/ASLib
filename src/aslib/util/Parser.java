package aslib.util;

/**
 * <p> Generalizes the parser classes. </p>
 *
 * @param <T> Type of object that the implementation class will work with.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 8.0.0
 */
public interface Parser<T> {
    T fromString(String s);

    String toString(T t);
}
