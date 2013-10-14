package setter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import setter.AddQuestionPanel.MyTableModel;
import backend.Answer;
import backend.FTBQ;
import backend.InvalidFTBQFormatException;
import backend.MCQ;
import backend.Question;
import backend.Section;
import backend.Test_;

public class SetterTestController
{
  //HashMap
  private static HashMap<String,ArrayList<MCQ>> all = new HashMap<String,ArrayList<MCQ>>();
  ArrayList<Section> section=new ArrayList<Section>();
  
  
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
	    Section s=new Section(sectionTitle,sectionIntroText,sectionTime);
	    s=test.getSection(currentSection);
	    
	    
	    test.addSection(s);
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
  
  
  public void addFTBQ(String subsection, String question, int marks)
  {
	  setCurrentQuestion(test.getSection(currentSection).getQuestionsList().size());
    try {
		FTBQ q=new FTBQ(question);
		q.setPossibleMarks(marks);
		q.setSubsectionTitle(subsection);
		test.getSection(currentSection).addQuestion(q);
		
	} catch (InvalidFTBQFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		//re-enter the text
	}
    
  }
  
  
  public void addMCQ(String section, String question, int marks, JTable possibleAnswers)
  {
	  setCurrentQuestion(test.getSection(currentSection).getQuestionsList().size());
	  
	  MCQ q=new MCQ(question);
	  q.setSubsectionTitle(section);
	  q.setPossibleMarks(marks);
	  
	  for(int i=0; i<possibleAnswers.getRowCount(); i++)
	  {
		  q.setAnswer(possibleAnswers.getValueAt(i, 0).toString(), new Boolean(possibleAnswers.getValueAt(i, 1).toString()), i);
	  }
  }
  
  public ArrayList<String> getQuestion()
  {
	  ArrayList<String> s=new ArrayList<String>();
	  ArrayList<Answer> a=new ArrayList<Answer>();
	  Question q=test.getSection(currentSection).getQuestion(currentQuestion);
	  
	  s.add(q.getPossibleMarks()+"");
	  s.add("Subsection");
	  
	  if (q instanceof FTBQ)
	  {		  
		  s.add(((FTBQ) q).getQFirstPart());
		  s.add(((FTBQ) q).getQSecondPart());		  
	  }
	  else if(q instanceof MCQ)
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
    return test.getSection(currentSection).toString();

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
