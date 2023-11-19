package camp_system.enquiry;

import java.util.ArrayList;

/** Represent a display class that is responsible for printing the enquiries */
public class EnquiryDisplay {
    /** 
     * Prints the provided enquiry objects in the standadized format
     * @param enquiries THis is the list of enquiries to print
     */
    public static void printEnquiries(ArrayList <Enquiry> enquiries) {
        if (enquiries.size() <= 0) {
            System.out.println("No Enquiries Found");
            return;
        }
        for (int i = 0; i < enquiries.size(); i ++) {
            System.out.printf("%d -> ", i + 1);
            enquiries.get(i).printEnquiry();
            System.out.println();
        }
    }
}
