
import java.util.ArrayList;


public class Worker implements Comparable<Worker>{
        public String name;
        public int workerId;
        public String contactNumber;
        public String typeOfWork;
        public String location;
        private final String loginId;
        private final String loginPswrd;
        public int pendingComplaints;

        public Worker(String name,String contactNumber,String location,String typeOfWork,String loginId,String loginPswrd) {
            this.name = name;
            this.contactNumber = contactNumber;
            this.typeOfWork = typeOfWork;
            this.location = location;
            this.loginId = loginId;
            this.loginPswrd = loginPswrd;
//            this.pendingComplaints = ComplaintDatabase.getComplaintDataByWorkerId(this.loginId).size();
        }
        public void setPendingComplaints(){
            ArrayList<Complaint> complaintDataByWorker = ComplaintDatabase.getComplaintDataByWorkerId(this.loginId);
            if(complaintDataByWorker.isEmpty()){
                this.pendingComplaints = 0;
            }
            else{
                this.pendingComplaints = complaintDataByWorker.size();
            }
        }
        public String getLoginId(){
            return this.loginId;
        }

        public String getLoginPassword(){
            return this.loginPswrd;
        }

        public boolean authoriseLogin(String loginId, String loginPassword){
            return this.loginId.equals(loginId)&&this.loginPswrd.equals(loginPassword);
        }

    @Override
    public int compareTo(Worker o) {
        return this.pendingComplaints - o.pendingComplaints;
    }
	
}
