package camp_system.enquiry;


public class EnquiryReply {
    public void reply(int index){
        System.out.println("Enter your reply"); String reply = scan.nextLine();
        enquiries.get(index).setReply(reply);
        enquiries.get(index).setStatus(Replied);
    }
    
}
