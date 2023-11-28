package user;
import java.util.ArrayList;
import java.util.List;
import camp.*;

/**
 * The CampCommitteeUser class represents a student user in the system who is part of the camp committee, extending the StudentUser class.
 * 
 * This class includes additional attributes such as points and the camp to which the user belongs as a committee member.
 * 
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class CampCommitteeUser extends StudentUser {

    /**
     * The points earned by the camp committee user.
     */
    private int points;

    /**
     * The camp to which the user belongs as a committee member.
     */
    private Camp memberOf;
    //private List<Camp> attendedCamps;
    /**
     * Constructs a new CampCommitteeUser object with the specified parameters.
     *
     * 
     * @param username The username of the camp committee user.
     * @param password The password of the camp committee user.
     * @param role The role of the camp committee user.
     * @param email The email address of the camp committee user.
     * @param name The name of the camp committee user.
     * @param faculty The faculty to which the camp committee user belongs.
     * @param memberOf The camp to which the camp committee user belongs as a committee member.
     */
    public CampCommitteeUser(String username, String password, String role, String email, String name, Faculty faculty) {
        super(username, password, role, email, name, faculty); // Assuming camp committee users are always part of the committee
        this.points = 0;
        this.setCampCommittee(true);
        this.campAndRole = super.campAndRole;
    }

    /**
     * Gets the camp to which the camp committee user belongs as a committee member.
     *
     * @return The camp to which the camp committee user belongs.
     */
    public Camp getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(Camp memberOf) {
        this.memberOf = memberOf;
    }
    /**
     * Gets the points earned by the camp committee user.
     *
     * @return The points earned by the camp committee user.
     */
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points=points;
    }
    public void printPoints(){
        System.out.println("Your points are: "+ getPoints());
    }
}
