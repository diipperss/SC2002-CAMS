/**
 * The StaffSuggestions class provides functionality for staff members to respond to and view suggestions.
 * It implements the SuggestionsInterface.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package suggestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.*;
import errorhandling.InputExceptionHandler;
import user.*;

public class StaffSuggestions implements SuggestionsInterface {
    static Scanner scanner = new Scanner(System.in);

    public StaffSuggestions(StaffUser staffuser){
    }
    /**
     * Allows a staff member to respond to a suggestion.
     *
     * @param staff The staff member responding to the suggestion.
     */
 public static void respondToSuggestion(StaffUser staffuser) {
        System.out.println("Which camp do you want to view the suggestions of?");
        int i = 1;
        for(Camp camp: staffuser.getCreatedCamps()){
            System.out.println("Camp " + i + ": " + camp.getName());
            i++;
        }
        int choice = InputExceptionHandler.scanNextInt(scanner);      
        if(choice == -1) return;
        scanner.nextLine();

        System.out.println("Which suggestion number do you want to change?");
        Camp camp = staffuser.getCreatedCamps().get(choice-1);
        if(camp.getSuggestions().isEmpty()){
            System.out.println("There are no suggestions");
            return;
        }
        i=1;
        for(Suggestions suggestions : camp.getSuggestions()){
            System.out.println("Suggestion " + i + ": ");
            suggestions.printSuggestion();
            i++;
        }
        choice = InputExceptionHandler.scanNextInt(scanner);      
        if(choice == -1) return;
        scanner.nextLine();
        Suggestions suggestion = camp.getSuggestions().get(choice -1);
        if(suggestion.getApproval() == true){
            System.out.println("The suggestion is approved already");
            return;
        }
        System.out.println("Are you sure you want to approve this suggestion? (1:YES, 2:NO)");
        int option = InputExceptionHandler.scanNextInt(scanner);
        if (option==1){
        suggestion.setApproval(true); 
        suggestion.getCampCommitteeUser().setPoints(suggestion.getCampCommitteeUser().getPoints()+1);       
        System.out.println("Suggestion has been approved and student " + suggestion.getCampCommitteeUser().getName() +" has been award point");
        }
        else if (option==2){
        System.out.println("Suggestion has not been approved");
        return;
        }
        else{
            System.out.println("Wrong input. Please try again.");
            return;
        }
    }

    /**
     * Allows a staff member to view suggestions.
     *
     * @param staff The staff member viewing the suggestions.
     */
    public static void viewSuggestion(StaffUser staffuser) {
        for(Camp camp: staffuser.getCreatedCamps()){
            System.out.println("Camp: " +  camp.getName());
            if(camp.getSuggestions().isEmpty()){
                System.out.println("There are no suggestions for this camp");
            }
            else{
                int i = 1;
                for(Suggestions suggestions: camp.getSuggestions()){
                    System.out.println("Suggestion: " + i);
                    suggestions.printSuggestion();
                    i++;
                }
            }
        }
    }
}
