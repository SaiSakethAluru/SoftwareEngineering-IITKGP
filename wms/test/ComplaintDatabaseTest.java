/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saketh
 */
public class ComplaintDatabaseTest {
    private static final int TIMEOUT = 4000;
    public ComplaintDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of assignAll method, of class ComplaintDatabase.
     */
    

    /**
     * Test of recordNewComplaint method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testRecordNewComplaint() {
        System.out.println("recordNewComplaint");
        User user = new User("f","12","f","f","f");
        Complaint complaint = new Complaint("c","c","Sweeping","c",user);
        assertEquals("complaint stored with correct id",3, ComplaintDatabase.recordNewComplaint(complaint));
        Complaint obtained = ComplaintDatabase.getComplaintDataByUserId("f").get(0);
        assertEquals("description of recorded and stored complaint",complaint.complaintDescription,obtained.complaintDescription);
        assertEquals("location of recorded and stored complaint",complaint.location,obtained.location);
        assertEquals("tools of recorded and stored complaint",complaint.toolsRequired,obtained.toolsRequired);
        assertEquals("type of work of recorded and stored complaint",complaint.typeOfWork,obtained.typeOfWork);
        assertEquals("user id of recorded and stored complaint",complaint.getUserDetails().getLoginId(),obtained.getUserDetails().getLoginId());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteComplaint method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testDeleteComplaint() {
        System.out.println("deleteComplaint");
        User user = new User("c","1234","c","c","c");
        Complaint complaint = new Complaint("c","c","Sweeping","c",user);
        complaint.complaintId = 3;
        ComplaintDatabase.deleteComplaint(complaint);
        ArrayList<Complaint> complaintList = ComplaintDatabase.getComplaintDataByUserId("c");
        if(!complaintList.isEmpty()){
            for(int i=0;i<complaintList.size();i++){
                assertNotEquals("complaint doesn't have id= 3",3,complaintList.get(i).complaintId);
            }
        }
        else{
            assertTrue("no complaint with id = 3",complaintList.isEmpty());
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getComplaintDataByUserId method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetComplaintDataByUserIdExisting() {
        System.out.println("getComplaintDataByUserId with existing complaints");
        ArrayList<Complaint> expResult = new ArrayList<>();
        User defUser = new User("a","a","a","a","a");
        Complaint defComplaint = new Complaint("a","a","Electrical","a",defUser);
        defComplaint.complaintId=1;
        expResult.add(defComplaint);
        ArrayList<Complaint> result = ComplaintDatabase.getComplaintDataByUserId("a");
        assertEquals("description of given complaints and retrieved complaint",expResult.get(0).complaintDescription, result.get(0).complaintDescription);
        assertEquals("location of given complaint and retrieved complaint",expResult.get(0).location, result.get(0).location);
        assertEquals("tools of given complaint and retrieved complaint",expResult.get(0).toolsRequired,result.get(0).location);
        assertEquals("comparing type of work of given and retrieved complaint",expResult.get(0).typeOfWork,result.get(0).typeOfWork);
        assertEquals("comparing id of given and retrieved complaint",expResult.get(0).complaintId,result.get(0).complaintId);
        
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testGetComplaintDataByUserIdNoComplaints(){
        System.out.println("getComplaintDataByUserId with no complaints");
        ArrayList<Complaint> result = ComplaintDatabase.getComplaintDataByUserId("f");
        assertTrue("complaints of a user having no complaints",result.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testGetComplaintDataByUserIdNoUser(){
        System.out.println("getComplaintDataByUserId with no user");
        ArrayList<Complaint> result = ComplaintDatabase.getComplaintDataByUserId("z");
        assertTrue("complaints of a non-existing user",result.isEmpty());
    }
    /**
     * Test of getComplaintDataByWorkerId method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetComplaintDataByWorkerIdExisting() {
        System.out.println("getComplaintDataByWorkerId with existing complaints");
        String workerId = "a";
        ArrayList<Complaint> expResult = new ArrayList<>();
        User defUser = new User("a","a","a","a","a");
        Complaint defComplaint = new Complaint("a","a","Electrical","a",defUser);
        expResult.add(defComplaint);
        ArrayList<Complaint> result = ComplaintDatabase.getComplaintDataByWorkerId(workerId);
        assertEquals("login id of given user and retrieved complaint's user",expResult.get(0).getUserDetails().getLoginId(),result.get(0).getUserDetails().getLoginId());
        assertEquals("description of given complaint and retrived complaint",expResult.get(0).complaintDescription,result.get(0).complaintDescription);
        assertEquals("location of given complaint and retrieved complaint",expResult.get(0).location,result.get(0).location);
        assertEquals("type of work of given complaint and retrieved complaint",expResult.get(0).typeOfWork,result.get(0).typeOfWork);
        assertEquals("tools of given complaint and retrieved complaint",expResult.get(0).toolsRequired,result.get(0).toolsRequired);
    }
    
    @Test(timeout = TIMEOUT)
    public void testGetComplaintDataByWorkerIdNoComplaints(){
        System.out.println("getComplaintDatabByWorkerId with no complaints");
        String workerId = "b";
        ArrayList<Complaint> result = ComplaintDatabase.getComplaintDataByWorkerId(workerId);
        assertTrue("complaints of a worker having no complaints",result.isEmpty());
    }
    
    @Test(timeout = TIMEOUT)
    public void testGetComplaintDatabByWorkerIdNoWorker(){
        System.out.println("getComplaintDataByWorkerId with no worker");
        String workerId = "x";
        ArrayList<Complaint> result = ComplaintDatabase.getComplaintDataByWorkerId(workerId);
        assertTrue("complaints of a non-existing worker",result.isEmpty());
    }

    /**
     * Test of getMaxComplaints method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetMaxComplaints() {
        System.out.println("getMaxComplaints");
        assertEquals("maximum complaints allowed",200, ComplaintDatabase.getMaxComplaints());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAssignedWorker method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testUpdateAssignedWorker() {
        System.out.println("updateAssignedWorker");
        String workerId = "bb";
        int complaintId = 2;
        ComplaintDatabase.updateAssignedWorker(workerId, complaintId);
        User defUser = new User("b","b","b","b","b");
        Complaint expResult = new Complaint("b","b","Plumbing","b",defUser);
        Worker defAssignedWorker = new Worker("bb","1234","bb","Plumbing","bb","bb");
        defAssignedWorker.workerId = 3;
        expResult.assignedWorker = defAssignedWorker;
        ArrayList<Complaint> complaintList = ComplaintDatabase.getComplaintDataByWorkerId("bb");
        Complaint result = complaintList.get(0);
        assertEquals("updated name and stored name of assigned worker",expResult.assignedWorker.name,result.assignedWorker.name);
        assertEquals("updated and stored id of assigned worker",expResult.assignedWorker.workerId,result.assignedWorker.workerId);
        assertEquals("updated and stored contact number of assigned worker",expResult.assignedWorker.contactNumber,result.assignedWorker.contactNumber);
        assertEquals("updated and stored location of assigned worker",expResult.assignedWorker.location,result.assignedWorker.location);
        assertEquals("updated and stored login id of assigned worker",expResult.assignedWorker.getLoginId(),result.assignedWorker.getLoginId());
    }

    /**
     * Test of updateMessage method, of class ComplaintDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testUpdateMessage() {
        System.out.println("updateMessage");
        String message = "hello";
        int complaintId = 2;
        ComplaintDatabase.updateMessage(message, complaintId);
        ArrayList<Complaint> complaintList = ComplaintDatabase.getComplaintDataByUserId("b");
        Complaint complaint = complaintList.get(0);
        assertEquals("updated and stored message",message,complaint.getMessage());
    }
    
}
