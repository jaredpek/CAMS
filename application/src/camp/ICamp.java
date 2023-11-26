package camp;

import java.util.ArrayList;

import user.Faculty;
import user.User;

/** 
 * An interface the implements methods to manipulate the list of camps
 * @author Jared Pek
 */
public interface ICamp {
    /** A CampParse object */
    public CampParse campParse = new CampParse();
    /** A CampBuild object */
    public CampBuild campBuild = new CampBuild();
    /** A CampEdit object */
    public CampEdit campEdit = new CampEdit();
    /** A CampSort object */
    public CampSort campSort = new CampSort();
    /** A CampSelect object */
    public CampSelect campSelect = new CampSelect();
    /** 
     * Method to get all camps in the list 
     * @param user The user getting all the camps
     * @return Arraylist of camps
     */
    public ArrayList <Camp> getAll(User user);
    /**
     * Returns only a list of camps open to the group
     * @param group The group to check
     * @return Arraylist of camps
     */
    public ArrayList <Camp> getByGroup(Faculty group);
    /**
     * Returns a list of camps a user is an attendee of
     * @param user The user to check
     * @return Arraylist of camps
     */
    public ArrayList <Camp> getByAttendee(User user);
    /**
     * Returns a list of camps a user is a committee of
     * @param user The user to check
     * @return Arraylist of camps
     */
    public ArrayList <Camp> getByCommittee(User user);
    /**
     * Returns a list of camps the user is involved in, either as attendee or committee
     * @param user The user to check
     * @return Arraylist of camps
     */
    public ArrayList <Camp> getByStudent(User user);
    /**
     * Returns a list of camps the user is involved in as staff
     * @param user The user to check
     * @return Arraylist of camps
     */
    public ArrayList <Camp> getByStaff(User user);
}
