package test;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.*;

public class AnswerTest
{

  @Test
  public final void testGetAnswerText()
  {
    Answer testAnswer = new Answer ("testText", true);
    String expResult = "testText";
    
    assertEquals(expResult, testAnswer.getAnswerText());
  }

  @Test
  public final void testSetIsCorrect()
  {
    Answer testAnswer = new Answer ("testText", true);
    boolean expResult = true;
    assertEquals(expResult, testAnswer.getIsRight());
    
    testAnswer.setIsCorrect(false);
    expResult = false;
    
    assertEquals(expResult, testAnswer.getIsRight());
  }

  @Test
  public final void testGetIsRight()
  {
    Answer testAnswer = new Answer ("testText", true);
    boolean expResult = true;
    assertEquals(expResult, testAnswer.getIsRight());
    
    Answer testAnswerFalse = new Answer("testTextFalse", false);
    expResult = false;
    assertEquals(expResult, testAnswerFalse.getIsRight());
  }

  @Test
  public final void testSelect()
  {
    Answer testAnswer = new Answer ("testText", true);
    boolean expResult = false;
    assertEquals(expResult, testAnswer.getIsSelected()); //expect the answer to be initially unselected
    
    //select the answer
    testAnswer.select();
    expResult = true;
    assertEquals(expResult, testAnswer.getIsSelected());
  }

  @Test
  public final void testDeSelect()
  {
    Answer testAnswer = new Answer ("testText", true);
    boolean expResult = false;
    assertEquals(expResult, testAnswer.getIsSelected()); //expect the answer to be initially unselected
    
    //select the answer
    testAnswer.select();
    expResult = true;
    assertEquals(expResult, testAnswer.getIsSelected());
    
    //deselect answer
    testAnswer.deSelect();
    expResult = false;
    assertEquals(expResult, testAnswer.getIsSelected());
  }

  @Test
  public final void testGetIsSelected()
  {
    Answer testAnswer = new Answer ("testText", true);
    boolean expResult = false;
    assertEquals(expResult, testAnswer.getIsSelected()); //expect the answer to be initially unselected
  }

  @Test
  public final void testToString()
  {
    Answer testAnswer = new Answer ("testText", true);
    String expResult = "testText";
    assertEquals(expResult, testAnswer.toString()); //expect the answer to be initially unselected
  }

}
