package camp_system.enquiry;

import java.util.ArrayList;

public class EnquiryDisplay {
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
