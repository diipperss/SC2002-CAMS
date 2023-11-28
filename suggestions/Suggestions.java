/**
 * The Suggestions class represents suggestions related to camps in the system.
 * It includes information about the camp name, suggestion details, approval status,
 * suggested changes, and the associated camp committee user.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package suggestions;

import user.CampCommitteeUser;

public class Suggestions {

    /**
     * The name of the camp associated with the suggestion.
     */
    private String campName;

    /**
     * The details of the suggestion.
     */
    private String suggestion;

    /**
     * The staff reply to the suggestion.
     */
    private String reply;

    /**
     * The approval status of the suggestion.
     */
    private boolean approve;

    /**
     * The suggested changes associated with the suggestion.
     */
    private String change;

    /**
     * The camp committee user associated with the suggestion.
     */
    private CampCommitteeUser campCommitteeUser;

    /**
     * Gets the camp committee user associated with the suggestion.
     *
     * @return The camp committee user associated with the suggestion.
     */
    public CampCommitteeUser getCampCommitteeUser() {
        return campCommitteeUser;
    }

    /**
     * Sets the camp committee user associated with the suggestion.
     *
     * @param campCommitteeUser The camp committee user to be associated with the suggestion.
     */
    public void setCampCommitteeUser(CampCommitteeUser campCommitteeUser) {
        this.campCommitteeUser = campCommitteeUser;
    }

    /**
     * Gets the details of the suggestion.
     *
     * @return The details of the suggestion.
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * Sets the details of the suggestion.
     *
     * @param suggestion The details of the suggestion to be set.
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    /**
     * Gets the name of the camp associated with the suggestion.
     *
     * @return The name of the camp associated with the suggestion.
     */
    public String getCamp() {
        return campName;
    }

    /**
     * Sets the name of the camp associated with the suggestion.
     *
     * @param campName The name of the camp to be set.
     */
    public void setCamp(String campName) {
        this.campName = campName;
    }

    /**
     * Gets the staff reply to the suggestion.
     *
     * @return The staff reply to the suggestion.
     */
    public String getReply() {
        return reply;
    }

    /**
     * Sets the staff reply to the suggestion.
     *
     * @param reply The staff reply to be set.
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * Gets the approval status of the suggestion.
     *
     * @return The approval status of the suggestion.
     */
    public boolean getApproval() {
        return approve;
    }

    /**
     * Sets the approval status of the suggestion.
     *
     * @param approve The approval status to be set.
     */
    public void setApproval(boolean approve) {
        this.approve = approve;
    }

    /**
     * Gets the suggested changes associated with the suggestion.
     *
     * @return The suggested changes associated with the suggestion.
     */
    public String getChange() {
        return change;
    }

    /**
     * Sets the suggested changes associated with the suggestion.
     *
     * @param change The suggested changes to be set.
     */
    public void setChange(String change) {
        this.change = change;
    }

    /**
     * Prints the details of the suggestion, including the camp name, suggestion details,
     * approval status, suggested changes, and the associated camp committee user.
     */
    public void printSuggestion() {
        System.out.println("Camp Name: " + campName);
        System.out.println("Suggestion: " + suggestion);
        System.out.println("Approval Status: " + approve);
        System.out.println("Change: " + change);
        System.out.println("---------------");
    }

    /**
     * Prints the available parameters for making a suggestion.
     */
    public void printParameters() {
        System.out.println("1. Camp Name");
        System.out.println("2. Dates");
        System.out.println("3. Registration Closing Date");
        System.out.println("4. User group");
        System.out.println("5. Location");
        System.out.println("6. Total Slots");
        System.out.println("7. Camp Committee Slots");
        System.out.println("8. Description: ");
    }
}
