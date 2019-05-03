package aslib.filemanager;

import aslib.exceptions.InvalidEnumSearchArgumentException;
import javafx.stage.FileChooser;

/**
 * <p> Contains the relation between file type and their extensions. </p>
 *
 * <p> Automatically creates the {@link javafx.stage.FileChooser.ExtensionFilter}
 * from the selected option. </p>
 *
 * <h2> Filters and Extensions </h2>
 * <table style="width:400px" summary="">
 * <tr>
 * <th> Filter </th>
 * <th> Extensions </th>
 * </tr>
 * <tr>
 * <td> All </td>
 * <td> * </td>
 * </tr>
 * <tr>
 * <td> Compressed </td>
 * <td> *.7z, *.ace, *.alz, *.arc, *.arj, *.bzip2, *.egg, *.gz, *.gzip, *.rar, *.tar, *.zip </td>
 * </tr>
 * <tr>
 * <td> Disk Image </td>
 * <td> *.adf, *.bin, *.cue, *.dmg, *.img, *.iso, *.nrg </td>
 * </tr>
 * <tr>
 * <td> Document </td>
 * <td> *.doc, *.docx, *.ppt, *.pptx, *.xls, *.xlsx, *.odt, *.odp, *.ods, *.pdf, *.rtf, *.txt </td>
 * </tr>
 * <tr>
 * <td> Hash </td>
 * <td> *.txt, *.md5, *.sha1, *.sha224, *.sha356, *.sha384, *.sha512 </td>
 * </tr>
 * <tr>
 * <td> Music </td>
 * <td> *.aac, *.aiff, *.mp3, *.ogg, *.wav, *.wma </td>
 * </tr>
 * <tr>
 * <td> Picture </td>
 * <td> *.gif, *.jpg, *.jpeg, *.png, *.tiff </td>
 * </tr>
 * <tr>
 * <td> Runnable </td>
 * <td> *.apk, *.appimage, *.AppImage, *.exe, *.jar, *.run </td>
 * </tr>
 * <tr>
 * <td> Script </td>
 * <td> *.bash, *.bat, *.dat, *.sh, *.vbs </td>
 * </tr>
 * <tr>
 * <td> Source Code </td>
 * <td> *.c, *.cpp, *.java, *.pas </td>
 * </tr>
 * <tr>
 * <td> Video </td>
 * <td> *.flv, *.mkv, *.mp4, *.mpeg, *.wmv </td>
 * </tr>
 * </table>
 *
 * @author Adriano Siqueira
 * @version 1.0 - 1.1
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
    MUSIC("Musics", "*.aac", "*.aiff", "*.mp3", "*.oga", "*.ogg", "*.wav", "*.wma"),

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
    SOURCE_CODE("Source Codes", "*.c", "*.cpp", "*.java", "*.pas", "*.py"),

    /**
     * <p> Only video files are shown. </p>
     */
    VIDEO("Videos", "*.flv", "*.mkv", "*.mp4", "*.mpeg", "*.ogv", "*.rmvb", "*.wmv");

    public final String description;
    public final String[] extensions;
    public final FileChooser.ExtensionFilter filter;

    FileExtension(String description, String... extensions) {
        this.description = description;
        this.extensions = extensions;
        this.filter = new FileChooser.ExtensionFilter(description, extensions);
    }

    /**
     * <p> Searches for the extension at all enum options and returns the first
     * occurrence. </p>
     *
     * @param extension Extension to be searched for.
     * @return The {@link FileExtension} option that contains the extension in its list.
     * @throws IllegalArgumentException           If the extension does not starts with a dot.
     * @throws InvalidEnumSearchArgumentException If the extension does not exists.
     * @throws NullPointerException               If the extension is null.
     */
    public static FileExtension getByExtension(String extension) throws IllegalArgumentException, InvalidEnumSearchArgumentException, NullPointerException {
        if (extension == null)
            throw new NullPointerException("The extension can not be null");
        else if (extension.charAt(0) != '.')
            throw new IllegalArgumentException("The extension must start with a dot ('.').");

        for (FileExtension value : values())
            for (String valueExtension : value.extensions)
                if (valueExtension.endsWith(extension))
                    return value;

        throw new InvalidEnumSearchArgumentException("The extension does not exists.");
    }
}
