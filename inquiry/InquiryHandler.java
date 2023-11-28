package inquiry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The InquiryHandler class provides methods for handling inquiries, including saving, editing, and deleting inquiries
 * to/from a file, and searching for inquiries based on various criteria.
 *
 * @version 1.0
 * @since 2023-11-24
 * @author Grp4
 */
public class InquiryHandler {
    private static String fileName;

    /**
     * Constructs an InquiryHandler object with the specified file name.
     *
     * @param fileName The name of the file to handle inquiries.
     */
    public InquiryHandler(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Saves a list of inquiries to the file.
     *
     * @param inquiries The list of inquiries to save.
     */
    public void saveInquiriesToFile(List<Inquiry> inquiries) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("InquiryFile.txt", true))) {
    
            for (Inquiry Inquiry : inquiries) {

                writer.write("Sender: " + Inquiry.getUsername() + "\n");
                writer.write("Inquiry: " + Inquiry.getMessage() + "\n");
                writer.write("Camp: " + Inquiry.getCampName() + "\n");
                writer.write("Reply: " + Inquiry.getReply() + "\n");
                writer.write("Replier: " + Inquiry.getReplierID()+"\n");
                
                writer.write("\n"); // Add a separator between inquiries
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    



    //clear the contents
    /**
     * Clears the contents of the file.
     *
     * @param fileName The name of the file to clear.
     */
    public static void clearFile(String fileName) {
    try (PrintWriter writer = new PrintWriter(fileName)) {
        // Empty the file
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

    /**
     * Edits a list of inquiries in the file.
     *
     * @param fileName  The name of the file to edit.
     * @param inquiries The list of inquiries to edit.
     */
    public void editInquiriesToFile(String fileName, List<Inquiry> inquiries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("InquiryFile.txt"))) {
            for (Inquiry Inquiry : inquiries) {
                writer.write("Sender: " + Inquiry.getUsername() + "\n");
                writer.write("Inquiry: " + Inquiry.getMessage() + "\n");
                writer.write("Camp: " + Inquiry.getCampName() + "\n");
                writer.write("Reply: " + Inquiry.getReply() + "\n");
                writer.write("Replier: " + Inquiry.getReplierID() + "\n");
                writer.write("\n"); // Add a separator between inquiries
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

// Find the student(s) by Username
    /**
     * Finds students with the specified username in the file.
     *
     * @param fileName The name of the file to search.
     * @param username The username to search for.
     * @return A list of StoreInquiry objects matching the specified username.
     */
public static List<StoreInquiry> findStudentByUsername(String fileName, String username) {
    List<StoreInquiry> students = new ArrayList<>();
    for (int i = 0; i< 1; i++) {
        students.add(null);
    }
    try (Scanner scanner = new Scanner(new File(fileName))) {
        if (!(scanner.hasNextLine())){
            return students;
        }
        students.remove(0);
        while (scanner.hasNextLine()) {
            String senderLine = scanner.nextLine();
            String messageLine = scanner.nextLine();
            String campLine = scanner.nextLine();
            String replyLine = scanner.nextLine();
            String replierLine = scanner.nextLine();
            scanner.nextLine(); // Skip the empty line

            // Extract data from lines
            String currentSender = senderLine.replace("Sender: ", "").trim();
            messageLine = messageLine.replace("Inquiry: ", "").trim();
            campLine = campLine.replace("Camp: ", "").trim();
            replyLine = replyLine.replace("Reply: ", "").trim();
            replierLine = replierLine.replace("Replier: ", "").trim();

            // Check if the current user is a Student and has the specified username
            if (currentSender.equals(username)) {
                // Create a Student object with the extracted data

                StoreInquiry student = new StoreInquiry(currentSender,messageLine,campLine,replyLine,replierLine);
                student.setUsername(currentSender);
                student.setCamp(campLine);
                student.setInquiry(messageLine);
                student.setReply(replyLine);
                student.setReplierID(replierLine);
                students.add(student);
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    return students;
}

    /**
     * Finds students in the specified camp in the file.
     *
     * @param fileName  The name of the file to search.
     * @param CampInput The camp name to search for.
     * @return A list of StoreInquiry objects matching the specified camp name.
     */
public static List<StoreInquiry> findStudentByCamp(String fileName, String CampInput) {
    List<StoreInquiry> campattendees = new ArrayList<>();
    for (int i = 0; i< 1; i++) {
        campattendees.add(null);
    }
    try (Scanner scanner = new Scanner(new File(fileName))) {
        if (!(scanner.hasNextLine())){
            return campattendees;
        }
        campattendees.remove(0);
        while (scanner.hasNextLine()) {
            String senderLine = scanner.nextLine();
            String messageLine = scanner.nextLine();
            String campLine = scanner.nextLine();
            String replyLine = scanner.nextLine();
            String replierLine = scanner.nextLine();

            scanner.nextLine(); // Skip the empty line

            // Extract data from lines
            String currentSender = senderLine.replace("Sender: ", "").trim();
            messageLine = messageLine.replace("Inquiry: ", "").trim();
            campLine = campLine.replace("Camp: ", "").trim().toUpperCase();
            replyLine = replyLine.replace("Reply: ", "").trim();
            replierLine = replierLine.replace("Replier: ", "").trim();

            // Check if the current user is a Student and has the specified username
            if (campLine.equals(CampInput)) {
                // Create a Student object with the extracted data

                StoreInquiry student = new StoreInquiry(currentSender,messageLine,campLine,replyLine,replierLine);
                student.setUsername(currentSender);
                student.setCamp(campLine);
                student.setInquiry(messageLine);
                student.setReply(replyLine);
                student.setReplierID(replierLine);
                campattendees.add(student);
            }
    }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return campattendees;
}

     /**
     * Deletes an inquiry from the file based on the camp associated with the inquiry.
     *
     * @param fileName The name of the file to delete the inquiry from.
     * @param student   The StoreInquiry object representing the inquiry to be deleted.
     */
    public void deleteInquiryInFile(String fileName, StoreInquiry student) {
        String CampInput = student.getCamp();
        Path path = Paths.get(fileName);
    
        try {
            List<String> lines = Files.readAllLines(path);

            int i = 0;
            while (i < lines.size()) {
                String campLine = lines.get(i + 2);
                campLine = campLine.replace("Camp: ", "").trim().toUpperCase();;
                if (campLine.equals(CampInput)) {
        
                    for (int j = 0; j < 6; j++) {
                        lines.remove(i);
                    }
                    break;
                }
                i += 6;
            }
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}
