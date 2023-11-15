package camp_system.camp;

import java.text.ParseException;
import java.util.Date;

import camp_system.application.IBase;
import camp_system.user.Faculty;
import camp_system.user.User;

public class CampBuild implements IBase {
    public Camp build(User user, int id) throws ParseException {
        System.out.printf("Name: "); String name = scan.nextLine();
        System.out.printf("Group: "); Faculty group = Faculty.fromString(scan.nextLine());
        System.out.printf("Location: "); String location = scan.nextLine();
        System.out.printf("Description: "); String description = scan.nextLine();
        System.out.printf("Start Date: "); Date startDate = dateParse.date(scan.nextLine());
        System.out.printf("End Date: "); Date endDate = dateParse.date(scan.nextLine());
        System.out.printf("Register By: "); Date registerBy = dateParse.date(scan.nextLine());
        System.out.printf("Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
        System.out.printf("Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
        return new Camp(id, name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, user.getUserID());
    }
    public Camp template(User user, int id) throws ParseException {
        return new Camp(
            id, 
            "camp1", 
            Faculty.NTU, 
            "ntu", 
            "camp1 in ntu!", 
            dateParse.date("12-12-2023 10:00"), 
            dateParse.date("15-12-2023 15:00"), 
            dateParse.date("10-12-2023 23:59"), 
            100, 
            10, 
            user.getUserID()
        );
    }
}
