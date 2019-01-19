package aslib.fx.control;

import aslib.exceptions.InvalidClassException;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * <p> An custom {@link TextField} made to handle numbers only. </p>
 *
 * <h3> Type of Data &lt;T&gt; </h3>
 * <p> Must be one of the wrap classes that works with numbers. </p>
 * <ul>
 * <li>{@link Byte}</li>
 * <li>{@link Short}</li>
 * <li>{@link Integer}</li>
 * <li>{@link Long}</li>
 * <li>{@link Float}</li>
 * <li>{@link Double}</li>
 * </ul>
 *
 * @param <T> Type of data that {@link NumberField} will work with.
 * @author Adriano Siqueira
 * @version 1.1
 * @since 4.2
 */
public class NumberField<T> extends TextField {
    private Class<T> tClass;
    private boolean point;

    /**
     * <p> Creates an instance of {@link NumberField}. </p>
     *
     * @param tClass Number class that {@link NumberField} will work with. More details {@link NumberField here}.
     */
    public NumberField(Class<T> tClass) {
        this.tClass = tClass;
        checkGeneric();
        configureBehavior();
    }

    /**
     * <p> Checks if generic is a valid number class. </p>
     *
     * @throws InvalidClassException If the class is not of a valid number class type.
     */
    private void checkGeneric() throws InvalidClassException {
        if (tClass != Byte.class &&
                tClass != Short.class &&
                tClass != Integer.class &&
                tClass != Long.class &&
                tClass != Float.class &&
                tClass != Double.class)
            throw new InvalidClassException("The generic class must be of a numeric type.");
    }

    /**
     * <p> Configures the behavior of {@link NumberField}. </p>
     */
    private void configureBehavior() {
        setTextFormatter(new TextFormatter<>(change -> {
            switch (change.getText()) {
                case "":
                    return change;
                case "-":
                    if (!getText().contains("-")) {
                        if (change.getControlNewText().charAt(0) == '-') return change;
                        else return null;
                    } else return null;

                case ".":
                    if (tClass == Float.class || tClass == Double.class) return point ? null : change;
                    else return null;
                default:
                    return change.getText().matches("[\\d]")
                            ? change
                            : null;
            }
        }));

        textProperty().addListener((observable, oldValue, newValue) -> point = newValue.contains("."));
        point = false;
    }
}