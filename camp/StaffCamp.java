package camp;

import java.util.List;
import java.util.Scanner;

import errorhandling.InputExceptionHandler;
import user.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The StaffCamp class provides functionality for staff users to create, view, edit, and delete camps.
 * Staff users can perform operations related to camps, including managing camp details and availability.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StaffCamp implements UserCampI {

    static Faculty faculty;
    StaffUser staffuser;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a StaffCamp object with the specified staff user.
     *
     * @param staffuser The staff user associated with the StaffCamp object.
     */
    public StaffCamp(StaffUser staffuser){
        this.staffuser = staffuser;
    }

    /**
     * Creates a new camp based on user input.
     *
     * @param staffuser The staff user creating the camp.
     */
    public static void createCamp(StaffUser staffuser) {
        Scanner scanner = new Scanner(System.in);

        try {
        System.out.println("Enter the name of the new camp:");
        String campName = scanner.nextLine();

        System.out.println("Enter the start date of the new camp (YYYY-MM-DD):");
        String startDate = scanner.nextLine();
        LocalDate inputDate = DateFormat.parseDate(startDate);

        System.out.println("Enter the registration closing date of the new camp (YYYY-MM-DD):");
        String registrationClosingDate = scanner.nextLine();
        LocalDate inputRegistrationDate = DateFormat.parseDate(registrationClosingDate);

        //check if the dates match up
        if (inputDate.isBefore(inputRegistrationDate)){
            System.out.println("Registration date cannot be after camp start date.");
            
        }

        System.out.println("Enter the user group for the new camp:");
        String userGroup = scanner.nextLine();

        System.out.println("Enter the location of the new camp:");
        String location = scanner.nextLine();
        //scanner.nextLine();
        String staffInCharge = staffuser.getName();
        //System.out.println("");
        System.out.println("Enter the total slots for the new camp:");
        int totalSlots = InputExceptionHandler.scanNextInt(scanner);
        if(totalSlots == -1) return;
        scanner.nextLine(); // consume the newline character
        int campCommitteeSlots;
        do {
            System.out.println("Enter the camp committee slots for the new camp (should be <= 10):");
            campCommitteeSlots = InputExceptionHandler.scanNextInt(scanner);
            scanner.nextLine();
            if(campCommitteeSlots == -1) return;
            if (campCommitteeSlots > 10) {
                System.out.println("Invalid input. Camp committee slots should be 10 or fewer. Try again.");
            }
            else if (campCommitteeSlots > totalSlots) {
                System.out.println("Invalid input. Camp committee slots should should not be more than total slots.");
            }
        } while (campCommitteeSlots > 10 || campCommitteeSlots > totalSlots || campCommitteeSlots <0);
        

        System.out.println("Enter the description of the new camp:");
        String description = scanner.nextLine();

        System.out.println("Enter camp number you want to create (1: NTU 2: " + staffuser.getFaculty() + ")");
        int choice = InputExceptionHandler.scanNextInt(scanner);
        if(choice == -1) return;
        scanner.nextLine();
        if(choice == 1) faculty = Faculty.NTU;
        else if(choice == 2) faculty = staffuser.getFaculty();
        else{
            System.out.println("You have entered the wrong number. Try again");
            createCamp(staffuser);
        }
        // Assuming the Staff class has a method to create a new camp
        Camp camp = new Camp(campName, startDate, registrationClosingDate,
                        userGroup, location, staffInCharge,
                        totalSlots, campCommitteeSlots, description,
                        faculty);
        staffuser.getCreatedCamps().add(camp);
            AllCamps.registerStaff(staffuser); // Register the staff with the AllCamps class
            AllCamps.addCamp(camp); 

        System.out.println("Camp created successfully!");
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date. Please use the format YYYY-MM-DD. Please try again.");
            return; // consume the newline character
        }
    }

         /**
          * Displays the camps created by the staff user.
          *
          * @param staffuser The staff user whose camps are to be displayed.
          */
        public static void viewOwnCamps(StaffUser staffuser){
            if(staffuser.getCreatedCamps().isEmpty()){
                System.out.println("You have no camps");
                return;
            }
            int i = 1;
            for (Camp camp : staffuser.getCreatedCamps()) {
                System.out.println("Selection: " + i);
                camp.viewCampInfo();
                i++;
            }
        }
    /**
     * Edits the details of a specific camp created by the staff user.
     *
     * @param staffuser The staff user editing the camp.
     */
    public static void editCamp(StaffUser staffuser) {
        System.out.println("View your own camps");
        if(staffuser.getCreatedCamps().isEmpty()){
            System.out.println("You have no camps");
            return;
        }
        viewOwnCamps(staffuser);
        System.out.println("Do you want you want to edit your camp? (1:Yes 2:No)");
        int choice = InputExceptionHandler.scanNextInt(scanner);
        if(choice == -1) return;
        scanner.nextLine();
        if(choice == 1){}
        else if(choice == 2) return;
        else{ 
            System.out.println("You entered a wrong number. Try again");
            editCamp(staffuser);
        }
        System.out.println("Select which camp you want to edit: ");
        int campIndex = InputExceptionHandler.scanNextInt(scanner);
        if(campIndex == -1) return;
        scanner.nextLine(); // consume the newline character
    if (campIndex >= 1 && campIndex <= staffuser.getCreatedCamps().size()) {
        Camp camp = staffuser.getCreatedCamps().get(campIndex-1);
        System.out.println("1. Edit Camp Name");
        System.out.println("2. Edit Start Date");
        System.out.println("3. Edit Registration Closing Date");
        System.out.println("4. Edit User Group");
        System.out.println("5. Edit Location");
        System.out.println("6. Edit Visibility");
        System.out.println("7. Edit Total Slots");
        System.out.println("8. Edit Description");
        System.out.println("Enter your choice: ");  // Add this line to take user input for choice
        choice = InputExceptionHandler.scanNextInt(scanner);
        if(choice == -1) return;
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter the new camp name: ");
                String newName = scanner.nextLine();
                camp.setName(newName);
                break;
            case 2:
                System.out.print("Enter the new start date (YYYY-MM-DD): ");
                String inputnewStartDate = scanner.nextLine();
                LocalDate newStartDate = DateFormat.parseDate(inputnewStartDate);
                camp.setDate(newStartDate);
                break;
            case 3:
                System.out.print("Enter the new registration closing date (YYYY-MM-DD): ");
                String inputnewRegistrationClosingDate = scanner.nextLine();
                LocalDate newRegistrationClosingDate = DateFormat.parseDate(inputnewRegistrationClosingDate);
                camp.setRegistrationClosingDate(newRegistrationClosingDate);
                break;
            case 4:
                System.out.print("Enter the new user group: ");
                String newUserGroup = scanner.nextLine();
                camp.setUserGroup(newUserGroup);
                break;
            case 5:
                System.out.print("Enter the new location: ");
                String newLocation = scanner.nextLine();
                camp.setLocation(newLocation);
                break;
            case 6:
                System.out.println("Enter visibility (1: Visible 2: Not visible): ");
                choice = InputExceptionHandler.scanNextInt(scanner);
                if(choice == -1) return;
                switch(choice){
                    case(1):
                        camp.setVisibility(true);
                        break;
                    case(2):
                        camp.setVisibility(false);
                        break;
                    default:
                        System.out.println("Please select a number again");
                }
                break;
            case 7:
                int newTotalSlots;   
                    System.out.print("Enter the new total slots: ");
                    newTotalSlots = InputExceptionHandler.scanNextInt(scanner);
                    if(newTotalSlots == -1) return;
                    scanner.nextLine();
                    camp.setTotalSlots(newTotalSlots);
                break;
            case 8:
                System.out.print("Enter the new description: ");
                String newDescription = scanner.nextLine();
                camp.setDescription(newDescription);
                break;
            default:
                System.out.println("Invalid choice. No changes made.");
                return;
        }
        System.out.println("Camp details updated successfully!");
        }else{
            System.out.println("Invalid camp index. No changes made.");
            }
    }
        /**
        * Deletes a specific camp created by the staff user.
        *
        * @param staffuser The staff user deleting the camp.
        */
        public static void deleteCamp(StaffUser staffuser) {
            if(staffuser.getCreatedCamps().isEmpty()){
                System.out.println("You have no camps");
                return;
            }
            int i = 1;
            for (Camp camp : staffuser.getCreatedCamps()) {
                System.out.println("Selection: " + i);
                camp.viewCampInfo();
                i++;
            }
            System.out.println("Select which camp you want to delete: ");
            //viewOwnCamps();
            int campIndex = InputExceptionHandler.scanNextInt(scanner);
            if(campIndex == -1) return;
            scanner.nextLine();
            Camp camp = staffuser.getCreatedCamps().get(campIndex-1);
            if (campIndex >= 1 && campIndex <= staffuser.getCreatedCamps().size()) {
                staffuser.getCreatedCamps().remove(camp);
            AllCamps.removeCamp(camp);
            }else{
                System.out.println("Invalid camp index. No changes made.");
            }
        }

    /**
     * Displays information about all camps.
     */
    public static void viewAllCamps() {
        System.out.println("All Camps:");
        List<Camp> allCamps = AllCamps.getAllCamps();
        for (Camp camp : allCamps) {
            camp.viewCampInfo();
        }
    }
   
}
