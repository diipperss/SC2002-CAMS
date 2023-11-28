package user;

import java.util.ArrayList;
import java.util.List;
import camp.*;

/**
 * The StaffUser class represents a staff user in the system, extending the  User class.
 * Staff users have the ability to create camps, and this class includes a list to keep track of camps created by the staff.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StaffUser extends User {

    /**
     * The list of camps created by the staff user.
     */
    private List<Camp> createdCamps;

    /**
     * Constructs a new StaffUser object with the specified parameters.
     *
     * @param username The username of the staff user.
     * @param password The password of the staff user.
     * @param role The role of the staff user.
     * @param email The email address of the staff user.
     * @param name The name of the staff user.
     * @param sss The faculty to which the staff user belongs (assumed to be SSS based on the provided constructor).
     */
    public StaffUser(String username, String password, String role, String email, String name, Faculty sss) {
        super(username, password, role, email, name, sss);
        this.createdCamps = new ArrayList<>();
    }

    /**
     * Gets the list of camps created by the staff user.
     *
     * @return The list of camps created by the staff user.
     */
    public List<Camp> getCreatedCamps() {
        return createdCamps;
    }
}
