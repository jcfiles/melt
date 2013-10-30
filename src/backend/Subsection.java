package backend;

import java.util.ArrayList;

/*
 * @author Erotokritou Zoe, Dimitrios Chondrokoukis, Stefan Lesnjakovic
 */
public class Subsection extends SubsectionContainer implements java.io.Serializable
{
  private String subsectionTitle;
  private ArrayList<SubsectionContainer> subsectionContainer;
  
  //constructors
  public Subsection()
  {
  	super();
  }
  /*
   * creates an empty subsection
   */
  public Subsection(String subsectionTitle, Object parent)
  {
	  super(parent);
	  this.subsectionTitle = subsectionTitle;
	  this.subsectionContainer=new ArrayList<SubsectionContainer>();
  }
  
  
  public void setSubsectionTitle(String subsectionTitle)
  {
	  this.subsectionTitle = subsectionTitle;
  }
  
  public ArrayList<SubsectionContainer> getContainer()
  {
  	return subsectionContainer;
  }
  
  public String getSubsectionTitle()
  {
	  return this.subsectionTitle;
  }
  
  public void addQuestion(Question q)
  {
  	subsectionContainer.add(q);
     // possibleSectionMarks += q.getPossibleMarks();
  }
  
  public void removeQuestion(Question q)
  {
  	subsectionContainer.remove(q);
      //possibleSectionMarks -= q.getPossibleMarks();
  }

  public void addSubsection(Subsection s)
  {
  	subsectionContainer.add(s);
  }
  
  public void removeSubsection(Subsection s)
  {
  	subsectionContainer.remove(s);
  }
  
  public boolean isEmpty()
  {
  	if(subsectionContainer.size() < 1)
  		return true;
  	else
  		return false;
  }
  
  public boolean hasQuestions()
  {
  	if(!this.isEmpty() && (subsectionContainer.get(0) instanceof Question))
  		return true;
  	else
  		return false;
  }
  
  @Override
  public String toString()
  {
  	return subsectionTitle;
  }
  
  /*
   * creates a subsection with questions in it
   * note: you cannot add another subsection to this one
   *
  public Subsection(ArrayList<Question> questions)
  {
    super(questions);
    this.subsectionTitle = "";
    this.subsectionContainer = null;
  }
  
  /*
   * creates a subsection with questions in it, that is named
   * note: you cannot add another subsection to this one
   *
  public Subsection(String subsectionTitle, ArrayList<Question> questions)
  {
    super(questions);
    this.subsectionTitle = subsectionTitle;
    this.subsectionContainer = null;
  }
  
  /*
   * create new Subsection within subsection (this should only be possible if there are no questions already created)
   *
  public Subsection addNewSubsection(Subsection newSubsection) throws InvalidSubsectionException
  {
    if(questions == null)
      this.subsectionContainer = newSubsection;
    else
      throw new InvalidSubsectionException();
    
    return newSubsection;
  }
  
  /*
   * Create a new empty subsection within the subsection (this should only be possible if a subsection does not already have questions)
   *
  public Subsection addNewSubsection(String subsectionTitle) throws InvalidSubsectionException
  {
    if(questions == null)
      this.subsectionContainer = new Subsection(subsectionTitle);
    else
      throw new InvalidSubsectionException();
    
    return (Subsection) this.subsectionContainer;
  }
  
  /*
   * Add questions to a subsection (this should only be possible if there are no subsections within the subsection)
   *
  public Subsection setNewQuestions(ArrayList<Question> questions) throws InvalidSubsectionException
  {
    if(subsectionContainer == null)
      this.questions = questions;
    else
      throw new InvalidSubsectionException("This subsection already contains a subsection therefore you cannot add Questions here!");
    
    return this;
  }
  
  //Getters and Setters
  public String getSubsectionTitle()
  {
    return subsectionTitle;
  }

  public void setSubsectionTitle(String subsectionTitle)
  {
    this.subsectionTitle = subsectionTitle;
  }
  */
  
  
}
