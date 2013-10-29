package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backend.*;

public class StudentAnswerTest {

	@Test
	public void testGetRightSlotAnswers() {
		
		ArrayList<String> exprightAnswers = new ArrayList<String> ();
		exprightAnswers.add("answer1");
		exprightAnswers.add("answer2");
		
		StudentAnswer sAnswer = new StudentAnswer(exprightAnswers);
		
		assertEquals(exprightAnswers, sAnswer.getRightSlotAnswers());
		
	}

	@Test
	public void testGetSlotAnswers() {
		
		ArrayList<String> exprightAnswers = new ArrayList<String> ();
		exprightAnswers.add("incorrectanswer1");
		exprightAnswers.add("answer2");
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswers(exprightAnswers);
		
		assertEquals(exprightAnswers, sAnswer.getSlotAnswers());
		
	}

	@Test
	public void testSetSlotAnswers() {
		
		ArrayList<String> exprightAnswers = new ArrayList<String> ();
		exprightAnswers.add("incorrectanswer1");
		exprightAnswers.add("answer2");
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswers(exprightAnswers);
		
		assertEquals(exprightAnswers, sAnswer.getSlotAnswers());
		
	}

	@Test
	public void testSetSlotAnswer() {
		
		String expSlotAnswer = "answer1";
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswer(expSlotAnswer, 0);
		
		assertEquals(expSlotAnswer, sAnswer.getSlotAnswer(0));	
		
	}

	@Test
	public void testGetSlotAnswer() {
		
		String expSlotAnswer = "answer1";
		
		StudentAnswer sAnswer = new StudentAnswer();
		sAnswer.setSlotAnswer(expSlotAnswer, 0);
		
		assertEquals(expSlotAnswer, sAnswer.getSlotAnswer(0));	
		
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

}
