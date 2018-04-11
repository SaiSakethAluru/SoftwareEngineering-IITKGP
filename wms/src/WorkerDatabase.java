

import java.sql.*;
import java.util.ArrayList;

public class WorkerDatabase extends Database{
	private static int MAXWORKERS=500;
	static final String DB_URL = "jdbc:derby://localhost:1527/workerList";
        static final String DB_DRV = "apache_derby_net";
        static final String DB_USER = "workerList";
        static final String DB_PASSWD = "workerList";
        static Connection CONNECTION = null;
        static Statement STATEMENT = null;
        static ResultSet RESULTSET = null;
    
	public WorkerDatabase(){
            super();
            try{
                CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                STATEMENT=CONNECTION.createStatement();
                
                System.out.println("Worker Database Connection successfull");
            }
            catch(SQLException sqlEx){
                System.out.println("Connection to worker Database failed");
            }
        }
        
	public static int registerNewWorker(Worker worker) {
            int workerId = 0;
            try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT=CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT MAX(ID) FROM APP.WORKERS");
            while(RESULTSET.next()){
                workerId = RESULTSET.getInt(1);
            }
            workerId++;
            STATEMENT.executeUpdate("INSERT INTO  APP.WORKERS "+"VALUES ('" + worker.name + "', '" + worker.contactNumber +"', '" + worker.location + "', '" + worker.typeOfWork +"', '" + worker.getLoginId() + "', '" + worker.getLoginPassword() + "'," + "CAST(" + workerId + " AS INT)" + ")");
            System.out.println("Successfully registered new worker");
            WorkerDatabase.updateSize(WorkerDatabase.size+1);
            return workerId;
        }   
            catch(Exception a){
                System.out.println("Error in inserting new user");
                return -1;
            }
	}
        
	public static void modifyWorkerData(Worker worker) {
            try{
                CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                STATEMENT=CONNECTION.createStatement();
                STATEMENT.executeUpdate("UPDATE APP.WORKERS SET NAME = '"+worker.name+"', CONTACTNUMBER = '"+worker.contactNumber+"', LOCATION = '"+worker.location+"', TYPEOFWORK = '"+worker.typeOfWork+ "' WHERE CAST(LOGINID AS CHAR(128)) = CAST('"+worker.getLoginId()+"' AS CHAR(128))");
                System.out.println("Worker data modified successfully");
            }
            catch(SQLException sqlEx){
                System.out.println("Error in modifying worker data");
            }
	}
	public static Worker getWorkerData(String loginId) {
            try{
                CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                STATEMENT=CONNECTION.createStatement();
                RESULTSET = STATEMENT.executeQuery("SELECT * FROM APP.WORKERS");
                while(RESULTSET.next()){
                    if(RESULTSET.getString(5).equals(loginId)){
                        Worker worker = new Worker(RESULTSET.getString(1),RESULTSET.getString(2),RESULTSET.getString(3),RESULTSET.getString(4),RESULTSET.getString(5),RESULTSET.getString(6));
                        worker.workerId = RESULTSET.getInt(7);
                        return worker;
                    }
                }
                return null;
            }
            catch(SQLException sqlEx){
                System.out.println("Error retrieving worker data");
                return null;
            }
	}
        public static ArrayList<Worker> getWorkerDataByType(String typeOfWork){
            try{
                CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                STATEMENT = CONNECTION.createStatement();
                RESULTSET = STATEMENT.executeQuery("SELECT * FROM APP.WORKERS");
                ArrayList<Worker> workersByType = new ArrayList<>();
                while(RESULTSET.next()){
                    if(RESULTSET.getString(4).equals(typeOfWork)){
                        Worker worker = new Worker(RESULTSET.getString(1),RESULTSET.getString(2),RESULTSET.getString(3),RESULTSET.getString(4),RESULTSET.getString(5),RESULTSET.getString(6));
                        worker.workerId = RESULTSET.getInt(7);
                        workersByType.add(worker);
                    }
                }
                return workersByType;
            }
            catch(SQLException sqlEx){
                System.out.println("Error in getWorkerDataByType");
                ArrayList<Worker> workersByType = new ArrayList<>();
                return workersByType;
            }
        }
	public static boolean deleteWorker(Worker worker) {
            try{
                CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                STATEMENT = CONNECTION.createStatement();
                STATEMENT.executeUpdate("DELETE FROM APP.WORKERS WHERE CAST(LOGINID AS CHAR(128)) = CAST('"+worker.getLoginId()+"' AS CHAR(128))");
                System.out.println("Successfully deleted worker");
                return true;
            }
            catch(SQLException sqlEx){
                System.out.println("Error in deleteWorker");
                return false;
            }
		
	}
	public static int getMaxWorkers() {
		return WorkerDatabase.MAXWORKERS;
	}
	
}
