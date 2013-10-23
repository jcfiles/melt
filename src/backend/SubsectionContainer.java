package backend;

import java.util.ArrayList;

public abstract class SubsectionContainer
{
  //variables that a subsectionCOntainer can hold
  //note that any subsectionContainer can only hold one of each at a time
  protected Subsection subsection;
  protected ArrayList<Question> questions;
  
  public SubsectionContainer()
  {
    this.subsection = null;
    this.questions = null;
  }
  
  /*
   * this creates a subsection with a name.
   * here you can add another subsection OR questions
   */
  public SubsectionContainer (String subsectionTitle)
  {
    this.subsection = new Subsection(subsectionTitle);
  }
  
  /*
   * This creates a subsection containing questions
   * note: more subsections cannot be added to a subsection created like this.
   */
  public SubsectionContainer (ArrayList<Question> questions)
  {
    this.questions = questions;
  }
  
  
  //getters and setters for questions
  public ArrayList<Question> getQuestions()
  {
    return questions;
  }

  public void setQuestions(ArrayList<Question> questions)
  {
    this.questions = questions;
  }
  
  public boolean addQuestion(Question question)
  {
    return questions.add(question);
  }

  
  
}
