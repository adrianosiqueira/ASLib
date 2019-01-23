package aslib.filemanager;

import javafx.stage.FileChooser;

/**
 * <p> Contains the relation between file type and their extensions. </p>
 *
 * <p> Automatically creates the {@link javafx.stage.FileChooser.ExtensionFilter}
 * from the selected option. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.0
 */
public enum FileExtension {
    /**
     * <p> Show all files without any restriction. </p>
     */
    ALL("All", "*"),

    /**
     * <p> Only compressed files are shown. </p>
     */
    COMPRESSED("Compresseds", "*.7z", "*.ace", "*.alz", "*.arc", "*.arj", "*.bzip2", "*.egg", "*.gz", "*.gzip", "*.rar", "*.tar", "*.zip"),

    /**
     * <p> Only disc image files are shown. </p>
     */
    DISK_IMAGE("Disc Images", "*.adf", "*.bin", "*.cue", "*.dmg", "*.img", "*.iso", "*.nrg"),

    /**
     * <p> Only document files are shown. </p>
     */
    DOCUMENT("Documents", "*.doc", "*.docx", "*.ppt", "*.pptx", "*.xls", "*.xlsx", "*.odt", "*.odp", "*.ods", "*.pdf", "*.rtf", "*.txt"),

    /**
     * <p> Only hash files are shown. </p>
     */
    HASH("Hashes", "*.txt", "*.md5", "*.sha1", "*.sha224", "*.sha356", "*.sha384", "*.sha512"),

    /**
     * <p> Only music files are shown. </p>
     */
    MUSIC("Musics", "*.aac", "*.aiff", "*.mp3", "*.ogg", "*.wav", "*.wma"),

    /**
     * <p> Only picture files are shown. </p>
     */
    PICTURE("Pictures", "*.gif", "*.jpg", "*.jpeg", "*.png", "*.tiff"),

    /**
     * <p> Only runnable files are shown. </p>
     */
    RUNNABLE("Runnables", "*.apk", "*.appimage", "*.AppImage", "*.exe", "*.jar", "*.run"),

    /**
     * <p> Only script files are shown. </p>
     */
    SCRIPT("Scripts", "*.bash", "*.bat", "*.dat", "*.sh", "*.vbs"),

    /**
     * <p> Only source code files are shown. </p>
     */
    SOURCE_CODE("Source Codes", "*.c", "*.cpp", "*.java", "*.pas"),

    /**
     * <p> Only video files are shown. </p>
     */
    VIDEO("Videos", "*.flv", "*.mkv", "*.mp4", "*.mpeg", "*.wmv");

    public final String description;
    public final String[] extensions;
    public final FileChooser.ExtensionFilter filter;

    FileExtension(String description, String... extensions) {
        this.description = description;
        this.extensions = extensions;
        this.filter = new FileChooser.ExtensionFilter(description, extensions);
    }
}