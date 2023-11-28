package report;

/**
 * This interface provides methods to view students' and camp committee members' lists.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public interface ReportInterface {

  /**
   * Displays the list of students along with their roles and faculties.
   */
  default void viewStudentsList() {
  }

  /**
   * Displays the list of camp committee members along with their roles, faculties, and points.
   */
  default void viewCampCommitteeList() {
  }
}