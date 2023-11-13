package camp_system.enquiry;


public class EnquiryEdit {
    public void edit(EnquiryControl enquiries,int index){
        System.out.println("Enter your edit"); String edit = scan.nextLine();
        enquiries.get(index).setQuestion(edit);
    }
    
}
