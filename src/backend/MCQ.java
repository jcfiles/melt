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
    
    public MCQ(String questionText)
    {
        super(questionText);
        answers = new ArrayList<Answer>();
    }
    
    /**
     * Constructor for questions with number of marks provided.
     */
    public MCQ(String questionText, int mark)
    {
        super(questionText);
        answers = new ArrayList<Answer>();
        possibleMarks = mark;
    }
    
    /**
     * Constructor questions, with a single answer provided.
     */
    public MCQ(String questionText, Answer a)
    {
        super(questionText);
        answers = new ArrayList<Answer>();
        answers.add(a);
    }
    
    /**
     * Constructor questions, with a single answer and number of marks provided.
     */
    public MCQ(String questionText, Answer a, int mark)
    {
        super(questionText);
        answers = new ArrayList<Answer>();
        answers.add(a);
        possibleMarks = mark;
    }
    
    /**
     * Constructor questions, with a multiple answers provided.
     */
    public MCQ(String questionText, ArrayList<Answer> answers)
    {
        super(questionText);
        this.answers = answers;
    }
    
    /**
     * Constructor questions, with multiple answers and number of marks provided.
     */
    public MCQ(String questionText, ArrayList<Answer> answers, int mark)
    {
        super(questionText);
        this.answers = answers;
        possibleMarks = mark;
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
     public String toString()
    {
        String s = questionText + "\n\n";
        for(int i = 0; i < answers.size(); i++) {
            int unicode = 0x0041 + i; // HEX - 0041 unicode is 'A'
            char c = (char)unicode;
            s += "(" + c + ") " + answers.get(i).toString() + "\n";
        }
        return s;
    }
}