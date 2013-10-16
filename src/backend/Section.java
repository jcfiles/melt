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
    private boolean isLocked;
    private SectionTimer sectionProgram;
    private int sectionTime;
    
    private String subSectionTitle;
    private String subSectionParagraphText;

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
    
    /**
     * Constructor for subSection
     * @param String subSectionTitle, String subSectionParagraphText
     */
    public void setsubSection (String subSectionTitle, String subSectionParagraphText) 
    {
    	this.subSectionTitle = subSectionTitle;
    	this.subSectionParagraphText = subSectionParagraphText;
    }
    
    /**
     * @return String subSectionTitle
     */
    public String getsubSectionTitle() 
    {
    	return subSectionTitle;
    }
    
    /**
     * @return String subSectionParagraphText
     */
    
    public String getsubSectionParagraphText()
    {
    	return subSectionParagraphText;
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
    
    public int getPossibleSectionMarks()
    {
        return possibleSectionMarks;
    }
    
    public void addQuestion(Question q)
    {
        questions.add(q);
        possibleSectionMarks += q.getPossibleMarks();
    }
    
    public void removeQuestion(Question q)
    {
        questions.remove(q);
        possibleSectionMarks -= q.getPossibleMarks();
    }
    
    public void insertQuestion(Question q, int index)
    {
        questions.set(index, q);
    }
    
    public void swapQuestions(Question q1, Question q2){
    	int positionQ1 = 0;
    	int positionQ2 = 0;
    	for(int i=0; i<questions.size(); i++){
    		if(q1.equals(questions.get(i))){
    			positionQ1 = i;
    		}
    		if(q2.equals(questions.get(i))){
    			positionQ2 = i;
    		}
    	}
    	questions.remove(positionQ1);
    	questions.add(positionQ1, q2);
    	questions.remove(positionQ2);
    	questions.add(positionQ2, q1);
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
            sectionMarksAwarded += q.getMarksAwarded();
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
    
    /*
     * Locks the section
     */
    public void lockSection(){
    	isLocked = true;
    }
    
    /*
     * Returns true or false if the section is locked
     */
    public boolean isLocked(){
    	return isLocked;
    }
}