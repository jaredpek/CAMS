package camp_system.enquiry;

import java.util.*;

import CampSystem.Enquiry;
import CampSystem.Enquiry.enquiryStatus;

public class EnquiryControl{

    private ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
    
    Scanner scan = new Scanner(System.in);
    public EnquiryControl(ArrayList <Enquiry> enquiries){
        this.enquiries = enquiries;
    }

    public void addEnquiry() //the Input should be done in the main program
    {
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
        enquiries.add(new Enquiry(s1, c1, question));
    }

    public void editEnquiry(int index)
    {
            
        System.out.println("Enter your reply"); String reply = scan.nextLine();
        enquiries.get(index).setReply(reply);
    }

    public void deleteEnquiry(int index)
    {
        enquiries.remove(index);
    }

    public Enquiry getEnquiry(int index)
    {
        return enquiries.get(index);
    }
    
    public ArrayList<Enquiry> getEnquiries(Camp camp)
    {
        int indexOfNewArray = 0;
        ArrayList<Enquiry> campEnquiries = new ArrayList<Enquiry>();
        for(int index = 0;index < enquiries.size();index++){
            if(enquiries.get(index).getCamp() == camp)
            {
                campEnquiries.add(enquiries.get(index));
                indexOfNewArray++;
            }
        }
        return campEnquiries;
    }

    public Enquiry[] getEnquiries(Student student)
    {
        int indexOfNewArray = 0;
        ArrayList<Enquiry> studentEnquiries = new ArrayList<Enquiry>();
        for(int index = 0;index < enquiries.size();index++){
            if(enquiries.get(index).getStudent() == student)
            {
                studentEnquiries.add(enquiries.get(index));
                indexOfNewArray++;
            }
        }
        return studentEnquiries;
    }
    
}
