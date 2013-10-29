package test;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.*;

public class EssayQTest {

	@Test
	/**
	 * testGetMarksAwarded cannot initialize methods ending EssayQ.studentAnswer.setMarksAwarded(3) 
	 * because EssayQ.studentAnswer is not public, i.e. StudentAnswer studentAnswer;
	 */
	
	public void testGetMarksAwarded() {
		StudentAnswer testStudentAnswer = new StudentAnswer ("answer1", "answer2");
		int expMarks = 2;
		testStudentAnswer.setMarksAwarded(expMarks);
		assertEquals(expMarks, testStudentAnswer.getMarksAwarded());
	}

	@Test
	public void testgetMaxWords() {
		
		int expMaxWords = 3;
		EssayQ testEssayQ = new EssayQ ("questionText1", expMaxWords, 3, null);
		assertEquals(expMaxWords, testEssayQ.getMaxWords());
		
	}
	
	public void testsetMaxWords() {
		
		int expMaxWords = 3;
		EssayQ testEssayQ = new EssayQ ("questionText1", null);
		testEssayQ.setMaxWords(3);
		assertEquals(expMaxWords, testEssayQ.getMaxWords());
		
	}
	
	@Test
	public void testgetStudentAnswer() {
		String answer1 = "answer1";
		EssayQ testEssayQ = new EssayQ ("questionText1", null);
		testEssayQ.setStudentAnswer(answer1);
		assertEquals(answer1, testEssayQ.getStudentAnswer());
	}
	
	@Test
	public void testsetStudentAnswer() {
		String answer2 = "answer2";
		EssayQ testEssayQ = new EssayQ ("questionText1", null);
		testEssayQ.setStudentAnswer(answer2);
		assertEquals(answer2, testEssayQ.getStudentAnswer());
	}

	@Test
	public void testGetMaxWords() {
		int expMaxWords = 250;
		EssayQ testEssayQ = new EssayQ ("questionText1", null);
		testEssayQ.setMaxWords(expMaxWords);
		assertEquals(expMaxWords, testEssayQ.getMaxWords());
	}

	@Test
	public void testSetMaxWords() {
		int expMaxWords = 250;
		EssayQ testEssayQ = new EssayQ ("questionText1", null);
		testEssayQ.setMaxWords(expMaxWords);
		assertEquals(expMaxWords, testEssayQ.getMaxWords());	
	}


}
