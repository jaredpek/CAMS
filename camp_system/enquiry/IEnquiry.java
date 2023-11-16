package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.user.User;

public interface IEnquiry {
    public void reply(User user);
    public ArrayList<Enquiry> getByCamp(Camp camp);
    public ArrayList <Enquiry> getByStudent(User student);
}
