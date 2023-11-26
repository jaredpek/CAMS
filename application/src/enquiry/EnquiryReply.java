package enquiry;

import input.Scan;
import message.Status;

/** 
 * Represents a class that replies an enquiry
 * @author Tan Yoong Ken
 */
public class EnquiryReply {
    /** 
     * Obtain user input and select a enquiry
     * @param user The user selecting the enquiry
     * @param enquiry The enquiry chosen by the user
     */
    public void reply(String user, Enquiry enquiry){
        if (enquiry.getUser().compareTo(user) == 0) {
            System.out.println("Cannot reply to your own enquiry."); return;
        }
        System.out.printf("Reply: "); String reply = Scan.scan.nextLine();
        if (reply.isEmpty()) { return; }
        enquiry.setReply(reply);
        enquiry.setStatus(Status.REPLIED);
        enquiry.setRepliedBy(user);
    }
    
}
