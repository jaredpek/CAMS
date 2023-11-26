package enquiry;

import input.Scan;

/** 
 * Represents a class that edits the enquiry
 * @author Tan Yoong Ken
 */
public class EnquiryEdit {
    /**
     * Obtain user input and edits the required enquiry
     * @param enquiry This is the enquiry to edit
     */
    public void edit(Enquiry enquiry){
        System.out.printf("New Enquiry: "); String edit = Scan.scan.nextLine();
        enquiry.setMessage(edit);
    }
}
