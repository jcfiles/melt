package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a test
 * 
 * @author Bruce Steedman
 * @version 2013.09.28
 */
public class Test_ implements java.io.Serializable
{
    private String testTitle;
    private String testIntroText;
    private ArrayList<Section> sections;
    private int possibleMarks; // not used yet!
    private int totalMarksAwarded;
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
     * Reads a test from a file
     */
    public static Test_ readFromFile(String sourceFile) throws IOException, ClassNotFoundException
    {
        File source = new File(sourceFile);
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(source));
        Test_ t = (Test_)is.readObject();
        is.close();
        return t;
    }
    
    /**
     * Writes a test to file
     * 
     */
    public void saveToFile(String destinationFile) throws IOException
    {
        File destination = new File(destinationFile);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(destination));
        os.writeObject(this);
        os.close();
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
     * Returns all sections
     */
    public ArrayList<Section> getAllSections()
    {
        return sections;
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
    private int gradeTest()
    {
        totalMarksAwarded = 0;
        Iterator<Section> it = sections.iterator();
        while (it.hasNext()) {
            Section s = it.next();
            totalMarksAwarded += s.gradeSection();
        }
        return totalMarksAwarded;
    }
    
    /**
     * Gets the test marks
     */
    public int getTotalMarks()
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
     * Demo for testing
     * 
     */
    public static Test_ getDemoTest()
    {
        Test_ t1 = new Test_("A test..","Instructions for the test....",5);
        Question q1 = new Question("What is 2 + 2?");
        Section s1 = new Section("Section A", "Grammar section...");
        t1.addSection(s1);
        Section s2 = new Section("Section B", "Vocabulary section...");
        t1.addSection(s2); 
        //s1.addQuestion(q1);
        q1.addAnswer("5", false);
        q1.addAnswer("3", false);
        q1.addAnswer("4", true);
        FTBQ q2 = null;
        try {
            q2 = new FTBQ("You can suck my [thumb].");
        }
        catch(InvalidFTBQFormatException e) {
        }
        s1.addQuestion(q2);
        FTBQ q3 = null;
        try {
            q3 = new FTBQ("You can hold my [hand].");
        }
        catch(InvalidFTBQFormatException e) {
        }
        s1.addQuestion(q3);
        return t1;
    }
    
    /**
     * Demo for testing
     * 
     */
    public static void main(String[] args)
    {
        Test_ t = Test_.getDemoTest();
        //System.out.println(t);
        //FTBQ q1 = (FTBQ)t.getSection(0).getQuestion(0);
        //String a = q1.getTheAnswer().getAnswerText();
        //q1.setGivenAnswer("thumb");
    }
}