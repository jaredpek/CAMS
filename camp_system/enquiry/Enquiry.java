package camp_system.enquiry;

import camp_system.camp.Camp;
import camp_system.user.User;

public class Enquiry {
    private Status status;
    private User student;
    private Camp camp;
    private String question, reply;

    public Enquiry(User student,Camp camp,String question) {
        this.status = Status.PROCESSING; //default value
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = ""; //default no replies
    }

    public void printEnquiry() {
        System.out.println("Enquiry Status: " + this.status);
        System.out.println("Student Name : " + this.student.getName());
        System.out.println("Camp Name: "+ this.camp.getName());
        System.out.println("Question: " + this.question);
        System.out.println("Reply: " + this.reply + "\n");
    }

    public Status getStatus() { return this.status; }
    protected void setStatus(Status status) { this.status = status; }

    public Camp getCamp() { return this.camp; }
    protected void setCamp(Camp camp) { this.camp = camp; }

    public User getStudent() { return this.student; }
    protected void setStudent(User student) { this.student = student; }

    public String getQuestion() { return this.question; }
    protected void setQuestion(String question) { this.question = question; }

    public String getReply() { return this.reply; }
    protected void setReply(String reply) { this.reply = reply; }
}
