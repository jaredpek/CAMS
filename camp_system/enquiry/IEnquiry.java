package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.user.User;

/** An interface that implements methods to manipulate the list of enquiries*/
public interface IEnquiry {
    public void reply(User user);
    public ArrayList<Enquiry> getByCamp(Camp camp);
    public ArrayList <Enquiry> getByStudent(User student);
}
