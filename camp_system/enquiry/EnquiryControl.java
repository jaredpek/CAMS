package camp_system.enquiry;

import java.util.ArrayList;

import camp_system.application.IControl;
import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampSelect;
import camp_system.user.Role;
import camp_system.user.User;

public class EnquiryControl implements IControl {
    private static ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
    private CampControl campControl = new CampControl();

    public static void start() {
        enquiries.addAll(EnquiryParse.parse("camp_system\\data\\enquiries.csv"));
    }

    public static void close() {
        EnquiryParse.write("camp_system\\data\\enquiries.csv", enquiries);
    }

    /*
     * Adds a new enquiry into the list of enquiries
     * Only available for Students
    */
    public void add(User user) {
        ArrayList <Camp> camps = campControl.getByGroup(user.getFaculty());
        Camp camp = CampSelect.select(camps);
        if (camp == null) return;
        Enquiry enquiry = EnquiryBuild.build(user, camp);
        enquiries.add(enquiry);
    }

    /*
     * Only allow Committee Member or Staff to reply to the enquiry
     * Adds a point if the user is a Committee Member
    */
    public void reply(User user) {
        ArrayList <Camp> camps = new ArrayList <Camp> ();
        if (user.getRole() == Role.STUDENT) camps = campControl.getByCommittee(user);
        if (user.getRole() == Role.STAFF) camps = campControl.getByStaff(user);
        Camp camp = CampSelect.select(camps);
        if (camp == null) return;
        ArrayList <Enquiry> enquiries = getByCamp(camp);
        Enquiry enquiry = EnquirySelect.select(enquiries);
        if (!camp.enrolledCommittee(user.getUserID()) && !camp.enrolledStaff(user.getUserID())) return;
        EnquiryReply.reply(user.getUserID(), enquiry);
    }

    /* Allow Students to edit their enquiry
     * Only applicable when the enquiry is still processing
    */
    public void edit(User user) {
        ArrayList <Enquiry> studentEnquiries = getByStudent(user);
        Enquiry enquiry = EnquirySelect.select(studentEnquiries);
        if (enquiry == null || user.getUserID() != enquiry.getStudent()) return;
        EnquiryEdit.edit(enquiry);
    }

    /*
     * Allow only the student to delete their enquiry
    */
    public void delete(User user) {
        ArrayList <Enquiry> studentEnquiries = getByStudent(user);
        Enquiry enquiry = EnquirySelect.select(studentEnquiries);
        if (enquiry == null || user.getUserID() != enquiry.getStudent()) return;
        enquiries.remove(enquiry);
    }

    /* 
     * Get the list of enquiry for the camp's committee member and staff
    */
    public ArrayList<Enquiry> getByCamp(Camp camp) {
        ArrayList<Enquiry> campEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp() == camp.getId()) campEnquiries.add(enquiry);
        }
        return campEnquiries;
    }

    /* 
     * Allow students to see their own enquiry
    */
    public ArrayList <Enquiry> getByStudent(User student) {
        ArrayList<Enquiry> studentEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getStudent() == student.getUserID()) studentEnquiries.add(enquiry);
        }
        return studentEnquiries;
    }
}
