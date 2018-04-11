
import java.util.ArrayList;


public class Schedule {
    private ArrayList<Complaint> pendingComplaints = new ArrayList<>();
    private final Worker worker;
    public Schedule(Worker worker){
        this.worker = worker;
        this.pendingComplaints = ComplaintDatabase.getComplaintDataByWorkerId(worker.getLoginId());
    }
    public ArrayList<Complaint> getPendingComplaints(){
        return this.pendingComplaints;
    }
    
    public Worker getWorker(){
        return this.worker;
    }
}
