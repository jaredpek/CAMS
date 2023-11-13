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

    /*
     * Adds a new enquiry into the list of enquiries
     * Only available for Students
    */
    public void addEnquiry(EnquiryControl enquiries) //the Input should be done in the main program
    {
        enquiries.add(EnquiryBuild.build(user));
    }

    /*
     * Only allow Committee Member or Staff to reply to the enquiry
     * Adds a point if the user is a Committee Member
    */
    public void replyEnquiry(EnquiryControl enquiries,User user)
    {
        System.out.println("Please select the index of the enquiry you would like to reply"); int index = scan.nextInt();
        EnquiryReply.reply(enquiries,user,index);
    }

    /* Allow Students to edit their enquiry
     * Only applicable when the enquiry is still processing
    */
    public void editEnquiry(EnquiryControl enquiries)
    {
        System.out.println("Please select the index of the enquiry you would like to edit"); int index = scan.nextInt();
        EnquiryEdit.edit(enquiries,index);
    }

    /*
     * Allow only the student to delete their enquiry
    */
    public void deleteEnquiry(EnquiryControl global,EnquiryControl enquiries)
    {
        System.out.println("Please select the index of the enquiry you would like to delete"); int index = scan.nextInt();
        EnquiryDelete.delete(global,enquiries,index);
    }

    /*
     * return the enquiry
    */
    public Enquiry getEnquiry(int index)
    {
        return enquiries.get(index);
    }

    /* 
     * Get the list of enquiry for the camp's committee member and staff
    */
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

    /* 
     * Allow students to see their own enquiry
    */
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
