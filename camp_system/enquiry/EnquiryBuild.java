package camp_system.enquiry;

import java.util.*;

import camp_system.enquiry.Enquiry;

public class EnquiryBuild {
    public Enquiry build(User user){
        Scanner scan = new Scanner(System.in);
        
        int indexCamp =0;
        Camp c1 = new Camp();
        System.out.println("Camp name: "); String campName;
        while(camp.get(indexCamp).campName != campName) {indexCamp++;}
        c1 = camp.get(indexCamp);
        System.out.println("Question: "); String question = scan.nextLine();
        
        return new Enquiry(user, c1, question);
    }
}
