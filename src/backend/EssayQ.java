package backend;

/*
* This is a manually marked question
*/
public class EssayQ extends Question {

	
	StudentAnswer studentAnswer;
	private int maxWords; //0 meaning infinity
	
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
	
	@Override
	protected int getMarksAwarded() 
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

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer.setAnswer(studentAnswer);
	}

}
