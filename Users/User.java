package user;

import java.util.Scanner;

/**
 * The User class represents a user in the system with attributes such as
 * username, password, role, email, name, and associated faculty.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class User {

    private String username;
    private String password;
    private String role;
    private String email;
    private String name;
    private Faculty faculty;

    /**
     * Constructs a new User with the specified attributes.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param role the role of the user
     * @param email the email address of the user
     * @param name the name of the user
     * @param faculty the faculty to which the user belongs
     */
    public User(String username, String password, String role, String email, String name, Faculty faculty) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.name = name;
        this.faculty = faculty;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password to set
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * Retrieves the role of the user.
     *
     * @return the role of the user
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the new role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return the email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the new email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the faculty to which the user belongs.
     *
     * @return the faculty of the user
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty to which the user belongs.
     *
     * @param faculty the new faculty to set
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * Provides a formatted string containing user information.
     *
     * @return a formatted string with user information
     */
    public String viewInfo() {
        return "Name: " + name +
               "\nEmail: " + email +
               "\nUsername: " + username +
               "\nPassword: " + password +
               "\nRole: " + role;

    }

    /**
     * Method in the user class that will be inherited by all subclasss to change user password 
     * will be called by respective StaffActions, StudentsActions,CampCommitee Actions
     * will request for current password and match against database before being able to change
     * 
     */
    public void changePassword() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();

        // Check if the entered current password matches the user actual password
        if (currentPassword.equals(getPassword())) {
            System.out.print("Enter your new password: ");
            String newPassword = scanner.nextLine();

            // Perform additional password validation if needed

            // Set the new password for the staff
            setPassword(newPassword);

            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Incorrect current password. Password change failed.");
        }
    }

}
