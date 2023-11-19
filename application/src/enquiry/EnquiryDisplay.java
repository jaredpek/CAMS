package enquiry;

import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;

/** Represent a display class that is responsible for printing the enquiries */
public class EnquiryDisplay {
    public static void header() {
        System.out.println("Enquiries");
        for (int i = 0; i < 180; i ++) System.out.printf("-"); System.out.println();
        System.out.printf("%-2s |", "ID");
        System.out.printf(" %-10s |", "Status");
        System.out.printf(" %-15s |", "Camp");
        System.out.printf(" %-10s |", "User");
        System.out.printf(" %-50s |", "Question");
        System.out.printf(" %-10s |", "Replied By");
        System.out.printf(" %-50s\n", "Reply");
    }
    public static void enquiry(Enquiry enquiry) {
        Camp camp = CampControl.campControl.getCamp(enquiry.getCamp());
        if (camp == null) return;
        System.out.printf(" %-10s |", enquiry.getStatus());
        System.out.printf(" %-15s |", camp.getName());
        System.out.printf(" %-10s |", enquiry.getUser());
        System.out.printf(" %-50s |", enquiry.getMessage());
        System.out.printf(" %-10s |", enquiry.getRepliedBy());
        System.out.printf(" %-50s\n", enquiry.getReply());
    }
    /** 
     * Prints the provided enquiry objects in the standadized format
     * @param enquiries THis is the list of enquiries to print
     */
    public static void enquiries(ArrayList <Enquiry> enquiries) {
        if (enquiries.size() <= 0) {
            System.out.println("No Enquiries Found");
            return;
        }
        header();
        for (int i = 0; i < enquiries.size(); i ++) {
            System.out.printf("%-2d |", i + 1);
            enquiry(enquiries.get(i));
            System.out.println();
        }
    }
}
