package aslib.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> Generify the classes that works with string-morse translations. </p>
 *
 * <p> Plus, it provides a complete dictionary. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public interface MorseDictionary {
    Map<String, String> dictionary = new LinkedHashMap<String, String>() {{
        put("0", "- - - - -");
        put("1", ". - - - -");
        put("2", ". . - - -");
        put("3", ". . . - -");
        put("4", ". . . . -");
        put("5", ". . . . .");
        put("6", "- . . . .");
        put("7", "- - . . .");
        put("8", "- - - . .");
        put("9", "- - - - .");
        put("A", ". -");
        put("Ã", ". -");
        put("Â", ". -");
        put("Á", ". -");
        put("À", ". -");
        put("B", "- . . .");
        put("C", "- . - .");
        put("Ç", "- . - .");
        put("D", "- . .");
        put("E", ".");
        put("Ê", ".");
        put("É", ".");
        put("F", ". . - .");
        put("G", "- - .");
        put("H", ". . . .");
        put("I", ". .");
        put("Í", ". .");
        put("J", ". - - -");
        put("K", "- . -");
        put("L", ". - . .");
        put("M", "- -");
        put("N", "- .");
        put("Ñ", "- .");
        put("O", "- - -");
        put("Õ", "- - -");
        put("Ô", "- - -");
        put("Ó", "- - -");
        put("P", ". - - .");
        put("Q", "- - . -");
        put("R", ". - .");
        put("S", ". . .");
        put("T", "-");
        put("U", ". . -");
        put("Ú", ". . -");
        put("Ü", ". . -");
        put("V", ". . . -");
        put("W", ". - -");
        put("X", "- . . -");
        put("Y", "- . - -");
        put("Z", "- - . .");
        put(" ", "       ");
    }};

    String get(String input) throws NullPointerException;
}
