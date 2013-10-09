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
  
  //Constructor  
  public SetterTestController(Test_ test, ArrayList<Question> questions) {
    super();
    this.test = test;
    this.questions = questions;
    
    noQuestions = questions.size();
  }
  
  
  

  
}
