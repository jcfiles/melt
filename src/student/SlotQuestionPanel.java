package student;

import java.util.ArrayList;

import backend.SlotQ;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

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
	private ArrayList<JTextField> textFields;

	/**
	 * Create the panel.
	 */
	public SlotQuestionPanel(SlotQ slotq) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.slotq = slotq;
		textFields = new ArrayList<>();
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
				JLabel questionText = new JLabel(new StringBuilder().append(question).toString());
				add(questionText);
				question = "";
				JTextField emptyField = new JTextField(10);
				add(emptyField);
				textFields.add(emptyField);
				i=i+delimiter.length();
			}
		}
		JLabel questionText = new JLabel(new StringBuilder().append(question).toString());
		questionText.setHorizontalAlignment(SwingConstants.LEFT);
		add(questionText);
		
	}

	@Override
	public void submitAnswer() {
		for(int i=0; i<textFields.size(); i++){
			slotq.setStudentAnswer(textFields.get(i).getText(), i);
		}
		// TODO Auto-generated method stub
		
	}
	
	/**
     * (non-Javadoc)
     * @see student.QuestionPanel#isAnswered()
     * 
     * Returns true if the student has checked an answer
     */

	@Override
	public boolean isAnswered() {
		boolean fieldIsFilled = true;
		for(int i=0; i<textFields.size(); i++){
			if(textFields.get(i).getText().equals("")){
				fieldIsFilled = false;
				break;
			}
		}
		return fieldIsFilled;
	}

}
