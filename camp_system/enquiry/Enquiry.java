package camp_system.enquiry;


public class Enquiry {
    private Status status;
    private String student;
    private int camp;
    private String question, reply;

    public Enquiry(String student, int camp, String question) {
        this.status = Status.PROCESSING; //default value
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = ""; //default no replies
    }

    public void printEnquiry() {
        System.out.println("Enquiry Status: " + this.status);
        System.out.println("Student Name : " + this.student);
        System.out.println("Camp Name: "+ this.camp);
        System.out.println("Question: " + this.question);
        System.out.println("Reply: " + this.reply + "\n");
    }

    public Status getStatus() { return this.status; }
    protected void setStatus(Status status) { this.status = status; }

    public int getCamp() { return this.camp; }
    protected void setCamp(int camp) { this.camp = camp; }

    public String getStudent() { return this.student; }
    protected void setStudent(String student) { this.student = student; }

    public String getQuestion() { return this.question; }
    protected void setQuestion(String question) { this.question = question; }

    public String getReply() { return this.reply; }
    protected void setReply(String reply) { this.reply = reply; }
}
