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
public class RegisterNewUserTest {
    private static final int TIMEOUT = 4000;
    static RegisterNewUser registerNewUser;
    public RegisterNewUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        registerNewUser = new RegisterNewUser();
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
     * Test of validDetails method, of class RegisterNewUser.
     */
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsCorrect() {
        System.out.println("validDetails with correct details");
        String inputName = "z"; 
        String inputContactNumber = "988651234";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("new user with valid details",0,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankName() {
        System.out.println("validDetails with blank name");
        String inputName = ""; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("new user registration with blank name",1,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankNumber() {
        System.out.println("validDetails with blank number");
        String inputName = "z"; 
        String inputContactNumber = "";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("new user registration with blank number",1,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankDetails() {
        System.out.println("validDetails with blank details");
        String inputName = "z"; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("new user registration with blank contactdetails",1,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankLoginId() {
        System.out.println("validDetails with blank login id");
        String inputName = "z"; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "z";
        String inputLoginId = "";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("new user registration with blank login id",1,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankLoginPassword() {
        System.out.println("validDetails with blank login password");
        String inputName = "z"; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "";
        String inputConfirmPassword = "z";
        assertEquals("new user registration with blank login password",1,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankConfirmPassword() {
        System.out.println("validDetails with blank login confirm password");
        String inputName = "z"; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "";
        assertEquals("new user registration with blank confirm password",1,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsIncorrect(){
        System.out.println("validDetails with incorrect passwords");
        String inputName = "z"; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "zz";
        assertEquals("new user registration with mismatched input password and confirm password",2,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsExisting() {
        System.out.println("validDetails with existing loginI id");
        String inputName = "z"; 
        String inputContactNumber = "9886512345";
        String inputcontactDetails = "z";
        String inputLoginId = "a";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("register new user with existing login id",3,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsNumberFormat() {
        System.out.println("validDetails with wrong number format");
        String inputName = "z"; 
        String inputContactNumber = "z";
        String inputcontactDetails = "z";
        String inputLoginId = "z";
        String inputLoginPassword = "z";
        String inputConfirmPassword = "z";
        assertEquals("register new user with wrong contact number format",4,registerNewUser.validDetails(inputName, inputContactNumber, inputcontactDetails, inputLoginId, inputLoginPassword, inputConfirmPassword));
        
    }
    
}
