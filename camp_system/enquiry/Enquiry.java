package camp_system.enquiry;

public class Enquiry {
    
    public enum enquiryStatus {Processing ,Replied};
    private enquiryStatus status;
    private Student student;
    private Camp camp;
    private String question, reply;
    

    public Enquiry(Student student,Camp camp,String question)
    {
        this.status = enquiryStatus.Processing; //default value
        this.student = student;
        this.camp = camp;
        this.question = question;
        this.reply = ""; //default no replies
    }

    public void printEnquiry(){
        System.out.println("Enquiry Status: " + this.status);
        System.out.println("StudentName : " + this.student.getName());
        System.out.println("Camp Name: "+ this.camp.getName());
        System.out.println("Question: " + this.question);
        System.out.println("Reply: " + this.reply + "\n");
    }

    public void setStatus(enquiryStatus status){
        this.status = status; 
    }

    public Camp getCamp(){
        return this.camp;
    }

    public Student getStudent(){
        return this.student;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getQuestion(){
        return this.question;
    }

    public void setReply(String reply){
        this.reply = reply;
    }

    public String getReply(){
        return this.reply;
    }


}

