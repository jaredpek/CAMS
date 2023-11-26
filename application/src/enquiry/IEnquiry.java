package enquiry;

import java.util.ArrayList;

import camp.Camp;
import user.User;

/** 
 * An interface that implements methods to manipulate the list of enquiries
 * @author Tan Yoong Ken
 */
public interface IEnquiry {
    /** An EnquiryParse object */
    public EnquiryParse enquiryParse = new EnquiryParse();
    /** An EnquiryBuild object */
    public EnquiryBuild enquiryBuild = new EnquiryBuild();
    /** An EnquiryEdit object */
    public EnquiryEdit enquiryEdit = new EnquiryEdit();
    /** An EnquirySelect object */
    public EnquirySelect enquirySelect = new EnquirySelect();
    /** An EnquiryReply object */
    public EnquiryReply enquiryReply = new EnquiryReply();
    /** 
     * Method to reply to enquiry 
     * @param user The user replying to the enquiry
     */
    public void reply(User user);
    /**
     * Returns an arraylist of enquiries for a specific camp
     * @param camp Camp to filter enquiries by
     * @return Arraylist of enquiry objects
     */
    public ArrayList<Enquiry> getByCamp(Camp camp);
    /**
     * Returns an arraylist of enquiries for a specific student
     * @param student Student to filter enquiries by
     * @return Arraylist of enquiry objects
     */
    public ArrayList <Enquiry> getByStudent(User student);
}
