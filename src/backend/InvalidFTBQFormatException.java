package backend;

/**
 * Exception to catch incorrectly formatted fill in the blanks questions
 * 
 * @author Bruce Steemdan
 * @version 2013.09.28
 */
public class InvalidFTBQFormatException extends Exception
{
    //

    /**
     * Constructor for objects of class InvalidFTBQFormatException
     */
    public InvalidFTBQFormatException()
    {
        super("The question string must contain the answer wrapped in [...].");
    }
}
