package camp;
import user.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import errorhandling.InputExceptionHandler;

/**
 * This class provides functionalities related to camps for student users.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StudentCamp implements UserCampI{
    public static StudentUser studentuser;
    static Scanner scanner = new Scanner(System.in);

    public StudentCamp(StudentUser studentuser){
        }
    
    /**
     * Displays the available camps for a student user.
     * 
     * @param studentuser The student user to view available camps.
     */
    public static void viewAvailableCamps(StudentUser studentuser){
        if (studentuser.getAvailableCamps().isEmpty()) {
            System.out.println("No camps available.");
        } else {
            System.out.println("Available Camps:");
            for (int i = 0; i < studentuser.getAvailableCamps().size(); i++) {
                Camp camp = studentuser.getAvailableCamps().get(i);
                System.out.println((i + 1) + ". Camp Name: " + camp.getName() + " Number of slots left: " + camp.getTotalSlots());
                // Add more details if needed
            }
        }
    }

    /**
     * Allows a student user to sign up for a camp.
     * 
     * @param studentuser The student user signing up for the camp.
     */
    public static void signUpForCamp(StudentUser studentuser) {
        if(studentuser.getAvailableCamps().isEmpty()){
            System.out.println("There are no camps available to join");
            return;
        }
        viewAvailableCamps(studentuser);     
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the camp you want to register for: ");
        int campIndex = InputExceptionHandler.scanNextInt(scanner);
        if(campIndex == -1) return;
        scanner.nextLine(); 
        if (campIndex >= 1 && campIndex <= studentuser.getAvailableCamps().size()) {
            Camp selectedCamp = studentuser.getAvailableCamps().get(campIndex - 1);
            if (selectedCamp.getTotalSlots() == 0) {
            System.out.println("Camp is full"); 
            return;}
            if (DateFormat.hasDateClash(selectedCamp, studentuser) == null) {
                RegisterForCamp registerForCamp = new RegisterForCamp();
                if(studentuser.getIsCampCommittee()){
                    System.out.println("Registered successfully as an attendee for " + selectedCamp.getName());
                    RegisterForCamp.registerAsAttendee(selectedCamp, studentuser);
                    return;
                }
                System.out.println("Do you want to be in the camp committee? (1: No, 2: Yes)");
                int choice = InputExceptionHandler.scanNextInt(scanner);
                if(choice == -1) return;
                scanner.nextLine();
                if (choice == 1) {
                    System.out.println("Registered successfully as an attendee for " + selectedCamp.getName());
                    RegisterForCamp.registerAsAttendee(selectedCamp, studentuser);                                 
                } else if (choice == 2) {
                    System.out.println("Registered successfully as a Camp Committee member for " + selectedCamp.getName());                   
                    studentuser = new CampCommitteeUser(studentuser.getUsername(), studentuser.getPassword(), studentuser.getRole(),studentuser.getEmail(), studentuser.getName(), studentuser.getFaculty());
                    CampCommitteeUser campcommitteeuser = (CampCommitteeUser) studentuser;
                    RegisterForCamp.registerAsCampCommitteeMember(selectedCamp, campcommitteeuser);           
                    LoginService.storeCampCommitteeUser(studentuser.getUsername(), campcommitteeuser, studentuser);
                    System.out.println("Please log out to update access.");
                } 
            } else {
                System.out.println("Date clash detected. Cannot register for the camp.");
            }
        } else {
            System.out.println("Invalid camp index.");
        }
    
    }
    
    
    /**
     * Displays the camps attended by a student user.
     * 
     * @param studentuser The student user to view attended camps.
     */
    public static void viewOwnCamps(StudentUser studentuser) {
        List<Map<Camp, String>> campAndRole = studentuser.getCampAndRole();
        if (campAndRole.isEmpty()) {
            System.out.println("You have not attended any camps yet.");
        } else {
            System.out.println("Attended Camps:");
            for (int i = 0; i < campAndRole.size(); i++) {
                Map<Camp, String> campRoleMap = campAndRole.get(i);
                for(Map.Entry<Camp, String> entry : campRoleMap.entrySet()){
                    Camp camp = entry.getKey();
                    String role = entry.getValue();
                    System.out.println("Camp: " + camp.getName() + ", Role: " + role);
                }
        }
                } 
    }  
    
    /**
     * Allows a student user to withdraw from a camp.
     * 
     * @param studentuser The student user withdrawing from the camp.
     */
    public static void withdrawFromCamp(StudentUser studentuser) {
        if(studentuser.getAttendedCamps().isEmpty()){
            System.out.println("You are not in any camps");
            return;
        }
        int i = 1;
        List<Camp> camps = studentuser.getAttendedCamps();
        for(Camp camp: camps){
            System.out.println(i +")" + camp.getName());
        }
        System.out.println("Select the camp you want to withdraw from");
        int choice = InputExceptionHandler.scanNextInt(scanner);
        if(choice == -1) return;
        scanner.nextLine();
        if(choice > studentuser.getAttendedCamps().size()){
            System.out.println("You have entered a wrong number");
            withdrawFromCamp(studentuser);
        }
        Camp camp = studentuser.getAttendedCamps().get(i-1);
        System.out.println("Are you sure you want to withdraw? (1: Yes 2: No)");
        choice = InputExceptionHandler.scanNextInt(scanner);
        if(choice == -1) return;
        scanner.nextLine();
        if(choice == 1);
        else return;
        studentuser.getAttendedCamps().remove(camp);
        studentuser.getAvailableCamps().remove(camp);
        camp.setTotalSlots(camp.getTotalSlots()+1);
        System.out.println("Withdrawn from camp: " + camp.getName());
    }
    
}
