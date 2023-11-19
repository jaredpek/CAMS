package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.scanner.Scan;

/** Represents a class that selects a list of enquiries */
public class EnquirySelect {
    /** 
     * Prints out the list of enquiries and allow user to select the specific enquiry 
     * @param enquiries
     * @return Enquiry
     */
    public static Enquiry select(ArrayList <Enquiry> enquiries) {
        EnquiryDisplay.printEnquiries(enquiries);
        if (enquiries.size() == 0) return null;
        System.out.printf("Option: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        return enquiries.get(index - 1);
    }
}
