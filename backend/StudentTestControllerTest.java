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
import student.TestSectionPanel;

/**
 *
 * @author me
 */
public class StudentTestControllerTest {
    
    public StudentTestControllerTest() {
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
     * Test of getTest method, of class StudentTestController.
     */
    @Test
    public void testGetTest() {
        System.out.println("getTest");
        StudentTestController instance = new StudentTestController();
        Test_ expResult = null;
        Test_ result = instance.getTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startSection method, of class StudentTestController.
     */
    @Test
    public void testStartSection() {
        System.out.println("startSection");
        Section section = null;
        StudentTestController instance = new StudentTestController();
        instance.startSection(section);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endSection method, of class StudentTestController.
     */
    @Test
    public void testEndSection() {
        System.out.println("endSection");
        TestSectionPanel sectionPanel = null;
        StudentTestController instance = new StudentTestController();
        instance.endSection(sectionPanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}