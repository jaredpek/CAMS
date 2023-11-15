package camp_system.enquiry;


public class Enquiry {
    private Status status;
    private String student;
    private long camp;
    private String question, reply;

    public Enquiry(String student, long camp, String question) {
        this.status = Status.PROCESSING; //default value
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = "No Reply"; //default no replies
    }

    public Enquiry(Status status, String student, long camp, String question, String reply) {
        this.status = status;
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = reply;
    }

    public void printEnquiry() {
        System.out.println("Enquiry Status: " + this.status);
        System.out.println("Student Name : " + this.student);
        System.out.println("Question: " + this.question);
        System.out.println("Reply: " + this.reply + "\n");
    }

    public Status getStatus() { return this.status; }
    protected void setStatus(Status status) { this.status = status; }

    public long getCamp() { return this.camp; }
    protected void setCamp(long camp) { this.camp = camp; }

    public String getStudent() { return this.student; }
    protected void setStudent(String student) { this.student = student; }

    public String getQuestion() { return this.question; }
    protected void setQuestion(String question) { this.question = question; }

    public String getReply() { return this.reply; }
    protected void setReply(String reply) { this.reply = reply; }
}
