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
public class WorkerLoginTest {
    private static final int TIMEOUT=4000;
    static WorkerLogin workerLogin;
    public WorkerLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        workerLogin = new WorkerLogin();
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
     * Test of validEntries method, of class WorkerLogin.
     */
    @Test(timeout = TIMEOUT)
    public void testValidEntriesCorrect() {
        System.out.println("validEntries with correct details");
        String inputId = "a";
        String inputPassword = "a";
        Worker worker = WorkerDatabase.getWorkerData(inputId);
        assertTrue("worker login with valid details",workerLogin.validEntries(worker, inputId, inputPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesIncorrect() {
        System.out.println("validEntries with incorrect details");
        String inputId = "a";
        String inputPassword = "b";
        Worker worker = WorkerDatabase.getWorkerData(inputId);
        assertFalse("worker login with incorrect password",workerLogin.validEntries(worker, inputId, inputPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesNoWorker() {
        System.out.println("validEntries with non existing worker");
        String inputId = "zz";
        String inputPassword = "a";
        Worker worker = WorkerDatabase.getWorkerData(inputId);
        assertFalse("worker login with invalid login id",workerLogin.validEntries(worker, inputId, inputPassword));
    }
}
