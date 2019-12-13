package aslib.fx.control;

import aslib.util.NumericType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.Objects;

/**
 * <p> An custom {@link TextField} made to handle numbers only. </p>
 *
 * @author Adriano Siqueira
 * @version 4.0.0
 * @since 4.2
 */
public class NumberField extends TextField {
    private NumericType type;
    private boolean point = false;

    /**
     * <p> Creates an instance of {@link NumberField}. </p>
     *
     * @param type Number type that {@link NumberField} will work with.
     */
    public NumberField(NumericType type) throws NullPointerException {
        this.type = Objects.requireNonNull(type, "Type can not be null.");
        configureBehavior();
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
                    if (type == NumericType.FLOAT || type == NumericType.DOUBLE)
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