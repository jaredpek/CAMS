package camp_system.enquiry;

import camp_system.scanner.Scan;
import camp_system.message.Status;

/** Represents a class that replies an enquiry */
public class EnquiryReply {
    /** 
     * Obtain user input and select a enquiry
     * @param user The user selecting the enquiry
     * @param enquiry The enquiry chosen by the user
     */
    public static void reply(String user, Enquiry enquiry){
        System.out.printf("Reply: "); String reply = Scan.scan.nextLine();
        enquiry.setReply(reply);
        enquiry.setStatus(Status.REPLIED);
        enquiry.setRepliedBy(user);
    }
    
}
