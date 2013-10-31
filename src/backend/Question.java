package backend;

import java.util.ArrayList;

/**
 * A question.
 * 
 * @author Bruce Steedman
 * @version 2013.10.10
 */
public abstract class Question extends SubsectionContainer implements java.io.Serializable  {
    
    protected String questionText;
    protected int possibleMarks = 1;
    protected int marksAwarded = 0;
    Object parent;
    protected String feedback;
		// protected String subsectionTitle = "";
    
    protected ArrayList<Answer> answers;  
    
    /**
     * Constructor for questions.
     */
    public Question(String questionText, Object parent)
    {
    	super(parent);
    	this.parent = parent;
        this.questionText = questionText;
        this.feedback = "";
        answers = new ArrayList<Answer>();
    }


    /**
     * @return String subSectionTitle
     */
    /*
   public String getsubSectionTitle() 
    {
    	return subsectionTitle;
    }
 */
    
    public String getQuestionText()
    {
        return questionText;
    }
    
    public void setQuestionText(String text) // for editing
    {
        questionText = text;
    }
    
/*
   public void setSubsectionTitle(String text) // for editing
    {
        subsectionTitle = text;
    }
    */

    /**
     * Returns the mark awarded for the question. Is 0 if wrong or unanswered.
     */
    public int getPossibleMarks()
    {
        return possibleMarks;
    }
    
    public void setPossibleMarks(int marks)
    {
        possibleMarks = marks;
    }
    
    public void addAnswer(Answer answer)
    {
        answers.add(answer);
    }
    
    public String getFeedback()
		{
			return feedback;
		}

		public void setFeedback(String feedback)
		{
			this.feedback = feedback;
		}

    
    /**
     * Sets an answer to the question by index, e.g. 0 is the first answer. 
     */
    public void setAnswer(String answerText, boolean isRight, int index)
    {
        answers.add(new Answer(answerText, isRight));
    }
    
    /**
     * Returns an answer by index, for questions with more than one possible answer.
     */
    public Answer getIndexedAnswer(int answerNum)
    {
        return answers.get(answerNum);
    }
    
    /**
     * Returns the parent section of the question
     * @return Section section
     */
    public Section getParentSection(){
    	Object outerObject = parent;
    	while((outerObject instanceof Section)==false){
    		outerObject = ((SubsectionContainer)outerObject).getParent();
    	}
    	return (Section)outerObject;
    }
    
    
    /**
     * Returns the path of the question
     * @return String path
     */
    public String getQuestionPath(){
    	String path="";
    	Object outerObject = parent;
    	while((outerObject instanceof Section)==false){
    		if(!path.equals("")){
    			path = ((Subsection)outerObject).getSubsectionTitle() + " > " + path;
    		}
    		else{
    			path = ((Subsection)outerObject).getSubsectionTitle();
    		}
    		outerObject = ((SubsectionContainer)outerObject).getParent();
    	}
    	return path;
    }
    
    public abstract int getMarksAwarded();
}