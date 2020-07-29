package aslib.fx.util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/**
 * <p> Provides an easy way to create dialog boxes to show StackTraces. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public class StackTraceDialog extends Alert {
    private final Exception exception;

    /**
     * <p> Configures the dialog with the type and exception. All other
     * attributes will be set to null. </p>
     *
     * @param alertType Type of the dialog.
     * @param exception Exception where the StackTrace will be obtained.
     *
     * @since 1.0.0
     */
    public StackTraceDialog(AlertType alertType, Exception exception) {
        this(alertType, null, null, exception);
    }

    /**
     * <p> Configures the dialog with the type, title and exception. Header
     * attribute will be set to null. </p>
     *
     * @param alertType Type of the dialog.
     * @param title     Title text of the dialog.
     * @param exception Exception where the StackTrace will be obtained.
     *
     * @since 1.0.0
     */
    public StackTraceDialog(AlertType alertType, String title, Exception exception) {
        this(alertType, title, null, exception);
    }

    /**
     * <p> Configures the dialog with all the attributes. </p>
     *
     * @param alertType Type of the dialog.
     * @param title     Title text of the dialog.
     * @param header    Header text of the dialog.
     * @param exception Exception where the StackTrace will be obtained.
     *
     * @throws NullPointerException If the exception is null.
     * @since 1.0.0
     */
    public StackTraceDialog(AlertType alertType, String title, String header, Exception exception)
            throws NullPointerException {
        super(alertType != null ? alertType : AlertType.ERROR);
        this.setTitle(title);
        this.setHeaderText(header);
        this.exception = Objects.requireNonNull(exception, "Exception can not be null.");

        configure();
    }

    /**
     * <p> Adapts the dialog to show the StackTrace content. </p>
     *
     * @since 1.0.0
     */
    private void configure() {
        StringWriter writer = new StringWriter();
        exception.printStackTrace(new PrintWriter(writer));

        final TextArea area = new TextArea(writer.toString());
        area.setEditable(false);

        this.getDialogPane().setContent(area);
    }
}
