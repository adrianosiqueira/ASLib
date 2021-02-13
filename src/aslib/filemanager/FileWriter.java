package aslib.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * <p> Handles all file write operations. </p>
 *
 * <p> It works with {@link File}s and {@link Path}s. </p>
 *
 * <p><b> Attention: </b> These methods can cause memory overflow if the content
 * for writing is very large. </p>
 *
 * @author Adriano Siqueira
 * @version 1.1.0
 * @since 9.0.0
 */
public class FileWriter {

    /**
     * <p> Creates an instance of {@link FileWriter}. </p>
     *
     * @since 1.1.0
     */
    public FileWriter() {
    }

    /**
     * <p> Appends the content to the end of the file. </p>
     *
     * <p> If the content or file is null, the operation will be canceled. </p>
     *
     * <p> If the file does not exist, it will be created. </p>
     *
     * @param content Content to write.
     * @param file    File to write to.
     *
     * @since 1.0.0
     */
    public void append(String content, File file) {
        if (content == null || file == null) {
            return;
        }

        this.append(content, file.toPath());
    }

    /**
     * <p> Appends the content to the end of the path. </p>
     *
     * <p> If the content or path is null, the operation will be canceled. </p>
     *
     * <p> If the path does not exist, it will be created. </p>
     *
     * @param content Content to write.
     * @param path    Path to write to.
     *
     * @since 1.0.0
     */
    public void append(String content, Path path) {
        if (content == null || path == null) {
            return;
        }

        this.write(content,
                   path,
                   StandardOpenOption.WRITE,
                   StandardOpenOption.CREATE,
                   StandardOpenOption.APPEND);
    }

    /**
     * <p> Appends the lines to the end of the file. </p>
     *
     * <p> If the lines or file is null, the operation will be canceled. </p>
     *
     * <p> If the file does not exist, it will be created. </p>
     *
     * @param lines Lines to write.
     * @param file  File to write to.
     *
     * @since 1.1.0
     */
    public void append(List<String> lines, File file) {
        if (lines == null || file == null) {
            return;
        }

        this.append(lines, file.toPath());
    }

    /**
     * <p> Appends the lines to the end of the path. </p>
     *
     * <p> If the lines or path is null, the operation will be canceled. </p>
     *
     * <p> If the path does not exist, it will be created. </p>
     *
     * @param lines Lines to write.
     * @param path  Path to write to.
     *
     * @since 1.1.0
     */
    public void append(List<String> lines, Path path) {
        if (lines == null || path == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();

        lines.forEach(line -> builder.append(line)
                                     .append(System.lineSeparator()));

        this.write(builder.toString(),
                   path,
                   StandardOpenOption.WRITE,
                   StandardOpenOption.CREATE,
                   StandardOpenOption.APPEND);
    }

    /**
     * <p> Writes the content to the file. All previous content will be replaced. </p>
     *
     * <p> If the content or file is null, the operation will be canceled. </p>
     *
     * <p> If the file does not exist, it will be created. </p>
     *
     * @param content Content to write.
     * @param file    File to write to.
     *
     * @since 1.0.0
     */
    public void write(String content, File file) {
        if (content == null || file == null) {
            return;
        }

        this.write(content, file.toPath());
    }

    /**
     * <p> Writes the content to the path. All previous content will be replaced. </p>
     *
     * <p> If the content or path is null, the operation will be canceled. </p>
     *
     * <p> If the path does not exist, it will be created. </p>
     *
     * @param content Content to write.
     * @param path    Path to write to.
     *
     * @since 1.0.0
     */
    public void write(String content, Path path) {
        if (content == null || path == null) {
            return;
        }

        this.write(content,
                   path,
                   StandardOpenOption.WRITE,
                   StandardOpenOption.CREATE,
                   StandardOpenOption.TRUNCATE_EXISTING);
    }

    /**
     * <p> Writes the lines to the file. All previous content will be replaced. </p>
     *
     * <p> If the lines or file is null, the operation will be canceled. </p>
     *
     * <p> If the file does not exist, it will be created. </p>
     *
     * @param lines Lines to write.
     * @param file  File to write to.
     *
     * @since 1.1.0
     */
    public void write(List<String> lines, File file) {
        if (lines == null || file == null) {
            return;
        }

        this.write(lines, file.toPath());
    }

    /**
     * <p> Writes the lines to the path. All previous content will be replaced. </p>
     *
     * <p> If the lines or path is null, the operation will be canceled. </p>
     *
     * <p> If the path does not exist, it will be created. </p>
     *
     * @param lines Lines to write.
     * @param path  Path to write to.
     *
     * @since 1.1.0
     */
    public void write(List<String> lines, Path path) {
        if (lines == null || path == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();

        lines.forEach(line -> builder.append(line)
                                     .append(System.lineSeparator()));

        this.write(builder.toString(),
                   path,
                   StandardOpenOption.WRITE,
                   StandardOpenOption.CREATE,
                   StandardOpenOption.TRUNCATE_EXISTING);
    }

    /**
     * <p> Writes the content to the file according to the
     * {@link StandardOpenOption}s provided. </p>
     *
     * <p> Internal use only. </p>
     *
     * @param content     Content to write.
     * @param path        Path to write to.
     * @param openOptions Determines how the operation will be performed.
     *
     * @since 1.0.0
     */
    private void write(String content, Path path, StandardOpenOption... openOptions) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, openOptions)) {
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}