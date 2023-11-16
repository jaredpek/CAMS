package camp_system.camp;

import java.util.ArrayList;

import camp_system.array_parser.ArrayParse;
import camp_system.csv_parser.CSVParse;
import camp_system.date_parser.DateParse;

public class CampParse {
    public static ArrayList <Camp> parse(String file) {
        ArrayList <Camp> results = new ArrayList <Camp> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = CampBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

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
