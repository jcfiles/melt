package backend;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.*;

/**
 * 
 * @author Stefan Lesnjakovic
 *
 */

/*
 * This is a manually marked question
 */
public class SlotQ extends Question {

	StudentAnswer studentAnswer;
	//TODO ^ not sure if this is a good idea. it is definitely memory inefficient and less flexible (as every blank has a mark)
	//a different way to do this is to let StudentAnswer store a list of answers or to make a subclass of StudentAnswer for each type of manually marked question.
	
	ArrayList<String> expectedAnswers;
	String[] qParts; //stores the parts of the question that are not the answer
	


	public SlotQ(String questionText) throws InvalidSlotQFormatException {
		super(questionText);
		this.qParts = parseQtext(questionText);
		this.expectedAnswers = parseAtext(questionText);
		this.studentAnswer = new StudentAnswer();
	}

	/*
	 * this will parse the given answers out of the text and return the text snipets as an Array
	 * eg. "This [is] a [test] question." Should return a list with 3 elements: "This ", " a ", " question."
	 * 
	 */
	private String[] parseQtext(String questionText) throws InvalidSlotQFormatException
	{
		String filteredText[];
		//extract just the parts of the questions out of the questionText
		try {
			filteredText = questionText.split("\\[[^\\[]*\\]");
		} catch(IllegalArgumentException iae) {
			throw new InvalidSlotQFormatException();
		}
		
		//testing
		/*
		for(int i=0; i<filteredText.length; i++)
		{
			System.out.println(filteredText[i]);
		}
		*/
		return filteredText;
	}
	
	/*
	 * extract the answers out of the questionText using a pattern
	 * eg "This [is] a [test] question." Should return a list with 2 elements: "is", "test"
	 */
	private ArrayList<String> parseAtext(String questionText) throws InvalidSlotQFormatException
	{
		ArrayList<String> expectedAnswers = new ArrayList<String>();
		/*
		 * this will find any occurence of [ a-zA-Z0-9 ] in the text and just return the text inside the [] brackets
		 */
		Pattern pattern = Pattern.compile("(?<=\\[)[a-zA-Z0-9 ]*(?=\\])");
		Matcher matcher = pattern.matcher(questionText);
		
		boolean found = false;
		while (matcher.find())
		{
			expectedAnswers.add(matcher.group());
			found = true;
		}
		if(!found)
		{
			throw new InvalidSlotQFormatException();
		}
		
		return expectedAnswers;
		
	}
	/**
	 * Return a String[] which contains the parts of the question
	 * @return String[]
	 */
	public String[] getqParts() {
		return qParts;
	}
	
	/**
	 * Returns an arraylist of strings with what the setter has put into the blanks
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getExpectedAnswers() {
		return expectedAnswers;
	}

	//a total of all the individual blanks
	@Override
	protected int getMarksAwarded() {
		return studentAnswer.getMarksAwarded();
	}

	public ArrayList<String> getStudentAnswers() {
		return studentAnswer.getSlotAnswers();
	}
	
	public void setStudentAnswers(ArrayList<String> studentAnswers) {
		this.studentAnswer.setSlotAnswers(studentAnswers);
	}

	//setters for individual blanks. could also use above ^ although this might make things slightly simpler
	public void setStudentAnswer(String answer, int index) {
		this.studentAnswer.setSlotAnswer(answer, index);
	}
	
	public String getStudentAnswer(int index) {
		return this.studentAnswer.getSlotAnswer(index);
	}
	
	public void setStudentFeedback(String feedback) {
		this.studentAnswer.setFeedback(feedback);
	}
	
	public String getStudentFeedback(int index) {
		return this.studentAnswer.getFeedback();
	}
	
	public void setStudentMark(int mark) {
		this.studentAnswer.setMarksAwarded(mark);
	}
	
	public int getStudentMark() {
		return this.studentAnswer.getMarksAwarded();
	}
	
	public void setMarked(boolean marked) {
		this.studentAnswer.setMarked(marked);
	}
	
	public boolean isMarked() {
		return this.studentAnswer.isMarked();
	}

	/**
	 * Returns the slot question as a string replacing the missing words with "<BLANK>"
	 * @return String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(); //use the StringBuilder for efficiency
		for(int i = 0; i < qParts.length; i++)
		{
			sb.append(qParts[i]);
			
			if(i < (expectedAnswers.size())) //because we do not want <BLANK> after the last blank
				sb.append("<BLANK>");
		}	
		return sb.toString();
	}

	//functionality testing
	public static void main(String[] args) throws InvalidSlotQFormatException
	{
		SlotQ testq = new SlotQ("[afa]This [is] a test [question].");
		System.out.println(testq.toString());
		for(int i=0; i<testq.getqParts().length; i++)
		  System.out.println(testq.getqParts()[i]);
		System.out.println("the end");
		//SlotQ testq = new SlotQ("This (is) a (test) question.");
	}
	

}
