package aslib.ai;

/**
 * <p> Contains the function to analyze and detect the gender from the provided
 * name.</p>
 *
 * @author Adriano Siqueira
 * @version 5.1
 * @since 1.0
 */
public class GenderDetector {
    private String name;

    /**
     * <p> Creates an instance of {@link GenderDetector} class. </p>
     *
     * <p> Because the name was not initialized, the result of the detection
     * will accuse the name of being invalid if it not call {@code setName}
     * before. </p>
     */
    public GenderDetector() {
    }

    /**
     * <p> Creates an instance of {@link GenderDetector} class. </p>
     *
     * @param fullName Complete name of the person. The sur name will be removed automatically.
     */
    public GenderDetector(String fullName) {
        this.name = fullName != null
                ? fullName.split(" ")[0]
                : fullName;
    }

    /**
     * <p> Analyzes the naming pattern of the name to detect its gender. </p>
     * <p> <b>Obs.:</b> This function only works in "<b>Brazilian Portuguese</b>" names. </p>
     *
     * @return [-1] - Invalid <br> [ 0] - Undefined <br> [ 1] - Feminine <br> [ 2] - Masculine
     */
    public int getSex() {
        if (name == null || name.length() < 3)
            return -1;

        switch (name.charAt(name.length() - 1)) {
            case 'a':   // Amanda
                return 1;

            case 'c':   // Isac
                return 2;

            case 'd':   // David
            case 'f':   // Alaf
            case 'k':   // Isak
                return 2;

            case 'e':
                if (name.charAt(0) == 'a')
                    if (name.charAt(1) == 'l') return 2;                                // Alexandre
                    else return 1;                                                      // Adriane
                else if (name.charAt(0) == 'd')
                    if (name.charAt(1) == 'a' && name.charAt(2) == 'v') return 2;       // Davide
                    else if (name.charAt(1) == 'e' && name.charAt(3) == 'v') return 2;  // Deivede
                    else return 1;                                                      // Daniele
                else if (name.charAt(0) == 'f') return 2;                               // Felipe
                else if (name.charAt(0) == 'h' && name.charAt(2) == 'n') return 2;      // Henrique
                else if (name.charAt(name.length() - 2) == 'm') return 2;               // Guilherme
                else if (name.charAt(0) == 'p') return 2;                               // Philipe
                else if (name.endsWith("que")) return 2;                                // Isaque
                else if (name.charAt(0) == 'v') return 2;                               // Vicente
                else return 1;                                                          // Rute

            case 'é':   // José
                return 2;

            case 'h':   // Sarah
                return 1;

            case 'i':
            case 'y':
                if (name.charAt(0) == 'k' && name.charAt(1) == 'e') return 2;   // Kenedy
                else if (name.charAt(2) == 'd') return 2;                       // Sidney
                else if (name.charAt(0) == 'f') return 2;                       // Fredi
                else if (name.charAt(0) == 'i')
                    if (name.charAt(1) == 'u') return 2;                        // Iuri
                    else return 1;                                              // Isabelli
                else if (name.charAt(0) == 'p') return 2;                       // Philipi
                else if (name.charAt(2) == 'v') return 2;                       // Davy
                else if (name.charAt(0) == 'w')
                    if (name.charAt(2) == 's') return 2;                        // Wesley
                    else return 1;                                              // Wendy
                else if (name.charAt(0) == 'y') return 2;                       // Yuri
                else return 1;                                                  // ???

            case 'l':
            case 'u':
                if (name.charAt(0) == 'd') return 2;                // Daniel
                else if (name.charAt(0) == 'g') return 2;           // Gesiel
                else if (name.charAt(0) == 'j') return 2;           // Jesiel
                else if (name.charAt(0) == 's') return 2;           // Samuel
                else if (name.charAt(0) == 'l')
                    if (name.charAt(1) == 'e') return 2;            // Leonel
                    else if (name.charAt(1) == 'i') return 2;       // Lionel
                    else return 1;
                else if (name.charAt(0) == 'm')
                    if (name.charAt(1) == 'a')
                        if (name.charAt(2) == 'b') return 1;        // Mabel
                        else if (name.charAt(2) == 'n') return 2;   // Manuel
                        else if (name.charAt(2) == 'r')
                            if (name.charAt(3) == 'c') return 2;    // Marcel
                            else return 1;                          // Mariel
                        else return 2;                              // Maxuel
                    else if (name.charAt(1) == 'i') return 2;       // Michel
                    else return 1;                                  // Muriel
                else if (name.charAt(0) == 'r')
                    if (name.charAt(2) == 'f') return 2;            // Rafael
                    else if (name.charAt(2) == 'p') return 2;       // Raphael
                    else if (name.charAt(2) == 'u') return 2;       // Raul
                    else if (name.charAt(1) == 'i') return 2;       // Riquelme
                    else return 1;                                  // Raquel
                else return 1;                                      // ???

            case 'm':
            case 'n':
                if (name.charAt(0) == 'a') return 2;        // Adrian
                else if (name.charAt(0) == 'c')
                    if (name.charAt(1) == 'l') return 2;    // Cleiton
                    else return 1;                          // Chaissen
                else if (name.charAt(0) == 'e') return 2;   // Erickson
                else if (name.charAt(0) == 'j') return 2;   // Jackson
                else if (name.charAt(0) == 'l') return 2;   // Luan
                else if (name.charAt(0) == 'm')
                    if (name.charAt(1) == 'i') return 1;    // Miriam
                    else return 2;                          // Marlon
                else if (name.charAt(0) == 'n') return 2;   // Nelson
                else if (name.charAt(0) == 'r') return 2;   // Ruan
                else if (name.charAt(0) == 's')
                    if (name.charAt(1) == 'e') return 2;    // Serafin
                    else return 1;                          // Shaissen
                else if (name.charAt(0) == 'w') return 2;   // Wellington
                else return 1;                              // ???

            case 'o':
            case 'ó':
                if (name.startsWith("con")) return 1;       // Conceição
                else if (name.startsWith("ree")) return 1;  // Reencarnação
                else if (name.startsWith("res")) return 1;  // Ressurreição
                else return 2;                              // João

            case 'p':   // Philip
                return 2;

            case 'r':
                if (name.charAt(0) == 'e')
                    if (name.charAt(1) == 'i') return 2;    // Eitor
                    else return 1;                          // Eleonor - Ester
                else if (name.charAt(0) == 'h')
                    if (name.charAt(2) == 'i') return 2;    // Heitor
                    else return 1;                          // Heleonor - Hester
                else return 2;                              // Sartor

            case 's':
            case 'z':
                if (name.charAt(0) == 'c') return 2;        // Carlos
                else if (name.charAt(0) == 'j') return 2;   // Juarez
                else if (name.charAt(0) == 'm') return 2;   // Matheus
                else if (name.charAt(0) == 'q') return 2;   // Queiroz
                else if (name.charAt(0) == 'r') return 2;   // Ramirez
                else if (name.charAt(0) == 'l')
                    if (name.charAt(1) == 'a') return 1;    // Lais
                    else return 2;                          // Lucas - Luis
                else return 1;                              // ???

            case 't':   // Vicent
                return 2;

            case 'x':   // Rex
                return 2;

            default:    // ???
                return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
