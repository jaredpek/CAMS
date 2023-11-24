package enquiry;

import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;
import camp.CampSelect;
import interfaces.IControl;
import message.Status;
import user.Role;
import user.User;

/** Represents a control call that manages a list of enquiries */
public class EnquiryControl implements IControl, IEnquiry {
    /** List of all the available enquiries */
    private static ArrayList <Enquiry> enquiries = new ArrayList <Enquiry> ();

    /** Static instance of EnquiryControl */
    public static EnquiryControl instance = new EnquiryControl();

    /** Initialises the enquiry array with data from a CSV file */
    public static void start() {
        enquiries.addAll((new EnquiryParse()).parse("application\\data\\enquiries.csv"));
    }

     /** Saves the enquiry array to the CSV file */
    public static void close() {
        (new EnquiryParse()).write("application\\data\\enquiries.csv", enquiries);
    }

	/**
	 * Checks whether a enquiry has already been reviewed
	 * @param enquiry The enquiry to check
	 * @return Boolean, true if has been reviewed
	 */
	private Boolean isReviewed(Enquiry enquiry) {
		if (enquiry.getStatus() == Status.PROCESSING) return false;
		System.out.println("Enquiry has already been " + enquiry.getStatus().toString());
		return true;
	}

    /**
     * Adds a new enquiry into the list of enquiries
     * Only available for Students
     * @param user The user adding the enquiry
    */
    public void add(User user) {
        ArrayList <Camp> camps = CampControl.instance.getByGroupNotCommittee(user);
        Camp camp = (new CampSelect()).select(camps, user.getUserID());
        if (camp == null) return;
        Enquiry enquiry = (new EnquiryBuild()).build(camp, user);
        enquiries.add(enquiry);
    }

    /**
     * Allow Students to edit their enquiry
     * Only applicable when the enquiry is still processing
     * @param user The user editting the enquiry
    */
    public void edit(User user) {
        String currentUser = user.getUserID();
        ArrayList <Enquiry> studentEnquiries = getByStudent(user);
        Enquiry enquiry = (new EnquirySelect()).select(studentEnquiries);
        if (enquiry == null || isReviewed(enquiry) || enquiry.getUser().compareTo(currentUser) != 0) return;
        (new EnquiryEdit()).edit(enquiry);
    }

    /** 
     * Allow only the student to delete their enquiry 
     * @param user The user deleting the enquiry
     */
    public void delete(User user) {
        String currentUser = user.getUserID();
        ArrayList <Enquiry> studentEnquiries = getByStudent(user);
        Enquiry enquiry = (new EnquirySelect()).select(studentEnquiries);
        if (enquiry == null || isReviewed(enquiry) || enquiry.getUser().compareTo(currentUser) != 0) return;
        enquiries.remove(enquiry);
    }

    /** 
     * Only allow Committee Member or Staff to reply to the enquiry
     * @param user The user replying to the enquiry
     */
    public void reply(User user) {
        ArrayList <Camp> camps = new ArrayList <Camp> ();
        if (user.getRole() == Role.STUDENT) camps = CampControl.instance.getByCommittee(user);
        if (user.getRole() == Role.STAFF) camps = CampControl.instance.getByStaff(user);
        Camp camp = (new CampSelect()).select(camps, user.getUserID());
        if (camp == null) return;
        ArrayList <Enquiry> enquiries = getByCamp(camp);
        Enquiry enquiry = (new EnquirySelect()).select(enquiries);
        if (enquiry == null || isReviewed(enquiry)) return;
        if (!camp.enrolledCommittee(user.getUserID()) && !camp.enrolledStaff(user.getUserID())) return;
        (new EnquiryReply()).reply(user.getUserID(), enquiry);
    }

    /**
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

    /** 
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
