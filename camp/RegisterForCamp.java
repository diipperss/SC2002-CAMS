/**
 * The RegisterForCamp class provides methods for registering users as camp committee members and attendees.
 * It manages the addition of committee members and attendees to the camp's lists, and updates user roles and
 * attendance information accordingly.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package camp;

import java.util.HashMap;
import java.util.Map;
import user.CampCommitteeUser;
import user.StudentUser;

public class RegisterForCamp {

    /**
     * Registers a camp committee member for the specified camp.
     *
     * @param camp              The camp to register the committee member for.
     * @param campCommitteeUser The camp committee member to register.
     */
    public static void registerAsCampCommitteeMember(Camp camp, CampCommitteeUser campCommitteeUser) {
        camp.getCommitteeMembers().add(campCommitteeUser);
        Map<StudentUser, String> entry = new HashMap<>();
        entry.put(campCommitteeUser, "camp committee member"); // Store in student user
        camp.getAttendeeListAndRole().add(entry); // Store in camp
        campCommitteeUser.setMemberOf(camp);
        campCommitteeUser.setRole("campcommitteemember");
        campCommitteeUser.setCampCommittee(true);
        campCommitteeUser.setAttendedCamps(camp, "camp committee member");
        campCommitteeUser.getAvailableCamps().remove(camp);
    }

    /**
     * Registers an attendee for the specified camp.
     *
     * @param camp        The camp to register the attendee for.
     * @param studentUser The attendee to register.
     */
    public static void registerAsAttendee(Camp camp, StudentUser studentUser) {
        Map<StudentUser, String> entry = new HashMap<>();
        entry.put(studentUser, "attendee");
        camp.getAttendeeListAndRole().add(entry); // Store in camp
        camp.setTotalSlots(camp.getTotalSlots() - 1);
        studentUser.setAttendedCamps(camp, "attendee"); // Store in student user
        studentUser.getAvailableCamps().remove(camp);
    }
}
