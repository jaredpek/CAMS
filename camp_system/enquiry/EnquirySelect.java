package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.application.IBase;

public class EnquirySelect implements IBase {
    public EnquiryDisplay enquiryDisplay = new EnquiryDisplay();

    public Enquiry select(ArrayList <Enquiry> enquiries) {
        enquiryDisplay.printEnquiries(enquiries);
        System.out.printf("Enquiry: "); int index = scan.nextInt(); scan.nextLine();
        return enquiries.get(index - 1);
    }
}
