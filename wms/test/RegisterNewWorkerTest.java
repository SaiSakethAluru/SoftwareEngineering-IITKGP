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
public class RegisterNewWorkerTest {
    private static final int TIMEOUT = 4000;
    static RegisterNewWorker registerNewWorker;
    public RegisterNewWorkerTest() {
        registerNewWorker = new RegisterNewWorker();
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
     * Test of validDetails method, of class RegisterNewWorker.
     */
    @Test(timeout = TIMEOUT)
    public void testValidDetailsCorrect() {
        System.out.println("validDetails with correct details");
        String inputName = "w";
        String inputContactNumber = "987152226";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with valid details",0, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankName() {
        System.out.println("validDetails with blank name");
        String inputName = "";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with blank name",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankNumber() {
        System.out.println("validDetails with blank number");
        String inputName = "w";
        String inputContactNumber = "";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with blank contact number",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankLocation() {
        System.out.println("validDetails with blank location");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with blank location",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankLoginId() {
        System.out.println("validDetails with blank login id");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with blank login id",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankType() {
        System.out.println("validDetails with blank type");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 0;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with blank type of work",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankLoginPassword() {
        System.out.println("validDetails with blank login password");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with blank login password",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankConfirmPassword() {
        System.out.println("validDetails with blank confirm password");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "";
        assertEquals("register new worker with blank confirm password",1, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsIncorrectPasswords() {
        System.out.println("validDetails with incorrect passwords");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "ww";
        assertEquals("register new worker with mismatch in passwords",2, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsExisting() {
        System.out.println("validDetails with blank name");
        String inputName = "w";
        String inputContactNumber = "66";
        String inputLocation = "w";
        String inputLoginId = "a";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with existing login id",3, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsNumberError() {
        System.out.println("validDetails with blank name");
        String inputName = "w";
        String inputContactNumber = "w";
        String inputLocation = "w";
        String inputLoginId = "w";
        int typeSelected = 1;
        String inputLoginPassword = "w";
        String inputConfirmPassword = "w";
        assertEquals("register new worker with wrong contact number format",4, registerNewWorker.validDetails(inputName, inputContactNumber, inputLocation, inputLoginId, typeSelected, inputLoginPassword, inputConfirmPassword));
    }
}
