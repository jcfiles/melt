package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a test
 * 
 * @author Lok Chan, assisted by Bruce
 * @version 2013.09.28
 */
public class Section
{
    private String sectionTitle;
    private String sectionIntroText;
    private ArrayList<Question> questions;
    private int possibleMarks; // not used yet!
    private double sectionMarksAwarded = 0;
    public boolean isLocked = true;
    private TestTimer sectionProgram; //the testTimer class
    private long sectionTime;
    

    /**
     * Constructor for objects of class Section
     */
    public Section(String sectionTitle, String sectionIntroText)
    {
        this.sectionTitle = sectionTitle;
        this.sectionIntroText = sectionIntroText;
        questions = new ArrayList<Question>();        
    }

    /**
     * Adds a question to the test
     * 
     */
    public void addQuestion(Question q)
    {
        questions.add(q);
    }
    
     /**
     * Removes a question from the test
     * 
     */
    public void removeQuestion(Question q)
    {
        questions.remove(q);
    }
    
     /**
     * Returns an question by index, starting at 0
     */
    public Question getQuestion(int questionNum)
    {
        return questions.get(questionNum);
    }

     /**
     * Starts the section
     */
/**    public void startSection() 
    {
         sectionProgram = new TestTimer(); //initializes Timer object
         sectionProgram.runSection(sectionTime); //runs section in "testTime" seconds.
    }
*/    
     /**
     * sets the timer for the entire test
     */    
/**    public void setSectionTime(long sectionTimeToBeSet)
    {
        sectionTime = sectionTimeToBeSet;
    }    
*/ 
    /**
     * Grades the test for a particular section only. 
     */
    private void gradeQuestionTest()
    {
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()) {
            Question q = it.next();
            sectionMarksAwarded = q.getMark();
        }
    }
    
    /**
     * Gets the test marks
     */
    public double getSectionMarks()
    {
        return sectionMarksAwarded;
    }
    
    /**
     * String representation of the test
     * 
     */
    public String toString()
    {
        String s = sectionTitle + "\n" + sectionIntroText + "\n\n";
        Iterator<Question> it = questions.iterator();
        int qNum = 1;
        while (it.hasNext()) {
            s += "Question " + qNum + ": " + it.next().toString() + "\n\n";
            qNum++;
        }
        return s;
    }
}