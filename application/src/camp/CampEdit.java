package camp;

import input.Scan;
import input.date.DateInput;
import input.integer.IntInput;
import user.Faculty;

/** 
 * Represents a class that edits a specified camp
 * @author Jared Pek
 */
public class CampEdit {
    /** This is the attributes of the camp that the user can edit */
    public void menu() {
        System.out.println("Select Attribute to Edit:");
        System.out.println("1 - Visibility");
        System.out.println("2 - Name");
        System.out.println("3 - Group");
        System.out.println("4 - Location");
        System.out.println("5 - Description");
        System.out.println("6 - Start Date");
        System.out.println("7 - End Date");
        System.out.println("8 - Register By");
        System.out.println("9 - Total Slots (Inclusive of Committee Slots)");
        System.out.println("10 - Committee Slots");
    }

    /**
     * Obtain user input and edits the required camp
     * @param camp This is the camp to edit
     */
    public void edit(Camp camp) {
        if (camp == null) return;
        menu();
        int option = IntInput.integer("Option");
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
                camp.setStartDate(DateInput.date("Enter New Start Date")); break;
            case 7:
                camp.setEndDate(DateInput.date("Enter New End Date")); break;
            case 8:
                camp.setRegisterBy(DateInput.date("Enter New Register By")); break;
            case 9:
                camp.setTotalSlots(IntInput.integer("Enter New Total Slots")); break;
            case 10:
                camp.setCommitteeSlots(IntInput.integer("Enter New Committee Slots")); break;
            default: break;
        }
    }
}
