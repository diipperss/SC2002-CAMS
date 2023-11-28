package report;
import java.util.List;
import java.util.Map;

import camp.*;
import user.*;

/**
 * This class represents a generic report and provides common attributes and methods for its subclasses.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 *
 */
public class Report {
  
  /** The camp committee user associated with the report. */
  private CampCommitteeUser campCommitteeUser;

  /** The username associated with the report. */
  private String username;

  /** The name of the camp associated with the report. */
  private String campname;

  /** The faculty associated with the report. */
  private Faculty faculty;

  /** The role associated with the report. */
  private String role;

  /** The points associated with the report. */
  private int points;

  /**
   * Default constructor for the Report class.
   */
  public Report() {
  }

  /**
   * Gets the username associated with the report.
   *
   * @return The username associated with the report.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username associated with the report.
   *
   * @param username The username to be set.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets the name of the camp associated with the report.
   *
   * @return The name of the camp associated with the report.
   */
  public String getCampName() {
    return campname;
  }

  /**
   * Sets the name of the camp associated with the report.
   *
   * @param campname The name of the camp to be set.
   */
  public void setCampName(String campname) {
    this.campname = campname;
  }

  /**
   * Gets the role associated with the report.
   *
   * @return The role associated with the report.
   */
  public String getRole() {
    return role;
  }

  /**
   * Sets the role associated with the report.
   *
   * @param role The role to be set.
   */
  public void setRole(String role) {
    this.role = role;
  }

  /**
   * Gets the faculty associated with the report.
   *
   * @return The faculty associated with the report.
   */
  public Faculty getFaculty() {
    return campCommitteeUser.getFaculty();
  }

  /**
   * Sets the faculty associated with the report.
   *
   * @param faculty The faculty to be set.
   */
  public void setFaculty(Faculty faculty) {
    this.faculty = faculty;
  }

  /**
   * Gets the points associated with the report.
   *
   * @return The points associated with the report.
   */
  public int getPoints() {
    return campCommitteeUser.getPoints();
  }

  /**
   * Sets the points associated with the report.
   *
   * @param points The points to be set.
   */
  public void setPoints(int points) {
    this.points = points;
  }
}