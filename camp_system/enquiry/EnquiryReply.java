package camp_system.enquiry;


public class EnquiryReply {
    public void reply(EnquiryControl enquiries,User user,int index){
        System.out.println("Enter your reply"); String reply = scan.nextLine();
        enquiries.get(index).setReply(reply);
        enquiries.get(index).setStatus(Replied);
        if(user.role == STAFF){
            return;
        }
        else{
            user.addPoint();
            return;
        }
    }
    
}
