package aslib.filemanager;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * <p> Contains the function to save a file. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.0
 */
public class Saver {
    private String title;
    private File initialDirectory;
    private FileExtension[] extensions;
    private Stage stage;

    /**
     * <p> Uses the class' name as title, sets user home folder as initial
     * directory and uses {@code FileExtension.ALL} as file filter. </p>
     */
    public Saver() {
        this(Saver.class.getSimpleName());
    }

    /**
     * <p> Sets user home folder as initial directory and uses
     * {@code FileExtension.ALL} as file filter. </p>
     *
     * @param title Title of the dialog window.
     */
    public Saver(String title) {
        this(title, new File(System.getProperty("user.home")));
    }

    /**
     * <p> Uses {@code FileExtension.ALL} as file filter. </p>
     *
     * @param title            Title of the dialog window.
     * @param initialDirectory Directory where dialog will started in.
     */
    public Saver(String title, File initialDirectory) {
        this(title, initialDirectory, FileExtension.ALL);
    }

    /**
     * <p> Creates an instance of {@link Saver} class. </p>
     *
     * @param title            Title of the dialog window.
     * @param initialDirectory Directory where dialog will started in.
     * @param extensions       Filters to be used by the dialog.
     */
    public Saver(String title, File initialDirectory, FileExtension... extensions) {
        this.title = title;
        this.initialDirectory = initialDirectory;
        this.extensions = extensions;

        this.stage = new Stage();
        this.stage.show();
        this.stage.close();
    }

    /**
     * <p> Select where the file will be saved. </p>
     *
     * @return File to writen into.
     */
    public File save() {
        return getFileChooser().showSaveDialog(stage);
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
