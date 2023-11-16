package camp_system.camp;

import java.util.ArrayList;
import java.util.Date;

import camp_system.user.Faculty;

/**
 * Represent a camp that is available to students
 */
public class Camp extends CampInformation {
    private long id;
    /** The status of a camp, if True, camp is active, else it is inactive */
    private Boolean active;

    /** The list of attendees of the camp */
    private ArrayList <String> attendeeList;

    /** The list of committee members of the camp */
    private ArrayList <String> committeeList;

    /** The list of attendees that previously withdrawed from the camp */
    private ArrayList <String> withdrawedList;

    /**
     * Creates a new Camp object with the relevant information
     * @param name This is the camp's name
     * @param group This is the group the camp is open to
     * @param location This is where the camp will be held
     * @param description This is the description of the camp
     * @param startDate This is when the camp starts
     * @param endDate This is the when the camp ends
     * @param registerBy This is when students must register for the camp
     * @param totalSlots This is the total number of slots available for the camp (both committee and attendees)
     * @param committeeSlots This is the number of slots available for committee members
     * @param staffInCharge This is the staff that is in charge of the entire camp
     */
    public Camp(
        long id, String name, Faculty group, String location, String description,
        Date startDate, Date endDate, Date registerBy,
        int totalSlots, int committeeSlots,
        String staffInCharge
    ) {
        super(
            name, group, location, description, 
            startDate, endDate, registerBy, 
            totalSlots, committeeSlots, 
            staffInCharge
        );
        this.id = id;
        this.active = true;
        this.committeeList = new ArrayList <String> ();
        this.attendeeList = new ArrayList <String> ();
        this.withdrawedList = new ArrayList <String> ();
    }
    
    public Camp(
        long id, Boolean active, String name, Faculty group, String location, String description,
        Date startDate, Date endDate, Date registerBy, int totalSlots, int committeeSlots, String staffInCharge, 
        ArrayList <String> committeeList, ArrayList <String> attendeeList, ArrayList <String> withdrawedList
    ) {
        super(
            name, group, location, description, 
            startDate, endDate, registerBy, 
            totalSlots, committeeSlots, 
            staffInCharge
        );
        this.id = id;
        this.active = active;
        this.committeeList = committeeList;
        this.attendeeList = attendeeList;
        this.withdrawedList = withdrawedList;
    }

    /** Print all the camp's details */
    public void printCampDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Start Date: " + getStartDate().toString());
        System.out.println("End Date: " + getEndDate().toString());
        System.out.println("Register By: " + getRegisterBy().toString());
        System.out.println("Group: " + getGroup());
        System.out.println("Location: " + getLocation());
        System.out.println("Description: " + getDescription());
        System.out.println("Attendee Slots Remaining: " + (getTotalSlots() - getCommitteeSlots() - attendeeList.size()));
        System.out.println("Committee Slots Remaining: " + (getCommitteeSlots() - committeeList.size()));
    }

    public void printCampDetails(String user) {
        this.printCampDetails();
        Role role = getCampRole(user);
        if (role != null) System.out.println("** You are a " + role + " of this camp");
    }

    /** Print the roles of all the students in the camp */
    public void printRoles() {
        System.out.printf("Total Slots = %d\n", this.getTotalSlots());
        System.out.printf("Committee (%d / %d)\n", committeeList.size(), this.getCommitteeSlots());
        for (String user : committeeList) System.out.println(user);
        System.out.printf("\nAttendee (%d / %d)\n", attendeeList.size(), this.getTotalSlots() - this.getCommitteeSlots());
        for (String user : attendeeList) System.out.println(user);
        System.out.println();
    }

    public long getId() { return id; }

    /**
     * Returns the current status of the camp, whether or not it is active
     * @return Boolean
     */
    public Boolean getActive() { return active; }

    /**
     * Sets the status of the camp, whether or not it is active
     * @param active This is the new status of the camp
     */
    protected void setActive(Boolean active) { this.active = active; }

    /**
     * Returns whether or not the camp still open for registration
     * @param date This is the date to check
     * @return Boolean
     */
    public Boolean withinDate(Date date) {
        if (date.compareTo(getRegisterBy()) <= 0) return true;
        return false;
    }

    /**
     * Returns whether or not a student is enrolled as an attendee
     * @param student This is the student to check
     * @return Boolean
     */
    public Boolean enrolledAttendee(String student) {
        if (attendeeList.contains(student)) return true;
        return false;
    }

    /**
     * Returns whether or not a student is enrolled as a committee member
     * @param student
     * @return Boolean
     */
    public Boolean enrolledCommittee(String student) {
        if (committeeList.contains(student)) return true;
        return false;
    }

    /**
     * Returns whether or not a staff is the staff in charge of the camp
     * @param staffInCharge
     * @return Boolean
     */
    public Boolean enrolledStaff(String staffInCharge) {
        if (getStaffInCharge().compareTo(staffInCharge) == 0) return true;
        return false;
    }

    /**
     * Returns whether of not a student has previously withdrawed from the camp
     * @param student
     * @return Boolean
     */
    public Boolean withdrawed(String student) {
        if (withdrawedList.contains(student)) return true;
        return false;
    }

    /**
     * Returns whether or not there are still vacancies for attendees to register
     * @return Boolean
     */
    public Boolean vacancyAttendee() {
        int attendeeSlots = getTotalSlots() - getCommitteeSlots();
        if (attendeeList.size() < attendeeSlots) return true;
        return false;
    }

    /**
     * Returns whether or not there are still vacancies for committee members to register
     * @return Boolean
     */
    public Boolean vacancyCommittee() {
        if (committeeList.size() < getCommitteeSlots()) return true;
        return false;
    }

    /**
     * Returns a list of all the attendees of the camp
     * @return ArrayList
     */
    public ArrayList <String> getAttendeeList() { return attendeeList; }

    /**
     * Adds an attendee to the camp if all requirements are fulfilled
     * @param user
     */
    protected void addAttendee(String user) {
        if (!vacancyAttendee()) { System.out.println("No more slots for attendees"); return; }
        if (enrolledAttendee(user)) { System.out.println("Already enrolled as an attendee"); return; }
        if (enrolledCommittee(user)) { System.out.println("Already enrolled in the committee"); return; }
        if (enrolledStaff(user)) { System.out.println("Already enrolled as the staff in charge"); return; }
        if (withdrawed(user)) { System.out.println("Previously withdrawed from the camp"); return; }
        if (!withinDate(new Date())) { System.out.println("Register date has already passed"); return; }
        attendeeList.add(user);
    }

    /**
     * Withdraws an attendee from the camp
     * @param user
     */
    protected void removeAttendee(String user) {
        if (!enrolledAttendee(user)) {
            System.out.println("Not enrolled in this camp");
            return;
        }
        attendeeList.remove(user);
        withdrawedList.add(user);
    }

    /**
     * Returns a list of committee members of the camp
     * @return ArrayList
     */
    public ArrayList <String> getCommitteeList() { return committeeList; }

    /**
     * Adds a committee member to the camp if all requirements are fulfilled
     * @param user
     */
    protected void addCommittee(String user) {
        if (!vacancyCommittee()) { System.out.println("No more slots for attendees"); return; }
        if (enrolledAttendee(user)) { System.out.println("Already enrolled as an attendee"); return; }
        if (enrolledCommittee(user)) { System.out.println("Already enrolled in the committee"); return; }
        if (enrolledStaff(user)) { System.out.println("Already enrolled as the staff in charge"); return; }
        if (withdrawed(user)) { System.out.println("Previously withdrawed from the camp"); return; }
        if (!withinDate(new Date())) { System.out.println("Register date has already passed"); return; }
        committeeList.add(user);
    }

    /**
     * Returns a list of users that withdrawed from the camp
     * @return ArrayList
     */
    public ArrayList <String> getWithdrawedList() { return withdrawedList; }

    /**
     * Returns whether the camp is open to a specified group
     * @param group
     * @return Boolean
     */
    public Boolean isGroup(Faculty group) {
        if (getGroup() == group || getGroup() == Faculty.NTU) return true;
        return false;
    }

    /**
     * Returns the role of a user in the camp
     * @param user
     * @return Role
     */
    public Role getCampRole(String user) {
        if (enrolledStaff(user)) return Role.STAFF;
        if (enrolledAttendee(user)) return Role.ATTENDEE;
        if (enrolledCommittee(user)) return Role.COMMITTEE;
        return null;
    }
}
