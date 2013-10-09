package setter;

import java.util.ArrayList;

import backend.Question;
import backend.Test_;

public class SetterTestController
{
  //Required Variables
  Test_ test;
  ArrayList<Question> questions;
  int noQuestions;
  
  //Empty constructor
  public SetterTestController() {
	  
  }
  
  //Constructor  
  public SetterTestController(Test_ test, ArrayList<Question> questions) {
    super();
    this.test = test;
    this.questions = questions;
    
    noQuestions = questions.size();
  }
  
  public void getTest(String title)
  {
    
  }
  
  public String setTest(String title)
  {
    
    return "";
  }
  
  public void getSection(String name)
  {
    
  }
  
}
