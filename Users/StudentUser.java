package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import camp.*;

/**
 * The StudentUser class represents a student user in the system, extending the User class.
 * 
 * Student users have additional attributes such as a list of camps they are attending and a flag indicating whether they are part of the camp committee.
 * 
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StudentUser extends User {

    /**
     * The list of camps attended by the student.
     */
    protected List<Map<Camp, String>> campAndRole;

    /**
     * A flag indicating whether the student is part of the camp committee.
     */
    private boolean isCampCommittee;
  


    /**
     * Constructs a new StudentUser object with the specified parameters.
     *
     * @param username The username of the student user.
     * @param password The password of the student user.
     * @param role The role of the student user.
     * @param email The email address of the student user.
     * @param name The name of the student user.
     * @param faculty The faculty to which the student user belongs.
     */
    public StudentUser(String username, String password, String role, String email, String name, Faculty faculty) {
        super(username, password, role, email, name, faculty);
        this.campAndRole = new ArrayList<>();
        this.isCampCommittee = false;

}

    /**
     * Sets whether the student is part of the camp committee.
     *
     * @param isCampCommittee A flag indicating whether the student is part of the camp committee.
     */
    public void setCampCommittee(boolean isCampCommittee) {
        this.isCampCommittee = isCampCommittee;
    }

    /**
     * Gets the list of camps attended by the student.
     *
     * @return The list of camps attended by the student.
     */
    public List<Camp> getAttendedCamps() {
        List<Camp> camps = new ArrayList<>();
        for (Map<Camp, String> campRoleMap : campAndRole) {
            for (Camp camp : campRoleMap.keySet()) {
                camps.add(camp);
            }
        }
        return camps;          
    }
    public List<Map<Camp, String>> getCampAndRole(){
        return campAndRole;
    }
    /**
     * Gets whether the student is part of the camp committee.
     *
     * @return true if the student is part of the camp committee,  false otherwise
     */
    public boolean getIsCampCommittee() {
        return isCampCommittee;
    }

    /**
     * Adds a camp to the list of camps attended by the student.
     *
     * @param attendedCamp The camp attended by the student.
     */
    public void setAttendedCamps(Camp attendedCamp, String role) {
        Map<Camp, String> campRoleMap = new HashMap<>();
        campRoleMap.put(attendedCamp, role);
        this.campAndRole.add(campRoleMap);
    }
    public List<Camp> getAvailableCamps() {
          List<Camp> availableCamps = new ArrayList<>();
           for(Camp camp : AllCamps.getAllCamps()){
            if((camp.getFaculty() == getFaculty() ||
             camp.getFaculty() == Faculty.NTU) && camp.getIsVisible() == true && camp.getTotalSlots() > 0 
             && !(getAttendedCamps().contains(camp))){
            availableCamps.add(camp);
             }
            }
            return availableCamps;
    }


    public void viewUserInfo() {
        System.out.println("User Information:");
        System.out.println(viewInfo());
        System.out.println("Is Camp Committee Member: " +  getIsCampCommittee());
    }


}
