package enquiry;

import java.util.ArrayList;
import java.util.HashMap;

/** 
 * Represents a class that computes the scores of commitee members based on enquiries
 * @author Tan Yoong Ken
 */
public class EnquiryScore {
    /**
     * Computes the scores of committee members based on enquiries
     * @param enquiries List of enquiries to check
     * @param committee List of committee members
     * @return HashMap of computed scores
     */
    public HashMap <String, Integer> compute(ArrayList <Enquiry> enquiries, ArrayList <String> committee) {
        HashMap <String, Integer> result = new HashMap <String, Integer> ();
        for (String user : committee) {
            result.put(user, 0);
        }
        for (Enquiry enquiry : enquiries) {
            result.computeIfPresent(enquiry.getRepliedBy(), (key, value) -> value + 1);
        }
        return result;
    }
}
