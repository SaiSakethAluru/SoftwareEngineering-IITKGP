/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saketh
 */
public class WmsMain {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        UserDatabase userDatabase = new UserDatabase();
        WorkerDatabase workerDatabase = new WorkerDatabase();
        ComplaintDatabase complaintDatabase = new ComplaintDatabase();
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
        
    }
    
}
