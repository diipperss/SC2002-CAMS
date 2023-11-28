package user;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the management of logged-in users in the system.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class LoggedInUser {
    
    private static HashMap<String, Boolean> loggedInUserDatabase;

    /**
     * Constructs a new LoggedInUser object and initializes the user database.
     */
    public LoggedInUser() {
        
        loggedInUserDatabase = new HashMap<>();

        loggedInUserDatabase.put("YCHERN", false);
        loggedInUserDatabase.put("KOH1", false);
        loggedInUserDatabase.put("CT113", false);
        loggedInUserDatabase.put("YCN019", false);
        loggedInUserDatabase.put("DL007", false);
        loggedInUserDatabase.put("DON84", false);
        loggedInUserDatabase.put("ELI34", false);
        loggedInUserDatabase.put("LE51", false);
        loggedInUserDatabase.put("SL22", false);
        loggedInUserDatabase.put("AKY013", false);

        loggedInUserDatabase.put("HUKUMAR", false);
        loggedInUserDatabase.put("OURIN", false);
        loggedInUserDatabase.put("UPAM", false);
        loggedInUserDatabase.put("ANWIT", false);
        loggedInUserDatabase.put("ARVI", false);
    
    }

    /**
     * Checks if there is any logged-in user.
     *
     * @return true if there is a logged-in user, false otherwise.
     */
    public static boolean thereIsALoggedInUser() {
        boolean returnValue = false;

        // Specify the value to search for
        boolean targetValue = false;

        // Iterate over the entries and find keys with the target value
        for (Map.Entry<String, Boolean> entry : loggedInUserDatabase.entrySet()) {
            if (entry.getValue() == targetValue) {
                returnValue = true;
                break;
            }
        }
        return returnValue;
    }

    /**
     * Sets a user as logged in.
     *
     * @param loggedInUser The user to set as logged in.
     */
    public static void setLoggedInUser(User loggedInUser) {
        loggedInUserDatabase.put(loggedInUser.getUsername(), true);
    }

    /**
     * Clears the logged-in status for a user.
     *
     * @param loggedOutUser The user to clear from logged-in status.
     */
    public static void clearLoggedInUser(User loggedOutUser) {
        loggedInUserDatabase.put(loggedOutUser.getUsername(), false);
    }

    /**
     * Finds and returns the currently logged-in user.
     *
     * @return The currently logged-in user or null if no user is logged in.
     */
    public static User findLoggedInUser() {
        for (Map.Entry<String, Boolean> entry : loggedInUserDatabase.entrySet()) {
            if (entry.getValue()) {
                System.out.println("Found User: " + LoginService.userDatabase.get(entry.getKey()).getName());
                return LoginService.userDatabase.get(entry.getKey());
            }
        }
        return null;
    }
}