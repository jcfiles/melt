package student;

import backend.SlotQ;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Dimitrios Chondrokoukis
 *
 */
public class SlotQuestionPanel extends QuestionPanel {

	/**
	 * This is the panel for the multi-slot questions
	 */
	private static final long serialVersionUID = 3541874320997314399L;
	private SlotQ slotq;

	/**
	 * Create the panel.
	 */
	public SlotQuestionPanel(SlotQ slotq) {
		this.slotq = slotq;
		String delimiter = "<BLANK>";
		String question = "";
		for(int i=0; i<slotq.toString().length()-delimiter.length(); i++){
			boolean found = true;
			for(int j=0; j<delimiter.length(); j++){
				if(delimiter.charAt(j)!=slotq.toString().charAt(j+i)){
					found = false;
					break;
				}
			}
			if(found == false){
				question = question + Character.toString(slotq.toString().charAt(i));
			}
			else{
				JLabel questionText = new JLabel(question);
				add(questionText);
				question = "";
				JTextField emptyField = new JTextField(10);
				add(emptyField);
				i=i+delimiter.length();
			}
		}
		JLabel questionText = new JLabel(question);
		add(questionText);
		
	}

	@Override
	public void submitAnswer() {
		// TODO Auto-generated method stub
		
	}
	
	/*
     * (non-Javadoc)
     * @see student.QuestionPanel#isAnswered()
     * 
     * Returns true if the student has checked an answer
     */

	@Override
	public boolean isAnswered() {
		// TODO Auto-generated method stub
		return false;
	}

}
