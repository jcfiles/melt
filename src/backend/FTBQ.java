package backend;

/**
 * A fill in the blank question
 * 
 * @author Bruce Steedman 
 * @version 2013.09.27
 */
public class FTBQ extends Question
{
    private String qFirstPart, qSecondPart;
    private String givenAnswer = ""; // index of the blank is in the question string
    
    /**
     * Constructor for objects of class FTBQ
     * 
     * @param Question text string must contain the answer string wrapped in [...] to be valid
     */
    public FTBQ(String ftbqText) throws InvalidFTBQFormatException
    {
        super(ftbqText); // this class does not utilise the questionText parameter in parent class
        String s[] = parseQandA(ftbqText);
        this.qFirstPart = s[1];
        this.qSecondPart = s[2];
        addAnswer(s[0], true);
    }
    
    public String getQFirstPart()
    {
        return qFirstPart;
    }
    
    public String getQSecondPart()
    {
        return qSecondPart;
    }
    
    public void setGivenAnswer(String answer) {
        givenAnswer = answer;
    }
    
    public String getGivenAnswer() {
        return givenAnswer;
    }
    
    @Override
    public int getMark()
    {
        return  givenAnswer.equals(getTheAnswer().getAnswerText()) ? possibleMarks : 0;
    }
    
     /**
     * Parses the question text for the answer, exception thrown on failure
     * 
     * @return 3 strings representing: the answer string and the question text before and after the blank
     */
    private String[] parseQandA(String rawQtext) throws InvalidFTBQFormatException
    {
        String aText, firstPartQ, secondPartQ;
        try {
            int firstBracket = rawQtext.indexOf("[");
            int lastBracket = rawQtext.lastIndexOf("]");
            aText = rawQtext.substring(firstBracket + 1, lastBracket);
            firstPartQ = rawQtext.substring(0, firstBracket);
            secondPartQ = rawQtext.substring(lastBracket + 1, rawQtext.length());
            if(lastBracket < firstBracket) throw new StringIndexOutOfBoundsException(); // Checks for ...]...[... case
        }
        catch (StringIndexOutOfBoundsException e){ 
             throw  new InvalidFTBQFormatException();
        }
        return new String[] {aText, firstPartQ, secondPartQ};
    }
    
     /**
     * String representation of a fill in the blanks question
     *  
     */
    public String toString()
    {
        return qFirstPart + "<BLANK>"+ qSecondPart + "\n";
    }
}