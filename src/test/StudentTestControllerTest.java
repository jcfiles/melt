package test;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.*;

public class StudentTestControllerTest {

	@Test
	public void testGetTest() {
		StudentTestController stc = new StudentTestController();
		Test_ expResult;
		try {
			expResult = Test_.getDemoTest2();
			assertEquals(expResult, stc.getTest());
		} catch (InvalidSlotQFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testStartSection() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndTest() {
		fail("Not yet implemented");
	}

}
