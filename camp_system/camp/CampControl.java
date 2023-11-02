package camp_system.camp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import camp_system.date_parser.DateParse;
import camp_system.user.User;
import camp_system.user.Faculty;
import camp_system.user.Role;

public class CampControl {
    private ArrayList <Camp> camps = new ArrayList <Camp> ();
    public Scanner scan = new Scanner(System.in);
    public DateParse dateParse = new DateParse();

    public void addTemplate(User user) throws ParseException {
        if (!(user.getRole() == Role.STAFF)) {
            System.out.println("Only Staff can add Camps");
            return;
        }
        camps.add(new Camp("camp1", Faculty.NTU, "ntu", "camp1 in ntu!", dateParse.date("12-12-2023 10:00"), dateParse.date("15-12-2023 15:00"), dateParse.date("10-12-2023 23:59"), 100, 10, user));
    }

    public void addCamp(User user) throws ParseException {
        if (!(user.getRole() == Role.STAFF)) {
            System.out.println("Only Staff can add Camps");
            return;
        }
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
    public void printCamps(ArrayList <Camp> camps) {
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf((i + 1) + " -> ");
            camps.get(i).printCampDetails();
            System.out.println();
        }
    }
    public void editCamp(User user) throws ParseException {
        if (!(user.getRole() == Role.STAFF)) {
            System.out.println("Only Staff can Edit Camps");
            return;
        }
        ArrayList <Camp> createdCamps = getCamps(user);
        if (createdCamps.size() <= 0) {
            System.out.println("No Camps Created");
            return;
        }
        printCamps(createdCamps);

        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        Camp camp = createdCamps.get(index - 1);
        editMenu();
        int option = scan.nextInt(); scan.nextLine();
        switch (option) {
            case 1:
                System.out.printf("Enter New Visibility: "); Boolean active = scan.nextBoolean();
                camp.setActive(active);
                break;
            case 2:
                System.out.printf("Enter New Name: "); String name = scan.nextLine();
                camp.setName(name);
                break;
            case 3:
                System.out.printf("Enter New Group: "); String group = scan.nextLine();
                camp.setGroup(Faculty.fromString(group));
                break;
            case 4:
                System.out.printf("Enter New Location: "); String location = scan.nextLine();
                camp.setLocation(location);
                break;
            case 5:
                System.out.printf("Enter New Description: "); String description = scan.nextLine();
                camp.setDescription(description);
                break;
            case 6:
                System.out.printf("Enter New Start Date: "); String startDate = scan.nextLine();
                camp.setStartDate(dateParse.date(startDate));
                break;
            case 7:
                System.out.printf("Enter New End Date: "); String endDate = scan.nextLine();
                camp.setEndDate(dateParse.date(endDate));
                break;
            case 8:
                System.out.printf("Enter New Date to Register By: "); String registerBy = scan.nextLine();
                camp.setRegisterBy(dateParse.date(registerBy));
                break;
            case 9:
                System.out.printf("Enter New Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
                camp.setTotalSlots(totalSlots);
                break;
            case 10:
                System.out.printf("Enter New Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
                camp.setCommitteeSlots(committeeSlots);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    public void deleteCamp(User user) {
        if (!(user.getRole() == Role.STAFF)) {
            System.out.println("Only Staff can Delete Camps");
            return;
        }
        ArrayList <Camp> createdCamps = getCamps(user);
        if (createdCamps.size() <= 0) {
            System.out.println("No Camps Created");
            return;
        }
        printCamps(createdCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        camps.remove(createdCamps.get(index - 1));
    }

    public ArrayList <Camp> getAllCamps(User user) {
        if (user.getRole() == Role.STAFF) return camps;
        return null;
    }

    public ArrayList <Camp> getCamps(Faculty group) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.isGroup(group)) {
                result.add(camp);
            }
        }
        return result;
    }

    public ArrayList <Camp> getCamps(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledAttendee(user) || camp.enrolledCommittee(user) || camp.enrolledStaff(user)) {
                result.add(camp);
            }
        }
        return result;
    }

    public void registerAttendee(User user) {
        ArrayList <Camp> availableCamps = getCamps(user.getFaculty());
        if (availableCamps.size() <= 0) {
            System.out.println("No Camps Available");
            return;
        }
        printCamps(availableCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        availableCamps.get(index - 1).addAttendee(user);
    }

    public void registerCommittee(User user) {
        ArrayList <Camp> registeredCamps = getCamps(user.getFaculty());
        for (int i = 0; i < registeredCamps.size(); i ++) {
            if (registeredCamps.get(i).enrolledCommittee(user)) return;
        }
        ArrayList <Camp> availableCamps = getCamps(user.getFaculty());
        if (availableCamps.size() <= 0) {
            System.out.println("No Camps Available");
            return;
        }
        printCamps(availableCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        availableCamps.get(index - 1).addCommittee(user);
    }

    public void withdrawAttendee(User user) {
        ArrayList <Camp> registeredCamps = getCamps(user.getFaculty());
        if (registeredCamps.size() <= 0) {
            System.out.println("No Camps Registered");
            return;
        }
        printCamps(registeredCamps);
        System.out.printf("Camp: "); int index = scan.nextInt(); scan.nextLine();
        registeredCamps.get(index - 1).removeAttendee(user);
    }
}
