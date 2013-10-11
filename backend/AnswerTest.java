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
public class AnswerTest {
    
    public AnswerTest() {
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
     * Test of getAnswerText method, of class Answer.
     */
    @Test
    public void testGetAnswerText() {
        System.out.println("getAnswerText");
        Answer instance = null;
        String expResult = "";
        String result = instance.getAnswerText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsCorrect method, of class Answer.
     */
    @Test
    public void testSetIsCorrect() {
        System.out.println("setIsCorrect");
        boolean bool = false;
        Answer instance = null;
        instance.setIsCorrect(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsRight method, of class Answer.
     */
    @Test
    public void testGetIsRight() {
        System.out.println("getIsRight");
        Answer instance = null;
        boolean expResult = false;
        boolean result = instance.getIsRight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class Answer.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        Answer instance = null;
        instance.select();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deSelect method, of class Answer.
     */
    @Test
    public void testDeSelect() {
        System.out.println("deSelect");
        Answer instance = null;
        instance.deSelect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsSelected method, of class Answer.
     */
    @Test
    public void testGetIsSelected() {
        System.out.println("getIsSelected");
        Answer instance = null;
        boolean expResult = false;
        boolean result = instance.getIsSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Answer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Answer instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}