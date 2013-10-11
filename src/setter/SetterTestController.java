package setter;

import java.util.ArrayList;
import java.util.HashMap;

import backend.MCQ;
import backend.Section;
import backend.Test_;

public class SetterTestController
{
	//HashMap
	private static HashMap<String,ArrayList<MCQ>> all = new HashMap<String,ArrayList<MCQ>>();
	ArrayList<Section> section=new ArrayList<Section>();
	
	
	private int currentSection=1,currentQuestion=0;
	private Test_ test;
  	
  
  
  //Empty constructor
  public SetterTestController() {

  }
  
  public void createTest(String title)
  {
	  test=new Test_(title,"");
  }
  
  public void setTitle(String title)
  {
	  //
  }
  
  public void newSection()
  {
	  Section s=new Section("","",1);
	  test.addSection(s);
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
  
  public void setSection(String name, int time, int noQuestions, int marks, String instructions)
  {
    Section obj=new Section(name, instructions,time); 
    section.add(obj);
    all.put(name, null);
    
    
  }
  
  public ArrayList<String> getSection(int i){
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
	  currentQuestion=question;
  }
  
  public int getCurrentSection()
  {
	  return currentSection;
  }
  
  public int getCurrentQuestion()
  {
	  return currentQuestion;
  }


}
