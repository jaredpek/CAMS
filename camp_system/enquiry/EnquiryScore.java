package camp_system.enquiry;

import java.util.ArrayList;
import java.util.HashMap;

public class EnquiryScore {
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
