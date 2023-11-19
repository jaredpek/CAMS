package camp_system.enquiry;

import camp_system.scanner.Scan;

/** Represents a class that edits the enquiry */
public class EnquiryEdit {
    /**
     * Obtain user input and edits the required enquiry
     * @param enquiry This is the enquiry to edit
     */
     
    public static void edit(Enquiry enquiry){
        System.out.printf("New Enquiry: "); String edit = Scan.scan.nextLine();
        enquiry.setQuestion(edit);
    }
}
