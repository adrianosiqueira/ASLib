package aslib.filemanager;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

/**
 * <p> Contains the functions to open a single or more files or a a single
 * directory. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 1.0
 */
public class Opener {
    private String title;
    private File initialDirectory;
    private FileExtension[] extensions;
    private Stage stage;

    /**
     * <p> Uses the class' name as title, sets the user home folder as initial
     * directory and uses {@code FileExtension.ALL} as file filter. </p>
     */
    public Opener() {
        this(Opener.class.getSimpleName());
    }

    /**
     * <p> Sets the user home folder as initial directory and uses
     * {@code FileExtension.ALL} as file filter. </p>
     *
     * @param title Title of the dialog window.
     */
    public Opener(String title) {
        this(title, new File(System.getProperty("user.home")));
    }

    /**
     * <p> Uses {@code FileExtension.ALL} as file filter. </p>
     *
     * @param title            Title of the dialog window.
     * @param initialDirectory Directory where dialog will start in.
     */
    public Opener(String title, File initialDirectory) {
        this(title, initialDirectory, FileExtension.ALL);
    }

    /**
     * <p> Creates an instance of {@link Opener} class. </p>
     *
     * @param title            Title of the dialog window.
     * @param initialDirectory Directory where dialog will start in.
     * @param extensions       Filters to be used by the dialog.
     */
    public Opener(String title, File initialDirectory, FileExtension... extensions) {
        this.title = title;
        this.initialDirectory = initialDirectory;
        this.extensions = extensions;

        this.stage = new Stage();
        this.stage.show();
        this.stage.close();
    }

    /**
     * <p> Open a single directory. </p>
     *
     * @return Selected directory or null if window is closed
     */
    public File openDirectory() {
        return getDirectoryChooser().showDialog(stage);
    }

    /**
     * <p> Open a single file. </p>
     *
     * @return Selected file or null if window is closed.
     */
    public File openFile() {
        return getFileChooser().showOpenDialog(stage);
    }

    /**
     * <p> Allow open multiple files in a row. </p>
     *
     * @return Selected files or null if window is closed.
     */
    public List<File> openFiles() {
        return getFileChooser().showOpenMultipleDialog(stage);
    }

    /**
     * <p> Creates an instance of {@link DirectoryChooser}. </p>
     *
     * @return DirectoryChooser ready to be used.
     */
    private DirectoryChooser getDirectoryChooser() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle(title);
        chooser.setInitialDirectory(initialDirectory);
        return chooser;
    }

    /**
     * <p> Creates an instance of {@link FileChooser}. </p>
     *
     * @return FileChooser ready to be used.
     */
    private FileChooser getFileChooser() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle(title);
        chooser.setInitialDirectory(initialDirectory);

        for (FileExtension extension : extensions)
            chooser.getExtensionFilters().add(extension.filter);

        return chooser;
    }
}
