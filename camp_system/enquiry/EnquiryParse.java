package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.csv_parser.CSVParse;

public class EnquiryParse {
    public static ArrayList <Enquiry> parse(String file) {
        ArrayList <Enquiry> results = new ArrayList <Enquiry> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = EnquiryBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    public static void write(String file, ArrayList <Enquiry> enquiries) {
        ArrayList <String> data = new ArrayList <String> ();
        for (Enquiry enquiry : enquiries) {
            data.add(
                enquiry.getStatus() + "," +
                enquiry.getStudent() + "," +
                enquiry.getCamp() + "," +
                enquiry.getQuestion() + "," +
                enquiry.getReply() + "," +
                enquiry.getRepliedBy()
            );
        }
        try {
            CSVParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
