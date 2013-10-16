package setter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import backend.Answer;
import backend.FIBQ;
import backend.InvalidFTBQFormatException;
import backend.MCQ;
import backend.Question;
import backend.Section;
import backend.Test_;

/*
 * @author Erotokritou Zoe
 */
public class SetterTestController
{
  private int currentSection=0,currentQuestion=0;
  private Test_ test;
    
  int k=0;
  
  //Empty constructor
  public SetterTestController() {

  }
  
  public void createTest(String title)
  {
	  if(test==null)
	  {test=new Test_(title,"");}
  }
  
  public void setTitle(String title)
  {
    test.setTestTitle(title);
    
    k=0;
  }
  
  public String getTitle()
  {
   return test.getTestTitle();
  }
  
  public void addSection(String sectionTitle, String sectionIntroText, int sectionTime)
  {
    Section s=new Section(sectionTitle,sectionIntroText,sectionTime);
    setCurrentSection(test.getAllSections().size());
    
    test.addSection(s);
  }
  
  public void editSection(String sectionTitle, String sectionIntroText, int sectionTime)
  {
	   /* Section s=new Section(sectionTitle,sectionIntroText,sectionTime);
	    s=test.getSection(currentSection);
	    
	    
	    test.addSection(s);
	    */
  }
  
  public void deleteSection()
  {
	  
  }
  
  public int countSection()
  {
	  ArrayList<Section> s=new ArrayList<Section>();
	  
	  if(test!=null)
	  {
		  s=test.getAllSections();
		  return s.size();
	  
	  }
	  else
	  {
		  return 0;
	  }	  
  }
  
  public int countQuestion()
  {
	  ArrayList<Section> s=new ArrayList<Section>();
	  ArrayList<Question> q=new ArrayList<Question>();	  
	  
	  if(test!=null)
	  {
		  q=test.getSection(currentSection).getQuestionsList();
		  return q.size();
	  
	  }
	  else
	  {
		  return 0;
	  }	  
  }
  
  public ArrayList<String> getSection()
  {
	  int marks=0;
	  ArrayList<String> s=new ArrayList<String>();
	  ArrayList<Question> q=new ArrayList<Question>();
	  q=test.getSection(currentSection).getQuestionsList();
	  
	  for(int i=0; i<q.size(); i++)
	  {
		  marks=marks+q.get(i).getPossibleMarks();
	  }
	  
	  s.add(test.getSection(currentSection).getSectionTitle());
	  s.add(test.getSection(currentSection).getSectionTime()+"");
	  s.add(q.size()+"");
	  s.add(marks+"");
	  s.add(test.getSection(currentSection).getSectionIntroText());
	
	  return s;
  }
  
  
  public int addFTBQ(String subsection, String question, int marks)
  {
	  setCurrentQuestion(test.getSection(currentSection).getQuestionsList().size());
    try {
		FIBQ q=new FIBQ(question);
		q.setPossibleMarks(marks);
		q.setSubsectionTitle(subsection);
		test.getSection(currentSection).addQuestion(q);
		
	} catch (InvalidFTBQFormatException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		return 0;
	}
    
    return 1;
  }
  
  
  public void addMCQ(String section, String question, int marks, JTable possibleAnswers)
  {
	  setCurrentQuestion(test.getSection(currentSection).getQuestionsList().size());
	  
	  MCQ q=new MCQ(question);
	  q.setSubsectionTitle(section);
	  q.setPossibleMarks(marks);
	  
	  for(int i=0; i<possibleAnswers.getRowCount(); i++)
	  {
		  String s=possibleAnswers.getValueAt(i, 0).toString();
		  String img=possibleAnswers.getValueAt(i, 1).toString();
		  
		  if(img.contains("check"))
		  {
			  q.setAnswer(s,true,i);
		  }
		  else
		  {
			  q.setAnswer(s,false,i);
		  }
		  
		 // q.setAnswer(possibleAnswers.getValueAt(i, 0).toString(), new Boolean(possibleAnswers.getValueAt(i, 1).toString()), i);
	  }
	  
	  test.getSection(currentSection).addQuestion(q);
	  
	  k=9;
  }
  
  public int getQuestionType()
  {
	  ArrayList<String> s=new ArrayList<String>();
	  ArrayList<Answer> a=new ArrayList<Answer>();
	  Question q=test.getSection(currentSection).getQuestion(currentQuestion);
  
	  if (q instanceof FIBQ)
	  {		  		
		  return 1;
	  }
	  else if(q instanceof MCQ)
	  {
		  return 0;
	  }
	  return 0;
  }
  
  public ArrayList<String> getQuestion()
  {
	  ArrayList<String> s=new ArrayList<String>();
	  ArrayList<Answer> a=new ArrayList<Answer>();
	  Question q=test.getSection(currentSection).getQuestion(currentQuestion);
	  
	  s.add(q.getPossibleMarks()+"");
	  s.add("Subsection");
	  
	  if (getQuestionType()==1)
	  {		  
		  s.add(((FIBQ) q).getQFirstPart());
		  s.add(((FIBQ) q).getQSecondPart());		  
	  }
	  else 
	  {
		  s.add(q.getQuestionText());
		  a=((MCQ) q).getAllAnswers();
		  
		  for(int i=0; i<a.size(); i++)
		  {
			  s.add(a.get(i).getAnswerText());
		  }
		  
	  }
	  
	  return s;
  }

  
  public String getCurrertSectionTitle()
  {
    return test.getSection(currentSection).getSectionTitle();

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
