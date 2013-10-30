package test;

import static org.junit.Assert.*;

import javax.swing.JTable;

import org.junit.Test;

import setter.*;
import backend.*;

public class SetterTestControllerTest {

	@Test
	public final void testCreateTest() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		String expResult = "testTitle";
		assertEquals(expResult, stc.getTitle());
	}

	@Test
	public final void testSetTitle() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		stc.setTitle("newTitle");
		String expResult = "newTitle";
		assertEquals(expResult, stc.getTitle());
	}

	@Test
	public final void testGetTitle() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		String expResult = "testTitle";
		assertEquals(expResult, stc.getTitle());
	}

	@Test
	public final void testCountSection() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		int expResult = 0;
		assertEquals(expResult, stc.countSection());
		
		stc.addSection("sectionTitle", "sectionIntro", 1);
		expResult = 1;
		assertEquals(expResult, stc.countSection());
	}

	/****** From here **********/
	/*
	@Test
	public final void testCountQuestion() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		stc.addSection("sectionTitle", "sectionIntro", 1);
		int expResult = 0;
		assertEquals(expResult, stc.countQuestion());
		
		stc.addFIBQ("A", "This is a [test] question.", 1);
		expResult = 1;
		assertEquals(expResult, stc.countQuestion());
	}

	@Test
	public final void testAddFIBQ() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		stc.addSection("sectionTitle", "sectionIntro", 1);
		int expResult = 1;
		assertEquals(expResult, stc.addFIBQ("A", "This is a [test] question.", 1));
	}

	@Test
	public final void testEditFIBQ() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		stc.addSection("sectionTitle", "sectionIntro", 1);
		int expResult = 0;
		stc.addFIBQ("A", "This is a [test] question.", 1);
		assertEquals(expResult, stc.editFIBQ("A", "Test question.", 1));
		
		expResult = 1;
		assertEquals(expResult, stc.editFIBQ("A", "A [Test] question.", 1));
	}
	/*
	@Test
	public final void testAddMCQ() {
		fail("Not yet implemented");
	}

	@Test
	public final void testEditMCQ() {
		fail("Not yet implemented");
	}
	/
	@Test
	public final void testGetQuestionType() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		stc.addSection("sectionTitle", "sectionIntro", 1);
		stc.addFIBQ("A", "This is a [test] question.", 1);
		int expResult = 1;
		assertEquals(expResult, stc.getQuestionType());
	}
	
	*/
	/****** to here **********/
	
	
	
	/*
	@Test
	public final void testGetQuestion() {
		fail("Not yet implemented");
	}
	
	@Test
	public final void testGetCurrertSectionTitle() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		stc.addSection("sectionTitle", "sectionIntro", 1);
		String expResult = "sectionTitle";
		assertEquals(expResult, stc.getCurrertSectionTitle());
	}

	@Test
	public final void testSetCurrentSection() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		int expResult = 0;
		assertEquals(expResult, stc.getCurrentSection());
		
		stc.setCurrentSection(1);
		expResult = 1;
		assertEquals(expResult, stc.getCurrentSection());
	}

	@Test
	public final void testSetCurrentQuestion() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		int expResult = 0;
		assertEquals(expResult, stc.getCurrentQuestion());
		
		stc.setCurrentQuestion(1);
		expResult = 1;
		assertEquals(expResult, stc.getCurrentQuestion());
	}

	@Test
	public final void testGetCurrentSection() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		int expResult = 0;
		assertEquals(expResult, stc.getCurrentSection());
	}

	@Test
	public final void testGetCurrentQuestion() {
		SetterTestController stc = new SetterTestController();
		stc.createTest("testTitle");
		int expResult = 0;
		assertEquals(expResult, stc.getCurrentQuestion());
	}
	*/
}
