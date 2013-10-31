package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backend.*;

public class SubsectionTest {
	
	@Test
	public void testSetSubsectionTitle() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		
		String expSubsectionTitle = "title2";
		expSubSection.setSubsectionTitle(expSubsectionTitle);
		
		assertEquals(expSubsectionTitle, expSubSection.getSubsectionTitle());
		
	}

	@Test
	public void testGetSubsectionTitle() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		
		String expSubsectionTitle = "title2";
		expSubSection.setSubsectionTitle(expSubsectionTitle);
		
		assertEquals(expSubsectionTitle, expSubSection.getSubsectionTitle());
		
	}

	@Test
	public void testAddQuestion() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		
		Question q1 = new MCQ ("question1", null);
		Question q2 = new MCQ ("question2", null);
		Question q3 = new MCQ ("question3", null);

		expSubSection.addQuestion(q1);
		expSubSection.addQuestion(q2);
		expSubSection.addQuestion(q3);
		
		assertEquals(q1, expSubSection.getContainer().get(0));	
		assertEquals(q2, expSubSection.getContainer().get(1));	
		assertEquals(q3, expSubSection.getContainer().get(2));
		
	}

	@Test
	public void testRemoveQuestion() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		
		Question q1 = new MCQ ("question1", null);
		Question q2 = new MCQ ("question2", null);

		expSubSection.addQuestion(q1);
		expSubSection.addQuestion(q2);
		
		assertEquals(q1, expSubSection.getContainer().get(0));	
		assertEquals(q2, expSubSection.getContainer().get(1));	
		
		expSubSection.removeQuestion(q2);

		assertEquals(q1, expSubSection.getContainer().get(0));
		assertEquals(1, expSubSection.getContainer().size());
		
		expSubSection.removeQuestion(q1);
		
		assertEquals(0, expSubSection.getContainer().size());

		
	}
	
	@Test
	public void testAddSubsection() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		
		Subsection s = new Subsection ("title1", null);
		
		expSubSection.addSubsection(s);
		
		assertEquals(1, expSubSection.getContainer().size());

	}
	
	@Test
	public void testRemoveSubsection() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		
		Subsection s = new Subsection ("title1", null);
		
		expSubSection.addSubsection(s);
		
		assertEquals(1, expSubSection.getContainer().size());
		assertEquals(s, expSubSection.getContainer().get(0));
		
		expSubSection.removeSubsection(s);
		
		assertEquals(0, expSubSection.getContainer().size());
		
		
	}
	
	/**
	 * Cannot initialize SubsectionContainer class since SubsectionContainer is an abstract class.
	 */
	@Test
	public void testisEmpty() {
		
		Subsection expSubSection = new Subsection ("title1", null);
				
		assertEquals(true, expSubSection.isEmpty());
		
		Subsection s = new Subsection ("title1", null);
		
		expSubSection.addSubsection(s);
		
		assertEquals(false, expSubSection.isEmpty());

		
	}
	

	@Test
	public void testhasQuestions() {
		
		Subsection expSubSection = new Subsection ("title1", null);

		assertEquals(false, expSubSection.hasQuestions());

		Subsection s = new Subsection ("title1", null);
		
		expSubSection.addSubsection(s);
		
		assertEquals(false, expSubSection.hasQuestions());
		
		expSubSection.removeSubsection(s);
		
		expSubSection.addQuestion(new MCQ("MCQ1", null));
		
		assertEquals(true, expSubSection.hasQuestions());		
		
	}

}
