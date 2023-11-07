package camp_system.camp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import camp_system.date_parser.DateParse;
import camp_system.user.User;
import camp_system.user.Faculty;
import camp_system.user.Role;

/**
 * Represents a camp manager that controls a list of all the camps
 */
public class CampControl {
    /** List of all the available camps */
    private ArrayList <Camp> camps;

    /** Scanner object */
    public Scanner scan = new Scanner(System.in);

    /** Date parsing object */
    public DateParse dateParse = new DateParse();

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
    public Boolean validUser(User user) {
        if (user.getRole() == Role.STAFF) return true;
        System.out.println("Only Staff are permitted to conduct this operation");
        return false;
    }


    public void addTemplate(User user) throws ParseException {
        if (!validUser(user)) return;
        camps.add(new Camp("camp1", Faculty.NTU, "ntu", "camp1 in ntu!", dateParse.date("12-12-2023 10:00"), dateParse.date("15-12-2023 15:00"), dateParse.date("10-12-2023 23:59"), 100, 10, user));
    }

    /**
     * Adds a new camp to the list of available camps
     * @param user This is the user (staff) that creates the camp
     * @throws ParseException
     */
    public void addCamp(User user) throws ParseException {
        if (!validUser(user)) return;
        System.out.printf("Name: "); String name = scan.nextLine();
        System.out.printf("Group: "); Faculty group = Faculty.fromString(scan.nextLine());
        System.out.printf("Location: "); String location = scan.nextLine();
        System.out.printf("Description: "); String description = scan.nextLine();
        System.out.printf("Start Date: "); Date startDate = dateParse.date(scan.nextLine());
        System.out.printf("End Date: "); Date endDate = dateParse.date(scan.nextLine());
        System.out.printf("Register By: "); Date registerBy = dateParse.date(scan.nextLine());
        System.out.printf("Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
        System.out.printf("Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
        camps.add(new Camp(name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, user));
    }

    private void editMenu() {
        System.out.println("Select Attribute to Edit:");
        System.out.println("1: Visibility");
        System.out.println("2: Name");
        System.out.println("3: Group");
        System.out.println("4: Location");
        System.out.println("5: Description");
        System.out.println("6: Start Date");
        System.out.println("7: End Date");
        System.out.println("8: Register By");
        System.out.println("9: Total Slots (Inclusive of Committee Slots)");
        System.out.println("10: Committee Slots");
    }

    /**
     * Prints the provided camp objects in the standardized format 
     * @param camps This is the list of camps to print
     */
    public void printCamps(ArrayList <Camp> camps) {
        if (camps.size() <= 0) {
            System.out.println("No Camps Found");
            return;
        }
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf((i + 1) + " -> ");
            camps.get(i).printCampDetails();
            System.out.println();
        }
    }

    /**
     * Edits the camp that is required in the camp list
     * @param user This is the current user that is editing the camp
     * @throws ParseException
     */
    public void editCamp(User user) throws ParseException {
        if (!validUser(user)) return;
        ArrayList <Camp> createdCamps = getStaffCamps(user);
        printCamps(createdCamps);

        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        Camp camp = createdCamps.get(index - 1);
        editMenu();
        int option = scan.nextInt(); scan.nextLine();
        switch (option) {
            case 1:
                System.out.printf("Enter New Visibility: "); Boolean active = scan.nextBoolean();
                camp.setActive(active); break;
            case 2:
                System.out.printf("Enter New Name: "); String name = scan.nextLine();
                camp.setName(name); break;
            case 3:
                System.out.printf("Enter New Group: "); String group = scan.nextLine();
                camp.setGroup(Faculty.fromString(group)); break;
            case 4:
                System.out.printf("Enter New Location: "); String location = scan.nextLine();
                camp.setLocation(location); break;
            case 5:
                System.out.printf("Enter New Description: "); String description = scan.nextLine();
                camp.setDescription(description); break;
            case 6:
                System.out.printf("Enter New Start Date: "); String startDate = scan.nextLine();
                camp.setStartDate(dateParse.date(startDate)); break;
            case 7:
                System.out.printf("Enter New End Date: "); String endDate = scan.nextLine();
                camp.setEndDate(dateParse.date(endDate)); break;
            case 8:
                System.out.printf("Enter New Date to Register By: "); String registerBy = scan.nextLine();
                camp.setRegisterBy(dateParse.date(registerBy)); break;
            case 9:
                System.out.printf("Enter New Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
                camp.setTotalSlots(totalSlots); break;
            case 10:
                System.out.printf("Enter New Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
                camp.setCommitteeSlots(committeeSlots); break;
            default:
                System.out.println("Invalid Option"); break;
        }
    }

    /**
     * Deletes a camp from the camp list
     * @param user This is the user that is deleting camps
     */
    public void deleteCamp(User user) {
        if (!validUser(user)) return;
        ArrayList <Camp> createdCamps = getStaffCamps(user);
        printCamps(createdCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        camps.remove(createdCamps.get(index - 1));
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
        printCamps(availableCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        availableCamps.get(index - 1).addAttendee(user);
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
        printCamps(availableCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        availableCamps.get(index - 1).addCommittee(user);
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
        printCamps(registeredCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        registeredCamps.get(index - 1).removeAttendee(user);
    }

    /**
     * Prints the roles of all the students in the specified camp
     * @param camps This is the list of camps to select from
     */
    public void viewRoles(ArrayList <Camp> camps) {
        printCamps(camps);
        System.out.printf("Enter Camp Option: "); int option = scan.nextInt(); scan.nextLine();
        camps.get(option).printRoles();
    }
}
