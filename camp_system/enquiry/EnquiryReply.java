package camp_system.enquiry;

import camp_system.scanner.Scan;

public class EnquiryReply {
    public static void reply(String user, Enquiry enquiry){
        System.out.printf("Reply: "); String reply = Scan.scan.nextLine();
        enquiry.setReply(reply);
        enquiry.setStatus(Status.REPLIED);
        enquiry.setRepliedBy(user);
    }
    
}
