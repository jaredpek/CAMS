package camp;

import java.util.ArrayList;

import control.IControl;
import user.Faculty;
import user.Role;
import user.User;
import view.CAMS;

/** Represents a control class that manages a list of camps */
public class CampControl implements IControl, ICamp, IEnrolment {
    /** List of all the available camps */
    private static ArrayList <Camp> camps = new ArrayList <Camp> ();
    public static CampControl campControl = new CampControl();

    /** Initialises the camp array with data from a CSV file */
    public static void start() {
        camps.addAll(CampParse.parse(".\\application\\data\\camps.csv"));
    }

    /** Saves the camp array to the CSV file */
    public static void close() {
        CampParse.write(".\\application\\data\\camps.csv", camps);
    }

    /**
     * Returns whether or not a user can add, edit or delete camps
     * @param user This is the user to check
     * @return Boolean
     */
    private Boolean isStaff() {
        if (CAMS.currentUser.getRole() == Role.STAFF) return true;
        System.out.println("Only Staff are permitted to conduct this operation");
        return false;
    }

    /**
     * Adds a new camp to the list of available camps
     * @param user This is the user (staff) that creates the camp
     */
    public void add() {
        if (!isStaff()) return;
        camps.add(CampBuild.build());
        CampSort.sortByAlphabetical(camps, 0);
    }

    /**
     * Adds a new camp to the list of available camps
     * @param user This is the user (staff) that creates the camp
     */
    public void addTemplate() {
        if (!isStaff()) return;
        camps.add(CampBuild.template());
    }

    /**
     * Edits the camp that is required in the camp list
     * @param user This is the current user that is editing the camp
     */
    public void edit() {
        if (!isStaff()) return;
        ArrayList <Camp> createdCamps = getByStaff(CAMS.currentUser);
        Camp camp = CampSelect.select(createdCamps, CAMS.currentUser.getUserID());
        CampEdit.edit(camp);
    }

    /**
     * Deletes a camp from the camp list
     * @param user This is the user that is deleting camps
     */
    public void delete() {
        if (!isStaff()) return;
        ArrayList <Camp> createdCamps = getByStaff(CAMS.currentUser);
        Camp camp = CampSelect.select(createdCamps, CAMS.currentUser.getUserID());
        camps.remove(camp);
    }

    public Camp getCamp(long id) {
        for (Camp camp : camps) {
            if (camp.getId() == id) return camp;
        }
        return null;
    }

    /**
     * Returns a list of all the camps available
     * @param user This is the user that is querying all the camps
     * @return ArrayList
     */
    public ArrayList <Camp> getAll() {
        if (!isStaff()) return null;
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
        CampEnrol.register(user.getUserID(), available);
    }

    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public void withdrawAttendee(User user) {
        ArrayList <Camp> registered = getByAttendee(user);
        CampWithdraw.attendee(user.getUserID(), registered);
    }
}
