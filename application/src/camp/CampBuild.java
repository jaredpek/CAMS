package camp;

import java.util.ArrayList;
import java.util.Date;

import array_parser.ArrayParse;
import input.Scan;
import input.date.DateInput;
import input.date.DateParse;
import input.integer.IntInput;
import interfaces.IBuild;
import user.Faculty;
import user.User;

/** 
 * Builds a new camp object
 * @author Jared Pek
 */
public class CampBuild implements IBuild {
    /** Obtains user input and creates a new camp object
     * @param user This is the user building the camp
     * @return Camp
     */
    public Camp build(User user) {
        System.out.printf("Name: "); String name = Scan.scan.nextLine();
        System.out.printf("Group: "); Faculty group = Faculty.fromString(Scan.scan.nextLine());
        System.out.printf("Location: "); String location = Scan.scan.nextLine();
        System.out.printf("Description: "); String description = Scan.scan.nextLine();
        Date startDate = DateInput.date("Start Date");
        Date endDate = DateInput.date("End Date");
        Date registerBy = DateInput.date("Register By");
        int totalSlots = IntInput.integer("Total Slots");
        int committeeSlots = IntInput.integer("Committee Slots");
        long id = (long) (new Date()).getTime();
        return new Camp(id, name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, user.getUserID());
    }

    /**
     * Creates a template camp object
     * @param user This is the user building the camp
     * @return Camp
     */
    public Camp template(User user) {
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

    /**
     * Parses an array of strings and creates a new camp object
     * @param data Array of strings of camp details
     * @return Camp
     */
    public Camp build(String[] data) {
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

    /**
     * Parses a 2D array of strings and creates a new list of camp objects
     * @param data 2D array of strings, where each row contains the details of 1 camp
     * @return ArrayList
     */
    public ArrayList <Camp> buildMany(ArrayList <String[]> data) {
        ArrayList <Camp> camps = new ArrayList <Camp> ();
        for (String[] entry : data) {
            Camp camp = build(entry);
            if (camp == null) continue;
            camps.add(camp);
        }
        return camps;
    }
}
