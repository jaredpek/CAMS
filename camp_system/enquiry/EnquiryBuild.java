package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.scanner.Scan;
import camp_system.user.User;


public class EnquiryBuild {
    public static Enquiry build(User user, Camp camp){
        System.out.printf("Enquiry: "); String question = Scan.scan.nextLine();        
        return new Enquiry(user.getUserID(), camp.getId(), question);
    }
    public static Enquiry build(String[] data) {
        if (data.length < 6) return null;
        Status status = Status.fromString(data[0]);
        String student = data[1];
        long camp = Long.valueOf(data[2]);
        String question = data[3];
        String reply = data[4];
        String repliedBy = data[5];
        return new Enquiry(status, student, camp, question, reply, repliedBy);
    }
    public static ArrayList <Enquiry> buildMany(ArrayList <String[]> data) {
        ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
        for (String[] entry : data) {
            Enquiry enquiry = build(entry);
            if (enquiry == null) continue;
            enquiries.add(enquiry);
        }
        return enquiries;
    }
}
