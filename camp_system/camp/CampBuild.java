package camp_system.camp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import camp_system.application.IBase;
import camp_system.date_parser.DateParse;
import camp_system.user.Faculty;
import camp_system.user.User;

public class CampBuild implements IBase {
    private DateParse dateParse = new DateParse();

    public Camp build(User user) throws ParseException {
        System.out.printf("Name: "); String name = scan.nextLine();
        System.out.printf("Group: "); Faculty group = Faculty.fromString(scan.nextLine());
        System.out.printf("Location: "); String location = scan.nextLine();
        System.out.printf("Description: "); String description = scan.nextLine();
        System.out.printf("Start Date: "); Date startDate = dateParse.date(scan.nextLine());
        System.out.printf("End Date: "); Date endDate = dateParse.date(scan.nextLine());
        System.out.printf("Register By: "); Date registerBy = dateParse.date(scan.nextLine());
        System.out.printf("Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
        System.out.printf("Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
        long id = (long) (new Date()).getTime();
        return new Camp(id, name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, user.getUserID());
    }
    public Camp template(User user) throws ParseException {
        long id = (long) (new Date()).getTime();
        return new Camp(
            id, 
            "camp1", 
            Faculty.NTU, 
            "NTU", 
            "camp1", 
            dateParse.date("12-12-2023 10:00"), 
            dateParse.date("15-12-2023 15:00"), 
            dateParse.date("10-12-2023 23:59"), 
            100, 
            10, 
            user.getUserID()
        );
    }
    private ArrayList <String> participantParse(String[] data) {
        ArrayList <String> results = new ArrayList <String> ();
        for (String entry : data) {
            if (entry.length() <= 0) continue;
            results.add(entry);
        }
        return results;
    }
    public Camp build(String[] data) throws ParseException {
        if (data.length < 15) return null;
        long id = Long.parseLong(data[0]);
        Boolean active = Boolean.parseBoolean(data[1]);
        String name = data[2];
        Faculty group = Faculty.fromString(data[3]);
        String location = data[4];
        String description = data[5];
        Date startDate = dateParse.date(data[6]);
        Date endDate = dateParse.date(data[7]);
        Date registerBy = dateParse.date(data[8]);
        int totalSlots = Integer.parseInt(data[9]);
        int committeeSlots = Integer.parseInt(data[10]);
        String staffInCharge = data[11];
        ArrayList <String> committeeList = participantParse(data[12].split("-"));
        ArrayList <String> attendeeList = participantParse(data[13].split("-"));
        ArrayList <String> withdrawedList = participantParse(data[14].split("-"));
        return new Camp(
            id, active, name, group, location, description, 
            startDate, endDate, registerBy, totalSlots, committeeSlots, staffInCharge, 
            committeeList, attendeeList, withdrawedList
        );
    }
    public ArrayList <Camp> buildMany(ArrayList <String[]> data) throws ParseException {
        ArrayList <Camp> camps = new ArrayList <Camp> ();
        for (String[] entry : data) {
            Camp camp = build(entry);
            if (camp == null) continue;
            camps.add(camp);
        }
        return camps;
    }
}
