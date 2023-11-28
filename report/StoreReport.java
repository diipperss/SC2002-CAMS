package report;

import camp.Camp;
import user.CampCommitteeUser;
import user.Faculty;
import user.User;

/**
 * This class extends {@link CampCommitteeUser} and stores information related to a report, including the user's name,
 * role (student or camp committee member), and points earned.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StoreReport extends CampCommitteeUser {
  private String name;
  private String role;
  private int points;

  /**
   * Constructs a {@code StoreReport} object with the specified parameters.
   *
   * @param name    the name of the user.
   * @param faculty the faculty of the user.
   * @param role    the role of the user (e.g., "Student" or "Camp Committee Member").
   * @param camp    the name of the camp associated with the report.
   * @param points  the points earned by the user.
   */
  public StoreReport(String name, Faculty faculty, String role, String camp, int points) {
    super("", "", role, "", name, faculty);
    this.name = name;
    this.role = role;
    this.points = points;
  }

  /**
   * Gets the username (name) of the user associated with the report.
   *
   * @return the username (name) of the user.
   */
  public String getUsername() {
    return name;
  }

  /**
   * Sets the username (name) of the user associated with the report.
   *
   * @param name the username (name) of the user.
   */
  public void setUsername(String name) {
    this.name = name;
  }

  /**
   * Gets the role of the user associated with the report (e.g., "Student" or "Camp Committee Member").
   *
   * @return the role of the user.
   */
  public String getRole() {
    return role;
  }

  /**
   * Sets the role of the user associated with the report.
   *
   * @param role the role of the user.
   */
  public void setRole(String role) {
    this.role = role;
  }

  /**
   * Gets the points earned by the user associated with the report.
   *
   * @return the points earned by the user.
   */
  public int getPoints() {
    return points;
  }

  /**
   * Sets the points earned by the user associated with the report.
   *
   * @param points the points earned by the user.
   */
  public void setPoints(int points) {
    this.points = points;
  }
}