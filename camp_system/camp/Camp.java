package camp_system.camp;

import java.util.ArrayList;
import java.util.Date;

import camp_system.user.Faculty;
import camp_system.user.User;

public class Camp extends CampInformation {
    private Boolean active;
    private ArrayList <User> attendeeList, committeeList, withdrawedList;

    public Camp(
        String name, Faculty group, String location, String description,
        Date startDate, Date endDate, Date registerBy,
        int totalSlots, int committeeSlots,
        User staffInCharge
    ) {
        super(
            name, group, location, description, 
            startDate, endDate, registerBy, 
            totalSlots, committeeSlots, 
            staffInCharge
        );
        this.active = true;
        this.committeeList = new ArrayList <User> ();
        this.attendeeList = new ArrayList <User> ();
        this.withdrawedList = new ArrayList <User> ();
    }

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

    public Boolean getActive() { return active; }
    protected void setActive(Boolean active) { this.active = active; }

    public Boolean withinDate(Date date) {
        if (date.compareTo(getRegisterBy()) <= 0) return true;
        return false;
    }
    public Boolean enrolledAttendee(User student) {
        if (attendeeList.contains(student)) return true;
        return false;
    }
    public Boolean enrolledCommittee(User student) {
        if (committeeList.contains(student)) return true;
        return false;
    }
    public Boolean enrolledStaff(User staffInCharge) {
        if (getStaffInCharge() == staffInCharge) return true;
        return false;
    }
    public Boolean withdrawed(User student) {
        if (withdrawedList.contains(student)) return true;
        return false;
    }
    public Boolean vacancyAttendee() {
        int attendeeSlots = getTotalSlots() - getCommitteeSlots();
        if (attendeeList.size() < attendeeSlots) return true;
        return false;
    }
    public Boolean vacancyCommittee() {
        if (committeeList.size() < getCommitteeSlots()) return true;
        return false;
    }

    protected ArrayList <User> getAttendeeList() { return attendeeList; }
    protected void addAttendee(User user) {
        if (!vacancyAttendee()) {
            System.out.println("No more slots for attendees");
            return;
        }
        if (enrolledAttendee(user)) {
            System.out.println("Already enrolled as an attendee");
            return;
        }
        if (enrolledCommittee(user)) {
            System.out.println("Already enrolled in the committee");
            return;
        }
        if (enrolledStaff(user)) {
            System.out.println("Already enrolled as the staff in charge");
            return;
        }
        if (withdrawed(user)) {
            System.out.println("Previously withdrawed from the camp");
            return;
        }
        if (!withinDate(new Date())) {
            System.out.println("Register date has already passed");
            return;
        }
        attendeeList.add(user);
    }
    protected void removeAttendee(User user) {
        if (!enrolledAttendee(user)) {
            System.out.println("Not enrolled in this camp");
            return;
        }
        attendeeList.remove(user);
        withdrawedList.add(user);
    }

    protected ArrayList <User> getCommitteeList() { return committeeList; }
    protected void addCommittee(User user) {
        if (!vacancyCommittee()) {
            System.out.println("No more slots for attendees");
            return;
        }
        if (enrolledAttendee(user)) {
            System.out.println("Already enrolled as an attendee");
            return;
        }
        if (enrolledCommittee(user)) {
            System.out.println("Already enrolled in the committee");
            return;
        }
        if (enrolledStaff(user)) {
            System.out.println("Already enrolled as the staff in charge");
            return;
        }
        if (withdrawed(user)) {
            System.out.println("Previously withdrawed from the camp");
            return;
        }
        if (!withinDate(new Date())) {
            System.out.println("Register date has already passed");
            return;
        }
        committeeList.add(user);
    }

    public Boolean isGroup(Faculty group) {
        if (getGroup() == group || getGroup() == Faculty.NTU) return true;
        return false;
    }

    public Role getCampRole(User student) {
        if (enrolledStaff(student)) return Role.STAFF;
        if (enrolledAttendee(student)) return Role.ATTENDEE;
        if (enrolledCommittee(student)) return Role.COMMITTEE;
        return null;
    }
}
