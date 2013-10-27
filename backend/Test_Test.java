/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Map;
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
public class Test_Test {
    
    public Test_Test() {
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
     * Test of readFromFile method, of class Test_.
     */
    @Test
    public void testReadFromFile() throws Exception {
        System.out.println("readFromFile");
        String sourceFile = "";
        Test_ expResult = null;
        Test_ result = Test_.readFromFile(sourceFile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTestTitle method, of class Test_.
     */
    @Test
    public void testGetTestTitle() {
        System.out.println("getTestTitle");
        Test_ instance = null;
        String expResult = "";
        String result = instance.getTestTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTestIntroText method, of class Test_.
     */
    @Test
    public void testGetTestIntroText() {
        System.out.println("getTestIntroText");
        Test_ instance = null;
        String expResult = "";
        String result = instance.getTestIntroText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveToFile method, of class Test_.
     */
    @Test
    public void testSaveToFile() throws Exception {
        System.out.println("saveToFile");
        String destinationFile = "";
        Test_ instance = null;
        instance.saveToFile(destinationFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSection method, of class Test_.
     */
    @Test
    public void testAddSection() {
        System.out.println("addSection");
        Section s = null;
        Test_ instance = null;
        instance.addSection(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSection method, of class Test_.
     */
    @Test
    public void testRemoveSection() {
        System.out.println("removeSection");
        Section s = null;
        Test_ instance = null;
        instance.removeSection(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSection method, of class Test_.
     */
    @Test
    public void testGetSection() {
        System.out.println("getSection");
        int sectionNum = 0;
        Test_ instance = null;
        Section expResult = null;
        Section result = instance.getSection(sectionNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSections method, of class Test_.
     */
    @Test
    public void testGetAllSections() {
        System.out.println("getAllSections");
        Test_ instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAllSections();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unlockTest method, of class Test_.
     */
    @Test
    public void testUnlockTest() {
        System.out.println("unlockTest");
        Test_ instance = null;
        instance.unlockTest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToFile method, of class Test_.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        Map mapWrite = null;
        Test_ instance = null;
        instance.writeToFile(mapWrite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextFromFile method, of class Test_.
     */
    @Test
    public void testGetTextFromFile() {
        System.out.println("getTextFromFile");
        String filename = "";
        Test_ instance = null;
        instance.getTextFromFile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endTest method, of class Test_.
     */
    @Test
    public void testEndTest() {
        System.out.println("endTest");
        Test_ instance = null;
        int expResult = 0;
        int result = instance.endTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Test_.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Test_ instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDemoTest method, of class Test_.
     */
    @Test
    public void testGetDemoTest() {
        System.out.println("getDemoTest");
        Test_ expResult = null;
        Test_ result;
		try {
			result = Test_.getDemoTest2();
			assertEquals(expResult, result);
		} catch (InvalidSlotQFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Test_.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        try {
			Test_.main(args);
		} catch (InvalidSlotQFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}