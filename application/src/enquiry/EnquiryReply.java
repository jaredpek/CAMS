package enquiry;

import message.Status;
import scan.Scan;

/** Represents a class that replies an enquiry */
public class EnquiryReply {
    /** 
     * Obtain user input and select a enquiry
     * @param user The user selecting the enquiry
     * @param enquiry The enquiry chosen by the user
     */
    public void reply(String user, Enquiry enquiry){
        System.out.printf("Reply: "); String reply = Scan.scan.nextLine();
        if (reply.isEmpty()) { return; }
        enquiry.setReply(reply);
        enquiry.setStatus(Status.REPLIED);
        enquiry.setRepliedBy(user);
    }
    
}
