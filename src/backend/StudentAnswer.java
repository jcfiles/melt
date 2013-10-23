package backend;

/*
 * A class to record a student's answer which is used for manual marking.
 * others than Answer.java which is used to store a possible predefined answer.
 */

public class StudentAnswer {
	
	protected Question question; //to get the question to this answer
	protected String rightAnswer;
	protected String answer;
	protected int marksAwarded;
	protected String feedback;
	protected boolean isMarked;

	//empty constructor
	public StudentAnswer()
	{
		this.answer = null;
		this.marksAwarded = 0;
		this.feedback = null;
		this.isMarked = false;
		this.rightAnswer = null;
	}
	
	//constructor with student answer
	public StudentAnswer(String answer)
	{
		this.answer = answer;
		this.marksAwarded = 0;
		this.feedback = null;
		this.isMarked = false;
		this.rightAnswer = null;
	}
	
	public StudentAnswer(String answer, String rightAnswer)
	{
	  this.answer = answer;
    this.marksAwarded = 0;
    this.feedback = null;
    this.isMarked = false;
    this.rightAnswer = rightAnswer;
	}
	
	
	//Setters and Getters
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getMarksAwarded() {
		return marksAwarded;
	}

	public void setMarksAwarded(int marksAwarded) {
		this.marksAwarded = marksAwarded;
	}
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public boolean isMarked() {
		return isMarked;
	}

	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}

}
