package backend;

/**
 * An answer to a question
 * 
 * @author Bruce Steedman
 * @version 2013.09.27
 */
public class Answer implements java.io.Serializable
{
    private String answerText = "";
    private boolean isRight = true;
    private boolean isSelected = false;
    
    /**
     * Constructor for an answer, passing the answer text
     */
    public Answer(String answerText, boolean isRight) // private constructor
    {
        this.answerText = answerText;
        this.isRight = isRight;
    }

    /**
     * Returns the answer text
     *  
     */
    public String getAnswerText()
    {
        return answerText;
    }
    
    /**
     * Sets the correct answer flag
     *  
     */
    public void setIsCorrect(boolean bool)
    {
        isRight = bool;
    }
    
    /**
     * Is the the right answer?
     *  
     */
    public boolean getIsRight()
    {
        return isRight;
    }
    
      /**
     * Selects an answer
     *  
     */
    public void select()
    {
        isSelected = true;
    }
     
     /**
     * Deselects an answer
     *  
     */
    public void deSelect()
    {
        isSelected = false;
    }
    
    /**
     * Is this question selected?
     *  
     */
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    /**
     * String representation of an answer
     *  
     */
    public String toString()
    {
        return answerText;
    }
}