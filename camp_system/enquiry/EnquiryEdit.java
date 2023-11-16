package camp_system.enquiry;

import camp_system.scanner.Scan;

public class EnquiryEdit {
    public static void edit(Enquiry enquiry){
        System.out.printf("New Enquiry: "); String edit = Scan.scan.nextLine();
        enquiry.setQuestion(edit);
    }
}
