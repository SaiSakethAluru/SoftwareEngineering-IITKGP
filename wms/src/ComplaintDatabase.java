import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ComplaintDatabase extends Database{
    private static final int MAXCOMPLAINTS = 200;
    static final String DB_URL = "jdbc:derby://localhost:1527/ComplaintDatabase";
    static final String DB_DRV = "apache_derby_net";
    static final String DB_USER = "complaintList";
    static final String DB_PASSWD = "complaintList";
    
    static Connection CONNECTION = null;
    static Statement STATEMENT = null;
    static ResultSet RESULTSET = null;
    

    public static void assignAll(Worker worker) {
        try {
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            STATEMENT.executeUpdate("UPDATE APP.COMPLAINTS SET WORKERID = '"+worker.getLoginId()+"' WHERE CAST(WORKERID AS CHAR(128)) = CAST('null' AS CHAR(128)) AND CAST(TYPEOFWORK AS CHAR(128)) = CAST('"+worker.typeOfWork+"' AS CHAR(128))");
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ComplaintDatabase(){
        try {
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT COUNT(*) FROM APP.COMPLAINTS");
            while(RESULTSET.next()){
                ComplaintDatabase.size = RESULTSET.getInt(1);
            }
            System.out.println("Complaint Database connection successful");
        } catch (SQLException ex) {
            System.out.println("Connection to complaint database failed");
        }
        
    }
    
    public static int recordNewComplaint(Complaint complaint){
        int complaintId=0;
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT MAX(ID) FROM APP.COMPLAINTS");
            while(RESULTSET.next()){
                complaintId = RESULTSET.getInt(1);
            }
            complaintId++;
            STATEMENT.executeUpdate("INSERT INTO APP.COMPLAINTS " + "VALUES ('"+complaint.getUserDetails().getLoginId() + "', '"+complaint.complaintDescription+"', '"+complaint.location+"', '"+complaint.typeOfWork+"', '"+complaint.toolsRequired+"','null', CAST('"+complaintId+"' AS INT), 'null')");
            System.out.println("Successfully recorded new complaint");
            ComplaintDatabase.updateSize(ComplaintDatabase.size+1);
            return complaintId;
        } 
        catch (SQLException ex) {
            Logger.getLogger(ComplaintDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public static void deleteComplaint(Complaint complaint){
        // delete complaint from array complantList;
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            STATEMENT.executeUpdate("DELETE FROM APP.COMPLAINTS WHERE ID = CAST('"+complaint.complaintId+"' AS INT)");   
        }
        catch(SQLException sqlEx){
            System.out.println("Error in deleteFinishedComplaint");
        }
    }
    
    public static ArrayList<Complaint> getComplaintDataByUserId(String userId){
        try{
            ArrayList<Complaint> complaintList = new ArrayList<>();
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT * FROM APP.COMPLAINTS");
            while(RESULTSET.next()){
                if(RESULTSET.getString(1).equals(userId)){
                    Complaint complaint = new Complaint(RESULTSET.getString(2),RESULTSET.getString(3),RESULTSET.getString(4),RESULTSET.getString(5),UserDatabase.getUserData(RESULTSET.getString(1)));
                    complaint.complaintId = RESULTSET.getInt(7);
                    complaint.setMessage(RESULTSET.getString(8));
                    if(!RESULTSET.getString(6).equals("null")){
                        complaint.assignedWorker = WorkerDatabase.getWorkerData(RESULTSET.getString(6));
                    }
                    complaintList.add(complaint);
                }
            }
            return complaintList;
        }
        catch(SQLException sqlEx){
            System.out.println("Unable to getComplaintData");
            ArrayList<Complaint> complaintList = new ArrayList<>();
            return complaintList;
        }
    }
    public static ArrayList<Complaint> getComplaintDataByWorkerId(String workerId){
        ArrayList<Complaint> complaintList = new ArrayList<>();
        Worker worker = WorkerDatabase.getWorkerData(workerId);
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT * FROM APP.COMPLAINTS");
            while(RESULTSET.next()){
                if(RESULTSET.getString(6).equals(workerId)){
                    Complaint complaint = new Complaint(RESULTSET.getString(2),RESULTSET.getString(3),RESULTSET.getString(4),RESULTSET.getString(5),UserDatabase.getUserData(RESULTSET.getString(1)));
                    complaint.complaintId = RESULTSET.getInt(7);
                    complaint.setMessage(RESULTSET.getString(8));
                    complaint.assignedWorker = worker;
                    complaintList.add(complaint);
                }
            }
            return complaintList;
        }
        catch(SQLException sqlEx){
            System.out.println("Unable to getComplaintDataByWorkerId");
            return null;
        }
    }
    
    public static int getMaxComplaints(){
        return ComplaintDatabase.MAXCOMPLAINTS;
    }
    
    public static void updateAssignedWorker(String workerId,int complaintId){
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            STATEMENT.executeUpdate("UPDATE APP.COMPLAINTS SET WORKERID = '" + workerId +"' WHERE ID = CAST('" + complaintId + "' AS INT)");
        }
        catch(SQLException sqlEx){
            System.out.println("Error in updateAssingedWorker");
        }
    }
    
    public static void updateMessage(String message,int complaintId){
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            STATEMENT.executeUpdate("UPDATE APP.COMPLAINTS SET CHAT = '" + message +"' WHERE ID = CAST('"+complaintId+"' AS INT)");
            System.out.println("Updated new message successfully");
        } 
        catch (SQLException ex) {
            Logger.getLogger(ComplaintDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
