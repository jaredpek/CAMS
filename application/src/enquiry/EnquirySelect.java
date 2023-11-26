package enquiry;

import java.util.ArrayList;

import input.integer.IntInput;

/** 
 * Represents a class that selects a list of enquiries
 * @author Tan Yoong Ken
 */
public class EnquirySelect {
    /** 
     * Prints out the list of enquiries and allow user to select the specific enquiry 
     * @param enquiries The list of enquiries to select from
     * @return Enquiry
     */
    public Enquiry select(ArrayList <Enquiry> enquiries) {
        (new EnquiryDisplay()).enquiries(enquiries);
        if (enquiries.size() == 0) return null;
        int index = IntInput.integer("Option");
        if (1 <= index && index <= enquiries.size()) return enquiries.get(index - 1);
        return null;
    }
}
