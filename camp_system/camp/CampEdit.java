package camp_system.camp;

import java.text.ParseException;

import camp_system.date_parser.DateParse;
import camp_system.scanner.Scan;
import camp_system.user.Faculty;

public class CampEdit {
    public static void menu() {
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

    public static void edit(Camp camp) throws ParseException {
        if (camp == null) return;
        menu();
        int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1:
                System.out.printf("Enter New Visibility: "); Boolean active = Scan.scan.nextBoolean();
                camp.setActive(active); break;
            case 2:
                System.out.printf("Enter New Name: "); String name = Scan.scan.nextLine();
                camp.setName(name); break;
            case 3:
                System.out.printf("Enter New Group: "); String group = Scan.scan.nextLine();
                camp.setGroup(Faculty.fromString(group)); break;
            case 4:
                System.out.printf("Enter New Location: "); String location = Scan.scan.nextLine();
                camp.setLocation(location); break;
            case 5:
                System.out.printf("Enter New Description: "); String description = Scan.scan.nextLine();
                camp.setDescription(description); break;
            case 6:
                System.out.printf("Enter New Start Date: "); String startDate = Scan.scan.nextLine();
                camp.setStartDate(DateParse.date(startDate)); break;
            case 7:
                System.out.printf("Enter New End Date: "); String endDate = Scan.scan.nextLine();
                camp.setEndDate(DateParse.date(endDate)); break;
            case 8:
                System.out.printf("Enter New Date to Register By: "); String registerBy = Scan.scan.nextLine();
                camp.setRegisterBy(DateParse.date(registerBy)); break;
            case 9:
                System.out.printf("Enter New Total Slots: "); int totalSlots = Scan.scan.nextInt(); Scan.scan.nextLine();
                camp.setTotalSlots(totalSlots); break;
            case 10:
                System.out.printf("Enter New Committee Slots: "); int committeeSlots = Scan.scan.nextInt(); Scan.scan.nextLine();
                camp.setCommitteeSlots(committeeSlots); break;
            default:
                System.out.println("Invalid Option"); break;
        }
    }
}
