package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
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

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

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
    private int possibleTestMarks;
    private int totalMarksAwarded;
    public boolean isLocked = true;
    
    //Importing the classes below to write student result to text file.
    private PrintWriter printWriter; 
    private File file;
    
    private Map<Integer, Integer> mapWrite;
    private Map<Integer, Integer> mapRead;


    /**
     * Constructor for objects of class Test
     */
    public Test_(String testTitle, String testIntroText) 
    {
        this.testTitle = testTitle;
        this.testIntroText = testIntroText;
        sections = new ArrayList<Section>();
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
    
    public void setTestTitle(String title)
    {
        testTitle = title;
    }
    
    public String getTestTitle()
    {
        return testTitle;
    }
    
    public String getTestIntroText()
    {
        return testIntroText;
    }
    
    public void setTestIntroText(String introduction)
    {
        testIntroText=introduction;
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
        
    public void addSection(Section s)
    {
        sections.add(s);
        possibleTestMarks += s.getSectionTime();
    }
    
    /**
     * 
     * Removes a section from the test
     */
    public void removeSection(Section s)
    {
        sections.remove(s);
        possibleTestMarks -= s.getSectionTime();
    }
    
    public void insertSection(Section s, int index)
    {
        sections.set(index, s);
    }
    
    /**
     * @param SectionNum is an index for the required section, starting at 0.
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
     * This version basically reads the student results from a text file.
     * This method uses String filename as its input parameter.
     */ 	
	public void getTextFromFile (String filename)  {
		
		try 
		{
			BufferedReader input = null;
			String lineOutput = "";
			input = new BufferedReader(new FileReader(filename));
			mapRead = new HashMap<Integer, Integer>();
			
			while (input!= null) {
				lineOutput = input.readLine();
				int studentIDposition = lineOutput.indexOf('|'); 
				String studentID = lineOutput.substring(0,studentIDposition);  
				int studentIDint = Integer.parseInt(studentID);
				String studentResult = lineOutput.substring(lineOutput.lastIndexOf('|') + 1);
				int studentResultInt = Integer.parseInt(studentResult);
				System.out.println(lineOutput);
				
				mapRead.put(studentIDint, studentResultInt);
			}
			input.close();

			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}	
	
    /**
     *  Ends the test
     */
    public int endTest()
    {
        int marks = gradeTest(); // test can only be grade when it is ended
        isLocked = true; // it is then automatically locked
        return marks;
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
     * Swaps the order of the two given sessions
     * 
     */
    public void swapSection(Section s1, Section s2){
    	int positionS1 = 0;
    	int posistionS2 = 0;
    	for(int i=0; i<sections.size(); i++){
    		if(sections.get(i).equals(s1)){
    			positionS1 = i;
    		}
    		if(sections.get(i).equals(s2)){
    			posistionS2 = i;
    		}
    	}
    	sections.remove(positionS1);
    	sections.add(positionS1,s2);
    	sections.remove(posistionS2);
    	sections.add(posistionS2, s1);
    }
    
     /**
     * Demo for testing
     * 
     */
    public static Test_ getDemoTest()
    {
        Test_ t1 = new Test_("Welcome to the Mancunia English test",
            "This test is designed to test your English langauge skills. " +
            "Each section will test a different aspect of those skills.");
        MCQ q1 = new MCQ("If I don't study I _ the test.");
        Section s1 = new Section("Section A", "Grammar section...", 1);
        t1.addSection(s1);
        Section s2 = new Section("Section B", "Vocabulary section...", 30);
        t1.addSection(s2); 
        s1.addQuestion(q1);
        q1.addAnswer(new Answer("won't pass", true));
        q1.addAnswer(new Answer("wouldn't pass", false));
        q1.addAnswer(new Answer("wouldn't have passed", false));
        FIBQ q2 = null;
        try {
            q2 = new FIBQ("The students are trying to [catch] up with what the professor has taught. (catch)");
        }
        catch(InvalidFTBQFormatException e) {
        }
        s1.addQuestion(q2);
        FIBQ q3 = null;
        try {
            q3 = new FIBQ("I haven't done my homework [yet], said Johnny. (yet)");
        }
        catch(InvalidFTBQFormatException e) {
        }
        s1.addQuestion(q3);
        
        FIBQ q4 = null;
		try {
			q4 = new FIBQ("It's rainning cats and [dogs]. (dogs)");
		} catch (InvalidFTBQFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s2.addQuestion(q4);
		
		MCQ q5 = new MCQ("The _ ate my homework.");
		q5.addAnswer(new Answer("cat", false));
		q5.addAnswer(new Answer("dog", true));
		q5.addAnswer(new Answer("duck", false));
		s2.addQuestion(q5);
		
		MCQ q6 = new MCQ("It's a _ walk to go to the University.");
		q6.addAnswer(new Answer("15-minute", true));
		q6.addAnswer(new Answer("15-minutes", false));
		s2.addQuestion(q6);
				
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