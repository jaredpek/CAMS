package camp_system.camp;

import java.util.ArrayList;

import camp_system.array_parser.ArrayParse;
import camp_system.csv_parser.CSVParse;
import camp_system.date_parser.DateParse;

/** Represents a class that reads and writes camp objects to and from a CSV */
public class CampParse {
    /**
     * Creates a new list of camp objects from a provided CSV file
     * @param file The path to the CSV file to read
     * @return ArrayList of camp objects
     */
    public static ArrayList <Camp> parse(String file) {
        ArrayList <Camp> results = new ArrayList <Camp> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = CampBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    /**
     * Writes a list of camps to a CSV file
     * @param file The path to write the CSV file to
     * @param camps The list of camps to write to the CSV file
     */
    public static void write(String file, ArrayList <Camp> camps) {
        ArrayList <String> data = new ArrayList <String> ();
        for (Camp camp : camps) {
            data.add(
                camp.getId() + "," +
                camp.getActive() + "," +
                camp.getName() + "," +
                camp.getGroup() + "," +
                camp.getLocation() + "," +
                camp.getDescription() + "," +
                DateParse.string(camp.getStartDate()) + "," +
                DateParse.string(camp.getEndDate()) + "," +
                DateParse.string(camp.getRegisterBy()) + "," +
                camp.getTotalSlots() + "," +
                camp.getCommitteeSlots() + "," +
                camp.getStaffInCharge() + "," +
                ArrayParse.toString(camp.getCommitteeList()) + "," + 
                ArrayParse.toString(camp.getAttendeeList()) + "," + 
                ArrayParse.toString(camp.getWithdrawedList())
            );
        }
        try {
            CSVParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
