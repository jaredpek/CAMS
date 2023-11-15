package camp_system.camp;

import java.text.ParseException;

import camp_system.application.IBase;
import camp_system.user.Faculty;

public class CampEdit implements IBase {
    public void menu() {
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

    public void edit(Camp camp) throws ParseException {
        if (camp == null) return;
        menu();
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
}
