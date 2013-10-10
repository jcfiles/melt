package backend;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SectionTest.
 *
 * @author  Lok Chan
 * @version 2013.09.29
 */
public class SectionTest
{
    Section s1;
    MCQ q1;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        s1 = new Section("Fill in the Blank section", "Please fill in the blanks accordingly in the given brackets below", 5);
        q1 = new MCQ("Does John Sergeant like pizza?");
        s1.addQuestion(q1);
        q1.addAnswer(new Answer("Yes", false));
        q1.addAnswer(new Answer("No", true));
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
    public void testNewMCQ()
    {
        assertEquals(true, s1 != null);
    }    
}
