package camp_system.enquiry;

import camp_system.IBase;

public class EnquiryReply implements IBase {
    public void reply(Enquiry enquiry){
        System.out.printf("Reply: "); String reply = scan.nextLine();
        enquiry.setReply(reply);
        enquiry.setStatus(Status.REPLIED);
    }
    
}
