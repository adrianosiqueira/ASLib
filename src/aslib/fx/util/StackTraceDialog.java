package aslib.fx.util;

import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p> Implements a dialog window, modified to display stack traces. </p>
 *
 * <p> This class was designed to be used in conjunction with the {@link Builder}
 * class. </p>
 *
 * <p> The width and height dimensions will be 50% of the useful area of the
 * screen, that is, the space of the taskbar and the menu bar is not considered. </p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 9.0.0
 */
public class StackTraceDialog extends Alert {

    /**
     * <p> Creates an {@link StackTraceDialog} instance with all the provided
     * attributes. </p>
     *
     * <p> The {@link javafx.scene.control.Alert.AlertType} is the only mandatory
     * attribute, all others can be set to null. The default value will be
     * assumed for each null attribute. </p>
     *
     * <p><b> Internal use only. </b></p>
     *
     * @param alertType  Type of the dialog.
     * @param title      Title of the window.
     * @param header     Header of the dialog.
     * @param throwable  Throwable to get the stack trace.
     * @param favIcon    Icon of the window.
     * @param headerIcon Icon of the header.
     * @param buttons    Buttons that will be used.
     *
     * @since 2.0.0
     */
    private StackTraceDialog(AlertType alertType,
                             String title,
                             String header,
                             Throwable throwable,
                             Image favIcon,
                             Image headerIcon,
                             ButtonType[] buttons) {
        super(alertType);

        this.setTitle(title);
        this.setHeaderText(header);

        TextArea area = new TextArea();
        area.setEditable(false);

        if (throwable != null) {
            StringWriter writer = new StringWriter();
            throwable.printStackTrace(new PrintWriter(writer));
            area.setText(writer.toString());
        }

        Rectangle2D screen = Screen.getPrimary()
                                   .getVisualBounds();

        DialogPane dialogPane = this.getDialogPane();
        dialogPane.setMinSize(screen.getWidth() * 0.5,
                              screen.getHeight() * 0.5);
        dialogPane.setContent(area);

        if (headerIcon != null) {
            ImageView imageView = new ImageView(headerIcon);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(64);
            dialogPane.setGraphic(imageView);
        }

        if (favIcon != null) {
            Stage stage = (Stage) dialogPane.getScene().getWindow();
            stage.getIcons().add(favIcon);
        }

        if (buttons != null && buttons.length > 0) {
            ObservableList<ButtonType> buttonList = this.getButtonTypes();
            buttonList.clear();
            buttonList.addAll(buttons);
        }
    }

    /**
     * <p> This class is used to create a {@link StackTraceDialog} object. </p>
     *
     * @author Adriano Siqueira
     * @version 1.0.0
     * @since 10.0.0
     */
    public static class Builder {

        private AlertType    alertType;
        private String       title;
        private String       header;
        private Throwable    throwable;
        private Image        favIcon;
        private Image        headerIcon;
        private ButtonType[] buttons;

        /**
         * <p> Creates a {@link Builder} instance. </p>
         *
         * <p> Since the {@link javafx.scene.control.Alert.AlertType} attribute
         * is mandatory, it is automatically initialized with
         * {@link javafx.scene.control.Alert.AlertType#ERROR}. </p>
         *
         * @since 1.0.0
         */
        public Builder() {
            this.alertType = AlertType.ERROR;
        }

        /**
         * <p> Sets the {@link javafx.scene.control.Alert.AlertType} of the
         * dialog. </p>
         *
         * <p> The AlertType is used to define the default header icon and
         * default button selection. </p>
         *
         * <p> Null value is not allowed, if it is, the current value will be
         * maintained. </p>
         *
         * @param alertType AlertType of the dialog. Not null.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder alertType(AlertType alertType) {
            if (alertType != null) {
                this.alertType = alertType;
            }

            return this;
        }

        /**
         * <p> Sets the text content of the window title. </p>
         *
         * <p> If it is null or empty, the title will simply not be displayed,
         * no errors or exceptions will be thrown. </p>
         *
         * @param title Text content of the window title.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * <p> Sets the text content of the header area. </p>
         *
         * <p> If it is null or empty, the header area will become a column
         * with only the icon. To remove the text and keep the area, a white
         * space must be provided. </p>
         *
         * @param header Text content of the header area.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder header(String header) {
            this.header = header;
            return this;
        }

        /**
         * <p> Sets the {@link Throwable} from which the stack trace will be
         * obtained. </p>
         *
         * <p> It supports {@link Exception}s and {@link Error}s. </p>
         *
         * <p> If the throwable is null, then the dialog content will be empty. </p>
         *
         * @param throwable Throwable to get the stack trace.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        /**
         * <p> Sets the icon that will appear in the corner of the window. </p>
         *
         * <p> The path of the {@link Image} object must be in an
         * {@link java.net.URI} format. Otherwise it will throw an exception. </p>
         *
         * <p> The {@link Image} will be automatically resized according to the
         * desktop environment. </p>
         *
         * <p> Not all desktop environments support this type of icon. If the
         * icon is not supported, it will simply not be displayed, no errors or
         * exceptions will be thrown. </p>
         *
         * @param favIcon Icon to place in the window corner.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder favIcon(Image favIcon) {
            this.favIcon = favIcon;
            return this;
        }

        /**
         * <p> Sets the icon that will appear in the header area. This icon
         * replaces the {@link javafx.scene.control.Alert.AlertType}'s default
         * if it is not null. </p>
         *
         * <p> The path of the {@link Image} object must be in an
         * {@link java.net.URI} format. Otherwise it will throw an exception. </p>
         *
         * <p> The {@link Image} will be resized to 64px with preserved ratio. </p>
         *
         * @param headerIcon Icon to place in the header area.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder headerIcon(Image headerIcon) {
            this.headerIcon = headerIcon;
            return this;
        }

        /**
         * <p> Sets the buttons that will appear in the dialog. </p>
         *
         * <p> All buttons must be non-null. If one is, then all buttons will
         * be ignored, making the array null. This will cause the default
         * selection to be used. </p>
         *
         * @param buttons Buttons to place in the dialog.
         *
         * @return The builder itself.
         *
         * @since 1.0.0
         */
        public Builder buttons(ButtonType... buttons) {
            for (ButtonType button : buttons) {
                if (button == null) {
                    return this;
                }
            }

            this.buttons = buttons;
            return this;
        }

        /**
         * <p> Creates the {@link StackTraceDialog} object using all the
         * attributes. </p>
         *
         * <p> This is a terminal method and terminates the builder's chained
         * calls. </p>
         *
         * @return The StackTraceDialog object.
         *
         * @since 1.0.0
         */
        public StackTraceDialog create() {
            return new StackTraceDialog(alertType,
                                        title,
                                        header,
                                        throwable,
                                        favIcon,
                                        headerIcon,
                                        buttons);
        }
    }
}