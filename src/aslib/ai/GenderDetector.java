package aslib.ai;

import aslib.util.Gender;
import aslib.util.Parsable;

/**
 * <p>Class designed to detect a person's gender through name analysis.</p>
 *
 * <p>It was designed to work with Brazilian names. Foreign names may or may not
 * work.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 1.0.0
 */
public class GenderDetector implements Parsable<String, Gender> {

    /**
     * <p>Parses the name to detect gender. It works only for Brazilian names.</p>
     *
     * @param name Name that will be analyzed. Not null.
     *
     * @return The person's gender. If the gender cannot be determined,
     * {@link Gender#UNDEFINED} will be returned.
     *
     * @since 2.0.0
     */
    @SuppressWarnings({"DuplicateExpressions", "SpellCheckingInspection"})
    @Override
    public Gender parse(String name) {
        if (name.length() < 3)
            return Gender.UNDEFINED;

        name = name.toLowerCase();
        Gender gender;

        switch (name.charAt(name.length() - 1)) {
            case 'a':
                if (name.charAt(name.length() - 2) == 'c') gender = Gender.MASCULINE;   // Juca - Luca
                else gender = Gender.FEMININE;      // Amanda
                break;

            case 'ã':
                if (name.charAt(0) == 'm') gender = Gender.FEMININE;    // Miriã
                else gender = Gender.MASCULINE;                         // Cauã
                break;

            case 'á':   // Thainá
            case 'h':   // Sarah
                gender = Gender.FEMININE;
                break;

            case 'c':   // Isac
            case 'd':   // David
            case 'f':   // Alaf
            case 'k':   // Isak - Jack
            case 'é':   // José
            case 'ó':   // Jacó
            case 'p':   // Philip
            case 't':   // Eliot - Vicent
            case 'x':   // Rex
                gender = Gender.MASCULINE;
                break;

            case 'e':
                if (name.charAt(name.length() - 2) == 'd') gender = Gender.MASCULINE;       // Andrade - Deivede
                else if (name.charAt(name.length() - 2) == 'g') gender = Gender.FEMININE;   // Anaderge
                else if (name.charAt(name.length() - 2) == 'i') gender = Gender.MASCULINE;  // Jackie
                else if (name.charAt(name.length() - 2) == 'l') gender = Gender.FEMININE;   // Gisele
                else if (name.charAt(name.length() - 2) == 'm') gender = Gender.MASCULINE;  // Guilherme - Riquelme
                else if (name.charAt(name.length() - 2) == 'n') gender = Gender.FEMININE;   // Adriane - Luane - Riane
                else if (name.charAt(name.length() - 2) == 'p') gender = Gender.MASCULINE;  // Felipe - Philipe
                else if (name.charAt(name.length() - 2) == 'r') gender = Gender.MASCULINE;  // Alexandre
                else if (name.charAt(name.length() - 2) == 's') gender = Gender.FEMININE;   // Luíse - Taíse
                else if (name.charAt(name.length() - 2) == 't')
                    if (name.charAt(0) == 'r') gender = Gender.FEMININE;                    // Rute
                    else gender = Gender.MASCULINE;                                         // Dante - Vicente
                else if (name.charAt(name.length() - 2) == 'u') gender = Gender.MASCULINE;  // Henrique - Isaque
                else if (name.charAt(name.length() - 2) == 'z') gender = Gender.FEMININE;   // Luíze - Taíze
                else gender = Gender.UNDEFINED;                                             // ???
                break;

            case 'i':
            case 'y':
                if (name.charAt(name.length() - 2) == 'a') gender = Gender.FEMININE;        // Elienai
                else if (name.charAt(name.length() - 2) == 'd')
                    if (name.charAt(0) == 'w') gender = Gender.FEMININE;                    // Wendi
                    else gender = Gender.MASCULINE;                                         // Fredi - Kenedi
                else if (name.charAt(name.length() - 2) == 'e') gender = Gender.MASCULINE;  // Sidnei - Weslei
                else if (name.charAt(name.length() - 2) == 'l') gender = Gender.FEMININE;   // Danieli - Isabeli - Sueli
                else if (name.charAt(name.length() - 2) == 'm')
                    if (name.charAt(name.length() - 3) == 'o') gender = Gender.MASCULINE;   // Tomi
                    else gender = Gender.FEMININE;      // Tami
                else if (name.charAt(name.length() - 2) == 'n')
                    if (name.charAt(name.length() - 3) == 'o') gender = Gender.MASCULINE;   // Doni - Raoni - Toni
                    else gender = Gender.FEMININE;      // Dani - Luani - Riani
                else if (name.charAt(name.length() - 2) == 'p') gender = Gender.MASCULINE;  // Felipi - Philipi
                else if (name.charAt(name.length() - 2) == 'r') gender = Gender.MASCULINE;  // Iuri
                else if (name.charAt(name.length() - 2) == 's') gender = Gender.FEMININE;   // Taisi
                else if (name.charAt(name.length() - 2) == 't') gender = Gender.FEMININE;   // Katy
                else if (name.charAt(name.length() - 2) == 'v') gender = Gender.MASCULINE;  // Davi - Doni - Ravi
                else gender = Gender.UNDEFINED;         // ???
                break;

            case 'l':
            case 'u':
                if (name.charAt(name.length() - 2) == 'e')
                    if (name.charAt(name.length() - 3) == 'a') gender = Gender.MASCULINE;       // Rafael
                    else if (name.charAt(name.length() - 3) == 'b') gender = Gender.FEMININE;   // Isabel - Mabel
                    else if (name.charAt(name.length() - 3) == 'c') gender = Gender.MASCULINE;  // Marcel
                    else if (name.charAt(name.length() - 3) == 'h') gender = Gender.MASCULINE;  // Michel
                    else if (name.charAt(name.length() - 3) == 'i')
                        if (name.charAt(0) == 'c') gender = Gender.MASCULINE;                   // Castiel
                        else if (name.charAt(0) == 'd') gender = Gender.MASCULINE;              // Daniel
                        else if (name.charAt(0) == 'g') gender = Gender.MASCULINE;              // Gesiel
                        else if (name.charAt(0) == 'j') gender = Gender.MASCULINE;              // Jesiel
                        else gender = Gender.FEMININE;                                          // Ariel - Muriel
                    else if (name.charAt(name.length() - 3) == 'n') gender = Gender.MASCULINE;  // Leonel
                    else if (name.charAt(name.length() - 3) == 'o') gender = Gender.MASCULINE;  // Manoel
                    else if (name.charAt(name.length() - 3) == 's') gender = Gender.MASCULINE;  // Eliesel
                    else if (name.charAt(name.length() - 3) == 'u')
                        if (name.charAt(0) == 'm') gender = Gender.MASCULINE;                   // Manuel - Maxuel
                        else if (name.charAt(0) == 's') gender = Gender.MASCULINE;              // Samuel
                        else gender = Gender.FEMININE;                                          // Raquel
                    else gender = Gender.UNDEFINED;                                             // ???
                else if (name.charAt(name.length() - 2) == 'u') gender = Gender.MASCULINE;      // Raul - Saul
                else gender = Gender.UNDEFINED;                                                 // ???
                break;

            case 'm':
            case 'n':
                if (name.charAt(name.length() - 2) == 'a')
                    if (name.charAt(name.length() - 3) == 'i')
                        if (name.charAt(0) == 'a') gender = Gender.MASCULINE;                   // Adrian
                        else if (name.charAt(0) == 'l') gender = Gender.FEMININE;               // Lilian
                        else if (name.charAt(0) == 'm') gender = Gender.FEMININE;               // Mirian
                        else if (name.charAt(0) == 'r') gender = Gender.MASCULINE;              // Rian
                        else if (name.charAt(0) == 'w') gender = Gender.MASCULINE;              // Wilian
                        else gender = Gender.UNDEFINED;                                         // ???
                    else if (name.charAt(name.length() - 3) == 'u') gender = Gender.MASCULINE;  // Luan - Ruan
                    else gender = Gender.UNDEFINED;                                             // ???
                else if (name.charAt(name.length() - 2) == 'e')
                    if (name.charAt(0) == 'a') gender = Gender.MASCULINE;                       // Adrien
                    else gender = Gender.FEMININE;                                              // Chaissen - Elen
                else if (name.charAt(name.length() - 2) == 'i')
                    if (name.charAt(0) == 'j')
                        if (name.charAt(1) == 'a') gender = Gender.FEMININE;                    // Jasmin
                        else gender = Gender.MASCULINE;                                         // Joaquim
                    else gender = Gender.MASCULINE;                                             // Benjamin - Serafin
                else if (name.charAt(name.length() - 2) == 'o') gender = Gender.MASCULINE;      // Alisson - Marlon
                else gender = Gender.UNDEFINED;                                                 // ???
                break;

            case 'o':
                if (name.startsWith("con")) gender = Gender.FEMININE;         // Conceição
                else if (name.startsWith("ree")) gender = Gender.FEMININE;    // Reencarnação
                else if (name.startsWith("res")) gender = Gender.FEMININE;    // Ressurreição
                else gender = Gender.MASCULINE;                               // João
                break;

            case 'r':
                if (name.charAt(name.length() - 2) == 'e')
                    if (name.charAt(0) == 'c') gender = Gender.MASCULINE;       // Carter
                    else if (name.charAt(0) == 'v') gender = Gender.MASCULINE;  // Valter
                    else if (name.charAt(0) == 'w') gender = Gender.MASCULINE;  // Walter
                    else gender = Gender.FEMININE;                              // Ester
                else if (name.charAt(name.length() - 2) == 'i')
                    if (name.charAt(0) == 'j') gender = Gender.MASCULINE;       // Jacir - Jair
                    else if (name.charAt(0) == 'v') gender = Gender.MASCULINE;  // Valdecir - Valdir
                    else gender = Gender.FEMININE;                              // Nadir
                else if (name.charAt(name.length() - 2) == 'o')
                    if (name.charAt(name.length() - 3) == 'n')
                        if (name.charAt(0) == 'c') gender = Gender.MASCULINE;   // Claudionor
                        else gender = Gender.FEMININE;                          // Eleonor
                    else gender = Gender.MASCULINE;                             // Eitor - Sartor
                else gender = Gender.UNDEFINED;                                 // ???
                break;

            case 's':
            case 'z':
                if (name.charAt(name.length() - 2) == 'i')
                    if (name.charAt(1) == 'u') gender = Gender.MASCULINE;                   // Luis
                    else gender = Gender.FEMININE;                                          // Iris
                else if (name.charAt(name.length() - 2) == 'í') gender = Gender.FEMININE;   // Taís
                else gender = Gender.MASCULINE;                                             // Carlos - Jesus - Lucas - Mateus - Tales
                break;

            default:    // ???
                gender = Gender.UNDEFINED;
                break;
        }

        return gender;
    }
}
