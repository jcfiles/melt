package backend;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuestionTest.
 *
 * @author  Bruce Steedman
 * @version 2013.09.28
 */
public class QuestionTest
{
    Question q1; // package private
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        q1 = new Question("What is the capital of Peru?");
        q1.addAnswer("Bogota", false);
        q1.addAnswer("Lima", true);
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
        assertEquals(true, q1 != null);
    }
}