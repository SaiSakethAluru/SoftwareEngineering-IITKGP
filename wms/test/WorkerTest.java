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
public class WorkerTest {
    private static final int TIMEOUT = 4000;
    static Worker defWorker;
    public WorkerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        defWorker = new Worker("aa","12345","aa","Electrical","a","a");
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
     * Test of setPendingComplaints method, of class Worker.
     */
    @Test(timeout = TIMEOUT)
    public void testSetPendingComplaints() {
        System.out.println("setPendingComplaints");
        defWorker.setPendingComplaints();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("calculating pending complaints of worker",1,defWorker.pendingComplaints);
    }

    /**
     * Test of getLoginId method, of class Worker.
     */
    @Test(timeout = TIMEOUT)
    public void testGetLoginId() {
        System.out.println("getLoginId");
        assertEquals("present and retrieved login id of worker","a", defWorker.getLoginId());
    }

    /**
     * Test of getLoginPassword method, of class Worker.
     */
    @Test(timeout = TIMEOUT)
    public void testGetLoginPassword() {
        System.out.println("getLoginPassword");
        assertEquals("present and retrieved login password of worker","a", defWorker.getLoginPassword());
    }

    /**
     * Test of authoriseLogin method, of class Worker.
     */
    @Test(timeout = TIMEOUT)
    public void testAuthoriseLoginValid() {
        System.out.println("authoriseLogin");
        String loginId = "a";
        String inputPassword = "a";
        assertTrue(defWorker.authoriseLogin(loginId, inputPassword));
        User user = UserDatabase.getUserData(loginId);
        assertEquals("authorise login with correct details",inputPassword,user.getLoginPswrd());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAuthoriseLoginInvalid() {
        System.out.println("authoriseLogin");
        String loginId = "a";
        String inputPassword = "b";
        User user = UserDatabase.getUserData(loginId);
        assertFalse(defWorker.authoriseLogin(loginId, inputPassword));
        assertNotEquals("authorise login with wrong password",inputPassword,user.getLoginPswrd());
    }

    /**
     * Test of compareTo method, of class Worker.
     */
    @Test(timeout = TIMEOUT)
    public void testCompareTo() {
        System.out.println("compareTo");
        Worker w1 = new Worker("p","987","p","p","p","p");
        w1.setPendingComplaints();
        Worker w2 = new Worker("q","9876","q","q","q","q");
        w2.setPendingComplaints();
        defWorker.setPendingComplaints();
        assertEquals("same number of pending complaints",0,w1.compareTo(w2));
        assertEquals("more number of pending complaints",1,defWorker.compareTo(w1));
        assertEquals("less number of pending complaints",-1,w1.compareTo(defWorker));
    }
    
}
