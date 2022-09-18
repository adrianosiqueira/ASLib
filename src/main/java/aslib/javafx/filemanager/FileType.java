package aslib.javafx.filemanager;

import javafx.stage.FileChooser.ExtensionFilter;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Contains the relation between file types and its respective extensions. This
 * class was designed to create a {@link ExtensionFilter} through a file type
 * selection.
 * </p>
 *
 * <p style="text-align:justify">
 * <b>Use samples:</b>
 * </p>
 *
 * <pre>
 * ExtensionFilter documentFilter = FileType.DOCUMENT.getFilter();
 * ExtensionFilter videoFilter    = FileType.VIDEO.getFilter();
 *
 *
 *
 * FileChooser chooser = new FileChooser();
 * chooser.getExtensionFilters()
 *        .addAll(
 *            FileType.DOCUMENT.getFilter(),
 *            FileType.VIDEO.getFilter()
 *        )
 * </pre>
 *
 * <hr>
 *
 * <h2><b>Relation between type and extensions</b></h2>
 *
 * <table style="width:400px" summary="">
 *  <tr>
 *      <th>Type</th>
 *      <th>Extensions</th>
 *  </tr>
 *  <tr>
 *      <td>All</td>
 *      <td>*</td>
 *  </tr>
 *      <tr>
 *      <td>Compressed</td>
 *      <td>.7z, .ace, .alz, .arc, .arj, .bzip2, .egg, .gz, .gzip, .rar, .tar, .zip</td>
 *      </tr>
 *  <tr>
 *      <td>Disk Image</td>
 *      <td>.adf, .bin, .cue, .dmg, .img, .iso, .nrg</td>
 *  </tr>
 *  <tr>
 *      <td>Document</td>
 *      <td>.doc, .docx, .odp, .ods, .odt, .pdf, .ppt, .pptx, .rtf, .txt, .xls, .xlsx</td>
 *  </tr>
 *  <tr>
 *      <td>Hash</td>
 *      <td>.md5, .sha1, .sha224, .sha256, .sha384, .sha512, .txt</td>
 *  </tr>
 *  <tr>
 *      <td>Markdown</td>
 *      <td>.markdown, .MARKDOWN, .md, .MD</td>
 *  </tr>
 *  <tr>
 *      <td>Markup</td>
 *      <td>.cfml, .gml, .htm, .html, .kml, .xaml, .xhtml, .xml, .yaml</td>
 *  </tr>
 *  <tr>
 *      <td>Music</td>
 *      <td>.aac, .aiff, .mp3, .ogg, .wav, .wma</td>
 *  </tr>
 *  <tr>
 *      <td>Picture</td>
 *      <td>.gif, .jpg, .jpeg, .png, .tiff, .webp</td>
 *  </tr>
 *  <tr>
 *      <td>Runnable</td>
 *      <td>.apk, .appimage, .AppImage, .exe, .jar, .msi, .run</td>
 *  </tr>
 *  <tr>
 *      <td>Script</td>
 *      <td>.bash, .bat, .dat, .js, .php, .sh, .vbs, .zsh</td>
 *  </tr>
 *  <tr>
 *      <td>Source Code</td>
 *      <td>.c, .cpp, .java, .pas, .py</td>
 *  </tr>
 *  <tr>
 *      <td>Stylesheet</td>
 *      <td>.css, .less, .sass, .scss, .styl, .xslt</td>
 *  </tr>
 *  <tr>
 *      <td>Video</td>
 *      <td>.3gp, .avi, .flv, .mkv, .mp4, .mpeg, .mpg, .ogv, .rmvb, .webm, .wmv</td>
 *  </tr>
 * </table>
 *
 * <hr>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 6.0.0
 */
public enum FileType {

    /**
     * <p style="text-align:justify">
     * Show all files without any restriction.
     * </p>
     *
     * @since 1.0.0
     */
    ALL("All", "*"),

    /**
     * <p style="text-align:justify">
     * Only compressed files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    COMPRESSED("Compresseds", "*.7z", "*.ace", "*.alz", "*.arc", "*.arj", "*.bzip2", "*.egg", "*.gz", "*.gzip", "*.rar", "*.tar", "*.zip"),

    /**
     * <p style="text-align:justify">
     * Only disc image files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    DISK_IMAGE("Disc Images", "*.adf", "*.bin", "*.cue", "*.dmg", "*.img", "*.iso", "*.nrg"),

    /**
     * <p style="text-align:justify">
     * Only document files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    DOCUMENT("Documents", "*.doc", "*.docx", "*.odp", "*.ods", "*.odt", "*.pdf", "*.ppt", "*.pptx", "*.rtf", "*.txt", "*.xls", "*.xlsx"),

    /**
     * <p style="text-align:justify">
     * Only hash files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    HASH("Hashes", "*.md5", "*.sha1", "*.sha224", "*.sha256", "*.sha384", "*.sha512", "*.txt"),

    /**
     * <p style="text-align:justify">
     * Only markdown files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    MARKDOWN("Markdown", "*.markdown", "*.MARKDOWN", "*.md", "*.MD"),

    /**
     * <p style="text-align:justify">
     * Only markup files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    MARKUP("Markup", "*.cfml", "*.gml", "*.htm", "*.html", "*.kml", "*.xaml", "*.xhtml", "*.xml", "*.yaml"),

    /**
     * <p style="text-align:justify">
     * Only music files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    MUSIC("Musics", "*.aac", "*.aiff", "*.mp3", "*.oga", "*.ogg", "*.wav", "*.wma"),

    /**
     * <p style="text-align:justify">
     * Only picture files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    PICTURE("Pictures", "*.gif", "*.jpg", "*.jpeg", "*.png", "*.svg", "*.tiff", "*.webp"),

    /**
     * <p style="text-align:justify">
     * Only runnable files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    RUNNABLE("Runnables", "*.apk", "*.appimage", "*.AppImage", "*.exe", "*.jar", "*.msi", "*.run"),

    /**
     * <p style="text-align:justify">
     * Only script files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    SCRIPT("Scripts", "*.bash", "*.bat", "*.dat", "*.js", "*.php", "*.sh", "*.vbs", "*.zsh"),

    /**
     * <p style="text-align:justify">
     * Only source code files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    SOURCE_CODE("Source Codes", "*.c", "*.cpp", "*.java", "*.pas", "*.py"),

    /**
     * <p style="text-align:justify">
     * Only stylesheet files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    STYLESHEET("Stylesheet", "*.css", "*.less", "*.sass", "*.scss", "*.styl", "*.xslt"),

    /**
     * <p style="text-align:justify">
     * Only video files are shown.
     * </p>
     *
     * @since 1.0.0
     */
    VIDEO("Videos", "*.3gp", "*.avi", "*.flv", "*.mkv", "*.mp4", "*.mpeg", "*.mpg", "*.ogv", "*.rmvb", "*.webm", "*.wmv");


    /**
     * <p style="text-align:justify">
     * Description of file type.
     * </p>
     *
     * @since 1.0.0
     */
    private final String description;

    /**
     * <p style="text-align:justify">
     * Extensions of the file type.
     * </p>
     *
     * @since 1.0.0
     */
    private final List<String> extensions;


    /**
     * <p style="text-align:justify">
     * Creates a new instance of {@link FileType}.
     * </p>
     *
     * @param description The description of type.
     * @param extensions  The extensions of type.
     *
     * @since 1.0.0
     */
    FileType(String description, String... extensions) {
        this.description = description;
        this.extensions  = List.of(extensions);
    }


    /**
     * <p style="text-align:justify">
     * Searches for a {@link FileType} that contains the provided extension
     * in its list. It doesn't matter whether or not the extension is preceded
     * by an asterisk with a dot, that is, the following are acceptable.
     * </p>
     *
     * <pre>
     * *.extension
     * .extension
     * extension
     * </pre>
     *
     * <p style="text-align:justify">
     * If the provided extension is null, empty or not found, then an
     * {@link Optional#empty()} will be returned.
     * </p>
     *
     * @param extension Extension to be searched for.
     *
     * @return An {@link Optional} containing a {@link FileType}.
     *
     * @since 1.0.0
     */
    public static Optional<FileType> getByExtension(String extension) {
        if (extension == null || extension.isBlank())
            return Optional.empty();

        AtomicReference<String> reference = new AtomicReference<>(extension);
        reference.set(reference.get().replaceAll("[*.]", ""));
        reference.set("*." + reference.get());

        return Stream.of(values())
                     .filter(e -> e.extensions.contains(reference.get()))
                     .findFirst();
    }


    /**
     * <p style="text-align:justify">
     * Creates a {@link ExtensionFilter} using the description and extensions
     * from the current {@link FileType}.
     * </p>
     *
     * @return A {@link ExtensionFilter}.
     *
     * @since 1.0.0
     */
    public ExtensionFilter getFilter() {
        return new ExtensionFilter(description, extensions);
    }
}
