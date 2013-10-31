package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import backend.*;

public class MCQTest {

	@Test
	public void testGetMarksAwarded() {
		MCQ mcq = new MCQ("This is a test question", null);
		int expResult = 0;
		assertEquals(expResult, mcq.getMarksAwarded());
	}

	@Test
	public void testGetAllAnswers() {
		ArrayList<Answer> testAnswer = new ArrayList<Answer>();
		MCQ mcq = new MCQ("This is a test question", testAnswer);
		ArrayList expResult = testAnswer;
		assertEquals(expResult, mcq.getAllAnswers());
	}

	@Test
	public void testToString() {
		MCQ mcq = new MCQ("This is a test question", null);
		String expResult = "MCQ ";
		assertEquals(expResult, mcq.toString());
	}

	@Test
	public void testGetQuestionText() {
		MCQ mcq = new MCQ("This is a test question", null);
		String expResult = "This is a test question";
		assertEquals(expResult, mcq.getQuestionText());
	}

	@Test
	public void testSetQuestionText() {
		MCQ mcq = new MCQ("This is a test question", null);
		mcq.setQuestionText("This is a different test question");
		String expResult = "This is a different test question";
		assertEquals(expResult, mcq.getQuestionText());
	}

	@Test
	public void testGetPossibleMarks() {
		MCQ mcq = new MCQ("This is a test question", 2, null);
		int expResult = 2;
		assertEquals(expResult, mcq.getPossibleMarks());
	}

	@Test
	public void testSetPossibleMarks() {
		MCQ mcq = new MCQ("This is a test question", null);
		mcq.setPossibleMarks(2);
		int expResult = 2;
		assertEquals(expResult, mcq.getPossibleMarks());
	}

	@Test
	public void testAddAnswer() {
		MCQ mcq = new MCQ("This is a test question", null);
		Answer testAnswer = new Answer("testAnswer", true);
		mcq.addAnswer(testAnswer);
		ArrayList<Answer> expResult = new ArrayList<Answer>();
		expResult.add(testAnswer);
		assertEquals(expResult, mcq.getAllAnswers());
	}


	/*
	@Test
	public void testSetAnswer() {
		Answer testAnswer = new Answer("testAnswer", true);
		MCQ mcq = new MCQ("This is a test question", testAnswer);
		mcq.setAnswer("a different answer", false, 0);
		Answer expResult = new Answer("a different answer", false);
		assertEquals(expResult, mcq.getIndexedAnswer(0));
		//TODO there is a bug in the implementation of this
	}
	*/

	@Test
	public void testGetIndexedAnswer() {
		Answer testAnswer = new Answer("testAnswer", true);
		MCQ mcq = new MCQ("This is a test question", testAnswer, null);
		Answer expResult = testAnswer;
		assertEquals(expResult, mcq.getIndexedAnswer(0));
	}

}
