package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.csv_parser.CSVParse;

public class EnquiryParse {
    private CSVParse csvParse = new CSVParse();
    private EnquiryBuild enquiryBuild = new EnquiryBuild();

    public ArrayList <Enquiry> parse(String file) {
        ArrayList <Enquiry> results = new ArrayList <Enquiry> ();
        try {
            ArrayList <String[]> campData = csvParse.read(file);
            results = enquiryBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    public void write(String file, ArrayList <Enquiry> enquiries) {
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
            csvParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
