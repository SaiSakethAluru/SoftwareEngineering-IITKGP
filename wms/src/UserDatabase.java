import java.sql.*;

public class UserDatabase extends Database{
    static final String DB_URL = "jdbc:derby://localhost:1527/userList";
    static final String DB_DRV = "apache_derby_net";
    static final String DB_USER = "userList";
    static final String DB_PASSWD = "userList";
    private static final int MAXUSERS = 500;
    static Connection CONNECTION = null;
    static Statement STATEMENT = null;
    static ResultSet RESULTSET = null;
    
    public UserDatabase(){
        try{
            String sql = DB_URL+"; databaseName=userList; user="+DB_USER+"; password="+DB_PASSWD+";";
            CONNECTION = DriverManager.getConnection(sql);
            STATEMENT=CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT COUNT(*) FROM APP.USERS");
            while(RESULTSET.next()){
                UserDatabase.size = RESULTSET.getInt(1);
            }
            System.out.println("User Database Connection successfull");
        }
        catch(Exception Ex){
            System.out.println("Connection to userdatabase failed");
        }
       
    }
    public static int registerNewUser(User user){
        int userId=0;
	try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT=CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT MAX(ID) FROM APP.USERS");
            while(RESULTSET.next()){
                userId = RESULTSET.getInt(1);
            }
            userId++;
            STATEMENT.executeUpdate("INSERT INTO  APP.USERS "+"VALUES ('" + user.name + "', '"+ user.getContactNumber()+"', '"+ user.getContactDetails() +"', '"+ user.getLoginId() +"', '"+ user.getLoginPswrd() +"',"+ "CAST("+userId+" AS INT)" + ")");
            System.out.println("Successfully registered new user");
            UserDatabase.updateSize(UserDatabase.size+1);
            return userId;
        }   
        catch(SQLException a){
            System.out.println("Error in inserting new user");
            return -1;
        }
    }
        
    public static void modifyUserData(User user) {
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT=CONNECTION.createStatement();
            STATEMENT.executeUpdate("UPDATE APP.USERS SET NAME = '" +user.name +"', CONTACTNUMBER = '"+ user.getContactNumber() + "', CONTACTDETAILS = '"+user.getContactDetails()+"' WHERE CAST(LOGINID AS CHAR(128)) = CAST('"+user.getLoginId()+"' AS CHAR(128))");
            System.out.println("Modification successful");
        }
        catch(SQLException sqlEx){
            System.out.println("Error in modifying user data");
        }
    }
	
    public static User getUserData(String loginId){
        try {
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT=CONNECTION.createStatement();
            RESULTSET = STATEMENT.executeQuery("SELECT * FROM APP.USERS");
            while(RESULTSET.next()){
                if(RESULTSET.getString(4).equals(loginId)){
                    User user = new User(RESULTSET.getString(1),RESULTSET.getString(2),RESULTSET.getString(3),RESULTSET.getString(4),RESULTSET.getString(5));
                    user.UserId = RESULTSET.getInt(6);
                    return user;
                }
            }
            return null;
        } catch (SQLException ex) {
//            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in getUserData");
            return null;
        }
    }
    
    public static boolean deleteUser(User user) {
        try{
            CONNECTION = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            STATEMENT = CONNECTION.createStatement();
            STATEMENT.executeUpdate("DELETE FROM APP.USERS WHERE CAST(LOGINID AS CHAR(128)) = CAST('"+user.getLoginId()+"' AS CHAR(128))");
            System.out.println("Successfully deleted user");
            return true;
        }
        catch(SQLException sqlEx){
            System.out.println("Error in deleteUser");
            return false;
        }
    }
    public static int getMaxUsers() {
        return UserDatabase.MAXUSERS;
    }
	
}
