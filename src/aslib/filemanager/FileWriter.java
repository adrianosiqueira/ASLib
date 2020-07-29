package aslib.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * <p> Handles all file write operations. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 9.0.0
 */
public class FileWriter {

    /**
     * <p> Appends the content to the file. </p>
     *
     * @param string Content to be write.
     * @param file   Where to write the content.
     *
     * @since 1.0.0
     */
    public void append(String string, File file) {
        write(string, file.toPath(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * <p> Appends the content to the file. </p>
     *
     * @param string Content to be write.
     * @param path   Where to write the content.
     *
     * @since 1.0.0
     */
    public void append(String string, Path path) {
        write(string, path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * <p> Writes the content to the file. It will replace all previous
     * content. </p>
     *
     * @param string Content to be write.
     * @param file   Where to write the content.
     *
     * @since 1.0.0
     */
    public void write(String string, File file) {
        write(string, file.toPath(), StandardOpenOption.CREATE);
    }

    /**
     * <p> Writes the content to the file. It will replace all previous
     * content. </p>
     *
     * @param string Content to be write.
     * @param path   Where to write the content.
     *
     * @since 1.0.0
     */
    public void write(String string, Path path) {
        write(string, path, StandardOpenOption.CREATE);
    }

    /**
     * <p> Writes the content to the file according to the options provided. </p>
     *
     * @param string  Content to be write.
     * @param path    Where to write the content.
     * @param options File handling method.
     *
     * @since 1.0.0
     */
    private void write(String string, Path path, OpenOption... options) {
        if (string == null) {
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path, options)) {
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}