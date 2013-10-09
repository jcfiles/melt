package setter;

import java.util.ArrayList;
import java.util.HashMap;

import backend.Question;
import backend.Section;
import backend.Test_;

public class SetterTestController
{
	//HashMap
	static HashMap<String,ArrayList<Question>> all = new HashMap<String,ArrayList<Question>>();
	ArrayList<Section> section=new ArrayList<Section>();
	
	//
	int currentSection=1,currentQuestion=0;
  
  
  
  
  //Empty constructor
  public SetterTestController() {
	  
  }
  
  //Constructor  
 /* public SetterTestController(Test_ test, ArrayList<Question> questions) {
    super();
    this.test = test;
    this.questions = questions;
    
    noQuestions = questions.size();
  }
  */
  public void getTest(String title)
  {
    
  }
  
  public String setTest(String title)
  {
    
    return "";
  }
  
  public void getSection(String name, int time, int noQuestions, int marks, String instructions)
  {
    Section obj=new Section(name, instructions,time); 
    section.add(obj);
    all.put(name, null);
    
    
  }
  
  public ArrayList<String> setSection(int i){
    ArrayList<String> sectionList = new ArrayList<String>();
    
    sectionList.add(section.get(i-1).getSectionTitle());
    sectionList.add(section.get(i-1).getSectionIntroText());
    sectionList.add(section.get(i-1).getSectionTime()+"");
    
    return sectionList;
  }
  
  public void setCurrentSection(int section)
  {
	  currentSection=section;
  }
  
  public void setCurrentQuestion(int question)
  {
	  currentSection=question;
  }
  
  public int getCurrentSection()
  {
	  return currentSection;
  }
  
  public int getCurrentQuestion()
  {
	  return currentSection;
  }


}
