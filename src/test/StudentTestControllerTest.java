package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import backend.*;

public class StudentTestControllerTest {

	@Test
	public void testsetTest() {
		
		StudentTestController stc = new StudentTestController();
		
		Test_ expTest = new Test_();
		stc.setTest(expTest);
		assertEquals(expTest, stc.getTest());		
		
	}

	@Test
	public void testgetTest() {
		
		StudentTestController stc = new StudentTestController();
		Test_ expTest = new Test_();
		stc.setTest(expTest);
		assertEquals(expTest, stc.getTest());
			// TODO Auto-generated catch block
		
	}
	

}
