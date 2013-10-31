package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a multiple choice question with one or more answers.
 * More than one answer can be correct.
 * 
 * @author Bruce Steedman
 * @version 2013.09.27
 */
public class MCQ extends Question {
    
	String label = "";
	
	
    public MCQ(String questionText, Object parent)
    {
        super(questionText, parent);
        answers = new ArrayList<Answer>();
    }
    
    public MCQ(String questionText, String label, Object parent)
    {
        super(questionText, parent);
        answers = new ArrayList<Answer>();
        this.label = label;
    }
    
    /**
     * Constructor for questions with number of marks provided.
     */
    
    public MCQ(String questionText, int mark, Object parent)
    {
        super(questionText, parent);
        answers = new ArrayList<Answer>();
        possibleMarks = mark;
    }
    
    /**
     * Constructor questions, with a single answer provided.
     */
    public MCQ(String questionText, Answer a, Object parent)
    {
        super(questionText, parent);
        answers = new ArrayList<Answer>();
        answers.add(a);
    }
    
    /**
     * Constructor questions, with a single answer and number of marks provided.
     */
    public MCQ(String questionText, Answer a, int mark, Object parent)
    {
        super(questionText, parent);
        answers = new ArrayList<Answer>();
        answers.add(a);
        possibleMarks = mark;
    }
    
    /**
     * Constructor questions, with a multiple answers provided.
     */
    public MCQ(String questionText, ArrayList<Answer> answers, Object parent)
    {
        super(questionText, parent);
        this.answers = answers;
    }
    
    /**
     * Constructor questions, with multiple answers and number of marks provided.
     */
    public MCQ(String questionText, ArrayList<Answer> answers, int mark, Object parent)
    {
        super(questionText, parent);
        this.answers = answers;
        possibleMarks = mark;
    }
    
    public MCQ(String questionText, ArrayList<Answer> answers, int mark, String label, Object parent)
    {
        super(questionText, parent);
        this.answers = answers;
        possibleMarks = mark;
        this.label = label;
    }
    
    /**
     * Returns all of the possible answers.
     */
    public ArrayList<Answer> getAllAnswers()
    {
        return answers;
    }
    
    /**
     * Returns the mark awarded for the question only if all correct answers and no others are selected.
     */
    public int getMarksAwarded()
    {
        Iterator<Answer> it = answers.iterator();
        boolean anyWrongAnswer = false;
        while (it.hasNext() && !anyWrongAnswer) { // Ensures loop is exited if any wrong answers are selected
            Answer a = it.next();
            if(a.getIsSelected()) {
                if(!a.getIsRight()) {
                    anyWrongAnswer = true;
                }
                else {
                    marksAwarded = possibleMarks;
                }
            }
        }
        return marksAwarded;
    }
    
    /**
     * String representation of a question with multiple answers referenced A, B, C etc..
     */
     public String getMCQ()
    {
        String s = questionText + "\n\n";
        for(int i = 0; i < answers.size(); i++) {
            int unicode = 0x0041 + i; // HEX - 0041 unicode is 'A'
            char c = (char)unicode;
            s += "(" + c + ") " + answers.get(i).toString() + "\n";
        }
        return s;
    }
     
     public String toString()
     {
    	 return "MCQ " + label;
     }
     
     /**
      * Swaps the order of two answers
      * @param ans1
      * @param ans2
      */    
     public void swapAnswers(Answer ans1, Answer ans2){
     	int ans1Position = 0;
     	int ans2Position = 0;
     	for(int i=0; i<answers.size(); i++){
     		if(answers.get(i).equals(ans1)){
     			ans1Position = i;
     		}
     		if(answers.get(i).equals(ans2)){
     			ans2Position = i;
     		}
     	}
     	answers.remove(ans1Position);
     	answers.add(ans1Position, ans2);
     	answers.remove(ans2Position);
     	answers.add(ans2Position, ans1);
     }

	@Override
	public void setMarksAwarded(int marks) {
		
	}
}