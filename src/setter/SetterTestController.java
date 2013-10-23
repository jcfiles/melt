package setter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import student.MainGui;
import student.TestSectionPanel;
import backend.Answer;
import backend.FIBQ;
import backend.InvalidFTBQFormatException;
import backend.MCQ;
import backend.Question;
import backend.Section;
import backend.StudentTestController;
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
	  test=new Test_("","");
  }
  
  /**
   * Create Test with the name
   */
  public void createTest(String title, String introduction)
  {
	  if(test==null)
	  {test=new Test_(title,introduction);}
	  else
	  {
		  setTitle(title);
		  setIntroduction(introduction);
	  }
  }
  
  public void createTest(String title)
  {
	  if(test==null)
	  {test=new Test_(title,"");}
  }
  
  public void deleteTest()
  {
	  test=new Test_("","");
  }
  
  public void setTitle(String title)
  {
    test.setTestTitle(title);
  }
  
  public void setIntroduction(String intro)
  {
	  test.setTestIntroText(intro);
  }
  
  public String getTitle()
  {
   return test.getTestTitle();
  }
  
  public String getIntroduction()
  {
	  return test.getTestIntroText();
  }
  
  /**
   * Add a Section in the test
   */
  public void addSection(String sectionTitle, String sectionIntroText, int sectionTime)
  {
    Section s=new Section(sectionTitle,sectionIntroText,sectionTime);
    setCurrentSection(test.getAllSections().size());
    
    test.addSection(s);
  }
  
  /**
   * Edit a section in the test
   */
  public void editSection(String sectionTitle, String sectionIntroText, int sectionTime)
  {
	    Section s=test.getSection(currentSection);
	    s.editSection(sectionTitle, sectionIntroText, sectionTime);
  }


  /**
   * Delete a section in the test
   */
  public void deleteSection()
  {
	  Section s=test.getSection(currentSection);
	  test.removeSection(s);
  }
  
  /**
   * Delete a question in the test
   */
  public void deleteQuestion()
  {
	  Section s=test.getSection(currentSection);
	  Question q=s.getQuestion(currentQuestion);
	  
	  s.removeQuestion(q);
  }
  
  /**
   * Counts how many Sections are in the test
   */
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
  
  /**
   * Counts how many Questions are in the test
   */
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
  
  /**
   * Return the current Section with the user is in with all the information
   */
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
  
  
  /**
   * Add a Fill Blank Question in the Section of the test
   */
  public int addFIBQ(String subsection, String question, int marks)
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
  
  /**
   * Edit the current Fill Blank Question
   */
  public int editFIBQ(String subsection, String question, int marks)
  {
	  Section s=test.getSection(currentSection);
	  FIBQ q=(FIBQ) s.getQuestion(currentQuestion);
	  String[] parts=new String[3];
	  
	  try {
			q.checkQuestion(question);
			
		} catch (InvalidFTBQFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			return 0;
		}
	  
	  q.setSubsectionTitle(subsection);
	  q.setQuestionText(question);
	  q.setPossibleMarks(marks);
	  
	  return 1;
  }
  
  /**
   * Add a Fill Blank Question in the Section of the test
   */
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
		  
	  }
	  
	  test.getSection(currentSection).addQuestion(q);

  }
  
  /**
   * Edit the current Multiplechoice Question
   */
  public void editMCQ(String section, String question, int marks, JTable possibleAnswers)
  {	  
	  MCQ q=(MCQ) test.getSection(currentSection).getQuestion(currentQuestion);
	  
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
	  }
  }
  
  /**
   * Return the current Question with the user is in with all the information
   */
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
  
  /**
   * Edit the current Fill Blank Question
   */
  public ArrayList<String> getQuestion()
  {
	  ArrayList<String> s=new ArrayList<String>();
	  ArrayList<Answer> a=new ArrayList<Answer>();
	  Question q=test.getSection(currentSection).getQuestion(currentQuestion);
	  
	  s.add(q.getPossibleMarks()+"");
	  s.add(q.getsubSectionTitle());
	  
	  if (getQuestionType()==1)
	  {		  
		  FIBQ f=(FIBQ) q;
		  s.add(((FIBQ) q).getQFirstPart());
		  Answer an=f.getIndexedAnswer(0);
		  s.add(an.getAnswerText());
		  s.add(((FIBQ) q).getQSecondPart());	
	  }
	  else 
	  {
		  s.add(q.getQuestionText());
		  a=((MCQ) q).getAllAnswers();
		  
		  for(int i=0; i<a.size(); i++)
		  {
			  s.add(a.get(i).getAnswerText());
			  s.add(a.get(i).getIsRight()+"");
		  }
		  
	  }
	  
	  return s;
  }

  
  /**
   * Returns the current section title
   */
  public String getCurrertSectionTitle()
  {
    return test.getSection(currentSection).getSectionTitle();

  }
  
  /**
   * Sets the current section number
   */
  public void setCurrentSection(int section)
  {
    currentSection=section;
  }
  
  /**
   * Sets the current question number
   */
  public void setCurrentQuestion(int question)
  {
    currentQuestion=question;
  }
  
  /**
   * Returns the current Section
   */
  public int getCurrentSection()
  {
    return currentSection;
  }
  
  /**
   * Returns the current queston
   */
  public int getCurrentQuestion()
  {
    return currentQuestion;
  }
  
  public void previewQuestion(){
	  
	  Section section=test.getSection(currentSection);
	  Question question=section.getQuestion(currentQuestion);
	  
	  StudentTestController studentTestController = new StudentTestController();
	  studentTestController.setTest(test);
	  MainGui.isSetter = true;
	  TestSectionPanel testSectionPanel = new TestSectionPanel(studentTestController, section, question);
	  MainGui.setComposite(testSectionPanel);
  }
}
