package setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.tree.DefaultMutableTreeNode;

import student.MainGui;
import student.TestSectionPanel;
import backend.Answer;
import backend.EssayQ;
import backend.FIBQ;
import backend.InvalidFTBQFormatException;
import backend.InvalidSlotQFormatException;
import backend.MCQ;
import backend.Question;
import backend.Section;
import backend.SlotQ;
import backend.StudentTestController;
import backend.Subsection;
import backend.SubsectionContainer;
import backend.Test_;

/*
 * @author Erotokritou Zoe
 */
public class SetterTestController
{
 // private int currentSection=0,currentQuestion=0;
  private Test_ test;
    
  int k=0;
  
  //Empty constructor
  public SetterTestController() {
	  test=new Test_("NewTest","");
  }
  
  public SetterTestController(Test_ test)
  {
  	this.test = test;
  }
  
  /**
   * Create Test with the name
   */
  public Test_  createTest(String title, String introduction)
  {
	  if(test==null)
	  {test=new Test_(title,introduction);}
	  else
	  {
		  setTitle(title);
		  setIntroduction(introduction);
	  }
	  return test;
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
  public Section addSection(String sectionTitle, String sectionIntroText, int sectionTime)
  {
    Section s=new Section(sectionTitle,sectionIntroText,sectionTime);
   // setCurrentSection(test.getAllSections().size());
    
    test.addSection(s);
    
    return s;
  }
  
  /**
   * Edit a section in the test
   */
  public Section editSection(Object current, String sectionTitle, String sectionIntroText, int sectionTime)
  {
	  ArrayList<Section> list=test.getAllSections();
	  Section s = null;
	  
	  for(int i=0; i<list.size(); i++)
	  {
		  if((Section)current==list.get(i))
			  {
			  s=test.getSection(i);		  
			  s.editSection(sectionTitle, sectionIntroText, sectionTime);
			  }
	    
	  }
	    return s;
	    
	  
  }


  /**
   * Delete a section in the test
   */
  public void deleteSection(Object section)
  {  
	 test.removeSection((Section)section);
  }
  
  
  public void addSubsection(Subsection sub)
  {
	  	  
	  if(sub.getParent() instanceof Subsection)
	  {
		  Subsection parent=(Subsection) sub.getParent();
		  parent.addSubsection(sub);
	  }
	  else
	  {
		  Section parent=(Section) sub.getParent();
		  parent.addSubsection(sub);
	  }
	  
  }
  
  public String getSubsectionTitle(Object obj,int index)
  {
	  if(obj instanceof Subsection)
	  {
		  Subsection sub=(Subsection)obj;
		  return ((Subsection)sub.getContainer().get(index)).getSubsectionTitle();
	  }
	  else
	  {
		  Section sub=(Section)obj;
		  return ((Subsection)sub.getContainer().get(index)).getSubsectionTitle();
	  }
  }
  
  public int getContainerSize(Object obj)
  {	  
	  if(obj instanceof Subsection)
	  {
		  Subsection sub=(Subsection)obj;
		  return sub.getContainer().size();
	  }
	  else
	  {
		  Section sub=(Section)obj;
		  if(sub.getContainer()!=null)
		  {return sub.getContainer().size();}
		  else
		  {
			  return 0;
		  }
	  }
  }
  
  /**
   * Delete a question in the test
   */
  public void deleteQuestion(Object current)
  {	 
	  Question q=(Question)current;
	  
	  if(q.getParent() instanceof Section)
	  {
		  ((Section)q.getParent()).getContainer().remove(q);
	  }
	  
	  if(q.getParent() instanceof Subsection)
	  {
		  ((Subsection)q.getParent()).getContainer().remove(q);
	  }
	  
  }
  
  /**
   * Delete a question in the test
   */
  public Subsection deleteSubsection(Object current, int index)
  {	 
	  Subsection s=(Subsection)current;
	  
	  if(current instanceof Section)
	  {
		  SubsectionContainer sc=((Section)current).getContainer().get(index);
		  s=(Subsection)sc;
		  ((Section)current).getContainer().remove(s);
		  
		  return s;		  
	  }
	  
	  if(current instanceof Subsection)
	  {
		  SubsectionContainer sc=((Subsection)current).getContainer().get(index);
		  s=(Subsection)sc;
		  ((Subsection)current).getContainer().remove(s);
		  
		  return s;

	  }
	  
	  return null;
	  
  }
  
  public Subsection editSubsection(Object current, String title)
  {
	  Subsection s=(Subsection)current;
	  s.setSubsectionTitle(title);	  
	  return s;
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
		  return q.size();
	  
	  }
	  else
	  {
		  return 0;
	  }	  
  }
  
 
  
  /**
   * Add a Fill Blank Question in the Section of the test
   */
  public Question addFIBQ(Object parent,String question, int marks)
  {
	  try {
			FIBQ q=new FIBQ(question, parent);
			q.setPossibleMarks(marks);
			
			if(parent instanceof Subsection)
			  {
				  Subsection sub=(Subsection)parent;
				  sub.addQuestion(q);
			  }
			  else
			  {
				  Section sub=(Section)parent;
				  sub.addQuestion(q);
			  }
			return q;
			
		} catch (InvalidFTBQFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			return null;
		}

	  
  }
  
  /**
   * Edit the current Fill Blank Question
   */
  public Question editFIBQ(Object current,String question, int marks)
  {
	  FIBQ q=(FIBQ) current;
	  
	  try {
			q.checkQuestion(question);
			
		} catch (InvalidFTBQFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			return null;
		}
	  
	  q.setQuestionText(question);
	  q.setPossibleMarks(marks);
	  
	  return q;
  }
  
  /**
   * Add a Fill Blank Question in the Section of the test
   */
  public Question addMCQ(Object parent, String question, int marks, JTable possibleAnswers)
  {
	  
	  MCQ q=new MCQ(question,parent);
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
	  
	  if(parent instanceof Subsection)
	  {
		  Subsection sub=(Subsection)parent;
		  sub.addQuestion(q);
	  }
	  else
	  {
		  Section sub=(Section)parent;
		  sub.addQuestion(q);
	  }
	  
	  return q;
  }
  
  /**
   * Edit the current Multiplechoice Question
   */
  public Question editMCQ(Object current, String question, int marks, JTable possibleAnswers)
  {	  
	  MCQ q=(MCQ) current;
	  
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
	  return q;
  }
  
  
  /**
   * Add a Fill Blank Question in the Section of the test
   */
  public Question addEssayQ(Object parent,String question, int marks, int height, int widht, int wordLimit)
  {
	  EssayQ q=new EssayQ(question,parent);
	  q.setPossibleMarks(marks);
	  q.setHeight(height);
	  q.setWidth(widht);
	  q.setMaxWords(wordLimit);
	
	  
	  if(parent instanceof Subsection)
	  {
		  Subsection sub=(Subsection)parent;
		  sub.addQuestion(q);
	  }
	  else
	  {
		  Section sub=(Section)parent;
		  sub.addQuestion(q);
	  }
	  
	  return q;

  }
  
  public Question editEssayQ(Object current,String question, int marks, int height, int widht, int wordLimit)
  {
	  EssayQ q= (EssayQ)current;
	  
	  q.setPossibleMarks(marks);
	  q.setHeight(height);
	  q.setWidth(widht);
	  q.setMaxWords(wordLimit);
	  
	  return q;
  }
  
  public Question addSlotQ(Object parent, String question, int marks)
  {
	  
	  try {
		SlotQ q=new SlotQ(question, parent);
		q.setPossibleMarks(marks);
		
		if(parent instanceof Subsection)
		  {
			  Subsection sub=(Subsection)parent;
			  sub.addQuestion(q);
		  }
		  else
		  {
			  Section sub=(Section)parent;
			  sub.addQuestion(q);
		  }
		return q;
		
	} catch (InvalidSlotQFormatException e) {
		// TODO Auto-generated catch block
		
		return null;	
	}

  }
  
  public Question editSlotQ(Object current, String question, int marks)
  {
	  SlotQ q=(SlotQ) current;
	  q.setPossibleMarks(marks);
	  q.setQuestionText(question);
	  
	  return q;	
  }
  
  
  /**
   * Edit the current Fill Blank Question
   */
  public ArrayList<String> getQuestion(Object obj)
  {
	  ArrayList<String> s=new ArrayList<String>();
	  ArrayList<Answer> a=new ArrayList<Answer>();
	  Question q=(Question)obj;
	  
	  s.add(q.getPossibleMarks()+"");
	  
	  if(q instanceof MCQ)
	  {
		  s.add(q.getQuestionText());
		  a=((MCQ) q).getAllAnswers();
		  
		  for(int i=0; i<a.size(); i++)
		  {
			  s.add(a.get(i).getAnswerText());
			  s.add(a.get(i).getIsRight()+"");
		  }
		  return s;
	  }
	  
	  if(q instanceof FIBQ)
	  {
		  FIBQ f=(FIBQ) q;
		  s.add(((FIBQ) q).getQFirstPart());
		  Answer an=f.getIndexedAnswer(0);
		  s.add(an.getAnswerText());
		  s.add(((FIBQ) q).getQSecondPart());
		  
		  return s;
	  }
	  
	  if(q instanceof EssayQ)
	  {
		  EssayQ e=(EssayQ) q;
		  s.add(e.getHeight()+"");
		  s.add(e.getWidth()+"");
		  s.add(e.getMaxWords()+"");
		  
		  return s;
	  }
	  
	  if(q instanceof SlotQ)
	  {
		  SlotQ slot=(SlotQ) q;
		  s.add(slot.getQuestionText());
		  
		  return s;
	  }

	  return null;
  }
  
  

  
  public ArrayList<String> getQuestionPath(Object obj)
  {
	  ArrayList<String> s=new ArrayList<String>();
	  
	Question q=(Question)obj;
	s.add(q.getQuestionPath());
	s.add(q.getParentSection().getSectionTitle());
	
	return s;
  }
  
  public Object getParent (Object current)
  {
	  Question q=(Question)current;
	  
	  return q.getParent();
  }
  
  
  public Test_ getTest()
  {
    return test;
  }
  
  public void saveTest(String destinationFile) throws IOException
  {
  	test.saveToFile(destinationFile);
  }
  
  public void previewQuestion(){
	  /*
	  Section section=test.getSection(currentSection);
	  Question question=section.getQuestion(currentQuestion);
	  
	  StudentTestController studentTestController = new StudentTestController();
	  studentTestController.setTest(test);
	  MainGui.isSetter = true;
	  TestSectionPanel testSectionPanel = new TestSectionPanel(studentTestController, section, question);
	  MainGui.setComposite(testSectionPanel);
	  */
  }
}
