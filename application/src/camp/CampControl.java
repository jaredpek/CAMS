package camp;

import java.util.ArrayList;

import interfaces.IControl;
import user.Faculty;
import user.Role;
import user.User;

/** Represents a control class that manages a list of camps */
public class CampControl implements IControl, ICamp, IEnrolment {
    /** List of all the available camps */
    private static ArrayList <Camp> camps = new ArrayList <Camp> ();

    /** Static instance of CampControl */
    public static CampControl instance = new CampControl();

    /** Initialises the camp array with data from a CSV file */
    public static void start() {
        camps.addAll((new CampParse()).parse("application\\data\\camps.csv"));
    }

    /** Saves the camp array to the CSV file */
    public static void close() {
        (new CampParse()).write("application\\data\\camps.csv", camps);
    }

    /**
     * Returns whether or not a user can add, edit or delete camps
     * @param user The user to check
     * @return Boolean
     */
    private Boolean isStaff(User user) {
        if (user.getRole() == Role.STAFF) return true;
        System.out.println("Only Staff are permitted to conduct this operation");
        return false;
    }

    /** 
     * Adds a new camp to the list of available camps 
     * @param user The user adding the camp
     */
    public void add(User user) {
        if (!isStaff(user)) return;
        camps.add((new CampBuild()).build(user));
        (new CampSort()).sortByAlphabetical(camps, 0);
    }

    /** 
     * Adds a new camp to the list of available camps 
     * @param user The user adding the camp
     */
    public void addTemplate(User user) {
        if (!isStaff(user)) return;
        camps.add((new CampBuild()).template(user));
    }

    /** 
     * Edits the camp that is required in the camp list 
     * @param user The user editting the camp
     */
    public void edit(User user) {
        if (!isStaff(user)) return;
        ArrayList <Camp> createdCamps = getByStaff(user);
        Camp camp = (new CampSelect()).select(createdCamps, user.getUserID());
        (new CampEdit()).edit(camp);
    }

    /** 
     * Deletes a camp from the camp list
     * @param user The user deleting the camp
     */
    public void delete(User user) {
        if (!isStaff(user)) return;
        ArrayList <Camp> createdCamps = getByStaff(user);
        Camp camp = (new CampSelect()).select(createdCamps, user.getUserID());
        camps.remove(camp);
    }

    /**
     * Returns a camp with the required id
     * @param id This is the id of the camp
     * @return Camp
     */
    public Camp getCamp(long id) {
        for (Camp camp : camps) {
            if (camp.getId() == id) return camp;
        }
        return null;
    }

    /** 
     * Returns a list of all the camps available 
     * @param user The user getting all the camps
     * @return Arraylist of camp objects
     */
    public ArrayList <Camp> getAll(User user) {
        if (!isStaff(user)) return null;
        return camps;
    }

    /**
     * Returns a list of camps that are open to a specified group
     * @param group This is the group to check
     * @return ArrayList
     */
    public ArrayList <Camp> getByGroup(Faculty group) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.isGroup(group) && camp.getActive()) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user is involved in as an attendee
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getByAttendee(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledAttendee(user.getUserID()) && camp.getActive()) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user is involved in as a committee member
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getByCommittee(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledCommittee(user.getUserID()) && camp.getActive()) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that is open to the user, but is not involved in as a committee member
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getByGroupNotCommittee(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.isGroup(user.getFaculty()) && !camp.enrolledCommittee(user.getUserID()) && camp.getActive()) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user is involved in, regardless of whether attendee or committee
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getByStudent(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if ((camp.enrolledAttendee(user.getUserID()) || camp.enrolledCommittee(user.getUserID())) && camp.getActive()) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user (staff) is in charge of
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getByStaff(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledStaff(user.getUserID()) && camp.getActive()) result.add(camp);
        }
        return result;
    }
    
    /**
     * Registers an attendee to a camp
     * @param user This is the user to register
     */
    public void registerCamp(User user) {
        ArrayList <Camp> available = getByGroup(user.getFaculty());
        (new CampEnrol()).register(user.getUserID(), available);
    }

    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public void withdrawAttendee(User user) {
        ArrayList <Camp> registered = getByAttendee(user);
        (new CampWithdraw()).attendee(user.getUserID(), registered);
    }
}
