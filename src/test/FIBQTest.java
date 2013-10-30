package test;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.*;

public class FIBQTest
{

  @Test
  public final void testGetMarksAwarded() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test].", null);
    String testAnswer = "test";
    testfibq.setGivenAnswer(testAnswer);
    int expResult = 1;
    assertEquals(expResult, testfibq.getMarksAwarded());
  }

  @Test
  public final void testGetMarksAwarded2() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test].",null);
    String testAnswer = "test";
    testfibq.setGivenAnswer(testAnswer);
    testfibq.setPossibleMarks(2);
    int expResult = 2;
    assertEquals(expResult, testfibq.getMarksAwarded());
  }
  
  @Test
  public final void testGetMarksAwarded0() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test].",null);
    String testAnswer = "wrongAnswer";
    testfibq.setGivenAnswer(testAnswer);
    int expResult = 0;
    assertEquals(expResult, testfibq.getMarksAwarded());
  }
  
  @Test
  public final void testGetQFirstPart() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.",null);
    String expResult = "This is a ";
    assertEquals(expResult, testfibq.getQFirstPart());
  }

  @Test
  public final void testGetQFirstPartNone() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("[test] question.",null);
    String expResult = "";
    assertEquals(expResult, testfibq.getQFirstPart());
  }
  
  @Test
  public final void testGetQSecondPart() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    String expResult = " question.";
    assertEquals(expResult, testfibq.getQSecondPart());
  }
  
  @Test
  public final void testGetQSecondPartNone() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test]", null);
    String expResult = "";
    assertEquals(expResult, testfibq.getQSecondPart());
  }

  @Test
  public final void testSetGivenAnswer() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    String expResult = "";
    assertEquals(expResult, testfibq.getGivenAnswer());
    
    testfibq.setGivenAnswer("test");
    expResult = "test";
    assertEquals(expResult, testfibq.getGivenAnswer());
  }

  @Test
  public final void testGetGivenAnswer() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    String expResult = "";
    assertEquals(expResult, testfibq.getGivenAnswer());
  }

  @Test
  public final void testToString() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    String expResult = "This is a <BLANK> question.\n";
    assertEquals(expResult, testfibq.toString());
  }

  @Test (expected = InvalidFTBQFormatException.class)
  public final void testGetQuestionTextforThrowingInvalidFTBQFormatException() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("Fuck this question!", null);
    String expResult = "I'm fucked!";
    assertEquals(expResult, testfibq.getQuestionText());
  }
  
  

  @Test
  public final void testGetQuestionText() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    String expResult = "This is a [test] question.";
    assertEquals(expResult, testfibq.getQuestionText());
  }

  @Test
  public final void testSetQuestionText() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    String expResult = "This is a [test] question.";
    assertEquals(expResult, testfibq.getQuestionText());
    
    testfibq.setQuestionText("This is a different [test] question.");
    expResult = "This is a different [test] question.";
    assertEquals(expResult, testfibq.getQuestionText());
  }



  @Test
  public final void testGetPossibleMarks() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    int expResult = 1;
    assertEquals(expResult, testfibq.getPossibleMarks());
  }

  @Test
  public final void testSetPossibleMarks() throws InvalidFTBQFormatException
  {
    FIBQ testfibq = new FIBQ("This is a [test] question.", null);
    int expResult = 1;
    assertEquals(expResult, testfibq.getPossibleMarks());
    
    testfibq.setPossibleMarks(2);
    expResult = 2;
    assertEquals(expResult, testfibq.getPossibleMarks());
  }

}
