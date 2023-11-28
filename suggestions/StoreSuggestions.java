/**
 * The StoreSuggestions class represents a user's suggestions stored in the system.
 * It extends the User class and includes information about the camp committee user, suggestions,
 * associated camp, and approval status.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package suggestions;

import user.User;

public class StoreSuggestions extends User {

    /**
     * The username of the camp committee user associated with the suggestions.
     */
    private String campCommitteeUsername;

    /**
     * The suggestions provided by the user.
     */
    private String suggestions;

    /**
     * The name of the camp associated with the suggestions.
     */
    private String camp;

    /**
     * The reply to the suggestions.
     */
    private String reply;

    /**
     * The ID of the replier, if applicable.
     */
    private String replierID;

    /**
     * The approval status of the suggestions.
     */
    private String approve;

    /**
     * Constructs a new StoreSuggestions object with the specified parameters.
     *
     * @param campCommitteeUsername The username of the camp committee user.
     * @param suggestions           The suggestions provided by the user.
     * @param camp                  The name of the camp associated with the suggestions.
     * @param reply                 The reply to the suggestions.
     * @param replierID             The ID of the replier, if applicable.
     */
    public StoreSuggestions(String campCommitteeUsername, String suggestions, String camp, String reply, String replierID) {
        super(campCommitteeUsername, "", "", "", "", null);
        this.campCommitteeUsername = campCommitteeUsername;
        this.suggestions = suggestions;
        this.camp = camp;
        this.reply = "none";
        this.replierID = "none";
    }

    /**
     * Gets the ID of the replier.
     *
     * @return The ID of the replier.
     */
    public String getReplierID() {
        return replierID;
    }

    /**
     * Sets the ID of the replier.
     *
     * @param replierID The ID of the replier to be set.
     */
    public void setReplierID(String replierID) {
        this.replierID = replierID;
    }

    /**
     * Gets the reply to the suggestions.
     *
     * @return The reply to the suggestions.
     */
    public String getReply() {
        return reply;
    }

    /**
     * Sets the reply to the suggestions.
     *
     * @param reply The reply to be set.
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * Gets the username of the camp committee user.
     *
     * @return The username of the camp committee user.
     */
    public String getCampCommitteeUsername() {
        return campCommitteeUsername;
    }

    /**
     * Sets the username of the camp committee user.
     *
     * @param campCommitteeUsername The username of the camp committee user to be set.
     */
    public void setCampCommitteeUsername(String campCommitteeUsername) {
        this.campCommitteeUsername = campCommitteeUsername;
    }

    /**
     * Gets the suggestions provided by the user.
     *
     * @return The suggestions provided by the user.
     */
    public String getSuggestions() {
        return suggestions;
    }

    /**
     * Sets the suggestions provided by the user.
     *
     * @param suggestions The suggestions to be set.
     */
    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * Gets the name of the camp associated with the suggestions.
     *
     * @return The name of the camp associated with the suggestions.
     */
    public String getCamp() {
        return camp;
    }

    /**
     * Sets the name of the camp associated with the suggestions.
     *
     * @param camp The name of the camp to be set.
     */
    public void setCamp(String camp) {
        this.camp = camp;
    }

    /**
     * Sets the approval status of the suggestions.
     *
     * @param approve The approval status to be set.
     */
    public void setApproval(String approve) {
        this.approve = approve;
    }

    /**
     * Gets the approval status of the suggestions.
     *
     * @return The approval status of the suggestions.
     */
    public String getApproval() {
        return approve;
    }
}
