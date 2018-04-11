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
public class UserDatabaseTest {
    private static final int TIMEOUT = 4000;
    static User defUser;
    static String defLoginId;
    static String defName = "a";
    static String defContactNum = "12";
    static String defContactDetails = "a";
    static String defPassword = "a";

    public UserDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        defLoginId = "a";
        defUser = new User(defName,defContactNum,defContactDetails,defLoginId,defPassword);
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
     * Test of registerNewUser method, of class UserDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testRegisterNewUser() {
        System.out.println("registerNewUser");
        defUser.UserId = UserDatabase.registerNewUser(defUser);
        User result = UserDatabase.getUserData(defLoginId);
        assertEquals("given name and retrieved name of user",defName,result.name);
        assertEquals("given and retrieved number of user",defContactNum,result.getContactNumber());
        assertEquals("given and retrieved contact details of user",defContactDetails,result.getContactDetails());
        assertEquals("given and retrieved login id of user",defLoginId,result.getLoginId());
        assertEquals("given and retrieved login password of user",defPassword,result.getLoginPswrd());
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyUserData method, of class UserDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testModifyUserData() {
        System.out.println("modifyUserData");
        User user = new User("bb","123","bb","b","b");
        user.UserId = 1;
        UserDatabase.modifyUserData(user);
        User obtainedUser = UserDatabase.getUserData("b");
        assertEquals("modified and stored name of user",user.name,obtainedUser.name);
        assertEquals("modified and stored contact number of user",user.getContactNumber(),obtainedUser.getContactNumber());
        assertEquals("modified and stored contact details of user",user.getContactDetails(),obtainedUser.getContactDetails());
        assertEquals("modified and stored user id of user",user.UserId,obtainedUser.UserId);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserData method, of class UserDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetUserDataExisting() {
        System.out.println("getUserData for existing user");
        User obtainedUser = UserDatabase.getUserData("b");
        obtainedUser.UserId = 1;
//        assertEquals(defUser.name, UserDatabase.getUserData(defLoginId).name);
//        assertEquals(defUser.UserId,UserDatabase.getUserData(defLoginId).UserId);
        User expectedUser = new User("bb","123","bb","b","b");
        expectedUser.UserId = 1;
        assertEquals("given and retrieved name of existing user",expectedUser.name,obtainedUser.name);
        assertEquals("given and retrieved contact number of existing user",expectedUser.getContactNumber(),obtainedUser.getContactNumber());
        assertEquals("given and retrieved contact details of existing user",expectedUser.getContactDetails(), expectedUser.getContactDetails());
        assertEquals("given and retrieved user id of existing user",expectedUser.UserId,obtainedUser.UserId);
    }
    
    @Test(timeout = TIMEOUT)
    public void testGetUserDataNonExisting(){
        System.out.println("getUserData for non-existing user");
        User obtainedUser = UserDatabase.getUserData("zz");
        assertNull("retrieving data of non-existing user",obtainedUser);
    }

    /**
     * Test of deleteUser method, of class UserDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testDeleteUser() {
        System.out.println("deleteUser");
        assertTrue("deleting user from database",UserDatabase.deleteUser(defUser));
        assertNull("retrieving data of deleted user",UserDatabase.getUserData(defLoginId));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxUsers method, of class UserDatabase.
     */
    @Test(timeout = TIMEOUT)
    public void testGetMaxUsers() {
        System.out.println("getMaxUsers");
        assertEquals("maximum number of users allowed",500, UserDatabase.getMaxUsers());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
