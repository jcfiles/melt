package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a question with one or more correct answers
 * 
 * @author Bruce Steedman
 * @version 2013.09.27
 */
public class Question
{
    protected String questionText;
    protected int possibleMarks = 1;
    protected int marksAwarded = 0;
    protected ArrayList<Answer> answers;
    
    /**
     * Constructor for objects of class question
     */
    public Question(String questionText)
    {
        this.questionText = questionText;
        answers = new ArrayList<Answer>();
    }
    
    /**
     * Constructor for objects of class question, with answer provided
     */
    public Question(String questionText, Answer a)
    {
        this(questionText);
        answers.add(a);
    }
    
    /**
     * Adds an answer to the question
     */
    public void addAnswer(String answerText, boolean isRight)
    {
        answers.add(new Answer(answerText, isRight));
    }
    
    /**
     * Sets an answer to the question by index
     */
    public void setAnswer(String answerText, boolean isRight, int index)
    {
        answers.add(new Answer(answerText, isRight));
    }
    
     /**
     * Returns the answer for questions with just one answer
     */
    public Answer getTheAnswer()
    {
        return answers.get(0);
    }
    
    /**
     * Returns an answer by index, for questions with more than one possible answer
     */
    public Answer getIndexedAnswer(int answerNum)
    {
        return answers.get(answerNum);
    }
    
    /**
     * Returns all of the possible answers
     */
    public ArrayList<Answer> getAllAnswers()
    {
        return answers;
    }
    
    /**
     * Returns the question text
     */
    public String getQuestionText()
    {
        return questionText;
    }
    
     /**
     * Sets the question text
     */
    public void getQuestionText(String text) // for editing
    {
        questionText = text;
    }
    
    /**
     * Returns the mark awarded for the question. Is 0 if wrong or unanswered
     */
    public int getMark()
    {
        Iterator<Answer> it = answers.iterator();
        while (it.hasNext()) {
            Answer a = it.next();
            if(a.getIsSelected() && a.getIsRight()) {
                marksAwarded = possibleMarks;
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