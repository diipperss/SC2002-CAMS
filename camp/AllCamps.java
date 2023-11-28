package camp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import user.*;

/**
 * This class manages the storage of staff and all camps.
 * It provides methods to add, remove, and retrieve camps, as well as register staff.
 * Additionally, it includes methods for sorting camps based on faculty and visibility.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class AllCamps {
    private static List<StaffUser> staffs = new ArrayList<>();
    private static List<Camp> allCamps = new ArrayList<>();
    
    /** 
     * Adds a new camp to the list of all camps.
     * 
     * @param camp The new camp created by staff.
     */
    public static void addCamp(Camp camp) {
        allCamps.add(camp);
    }

    /** 
     * Removes a camp from the list of all camps.
     * 
     * @param thecamp The camp to be removed.
     */
    public static void removeCamp(Camp thecamp) {
        Iterator<Camp> iterator = allCamps.iterator();
        while (iterator.hasNext()) {
            Camp camp = iterator.next();
            if (thecamp.equals(camp)) {
                iterator.remove();
                break; // Assuming each camp is unique, exit the loop after removal
            }
        }
    }

     /** 
     * Gets the list of all camps.
     * 
     * @return The list of all camps.
     */
    public static List<Camp> getAllCamps() {
        return allCamps;
    }

     /** 
     * Registers a staff member.
     * 
     * @param staff The staff member to be registered.
     */
    public static void registerStaff(StaffUser staff) {
        staffs.add(staff);
    }

    /**
     * Sorts the list of camps based on the specified faculty.
     * 
     * @param allCamps The list of camps to be sorted.
     * @param faculty The faculty used for sorting.
     * @return A new list containing only the camps with the specified faculty or NTU.
     */
    public static List<Camp> sortCampByFaculty(List<Camp> allCamps, Faculty faculty){
        List<Camp> newlist = new ArrayList<>(); 
        for(Camp camp: allCamps){
            if(camp.getFaculty() == faculty || camp.getFaculty() == Faculty.NTU){
                newlist.add(camp);
            }
        }
        return newlist;
    }

    /**
     * Sorts the list of camps to include only visible camps.
     * 
     * @param allCamps The list of camps to be sorted.
     * @return A new list containing only the visible camps.
     */
    public static List<Camp> sortOnlyVisibleCamps(List<Camp> allCamps){
        List<Camp> newlist = new ArrayList<>(); 
        for(Camp camp: allCamps){
            if(camp.getIsVisible()){
                newlist.add(camp);
            }
        }
        return newlist;
    }
}
