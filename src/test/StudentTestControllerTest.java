package test;

import static org.junit.Assert.*;

import org.junit.Test;
import backend.*;

public class StudentTestControllerTest {

	@Test
	public void testGetTest() {
		StudentTestController stc = new StudentTestController();
		Test_ expResult = Test_.getDemoTest();
		assertEquals(expResult, stc.getTest());
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
