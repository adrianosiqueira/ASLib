package aslib.javafx.filemanager;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Handles file opening operations through a graphical window. It follows the
 * builder design pattern to simplify its usage. This class can be used to
 * open a single or multi files, and directories as well.
 * </p>
 *
 * <p style="text-align:justify">
 * This class works creating and customizing an instance of either
 * {@link FileChooser} or {@link DirectoryChooser} according to what it will
 * open.
 * </p>
 *
 * <p style="text-align:justify">
 * <b>Sample use:</b>
 * </p>
 *
 * <pre>
 * Optional&lt;File&gt; file = FileOpener.single()
 *                                 .open();
 *
 *
 *
 * Optional&lt;File&gt; directory = FileOpener.directory()
 *                                      .open();
 *
 *
 *
 * FileOpener.single()
 *           .title("Select the music to play")
 *           .initialDirectory("/home/user/Music")
 *           .fileTypes(FileType.MUSIC)
 *           .open()
 *           .ifPresentOrElse(
 *               file -&gt; player.play(file),
 *               () -&gt; System.out.println("No file is selected.")
 *           );
 * </pre>
 *
 * <p style="text-align:justify">
 * <b>Caution:</b> This class must be used within a JavaFX thread.
 * </p>
 *
 * @param <R> The return type of the {@link FileOpener#open} method.
 *
 * @author Adriano Siqueira
 * @version 3.0.0
 * @since 1.0.0
 */
public class FileOpener<R> {

    private final Mode mode;

    private String     title;
    private String     initialDirectory;
    private String     initialFileName;
    private FileType[] fileTypes;
    private Stage      owner;


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileOpener} class.
     * </p>
     *
     * @param mode Determines the opening mode that the window will work.
     *
     * @throws IllegalThreadStateException If this class is used in a not
     *                                     JavaFX thread.
     * @since 3.0.0
     */
    private FileOpener(Mode mode)
    throws IllegalThreadStateException {
        if (isNotJavaFXThread())
            throw new IllegalThreadStateException("This class must be used within a JavaFX thread.");

        this.mode = mode;
    }


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileOpener} configured to open a single
     * directory. This implementation will use a {@link DirectoryChooser}.
     * </p>
     *
     * @return An instance of {@link FileOpener}.
     *
     * @throws IllegalThreadStateException If called from a not JavaFX thread.
     * @since 3.0.0
     */
    public static FileOpener<File> directory()
    throws IllegalThreadStateException {
        return new FileOpener<>(Mode.DIRECTORY);
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileOpener} configured to open multiple
     * files. This implementation will use a {@link FileChooser}.
     * </p>
     *
     * @return An instance of {@link FileOpener}.
     *
     * @throws IllegalThreadStateException If called from a not JavaFX thread.
     * @since 3.0.0
     */
    public static FileOpener<List<File>> multi()
    throws IllegalThreadStateException {
        return new FileOpener<>(Mode.MULTI);
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileOpener} configured to create a new
     * file, or replace an already existing one. It is suitable for getting a
     * file object that will be saved or written. This implementation will use
     * a {@link FileChooser}.
     * </p>
     *
     * @return An instance of {@link FileOpener}.
     *
     * @throws IllegalThreadStateException If called from a not JavaFX thread.
     * @since 3.0.0
     */
    public static FileOpener<File> save()
    throws IllegalThreadStateException {
        return new FileOpener<>(Mode.SAVE);
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileOpener} configured to open a single
     * file. This implementation will use a {@link FileChooser}.
     * </p>
     *
     * @return An instance of {@link FileOpener}.
     *
     * @throws IllegalThreadStateException If called from a not JavaFX thread.
     * @since 3.0.0
     */
    public static FileOpener<File> single()
    throws IllegalThreadStateException {
        return new FileOpener<>(Mode.SINGLE);
    }


    /**
     * <p style="text-align:justify">
     * Checks if this thread is NOT a JavaFX thread.
     * </p>
     *
     * @return TRUE if it is NOT a JavaFX thread.
     *
     * @since 3.0.0
     */
    private boolean isNotJavaFXThread() {
        return !Platform.isFxApplicationThread();
    }

    /**
     * <p style="text-align:justify">
     * Sets the file types that will be used to create the filters. Only the
     * file types defined here will be shown in the selection window.
     * </p>
     *
     * <p style="text-align:justify">
     * Has not effect when using the {@link FileOpener#directory}
     * implementation, but there is no problem using it anyway.
     * </p>
     *
     * <p style="text-align:justify">
     * If not defined, then all file types will be shown.
     * </p>
     *
     * @param fileTypes File type that will be shown in the selection window.
     *
     * @return Itself to allow call chaining.
     *
     * @since 3.0.0
     */
    public FileOpener<R> fileTypes(FileType... fileTypes) {
        this.fileTypes = fileTypes;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the directory where the window will open. It can use either
     * absolute or relative path, but the former is recommended.
     * </p>
     *
     * <p style="text-align:justify">
     * If not defined, then the user home folder will be used.
     * </p>
     *
     * @param initialDirectory Where the window will open.
     *
     * @return Itself to allow call chaining.
     *
     * @since 3.0.0
     */
    public FileOpener<R> initialDirectory(String initialDirectory) {
        this.initialDirectory = initialDirectory;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the file name that will be pre filled.
     * </p>
     *
     * <p style="text-align:justify">
     * Has not effect when using the {@link FileOpener#directory}
     * implementation, but there is no problem using it anyway.
     * </p>
     *
     * <p style="text-align:justify">
     * If not defined, then the name will be empty.
     * </p>
     *
     * @param initialFileName The name that will be pre filled.
     *
     * @return Itself to allow call chaining.
     *
     * @since 3.0.0
     */
    public FileOpener<R> initialFileName(String initialFileName) {
        this.initialFileName = initialFileName;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Opens the selection window.
     * </p>
     *
     * <p style="text-align:justify">
     * This method returns an {@link Optional} containing the selected file(s).
     * If the window is closed, or the <b>cancel</b> button is pressed, then
     * an {@link Optional#empty} will be returned.
     * </p>
     *
     * @return An {@link Optional} containing the selected file(s).
     *
     * @since 3.0.0
     */
    @SuppressWarnings("unchecked")
    public Optional<R> open() {
        switch (mode) {
            case DIRECTORY:
                return Optional.ofNullable((R) buildDirectoryChooser().showDialog(owner));
            case MULTI:
                return Optional.ofNullable((R) buildFileChooser().showOpenMultipleDialog(owner));
            case SAVE:
                return Optional.ofNullable((R) buildFileChooser().showSaveDialog(owner));
            case SINGLE:
                return Optional.ofNullable((R) buildFileChooser().showOpenDialog(owner));
            default:
                throw new RuntimeException("There is a problem with the mode.");
        }
    }

    /**
     * <p style="text-align:justify">
     * Sets owner window. When it is set, the parent window will be blocked
     * until the selection window is closed.
     * </p>
     *
     * <p style="text-align:justify">
     * If not defined, then the parent window will remain unblocked.
     * </p>
     *
     * @param owner The owner window.
     *
     * @return Itself to allow call chaining.
     *
     * @since 3.0.0
     */
    public FileOpener<R> owner(Stage owner) {
        this.owner = owner;
        return this;
    }

    /**
     * <p style="text-align:justify">
     * Sets the title of the selection window.
     * </p>
     *
     * <p style="text-align:justify">
     * If not defined, then the default one will be used.
     * </p>
     *
     * @param title Title of the selection window.
     *
     * @return Itself to allow call chaining.
     *
     * @since 3.0.0
     */
    public FileOpener<R> title(String title) {
        this.title = title;
        return this;
    }


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link DirectoryChooser} configured with the
     * provided attributes.
     * </p>
     *
     * @return An instance of {@link DirectoryChooser}.
     *
     * @since 3.0.0
     */
    private DirectoryChooser buildDirectoryChooser() {
        DirectoryChooser chooser = new DirectoryChooser();

        configureTitle(chooser);
        configureInitialDirectory(chooser);

        return chooser;
    }

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link FileChooser} configured with the provided
     * attributes.
     * </p>
     *
     * @return An instance of {@link FileChooser}.
     *
     * @since 3.0.0
     */
    private FileChooser buildFileChooser() {
        FileChooser chooser = new FileChooser();

        configureTitle(chooser);
        configureInitialFileName(chooser);
        configureInitialDirectory(chooser);
        configureExtensionFilters(chooser);

        return chooser;
    }

    /**
     * <p style="text-align:justify">
     * Configures the {@link ExtensionFilter} of the selection window.
     * </p>
     *
     * @param chooser Window that will be configured.
     *
     * @since 3.0.0
     */
    private void configureExtensionFilters(FileChooser chooser) {
        ObservableList<ExtensionFilter> filters = chooser.getExtensionFilters();

        Optional.ofNullable(fileTypes)
                .stream()
                .flatMap(Stream::of)
                .filter(Objects::nonNull)
                .distinct()
                .map(FileType::getFilter)
                .forEach(filters::add);

        if (filters.isEmpty())
            loadAllFilters(filters);
    }

    /**
     * <p style="text-align:justify">
     * Configures the initial directory of the selection window.
     * </p>
     *
     * @param chooser Window that will be configured.
     *
     * @since 3.0.0
     */
    private void configureInitialDirectory(DirectoryChooser chooser) {
        Runnable homeDirectorySetter = () -> {
            File homeDirectory = new File(System.getProperty("user.home"));
            chooser.setInitialDirectory(homeDirectory);
        };

        Optional.ofNullable(initialDirectory)
                .map(File::new)
                .ifPresentOrElse(chooser::setInitialDirectory, homeDirectorySetter);
    }

    /**
     * <p style="text-align:justify">
     * Configures the initial directory of the selection window.
     * </p>
     *
     * @param chooser Window that will be configured.
     *
     * @since 3.0.0
     */
    private void configureInitialDirectory(FileChooser chooser) {
        Runnable homeDirectorySetter = () -> {
            File homeDirectory = new File(System.getProperty("user.home"));
            chooser.setInitialDirectory(homeDirectory);
        };

        Optional.ofNullable(initialDirectory)
                .map(File::new)
                .ifPresentOrElse(chooser::setInitialDirectory, homeDirectorySetter);
    }

    /**
     * <p style="text-align:justify">
     * Configures the initial file name of the selection window.
     * </p>
     *
     * @param chooser Window that will be configured.
     *
     * @since 3.0.0
     */
    private void configureInitialFileName(FileChooser chooser) {
        chooser.setInitialFileName(initialFileName);
    }

    /**
     * <p style="text-align:justify">
     * Configures the title of the selection window.
     * </p>
     *
     * @param chooser Window that will be configured.
     *
     * @since 3.0.0
     */
    private void configureTitle(DirectoryChooser chooser) {
        Runnable defaultTitleSetter = () -> chooser.setTitle(mode.title);

        Optional.ofNullable(title)
                .ifPresentOrElse(chooser::setTitle, defaultTitleSetter);
    }

    /**
     * <p style="text-align:justify">
     * Configures the title of the selection window.
     * </p>
     *
     * @param chooser Window that will be configured.
     *
     * @since 3.0.0
     */
    private void configureTitle(FileChooser chooser) {
        Runnable defaultTitleSetter = () -> chooser.setTitle(mode.title);

        Optional.ofNullable(title)
                .ifPresentOrElse(chooser::setTitle, defaultTitleSetter);
    }

    /**
     * <p style="text-align:justify">
     * Creates a {@link ExtensionFilter} from the {@link FileType#ALL}
     * and adds it to the filters list.
     * </p>
     *
     * @param filters List of filters of the window.
     *
     * @since 3.0.0
     */
    private void loadAllFilters(ObservableList<ExtensionFilter> filters) {
        Stream.of(FileType.values())
              .map(FileType::getFilter)
              .forEach(filters::add);
    }


    /**
     * <p style="text-align:justify">
     * Operating mode of the {@link FileOpener} class. It is defined
     * automatically through the entry points of the class.
     * </p>
     *
     * @author Adriano Siqueira
     * @version 1.0.0
     * @since 3.0.0
     */
    private enum Mode {

        /**
         * <p style="text-align:justify">
         * Configures the {@link FileOpener} class to open a directory.
         * </p>
         *
         * @since 1.0.0
         */
        DIRECTORY("Select the directory to open"),

        /**
         * <p style="text-align:justify">
         * Configures the {@link FileOpener} class to open multiple files.
         * </p>
         *
         * @since 1.0.0
         */
        MULTI("Select the files to open"),

        /**
         * <p style="text-align:justify">
         * Configures the {@link FileOpener} class to open a file to save.
         * </p>
         *
         * @since 1.0.0
         */
        SAVE("Select the file to save"),

        /**
         * <p style="text-align:justify">
         * Configures the {@link FileOpener} class to open a single file.
         * </p>
         *
         * @since 1.0.0
         */
        SINGLE("Select the file to open");


        /**
         * <p style="text-align:justify">
         * Default title of the selection window.
         * </p>
         *
         * @since 1.0.0
         */
        public final String title;


        /**
         * <p style="text-align:justify">
         * Creates an instance of {@link Mode}.
         * </p>
         *
         * @param title Default title of the selection window.
         *
         * @since 1.0.0
         */
        Mode(String title) {
            this.title = title;
        }
    }
}
