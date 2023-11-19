package camp_system.enquiry;

import camp_system.message.Status;

/** Represent a camp that is available to students */
public class Enquiry {
    /** The status of the enquiry */
    private Status status;

    /** The user (Student) who made the enquiry */
    private String student;

    /** The camp that the enquiry is made for */
    private long camp;

    /** The questions and reply for the enquiry */
    private String question, reply;

    /** The person who replied the enquiry */
    private String repliedBy;

    /** 
     * Creates a new Enquiry object with the relevant information
     * @param student This is the user who created the enquiry
     * @param camp This is the camp that the enquiry is made for
     * @param question This is the question about the camp
     */
    public Enquiry(String student, long camp, String question) {
        this.status = Status.PROCESSING; //default value
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = "No Reply"; //default no replies
        this.repliedBy = "-"; //default
    }

    /** 
     * Creates a new Enquiry object with the relevant information
     * @param status This is the status of the enquiry
     * @param student This is the user who created the enquiry
     * @param camp This is the camp that the enquiry is made for
     * @param question This is the question about the camp
     * @param reply This is the reply for the enquiry
     * @param repliedBy This is the name of the person who replied the enquiry
     */
    public Enquiry(Status status, String student, long camp, String question, String reply, String repliedBy) {
        this.status = status;
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = reply;
        this.repliedBy = repliedBy;
    }

    /** Print the enquiry */
    public void printEnquiry() {
        System.out.println("Enquiry Status: " + this.status);
        System.out.println("Student Name : " + this.student);
        System.out.println("Camp Name : " + this.camp);
        System.out.println("Question: " + this.question);
        System.out.println("Reply: " + this.reply);
        System.out.println("Replied By : " + this.repliedBy);
    }

    /**
     * @return The status of the enquiry 
     */
    public Status getStatus() { return this.status; }
    /** 
     * @param status Set the status of the enquiry
     */
    protected void setStatus(Status status) { this.status = status; }

    /**
     * @return The camp of the enquiry 
     */
    public long getCamp() { return this.camp; }
    /** 
     * @param status Set the camp of the enquiry
     */
    protected void setCamp(long camp) { this.camp = camp; }

    /**
     * @return The student who made the enquiry 
     */
    public String getStudent() { return this.student; }
    /** 
     * @param student Set the student of the enquiry
     */
    protected void setStudent(String student) { this.student = student; }

    /**
     * @return The question of the enquiry 
     */
    public String getQuestion() { return this.question; }
    /** 
     * @param question Set the question of the enquiry
     */
    protected void setQuestion(String question) { this.question = question; }

    /**
     * @return The reply of the enquiry 
     */
    public String getReply() { return this.reply; }
    /** 
     * @param reply Set the reply of the enquiry
     */
    protected void setReply(String reply) { this.reply = reply; }

    /**
     * @return The person who replied the enquiry
     */
    public String getRepliedBy() { return repliedBy; }
    /** 
     * @param reply Set person who replied the enquiry
     */
    protected void setRepliedBy(String repliedBy) { this.repliedBy = repliedBy; }
}
