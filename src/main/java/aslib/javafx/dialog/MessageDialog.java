package aslib.javafx.dialog;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Acts as an interface to create and customize an instance of {@link Alert}.
 * It follows the builder design pattern for simplify its usage. This class can
 * be used to create message dialogs and stack trace dialogs as well.
 * </p>
 *
 * <p style="text-align:justify">
 * When a {@link Throwable} is provided, it automatically configures a hidden
 * content area containing its stack trace, that can be accessed through the
 * <b>Show details</b> button.
 * </p>
 *
 * <p style="text-align:justify">
 * The static methods of this class are the entry point to use it. They pre
 * configure the dialog according to the chosen theme: <b>blank</b>,
 * <b>confirmation</b>, <b>error</b>, <b>information</b> and <b>warning</b>.
 * </p>
 *
 * <p style="text-align:justify">
 * These themes pre configures the dialog with an icon, title and header text,
 * so if it is not provided, the default one will be used. It does not apply
 * for the {@link MessageDialog#blank} implementation.
 * </p>
 *
 * <p style="text-align:justify">
 * <b>Caution:</b> This class must be used within a JavaFX thread.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.1.0
 * @since 12.0.0
 */
public class MessageDialog {

    private AlertType alertType;

    private String    title;
    private String    headerText;
    private String    messageText;
    private Throwable throwable;

    private URL stylesheet;
    private URL favIcon;
    private URL headerIcon;

    private ButtonType[] buttons;

    private int      time;
    private TimeUnit timeUnit;

    private boolean resizable;
    private double  width;
    private double  height;

    private Runnable[] callbacks;

    /**
     * <p>
     * Creates an instance of {@link MessageDialog} .
     * </p>
     *
     * @param alertType The type of the {@link Alert} that will be generated.
     *
     * @throws IllegalStateException If this class is used in a not JavaFX
     *                               thread.
     * @since 1.0.0
     */
    private MessageDialog(AlertType alertType)
    throws IllegalStateException {
        if (!Platform.isFxApplicationThread())
            throw new IllegalStateException("This class must be used within a FX thread.");

        this.alertType = alertType;
    }


    /**
     * <p>
     * Creates a blank message dialog with no pre configuration.
     * </p>
     *
     * <p style="text-align:justify">
     * <b>Caution:</b> Using this approach requires attention, it will be
     * necessary to provide at least one button, otherwise it will not be
     * possible to close the dialog.
     * </p>
     *
     * @return An instance of {@link MessageDialog} with no pre configuration.
     *
     * @throws IllegalStateException If this class is used in a not JavaFX
     *                               thread.
     * @see AlertType#NONE
     * @since 1.0.0
     */
    public static MessageDialog blank()
    throws IllegalStateException {
        return new MessageDialog(AlertType.NONE);
    }

    /**
     * <p>
     * Creates a message dialog pre configured with a {@link ButtonType#CANCEL}
     * and {@link ButtonType#OK} buttons. Title and header text will display
     * "Confirmation" text. The icon will be a question mark.
     * </p>
     *
     * @return An instance of {@link MessageDialog} pre configured for a
     * confirmation prompt.
     *
     * @throws IllegalStateException If this class is used in a not JavaFX
     *                               thread.
     * @see AlertType#CONFIRMATION
     * @since 1.0.0
     */
    public static MessageDialog confirmation()
    throws IllegalStateException {
        return new MessageDialog(AlertType.CONFIRMATION);
    }

    /**
     * <p>
     * Creates a message dialog pre configured with a {@link ButtonType#OK}
     * button. Title and header text will display "Error" text. The icon will
     * be a cross mark.
     * </p>
     *
     * @return An instance of {@link MessageDialog} pre configured for a
     * error prompt.
     *
     * @throws IllegalStateException If this class is used in a not JavaFX
     *                               thread.
     * @see AlertType#ERROR
     * @since 1.0.0
     */
    public static MessageDialog error()
    throws IllegalStateException {
        return new MessageDialog(AlertType.ERROR);
    }

    /**
     * <p>
     * Creates a message dialog pre configured with a {@link ButtonType#OK}
     * button. Title and header text will display "Information" text. The icon
     * will be a information mark.
     * </p>
     *
     * @return An instance of {@link MessageDialog} pre configured for a
     * information prompt.
     *
     * @throws IllegalStateException If this class is used in a not JavaFX
     *                               thread.
     * @see AlertType#INFORMATION
     * @since 1.0.0
     */
    public static MessageDialog information()
    throws IllegalStateException {
        return new MessageDialog(AlertType.INFORMATION);
    }

    /**
     * <p>
     * Creates a message dialog pre configured with a {@link ButtonType#OK}
     * button. Title and header text will display "Warning" text. The icon will
     * be a exclamation mark.
     * </p>
     *
     * @return An instance of {@link MessageDialog} pre configured for a
     * warning prompt.
     *
     * @throws IllegalStateException If this class is used in a not JavaFX
     *                               thread.
     * @see AlertType#WARNING
     * @since 1.0.0
     */
    public static MessageDialog warning()
    throws IllegalStateException {
        return new MessageDialog(AlertType.WARNING);
    }


    /**
     * <p style="text-align:justify">
     * Sets the auto close timeout. The dialog will close automatically after
     * the specified time in the specified time unit If the time unit is null,
     * this feature will not work.
     * </p>
     *
     * @param time     Amount of time to wait before close the dialog.
     * @param timeUnit Unit of time to wait.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog autoClose(int time, TimeUnit timeUnit) {
        this.time     = time;
        this.timeUnit = timeUnit;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the buttons that will be used in the dialog. The buttons provided
     * will replace the default selection. Null buttons will be removed and if
     * no button remains, then the default selection will be used instead.
     * </p>
     *
     * @param buttons Buttons that will be used in the dialog.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog buttons(ButtonType... buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the callbacks that will run when the dialog is closed. These
     * runnables cannot access the dialog result. They will run independently
     * of how the dialog was closed.
     * </p>
     *
     * @param callbacks Callbacks that will run when the dialog is closed.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.1.0
     */
    public MessageDialog callbacks(Runnable... callbacks) {
        this.callbacks = callbacks;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the icon of the window title. This icon will appear in the task bar
     * too. If it is null, not found, or not provided, then no icon will be
     * displayed.
     * </p>
     *
     * @param favIcon Icon that will be used in title.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog favIcon(URL favIcon) {
        this.favIcon = favIcon;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the icon of the header area. This icon will replace the default one.
     * If it is null, not found, or not provided, then the default one will be
     * used.
     * </p>
     *
     * @param headerIcon Icon that will be used in the header area.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog headerIcon(URL headerIcon) {
        this.headerIcon = headerIcon;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the header text. This text will replace the default one. If it is a
     * white space, then no text will be shown. If it is null or not provided,
     * then the default one will be used. If it is an empty string, then the
     * icon will be placed on the left size.
     * </p>
     *
     * @param headerText Text of the header.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog headerText(String headerText) {
        this.headerText = headerText;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the message content text. If it is not provided, but the
     * {@link MessageDialog#throwable(Throwable) throwable} is present, then
     * the dialog will use the throwable {@link Throwable#getMessage message}
     * instead. If the throwable is not present, or does not have a message,
     * then no text will be shown.
     * </p>
     *
     * @param messageText Content of the message.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog messageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets whether the dialog will be resizable or not.
     * </p>
     *
     * @param resizable TRUE to make the dialog resizable.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog resizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Makes the dialog appear. This method does not wait for the dialog
     * closure, making the execution proceed normally while it is showing.
     * </p>
     *
     * @see Dialog#show
     * @since 1.0.0
     */
    public void show() {
        buildAlert().show();
    }

    /**
     * <p style="text-align:justify">
     * Makes the dialog appear. This method stops the execution until the
     * dialog closure.
     * </p>
     *
     * <p style="text-align:justify">
     * This method returns an {@link Optional} containing the clicked button.
     * If the dialog was closed without clicking in any button, then the
     * optional will be empty.
     * </p>
     *
     * @return An optional with the clicked button.
     *
     * @see Dialog#show
     * @since 1.0.0
     */
    public Optional<ButtonType> showAndWait() {
        return buildAlert().showAndWait();
    }

    /**
     * <p style="text-align:justify">
     * Sets the dialog preferred size. The dialog always will have a minimum of
     * 25% of the screen size. Even setting a value bellow that, the dialog
     * will keep its minimum size.
     * </p>
     *
     * <p style="text-align:justify">
     * The some value is zero, or this method is not called, then the size will
     * be defined by the platform.
     * </p>
     *
     * @param width  Width of the dialog.
     * @param height Height of the dialog.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog size(double width, double height) {
        this.width  = width;
        this.height = height;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the CSS stylesheet. If it is null, not found, or not provided, then
     * the dialog will use the platform default style.
     * </p>
     *
     * @param stylesheet Stylesheet to be used in the dialog.
     *
     * @return Itself to allow chaining calls.
     *
     * @see <a href="https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/doc-files/cssref.html#dialogpane">DialogPane CSS Reference</a>
     * @since 1.0.0
     */
    public MessageDialog stylesheet(URL stylesheet) {
        this.stylesheet = stylesheet;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the throwable object. When it is set, the dialog automatically
     * creates a hidden area where it will display the stack trace. This area
     * is accessible through the <b>Show details</b> button.
     * </p>
     *
     * <p style="text-align:justify">
     * If the message text is not provided, the dialog will use the throwable
     * {@link Throwable#getMessage message} instead. If the throwable does not
     * have a message, then no text will be shown.
     * </p>
     *
     * @param throwable Throwable from which the stack trace will be retrieved.
     *
     * @return Itself to allow chaining calls.
     *
     * @see <a href="https://openjfx.io/javadoc/11/javafx.controls/javafx/scene/control/DialogPane.html#expandableContentProperty">Expandable Content</a>
     * @since 1.0.0
     */
    public MessageDialog throwable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the title of the dialog. If it is null, then the default text from
     * theme will be used. If it is an empty string, then o text will be shown.
     * </p>
     *
     * @param title Title of the dialog window.
     *
     * @return Itself to allow chaining calls.
     *
     * @since 1.0.0
     */
    public MessageDialog title(String title) {
        this.title = title;
        return this;
    }


    /**
     * <p style="text-align:justify">
     * Creates the {@link Alert} instance customized with the provided
     * parameters.
     * </p>
     *
     * @return An Alert instance.
     *
     * @since 1.0.0
     */
    private Alert buildAlert() {
        Alert alert = new Alert(alertType);

        configureTitle(alert);
        configureHeaderText(alert);
        configureMessageText(alert);
        configureStackTraceArea(alert);
        configureButtons(alert);
        configureFavIcon(alert);
        configureHeaderIcon(alert);
        configureStylesheet(alert);
        configureSize(alert);
        configureAutoClose(alert);
        configureCallback(alert);

        return alert;
    }

    /**
     * <p style="text-align:justify">
     * Configures the auto close behavior. It creates a {@link Thread} that
     * will wait for the timeout before closing the dialog.
     * </p>
     *
     * @param alert Alert that will be closed.
     *
     * @since 1.0.0
     */
    private void configureAutoClose(Alert alert) {
        if (timeUnit == null) return;

        new Thread(() -> {
            try {
                timeUnit.sleep(time);
                Platform.runLater(alert::close);
            } catch (InterruptedException ignored) {}
        }).start();
    }

    /**
     * <p style="text-align:justify">
     * Replaces the default selection with the provided ones.
     * </p>
     *
     * @param alert Alert that will have the buttons replaced.
     *
     * @since 1.0.0
     */
    private void configureButtons(Alert alert) {
        if (buttons == null) return;

        buttons = Stream.of(buttons)
                        .filter(Objects::nonNull)
                        .toArray(ButtonType[]::new);

        if (buttons.length == 0) return;

        alert.getDialogPane()
             .getButtonTypes()
             .setAll(buttons);
    }

    /**
     * <p style="text-align:justify">
     * Schedules the callbacks to execute when the dialog is closed.
     * </p>
     *
     * @param alert Alert that will have the callbacks scheduled.
     *
     * @since 1.1.0
     */
    private void configureCallback(Alert alert) {
        if (callbacks == null) return;

        List<Runnable> runnables = Stream.of(callbacks)
                                         .filter(Objects::nonNull)
                                         .collect(Collectors.toList());

        alert.setOnHidden(e -> runnables.forEach(Runnable::run));
    }

    /**
     * <p style="text-align:justify">
     * Adds the icon on the dialog window.
     * </p>
     *
     * @param alert Alert from which the window instance will be retrieved.
     *
     * @since 1.0.0
     */
    private void configureFavIcon(Alert alert) {
        if (favIcon == null) return;

        Stage stage = (Stage) alert.getDialogPane()
                                   .getScene()
                                   .getWindow();

        stage.getIcons()
             .add(new Image(favIcon.toString()));
    }

    /**
     * <p style="text-align:justify">
     * Replaces the default header icon with the provided one.
     * </p>
     *
     * @param alert Alert where the icon will be added.
     *
     * @since 1.0.0
     */
    private void configureHeaderIcon(Alert alert) {
        if (headerIcon == null) return;

        ImageView headerView = new ImageView();
        headerView.setPreserveRatio(true);
        headerView.setFitWidth(48);
        headerView.setImage(new Image(headerIcon.toString()));

        alert.getDialogPane()
             .setGraphic(headerView);
    }

    /**
     * <p style="text-align:justify">
     * Replaces the default text with the provided one.
     * </p>
     *
     * @param alert Alert that will have the text replaced.
     *
     * @since 1.0.0
     */
    private void configureHeaderText(Alert alert) {
        if (headerText != null) {
            alert.setHeaderText(headerText);
        } else if (throwable != null) {
            alert.setHeaderText(throwable.getClass().getName());
        }
    }

    /**
     * <p style="text-align:justify">
     * Replaces the default text with the provided one.
     * </p>
     *
     * @param alert Alert that will have the text replaced.
     *
     * @since 1.0.0
     */
    private void configureMessageText(Alert alert) {
        if (messageText != null) {
            alert.setContentText(messageText);
        } else if (throwable != null) {
            alert.setContentText(throwable.getMessage());
        }
    }

    /**
     * <p style="text-align:justify">
     * Configures the size of the dialog.
     * </p>
     *
     * @param alert Alert that will have the size configured.
     *
     * @since 1.0.0
     */
    private void configureSize(Alert alert) {
        Rectangle2D screen    = Screen.getPrimary().getBounds();
        double      minWidth  = screen.getWidth() * 0.25;
        double      minHeight = screen.getHeight() * 0.25;

        alert.setResizable(true);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        if (width != 0.0 && height != 0.0) {
            dialogPane.setPrefSize(Math.max(width, minWidth), Math.max(height, minHeight));
        }

        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.setMinWidth(minWidth);
        stage.setMinHeight(minHeight);

        /*
         * Workaround for Alert class bug in Java 11 that causes window width
         * to be close to zero, not allowing content to be displayed. This
         * thread sets the user-defined resizable property value to override
         * the value used in fixing the bug.
         */
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
                Platform.runLater(() -> alert.setResizable(resizable));
            } catch (InterruptedException ignored) {}
        }).start();
    }

    /**
     * <p style="text-align:justify">
     * Configures the hidden stack trace area.
     * </p>
     *
     * @param alert Alert where the hidden area will be created.
     *
     * @since 1.0.0
     */
    private void configureStackTraceArea(Alert alert) {
        if (throwable == null) return;

        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setText(stringWriter.toString());

        alert.getDialogPane()
             .setExpandableContent(textArea);
    }

    /**
     * <p style="text-align:justify">
     * Adds the stylesheet to the dialog. The default one will not be replaced.
     * </p>
     *
     * @param alert Alert where the stylesheet will be added.
     *
     * @since 1.0.0
     */
    private void configureStylesheet(Alert alert) {
        if (stylesheet == null) return;

        alert.getDialogPane()
             .getStylesheets()
             .add(stylesheet.toString());
    }

    /**
     * <p style="text-align:justify">
     * Replaces the default text with the provided one.
     * </p>
     *
     * @param alert Alert that will have the text replaced.
     *
     * @since 1.0.0
     */
    private void configureTitle(Alert alert) {
        if (title != null) {
            alert.setTitle(title);
        } else {
            alert.setTitle(alertType.toString());
        }
    }
}
