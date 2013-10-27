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
public class SectionTest {
    
    public SectionTest() {
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
     * Test of getSectionTitle method, of class Section.
     */
    @Test
    public void testGetSectionTitle() {
        System.out.println("getSectionTitle");
        Section instance = null;
        String expResult = "";
        String result = instance.getSectionTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSectionIntroText method, of class Section.
     */
    @Test
    public void testGetSectionIntroText() {
        System.out.println("getSectionIntroText");
        Section instance = null;
        String expResult = "";
        String result = instance.getSectionIntroText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSectionTime method, of class Section.
     */
    @Test
    public void testGetSectionTime() {
        System.out.println("getSectionTime");
        Section instance = null;
        int expResult = 0;
        int result = instance.getSectionTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPossibleSectionMarks method, of class Section.
     */
    @Test
    public void testGetPossibleSectionMarks() {
        System.out.println("getPossibleSectionMarks");
        Section instance = null;
        int expResult = 0;
       // int result = instance.getPossibleSectionMarks();
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addQuestion method, of class Section.
     */
    @Test
    public void testAddQuestion() {
        System.out.println("addQuestion");
        Question q = null;
        Section instance = null;
        instance.addQuestion(q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeQuestion method, of class Section.
     */
    @Test
    public void testRemoveQuestion() {
        System.out.println("removeQuestion");
        Question q = null;
        Section instance = null;
        instance.removeQuestion(q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestion method, of class Section.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        int questionNum = 0;
        Section instance = null;
        Question expResult = null;
       // Question result = instance.getQuestion(questionNum);
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionsList method, of class Section.
     */
    @Test
    public void testGetQuestionsList() {
        System.out.println("getQuestionsList");
        Section instance = null;
        ArrayList expResult = null;
     //   ArrayList result = instance.getQuestionsList();
    //    assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endSection method, of class Section.
     */
    @Test
    public void testEndSection() {
        System.out.println("endSection");
        Section instance = null;
        instance.endSection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gradeSection method, of class Section.
     */
    @Test
    public void testGradeSection() {
        System.out.println("gradeSection");
        Section instance = null;
        int expResult = 0;
        int result = instance.gradeSection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Section.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Section instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}