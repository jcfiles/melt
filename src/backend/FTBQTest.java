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
public class FTBQTest
{
    FTBQ q2, badQ;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        try {
            q2 = new FTBQ("Two plus [three] equals five.");
            badQ = new FTBQ("Two plus three] equals five.");
        }
        catch(InvalidFTBQFormatException e) {}
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
    public void testGoodFormat()
    {
        assertEquals(true, q2 != null);
    }
    
    @Test
    public void testbadFormat()
    {
        assertEquals(true, badQ == null);
    }
}