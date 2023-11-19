package enquiry;

import java.util.ArrayList;

import camp.Camp;
import user.User;

/** An interface that implements methods to manipulate the list of enquiries*/
public interface IEnquiry {
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
