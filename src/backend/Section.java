package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a section
 * 
 * @author Lok Chan, assisted by Bruce
 * @version 2013.09.28
 */
public class Section implements java.io.Serializable
{
    private String sectionTitle;
    private String sectionIntroText;
    private ArrayList<Question> questions;
    private int possibleSectionMarks = 0; // Built as questions added/removed
    private int sectionMarksAwarded;
    public boolean isLocked = true;
    private SectionTimer sectionProgram;
    private int sectionTime;
    

    /**
     * Constructor for objects of class Section
     * @param sectionTime in minutes
     */
    public Section(String sectionTitle, String sectionIntroText, int sectionTime)
    {
        this.sectionTitle = sectionTitle;
        this.sectionIntroText = sectionIntroText;
        this.sectionTime = sectionTime;
        this.questions = new ArrayList<Question>();        
    }
    
    public String getSectionTitle()
    {
        return sectionTitle;
    }
    
    public String getSectionIntroText()
    {
        return sectionIntroText;
    }
    
    public int getSectionTime()
    {
        return sectionTime;
    }
    
    public String getPossibleSectionMarks()
    {
        return sectionIntroText;
    }
    
    public void addQuestion(Question q)
    {
        questions.add(q);
        possibleSectionMarks += q.getPossibleMark();
    }
    
    public void removeQuestion(Question q)
    {
        questions.remove(q);
        possibleSectionMarks -= q.getPossibleMark();
    }
    
    /**
     * Returns an question by index, starting at 0
     */
    public Question getQuestion(int questionNum)
    {
        return questions.get(questionNum);
    }
    
    /**
     * Returns a list of all question in the section
     */
    public ArrayList<Question> getQuestionsList()
    {
        return questions;
    }
    
    /**
     * Starts the test
     */
    //public void startSection() 
    //{
      //   new SectionTimer(this, sectionTime);
    //}
    
    public void endSection() {
        gradeSection();
    }
    
    /**
     * Grades the section 
     */
    public int gradeSection()
    {
        sectionMarksAwarded = 0;
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()) {
            Question q = it.next();
            sectionMarksAwarded += q.getMark();
        }
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