package camp_system.enquiry;

import camp_system.IBase;
import camp_system.camp.Camp;
import camp_system.user.User;


public class EnquiryBuild implements IBase {
    public Enquiry build(User user, Camp camp){
        System.out.printf("Enquiry: "); String question = scan.nextLine();        
        return new Enquiry(user, camp, question);
    }
}
