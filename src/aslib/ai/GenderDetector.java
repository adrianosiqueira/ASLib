package aslib.ai;

import aslib.util.GenderType;

/**
 * <p> Contains the function to analyze and detect the gender from the provided
 * name.</p>
 *
 * @author Adriano Siqueira
 * @version 5.2
 * @since 1.0
 */
public class GenderDetector {
    private String name;
    private GenderType gender;

    /**
     * <p> Switch that indicates whether the name was analyzed. </p>
     *
     * @apiNote Internal use only.
     */
    private boolean analyzed = false;

    /**
     * <p> Creates an instance of {@link GenderDetector} class. </p>
     *
     * <p> Because the name was not initialized, the result of the detection
     * will accuse the name of being invalid if it not call {@code setName}
     * before. </p>
     */
    public GenderDetector() {
        setName("");
    }

    /**
     * <p> Creates an instance of {@link GenderDetector} class. </p>
     *
     * @param fullName Complete name of the person. The sur name will be removed automatically.
     */
    public GenderDetector(String fullName) {
        setName(fullName);
    }

    /**
     * <p> Analyzes the naming pattern of the name to detect its gender. </p>
     *
     * <p> <b>Obs.:</b> This function only works in "<b>Brazilian Portuguese</b>"
     * names. </p>
     *
     * @apiNote Internal use only.
     */
    private void analyze() {
        if (name.length() < 3)
            gender = GenderType.INVALID;

        switch (name.charAt(name.length() - 1)) {
            case 'a':   // Amanda
                gender = GenderType.FEMININE;

            case 'c':   // Isac
                gender = GenderType.MASCULINE;

            case 'd':   // David
            case 'f':   // Alaf
            case 'k':   // Isak
                gender = GenderType.MASCULINE;

            case 'e':
                if (name.charAt(0) == 'a')
                    if (name.charAt(1) == 'l') gender = GenderType.MASCULINE;                                 // Alexandre
                    else gender = GenderType.FEMININE;                                                        // Adriane
                else if (name.charAt(0) == 'd')
                    if (name.charAt(1) == 'a' && name.charAt(2) == 'v') gender = GenderType.MASCULINE;        // Davide
                    else if (name.charAt(1) == 'e' && name.charAt(3) == 'v') gender = GenderType.MASCULINE;   // Deivede
                    else gender = GenderType.FEMININE;                                                        // Daniele
                else if (name.charAt(0) == 'f') gender = GenderType.MASCULINE;                                // Felipe
                else if (name.charAt(0) == 'h' && name.charAt(2) == 'n') gender = GenderType.MASCULINE;       // Henrique
                else if (name.charAt(name.length() - 2) == 'm') gender = GenderType.MASCULINE;                // Guilherme
                else if (name.charAt(0) == 'p') gender = GenderType.MASCULINE;                                // Philipe
                else if (name.endsWith("que")) gender = GenderType.MASCULINE;                                 // Isaque
                else if (name.charAt(0) == 'v') gender = GenderType.MASCULINE;                                // Vicente
                else gender = GenderType.FEMININE;                                                            // Rute

            case 'é':   // José
                gender = GenderType.MASCULINE;

            case 'h':   // Sarah
                gender = GenderType.FEMININE;

            case 'i':
            case 'y':
                if (name.charAt(0) == 'k' && name.charAt(1) == 'e') gender = GenderType.MASCULINE;    // Kenedy
                else if (name.charAt(2) == 'd') gender = GenderType.MASCULINE;                        // Sidney
                else if (name.charAt(0) == 'f') gender = GenderType.MASCULINE;                        // Fredi
                else if (name.charAt(0) == 'i')
                    if (name.charAt(1) == 'u') gender = GenderType.MASCULINE;                         // Iuri
                    else gender = GenderType.FEMININE;                                                // Isabelli
                else if (name.charAt(0) == 'p') gender = GenderType.MASCULINE;                        // Philipi
                else if (name.charAt(2) == 'v') gender = GenderType.MASCULINE;                        // Davy
                else if (name.charAt(0) == 'w')
                    if (name.charAt(2) == 's') gender = GenderType.MASCULINE;                         // Wesley
                    else gender = GenderType.FEMININE;                                                // Wendy
                else if (name.charAt(0) == 'y') gender = GenderType.MASCULINE;                        // Yuri
                else gender = GenderType.FEMININE;                                                    // ???

            case 'l':
            case 'u':
                if (name.charAt(0) == 'd') gender = GenderType.MASCULINE;                 // Daniel
                else if (name.charAt(0) == 'g') gender = GenderType.MASCULINE;            // Gesiel
                else if (name.charAt(0) == 'j') gender = GenderType.MASCULINE;            // Jesiel
                else if (name.charAt(0) == 's') gender = GenderType.MASCULINE;            // Samuel
                else if (name.charAt(0) == 'l')
                    if (name.charAt(1) == 'e') gender = GenderType.MASCULINE;             // Leonel
                    else if (name.charAt(1) == 'i') gender = GenderType.MASCULINE;        // Lionel
                    else gender = GenderType.FEMININE;                                    // ???
                else if (name.charAt(0) == 'm')
                    if (name.charAt(1) == 'a')
                        if (name.charAt(2) == 'b') gender = GenderType.FEMININE;          // Mabel
                        else if (name.charAt(2) == 'n') gender = GenderType.MASCULINE;    // Manuel
                        else if (name.charAt(2) == 'r')
                            if (name.charAt(3) == 'c') gender = GenderType.MASCULINE;     // Marcel
                            else gender = GenderType.FEMININE;                            // Mariel
                        else gender = GenderType.MASCULINE;                               // Maxuel
                    else if (name.charAt(1) == 'i') gender = GenderType.MASCULINE;        // Michel
                    else gender = GenderType.FEMININE;                                    // Muriel
                else if (name.charAt(0) == 'r')
                    if (name.charAt(2) == 'f') gender = GenderType.MASCULINE;             // Rafael
                    else if (name.charAt(2) == 'p') gender = GenderType.MASCULINE;        // Raphael
                    else if (name.charAt(2) == 'u') gender = GenderType.MASCULINE;        // Raul
                    else if (name.charAt(1) == 'i') gender = GenderType.MASCULINE;        // Riquelme
                    else gender = GenderType.FEMININE;                                    // Raquel
                else gender = GenderType.FEMININE;                                        // ???

            case 'm':
            case 'n':
                if (name.charAt(0) == 'a') gender = GenderType.MASCULINE;         // Adrian
                else if (name.charAt(0) == 'c')
                    if (name.charAt(1) == 'l') gender = GenderType.MASCULINE;     // Cleiton
                    else gender = GenderType.FEMININE;                            // Chaissen
                else if (name.charAt(0) == 'e') gender = GenderType.MASCULINE;    // Erickson
                else if (name.charAt(0) == 'j') gender = GenderType.MASCULINE;    // Jackson
                else if (name.charAt(0) == 'l') gender = GenderType.MASCULINE;    // Luan
                else if (name.charAt(0) == 'm')
                    if (name.charAt(1) == 'i') gender = GenderType.FEMININE;      // Miriam
                    else gender = GenderType.MASCULINE;                           // Marlon
                else if (name.charAt(0) == 'n') gender = GenderType.MASCULINE;    // Nelson
                else if (name.charAt(0) == 'r') gender = GenderType.MASCULINE;    // Ruan
                else if (name.charAt(0) == 's')
                    if (name.charAt(1) == 'e') gender = GenderType.MASCULINE;     // Serafin
                    else gender = GenderType.FEMININE;                            // Shaissen
                else if (name.charAt(0) == 'w') gender = GenderType.MASCULINE;    // Wellington
                else gender = GenderType.FEMININE;                                // ???

            case 'o':
            case 'ó':
                if (name.startsWith("con")) gender = GenderType.FEMININE;         // Conceição
                else if (name.startsWith("ree")) gender = GenderType.FEMININE;    // Reencarnação
                else if (name.startsWith("res")) gender = GenderType.FEMININE;    // Ressurreição
                else gender = GenderType.MASCULINE;                               // João

            case 'p':   // Philip
                gender = GenderType.MASCULINE;

            case 'r':
                if (name.charAt(0) == 'e')
                    if (name.charAt(1) == 'i') gender = GenderType.MASCULINE;     // Eitor
                    else gender = GenderType.FEMININE;                            // Eleonor - Ester
                else if (name.charAt(0) == 'h')
                    if (name.charAt(2) == 'i') gender = GenderType.MASCULINE;     // Heitor
                    else gender = GenderType.FEMININE;                            // Heleonor - Hester
                else gender = GenderType.MASCULINE;                               // Sartor

            case 's':
            case 'z':
                if (name.charAt(0) == 'c') gender = GenderType.MASCULINE;         // Carlos
                else if (name.charAt(0) == 'j') gender = GenderType.MASCULINE;    // Juarez
                else if (name.charAt(0) == 'm') gender = GenderType.MASCULINE;    // Matheus
                else if (name.charAt(0) == 'q') gender = GenderType.MASCULINE;    // Queiroz
                else if (name.charAt(0) == 'r') gender = GenderType.MASCULINE;    // Ramirez
                else if (name.charAt(0) == 'l')
                    if (name.charAt(1) == 'a') gender = GenderType.FEMININE;      // Lais
                    else gender = GenderType.MASCULINE;                           // Lucas - Luis
                else gender = GenderType.FEMININE;                                // ???

            case 't':   // Vicent
                gender = GenderType.MASCULINE;

            case 'x':   // Rex
                gender = GenderType.MASCULINE;

            default:    // ???
                gender = GenderType.UNDEFINED;
        }

        analyzed = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName != null
                ? fullName.split(" ")[0]
                : "";

        this.analyzed = false;
    }

    public GenderType getGender() {
        if (!analyzed)
            analyze();

        return gender;
    }
}