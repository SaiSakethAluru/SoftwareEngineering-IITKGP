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
public class UserInterfaceTest {
    private static final int TIMEOUT=4000;
    static UserInterface userInterface;
    static User defUser;
    public UserInterfaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        defUser = new User("a","12","a","a","a");
        userInterface = new UserInterface(defUser);
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
     * Test of validDetails method, of class UserInterface.
     */
    @Test(timeout = TIMEOUT)
    public void testValidDetailsCorrect() {
        System.out.println("validDetails with correct entries");
        String name = "a";
        String contactNumber = "12";
        String contactDetails = "a";
        assertEquals("save profile with valid details",0, userInterface.validDetails(name, contactNumber, contactDetails));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankName() {
        System.out.println("validDetails with blank name");
        String name = "";
        String contactNumber = "12";
        String contactDetails = "a";
        assertEquals("save profile with blank name",1, userInterface.validDetails(name, contactNumber, contactDetails));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankNumber() {
        System.out.println("validDetails with blank number");
        String name = "a";
        String contactNumber = "";
        String contactDetails = "a";
        assertEquals("save profile with blank contact number",1, userInterface.validDetails(name, contactNumber, contactDetails));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsBlankDetails() {
        System.out.println("validDetails with blank contact details");
        String name = "a";
        String contactNumber = "12";
        String contactDetails = "";
        assertEquals("save profile with blank contact details",1, userInterface.validDetails(name, contactNumber, contactDetails));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidDetailsNumberFormat() {
        System.out.println("validDetails with wrong number format");
        String name = "a";
        String contactNumber = "a";
        String contactDetails = "a";
        assertEquals("save profile with wrong number format",2, userInterface.validDetails(name, contactNumber, contactDetails));
    }
    
}
