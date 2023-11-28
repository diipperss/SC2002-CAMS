/**
 * The DateFormat class provides methods for parsing date strings and checking for date clashes.
 * It uses the java.time.LocalDate class for date manipulation.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package camp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import user.StudentUser;

public class DateFormat {

    /**
     * Parses the given date string using the specified date format.
     *
     * @param dateString The date string to be parsed.
     * @return A LocalDate object representing the parsed date.
     * @throws DateTimeParseException If the input string cannot be parsed to a valid date.
     */
    public static LocalDate parseDate(String dateString) throws DateTimeParseException {
        // Define the date format based on your input format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Change the pattern accordingly

        // Parse the string to LocalDate
        return LocalDate.parse(dateString, formatter);
    }

    /**
     * Checks for date clashes between the selected camp and the camps the student is already registered for.
     *
     * @param selectedCamp The camp to check for date clashes.
     * @param studentUser  The student user for whom to check date clashes.
     * @return The name of the camp with which a date clash occurs, or null if there is no clash.
     */
    public static String hasDateClash(Camp selectedCamp, StudentUser studentUser) {
        for (Camp registeredCamp : studentUser.getAttendedCamps()) {
            // Assuming you have a method in the Camp class to get the start date
            LocalDate dateOfRegisteredCamp = selectedCamp.getDate();
            LocalDate registeredCampStartDate = registeredCamp.getDate();

            // Check for date clashes
            if (dateOfRegisteredCamp.isEqual(registeredCampStartDate)) {
                return registeredCamp.getName(); // Date clash found, returns the clashing camp
            }
        }
        return null; // No date clash
    }
}
