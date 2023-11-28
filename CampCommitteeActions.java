
import java.util.List;
import java.util.Scanner;

import camp.AllCamps;
import camp.Camp;
import camp.CampCommitteeCamp;
import camp.StudentCamp;
import errorhandling.InputExceptionHandler;
import inquiry.*;
import user.*;
import report.*;
import suggestions.*;

/**
 * This class represents the actions that a Camp Committee member can perform in the system.
 * It extends the functionality of the StudentActions class.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 * 
 */
public class CampCommitteeActions extends StudentActions {
    
    /**
     * Constructs a new CampCommitteeActions object for the given Camp Committee user.
     *
     * @param campcommitteeuser The Camp Committee user for whom the actions are performed.
     */
    public CampCommitteeActions(CampCommitteeUser campcommitteeuser) {
        super(campcommitteeuser);
    }

    /**
     * Performs various actions based on the Camp Committee member's choice.
     *
     * @param campcommitteeuser The Camp Committee user for whom actions are performed.
     */
public static void performActions(CampCommitteeUser campcommitteeuser) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Camp Committee Actions:");
            System.out.println("1. View Camps");
            System.out.println("2. View Attended Camps");
            System.out.println("3. Register for Camp");
            System.out.println("4. Withdraw from a Camp");
            System.out.println("5. View your own camp details"); 
            System.out.println("6. Generate Camp Report"); 
            System.out.println("7. View Inquiries"); 
            System.out.println("8. Respond To Inquiries"); 
            System.out.println("9. Submit Suggestions");
            System.out.println("10. View Suggestions"); 
            System.out.println("11. Edit Suggestions");
            System.out.println("12. Delete Suggestions"); 
            System.out.println("13. View User Info"); 
            System.out.println("14. View Your Points");
            System.out.println("15. Change your password");
            System.out.println("16. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = InputExceptionHandler.scanNextInt(scanner);
            if(choice == -1) performActions(campcommitteeuser);
          
            switch (choice) {
                case 1:
                    CampCommitteeCamp.viewAvailableCamps(campcommitteeuser);
                    break;
                case 2:
                    CampCommitteeCamp.viewOwnCamps(campcommitteeuser);
                    break;
                case 3:
                    CampCommitteeCamp.signUpForCamp(campcommitteeuser);
                    break;
                case 4:
                    CampCommitteeCamp.withdrawFromCamp(campcommitteeuser);
                    break;
                case 5:
                    CampCommitteeCamp.viewOwnCamp(campcommitteeuser);
                    break;
                case 6:
                    CampCommitteeReport.generateStudentsList(campcommitteeuser);
                    break;
                case 7:
                    CampCommitteeInquiry.viewInquiry(campcommitteeuser);
                    break;
                case 8:
                    CampCommitteeInquiry.respondToInquiry(campcommitteeuser);
                    break;
                case 9:
                    CampCommitteeSuggestions.submitSuggestion(campcommitteeuser);
                    break;
                case 10:
                    CampCommitteeSuggestions.viewSuggestions(campcommitteeuser);
                    break;
                case 11:
                    CampCommitteeSuggestions.editSuggestions(campcommitteeuser);
                    break;
                case 12:
                    CampCommitteeSuggestions.deleteSuggestion(campcommitteeuser);
                    break;
                case 13:
                    campcommitteeuser.viewUserInfo();
                    break;
                case 14:
                    campcommitteeuser.printPoints();
                    break;
                case 15:
                    campcommitteeuser.changePassword();
                    break;
                case 16: 
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
