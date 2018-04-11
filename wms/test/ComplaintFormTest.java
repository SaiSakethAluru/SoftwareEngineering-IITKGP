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
public class ComplaintFormTest {
    private static final int TIMEOUT = 4000;
    static ComplaintForm complaintForm;
    static User user;
    public ComplaintFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        user = new User("a","234","a","a","a");
        complaintForm = new ComplaintForm(user);
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
     * Test of validEntries method, of class ComplaintForm.
     */
    @Test(timeout = TIMEOUT)
    public void testValidEntriesCorrect() {
        System.out.println("validEntries with correct details");
        int typeIndex = 1;
        String inputLocation = "c";
        String inputComplaintDescription = "c";
        String inputTools = "c";
        assertTrue("valid complaint details",complaintForm.validEntries(typeIndex, inputLocation, inputComplaintDescription, inputTools));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesBlankType() {
        System.out.println("validEntries with correct details");
        int typeIndex = 0;
        String inputLocation = "c";
        String inputComplaintDescription = "c";
        String inputTools = "c";
        assertFalse("complaint form with blank type of work",complaintForm.validEntries(typeIndex, inputLocation, inputComplaintDescription, inputTools));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesBlankLocation() {
        System.out.println("validEntries with correct details");
        int typeIndex = 1;
        String inputLocation = "";
        String inputComplaintDescription = "c";
        String inputTools = "c";
        assertFalse("complete form with blank location",complaintForm.validEntries(typeIndex, inputLocation, inputComplaintDescription, inputTools));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesBlankDescription() {
        System.out.println("validEntries with correct details");
        int typeIndex = 1;
        String inputLocation = "c";
        String inputComplaintDescription = "";
        String inputTools = "c";
        assertFalse("complaint form with blank description",complaintForm.validEntries(typeIndex, inputLocation, inputComplaintDescription, inputTools));
    }
    
    @Test(timeout = TIMEOUT)
    public void testValidEntriesBlankTools() {
        System.out.println("validEntries with correct details");
        int typeIndex = 1;
        String inputLocation = "c";
        String inputComplaintDescription = "c";
        String inputTools = "";
        assertFalse("complaint form with blank tools",complaintForm.validEntries(typeIndex, inputLocation, inputComplaintDescription, inputTools));
    }
}
