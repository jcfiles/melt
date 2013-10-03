package backend;

import java.util.ArrayList;

// Importing the classes below for importing files: 
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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
    
    //Importing the classes below to write student result to text file.
    private PrintWriter printWriter; 
    private File file;
    
    private Map<Integer, Integer> mapWrite;


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
     * Write to File. 
     * This version basically writes the studenID and testResult in a single text file.
     * This method uses Map as its input parameter.
     */   
	public void writeToFile (Map mapWrite) {
		
		this.mapWrite = mapWrite;
		String stringResults = "studentID | testResult";

        // Using an iterator
        Iterator<Map.Entry<Integer, Integer>> it = mapWrite.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry<Integer, Integer>)it.next();
            stringResults = stringResults + e.getKey() + " | " + e.getValue();
        }
		try
		{
			file = new File ("studentTestResults.txt");
			
			printWriter = new PrintWriter ("studentTestResults.txt");
			printWriter.println (stringResults);
			printWriter.close ();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
    
    /**
     * Read from File. 
     * This version basically writes the studenID and testResult in a single text file.
     * This method uses Map as its input parameter.
     */ 	
	public void getTextFromFile (String filename)  {
		
		try 
		{
			BufferedReader input = null;
			String lineOutput = "";
			input = new BufferedReader(new FileReader(filename));
			while (input!= null) {
				lineOutput = input.readLine();
				System.out.println(lineOutput);
			}
			input.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
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