package aslib.ai.genderdetector.bra;

import aslib.ai.genderdetector.Detector;
import aslib.ai.genderdetector.Gender;

/**
 * <p style="text-align:justify">
 * Handles the {@link Gender} detection through a name analysis. This class was
 * designed to work with Brazilian names, foreign names may or may not work.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class BrazilianDetector implements Detector {

    @SuppressWarnings({"DuplicatedCode", "DuplicateExpressions", "SpellCheckingInspection"})
    @Override
    public Gender detect(String name)
    throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("The name cannot be null.");
        if (name.length() < 3) return Gender.UNDEFINED;

        name = name.toLowerCase();

        switch (name.charAt(name.length() - 1)) {
            case 'a':
                if (name.charAt(name.length() - 2) == 'c') return Gender.MASCULINE;     // Juca - Luca
                else return Gender.FEMININE;                                            // Amanda

            case 'ã':
                if (name.charAt(0) == 'm') return Gender.FEMININE;  // Miriã
                else return Gender.MASCULINE;                       // Cauã

            case 'á':   // Thainá
            case 'h':   // Sarah
                return Gender.FEMININE;

            case 'c':   // Isac
            case 'd':   // David
            case 'f':   // Alaf
            case 'k':   // Isak - Jack
            case 'é':   // José
            case 'ó':   // Jacó
            case 'p':   // Philip
            case 't':   // Eliot - Vicent
            case 'x':   // Rex
                return Gender.MASCULINE;

            case 'e':
                if (name.charAt(name.length() - 2) == 'd') return Gender.MASCULINE;       // Andrade - Deivede
                else if (name.charAt(name.length() - 2) == 'g') return Gender.FEMININE;   // Anaderge
                else if (name.charAt(name.length() - 2) == 'i') return Gender.MASCULINE;  // Jackie
                else if (name.charAt(name.length() - 2) == 'l') return Gender.FEMININE;   // Gisele
                else if (name.charAt(name.length() - 2) == 'm') return Gender.MASCULINE;  // Guilherme - Riquelme
                else if (name.charAt(name.length() - 2) == 'n') return Gender.FEMININE;   // Adriane - Luane - Riane
                else if (name.charAt(name.length() - 2) == 'p') return Gender.MASCULINE;  // Felipe - Philipe
                else if (name.charAt(name.length() - 2) == 'r') return Gender.MASCULINE;  // Alexandre
                else if (name.charAt(name.length() - 2) == 's') return Gender.FEMININE;   // Luíse - Taíse
                else if (name.charAt(name.length() - 2) == 't')
                    if (name.charAt(0) == 'b') return Gender.FEMININE;                    // Bete
                    else if (name.charAt(0) == 'r') return Gender.FEMININE;               // Rute
                    else return Gender.MASCULINE;                                         // Dante - Vicente
                else if (name.charAt(name.length() - 2) == 'u')
                    if (name.charAt(0) == 'm') return Gender.FEMININE;                    // Monique
                    else return Gender.MASCULINE;                                         // Henrique - Isaque
                else if (name.charAt(name.length() - 2) == 'z') return Gender.FEMININE;   // Luíze - Taíze
                else return Gender.UNDEFINED;                                             // ???

            case 'i':
            case 'y':
                if (name.charAt(name.length() - 2) == 'a') return Gender.FEMININE;        // Elienai
                else if (name.charAt(name.length() - 2) == 'd')
                    if (name.charAt(0) == 'w') return Gender.FEMININE;                    // Wendi
                    else return Gender.MASCULINE;                                         // Fredi - Kenedi
                else if (name.charAt(name.length() - 2) == 'e') return Gender.MASCULINE;  // Sidnei - Weslei
                else if (name.charAt(name.length() - 2) == 'l') return Gender.FEMININE;   // Danieli - Isabeli - Sueli
                else if (name.charAt(name.length() - 2) == 'm')
                    if (name.charAt(name.length() - 3) == 'o') return Gender.MASCULINE;   // Tomi
                    else return Gender.FEMININE;                                          // Tami
                else if (name.charAt(name.length() - 2) == 'n')
                    if (name.charAt(name.length() - 3) == 'o') return Gender.MASCULINE;   // Doni - Raoni - Toni
                    else return Gender.FEMININE;                                          // Dani - Luani - Riani
                else if (name.charAt(name.length() - 2) == 'p') return Gender.MASCULINE;  // Felipi - Philipi
                else if (name.charAt(name.length() - 2) == 'r') return Gender.MASCULINE;  // Iuri
                else if (name.charAt(name.length() - 2) == 's') return Gender.FEMININE;   // Taisi
                else if (name.charAt(name.length() - 2) == 't') return Gender.FEMININE;   // Katy
                else if (name.charAt(name.length() - 2) == 'v') return Gender.MASCULINE;  // Davi - Doni - Ravi
                else return Gender.UNDEFINED;                                             // ???

            case 'l':
            case 'u':
                if (name.charAt(name.length() - 2) == 'e')
                    if (name.charAt(name.length() - 3) == 'a') return Gender.MASCULINE;       // Rafael
                    else if (name.charAt(name.length() - 3) == 'b') return Gender.FEMININE;   // Isabel - Mabel
                    else if (name.charAt(name.length() - 3) == 'c') return Gender.MASCULINE;  // Marcel
                    else if (name.charAt(name.length() - 3) == 'd') return Gender.MASCULINE;  // Tadeu
                    else if (name.charAt(name.length() - 3) == 'h') return Gender.MASCULINE;  // Michel
                    else if (name.charAt(name.length() - 3) == 'i')
                        if (name.charAt(0) == 'c') return Gender.MASCULINE;                   // Castiel
                        else if (name.charAt(0) == 'd') return Gender.MASCULINE;              // Daniel
                        else if (name.charAt(0) == 'g') return Gender.MASCULINE;              // Gesiel
                        else if (name.charAt(0) == 'j') return Gender.MASCULINE;              // Jesiel
                        else return Gender.FEMININE;                                          // Ariel - Muriel
                    else if (name.charAt(name.length() - 3) == 'n') return Gender.MASCULINE;  // Leonel
                    else if (name.charAt(name.length() - 3) == 'o') return Gender.MASCULINE;  // Manoel
                    else if (name.charAt(name.length() - 3) == 'r') return Gender.MASCULINE;  // Abreu
                    else if (name.charAt(name.length() - 3) == 's') return Gender.MASCULINE;  // Eliesel
                    else if (name.charAt(name.length() - 3) == 'u')
                        if (name.charAt(0) == 'm') return Gender.MASCULINE;                   // Manuel - Maxuel
                        else if (name.charAt(0) == 's') return Gender.MASCULINE;              // Samuel
                        else return Gender.FEMININE;                                          // Raquel
                    else return Gender.UNDEFINED;                                             // ???
                else if (name.charAt(name.length() - 2) == 'u') return Gender.MASCULINE;      // Raul - Saul
                else return Gender.UNDEFINED;                                                 // ???

            case 'm':
            case 'n':
                if (name.charAt(name.length() - 2) == 'a')
                    if (name.charAt(name.length() - 3) == 'i')
                        if (name.charAt(0) == 'a') return Gender.MASCULINE;                   // Adrian
                        else if (name.charAt(0) == 'l') return Gender.FEMININE;               // Lilian
                        else if (name.charAt(0) == 'm') return Gender.FEMININE;               // Mirian
                        else if (name.charAt(0) == 'r') return Gender.MASCULINE;              // Rian
                        else if (name.charAt(0) == 'w') return Gender.MASCULINE;              // Wilian
                        else return Gender.UNDEFINED;                                         // ???
                    else if (name.charAt(name.length() - 3) == 'u') return Gender.MASCULINE;  // Luan - Ruan
                    else return Gender.UNDEFINED;                                             // ???
                else if (name.charAt(name.length() - 2) == 'e')
                    if (name.charAt(0) == 'a') return Gender.MASCULINE;                       // Adrien
                    else return Gender.FEMININE;                                              // Chaissen - Elen
                else if (name.charAt(name.length() - 2) == 'i')
                    if (name.charAt(0) == 'i') return Gender.FEMININE;                        // Iasmin
                    else if (name.charAt(0) == 'j')
                        if (name.charAt(1) == 'a') return Gender.FEMININE;                    // Jasmin
                        else return Gender.MASCULINE;                                         // Joaquim
                    else return Gender.MASCULINE;                                             // Benjamin - Serafin
                else if (name.charAt(name.length() - 2) == 'o') return Gender.MASCULINE;      // Alisson - Marlon
                else return Gender.UNDEFINED;                                                 // ???

            case 'o':
                if (name.startsWith("con")) return Gender.FEMININE;         // Conceição
                else if (name.startsWith("ree")) return Gender.FEMININE;    // Reencarnação
                else if (name.startsWith("res")) return Gender.FEMININE;    // Ressurreição
                else return Gender.MASCULINE;                               // João

            case 'r':
                if (name.charAt(name.length() - 2) == 'e')
                    if (name.charAt(0) == 'c') return Gender.MASCULINE;       // Carter
                    else if (name.charAt(0) == 'v') return Gender.MASCULINE;  // Valter
                    else if (name.charAt(0) == 'w') return Gender.MASCULINE;  // Walter
                    else return Gender.FEMININE;                              // Ester
                else if (name.charAt(name.length() - 2) == 'i')
                    if (name.charAt(0) == 'j') return Gender.MASCULINE;       // Jacir - Jair
                    else if (name.charAt(0) == 'v') return Gender.MASCULINE;  // Valdecir - Valdir
                    else return Gender.FEMININE;                              // Nadir
                else if (name.charAt(name.length() - 2) == 'o')
                    if (name.charAt(name.length() - 3) == 'n')
                        if (name.charAt(0) == 'c') return Gender.MASCULINE;   // Claudionor
                        else return Gender.FEMININE;                          // Eleonor
                    else return Gender.MASCULINE;                             // Eitor - Sartor
                else return Gender.UNDEFINED;                                 // ???

            case 's':
            case 'z':
                if (name.charAt(name.length() - 2) == 'i')
                    if (name.charAt(1) == 'u') return Gender.MASCULINE;                   // Luis
                    else return Gender.FEMININE;                                          // Iris
                else if (name.charAt(name.length() - 2) == 'í') return Gender.FEMININE;   // Taís
                else return Gender.MASCULINE;                                             // Carlos - Jesus - Lucas - Mateus - Tales

            default:    // ???
                return Gender.UNDEFINED;
        }
    }
}
