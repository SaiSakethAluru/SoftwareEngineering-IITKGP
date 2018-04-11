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
public class UserTest {
    private static final int TIMEOUT = 4000;
    static User defUser;
    static String defLoginId = "a";
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        defUser = new User("a","12345","a","a","a");
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
     * Test of getContactDetails method, of class User.
     */
    @Test(timeout = TIMEOUT)
    public void testGetContactDetails() {
        System.out.println("getContactDetails");
        assertEquals("present and retrieved contact details of user","a", defUser.getContactDetails());
    }

    /**
     * Test of getContactNumber method, of class User.
     */
    @Test(timeout = TIMEOUT)
    public void testGetContactNumber() {
        System.out.println("getContactNumber");
        assertEquals("present and retrieved contact number of user","12345", defUser.getContactNumber());
    }

    /**
     * Test of getLoginId method, of class User.
     */
    @Test(timeout = TIMEOUT)
    public void testGetLoginId() {
        System.out.println("getLoginId");
        assertEquals("present and retrieved login id of user","a",defUser.getLoginId());
    }

    /**
     * Test of getLoginPswrd method, of class User.
     */
    @Test(timeout = TIMEOUT)
    public void testGetLoginPswrd() {
        System.out.println("getLoginPswrd");
        assertEquals("present and retrieved login password of user","a",defUser.getLoginId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of authoriseLogin method, of class User.
     */
    @Test(timeout = TIMEOUT)
    public void testAuthoriseLoginCorrect() {
        System.out.println("authoriseLogin for valid credentials");
        User user = UserDatabase.getUserData(defLoginId);
        String inputPassword = "a";
        assertEquals("present and retrieved login password","a",user.getLoginPswrd());
        assertTrue("entered password matches stored password",user.authoriseLogin(defLoginId, inputPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testAuthoriseLoginNotCorrect(){
        System.out.println("authoriseLogin for invalid credentials");
        User user = UserDatabase.getUserData(defLoginId);
        String input = "b";
        assertFalse("entered password doesn't match stored password",user.authoriseLogin(defLoginId, input));
    }
    
}
