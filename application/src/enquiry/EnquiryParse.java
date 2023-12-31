package enquiry;

import java.util.ArrayList;

import csv_parser.CSVParse;

/** 
 * Represents a class that reads and writes enquiry objects to and from a CSV
 * @author Tan Yoong Ken
 */
public class EnquiryParse {
    /** 
     * Create a new list of enquiry objects from a provided CSV file
     * @param file The parth to the CSV file to read
     * @return ArrayList of enquiry objects
     */
    public ArrayList <Enquiry> parse(String file) {
        ArrayList <Enquiry> results = new ArrayList <Enquiry> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = (new EnquiryBuild()).buildMany(campData);
        } catch (Exception e) {}
        return results;
    }

    /**
     * Writes a list of camps to a CSV file
     * @param file The path to write the CSV file to
     * @param enquiries The list of enquiries to write to the CSV file
     */
    public void write(String file, ArrayList <Enquiry> enquiries) {
        ArrayList <String> data = new ArrayList <String> ();
        for (Enquiry enquiry : enquiries) {
            data.add(
                enquiry.getStatus() + "," +
                enquiry.getUser() + "," +
                enquiry.getCamp() + "," +
                enquiry.getMessage() + "," +
                enquiry.getReply() + "," +
                enquiry.getRepliedBy()
            );
        }
        try {
            CSVParse.write(file, data);
        } catch (Exception e) {}
        
    }
}
