package camp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import inquiry.*;
import user.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import suggestions.*;

/**
 * Represents a camp with various attributes such as name, date, and location.
 * Camps can have inquiries, suggestions, attendees, and committee members.
 * Provides methods to access and modify camp information.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class Camp {
    private String campName;
    private LocalDate date;
    private LocalDate registrationClosingDate;
    private String userGroup;
    private String location;
    private String staffInCharge;
    private int totalSlots;
    private int campCommitteeSlots;
    private String description;
    private Faculty faculty;
    protected boolean isVisible;
    private List<Inquiry> inquiries;
    private List<Suggestions> suggestions;

    protected List<Map<StudentUser, String>> attendeeListAndRole;

    private List<CampCommitteeUser> campCommitteeList;

    /**
     * Constructs a new camp with the specified attributes.
     * 
     * @param campName                The name of the camp.
     * @param date                    The date of the camp.
     * @param registrationClosingDate The registration closing date of the camp.
     * @param userGroup               The user group associated with the camp. NTU/School
     * @param location                The location of the camp.
     * @param staffInCharge           The staff member in charge of the camp.
     * @param totalSlots              The total available slots for the camp.
     * @param campCommitteeSlots      The slots reserved for the camp committee.
     * @param description             A description of the camp.
     * @param faculty                 The faculty associated with the camp.
     *
     */
    public Camp(String campName, String date, String registrationClosingDate,
                String userGroup, String location, String staffInCharge,
                int totalSlots, int campCommitteeSlots, String description,
                Faculty faculty) {
        this.campName = campName;
        this.date = DateFormat.parseDate(date);
        this.registrationClosingDate = DateFormat.parseDate(registrationClosingDate);
        this.userGroup = userGroup;
        this.location = location;
        this.staffInCharge = staffInCharge;
        this.totalSlots = totalSlots;
        this.campCommitteeSlots = campCommitteeSlots;
        this.description = description;
        this.isVisible = true;
        this.inquiries = new ArrayList<>();
        this.attendeeListAndRole = new ArrayList<>();
        this.campCommitteeList = new ArrayList<>();
        this.suggestions = new ArrayList<>(); 
        this.faculty = faculty;
    }

    /**
     * Gets the name of the camp.
     * 
     * @return The name of the camp.
     */
    public String getName() {
        return campName;
    }

    /**
     * Gets the starting date of the camp.
     * 
     * @return The starting date of the camp.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the registration closing date of the camp.
     * 
     * @return The registration closing date of the camp.
     */
    public LocalDate getRegistrationClosingDate() {
        return registrationClosingDate;
    }

    /**
     * Gets the user group associated with the camp.
     * 
     * @return The user group of the camp.
     */
    public String getUserGroup() {
        return userGroup;
    }

    /**
     * Gets the location of the camp.
     * 
     * @return The location of the camp.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the staff member in charge of the camp.
     * 
     * @return The staff member in charge.
     */
    public String getStaffInCharge() {
        return staffInCharge;
    }

    /**
     * Gets the total available slots for the camp.
     * 
     * @return The total available slots.
     */
    public int getTotalSlots() {
        return totalSlots;
    }

    /**
     * Gets the slots reserved for the camp committee.
     * 
     * @return The camp committee slots.
     */
    public int getCampCommitteeSlots() {
        return campCommitteeSlots;
    }

    /**
     * Gets the description of the camp.
     * 
     * @return The description of the camp.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the camp is visible.
     * 
     * @return True if the camp is visible, false otherwise.
     */
    public boolean getIsVisible() {
        return isVisible;
    }

    /**
     * Gets the list of committee members for the camp.
     * 
     * @return The list of committee members.
     */
    public List<CampCommitteeUser> getCampCommitteeList() {
        return campCommitteeList;
    }

    /**
     * Gets the list of attendees and their roles for the camp.
     * 
     * @return The list of attendees and their roles.
     */
    public List<Map<StudentUser, String>> getAttendeeListAndRole() {
        return attendeeListAndRole;
    }

    /**
     * Sets the list of attendees and their roles for the camp.
     * 
     * @param attendeeListAndRole The list of attendees and their roles.
     */
    public void setAttendeeListAndRole(List<Map<StudentUser, String>> attendeeListAndRole) {
        this.attendeeListAndRole = attendeeListAndRole;
    }

    /**
     * Sets the name of the camp.
     * 
     * @param campName The new name for the camp.
     */
    public void setName(String campName) {
        this.campName = campName;
    }

    /**
     * Sets the date of the camp.
     * 
     * @param date The new date for the camp.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the registration closing date of the camp.
     * 
     * @param registrationClosingDate The new registration closing date for the camp.
     */
    public void setRegistrationClosingDate(LocalDate registrationClosingDate) {
        this.registrationClosingDate = registrationClosingDate;
    }

    /**
     * Sets the user group associated with the camp.
     * 
     * @param userGroup The new user group for the camp.
     */
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    /**
     * Sets the location of the camp.
     * 
     * @param location The new location for the camp.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the staff member in charge of the camp.
     * 
     * @param staffInCharge The new staff member in charge.
     */
    public void setStaffInCharge(String staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    /**
     * Sets the total available slots for the camp.
     * 
     * @param totalSlots The new total available slots for the camp.
     */
    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    /**
     * Sets the slots reserved for the camp committee.
     * 
     * @param campCommitteeSlots The new camp committee slots.
     */
    public void setCampCommitteeSlots(int campCommitteeSlots) {
        this.campCommitteeSlots = campCommitteeSlots;
    }

    /**
     * Sets the description of the camp.
     * 
     * @param description The new description for the camp.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the visibility of the camp.
     * 
     * @param isVisible True if the camp should be visible, false otherwise.
     */
    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * Gets the faculty associated with the camp.
     * 
     * @return The faculty of the camp.
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty associated with the camp.
     * 
     * @param faculty The new faculty for the camp.
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * Gets the list of inquiries for the camp.
     * 
     * @return The list of inquiries.
     */
    public List<Inquiry> getInquiries() {
        return inquiries;
    }

    /**
     * Sets the list of inquiries for the camp.
     * 
     * @param inquiries The new list of inquiries.
     */
    public void setInquiries(List<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }

    /**
     * Gets the list of suggestions for the camp.
     * 
     * @return The list of suggestions.
     */
    public List<Suggestions> getSuggestions() {
        return suggestions;
    }

    /**
     * Sets the list of suggestions for the camp.
     * 
     * @param suggestions The new list of suggestions.
     */
    public void setSuggestions(List<Suggestions> suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * Gets the list of committee members for the camp.
     * 
     * @return The list of committee members.
     */
    public List<CampCommitteeUser> getCommitteeMembers() {
        return campCommitteeList;
    }

    /**
     * Displays information about the camp, including its name, date, and other details.
     */
    public void viewCampInfo() {
        System.out.println("------------------------");
        System.out.println("Camp Name: " + getName());
        System.out.println("Date: " + getDate());
        System.out.println("Registration Closing Date: " + getRegistrationClosingDate());
        System.out.println("User Group: " + getUserGroup());
        System.out.println("Location: " + getLocation());
        System.out.println("Staff in Charge: " + getStaffInCharge());
        System.out.println("Total Slots: " + getTotalSlots());
        System.out.println("Camp Committee Slots: " + getCampCommitteeSlots());
        System.out.println("Description: " + getDescription());
        System.out.println("Visibility: " + getIsVisible());
        System.out.println("------------------------");
    }
}