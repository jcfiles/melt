package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a test
 * 
 * @author Bruce Steedman
 * @version 2013.09.28
 */
public class Test_
{
    private String testTitle;
    private String testIntroText;
    private ArrayList<Section> sections;
    private int possibleMarks; // not used yet!
    private double totalMarksAwarded = 0;
    public boolean isLocked = true;
    private int allocatedTime;
    
    private long testTime;


    /**
     * Constructor for objects of class Test
     */
    public Test_(String testTitle, String testIntroText, int allocatedTime) 
    {
        this.testTitle = testTitle;
        this.testIntroText = testIntroText;
        sections = new ArrayList<Section>();
        this.allocatedTime = allocatedTime;
    }

    /**
     * Adds a section to the test
     * 
     */
    public void addSection(Section s)
    {
        sections.add(s);
    }
    
     /**
     * Removes a section from the test
     * 
     */
    public void removeSection(Section s)
    {
        sections.remove(s);
    }
    
     /**
     * Returns a section by index, starting at 0
     */
    public Section getSection(int sectionNum)
    {
        return sections.get(sectionNum);
    }
    
    /**
     * Unlocks the test
     */
    public void unlockTest()
    {
        isLocked = false;
    }
    
     /**
     * Starts the test
     */
    public void startTest() 
    {
         new TestTimer(this, allocatedTime);
    }
    
     /**
     * sets the timer for the entire test. 
     */    
    public void setTestTime(long testTimeToBeSet)
    {
        testTime = testTimeToBeSet;
    }
    
    /**
     * Ends the test
     */
    public void endTest()
    {
        gradeTest(); // test can only be grade when it is ended
        isLocked = true; // it is then automatically locked
    }
    
    /**
     * Grades the test for all sections.
     */
    private void gradeTest()
    {
        Iterator<Section> it = sections.iterator();
        while (it.hasNext()) {
            Section s = it.next();
            totalMarksAwarded += s.getSectionMarks();
        }
    }
    
    /**
     * Gets the test marks
     */
    public double getTotalMarks()
    {
        return totalMarksAwarded;
    }
    
    /**
     * String representation of the test
     * 
     */
    public String toString()
    {
        String s = testTitle + "\n\n" + testIntroText + "\n";
        Iterator<Section> it = sections.iterator();
        int sNum = 1;
        while (it.hasNext()) {
            s += "Section " + sNum + ": " + it.next().toString() + "\n\n";
            sNum++;
        }
        return s;
    }
    
     /**
     * main for testing
     * 
     */
    public static void main(String[] args)
    {
        Test_ t1 = new Test_("","",5);
        t1.startTest();
    }

}