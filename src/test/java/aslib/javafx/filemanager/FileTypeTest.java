package aslib.javafx.filemanager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p style="text-align:justify">
 * Tests for the {@link FileType} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
@SuppressWarnings("OptionalGetWithoutIsPresent")
class FileTypeTest {

    @Test
    @DisplayName("GetByExtension: Returns 'COMPRESSED' when value is '7z'")
    void getByExtension_00() {
        assertEquals(FileType.COMPRESSED, FileType.getByExtension("7z").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'COMPRESSED' when value is 'rar'")
    void getByExtension_01() {
        assertEquals(FileType.COMPRESSED, FileType.getByExtension("rar").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'COMPRESSED' when value is 'zip'")
    void getByExtension_02() {
        assertEquals(FileType.COMPRESSED, FileType.getByExtension("zip").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'DISK_IMAGE' when value is 'bin'")
    void getByExtension_03() {
        assertEquals(FileType.DISK_IMAGE, FileType.getByExtension("bin").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'DISK_IMAGE' when value is 'cue'")
    void getByExtension_04() {
        assertEquals(FileType.DISK_IMAGE, FileType.getByExtension("cue").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'DISK_IMAGE' when value is 'iso'")
    void getByExtension_05() {
        assertEquals(FileType.DISK_IMAGE, FileType.getByExtension("iso").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'DOCUMENT' when value is 'doc'")
    void getByExtension_06() {
        assertEquals(FileType.DOCUMENT, FileType.getByExtension("doc").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'DOCUMENT' when value is 'pdf'")
    void getByExtension_07() {
        assertEquals(FileType.DOCUMENT, FileType.getByExtension("pdf").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'DOCUMENT' when value is 'txt'")
    void getByExtension_08() {
        assertEquals(FileType.DOCUMENT, FileType.getByExtension("txt").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'HASH' when value is 'md5'")
    void getByExtension_09() {
        assertEquals(FileType.HASH, FileType.getByExtension("md5").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'HASH' when value is 'sha1'")
    void getByExtension_10() {
        assertEquals(FileType.HASH, FileType.getByExtension("sha1").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'HASH' when value is 'sha512'")
    void getByExtension_11() {
        assertEquals(FileType.HASH, FileType.getByExtension("sha512").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MARKDOWN' when value is 'MD'")
    void getByExtension_12() {
        assertEquals(FileType.MARKDOWN, FileType.getByExtension("MD").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MARKDOWN' when value is 'markdown'")
    void getByExtension_13() {
        assertEquals(FileType.MARKDOWN, FileType.getByExtension("markdown").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MARKDOWN' when value is 'md'")
    void getByExtension_14() {
        assertEquals(FileType.MARKDOWN, FileType.getByExtension("md").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MARKUP' when value is 'html'")
    void getByExtension_15() {
        assertEquals(FileType.MARKUP, FileType.getByExtension("html").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MARKUP' when value is 'xml'")
    void getByExtension_16() {
        assertEquals(FileType.MARKUP, FileType.getByExtension("xml").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MARKUP' when value is 'yaml'")
    void getByExtension_17() {
        assertEquals(FileType.MARKUP, FileType.getByExtension("yaml").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MUSIC' when value is 'aac'")
    void getByExtension_18() {
        assertEquals(FileType.MUSIC, FileType.getByExtension("aac").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MUSIC' when value is 'mp3'")
    void getByExtension_19() {
        assertEquals(FileType.MUSIC, FileType.getByExtension("mp3").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'MUSIC' when value is 'ogg'")
    void getByExtension_20() {
        assertEquals(FileType.MUSIC, FileType.getByExtension("ogg").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'PICTURE' when value is 'gif'")
    void getByExtension_21() {
        assertEquals(FileType.PICTURE, FileType.getByExtension("gif").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'PICTURE' when value is 'jpg'")
    void getByExtension_22() {
        assertEquals(FileType.PICTURE, FileType.getByExtension("jpg").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'PICTURE' when value is 'png'")
    void getByExtension_23() {
        assertEquals(FileType.PICTURE, FileType.getByExtension("png").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'RUNNABLE' when value is 'apk'")
    void getByExtension_24() {
        assertEquals(FileType.RUNNABLE, FileType.getByExtension("apk").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'RUNNABLE' when value is 'exe'")
    void getByExtension_25() {
        assertEquals(FileType.RUNNABLE, FileType.getByExtension("exe").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'RUNNABLE' when value is 'msi'")
    void getByExtension_26() {
        assertEquals(FileType.RUNNABLE, FileType.getByExtension("msi").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'SCRIPT' when value is 'bash'")
    void getByExtension_27() {
        assertEquals(FileType.SCRIPT, FileType.getByExtension("bash").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'SCRIPT' when value is 'bat'")
    void getByExtension_28() {
        assertEquals(FileType.SCRIPT, FileType.getByExtension("bat").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'SCRIPT' when value is 'dat'")
    void getByExtension_29() {
        assertEquals(FileType.SCRIPT, FileType.getByExtension("dat").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'SOURCE_CODE' when value is 'c'")
    void getByExtension_30() {
        assertEquals(FileType.SOURCE_CODE, FileType.getByExtension("c").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'SOURCE_CODE' when value is 'java'")
    void getByExtension_31() {
        assertEquals(FileType.SOURCE_CODE, FileType.getByExtension("java").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'SOURCE_CODE' when value is 'py'")
    void getByExtension_32() {
        assertEquals(FileType.SOURCE_CODE, FileType.getByExtension("py").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'STYLESHEET' when value is 'css'")
    void getByExtension_33() {
        assertEquals(FileType.STYLESHEET, FileType.getByExtension("css").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'STYLESHEET' when value is 'less'")
    void getByExtension_34() {
        assertEquals(FileType.STYLESHEET, FileType.getByExtension("less").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'STYLESHEET' when value is 'scss'")
    void getByExtension_35() {
        assertEquals(FileType.STYLESHEET, FileType.getByExtension("scss").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'VIDEO' when value is '3gp'")
    void getByExtension_36() {
        assertEquals(FileType.VIDEO, FileType.getByExtension("3gp").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'VIDEO' when value is 'mkv'")
    void getByExtension_37() {
        assertEquals(FileType.VIDEO, FileType.getByExtension("mkv").get());
    }

    @Test
    @DisplayName("GetByExtension: Returns 'VIDEO' when value is 'mp4'")
    void getByExtension_38() {
        assertEquals(FileType.VIDEO, FileType.getByExtension("mp4").get());
    }
}
