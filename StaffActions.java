import user.*;
import camp.*;
import errorhandling.InputExceptionHandler;
import inquiry.*;
import report.*;
import suggestions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the actions that a staff member can perform in the system.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StaffActions {
    
    /**
     * Constructs a new StaffActions object for the given staff user.
     *
     * @param staffuser The staff user for whom the actions are performed.
     */
    public StaffActions(StaffUser staffuser){
    };

    static Scanner scanner = new Scanner(System.in);
    Faculty faculty;

    /**
     * Performs various actions based on the staff member's choice.
     *
     * @param staffuser The staff user for whom actions are performed.
     */
    public static void performActions(StaffUser staffuser) {
        //Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Staff Actions:");
            System.out.println("1. Create Camp");
            System.out.println("2. View your own Camp");
            System.out.println("3. Delete Camp");
            System.out.println("4. Edit Camp");
            System.out.println("5. View all the Camps");
            System.out.println("6. View Inquiries");
            System.out.println("7. Respond to Inquiries");
            System.out.println("8. View Suggestions");
            System.out.println("9. Respond to Suggestion");
            System.out.println("10. Generate a report of the list of students attending each camp");
            System.out.println("11. Generate a performance report of the camp committee members");
            System.out.println("12. Change Password");
            System.out.println("13. Back to Main Menu");           
            System.out.print("Enter your choice: ");  // Add this line to take user input for choice
            int choice;
            if(scanner.hasNextLine()){
                choice = InputExceptionHandler.scanNextInt(scanner);      
                if(choice == -1) performActions(staffuser);   
             }
            else {
                //System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    StaffCamp.createCamp(staffuser);
                    break;
                case 2:
                    StaffCamp.viewOwnCamps(staffuser);
                    break;
                case 3:
                    StaffCamp.deleteCamp(staffuser);
                    break;
                case 4:
                    StaffCamp.editCamp(staffuser);
                    break;
                case 5:
                     StaffCamp.viewAllCamps();
                	return;
                case 6:
                    StaffInquiry.viewInquiry(staffuser);
                    break;
                case 7:
                    StaffInquiry.respondToInquiry(staffuser);
                    break;
                case 8:
                    StaffSuggestions.viewSuggestion(staffuser);
                    break;
                case 9:
                    StaffSuggestions.respondToSuggestion(staffuser);
                    break;
                case 10:
                    StaffReport.generateStudentsList(staffuser);
                    break;             
                case 11:
                    StaffReport.generateCampCommitteeList(staffuser);
                    break;
                case 12:
                	staffuser.changePassword();
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}