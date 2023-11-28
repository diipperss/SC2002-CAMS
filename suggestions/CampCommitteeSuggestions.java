package suggestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.*;
import errorhandling.InputExceptionHandler;
import user.*;

/**
 * The CampCommitteeSuggestions class provides functionality for managing and interacting with
 * suggestions related to camps for the camp committee users.
 * It implements the SuggestionsInterface.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class CampCommitteeSuggestions implements SuggestionsInterface{
    public static CampCommitteeUser campcommitteeuser;

        public CampCommitteeSuggestions(CampCommitteeUser campcommitteeuser) {
    }
    static Scanner scanner = new Scanner(System.in);  

    /**
     * Displays the suggestions associated with the camp committee user's camp.
     *
     * @param campcommitteeuser The camp committee user for whom suggestions are viewed.
     */
    public static void viewSuggestions(CampCommitteeUser campcommitteeuser) {
        if (campcommitteeuser.getMemberOf().getSuggestions().isEmpty()){
            System.out.println("No suggestions");
            return;
        }
         if (campcommitteeuser.getMemberOf() == null) {
            System.out.println("No camps available!");
        } else {
            for(Suggestions suggestion : campcommitteeuser.getMemberOf().getSuggestions()){
                suggestion.printSuggestion();
            }
        }
}
    /**
     * Allows the camp committee user to edit suggestions for the associated camp.
     *
     * @param campcommitteeuser The camp committee user initiating the suggestion editing.
     */
    public static void editSuggestions(CampCommitteeUser campcommitteeuser) {
         if (campcommitteeuser.getMemberOf() == null) {
            System.out.println("No camps available!");
        } else {
        Scanner scanner = new Scanner(System.in);
        if (campcommitteeuser.getMemberOf().getSuggestions().isEmpty()){
            System.out.println("No suggestions");
            return;
        }
        System.out.println("Which suggestion number do you want to edit");
        Camp camp = campcommitteeuser.getMemberOf();
        int i = 1;
        for(Suggestions suggestion : camp.getSuggestions()){
            System.out.println("Suggestion: " + i);
            suggestion.printSuggestion();
            i++;
        }
        int choice = InputExceptionHandler.scanNextInt(scanner);
        scanner.nextLine();
        if(choice == -1) editSuggestions(campcommitteeuser);
        Suggestions suggestionObj = camp.getSuggestions().get(choice-1);
        if(suggestionObj.getApproval()) {
            System.out.println("This camp has been approved and cannot be edited!");
            return;
            }       
        System.out.println("What suggestion do you want to make?");
        suggestionObj.printParameters();
                choice = InputExceptionHandler.scanNextInt(scanner);
                scanner.nextLine();
                if(choice == -1) return;
                String suggestion = "null";
                switch (choice) {
                    case 1:
                        suggestion = "Camp Name";
                        break;
                    case 2:
                        suggestion = "Date";
                        break;
                    case 3:
                        suggestion = "Registration Closing Date";
                        break;
                    case 4:
                        suggestion = "User Group";
                        break;
                    case 5:
                        suggestion = "Location";
                        break;
                    case 6:
                        suggestion = "TotalSlots";
                        break;
                    case 7:
                        suggestion = "Camp Committee Slots";
                        break;
                    case 8:
                        suggestion = "Description";
                        break;
                    default:
                        System.out.println("Invalid option");
                        submitSuggestion(campcommitteeuser);
                        break;
                }
                System.out.println("What do you want the new value to be?");
                String change = scanner.nextLine();
                suggestionObj.setSuggestion(suggestion);
                suggestionObj.setChange(change);
                System.out.println("You have changed successfully");
        }
    }
 
        
    

    /**
     * Deletes a suggestion based on the user's choice.
     *
     * @param campcommitteeuser The camp committee user initiating the suggestion deletion.
     */
    public static void deleteSuggestion(CampCommitteeUser campcommitteeuser){
         if (campcommitteeuser.getMemberOf() == null) {
            System.out.println("No camps available!");
        }
        if (campcommitteeuser.getMemberOf().getSuggestions().isEmpty()){
            System.out.println("No suggestions");
            return;
        } 
        else {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Which suggestion number do you want to delete");
        Camp camp = campcommitteeuser.getMemberOf();
        int i = 1;
        for(Suggestions suggestion : camp.getSuggestions()){
            System.out.println("Suggestion: " + i);
            suggestion.printSuggestion();            i++;
        }
        int choice = InputExceptionHandler.scanNextInt(scanner);
        scanner.nextLine();
        if(campcommitteeuser.getMemberOf().getSuggestions().get(choice-1).getApproval()) {
            System.out.println("This camp has been approved and cannot be deleted!");
            return;
        }   
        campcommitteeuser.getMemberOf().getSuggestions().remove(choice-1);
        campcommitteeuser.setPoints(campcommitteeuser.getPoints()-1);
        }
        System.out.println("You have deleted successfully and your point has been deducted");
    }

    /**
     * Submits a new suggestion for the associated camp.
     *
     * @param campcommitteeuser The camp committee user submitting the suggestion.
     */
    public static void submitSuggestion(CampCommitteeUser campcommitteeuser) {
                String campName = campcommitteeuser.getMemberOf().getName().toUpperCase();
    
                System.out.println("What suggestion would you like to make?");
                System.out.println("1. Camp Name");
                System.out.println("2. Dates");
                System.out.println("3. Registration Closing Date");
                System.out.println("4. User group");
                System.out.println("5. Location");
                System.out.println("6. Total Slots");
                System.out.println("7. Camp Committee Slots");
                System.out.println("8. Description: ");
                int choice = InputExceptionHandler.scanNextInt(scanner);
                scanner.nextLine();
                if(choice == -1) return;
                String suggestion = "null";
                switch (choice) {
                    case 1:
                        suggestion = "campName";
                        break;
                    case 2:
                        suggestion = "date";
                        break;
                    case 3:
                        suggestion = "registrationClosingDate";
                        break;
                    case 4:
                        suggestion = "userGroup";
                        break;
                    case 5:
                        suggestion = "location";
                        break;
                    case 6:
                        suggestion = "totalSlots";
                        break;
                    case 7:
                        suggestion = "campCommitteeSlots";
                        break;
                    case 8:
                        suggestion = "description";
                    default:
                        System.out.println("Invalid option");
                        submitSuggestion(campcommitteeuser);
                        break;
                }
                System.out.println("What do you want the new value to be?");
                String change = scanner.nextLine();
                Suggestions suggestionObj = new Suggestions();
                suggestionObj.setSuggestion(suggestion);
                suggestionObj.setChange(change);
                suggestionObj.setCamp(campName);
                suggestionObj.setApproval(false);
                suggestionObj.setCampCommitteeUser(campcommitteeuser);
                Camp camp = campcommitteeuser.getMemberOf();
                // Adding the suggestionObj to the selected camp
                System.out.println("Selected Camp: " + camp.getName());
                camp.getSuggestions().add(suggestionObj);
                campcommitteeuser.setPoints(campcommitteeuser.getPoints()+1);
                System.out.println("You have gained one more point!");
            }
}
    

