package camp_system.camp;

import java.util.ArrayList;

import camp_system.user.Faculty;
import camp_system.user.User;

/** An interface the implements methods to manipulate the list of camps */
public interface ICamp {
    public ArrayList <Camp> getAll(User user);
    public ArrayList <Camp> getByGroup(Faculty group);
    public ArrayList <Camp> getByAttendee(User user);
    public ArrayList <Camp> getByCommittee(User user);
    public ArrayList <Camp> getByStudent(User user);
    public ArrayList <Camp> getByStaff(User user);
}
