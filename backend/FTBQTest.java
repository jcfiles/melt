/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

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
public class FTBQTest {
    
    public FTBQTest() {
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
     * Test of getQFirstPart method, of class FTBQ.
     */
    @Test
    public void testGetQFirstPart() {
        System.out.println("getQFirstPart");
        FTBQ instance = null;
        String expResult = "";
        String result = instance.getQFirstPart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQSecondPart method, of class FTBQ.
     */
    @Test
    public void testGetQSecondPart() {
        System.out.println("getQSecondPart");
        FTBQ instance = null;
        String expResult = "";
        String result = instance.getQSecondPart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGivenAnswer method, of class FTBQ.
     */
    @Test
    public void testSetGivenAnswer() {
        System.out.println("setGivenAnswer");
        String answer = "";
        FTBQ instance = null;
        instance.setGivenAnswer(answer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGivenAnswer method, of class FTBQ.
     */
    @Test
    public void testGetGivenAnswer() {
        System.out.println("getGivenAnswer");
        FTBQ instance = null;
        String expResult = "";
        String result = instance.getGivenAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarksAwarded method, of class FTBQ.
     */
    @Test
    public void testGetMarksAwarded() {
        System.out.println("getMarksAwarded");
        FTBQ instance = null;
        int expResult = 0;
        int result = instance.getMarksAwarded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FTBQ.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FTBQ instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}