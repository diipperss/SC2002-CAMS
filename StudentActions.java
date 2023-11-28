import user.*;
import camp.*;
import errorhandling.InputExceptionHandler;
import inquiry.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the actions that a student can perform in the system.
 * It includes options to view camps, view attended camps, register for a camp,
 * withdraw from a camp, view inquiries, submit inquiries, edit inquiries, delete inquiries,
 * change password, view user info, and go back to the main menu.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24 
 *
 */
public class StudentActions {
    protected StudentInquiry studentinquiry;

    /**
     * Constructs a new StudentActions object for the given student user.
     *
     * @param studentuser The student user for whom the actions are performed.
     */
    public StudentActions(StudentUser studentuser) {
    }

    public static void performActions(StudentUser studentuser) {
       Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("Student Actions:");
            System.out.println("1. View Camps");
            System.out.println("2. View Attended Camps");
            System.out.println("3. Register for Camp");
            System.out.println("4. Withdraw from a Camp");
            System.out.println("5. View Enquiries");
            System.out.println("6. Submit Enquiry");
            System.out.println("7. Edit Enquiry");
            System.out.println("8. Delete Enquiry");
            System.out.println("9. Change Password");
            System.out.println("10. View User Info");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice;
            if(scanner.hasNextLine()){
                choice = InputExceptionHandler.scanNextInt(scanner);
                if(choice == -1) performActions(studentuser);
            }
            else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    StudentCamp.viewAvailableCamps(studentuser);
                    break;
                case 2:
                    StudentCamp.viewOwnCamps(studentuser);
                    break;
                case 3:
                    StudentCamp.signUpForCamp(studentuser);
                    if(studentuser.getIsCampCommittee() == true){
                        System.out.println("Log in again.");
                        return;
                    }else{
                        break;
                    }
                case 4:
                    StudentCamp.withdrawFromCamp(studentuser);
                    break;
                case 5:
                    StudentInquiry.viewInquiry(studentuser);
                    break;
                case 6:
                    StudentInquiry.submitInquiry(studentuser);
                    break;
                case 7:
                    StudentInquiry.editInquiry(studentuser);
                    break;
                case 8:
                    StudentInquiry.deleteInquiry(studentuser);
                    break;
                case 9:
                    studentuser.changePassword();
                    break;
                case 10:
                    studentuser.viewUserInfo();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    



}
