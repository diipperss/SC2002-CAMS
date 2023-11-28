/**
 * The CampCommitteeInquiry class represents inquiries made by Camp Committee members in response to student inquiries.
 * It extends the StudentInquiry class and implements the InquiryInterface.
 *
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
package inquiry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.Camp;
import errorhandling.InputExceptionHandler;
import user.CampCommitteeUser;

public class CampCommitteeInquiry extends StudentInquiry implements InquiryInterface {

    private CampCommitteeUser campcommitteeuser;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a CampCommitteeInquiry object with the provided CampCommitteeUser.
     *
     * @param campcommitteeuser The CampCommitteeUser associated with this inquiry.
     */
    public CampCommitteeInquiry(CampCommitteeUser campcommitteeuser) {
        super(campcommitteeuser);
    }

    /**
     * Responds to inquiries made by students for the camp associated with the CampCommitteeUser.
     *
     * @param campcommitteeuser The CampCommitteeUser responding to inquiries.
     */
    public static void respondToInquiry(CampCommitteeUser campcommitteeuser) {
        Camp campMemberof = campcommitteeuser.getMemberOf();
        String campName = campMemberof.getName().toUpperCase();
        //find inquiries and print inquiries
        int inquiryIndex = 1;
        List<Inquiry> indexedInquiries = new ArrayList<>(); 
        List<StoreInquiry> campattendees = InquiryHandler.findStudentByCamp("InquiryFile.txt", campName);
        InquiryHandler inquiryHandler = new InquiryHandler("InquiryFile.txt");

        if ((campattendees.get(0) == null) || (campattendees.size() == 1 && campattendees.get(0) == null)) {
            System.out.println("No inquiries found.");
        } else {
            System.out.println("Inquiries by students for " + campName + " :");
            for (StoreInquiry student : campattendees) {
                System.out.println(inquiryIndex + ".");
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
                indexedInquiries.add(inquiryAdd); //add all these inquiries to the new arraylist
                inquiryIndex++;
                inquiryHandler.deleteInquiryInFile("InquiryFile.txt", student); //NOT WORKING
            }

            System.out.println("Select the Inquiry you want to reply to (e.g. '1'): ");
            int replyThisIndex = InputExceptionHandler.scanNextInt(scanner);
            if (replyThisIndex == -1) return;
            //replying to the inquiry
            if ("null".equals(indexedInquiries.get(replyThisIndex - 1).getReply())) {
                //store the inquiry that needs to be replied.
                Inquiry inquiryEdit = new Inquiry();
                inquiryEdit.setStudent(indexedInquiries.get(replyThisIndex - 1).getStudent());
                inquiryEdit.setCamp(indexedInquiries.get(replyThisIndex - 1).getCampName());
                inquiryEdit.setMessage(indexedInquiries.get(replyThisIndex - 1).getMessage());

                scanner.nextLine(); //consume the newline character
                System.out.println("Key in your reply: ");
                String newReply = scanner.nextLine();
                //edit the inquiry
                inquiryEdit.setReply(newReply);
                inquiryEdit.setReplierID(campcommitteeuser.getName());

                indexedInquiries.remove(replyThisIndex - 1); //delete outdated entry from the new arraylist
                indexedInquiries.add(inquiryEdit); //add updated entry to newarraylist

                inquiryHandler.saveInquiriesToFile(indexedInquiries);

                System.out.println("Inquiry successfully replied!");
                campcommitteeuser.setPoints(campcommitteeuser.getPoints() + 1);
                System.out.println("You have gained one more point!");
            } else {
                inquiryHandler.saveInquiriesToFile(indexedInquiries);
                System.out.println("Inquiry has already been replied!");
            }
        }
    }

    /**
     * Displays inquiries made by students for the camp associated with the CampCommitteeUser.
     *
     * @param campcommitteeuser The CampCommitteeUser viewing inquiries.
     */
    public static void viewInquiry(CampCommitteeUser campcommitteeuser) {
        //list of their created camps

        Camp campMemberof = campcommitteeuser.getMemberOf();
        String campName = campMemberof.getName().toUpperCase();

        List<StoreInquiry> students = InquiryHandler.findStudentByCamp("InquiryFile.txt", campName);
        if ((students.get(0) == null) || (students.size() == 1 && students.get(0) == null)) {
            System.out.println("No inquiries found.");
        } else {
            System.out.println("Inquiries by students:");
            int inquiryIndex = 1;
            for (StoreInquiry student : students) {
                System.out.println(inquiryIndex + ".");
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
