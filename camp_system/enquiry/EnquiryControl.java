package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampSelect;
import camp_system.user.User;

public class EnquiryControl {
    private ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();

    private EnquiryBuild enquiryBuild = new EnquiryBuild();
    private EnquirySelect enquirySelect = new EnquirySelect();
    private EnquiryEdit enquiryEdit = new EnquiryEdit();
    private EnquiryReply enquiryReply = new EnquiryReply();
    private CampSelect campSelect = new CampSelect();
    private EnquiryParse enquiryParse = new EnquiryParse();
    
    /** Creates a new CampControl object with a default empty list */
    public EnquiryControl() {
        enquiries.addAll(enquiryParse.parse("camp_system\\data\\enquiries.csv"));
    }

    public EnquiryControl(ArrayList <Enquiry> enquiries){
        this.enquiries = enquiries;
    }

    public void close() {
        enquiryParse.write("camp_system\\data\\enquiries.csv", enquiries);
    }

    /*
     * Adds a new enquiry into the list of enquiries
     * Only available for Students
    */
    public void addEnquiry(User user, ArrayList <Camp> camps) {
        Camp camp = campSelect.select(camps);
        if (camp == null) return;
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
        if (user.getCommitteeOf().getId() != enquiry.getCamp()) return;

        enquiryReply.reply(enquiry);
        user.addPoint();
    }

    /* Allow Students to edit their enquiry
     * Only applicable when the enquiry is still processing
    */
    public void editEnquiry(User user) {
        ArrayList <Enquiry> studentEnquiries = getStudentEnquiries(user);
        Enquiry enquiry = enquirySelect.select(studentEnquiries);
        if (enquiry == null || user.getUserID() != enquiry.getStudent()) return;
        enquiryEdit.edit(enquiry);
    }

    /*
     * Allow only the student to delete their enquiry
    */
    public void deleteEnquiry(User user) {
        ArrayList <Enquiry> studentEnquiries = getStudentEnquiries(user);
        Enquiry enquiry = enquirySelect.select(studentEnquiries);
        if (enquiry == null || user.getUserID() != enquiry.getStudent()) return;
        enquiries.remove(enquiry);
    }

    /* 
     * Get the list of enquiry for the camp's committee member and staff
    */
    public ArrayList<Enquiry> getCampEnquiries(Camp camp) {
        ArrayList<Enquiry> campEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp() == camp.getId()) campEnquiries.add(enquiry);
        }
        return campEnquiries;
    }

    /* 
     * Allow students to see their own enquiry
    */
    public ArrayList <Enquiry> getStudentEnquiries(User student) {
        ArrayList<Enquiry> studentEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getStudent() == student.getUserID()) studentEnquiries.add(enquiry);
        }
        return studentEnquiries;
    }
}
