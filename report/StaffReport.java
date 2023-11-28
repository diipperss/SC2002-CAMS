package report;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import camp.AllCamps;
import camp.Camp;
import camp.StudentCamp;
import errorhandling.InputExceptionHandler;
import inquiry.Inquiry;
import inquiry.InquiryHandler;
import inquiry.StoreInquiry;
import user.CampCommitteeUser;
import user.StaffUser;
import user.StudentUser;

/**
 * This class implements the Report interface and provides methods to generate reports for students and camp committee members.
 *@author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StaffReport implements ReportInterface{
  private StaffUser staff;
  
  /**
   * Constructs a {@code StaffReport} object with the specified {@link StaffUser}.
   *
   * @param staff the staff user for whom the report is generated.
   */
  public StaffReport(StaffUser staff) {
    this.staff = staff;
  }

  /**
   * Generates a report for the list of students attending a camp created by the staff.
   *
   * @param staff the staff user for whom the report is generated.
   */
  public static void generateStudentsList(StaffUser staff) {
    System.out.println("Select the camp you want:");

    int index = 1;
    for (int i = 0; i < staff.getCreatedCamps().size(); i++) {
      System.out.println(index + ". " + staff.getCreatedCamps().get(i).getName());
      index++;
    }
    Scanner scanner = new Scanner(System.in);
    int chosen = InputExceptionHandler.scanNextInt(scanner);
    Camp camp = staff.getCreatedCamps().get(chosen - 1);
    String campName = camp.getName();
    List<StoreReport> reports = new ArrayList<>();

    List<Map<StudentUser, String>> attendeeListAndRole = camp.getAttendeeListAndRole();
    for (Map<StudentUser, String> attendeeMap : attendeeListAndRole) {
      for (Map.Entry<StudentUser, String> entry : attendeeMap.entrySet()) {

        StudentUser studentUser = entry.getKey();
        String role = entry.getValue();
        if (role.equals("attendee")) {
          int points = 0; // Set appropriate points value
          StoreReport report = new StoreReport(entry.getValue(), studentUser.getFaculty(), "student", campName, points);
          reports.add(report);
        }
        else{
          for (int i=0;i<camp.getCampCommitteeList().size();i++){
            StoreReport report = new StoreReport(camp.getCampCommitteeList().get(i).getUsername(), camp.getCampCommitteeList().get(i).getFaculty(), "camp committe member", campName, camp.getCampCommitteeList().get(i).getPoints());
            reports.add(report);
          }
      }
    }
  }
    ReportHandler reportHandler = new ReportHandler("Attendeelist.txt");
    reportHandler.loadStudentsList(reports, camp);
  }

  /**
   * Generates a report for the list of camp committee members attending a camp created by the staff.
   *
   * @param staff the staff user for whom the report is generated.
   */
  public static void generateCampCommitteeList(StaffUser staff) {
    System.out.println("Select the camp you want:");

    int index = 1;
    for (int i = 0; i < staff.getCreatedCamps().size(); i++) {
      System.out.println(index + ". " + staff.getCreatedCamps().get(i).getName());
      index++;
    }
    Scanner scanner = new Scanner(System.in);
    int chosen = InputExceptionHandler.scanNextInt(scanner);
    Camp camp = staff.getCreatedCamps().get(chosen - 1);
    String campName = camp.getName();
    List<StoreReport> reports = new ArrayList<>();

    List<Map<StudentUser, String>> attendeeListAndRole = camp.getAttendeeListAndRole();
    for (Map<StudentUser, String> attendeeMap : attendeeListAndRole) {
      for (Map.Entry<StudentUser, String> entry : attendeeMap.entrySet()) {
        StudentUser studentUser = entry.getKey();
        String role = entry.getValue();
        if (role.equals("camp committee member")) {
          for (int i = 0; i < camp.getCampCommitteeList().size(); i++) {
            StoreReport report = new StoreReport(camp.getCampCommitteeList().get(i).getUsername(),
                camp.getCampCommitteeList().get(i).getFaculty(), "Camp Committee Member", campName,
                camp.getCampCommitteeList().get(i).getPoints());
            reports.add(report);
          }
        }
      }
    }
    ReportHandler reportHandler = new ReportHandler("PerformanceList.txt");
    reportHandler.loadCampCommitteeList(reports, camp);
  }
}
