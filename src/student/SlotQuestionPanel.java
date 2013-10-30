package student;

import java.util.ArrayList;

import backend.SlotQ;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JPanel;

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
	private int questionNumber = 0;
	private JLabel labelQuestionNumber;

	/**
	 * Create the panel.
	 */
	public SlotQuestionPanel(SlotQ slotq) {
		this.slotq = slotq;
		textFields = new ArrayList<>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{61, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		labelQuestionNumber = new JLabel("Question " + Integer.toString(questionNumber));
		labelQuestionNumber.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		GridBagConstraints gbc_labelQuestionNumber = new GridBagConstraints();
		gbc_labelQuestionNumber.insets = new Insets(0, 0, 5, 0);
		gbc_labelQuestionNumber.gridx = 0;
		gbc_labelQuestionNumber.gridy = 0;
		add(labelQuestionNumber, gbc_labelQuestionNumber);
		
		JLabel labelMarks = new JLabel("Marks: "+this.slotq.getPossibleMarks());
		labelMarks.setFont(new Font("MV Boli", Font.PLAIN, 15));
		GridBagConstraints gbc_labelMarks = new GridBagConstraints();
		gbc_labelMarks.insets = new Insets(0, 0, 5, 10);
		gbc_labelMarks.anchor = GridBagConstraints.EAST;
		gbc_labelMarks.gridx = 0;
		gbc_labelMarks.gridy = 1;
		add(labelMarks, gbc_labelMarks);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		String delimiter = "<BLANK>";
		String question = "";
		for(int i=0; i<slotq.getSlotQ().length()-delimiter.length(); i++){
			boolean found = true;
			for(int j=0; j<delimiter.length(); j++){
				if(delimiter.charAt(j)!=slotq.getSlotQ().charAt(j+i)){
					found = false;
					break;
				}
			}
			if(found == false){
				question = question + Character.toString(slotq.getSlotQ().charAt(i));
			}
			else{
				JLabel questionText = new JLabel(new StringBuilder().append(question).toString());
				questionText.setHorizontalAlignment(SwingConstants.LEFT);
				//GridBagConstraints gbc_questionText = new GridBagConstraints();
				//gbc_questionText.insets = new Insets(0, 0, 5, 0);
				//gbc_questionText.anchor = GridBagConstraints.WEST;
				//gbc_questionText.gridx = 0;
				//gbc_questionText.gridy = 2;
				panel.add(questionText);
				question = "";
				JTextField emptyField = new JTextField(10);
				panel.add(emptyField);
				textFields.add(emptyField);
				i=i+delimiter.length()-1;
			}
		}
		if(!question.equals("")){
			System.out.println("end "+question);
			JLabel questionText = new JLabel(new StringBuilder().append(question).toString());
			questionText.setHorizontalAlignment(SwingConstants.LEFT);
		}
		
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

	@Override
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
		labelQuestionNumber.setText("Question " + Integer.toString(questionNumber));
		labelQuestionNumber.validate();
	}

	@Override
	public void setPath(String path) {
		labelQuestionNumber.setText(path + " > " + labelQuestionNumber.getText());
		labelQuestionNumber.validate();
	}

}
