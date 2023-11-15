package camp_system.camp;

import java.util.ArrayList;

import camp_system.array_parser.ArrayParse;
import camp_system.csv_parser.CSVParse;
import camp_system.date_parser.DateParse;

public class CampParse {
    private CSVParse csvParse = new CSVParse();
    private CampBuild campBuild = new CampBuild();
    private DateParse dateParse = new DateParse();
    private ArrayParse arrayParse = new ArrayParse();

    public ArrayList <Camp> parse(String file) {
        ArrayList <Camp> results = new ArrayList <Camp> ();
        try {
            ArrayList <String[]> campData = csvParse.read(file);
            results = campBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    public void write(String file, ArrayList <Camp> camps) {
        ArrayList <String> data = new ArrayList <String> ();
        for (Camp camp : camps) {
            data.add(
                camp.getId() + "," +
                camp.getActive() + "," +
                camp.getName() + "," +
                camp.getGroup() + "," +
                camp.getLocation() + "," +
                camp.getDescription() + "," +
                dateParse.string(camp.getStartDate()) + "," +
                dateParse.string(camp.getEndDate()) + "," +
                dateParse.string(camp.getRegisterBy()) + "," +
                camp.getTotalSlots() + "," +
                camp.getCommitteeSlots() + "," +
                camp.getCommitteeSlots() + "," +
                arrayParse.toString(camp.getCommitteeList()) + "," + 
                arrayParse.toString(camp.getAttendeeList()) + "," + 
                arrayParse.toString(camp.getWithdrawedList())
            );
        }
        try {
            csvParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
