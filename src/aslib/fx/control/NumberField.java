package aslib.fx.control;

import aslib.util.NumericType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * <p> An custom {@link TextField} made to handle numbers only. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 4.2
 */
public class NumberField extends TextField {
    private Class numericClass;
    private boolean point = false;

    /**
     * <p> Creates an instance of {@link NumberField}. </p>
     *
     * @param type Number type that {@link NumberField} will work with.
     */
    public NumberField(NumericType type) throws NullPointerException {
        if (type != null) {
            numericClass = type.numericClass;
            configureBehavior();
        } else throw new NullPointerException("Type can not be null.");
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
                    if (numericClass == Float.class || numericClass == Double.class)
                        return point ? null : change;
                    else return null;
                default:
                    return change.getText().matches("[\\d]")
                            ? change
                            : null;
            }
        }));

        textProperty().addListener((observable, oldValue, newValue) -> point = newValue.contains("."));
    }
}