package enquiry;

import java.util.ArrayList;

import camp.Camp;
import user.User;

/** An interface that implements methods to manipulate the list of enquiries*/
public interface IEnquiry {
    public void reply();
    public ArrayList<Enquiry> getByCamp(Camp camp);
    public ArrayList <Enquiry> getByStudent(User student);
}
