package camp_system.camp;

import java.util.ArrayList;
import java.util.Date;

import camp_system.array_parser.ArrayParse;
import camp_system.date_parser.DateParse;
import camp_system.scanner.Scan;
import camp_system.user.Faculty;
import camp_system.user.User;

public class CampBuild {
    public static Camp build(User user) {
        System.out.printf("Name: "); String name = Scan.scan.nextLine();
        System.out.printf("Group: "); Faculty group = Faculty.fromString(Scan.scan.nextLine());
        System.out.printf("Location: "); String location = Scan.scan.nextLine();
        System.out.printf("Description: "); String description = Scan.scan.nextLine();
        System.out.printf("Start Date: "); Date startDate = DateParse.date(Scan.scan.nextLine());
        System.out.printf("End Date: "); Date endDate = DateParse.date(Scan.scan.nextLine());
        System.out.printf("Register By: "); Date registerBy = DateParse.date(Scan.scan.nextLine());
        System.out.printf("Total Slots: "); int totalSlots = Scan.scan.nextInt(); Scan.scan.nextLine();
        System.out.printf("Committee Slots: "); int committeeSlots = Scan.scan.nextInt(); Scan.scan.nextLine();
        long id = (long) (new Date()).getTime();
        return new Camp(id, name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, user.getUserID());
    }
    public static Camp template(User user) {
        long id = (long) (new Date()).getTime();
        return new Camp(
            id, 
            "camp1", 
            Faculty.NTU, 
            "NTU", 
            "camp1", 
            DateParse.date("12-12-2023 10:00"), 
            DateParse.date("15-12-2023 15:00"), 
            DateParse.date("10-12-2023 23:59"), 
            100, 
            10, 
            user.getUserID()
        );
    }
    public static Camp build(String[] data) {
        if (data.length < 15) return null;
        long id = Long.parseLong(data[0]);
        Boolean active = Boolean.parseBoolean(data[1]);
        String name = data[2];
        Faculty group = Faculty.fromString(data[3]);
        String location = data[4];
        String description = data[5];
        Date startDate = DateParse.date(data[6]);
        Date endDate = DateParse.date(data[7]);
        Date registerBy = DateParse.date(data[8]);
        int totalSlots = Integer.parseInt(data[9]);
        int committeeSlots = Integer.parseInt(data[10]);
        String staffInCharge = data[11];
        ArrayList <String> committeeList = ArrayParse.fromString(data[12]);
        ArrayList <String> attendeeList = ArrayParse.fromString(data[13]);
        ArrayList <String> withdrawedList = ArrayParse.fromString(data[14]);
        return new Camp(
            id, active, name, group, location, description, 
            startDate, endDate, registerBy, totalSlots, committeeSlots, staffInCharge, 
            committeeList, attendeeList, withdrawedList
        );
    }
    public static ArrayList <Camp> buildMany(ArrayList <String[]> data) {
        ArrayList <Camp> camps = new ArrayList <Camp> ();
        for (String[] entry : data) {
            Camp camp = build(entry);
            if (camp == null) continue;
            camps.add(camp);
        }
        return camps;
    }
}
