
package inquiry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.AllCamps;
import errorhandling.InputExceptionHandler;
import user.StudentUser;
import camp.*;

/**
 * This class provides functionalities related to inquiries made by a student, including viewing, editing,
 * deleting, and submitting inquiries.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 * 
 */
public class StudentInquiry implements InquiryInterface {

    private StudentUser studentuser;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a StudentInquiry object with the specified student user.
     *
     * @param studentuser The student user making the inquiries.
     */
    public StudentInquiry(StudentUser studentuser) {
        this.studentuser = studentuser;
    }

    /**
     * Displays the inquiries made by the student.
     *
     * @param studentuser The student user making the inquiries.
     */
    public static void viewInquiry(StudentUser studentuser) {
        if (AllCamps.getAllCamps().isEmpty()) {
            System.out.println("No camps available!");
        } else {
            List<StoreInquiry> getStudentInquiries = InquiryHandler.findStudentByUsername("InquiryFile.txt", studentuser.getUsername());
            if ((getStudentInquiries.size() == 1 && getStudentInquiries.get(0) == null)) {
                System.out.println("No inquiries found.");
            } else {
                System.out.println("Inquiries by you:");
                System.out.println("--------------------------");

                for (StoreInquiry studentInquiry : getStudentInquiries) {
                    System.out.println("Username: " + studentInquiry.getUsername());
                    System.out.println("Camp: " + studentInquiry.getCamp());
                    System.out.println("Inquiry: " + studentInquiry.getInquiry());
                    System.out.println("Reply: " + studentInquiry.getReply());
                    System.out.println("ReplierID: " + studentInquiry.getReplierID());
                    System.out.println("--------------------------");

                }
            }
        }
    }

    /**
     * Allows the student to edit an inquiry made by them.
     *
     * @param studentuser The student user making the inquiries.
     */
    public static void editInquiry(StudentUser studentuser) {
        if (AllCamps.getAllCamps().isEmpty()) {
            System.out.println("No camps available!");
        } else {

            //print out the list of camps
            Scanner scanner = new Scanner(System.in);

            int inquiryIndex = 1;
            List<Inquiry> indexedInquiries = new ArrayList<>(); //create a new blank arraylist
            List<StoreInquiry> students = InquiryHandler.findStudentByUsername("InquiryFile.txt", studentuser.getUsername());
            if (students == null || (students.size() == 1 && students.get(0) == null)) {
                System.out.println("No inquiries found.");
            } else {
                for (StoreInquiry student : students) {
                    System.out.println(inquiryIndex);
                    System.out.println("Username: " + student.getUsername());
                    System.out.println("Camp: " + student.getCamp());
                    System.out.println("Inquiry: " + student.getInquiry());
                    System.out.println("Reply: " + student.getReply());
                    System.out.println("ReplierID: " + student.getReplierID());
                    System.out.println("--------------------------");
                    Inquiry inquiryAdd = new Inquiry();
                    inquiryAdd.setStudent(student);
                    inquiryAdd.setMessage(student.getInquiry());
                    inquiryAdd.setCamp(student.getCamp());
                    inquiryAdd.setReply(student.getReply());
                    indexedInquiries.add(inquiryAdd);
                    inquiryIndex++;
                }
                System.out.println("Select the inquiry you want to edit (e.g. '1'): ");
                int editThisIndex = InputExceptionHandler.scanNextInt(scanner);
                if (editThisIndex == -1) return;
                if ("null".equals(indexedInquiries.get(editThisIndex - 1).getReply())) {
                    //get the inquiry that needs to be edited.
                    Inquiry inquiryEdit = new Inquiry();
                    inquiryEdit.setStudent(indexedInquiries.get(editThisIndex - 1).getStudent());
                    inquiryEdit.setCamp(indexedInquiries.get(editThisIndex - 1).getCampName());
                    inquiryEdit.setReply(indexedInquiries.get(editThisIndex - 1).getReply());

                    scanner.nextLine();  //consume the newline character
                    System.out.println("Key in your new inquiry: ");
                    String newInquiry = scanner.nextLine();
                    //edit the inquiry
                    inquiryEdit.setMessage(newInquiry);

                    indexedInquiries.remove(editThisIndex - 1); //delete outdated entry from the new arraylist
                    indexedInquiries.add(inquiryEdit); //add updated entry to newarraylist

                    // Clear the content of the file
                    InquiryHandler.clearFile("InquiryFile.txt");

                    // Write the new content to the file
                    InquiryHandler inquiryHandler = new InquiryHandler("InquiryFile.txt");
                    inquiryHandler.editInquiriesToFile("InquiryFile.txt", indexedInquiries);

                    System.out.println("Inquiry successfully edited!");

                } else {
                    System.out.println("You cannot edit this inquiry!");
                }
            }

        }
    }

    /**
     * Allows the student to delete an inquiry made by them.
     *
     * @param studentuser The student user making the inquiries.
     */
    public static void deleteInquiry(StudentUser studentuser) {
        if (AllCamps.getAllCamps().isEmpty()) {
            System.out.println("No camps available!");
        } else {
            Scanner scanner = new Scanner(System.in);

            int inquiryIndex = 1;
            List<Inquiry> indexedInquiries = new ArrayList<>(); //create a new blank arraylist
            List<StoreInquiry> students = InquiryHandler.findStudentByUsername("InquiryFile.txt", studentuser.getUsername());
            if (students == null || (students.size() == 1 && students.get(0) == null)) {
                System.out.println("No inquiries found.");
            } else {
                for (StoreInquiry student : students) {
                    System.out.println(inquiryIndex);
                    System.out.println("Username: " + student.getUsername());
                    System.out.println("Inquiry: " + student.getInquiry());
                    System.out.println("Camp Name: " + student.getCamp());
                    System.out.println("Reply: " + student.getReply());
                    System.out.println("ReplierID: " + student.getReplierID());
                    System.out.println("--------------------------");
                    Inquiry inquiryAdd = new Inquiry();
                    inquiryAdd.setStudent(student);
                    inquiryAdd.setMessage(student.getInquiry());
                    inquiryAdd.setCamp(student.getCamp());
                    inquiryAdd.setReply(student.getReply());
                    indexedInquiries.add(inquiryAdd);
                    inquiryIndex++;
                }
                System.out.println("Select the inquiry you want to delete (e.g. '1'): ");
                int deleteThisIndex = InputExceptionHandler.scanNextInt(scanner);
                if (deleteThisIndex == -1) return;
                if ("null".equals(indexedInquiries.get(deleteThisIndex - 1).getReply())) { //before staff responds then delete
                    indexedInquiries.remove(deleteThisIndex - 1); //delete selected entry from the new arraylist

                    // Clear the content of the file
                    InquiryHandler.clearFile("InquiryFile.txt");

                    // Write the new content to the file
                    InquiryHandler inquiryHandler = new InquiryHandler("InquiryFile.txt");
                    inquiryHandler.editInquiriesToFile("InquiryFile.txt", indexedInquiries);

                    System.out.println("Inquiry successfully deleted!");

                } else {
                    System.out.println("You cannot delete this inquiry!");
                }
            }

        }
    }

    /**
     * Allows the student to submit a new inquiry.
     *
     * @param studentuser The student user making the inquiry.
     */
    public static void submitInquiry(StudentUser studentuser) {
        if (AllCamps.getAllCamps().isEmpty()) {
            System.out.println("No camps available!");
        } else {
            Scanner scanner = new Scanner(System.in);
            String facultyname = "NTU";
            int facultyindex = studentuser.getFaculty().ordinal();
            switch (facultyindex) {
                case 0:
                    facultyname = "SCSE";
                    break;
                case 1:
                    facultyname = "ADM";
                    break;
                case 2:
                    facultyname = "EEE";
                    break;
                case 3:
                    facultyname = "NBS";
                    break;
                case 4:
                    facultyname = "SSS";
                    break;
            }

            System.out.println("Enter your camp faculty:"); //(SCSE/ADM/EEE/NBS/SSS/NTU):
            System.out.println("1. " + facultyname);
            System.out.println("2. NTU");

            int chosen = InputExceptionHandler.scanNextInt(scanner);
            if (chosen == -1) return;
            if (chosen == 2) {
                facultyindex = 5;
            }

            List<Camp> campsInFaculty = new ArrayList<>();
            for (Camp camp : AllCamps.getAllCamps()) {
                if (camp.getFaculty() != null && camp.getFaculty().ordinal() == facultyindex) {
                    campsInFaculty.add(camp);
                }
            }

            if (campsInFaculty.isEmpty()) {
                System.out.println("No camps available in the selected faculty!");
            } else {
                System.out.println("Available camps:");
                int index = 1;
                for (Camp camp1 : campsInFaculty) {
                    System.out.println(index + ". " + camp1.getName());
                    index++;
                }

                System.out.println("Enter choice of camp: ");
                int campIndex = InputExceptionHandler.scanNextInt(scanner);
                if (campIndex == -1) return;
                scanner.nextLine();  //consume the newline character
                String campName = campsInFaculty.get(campIndex - 1).getName();

                System.out.println("Enter your inquiry message:");
                String message = scanner.nextLine();

                // Load the inquiry details
                Inquiry inquiry = new Inquiry();
                inquiry.setStudent(studentuser);
                inquiry.setMessage(message);
                inquiry.setCamp(campName);

                // Adding the inquiry to the selected camp
                Camp selectedCamp = null;
                for (Camp camp : campsInFaculty) {
                    if (camp.getName().equals(campName)) {
                        selectedCamp = camp;
                        break; // Assuming each camp name is unique, exit the loop after adding the inquiry
                    }
                }

                System.out.println("Selected Camp: " + selectedCamp.getName());
                selectedCamp.getInquiries().add(inquiry);

                int lastIndex = selectedCamp.getInquiries().size() - 1;

                List<Inquiry> InquiryToAdd = new ArrayList<>();
                InquiryToAdd.add(selectedCamp.getInquiries().get(lastIndex));

                // Saving the inquiries to file
                InquiryHandler inquiryHandler = new InquiryHandler("InquiryFile.txt");
                inquiryHandler.saveInquiriesToFile(InquiryToAdd);

                System.out.println("Inquiry submitted successfully!");
            }
        }
    }
}
