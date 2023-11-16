package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.scanner.Scan;

public class EnquirySelect {
    public static Enquiry select(ArrayList <Enquiry> enquiries) {
        EnquiryDisplay.printEnquiries(enquiries);
        if (enquiries.size() == 0) return null;
        System.out.printf("Enquiry: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        return enquiries.get(index - 1);
    }
}
