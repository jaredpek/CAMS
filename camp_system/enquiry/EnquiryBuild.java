package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.application.IBase;
import camp_system.camp.Camp;
import camp_system.user.User;


public class EnquiryBuild implements IBase {
    public Enquiry build(User user, Camp camp){
        System.out.printf("Enquiry: "); String question = scan.nextLine();        
        return new Enquiry(user.getUserID(), camp.getId(), question);
    }
    public Enquiry build(String[] data) {
        if (data.length < 5) return null;
        Status status = Status.fromString(data[0]);
        String student = data[1];
        int camp = Integer.valueOf(data[2]);
        String question = data[3];
        String reply = data[4];
        return new Enquiry(status, student, camp, question, reply);
    }
    public ArrayList <Enquiry> buildMany(ArrayList <String[]> data) {
        ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
        for (String[] entry : data) {
            Enquiry enquiry = build(entry);
            if (enquiry == null) continue;
            enquiries.add(enquiry);
        }
        return enquiries;
    }
}
