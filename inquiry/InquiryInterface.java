package inquiry;

/**
 * The InquiryInterface interface provides methods for viewing, editing, submitting, responding to, and checking
 * the status of inquiries.
 * 
 * @version 1.0
 * @since 2023-11-24
 * @author Grp4
 */
public interface InquiryInterface {
    
    /**
     * View inquiries.
     */
    public default void viewInquiry() {};

    /**
     * Edit inquiries.
     */
    public default void editInquiry() {};

    /**
     * Submit inquiries.
     */
    public default void submitInquiry() {};

    /**
     * Respond to inquiries.
     */
    public default void respondToInquiry() {};
    
    /**
     * Check the status of inquiries.
     */
    public default void statusOfInquiry() {};
}
