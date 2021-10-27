package aslib.fx.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>Class designed to create stack trace dialogs using the builder design
 * pattern. It creates an object of class {@link Alert} modified and configured
 * according to the parameters provided.</p>
 *
 * <p>By default it will create an error dialog unless an {@link Alert.AlertType}
 * is provided.</p>
 *
 * <p>If no {@link Throwable} is defined, no content will be shown.</p>
 *
 * <p>This class needs to be called from a javafx thread.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class StackTraceDialogBuilder implements Builder<Alert> {

    private Alert.AlertType alertType = Alert.AlertType.ERROR;

    private String title      = "";
    private String headerText = "";

    private Throwable throwable = null;

    private Image headerIcon = null;
    private Image favIcon    = null;

    private ButtonType[] buttons = null;

    private double  width     = 0.0;
    private double  height    = 0.0;
    private boolean resizable = true;


    /**
     * <p>Sets the {@link Alert.AlertType} property used by the {@link Alert}
     * class. This property is responsible for the initial configuration of the
     * dialog.</p>
     *
     * @param alertType Property to be set. It will be ignored if null.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setAlertType(Alert.AlertType alertType) {
        if (alertType != null)
            this.alertType = alertType;

        return this;
    }

    /**
     * <p>Sets the dialog box buttons.</p>
     *
     * <p>If the vector is null, it will be ignored. Null elements will be removed.
     * If no valid button remains, the default selection will be used.</p>
     *
     * @param buttons Buttons to be set. Not null.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setButtons(ButtonType... buttons) {
        Optional.ofNullable(buttons)
                .ifPresent(buttonsT -> this.buttons = Arrays.stream(buttonsT)
                                                            .filter(Objects::nonNull)
                                                            .toArray(ButtonType[]::new));

        return this;
    }

    /**
     * <p>Sets the icon in the dialog window and the taskbar. This icon may not
     * appear depending on your desktop environment.</p>
     *
     * <p>If null, no icon will be displayed.</p>
     *
     * @param favIcon Icon to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setFavIcon(Image favIcon) {
        this.favIcon = favIcon;
        return this;
    }

    /**
     * <p>Sets the dialog header icon. This icon replaces the default set by
     * {@link Alert.AlertType}.</p>
     *
     * <p>If null, the default icon will be used.</p>
     *
     * @param headerIcon Icon to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setHeaderIcon(Image headerIcon) {
        this.headerIcon = headerIcon;
        return this;
    }

    /**
     * <p>Sets the dialog header text. This text appears next to the icon, above
     * the content text.</p>
     *
     * <p>If null or empty, the header position becomes vertical. To maintain
     * the horizontal position, the text must have a blank character.</p>
     *
     * @param headerText Text to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setHeaderText(String headerText) {
        this.headerText = headerText;
        return this;
    }

    /**
     * <p>Sets the height of the dialog box. If it is less than or equal to zero,
     * the default size will be used.</p>
     *
     * @param height Height to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    /**
     * <p>Determines whether the dialog will be resizable.</p>
     *
     * @param resizable Property to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setResizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }

    /**
     * <p>Sets the {@link Throwable} from which the stack trace will be taken.
     * If null, no content will be displayed.</p>
     *
     * @param throwable Throwable to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    /**
     * <p>Sets the title text of the dialog window.</p>
     *
     * @param title Text to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <p>Sets the width of the dialog box. If it is less than or equal to zero,
     * the default size will be used.</p>
     *
     * @param width Width to be set.
     *
     * @return The instance itself.
     *
     * @since 1.0.0
     */
    public StackTraceDialogBuilder setWidth(double width) {
        this.width = width;
        return this;
    }


    /**
     * <p>Builds the modified object of {@link Alert} class using the parameters
     * provided.</p>
     *
     * @return A non-null object.
     *
     * @since 1.0.0
     */
    @Override
    public Alert build() {
        Alert alert = new Alert(alertType);

        alert.setTitle(title);
        alert.setHeaderText(headerText);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        if (throwable != null) {
            StringWriter writer = new StringWriter();
            throwable.printStackTrace(new PrintWriter(writer));
            textArea.setText(writer.toString());
        }

        if (headerIcon != null) {
            alert.setGraphic(new ImageView(headerIcon));
        }

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setContent(textArea);

        if (buttons != null && buttons.length > 0) {
            dialogPane.getButtonTypes()
                      .setAll(buttons);
        }

        if (favIcon != null) {
            Stage stage = (Stage) dialogPane.getScene()
                                            .getWindow();
            stage.getIcons()
                 .setAll(favIcon);
        }

        dialogPane.setPrefWidth(width > 0 ? width : Region.USE_COMPUTED_SIZE);
        dialogPane.setPrefHeight(height > 0 ? height : Region.USE_COMPUTED_SIZE);
        alert.setResizable(resizable);

        return alert;
    }
}
