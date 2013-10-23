package backend;

/*
* This is a manually marked question
*/
public class EssayQ extends Question {

	
	StudentAnswer studentAnswer;

	public EssayQ(String questionText) {
		super(questionText);
		this.studentAnswer = new StudentAnswer();
	}

	public EssayQ(String questionText, int possibleMarks) {
		super(questionText);
		this.possibleMarks = possibleMarks;
		this.studentAnswer = new StudentAnswer();
	}
	
	
	
	@Override
	protected int getMarksAwarded() {
		
		return studentAnswer.getMarksAwarded();
	}
	
	public StudentAnswer getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(StudentAnswer studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

}
