
package inquiry;

import user.User;

/**
 * This class represents an inquiry stored in the system. It extends the User class and includes information
 * such as username, inquiry message, associated camp, reply, and the ID of the user who replied.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StoreInquiry extends User {

    private String username;
    private String inquiry;
    private String camp;
    private String reply;
    private String replierID;

    /**
     * Constructs a StoreInquiry object with the specified details.
     *
     * @param username   The username of the user making the inquiry.
     * @param inquiry    The inquiry message.
     * @param camp       The associated camp.
     * @param reply      The reply to the inquiry (default is "none").
     * @param replierID  The ID of the user who replied to the inquiry (default is "none").
     */
    public StoreInquiry(String username, String inquiry, String camp, String reply, String replierID) {
        super(username, "", "", "", "", null);
        this.username = username;
        this.inquiry = inquiry;
        this.camp = camp;
        this.reply = "none";
        this.replierID = "none";
    }

    /**
     * Gets the ID of the user who replied to the inquiry.
     *
     * @return The ID of the user who replied.
     */
    public String getReplierID() {
        return replierID;
    }

    /**
     * Sets the ID of the user who replied to the inquiry.
     *
     * @param replierID The ID of the user who replied.
     */
    public void setReplierID(String replierID) {
        this.replierID = replierID;
    }

    /**
     * Gets the reply to the inquiry.
     *
     * @return The reply to the inquiry.
     */
    public String getReply() {
        return reply;
    }

    /**
     * Sets the reply to the inquiry.
     *
     * @param reply The reply to the inquiry.
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * Gets the username of the user making the inquiry.
     *
     * @return The username of the user making the inquiry.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user making the inquiry.
     *
     * @param username The username of the user making the inquiry.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the inquiry message.
     *
     * @return The inquiry message.
     */
    public String getInquiry() {
        return inquiry;
    }

    /**
     * Sets the inquiry message.
     *
     * @param inquiry The inquiry message.
     */
    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    /**
     * Gets the associated camp.
     *
     * @return The associated camp.
     */
    public String getCamp() {
        return camp;
    }

    /**
     * Sets the associated camp.
     *
     * @param camp The associated camp.
     */
    public void setCamp(String camp) {
        this.camp = camp;
    }
}
