package aslib.filemanager;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p> Contains the function and components to perform file openings.  </p>
 *
 * @author Adriano Siqueira
 */
public class Opener {

    /**
     * <p> All files are shown without restrictions. </p>
     */
    public static final FileChooser.ExtensionFilter ALL = new FileChooser.ExtensionFilter("All", "*");

    /**
     * <p> Only compressed files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter COMPRESSED = new FileChooser.ExtensionFilter("Compressed",
            "*.7z",
            "*.ace",
            "*.alz",
            "*.arc",
            "*.arj",
            "*.bzip2",
            "*.egg",
            "*.gz",
            "*.gzip",
            "*.rar",
            "*.tar",
            "*.zip"
    );

    /**
     * <p> Only disc image files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter DISC_IMAGES = new FileChooser.ExtensionFilter("Disc Images",
            "*.adf",
            "*.bin",
            "*.cue",
            "*.dmg",
            "*.img",
            "*.iso",
            "*.nrg"
    );

    /**
     * <p> Only document files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter DOCUMENTS = new FileChooser.ExtensionFilter("Documents",
            "*.doc",
            "*.docx",
            "*.ppt",
            "*.pptx",
            "*.xls",
            "*.xlsx",
            "*.odt",
            "*.odp",
            "*.ods",
            "*.pdf",
            "*.rtf",
            "*.txt"
    );

    /**
     * <p> Only hash files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter HASH = new FileChooser.ExtensionFilter("Hashes",
            "*.txt",
            "*.md5",
            "*.sha1",
            "*.sha224",
            "*.sha356",
            "*.sha384",
            "*.sha512"
    );

    /**
     * <p> Only music files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter MUSICS = new FileChooser.ExtensionFilter("Musics",
            "*.aac",
            "*.aiff",
            "*.mp3",
            "*.ogg",
            "*.wav",
            "*.wma"
    );

    /**
     * <p> Only picture files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter PICTURES = new FileChooser.ExtensionFilter("Pictures",
            "*.gif",
            "*.jpg",
            "*.jpeg",
            "*.png",
            "*.tiff"
    );

    /**
     * <p> Only runnable files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter RUNNABLE = new FileChooser.ExtensionFilter("Runnable",
            "*.apk",
            "*.appimage",
            "*.AppImage",
            "*.exe",
            "*.jar",
            "*.run"
    );

    /**
     * <p> Only script files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter SCRIPTS = new FileChooser.ExtensionFilter("Scripts",
            "*.bash",
            "*.bat",
            "*.dat",
            "*.sh",
            "*.vbs"
    );

    /**
     * <p> Only video files are shown. </p>
     */
    public static final FileChooser.ExtensionFilter VIDEOS = new FileChooser.ExtensionFilter("Videos",
            "*.flv",
            "*.mkv",
            "*.mp4",
            "*.mpeg",
            "*.wmv"
    );

    /**
     * <p> Invokes the system's open dialog. </p>
     * <p> Obs.: It is necessary to check null files, because if the dialog is closed, or cancel button is pressed
     * a null object is returned. If opening a single file, the check must be done on the first item in the list
     * ( list.get(0) ). </p>
     *
     * @param title            Title of dialog pane. If it is null, the default value will be set.
     * @param initialDirectory Directory to open the dialog. If it is null, the dialog opens in the user's home folder.
     * @param openSingle       TRUE: Ensures that only one file can be opened. FALSE: Allows multiple files opening.
     * @param extensions       File types to filter in the dialog. "ALL" filter will be added automatically only when if it is null, otherwise should be added in the array. The default selected extension is the first item in the array.
     * @return List with the selected items.
     */
    public static List<File> open(final String title,
                                  final String initialDirectory,
                                  final boolean openSingle,
                                  final FileChooser.ExtensionFilter... extensions) {
        /*
        To solve the problem of the thread that continues running even after the end of the function,
        it is necessary to create a stage for the file chooser window. Then the stage should be opened
        and closed.
        */
        final Stage stage = new Stage();
        stage.show();
        stage.close();

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle((title != null) ? title : "File Opener");
        fileChooser.setInitialDirectory(new File((initialDirectory != null) ? initialDirectory : System.getProperty("user.home")));

        fileChooser.getExtensionFilters().clear();
        if (extensions != null) fileChooser.getExtensionFilters().addAll(extensions);
        else fileChooser.getExtensionFilters().add(ALL);

        final List<File> files;

        if (openSingle) {
            File temp = fileChooser.showOpenDialog(stage);
            files = (temp != null) ? Collections.singletonList(temp) : new ArrayList<>();
        } else {
            List<File> temp = fileChooser.showOpenMultipleDialog(stage);
            files = (temp != null) ? temp : new ArrayList<>();
        }

        return files;
    }
}
