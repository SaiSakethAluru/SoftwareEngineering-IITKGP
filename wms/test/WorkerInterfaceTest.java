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
public class WorkerInterfaceTest {
    private static final int TIMEOUT = 4000;
    static WorkerInterface workerInterface;
    static Worker worker;
    public WorkerInterfaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        worker = new Worker("a","123","a","Electrical","a","a");
        workerInterface = new WorkerInterface(worker);
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
     * Test of validDetails method, of class WorkerInterface.
     */
    @Test(timeout = TIMEOUT)
    public void testValidDetailsCorrect() {
        System.out.println("validDetails with correct details");
        String name = "a";
        String contactNumber = "123";
        String location = "a";
        assertEquals("save profile with valid details",0, workerInterface.validDetails(name, contactNumber, location));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankName() {
        System.out.println("validDetails with blank name");
        String name = "";
        String contactNumber = "123";
        String location = "a";
        assertEquals("save profile with blank name",1, workerInterface.validDetails(name, contactNumber, location));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankNumber() {
        System.out.println("validDetails with blank number");
        String name = "a";
        String contactNumber = "";
        String location = "a";
        assertEquals("save profile with blank number",1, workerInterface.validDetails(name, contactNumber, location));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankLocation() {
        System.out.println("validDetails with blank location");
        String name = "a";
        String contactNumber = "123";
        String location = "";
        assertEquals("save profile with blank location",1, workerInterface.validDetails(name, contactNumber, location));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsInvalidNumber() {
        System.out.println("validDetails with invalid number");
        String name = "a";
        String contactNumber = "a";
        String location = "a";
        assertEquals("save profile with blank number",2, workerInterface.validDetails(name, contactNumber, location));
    }
}
