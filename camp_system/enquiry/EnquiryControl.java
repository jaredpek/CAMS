package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampSelect;
import camp_system.user.User;

public class EnquiryControl {
    private ArrayList <Enquiry> enquiries;

    public static EnquiryBuild enquiryBuild = new EnquiryBuild();
    public static EnquirySelect enquirySelect = new EnquirySelect();
    public static EnquiryEdit enquiryEdit = new EnquiryEdit();
    public static EnquiryReply enquiryReply = new EnquiryReply();

    public static CampSelect campSelect = new CampSelect();

    public EnquiryControl() {this.enquiries = new ArrayList <Enquiry> (); }
    public EnquiryControl(ArrayList <Enquiry> enquiries){
        this.enquiries = enquiries;
    }

    /*
     * Adds a new enquiry into the list of enquiries
     * Only available for Students
    */
    public void addEnquiry(User user, ArrayList <Camp> camps) {
        Camp camp = campSelect.select(camps);
        Enquiry enquiry = enquiryBuild.build(user, camp);
        enquiries.add(enquiry);
    }

    /*
     * Only allow Committee Member or Staff to reply to the enquiry
     * Adds a point if the user is a Committee Member
    */
    public void replyEnquiry(User user) {
        ArrayList <Enquiry> committeeEnquiries = getCampEnquiries(user.getCommitteeOf());
        Enquiry enquiry = enquirySelect.select(committeeEnquiries);
        if (user.getCommitteeOf() != enquiry.getCamp()) return;

        enquiryReply.reply(enquiry);
        user.addPoint();
    }

    /* Allow Students to edit their enquiry
     * Only applicable when the enquiry is still processing
    */
    public void editEnquiry(User user) {
        ArrayList <Enquiry> studentEnquiries = getStudentEnquiries(user);
        Enquiry enquiry = enquirySelect.select(studentEnquiries);
        if (user != enquiry.getStudent()) return;
        enquiryEdit.edit(enquiry);
    }

    /*
     * Allow only the student to delete their enquiry
    */
    public void deleteEnquiry(User user) {
        ArrayList <Enquiry> studentEnquiries = getStudentEnquiries(user);
        Enquiry enquiry = enquirySelect.select(studentEnquiries);
        if (user != enquiry.getStudent()) return;
        enquiries.remove(enquiry);
    }

    /* 
     * Get the list of enquiry for the camp's committee member and staff
    */
    public ArrayList<Enquiry> getCampEnquiries(Camp camp) {
        ArrayList<Enquiry> campEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp() == camp) campEnquiries.add(enquiry);
        }
        return campEnquiries;
    }

    /* 
     * Allow students to see their own enquiry
    */
    public ArrayList <Enquiry> getStudentEnquiries(User student) {
        ArrayList<Enquiry> studentEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getStudent() == student) studentEnquiries.add(enquiry);
        }
        return studentEnquiries;
    }
}
