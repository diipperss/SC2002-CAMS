/**
 * The InputExceptionHandler class provides methods for handling input-related exceptions.
 * It includes a method for scanning the next integer, handling InputMismatchException,
 * and prompting the user for valid input.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package errorhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputExceptionHandler {

    /**
     * Scans the next integer using the provided Scanner.
     * Handles InputMismatchException and prompts the user for valid input.
     *
     * @param scanner The Scanner object used for input.
     * @return The scanned integer or -1 if an exception occurs.
     */
    public static int scanNextInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("You can only enter an integer");
            return -1;
        }
    }
}
