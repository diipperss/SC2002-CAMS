package user;
import camp.*;
import inquiry.*;
import user.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


/**
 * The LoginService class provides functionality for user authentication and manages a database of users.
 * 
 * The user database is initialized with some sample users given in the excel sheet and
 * the class includes a login method to authenticate users based on their username and password
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-23
 */


public class LoginService {
    /**
     * The map representing the user database with usernames as keys and corresponding Staff object or Student object as values.
     */
	static HashMap<String, User> userDatabase;
     
    /**
     * Constructs a new LoginService object and initializes the user database with sample users from the excel sheet
     */
    public LoginService() {
        userDatabase = new HashMap<>();
        // Initialize with some users (you may load this from a database in a real application)

        /* userDatabase.put("student1", new StudentUser("student1", "password", "student", "student1@gmail.com", "student1", "SCSE"));
        userDatabase.put("staff1", new StaffUser("staff1", "password", "staff", "staff1@gmail.com", "staff1", "SCSE"));
        userDatabase.put("staff2", new StaffUser("staff2", "password", "staff", "staff2@gmail.com", "staff2", "SCSE")); */

        // initialising student list
        userDatabase.put("YCHERN", new StudentUser("YCHERN", "password", "student", "YCHERN@e.ntu.edu.sg", "CHERN",Faculty.SCSE));
        userDatabase.put("KOH1", new StudentUser("KOH1", "password", "student", "KOH1@e.ntu.edu.sg", "KOH", Faculty.ADM));
        userDatabase.put("BR015", new StudentUser("BR015", "password", "student", "BR015@e.ntu.edu.sg", "BRANDON", Faculty.EEE));
        userDatabase.put("CT113", new StudentUser("CT113", "password", "student", "CT113@e.ntu.edu.sg", "CALVIN", Faculty.SCSE));
        userDatabase.put("YCN019", new StudentUser("YCN019", "password", "student", "YCN019@e.ntu.edu.sg", "CHAN", Faculty.NBS));
        userDatabase.put("DL007", new StudentUser("DL007", "password", "student", "DL007@e.ntu.edu.sg", "DENISE", Faculty.SCSE));
        userDatabase.put("DON84", new StudentUser("DON84", "password", "student", "DON84@e.ntu.edu.sg", "DONG", Faculty.ADM));
        userDatabase.put("ELI34", new StudentUser("ELI34", "password", "student", "ELI34@e.ntu.edu.sg", "ERNEST",  Faculty.EEE));
        userDatabase.put("LE51", new StudentUser("LE51", "password", "student", "LE51@e.ntu.edu.sg", "LEE", Faculty.SCSE));
        userDatabase.put("SL22", new StudentUser("SL22", "password", "student", "SL22@e.ntu.edu.sg", "LIU", Faculty.NBS));
        userDatabase.put("AKY013", new StudentUser("AKY013", "password", "student", "AKY013@e.ntu.edu.sg", "RAWAL", Faculty.SSS));
        
        // initialising staff list
        userDatabase.put("HUKUMAR", new StaffUser("HUKUMAR", "password", "staff", "HUKUMAR@e.ntu.edu.sg", "Madhukumar", Faculty.SCSE));
        userDatabase.put("OURIN", new StaffUser("OURIN", "password", "staff", "OURIN@e.ntu.edu.sg", "Alexei", Faculty.ADM));
        userDatabase.put("UPAM", new StaffUser("UPAM", "password", "staff", "UPAM@e.ntu.edu.sg", "Chattopadhyay", Faculty.EEE));
        userDatabase.put("ANWIT", new StaffUser("ANWIT", "password", "staff", "ANWIT@e.ntu.edu.sg", "Datta", Faculty.SCSE));
        userDatabase.put("ARVI", new StaffUser("ARVI", "password", "staff", "ARVI@e.ntu.edu.sg", "Arvind", Faculty.NBS));
        
        //initialising campcommittee list

    }

        public static void storeCampCommitteeUser(String key, CampCommitteeUser campcommitteeuser, StudentUser studentuser){
            userDatabase.remove(key, studentuser);
            userDatabase.put(key, campcommitteeuser);
        }
    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password entered by the user attempting to log in.
     * @return The User object if authentication is successful, or null if the login is invalid.
     */
    public static User login() {
        //declare scanner and get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        User user = userDatabase.get(username);

        //compare username to database
        if(user == null){
            System.out.println("Incorrect username!");
            return null;
        }

        //get password input
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        //check pasword
        if(!user.getPassword().equals(password)){
            System.out.println("Incorrect password!");
            return null;
        }else {
            return user;
        }
    }

    public static void logout(User loggedInUser) {
        //check if user exists
        if (loggedInUser != null) {
            System.out.println("Logging out " + loggedInUser.getUsername());
            loggedInUser = null;
        } else {
            System.out.println("Not logged in.");
        }
    }
}
