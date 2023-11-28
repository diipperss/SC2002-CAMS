/**
 * The Inquiry class represents an inquiry made by a user for a specific camp.
 * It contains information such as the student's username, camp name, inquiry message, staff reply,
 * sender, replier ID, and the student who made the inquiry.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package inquiry;

import user.User;

public class Inquiry {
    private String studentUsername;
    private String campName;
    private String message;
    private String reply; // New field for staff reply
    private User sender;
    private String replierID;
    private User student;

    /**
     * Constructs an empty Inquiry object.
     */
    public Inquiry() {

    }

    /**
     * Gets the username of the student who made the inquiry.
     *
     * @return The username of the student.
     */
    public String getUsername() {
        return student.getUsername();
    }

    /**
     * Sets the student for this inquiry.
     *
     * @param student The user representing the student.
     */
    public void setUsername(User student) {
        this.student = student;
    }

    /**
     * Sets the student for this inquiry.
     *
     * @param student The user representing the student.
     */
    public void setStudent(User student) {
        this.student = student;
    }

    /**
     * Gets the student who made the inquiry.
     *
     * @return The user representing the student.
     */
    public User getStudent() {
        return student;
    }

    /**
     * Gets the replier ID associated with the inquiry.
     *
     * @return The ID of the staff member who replied to the inquiry.
     */
    public String getReplierID() {
        return replierID;
    }

    /**
     * Sets the replier ID associated with the inquiry.
     *
     * @param replierID The ID of the staff member who replied to the inquiry.
     */
    public void setReplierID(String replierID) {
        this.replierID = replierID;
    }

    /**
     * Gets the message of the inquiry.
     *
     * @return The inquiry message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the inquiry.
     *
     * @param message The inquiry message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the name of the camp associated with the inquiry.
     *
     * @return The name of the camp.
     */
    public String getCamp() {
        return campName;
    }

    /**
     * Sets the name of the camp associated with the inquiry.
     *
     * @param campName The name of the camp.
     */
    public void setCamp(String campName) {
        this.campName = campName;
    }

    /**
     * Gets the staff reply associated with the inquiry.
     *
     * @return The staff reply.
     */
    public String getReply() {
        return reply;
    }

    /**
     * Sets the staff reply associated with the inquiry.
     *
     * @param reply The staff reply.
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * Gets the name of the camp associated with the inquiry.
     *
     * @return The name of the camp.
     */
    public String getCampName() {
        return campName;
    }
}
