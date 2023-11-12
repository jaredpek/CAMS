package camp_system.enquiry;

import java.util.*;

import camp_system.enquiry.Enquiry;

public class EnquiryBuild {
    public Enquiry build(User user){
        Scanner scan = new Scanner(System.in);
        int indexStudent = 0;
        int indexCamp =0;
        User s1 = new User();
        Camp c1 = new Camp();
        System.out.println("Please enter the following details: ");
        System.out.println("Your name: "); String studentName;

        while(user.get(indexStudent).studentName != studentName){indexStudent++;}
        s1 = user.get(indexStudent);

        System.out.println("Camp name: "); String campName;
        while(camp.get(indexCamp).campName != campName) {indexCamp++;}
        c1 = camp.get(indexCamp);
        System.out.println("Question: "); String question = scan.nextLine();
        
        return new Enquiry(s1, c1, question);
    }
}
