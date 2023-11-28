import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The InputExceptionHandler class provides methods for handling input exceptions.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class InputExceptionHandler {
    
    /**
     * Safely scans and retrieves the next integer from the given Scanner, handling InputMismatchException.
     *
     * @param scanner The Scanner object to read input from.
     * @return The scanned integer or 0 in case of an exception.
     */
    public static int scanNextInt(Scanner scanner) { 
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("You did not enter the correct input type.");
            return 0;
        }
    }
}
