package report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.*;

/**
 * This class handles the generation and loading of reports.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 * 
 */
public class ReportHandler {

  /** The name of the file to be used for handling reports. */
  private static String fileName;

  /**
   * Constructs a new ReportHandler with the specified file name.
   *
   * @param fileName The name of the file to be used for handling reports.
   */
  public ReportHandler(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Displays the camp information as a formatted string.
   *
   * @param paramCamp The camp for which information is displayed.
   * @return A formatted string containing the camp information.
   */
  public static String viewCampInfoInString(Camp paramCamp) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("------------------------\n");
    stringBuilder.append("Camp Name: ").append(paramCamp.getName()).append("\n");
    stringBuilder.append("Date: ").append(paramCamp.getDate()).append("\n");
    stringBuilder.append("Registration Closing Date: ").append(paramCamp.getRegistrationClosingDate()).append("\n");
    stringBuilder.append("User Group: ").append(paramCamp.getUserGroup()).append("\n");
    stringBuilder.append("Location: ").append(paramCamp.getLocation()).append("\n");
    stringBuilder.append("Staff in Charge: ").append(paramCamp.getStaffInCharge()).append("\n");
    stringBuilder.append("Total Slots: ").append(paramCamp.getTotalSlots()).append("\n");
    stringBuilder.append("Camp Committee Slots: ").append(paramCamp.getCampCommitteeSlots()).append("\n");
    stringBuilder.append("Description: ").append(paramCamp.getDescription()).append("\n");
    stringBuilder.append("Visibility: ").append(paramCamp.getIsVisible()).append("\n");
    stringBuilder.append("------------------------\n");
    stringBuilder.append("\n");
    System.out.println(stringBuilder.toString());
    return stringBuilder.toString();
  }

  /**
   * Loads the list of students into a file along with the camp information.
   *
   * @param reports The list of reports to be loaded.
   * @param camp    The camp associated with the reports.
   */
  public void loadStudentsList(List<StoreReport> reports, Camp camp) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Attendeelist.txt", true))) {
      writer.write(ReportHandler.viewCampInfoInString(camp) + "\n");
      int index = 1;
      for (StoreReport report : reports) {
        writer.write("Attendee " + index + ":" + "\n");
        writer.write("Name: " + report.getUsername() + "\n");
        writer.write("Role: " + report.getRole() + "\n");
        writer.write("Faculty: " + report.getFaculty().toString() + "\n");

        writer.write("\n"); // Add a separator between reports
        index++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Loads the list of camp committee members into a file along with the camp information.
   *
   * @param reports The list of reports to be loaded.
   * @param camp    The camp associated with the reports.
   */
  public void loadCampCommitteeList(List<StoreReport> reports, Camp camp) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("PerformanceList.txt", true))) {
      writer.write(ReportHandler.viewCampInfoInString(camp) + "\n");
      int index = 1;
      for (StoreReport report : reports) {
        writer.write("Attendee " + index + ":" + "\n");
        writer.write("Name: " + report.getUsername() + "\n");
        writer.write("Role: " + report.getRole() + "\n");
        writer.write("Faculty: " + report.getFaculty().toString() + "\n");
        writer.write("Points: " + report.getPoints() + "\n");

        writer.write("\n"); // Add a separator between reports
        index++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}