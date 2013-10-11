/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author me
 */
public class MCQTest {
    
    public MCQTest() {
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
     * Test of getAllAnswers method, of class MCQ.
     */
    @Test
    public void testGetAllAnswers() {
        System.out.println("getAllAnswers");
        MCQ instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAllAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarksAwarded method, of class MCQ.
     */
    @Test
    public void testGetMarksAwarded() {
        System.out.println("getMarksAwarded");
        MCQ instance = null;
        int expResult = 0;
        int result = instance.getMarksAwarded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MCQ.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MCQ instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}