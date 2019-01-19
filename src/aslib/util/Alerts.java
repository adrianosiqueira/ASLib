package aslib.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 * <p> Contains an abstraction to create and manipulate dialog panes. </p>
 *
 * @author Adriano Siqueira
 * @version 2.0
 * @since 1.0
 */
public class Alerts {

    /**
     * <p> Create and show a dialog pane configured with the provided parameters. </p>
     *
     * @param type    Type of dialog box, depending on the type specified, some predefined settings can be set. If it is null, the default type will be used.
     * @param title   Title of dialog box. If it is null, the title will be empty.
     * @param header  Header of the dialog box. This content appears above the text content. If it is null, the header will be empty.
     * @param content Content of the dialog box.
     * @param buttons Vector with a custom selection of buttons. If it is null, the default selection will be used.
     * @param wait    TRUE: Execution is paused until the dialog box is closed. FALSE: Execution continues in parallel.
     * @return Button pressed.
     */
    public static ButtonType show(final Alert.AlertType type,
                                  final String title,
                                  final String header,
                                  final String content,
                                  final ButtonType[] buttons,
                                  final boolean wait) {
        Alert alert = new Alert(type != null ? type : Alert.AlertType.NONE);
        alert.setTitle(title != null ? title : "");
        alert.setHeaderText(header != null ? header : "");
        alert.setContentText(content != null ? content : "");
        alert.getDialogPane().setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        if (buttons != null) {
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(buttons);
        }

        if (wait) alert.showAndWait();
        else alert.show();

        return alert.getResult();
    }
}