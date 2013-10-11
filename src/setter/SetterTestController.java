package setter;

import java.util.ArrayList;
import java.util.HashMap;

import backend.MCQ;
import backend.Question;
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
    test.setTestTitle(title);
  }
  
  public String getTitle()
  {
   return test.getTestTitle();
  }
  
  public void addSection(String sectionTitle, String sectionIntroText, int sectionTime)
  {
    Section s=new Section(sectionTitle,sectionIntroText,sectionTime);
    test.addSection(s);
  }
  
  public void addFBI(String section)
  {
    
  }
  
  public void addMC(String section)
  {
    
  }

  
  
  /*

  public void getTest(String title)
  {
    
  }
  
  public String setTest(String title)
  {
    
    return "";
  }
  
 /* public void setSection(String name, int time, int noQuestions, int marks, String instructions)

  {
    Section obj=new Section(name, instructions, subsection, time); 
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
  */
  public int  getCurrertSectionTitle()
  {
    test.getSection(currentSection);
    
    return 0;
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
