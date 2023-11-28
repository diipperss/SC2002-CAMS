package inquiry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.AllCamps;
import camp.Camp;
import errorhandling.InputExceptionHandler;
import user.*;

/**
 * The StaffInquiry class provides methods for staff users to respond to and view inquiries related to the camps they created.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class StaffInquiry implements InquiryInterface {

    Scanner scanner = new Scanner(System.in);  

    public StaffInquiry(StaffUser staffuser){
    }

    /**
     * Responds to inquiries for the camps created by the staff user.
     *
     * @param staffuser The staff user responding to inquiries.
     */
    public static void respondToInquiry(StaffUser staffuser) {
        Scanner scanner = new Scanner(System.in);    
        //print out camps created
        //list of their created camps.
        List<Camp> campsCreated = new ArrayList<>();
            for (Camp camp : AllCamps.getAllCamps()) {
                if (camp.getStaffInCharge() == staffuser.getName()) {
                    campsCreated.add(camp);
                }
        }
        //print list of their created camps.
        if (campsCreated.isEmpty()) {
            System.out.println("No camps created!");
        } else {
            System.out.println("Available camps:");
            int index=1;
            for (Camp camp1 : campsCreated) {
                System.out.println(index + ". " + camp1.getName());
                index++;
            }
        //find the camp
        System.out.println("Enter choice of camp: ");
        int campIndex = InputExceptionHandler.scanNextInt(scanner);
        if(campIndex == -1) return;
        scanner.nextLine();  //consume the newline character
        String campName = campsCreated.get(campIndex - 1).getName().toUpperCase();
    
        //find the students' inquiries for that camp
        int inquiryIndex = 1;
        List<Inquiry> indexedInquiries = new ArrayList<>(); 
        List<StoreInquiry> campattendees = InquiryHandler.findStudentByCamp("InquiryFile.txt", campName);
        InquiryHandler inquiryHandler = new InquiryHandler("InquiryFile.txt");

        if ((campattendees.get(0) == null ||campattendees.size() == 1 && campattendees.get(0) == null)) {
            System.out.println("No inquiries found.");
        } else {
            System.out.println("Inquiries by students:");
            for (StoreInquiry student : campattendees) {
                System.out.println(inquiryIndex+".");
                System.out.println("Username: " + student.getUsername());
                System.out.println("Inquiry: " + student.getInquiry());
                System.out.println("Camp Name: " + student.getCamp());
                System.out.println("Reply: " +student.getReply());
                System.out.println("ReplierID: " +student.getReplierID());
                System.out.println("--------------------------");
                Inquiry inquiryAdd = new Inquiry();
                inquiryAdd.setStudent(student);
                inquiryAdd.setMessage(student.getInquiry());
                inquiryAdd.setCamp(student.getCamp());
                inquiryAdd.setReply(student.getReply());
                indexedInquiries.add(inquiryAdd); //add all these inquiries to the new arraylist
                inquiryIndex++;
                inquiryHandler.deleteInquiryInFile("InquiryFile.txt",student); //NOT WORKING

            }

            System.out.println("Select the inquiry you want to reply to (e.g. '1'): ");
            int replyThisIndex = InputExceptionHandler.scanNextInt(scanner);
            if(replyThisIndex == -1) return;
            if ("null".equals(indexedInquiries.get(replyThisIndex-1).getReply())){
                //store the inquiry that needs to be replied.
                Inquiry inquiryEdit = new Inquiry();
                inquiryEdit.setStudent(indexedInquiries.get(replyThisIndex-1).getStudent());
                inquiryEdit.setCamp(indexedInquiries.get(replyThisIndex-1).getCampName());
                inquiryEdit.setMessage(indexedInquiries.get(replyThisIndex-1).getMessage());
                
                scanner.nextLine();  //consume the newline character
                System.out.println("Key in your reply: ");
                String newReply = scanner.nextLine();
                //edit the inquiry
                inquiryEdit.setReply(newReply);
                inquiryEdit.setReplierID(staffuser.getName());
                //System.out.println(inquiryEdit);

                indexedInquiries.remove(replyThisIndex-1); //delete outdated entry from the new arraylist
                indexedInquiries.add(inquiryEdit); //add updated entry to newarraylist
              
               inquiryHandler.saveInquiriesToFile(indexedInquiries);

                System.out.println("Inquiry successfully replied!");


            }
            else{
               inquiryHandler.saveInquiriesToFile(indexedInquiries);
                System.out.println("Inquiry has already been replied!");
            }
    
    }
}
}
    /**
     * Views inquiries for the camps created by the staff user.
     *
     * @param staffuser The staff user viewing inquiries.
     */
    public static void viewInquiry(StaffUser staffuser) {
        Scanner scanner = new Scanner(System.in);        
        //list of their created camps
        List<Camp> campsCreated = new ArrayList<>();
            for (Camp camp : AllCamps.getAllCamps()) {
                if (camp.getStaffInCharge() == staffuser.getName()) {
                    campsCreated.add(camp);
                }
        }
        //print list of their created camps.
        if (campsCreated.isEmpty()) {
            System.out.println("No camps created!");
        } else {
            System.out.println("Available camps:");
            int index=1;
            for (Camp camp1 : campsCreated) {
                System.out.println(index + ". " + camp1.getName());
                index++;
            }
            
        //find the camp
        System.out.println("Enter choice of camp: ");
        int campIndex = InputExceptionHandler.scanNextInt(scanner);
        if(campIndex == -1) return;
        scanner.nextLine();  //consume the newline character
        String campName = campsCreated.get(campIndex - 1).getName().toUpperCase();

        List<StoreInquiry> students = InquiryHandler.findStudentByCamp("InquiryFile.txt", campName);
        if ((students.get(0) == null || students.size() == 1 && students.get(0) == null)) {
            System.out.println("No inquiries found.");
        }
        else{
            System.out.println("Inquiries by students:");
            int inquiryIndex=1;
            for (StoreInquiry student : students) {
                System.out.println(inquiryIndex+".");
                System.out.println("Username: " + student.getUsername());
                System.out.println("Inquiry: " + student.getInquiry());
                System.out.println("Camp: " + student.getCamp());
                System.out.println("Reply: " + student.getReply());
                System.out.println("ReplierID: " + student.getReplierID());
                System.out.println("--------------------------");
                inquiryIndex++;

                }
            }
        }
    }

    }


