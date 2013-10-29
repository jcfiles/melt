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

	/**
	 * Error: Cannot initialize Question - Question expQ = new Question ("questiontext1", o);
	 */
	
	
	@Test
	public void testGetContainer() {
		
		Subsection expSubSection = new Subsection ("title1", null);
//		expSubSection.addQuestion(new Question("question1", null));
		
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
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveQuestion() {
		fail("Not yet implemented");
	}
	
	/**
	 * Cannot initialize SubsectionContainer class since SubsectionContainer is an abstract class.
	 */
	@Test
	public void testAddSubsection() {
		
		Subsection expSubSection = new Subsection ("title1", null);
		expSubSection.addSubsection(new Subsection ("title1", null));
/**		
		ArrayList<SubsectionContainer> expSubsectionContainerArrayList = new ArrayList<SubsectionContainer>();
		
		SubsectionContainer expSubsectionContainer = new SubsectionContainer(null);
		expSubsectionContainerArrayList.add(new SubsectionContainer(null));
		
		assertEquals(expSubsectionTitle, expSubSection.getContainer());
**/

	}
	
	/**
	 * Cannot initialize SubsectionContainer class since SubsectionContainer is an abstract class.
	 */
	@Test
	public void testRemoveSubsection() {
		fail("Not yet implemented");
	}
	
	/**
	 * Cannot initialize SubsectionContainer class since SubsectionContainer is an abstract class.
	 */
	@Test
	public void testisEmpty() {
		fail("Not yet implemented");
	}
	
	/**
	 * Cannot initialize SubsectionContainer class since SubsectionContainer is an abstract class.
	 */
	@Test
	public void testhasQuestions() {
		fail("Not yet implemented");
	}

}
