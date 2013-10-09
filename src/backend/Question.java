package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a question with one or more answers.
 * 
 * @author Bruce Steedman
 * @version 2013.09.27
 */
public class Question implements java.io.Serializable
{
    protected String questionText;
    protected int possibleMarks = 1;
    protected int marksAwarded = 0;
    protected ArrayList<Answer> answers;
    
    /**
     * Constructor for questions.
     */
    public Question(String questionText)
    {
        this.questionText = questionText;
        answers = new ArrayList<Answer>();
    }
    
    /**
     * Constructor for questions with number of marks provided.
     */
    public Question(String questionText, int mark)
    {
        this.questionText = questionText;
        answers = new ArrayList<Answer>();
        possibleMarks = mark;
    }
    
    /**
     * Constructor questions, with a single answer provided.
     */
    public Question(String questionText, Answer a)
    {
        this(questionText);
        answers = new ArrayList<Answer>();
        answers.add(a);
    }
    
    /**
     * Constructor questions, with a multiple answers provided.
     */
    public Question(String questionText, ArrayList<Answer> answers)
    {
        this(questionText);
        this.answers = answers;
    }
    
    /**
     * Constructor questions, with a single answer and number of marks provided.
     */
    public Question(String questionText, Answer a, int mark)
    {
        this(questionText);
        answers = new ArrayList<Answer>();
        answers.add(a);
        possibleMarks = mark;
    }
    
    /**
     * Constructor questions, with multiple answers and number of marks provided.
     */
    public Question(String questionText, ArrayList<Answer> answers, int mark)
    {
        this(questionText);
        this.answers = answers;
        possibleMarks = mark;
    }
    
    public void addAnswer(String answerText, boolean isRight)
    {
        answers.add(new Answer(answerText, isRight));
    }
    
    /**
     * Sets an answer to the question by index, e.g. 0 is the first answer. 
     */
    public void setAnswer(String answerText, boolean isRight, int index)
    {
        answers.add(new Answer(answerText, isRight));
    }
    
     /**
     * Returns the answer for questions with just one answer.
     */
    public Answer getTheAnswer()
    {
        return answers.get(0);
    }
    
    /**
     * Returns an answer by index, for questions with more than one possible answer.
     */
    public Answer getIndexedAnswer(int answerNum)
    {
        return answers.get(answerNum);
    }
    
    /**
     * Returns all of the possible answers.
     */
    public ArrayList<Answer> getAllAnswers()
    {
        return answers;
    }
    
    public String getQuestionText()
    {
        return questionText;
    }
    
     /**
     * Sets the question text.
     */
    public void setQuestionText(String text) // for editing
    {
        questionText = text;
    }
    
    /**
     * Returns the mark awarded for the question only if all correct answers and no others are selected.
     */
    public int getMark()
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
     * Returns the mark awarded for the question. Is 0 if wrong or unanswered.
     */
    public int getPossibleMark()
    {
        return possibleMarks;
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