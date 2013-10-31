package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backend.*;

public class SlotQTest {


	@Test
	public void testGetqParts() throws InvalidSlotQFormatException {
		
		SlotQ testSlotQ = new SlotQ("This [is] a [test] question.", null);
		
		String [] expqParts = new String[3];
		expqParts[0] = "This ";
		expqParts[1] = " a ";
		expqParts[2] = " question.";

		assertEquals(expqParts, testSlotQ.getqParts());
	}
	
	@Test
	public void testGetqParts2() throws InvalidSlotQFormatException {
		
		SlotQ testSlotQ = new SlotQ("[test]This [is] a [test] question[test].", null);
		
		String [] expqParts = new String[5];
		expqParts[0] = "";
		expqParts[1] = "This ";
		expqParts[2] = " a ";
		expqParts[3] = " question";
		expqParts[4] = ".";

		assertEquals(expqParts, testSlotQ.getqParts());
		
		
		
	}
	
	@Test
	public void testGetqParts3() throws InvalidSlotQFormatException {
		
		SlotQ testSlotQ = new SlotQ("[test]This [is] a [test] question[test]", null);
		
		String [] expqParts = new String[4];
		expqParts[0] = "";
		expqParts[1] = "This ";
		expqParts[2] = " a ";
		expqParts[3] = " question";

		assertEquals(expqParts, testSlotQ.getqParts());
		
		
		
	}

	@Test
	public void testGetExpectedAnswers() throws InvalidSlotQFormatException {

		SlotQ testSlotQ = new SlotQ("This [is] a [test] question.", null);
		ArrayList<String> expexpectedAnswers = new ArrayList<String>();
		expexpectedAnswers.add("is");
		expexpectedAnswers.add("test");
		
		assertEquals(expexpectedAnswers, testSlotQ.getExpectedAnswers());
		
	}

	@Test
	public void testGetExpectedAnswers2() throws InvalidSlotQFormatException {

		SlotQ testSlotQ = new SlotQ("This [is] a [test] question[test]", null);
		ArrayList<String> expexpectedAnswers = new ArrayList<String>();
		expexpectedAnswers.add("is");
		expexpectedAnswers.add("test");
		expexpectedAnswers.add("test");
		
		assertEquals(expexpectedAnswers, testSlotQ.getExpectedAnswers());
		
	}

	
	@Test
	public void testGetStudentAnswers() throws InvalidSlotQFormatException {
		
		ArrayList<String> exprightAnswers = new ArrayList<String>();
		exprightAnswers.add("123");
		exprightAnswers.add("456");
		
		StudentAnswer sAnswer = new StudentAnswer(exprightAnswers);

		assertEquals(exprightAnswers, sAnswer.getRightSlotAnswers() );
		
	}

	@Test
	public void testSetStudentAnswers() {
		
		ArrayList<String> expslotAnswers = new ArrayList<String>();
		expslotAnswers.add("is");
		expslotAnswers.add("a");
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswers(expslotAnswers);
		
		assertEquals(expslotAnswers, sAnswer.getSlotAnswers());	
		

	}

	@Test
	public void testSetStudentAnswer() {
		
		String answer1 = "is";
		String answer2 = "a";
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswer(answer1, 0);
		sAnswer.setSlotAnswer(answer2, 1);		
		
		assertEquals(answer1, sAnswer.getSlotAnswers().get(0));
		assertEquals(answer2, sAnswer.getSlotAnswers().get(1));

	}

	@Test
	public void testGetStudentAnswer() {
		
		String answer1 = "is";
		String answer2 = "a";
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswer(answer1, 0);
		sAnswer.setSlotAnswer(answer2, 1);		
		
		assertEquals(answer1, sAnswer.getSlotAnswer(0));
		assertEquals(answer2, sAnswer.getSlotAnswer(1));
		
	}

	@Test
	public void testSetStudentFeedback() {
		
		StudentAnswer sAnswer = new StudentAnswer();
		String feedback1 = "Good!";
		sAnswer.setFeedback(feedback1);
		
		assertEquals(feedback1, sAnswer.getFeedback());
		
	}

	@Test
	public void testGetStudentFeedback() {
		
		StudentAnswer sAnswer = new StudentAnswer();
		String expfeedback1 = "Good!";
		sAnswer.setFeedback(expfeedback1);
		
		assertEquals(expfeedback1, sAnswer.getFeedback());	
		
	}

	@Test
	public void testSetStudentMark() {
		
		StudentAnswer sAnswer = new StudentAnswer();
		int expMarks = 1;
		sAnswer.setMarksAwarded(expMarks);
		
		assertEquals(expMarks, sAnswer.getMarksAwarded() );	
		
	}

	@Test
	public void testGetStudentMark() {
		
		StudentAnswer sAnswer = new StudentAnswer();
		int expMarks = 1;
		sAnswer.setMarksAwarded(expMarks);
		
		assertEquals(expMarks, sAnswer.getMarksAwarded() );	
		
	}

	@Test
	public void testSetMarked() {

		StudentAnswer sAnswer = new StudentAnswer();
		boolean expisMarked = true;
		sAnswer.setMarked(expisMarked);
		
		assertEquals(expisMarked, sAnswer.isMarked() );	

	}

	@Test
	public void testIsMarked() {

		StudentAnswer sAnswer = new StudentAnswer();
		boolean expisMarked = true;
		sAnswer.setMarked(expisMarked);
		
		assertEquals(expisMarked, sAnswer.isMarked() );	

	}

	/** Can someone help me with this?
	 * 
	 * @throws InvalidSlotQFormatException
	 */
	@Test
	public void testgetSlotQ() throws InvalidSlotQFormatException {
		
		SlotQ testSlotQ = new SlotQ("This [is] a [test] question.", null);
		String exptoString = "This <BLANK> a <BLANK> question.";
		
		assertEquals(exptoString, testSlotQ.getSlotQ());
		
	}
	
	/** Can someone help me with this?
	 * 
	 * @throws InvalidSlotQFormatException
	 */
	@Test
	public void testToString() throws InvalidSlotQFormatException {
		
		SlotQ testSlotQ = new SlotQ("This [is] a [test] question.", "1", null);
		String exptoString = "SlotQ 1";
		
		assertEquals(exptoString, testSlotQ.toString());
		
	}

}
