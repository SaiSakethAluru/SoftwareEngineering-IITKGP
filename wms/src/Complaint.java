
import java.util.ArrayList;
import java.util.Collections;


public class Complaint {
	
    public boolean processed;
    public String complaintDescription;
    public String location;
    public String typeOfWork;
    public String toolsRequired;     
    //public int priority;
    public int complaintId;
    public Worker assignedWorker = null;
    private User user = null;
    private String message;

    public Complaint(String complaintDescription,String location,String typeOfWork,String toolsRequired,User user){
        this.complaintDescription = complaintDescription;
        this.location = location;
        this.typeOfWork = typeOfWork;
        this.toolsRequired = toolsRequired;
        this.user = user;
        this.processed = false;
    }


    public void assignWorker(){
        ArrayList<Worker> workersByType = WorkerDatabase.getWorkerDataByType(this.typeOfWork);
        if(workersByType.isEmpty()){
            return;
        }
        for(int i=0;i<workersByType.size();i++){
            workersByType.get(i).setPendingComplaints();
        }
        Collections.sort(workersByType);
        for(int i=0;i<workersByType.size();i++){
            if(this.location.equalsIgnoreCase(workersByType.get(i).location)){
                this.assignedWorker = workersByType.get(i);
                processed = true;
                break;
            }
        }
        if(!processed){
                this.assignedWorker = workersByType.get(0);
                processed = true;
        }
        if(processed){
            ComplaintDatabase.updateAssignedWorker(this.assignedWorker.getLoginId(), this.complaintId);
        }
    }

    public User getUserDetails(){
        return this.user;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
}
