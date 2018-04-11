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
public class WorkerDatabaseTest {
    private static final int TIMEOUT=4000;
    String defLoginId = "c";
    Worker worker;
    public WorkerDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        worker = new Worker("c","12345","c","Sweeping","c","c");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerNewWorker method, of class WorkerDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testRegisterNewWorker() {
        System.out.println("registerNewWorker");
//        Worker worker = new Worker("c","12345","c","Sweeping","c","c");
        assertEquals("register new worker with worker id",4, WorkerDatabase.registerNewWorker(worker));
        Worker obtained = WorkerDatabase.getWorkerData(defLoginId);
        assertEquals("name of given and stored worker",worker.name,obtained.name);
        assertEquals("contact number of given and stored worker",worker.contactNumber,obtained.contactNumber);
        assertEquals("location of given and stored worker",worker.location,obtained.location);
        assertEquals("type of work of given and stored worker",worker.typeOfWork,obtained.typeOfWork);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of modifyWorkerData method, of class WorkerDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testModifyWorkerData() {
        System.out.println("modifyWorkerData");
        Worker newWorker = new Worker("aa","12345","aa","Electrical","a","a");
        WorkerDatabase.modifyWorkerData(newWorker);
        Worker result = WorkerDatabase.getWorkerData("a");
        assertEquals("modified and updated name of worker",newWorker.name,result.name);
        assertEquals("modified and updated location of worker",newWorker.location,result.location);
        assertEquals("modified and updated type of work of worker",newWorker.typeOfWork,result.typeOfWork);
        assertEquals("modified and updated contact number of worker",newWorker.contactNumber,result.contactNumber);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getWorkerData method, of class WorkerDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetWorkerData() {
        System.out.println("getWorkerData");
        Worker expResult = new Worker("aa","12345","aa","Electrical","a","a");
        Worker result = WorkerDatabase.getWorkerData("a");
//        assertEquals(expResult, result);
        assertEquals("present and retrieved name of worker",expResult.name,result.name);
        assertEquals("present and retrieved contact number of worker",expResult.contactNumber, result.contactNumber);
        assertEquals("present and retrieved location of worker",expResult.location,result.location);
        assertEquals("present and retrieved type of work of worker",expResult.typeOfWork,result.typeOfWork);
        assertEquals("present and retrieved login id of worker",expResult.getLoginId(),result.getLoginId());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorkerDataByType method, of class WorkerDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetWorkerDataByType() {
        System.out.println("getWorkerDataByType");
        String typeOfWork = "Electrical";
        Worker defWorker = new Worker("aa","12345","aa","Electrical","a","a");
        ArrayList<Worker> resultList = WorkerDatabase.getWorkerDataByType(typeOfWork);
        Worker result = resultList.get(0);
        assertEquals("existing and retrieved name of worker by type",defWorker.name,result.name);
        assertEquals("existing and retrieved contact number of worker by type",defWorker.contactNumber,result.contactNumber);
        assertEquals("existing and retrieved location of worker by type",defWorker.location,result.location);
        assertEquals("existing and retrieved type of work of worker by type",defWorker.typeOfWork,result.typeOfWork);
        assertEquals("existing and retrieved login id of worker by type",defWorker.getLoginId(),result.getLoginId());;
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteWorker method, of class WorkerDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testDeleteWorker() {
        System.out.println("deleteWorker");
        assertEquals("deleting worker from database",true, WorkerDatabase.deleteWorker(worker));
        assertNull("retrieving data of deleted worker",WorkerDatabase.getWorkerData(defLoginId));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMaxWorkers method, of class WorkerDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetMaxWorkers() {
        System.out.println("getMaxWorkers");
        assertEquals("max worker allowed in database",500, WorkerDatabase.getMaxWorkers());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
