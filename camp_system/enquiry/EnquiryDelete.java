package camp_system.enquiry;

public class EnquiryDelete{
    public void delete(EnquiryControl global,EnquiryControl enquiries, int index){
        global.remove(enquiries.get(index));
    }
}

