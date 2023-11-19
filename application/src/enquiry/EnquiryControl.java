package enquiry;

import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;
import camp.CampSelect;
import control.IControl;
import user.Role;
import user.User;
import view.CAMS;

/** Represents a control call that manages a list of enquiries */
public class EnquiryControl implements IControl, IEnquiry {
    /** List of all the available enquiries */
    private static ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();
    public static EnquiryControl instance = new EnquiryControl();

    /** Initialises the enquiry array with data from a CSV file */
    public static void start() {
        enquiries.addAll(EnquiryParse.parse(".\\application\\data\\enquiries.csv"));
    }

     /** Saves the enquiry array to the CSV file */
    public static void close() {
        EnquiryParse.write(".\\application\\data\\enquiries.csv", enquiries);
    }

    /*
     * Adds a new enquiry into the list of enquiries
     * Only available for Students
     * @param user This is to check the user
    */
    public void add() {
        ArrayList <Camp> camps = CampControl.campControl.getByGroupNotCommittee(CAMS.currentUser);
        Camp camp = CampSelect.select(camps, CAMS.currentUser.getUserID());
        if (camp == null) return;
        Enquiry enquiry = EnquiryBuild.build(camp);
        enquiries.add(enquiry);
    }

    /* Allow Students to edit their enquiry
     * Only applicable when the enquiry is still processing
     * @param user This is the user (student) that edits the enquiry
    */
    public void edit() {
        ArrayList <Enquiry> studentEnquiries = getByStudent(CAMS.currentUser);
        Enquiry enquiry = EnquirySelect.select(studentEnquiries);
        if (enquiry == null || CAMS.currentUser.getUserID() != enquiry.getUser()) return;
        EnquiryEdit.edit(enquiry);
    }

    /*
     * Allow only the student to delete their enquiry
     * @param user This is the user (student) that wants to delete the enquiry
    */
    public void delete() {
        ArrayList <Enquiry> studentEnquiries = getByStudent(CAMS.currentUser);
        Enquiry enquiry = EnquirySelect.select(studentEnquiries);
        if (enquiry == null || CAMS.currentUser.getUserID() != enquiry.getUser()) return;
        enquiries.remove(enquiry);
    }

    /*
     * Only allow Committee Member or Staff to reply to the enquiry
     * Adds a point if the user is a Committee Member
     * @param user This is the user (Committee Member) that wants to reply to the enquiry
    */
    public void reply() {
        User user = CAMS.currentUser;
        ArrayList <Camp> camps = new ArrayList <Camp> ();
        if (user.getRole() == Role.STUDENT) camps = CampControl.campControl.getByCommittee(user);
        if (user.getRole() == Role.STAFF) camps = CampControl.campControl.getByStaff(user);
        Camp camp = CampSelect.select(camps, user.getUserID());
        if (camp == null) return;
        ArrayList <Enquiry> enquiries = getByCamp(camp);
        Enquiry enquiry = EnquirySelect.select(enquiries);
        if (!camp.enrolledCommittee(user.getUserID()) && !camp.enrolledStaff(user.getUserID())) return;
        EnquiryReply.reply(user.getUserID(), enquiry);
    }

    /* 
     * Get the list of enquiry for the camp's committee member and staff
     * @param camp This is the list of camp that the user is in charge of
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
     * @param student This is the user that has access to their own enquiry
     * @return studentEnquiries This is the enquiries that the student made
    */
    public ArrayList <Enquiry> getByStudent(User student) {
        ArrayList<Enquiry> studentEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getUser().compareTo(student.getUserID()) == 0) studentEnquiries.add(enquiry);
        }
        return studentEnquiries;
    }
}
