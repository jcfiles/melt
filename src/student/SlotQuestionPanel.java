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
		for(int i=0; i<slotq.getqParts().length;i++){
			JLabel questionText = new JLabel(slotq.getqParts()[i]);
			add(questionText);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("hbsidjhoihs ");
		JLabel lblAsdfadfbfkfdjv = new JLabel(sb.toString());
		add(lblAsdfadfbfkfdjv);
		JTextField field = new JTextField();
		add(field);
		JLabel lblAsdfadfbfkfdj1v = new JLabel(sb.toString());
		add(lblAsdfadfbfkfdj1v);
		
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
