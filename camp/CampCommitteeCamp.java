package camp;




import java.util.Scanner;
import errorhandling.InputExceptionHandler;
import user.CampCommitteeUser;
import java.util.List;
/**
 * The CampCommitteeCamp class represents a camp for camp committee members, extending the StudentCamp class.
 * It provides methods for viewing camp information, signing up for camps, and withdrawing from camps.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class CampCommitteeCamp extends StudentCamp {

    /**
     * Constructs a CampCommitteeCamp object with the given CampCommitteeUser.
     *
     * @param campCommitteeUser The camp committee user associated with this camp.
     */
    public CampCommitteeCamp(CampCommitteeUser campCommitteeUser) {
        super(campCommitteeUser); // Call the constructor of the superclass (StudentCamp)
    }

    /**
     * Views the information of the camp that the camp committee user is a member of.
     *
     * @param campCommitteeUser The camp committee user viewing their own camp.
     */
    public static void viewOwnCamp(CampCommitteeUser campCommitteeUser) {
        Camp camp = campCommitteeUser.getMemberOf();
        camp.viewCampInfo();
    }

    /**
     * Allows the camp committee user to sign up for an available camp.
     *
     * @param campCommitteeUser The camp committee user signing up for a camp.
     */
    public static void signUpForCamp(CampCommitteeUser campCommitteeUser) {
        if (campCommitteeUser.getAvailableCamps().isEmpty()) {
            System.out.println("There are no camps available to join");
            return;
        }
        viewAvailableCamps(campCommitteeUser);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the camp you want to register for: ");
        int campIndex = InputExceptionHandler.scanNextInt(scanner);
        if (campIndex == -1) return;
        scanner.nextLine();
        if (campIndex >= 1 && campIndex <= campCommitteeUser.getAvailableCamps().size()) {
            Camp selectedCamp = campCommitteeUser.getAvailableCamps().get(campIndex - 1);
            if (selectedCamp.getTotalSlots() == 0) {
                System.out.println("Camp is full");
                return;
            }
            if (DateFormat.hasDateClash(selectedCamp, studentuser) == null) {
                System.out.println("You have successfully signed up as an attendee");
                RegisterForCamp registerForCamp = new RegisterForCamp();
                RegisterForCamp.registerAsAttendee(selectedCamp, studentuser);
            }
        } else {
            System.out.println("Invalid camp index.");
        }
    }

    /**
     * Allows the camp committee user to withdraw from a camp.
     *
     * @param campCommitteeUser The camp committee user withdrawing from a camp.
     */
    public static void withdrawFromCamp(CampCommitteeUser campCommitteeUser) {
        if (campCommitteeUser.getAttendedCamps().isEmpty()) {
            System.out.println("You are not in any camps");
            return;
        }
        List<Camp> camps = campCommitteeUser.getAttendedCamps();
        int i = 1;
        for (Camp camp : camps) {
            System.out.println(i + ")" + camp.getName());
        }
        System.out.println("Select the camp you want to withdraw from");
        int choice = InputExceptionHandler.scanNextInt(scanner);
        if (choice == -1) return;
        scanner.nextLine();
        if (choice > campCommitteeUser.getAttendedCamps().size()) {
            System.out.println("You have entered a wrong number");
            withdrawFromCamp(campCommitteeUser);
        } else if (camps.get(choice - 1) == campCommitteeUser.getMemberOf()) {
            System.out.println("You cannot leave this camp as you are a camp committee member");
            return;
        }
        Camp camp = campCommitteeUser.getAttendedCamps().get(choice - 1);
        System.out.println("Are you sure you want to withdraw? (1: Yes 2: No)");
        choice = InputExceptionHandler.scanNextInt(scanner);
        if (choice == -1) return;
        scanner.nextLine();
        if (choice == 1);
        else return;
        campCommitteeUser.getAttendedCamps().remove(camp);
        camp.setTotalSlots(camp.getTotalSlots() + 1);
        System.out.println("Withdrawn from camp: " + camp.getName());
    }
}
