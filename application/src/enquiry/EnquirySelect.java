package enquiry;

import java.util.ArrayList;

import scan.Scan;

/** Represents a class that selects a list of enquiries */
public class EnquirySelect {
    /** 
     * Prints out the list of enquiries and allow user to select the specific enquiry 
     * @param enquiries The list of enquiries to select from
     * @return Enquiry
     */
    public Enquiry select(ArrayList <Enquiry> enquiries) {
        (new EnquiryDisplay()).enquiries(enquiries);
        if (enquiries.size() == 0) return null;
        System.out.printf("Option: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        if (1 <= index && index <= enquiries.size()) return enquiries.get(index - 1);
        return null;
    }
}
