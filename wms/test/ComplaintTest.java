/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ComplaintTest {
    private static final int TIMEOUT = 4000;
    static Complaint defComplaint;
    static User defUser;
    public ComplaintTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        defUser = new User("d","1","d","d","d");
        defComplaint = new Complaint("d","d","Electrical","d",defUser);
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
     * Test of assignWorker method, of class Complaint.
     */
    @Test(timeout = TIMEOUT)
    public void testAssignWorker() {
        System.out.println("assignWorker");
        defComplaint.assignWorker();
        assertEquals("assigned worker's login id","a",defComplaint.assignedWorker.getLoginId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUserDetails method, of class Complaint.
     */
    @Test(timeout = TIMEOUT)
    public void testGetUserDetails() {
        System.out.println("getUserDetails");
        User result = defComplaint.getUserDetails();
        assertEquals("user login id details",defUser.getLoginId(),result.getLoginId());
        assertEquals("complaint user's name ",defUser.name,result.name);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMessage method, of class Complaint.
     */
    @Test(timeout = TIMEOUT)
    public void testGetMessage() {
        System.out.println("getMessage");
        String expResult = "hello";
        String result = defComplaint.getMessage();
        assertEquals("present message and retrieved message",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setMessage method, of class Complaint.
     */
    @Test(timeout = TIMEOUT)
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "hello";
        defComplaint.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("set message and retrieved message",message,defComplaint.getMessage());
    }
    
}
