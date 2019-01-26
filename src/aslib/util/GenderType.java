package aslib.util;

/**
 * <p> Contains the options to represent the gender of a person. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.0
 */
public enum GenderType {
    INVALID(-1),
    UNDEFINED(0),
    FEMININE(1),
    MASCULINE(2),
    LESBIAN(3),
    GAY(4),
    TRANSGENDER(5);

    private int gender;

    GenderType(int gender) {
        this.gender = gender;
    }

    /**
     * <p> Search for the option whose code matches the argument. </p>
     *
     * @param gender Code to return as an option of enum.
     * @return The enum option that matches the code.
     * @throws IllegalArgumentException If the code not exists.
     */
    public GenderType getGenderType(int gender) throws IllegalArgumentException {
        for (GenderType value : values())
            if (value.gender == gender)
                return value;

        throw new IllegalArgumentException("The gender provided is invalid!");
    }

    /**
     * <p> Returns the code of the enum option. </p>
     *
     * @return The code of gender.
     */
    public int getGender() {
        return gender;
    }
}
