package aslib.ai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <p> Contains the function to calculate the age based in the date of birth. </p>
 *
 * @author Adriano Siqueira
 * @version 1.2
 * @since 1.0
 */
public class AgeDetector {

    /**
     * <p> Calculates the age based in the date of birth. </p>
     *
     * @param birthDate Date of birth in the format (dd/mm/yyyy).
     * @return The age.
     * @throws ParseException           If the values are not in correct format.
     * @throws IllegalArgumentException If the date is invalid.
     */
    public static int detect(final String birthDate) throws ParseException, IllegalArgumentException {
        int age;

        Calendar baseCalendar = Calendar.getInstance();
        Calendar birthCalendar = Calendar.getInstance();

        birthCalendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(birthDate));

        // Detects possible bugs that may make it impossible to perform the calculation.
        if (birthCalendar.get(Calendar.YEAR) == baseCalendar.get(Calendar.YEAR)) {
            if (birthCalendar.get(Calendar.MONTH) > baseCalendar.get(Calendar.MONTH)) {
                throw new IllegalArgumentException("The month of birth is invalid");
            } else if (birthCalendar.get(Calendar.MONTH) == baseCalendar.get(Calendar.MONTH)) {
                if (birthCalendar.get(Calendar.DAY_OF_MONTH) > baseCalendar.get(Calendar.DAY_OF_MONTH)) {
                    throw new IllegalArgumentException("The day of birth is invalid");
                }
            }
        } else if (birthCalendar.get(Calendar.YEAR) > baseCalendar.get(Calendar.YEAR)) {
            throw new IllegalArgumentException("The year of birth is invalid");
        }

        // From this point, we are guaranteed that the data is valid.
        age = baseCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

        // Determines if the birthday has not arrived yet. If not, the age must be decreased.
        if (birthCalendar.get(Calendar.MONTH) == baseCalendar.get(Calendar.MONTH)) {
            if (birthCalendar.get(Calendar.DAY_OF_MONTH) > baseCalendar.get(Calendar.DAY_OF_MONTH)) {
                --age;
            }
        } else if (birthCalendar.get(Calendar.MONTH) > baseCalendar.get(Calendar.MONTH)) {
            --age;
        }

        return age;
    }
}
