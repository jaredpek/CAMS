package camp_system.enquiry;

import camp_system.IBase;

public class EnquiryEdit implements IBase {
    public void edit(Enquiry enquiry){
        System.out.println("Enter your edit"); String edit = scan.nextLine();
        enquiry.setQuestion(edit);
    }
}
