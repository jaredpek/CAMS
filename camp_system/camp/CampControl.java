package camp_system.camp;

import java.text.ParseException;
import java.util.ArrayList;

import camp_system.user.User;
import camp_system.user.Faculty;
import camp_system.user.Role;

/**
 * Represents a camp manager that controls a list of all the camps
 */
public class CampControl implements ICamp {
    /** List of all the available camps */
    private ArrayList <Camp> camps;
    private CampBuild campBuild = new CampBuild();
    private CampEdit campEdit = new CampEdit();
    private CampSelect campSelect = new CampSelect();
    private CampSort campSort = new CampSort();

    /** Creates a new CampControl object with a default empty list */
    public CampControl() {this.camps = new ArrayList <Camp> ();}

    /**
     * Creates a new CampControl object with an initial list of camps
     * @param camps This is the initial list of camps
     */
    public CampControl(ArrayList <Camp> camps) {
        this.camps = camps;
    }

    /**
     * Returns whether or not a user can add, edit or delete camps
     * @param user This is the user to check
     * @return Boolean
     */
    private Boolean validUser(User user) {
        if (user.getRole() == Role.STAFF) return true;
        System.out.println("Only Staff are permitted to conduct this operation");
        return false;
    }

    /**
     * Adds a new camp to the list of available camps
     * @param user This is the user (staff) that creates the camp
     * @throws ParseException
     */
    public void addCamp(User user) throws ParseException {
        if (!validUser(user)) return;
        camps.add(campBuild.build(user));
        campSort.sortByAlphabetical(camps, 0);
    }

    public void addTemplate(User user) throws ParseException {
        if (!validUser(user)) return;
        camps.add(campBuild.template(user));
    }

    /**
     * Edits the camp that is required in the camp list
     * @param user This is the current user that is editing the camp
     * @throws ParseException
     */
    public void editCamp(User user) throws ParseException {
        if (!validUser(user)) return;
        ArrayList <Camp> createdCamps = getStaffCamps(user);
        Camp camp = campSelect.select(createdCamps);
        campEdit.edit(camp);
    }

    /**
     * Deletes a camp from the camp list
     * @param user This is the user that is deleting camps
     */
    public void deleteCamp(User user) {
        if (!validUser(user)) return;
        ArrayList <Camp> createdCamps = getStaffCamps(user);
        Camp camp = campSelect.select(createdCamps);
        camps.remove(camp);
    }

    /**
     * Returns a list of all the camps available
     * @param user This is the user that is querying all the camps
     * @return ArrayList
     */
    public ArrayList <Camp> getAllCamps(User user) {
        if (!validUser(user)) return null;
        return camps;
    }

    /**
     * Returns a list of camps that are open to a specified group
     * @param group This is the group to check
     * @return ArrayList
     */
    public ArrayList <Camp> getGroupCamps(Faculty group) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.isGroup(group)) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user is involved in as an attendee
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getAttendeeCamps(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledAttendee(user)) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user is involved in as a committee member
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getCommitteeCamps(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledCommittee(user)) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user is involved in, regardless of whether attendee or committee
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getStudentCamps(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledAttendee(user) || camp.enrolledCommittee(user)) result.add(camp);
        }
        return result;
    }

    /**
     * Returns a list of camps that the user (staff) is in charge of
     * @param user This is the user to check
     * @return ArrayList
     */
    public ArrayList <Camp> getStaffCamps(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledStaff(user)) result.add(camp);
        }
        return result;
    }

    /**
     * Registers an attendee to a camp
     * @param user This is the user to register
     */
    public void registerAttendee(User user) {
        ArrayList <Camp> availableCamps = getGroupCamps(user.getFaculty());
        Camp camp = campSelect.select(availableCamps);
        camp.addAttendee(user);
    }

    /**
     * Registers a committee member to a camp
     * @param user This is the user to register
     */
    public void registerCommittee(User user) {
        ArrayList <Camp> registeredCamps = getCommitteeCamps(user);
        for (int i = 0; i < registeredCamps.size(); i ++) {
            if (registeredCamps.get(i).enrolledCommittee(user)) return;
        }
        ArrayList <Camp> availableCamps = getGroupCamps(user.getFaculty());
        Camp camp = campSelect.select(availableCamps);
        camp.addCommittee(user);
    }

    private void registerMenu() {
        System.out.println("Available Roles:");
        System.out.println("1: Attendee");
        System.out.println("2: Committee");
    }
    /**
     * Registers a user to a camp, user can select whether or not to enrol as attendee or committee
     * @param user This is the user to register
     */
    public void registerCamp(User user) {
        registerMenu();
        System.out.printf("Enter Option: "); int option = scan.nextInt(); scan.nextLine();
        switch (option) {
            case 1: registerAttendee(user); break;
            case 2: registerCommittee(user); break;
        }
    }

    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public void withdrawAttendee(User user) {
        ArrayList <Camp> registeredCamps = getAttendeeCamps(user);
        Camp camp = campSelect.select(registeredCamps);
        camp.removeAttendee(user);
    }
}
