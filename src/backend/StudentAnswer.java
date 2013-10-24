package backend;

import java.util.ArrayList;

/*
 * A class to record a student's answer which is used for manual marking.
 * others than Answer.java which is used to store a possible predefined answer.
 */

public class StudentAnswer {
	
	protected Question question; //to get the question to this answer
	protected String rightAnswer;
	protected String answer;
	
	//for slot questions have a list of answers
	protected ArrayList<String> rightSlotAnswers;
	protected ArrayList<String> slotAnswers;

	protected int marksAwarded;
	protected String feedback;
	protected boolean isMarked;

	//empty constructor
	public StudentAnswer()
	{
		this.answer = "";
		this.marksAwarded = 0;
		this.feedback = null;
		this.isMarked = false;
		this.rightAnswer = null;
		this.rightSlotAnswers = null;
		this.slotAnswers = null;
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
	  this.feedback = "";
	  this.isMarked = false;
	  this.rightAnswer = rightAnswer;
	}
	
	public StudentAnswer(ArrayList<String> rightAnswers)
	{
		this.answer = null;
		this.marksAwarded = 0;
		this.feedback = "";
		this.isMarked = true;
		this.rightSlotAnswers = rightAnswers;
		this.slotAnswers = new ArrayList<String>();
		for(int i=0; i<rightSlotAnswers.size(); i++)
			slotAnswers.add("");
	}
	
	
	
	//Setters and Getters
	public ArrayList<String> getRightSlotAnswers() {
		return rightSlotAnswers;
	}
	
	public ArrayList<String> getSlotAnswers() {
		return slotAnswers;
	}

	public void setSlotAnswers(ArrayList<String> slotAnswers) {
		this.slotAnswers = slotAnswers;
	}
	
	public void setSlotAnswer(String answer, int index)
	{
		this.slotAnswers.set(index, answer);
	}
	
	public String getSlotAnswer(int index)
	{
		return this.slotAnswers.get(index);
	}

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
