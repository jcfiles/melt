package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import backend.*;

public class SectionTest {

	@Test
	public void testEditSection() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		testSection.editSection("newTitle", "newIntro", 2);
		Section expResult = new Section("newTitle", "newIntro", 2);
		assertEquals(expResult.getSectionTitle(), testSection.getSectionTitle());
		assertEquals(expResult.getSectionIntroText(), testSection.getSectionIntroText());
		assertEquals(expResult.getSectionTime(), testSection.getSectionTime());
	}

	@Test
	public void testGetSectionTitle() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		String expResult = "testTitle";
		assertEquals(expResult, testSection.getSectionTitle());
	}

	@Test
	public void testGetSectionIntroText() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		String expResult = "testIntro";
		assertEquals(expResult, testSection.getSectionIntroText());
	}

	@Test
	public void testGetSectionTime() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		int expResult = 1;
		assertEquals(expResult, testSection.getSectionTime());
	}

	@Test
	public void testGetPossibleSectionMarks() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		int expResult = 0;
	//	assertEquals(expResult, testSection.getPossibleSectionMarks());
	}

	@Test
	public void testgetContainer() throws InvalidFTBQFormatException {
		Section testSection = new Section("testTitle", "testIntro", 1);
		FIBQ fibq = new FIBQ("This is a [test] question.", null);
		testSection.addQuestion(fibq);
		ArrayList<SubsectionContainer> expResult = new ArrayList<SubsectionContainer>();
		expResult.add(fibq);
		assertEquals(expResult, testSection.getContainer());
	}

	@Test
	public void testRemoveQuestion() throws InvalidFTBQFormatException {
		Section testSection = new Section("testTitle", "testIntro", 1);
		FIBQ fibq = new FIBQ("This is a [test] question.", null);
		testSection.addQuestion(fibq);
		ArrayList<Question> expResult = new ArrayList<Question>();
		testSection.removeQuestion(fibq);
		assertEquals(expResult, testSection.getQuestions());
	}

	@Test
	public void testGradeSection() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		int expResult = 0;
		assertEquals(expResult, testSection.gradeSection());
	}

	@Test
	public void testToString() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		String expResult = "testTitle";
		assertEquals(expResult, testSection.toString());
	}

	@Test
	public void testLockSection() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		boolean expResult = false;
		assertEquals(expResult, testSection.isLocked());
		testSection.lockSection();
		expResult = true;
		assertEquals(expResult, testSection.isLocked());
	}

	@Test
	public void testIsLocked() {
		Section testSection = new Section("testTitle", "testIntro", 1);
		boolean expResult = false;
		assertEquals(expResult, testSection.isLocked());
	}

}
