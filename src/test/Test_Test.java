package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backend.*;

public class Test_Test {

	@Test
	public void testSetTestTitle() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		ttest.setTestTitle("newTitle");
		String expResult = "newTitle";
		assertEquals(expResult, ttest.getTestTitle());
	}

	@Test
	public void testGetTestTitle() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		String expResult = "testTitle";
		assertEquals(expResult, ttest.getTestTitle());
	}

	@Test
	public void testGetTestIntroText() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		String expResult = "testIntro";
		assertEquals(expResult, ttest.getTestIntroText());
	}

	@Test
	public void testAddSection() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		Section testSection = new Section("sectionTitle", "sectionIntro", 1);
		ttest.addSection(testSection);
		Section expResult = testSection;
		assertEquals(expResult, ttest.getSection(0));
	}

	@Test
	public void testRemoveSection() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		Section testSection = new Section("sectionTitle", "sectionIntro", 1);
		ttest.addSection(testSection);
		Section expResult = testSection;
		assertEquals(expResult, ttest.getSection(0));
		
		ttest.removeSection(testSection);
		ArrayList<Section> expResult2 = new ArrayList<Section>();
		assertEquals(expResult2, ttest.getAllSections());
	}


	@Test
	public void testGetSection() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		Section testSection = new Section("sectionTitle", "sectionIntro", 1);
		ttest.addSection(testSection);
		Section expResult = testSection;
		assertEquals(expResult, ttest.getSection(0));
	}

	@Test
	public void testGetAllSections() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		Section testSection = new Section("sectionTitle", "sectionIntro", 1);
		ttest.addSection(testSection);
		ArrayList<Section> expResult = new ArrayList<Section>();
		expResult.add(testSection);
		assertEquals(expResult, ttest.getAllSections());
	}

	@Test
	public void testUnlockTest() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		boolean expResult = true;
		assertEquals(expResult, ttest.isLocked);
		
		ttest.unlockTest();
		expResult = false;
		assertEquals(expResult, ttest.isLocked);
	}

	@Test
	public void testEndTest() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		int expResultMark = 0;
		boolean expResultState = true;
		assertEquals(expResultMark, ttest.endTest());
		assertEquals(expResultState, ttest.isLocked);
	}

	@Test
	public void testToString() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		String expResult = "testTitle\n\ntestIntro\n";
		assertEquals(expResult, ttest.toString());
	}

	@Test
	public void testSwapSection() {
		Test_ ttest = new Test_("testTitle", "testIntro");
		Section testSection = new Section("testTitle", "testIntro", 1);
		Section testSection2 = new Section("testTitle2", "testIntro2", 2);
		ttest.addSection(testSection);
		ttest.addSection(testSection2);
		ArrayList<Section> expResult = new ArrayList<Section>();
		expResult.add(testSection);
		expResult.add(testSection2);
		assertEquals(expResult, ttest.getAllSections());
		
		ttest.swapSection(testSection, testSection2);
		expResult = new ArrayList<Section>();
		expResult.add(testSection2);
		expResult.add(testSection);
		assertEquals(expResult, ttest.getAllSections());
		
	}

}
