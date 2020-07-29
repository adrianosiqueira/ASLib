package aslib.fx.util;

import javafx.scene.control.Alert;

/**
 * <p> Provides an easy way to create dialog boxes to show messages. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public class MessageDialog extends Alert {

    /**
     * <p> Configures the dialog with the type. All other attributes will be
     * set to null. </p>
     *
     * @param alertType Type of the dialog.
     *
     * @since 1.0.0
     */
    public MessageDialog(AlertType alertType) {
        this(alertType, null, null, null);
    }

    /**
     * <p> Configures the dialog with the type and the content text. All other
     * attributes will be set to null. </p>
     *
     * @param alertType Type of the dialog.
     * @param content   Content text of the dialog.
     *
     * @since 1.0.0
     */
    public MessageDialog(AlertType alertType, String content) {
        this(alertType, null, null, content);
    }

    /**
     * <p> Configures the dialog with the type, title and content text. The
     * header attribute will be set to null. </p>
     *
     * @param alertType Type of the dialog.
     * @param title     Title text of the dialog.
     * @param content   Content text of the dialog.
     *
     * @since 1.0.0
     */
    public MessageDialog(AlertType alertType, String title, String content) {
        this(alertType, title, null, content);
    }

    /**
     * <p> Configures the dialog with all the attributes. </p>
     *
     * @param alertType Type of the dialog.
     * @param title     Title text of the dialog.
     * @param header    Header text of the dialog.
     * @param content   Content text of the dialog.
     *
     * @since 1.0.0
     */
    public MessageDialog(AlertType alertType, String title, String header, String content) {
        super(alertType != null ? alertType : AlertType.INFORMATION);
        this.setTitle(title);
        this.setHeaderText(header);
        this.setContentText(content);
    }
}
