package backend;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test_Test.
 *
 * @author  Bruce Steedman
 * @version 2013.09.28
 */
public class Test_Test
{
    public Test_ t1;
    public Question q1;
    public Section s1;
    public FTBQ q2;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        t1 = new Test_("Demo test 1", "This is the intro text to this test... \nblah blah blah\n", 5);
        t1.setTestTime(5);
        s1 = new Section("Section Fill in the Blanks", "This is a section to fill in the blanks");
        
        
        q1 = new Question("What is the capital of Peru?");
        q1.addAnswer("Bogota", false);
        q1.addAnswer("Lima", true);
        try {
            q2 = new FTBQ("Two plus [three] equals five.");
        }
        catch(InvalidFTBQFormatException e) {
        }
        t1.addSection(s1);
        s1.addQuestion(q1);
        s1.addQuestion(q2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testCreateTest_()
    {
        assertEquals(true, t1 != null);
    }
    
    @Test
    public void testPrintTest_()
    {
        System.out.println(t1);
        assertEquals(true, t1 != null);
    }
    
    @Test
    public void testGetMarksNoAnswers()
    {
        assertEquals(true, t1.getTotalMarks() == 0);
    }
    
    @Test
    public void testGetMarksCorrectAnswers()
    {
        t1.getSection(0).getQuestion(0).getIndexedAnswer(1).select(); // comment out to see marks awarded change
        t1.getSection(0).getQuestion(1).getTheAnswer().select(); // ditto
        t1.endTest();
        assertEquals(true, t1.getTotalMarks() >= 0);
    }
}