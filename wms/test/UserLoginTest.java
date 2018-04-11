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
public class UserLoginTest {
    private static final int TIMEOUT=4000;
    static UserLogin userLogin;
    public UserLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        userLogin = new UserLogin();
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
     * Test of validEntries method, of class UserLogin.
     */
    @Test(timeout = TIMEOUT)
    public void testValidEntriesCorrect() {
        System.out.println("validEntries with correct details");
        String loginId = "a";
        String inputPassword = "a";
        User user = UserDatabase.getUserData(loginId);
        assertTrue("login with valid credentials",userLogin.validEntries(user,loginId,inputPassword));
        
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesIncorrect(){
        System.out.println("validEntries with incorrect details");
        String loginId = "a";
        String inputPassword = "b";
        User user = UserDatabase.getUserData(loginId);
        assertFalse("login with wrong password",userLogin.validEntries(user,loginId,inputPassword));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesNoUser(){
        System.out.println("validEntries with non existing user");
        String loginId = "zz";
        String inputPassword = "b";
        User user = UserDatabase.getUserData(loginId);
        assertFalse("login with invalid login id",userLogin.validEntries(user,loginId,inputPassword));
    }
}
