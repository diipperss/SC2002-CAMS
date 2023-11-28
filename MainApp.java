import user.*;
import report.*;
import suggestions.*;
import camp.*;
import errorhandling.InputExceptionHandler;
import fontutils.*;
import inquiry.*;

import java.util.Scanner;


/**
 * The MainApp class is the entry point for the application, providing functionality for user authentication, login, and menu navigation.
 * It includes methods for handling user login, logout, and displaying menu options based on user roles.
 * The application activates StudentActions,StaffActions and CampcommiteeActions interface base on the user respective role
 * 
 * 
 * 
 * @author Grp4
 * @version 1.0
 * @since YYYY-MM-DD
 */
public class MainApp {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        LoggedInUser lInUser = new LoggedInUser();
        Scanner scanner = new Scanner(System.in);

        User loggedInUser = null;

        if (LoggedInUser.thereIsALoggedInUser() == true) {
            loggedInUser = LoggedInUser.findLoggedInUser();
        } else {
            loggedInUser = null;
        }

        while (true) {
            FontUtils.displayCAMS();
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = InputExceptionHandler.scanNextInt(scanner);
            if (choice == -1) {continue;}

            switch (choice) {
                case 1:
                    if(loggedInUser == null) {
                        loggedInUser = LoginService.login();
                    }
                    else {
                        System.out.println(loggedInUser.getUsername() + " please log out.");
                        continue;
                    }
                    break;
                case 2:
                    LoginService.logout(loggedInUser);
                    loggedInUser = null;
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (loggedInUser != null) {
                if ("student".equals(loggedInUser.getRole())) {
                    StudentUser studentuser = (StudentUser) loggedInUser;
                    if(!(studentuser.getIsCampCommittee())){
                    StudentActions.performActions(studentuser);
                    }
                }
            
                 else if ("staff".equals(loggedInUser.getRole())) {
                    if (loggedInUser instanceof StaffUser) {
                        StaffUser staffuser = (StaffUser) loggedInUser;
                        StaffActions.performActions(staffuser);
                    }
                }                        
                //System.out.println("campcommitteemember".equals(loggedInUser.getRole()));
                else if("campcommitteemember".equals(loggedInUser.getRole())){                  
                        CampCommitteeUser campcommitteeuser = (CampCommitteeUser) loggedInUser;
                        CampCommitteeActions.performActions(campcommitteeuser);
                    }
                    else {
                        System.out.println("Invalid user type.");
                    }
                } 
                }
            }
    } 
            
        
        
    


    /**
     * Performs user login using the provided LoginService.
     *
     * @param loginService The LoginService used for user authentication.
     * @return The User object representing the logged-in user, or null if the login is unsuccessful.
     */
    /*private static User login(LoginService loginService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return loginService.login(username, password);
    }*/

  /**
    * Logs out the specified user.
    *
    * @param user The User object representing the logged-in user.
    */
    /*private static void logout(User user) {
        if (user != null) {
            System.out.println("Logging out " + user.getUsername());
        } else {
            System.out.println("Not logged in.");
        }
    }*/
