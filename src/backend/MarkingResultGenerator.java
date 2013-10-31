package backend;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/*
 * This class is intended to create a marking report of an already marked test and output:
 * all questions of all subsections with expected answers
 * the actual answer
 * feedback
 * marks awarded
 * 
 */
public class MarkingResultGenerator
{

  public static void main(String[] args) throws InvalidSlotQFormatException
  {
    MarkingResultGenerator mrg = new MarkingResultGenerator(Test_.getDemoTest2());
    //MarkingResultGenerator mrg = new MarkingResultGenerator();
    //System.out.println(mrg.msb);
    System.out.println(mrg.getMarksReport());
  }
  
  //tree vars
  public JTree tree;
  private DefaultTreeModel treeModel;
  
  //string to hold the report
  private StringBuilder msb;
  private String marksReport;
  

  public MarkingResultGenerator()
  {
    this.msb = new StringBuilder(100);
    msb.append("Fuck this shit");
    msb.append("And this shit too");
    this.marksReport = msb.toString();
  }
  
  public MarkingResultGenerator(Test_ test)
  {
    //generate report
    this.msb = new StringBuilder(10000);
    msb.append("Test: " + test.getTestTitle() + "\n\n");
    //generate the tree of the test
    //tree initialisation
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(test);
    treeModel = new DefaultTreeModel(rootNode);
    
    tree = new JTree(treeModel);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    
    //recursive insert
    for(int i=0; i<test.getAllSections().size(); i++)
    {
      //add all sections
      DefaultMutableTreeNode section = new DefaultMutableTreeNode(test.getSection(i));
      treeModel.insertNodeInto(section, rootNode, i);
      //rootNode.add(section);
      
      //add this section title to the mark report
      msb.append(test.getAllSections().get(i).toString() + "\n\n");
      System.out.println(test.getAllSections().get(i).toString()); 
      
      //to this section node add all its subsections recursively
      ArrayList<SubsectionContainer> s = ((Section)section.getUserObject()).getContainer();
      //check if section is empty
      if(s.size() == 0)
        continue;
      else if(s.get(0) instanceof Question) //check if this section contains questions directly
      {
        //add all the questions to the report
        for(int j=0; j < s.size(); j++)
        {
          DefaultMutableTreeNode currentNode = new DefaultMutableTreeNode(s.get(j));
          
          //add question to tree
          treeModel.insertNodeInto(currentNode, section, j);
          
          //add question to marks report
          Question currentQ = (Question) s.get(j);
          msb.append("Q " + j + ": ");
          System.out.println("Q " + j);
          
          addQuestionToReport(currentQ);
          
        }//for: add questions to the report
      }//if this section contains question
      else // it will be a subsection
      {
        for(int j=0; j < s.size(); j++)
        {
          //add given subsection to tree
          DefaultMutableTreeNode currentNode = new DefaultMutableTreeNode(s.get(j));
          treeModel.insertNodeInto(currentNode, section, j);
          
          //generate report recursively
          recursiveReportGen(section, currentNode);
        }//for recursive search this subsection of section
      }//else this section contains a subsection
      
    }//insert recursively into the marksReport
    
    this.marksReport = msb.toString();
    
  }//constructor (test)
  
  //this will traverse the test structure recursively for subsections and then for each subsection found it will 
  //check whether it is empty or contains questions, if it has another subsection it will call itself in that.
  public void recursiveReportGen(DefaultMutableTreeNode parent, DefaultMutableTreeNode currentChild)
  {
    //check if exiting node
    //ie check for no more subsections or questions
    Subsection currentSub = (Subsection) currentChild.getUserObject();
    msb.append(currentSub.toString() + "\n");
    System.out.println(currentSub.toString());
    if(currentSub.isEmpty()) //if it is empty just return
    {
      return;
    }
    else if(currentSub.hasQuestions())
    {
      //if it has questions add them as treeNodes to the tree
      ArrayList<SubsectionContainer> sc = currentSub.getContainer();
      for(int i=0; i < sc.size(); i++)
      {
        DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(sc.get(i));
        treeModel.insertNodeInto(newChild, currentChild, i); //add the question
        
        //add questions to the report
        Question currentQ = (Question) sc.get(i);
        msb.append("Q " + i + ": ");
        System.out.println("Q " + i);
        
        addQuestionToReport(currentQ);
        
      }//for add questions to current subsection
    }// if current subsection has questions
    else //it will be a subsection so add the title to the report
    {
      //add this one to the report and
      //msb.append(currentSub.toString() + "\n\n");
      //System.out.println(currentSub.toString());
      
      //it will have more subsections so add them recursively
      ArrayList<SubsectionContainer> sc = currentSub.getContainer();
      for(int i=0; i < sc.size(); i++)
      {
        //System.out.println(currentSub.toString());
        DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(sc.get(i));
        
        //recursively go down through the subsection
        recursiveReportGen(currentChild, newChild); //search this subsection for more subsections so currentChild will become the new parent and newChild the current one for this iteration
        treeModel.insertNodeInto(newChild, currentChild, i); //add the subsection
        
      }//for
    }//else
  }//recursiveAdd
  
  private void addQuestionToReport(Question currentQ)
  {
    System.out.println("Hey");
    
    if(currentQ instanceof EssayQ)
    {
      //question
      msb.append(((EssayQ) currentQ).getQuestionText() + "\n");
      //studentAnswer
      msb.append("Your answer:\n" + ((EssayQ) currentQ).getStudentAnswer() + "\n");
      //feedback
      msb.append("Feedback:\n" + ((EssayQ) currentQ).getFeedback() + "\n");
      //marks
      msb.append("Marks: " + ((EssayQ) currentQ).getMarksAwarded() + "/" + ((EssayQ) currentQ).getPossibleMarks() + "\n");
    }//if essayQ
    else if(currentQ instanceof SlotQ)
    {
      System.out.println("Bob");
      //question
      msb.append(((SlotQ) currentQ).getSlotQ() + "\n");
      //Expected answers
      ArrayList expAnswers = ((SlotQ) currentQ).getExpectedAnswers();
      msb.append("Expected Answers: ");
      for(int k=0; k<expAnswers.size(); k++)
      {
        msb.append(expAnswers.get(k) + " ");
      }
      msb.append("\n");
      //studentAnswer
      ArrayList stuAnswers = ((SlotQ) currentQ).getStudentAnswers();
      msb.append("Your Answers: ");
      for(int k=0; k<stuAnswers.size();k++)
      {
        msb.append(stuAnswers.get(k) + " ");
      }
      msb.append("\n");
      //feedback (if there is any)
      if(((SlotQ) currentQ).getStudentFeedback() != "")
      {
        msb.append("Feedback: " + ((SlotQ) currentQ).getStudentFeedback() + "\n");
      }
      //marks
      msb.append("Marks: " + ((SlotQ) currentQ).getStudentMark() + "/" + ((SlotQ) currentQ).getPossibleMarks() + "\n");
    }//if slotQ
    else if(currentQ instanceof FIBQ)
    {
      //question
      msb.append(((FIBQ) currentQ).getFIBQ() + "\n");
      //Expected answer
      msb.append("Expected Answer: " + ((FIBQ) currentQ).getIndexedAnswer(0).getAnswerText() + "\n");
      //studentAnswer
      msb.append("Your Answer: " + ((FIBQ) currentQ).getGivenAnswer() + "\n");
      //marks
      msb.append("Marks: " + ((FIBQ) currentQ).getMarksAwarded() + "/" + ((FIBQ) currentQ).getPossibleMarks() + "\n");
    }//if fibq
    else if(currentQ instanceof MCQ)
    {
      //question
      msb.append(((MCQ) currentQ).getQuestionText() + "\n");
      //Expected answer
      ArrayList<Answer> answers = ((MCQ) currentQ).getAllAnswers();
      msb.append("Answers: ");
      for(int k=0; k<answers.size();k++)
      {
        msb.append(answers.get(k).getAnswerText());
        if(answers.get(k).getIsRight())
          msb.append("[correct] ");
        else
          msb.append(" ");
      }
      msb.append("\n");
      //studentAnswer
      msb.append("Your Answers: ");
      for(int k=0; k<answers.size();k++)
      {
        if(answers.get(k).getIsSelected())
          msb.append(answers.get(k).getAnswerText() + " ");
      }
      msb.append("\n");
      //Marks
      msb.append("Marks: " + ((MCQ) currentQ).getMarksAwarded() + "/" + ((MCQ) currentQ).getPossibleMarks() + "\n");
    }//if mcq
    msb.append("\n");
    
  }//private void addQuestionToReport
  
  public String getMarksReport()
  {
    return this.marksReport;
  }
    
}
