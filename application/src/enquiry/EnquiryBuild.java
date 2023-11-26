package enquiry;

import java.util.ArrayList;

import camp.Camp;
import interfaces.IBuild;
import message.Status;
import scan.Scan;
import user.User;

/** 
 * Builds a new enquiry object
 * @author Tan Yoong Ken
 */
public class EnquiryBuild implements IBuild {
    /**
     * Obtain user input and creates a new enquiry object
     * @param camp This is the camp that the user wants to create an enquiry in
     * @param user This is the user building the enquiry
     * @return Enquiry This is the enquiry to be added to the arraylist of enquiries
     */
    public Enquiry build(Camp camp, User user){
        System.out.printf("Enquiry: "); String question = Scan.scan.nextLine();        
        return new Enquiry(user.getUserID(), camp.getId(), question);
    }

    /**
     * Parses an array of strings and creates a new camp object
     * @param data Array of strings of enquiry details
     * @return Enquiry
     */
    public Enquiry build(String[] data) {
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
    public ArrayList <Enquiry> buildMany(ArrayList <String[]> data) {
        ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
        for (String[] entry : data) {
            Enquiry enquiry = build(entry);
            if (enquiry == null) continue;
            enquiries.add(enquiry);
        }
        return enquiries;
    }
}
