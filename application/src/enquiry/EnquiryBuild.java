package enquiry;

import java.util.ArrayList;

import camp.Camp;
import message.Status;
import scanner.Scan;
import view.CAMS;

/** Builds a new enquiry object */
public class EnquiryBuild {
    /**
     * Obtain user input and creates a new enquiry object
     * @param user This is the user creating the enquiry
     * @param camp This is the camp that the user wants to create an enquiry in
     * @return Enquiry This is the enquiry to be added to the arraylist of enquiries
     */
    public static Enquiry build(Camp camp){
        System.out.printf("Enquiry: "); String question = Scan.scan.nextLine();        
        return new Enquiry(CAMS.currentUser.getUserID(), camp.getId(), question);
    }

    /**
     * Parses an array of strings and creates a new camp object
     * @param data Array of strings of enquiry details
     * @return Enquiry
     */
    public static Enquiry build(String[] data) {
        if (data.length < 6) return null;
        Status status = Status.fromString(data[0]);
        String student = data[1];
        long camp = Long.valueOf(data[2]);
        String question = data[3];
        String reply = data[4];
        String repliedBy = data[5];
        return new Enquiry(status, student, camp, question, reply, repliedBy);
    }

    /**
     * Parses a 2D array of strings and creates a new list of enquiry objects
     * @param data 2D array of strings, where each row contains the details of 1 enquiry
     * @return enquiries arraylist
     */
    public static ArrayList <Enquiry> buildMany(ArrayList <String[]> data) {
        ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
        for (String[] entry : data) {
            Enquiry enquiry = build(entry);
            if (enquiry == null) continue;
            enquiries.add(enquiry);
        }
        return enquiries;
    }
}
