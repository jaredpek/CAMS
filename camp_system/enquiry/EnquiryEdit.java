package camp_system.enquiry;

import camp_system.scanner.Scan;

public class EnquiryEdit {
    public static void edit(Enquiry enquiry){
        System.out.println("Enter your edit"); String edit = Scan.scan.nextLine();
        enquiry.setQuestion(edit);
    }
}
