package aslib.fx.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 * <p> Abstracts the creation of objects of type Alert. </p>
 *
 * @author Adriano Siqueira
 * @version 3.0
 * @since 2.0
 */
public class Alerts {
    private Alert.AlertType type;
    private String title;
    private String header;
    private String content;
    private ButtonType[] buttons;

    /**
     * <p> Creates an instance of {@link Alerts} class. </p>
     *
     * <p> The header of dialog will be empty and the default buttons selection
     * will be used. </p>
     *
     * @param type    Type of the message.
     * @param title   Title of the dialog.
     * @param content Content of the dialog.
     */
    public Alerts(Alert.AlertType type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }

    /**
     * <p> Creates an instance of {@link Alerts} class. </p>
     *
     * <p> The default buttons selection will be used. </p>
     *
     * @param type    Type of the message.
     * @param title   Title of the dialog.
     * @param header  Header of the dialog, shown above of content.
     * @param content Content of the dialog.
     */
    public Alerts(Alert.AlertType type, String title, String header, String content) {
        this(type, title, content);
        this.header = header;
    }

    /**
     * <p> Creates an instance of {@link Alerts} class. </p>
     *
     * @param type    Type of the message.
     * @param title   Title of the dialog.
     * @param header  Header of the dialog, shown above of content.
     * @param content Content of the dialog.
     * @param buttons Buttons that will be present in the dialog.
     */
    public Alerts(Alert.AlertType type, String title, String header, String content, ButtonType[] buttons) {
        this(type, title, header, content);
        this.buttons = buttons;
    }

    /**
     * <p> Shows the dialog. As this dialog is show in background, the result
     * value is not caught. </p>
     */
    public void show() {
        Alert alert = getAlert();
        alert.show();
    }

    /**
     * <p> Shows the dialog and pauses the execution. </p>
     *
     * @return The pressed button.
     */
    public ButtonType showAndWait() {
        Alert alert = getAlert();
        alert.showAndWait();
        return alert.getResult();
    }

    /**
     * <p> Creates an {@link Alert} object with the provided information. </p>
     *
     * @return A complete alert ready to be used.
     */
    private Alert getAlert() {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        if (buttons != null) {
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(buttons);
        }

        alert.getDialogPane().setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        return alert;
    }
}
