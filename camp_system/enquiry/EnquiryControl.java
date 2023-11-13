package camp_system.enquiry;

import java.util.*;

import CampSystem.Enquiry;
import CampSystem.Enquiry.enquiryStatus;
import camp_system.user.User;

public class EnquiryControl{

    private ArrayList <Enquiry> enquiries;
    
    Scanner scan = new Scanner(System.in);
    public EnquiryControl() {this.enquiries = new ArrayList <Enquiry> (); }
    public EnquiryControl(ArrayList <Enquiry> enquiries){
        this.enquiries = enquiries;
    }

     public void addEnquiry() //the Input should be done in the main program
    {
        enquiries.add(EnquiryBuild.build(user));
        user.addPoint();
    }

    public void replyEnquiry()
    {
        System.out.println("Please select the index of the enquiry you would like to reply"); int index = scan.nextInt();
        EnquiryEdit.edit(index);
    }

    public void editEnquiry()
    {
        System.out.println("Please select the index of the enquiry you would like to edit"); int index = scan.nextInt();
    
    }
    
    public void deleteEnquiry()
    {
        System.out.println("Please select the index of the enquiry you would like to delete"); int index = scan.nextInt();
        EnquiryDetele.delete(index);
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
