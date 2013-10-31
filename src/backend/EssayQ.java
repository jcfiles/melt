package backend;

/*
* This is a manually marked question
*/
public class EssayQ extends Question {

	
	StudentAnswer studentAnswer;
	private int maxWords; //0 meaning infinity
	String label = "";
	int height,width;
	
  public EssayQ(String questionText, Object parent) {
		super(questionText, parent);
		this.studentAnswer = new StudentAnswer();
		this.maxWords = 0;
	}

	public EssayQ(String questionText, int possibleMarks, Object parent) {
		super(questionText, parent);
		this.possibleMarks = possibleMarks;
		this.studentAnswer = new StudentAnswer();
		this.maxWords = 0;
	}
	
	public EssayQ(String questionText, int possibleMarks, int maxWords, Object parent) {
    super(questionText, parent);
    this.possibleMarks = possibleMarks;
    this.studentAnswer = new StudentAnswer();
    this.maxWords = maxWords;
  }
	
	public EssayQ(String questionText, int possibleMarks, int maxWords, String label, Object parent)
	{
		super(questionText, parent);
    this.possibleMarks = possibleMarks;
    this.studentAnswer = new StudentAnswer();
    this.maxWords = maxWords;
    this.label = label;
	}
	
	
	@Override
	public int getMarksAwarded() 
	{		
		return studentAnswer.getMarksAwarded();
	}
	 
	public int getMaxWords()
	{
	  return maxWords;
	}

	public void setMaxWords(int maxWords)
	{
	  this.maxWords = maxWords;
	}

	public String getStudentAnswer() {
		return studentAnswer.getAnswer();
	}
	
	public StudentAnswer getWholeStudentAnswer()
	{
	  return studentAnswer;
	}
	
	@Override
	public String getFeedback()
	{
	  return studentAnswer.getFeedback();
	}
	
	@Override
	public void setFeedback(String feedback)
	{
	  studentAnswer.setFeedback(feedback);
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer.setAnswer(studentAnswer);
	}
	
	@Override
	public String toString()
	{
		return "EssayQ " + label;
	}
	
	public void setHeight(int h)
	{
		height=h;
	}

	public void setWidth(int w)
	{
		width=w;
	}
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	public void setMarked(boolean marked) {
		this.studentAnswer.setMarked(marked);
	}

	@Override
	public void setMarksAwarded(int marks) {
		this.studentAnswer.setMarksAwarded(marks);
	}
}
