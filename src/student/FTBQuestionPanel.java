package student;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import backend.FIBQ;
import backend.Answer;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * 
 * @author Dimitrios Chondrokoukis
 * @contributor Bruce Steedman
 */
public class FTBQuestionPanel extends QuestionPanel {
	
    private static final long serialVersionUID = -2289297585604116875L;
    private JTextField textField;
    private FIBQ ftbq;
    private int questionNumber = 0;
    private JLabel labelQuestionNumber;

   /**
    * Create the panel.
    */
    public FTBQuestionPanel(FIBQ ftbq) {
        this.ftbq = ftbq;
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{10, 0};
	gridBagLayout.rowHeights = new int[]{0, 10, 0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	
	labelQuestionNumber = new JLabel("Question "+Integer.toString(questionNumber));
	labelQuestionNumber.setFont(new Font("Maiandra GD", Font.BOLD, 20));
	labelQuestionNumber.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_labelQuestionNumber = new GridBagConstraints();
	gbc_labelQuestionNumber.insets = new Insets(0, 0, 5, 0);
	gbc_labelQuestionNumber.gridx = 0;
	gbc_labelQuestionNumber.gridy = 0;
	add(labelQuestionNumber, gbc_labelQuestionNumber);
	
	JLabel lblNewLabel = new JLabel("Marks: "+ftbq.getPossibleMarks());
	lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 10);
	gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 1;
	add(lblNewLabel, gbc_lblNewLabel);
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.anchor = GridBagConstraints.NORTHWEST;
	gbc_panel.gridx = 0;
	gbc_panel.gridy = 2;
	add(panel, gbc_panel);
		
	JLabel qFirstPart = new JLabel(ftbq.getQFirstPart());
	qFirstPart.setFont(new Font("Maiandra GD", Font.BOLD, 20));
	panel.add(qFirstPart);
		
	textField = new JTextField();
	textField.setFont(new Font("Verdana", Font.PLAIN, 13));
	panel.add(textField);
	textField.setColumns(10);
		
	JLabel qSecondPart = new JLabel(ftbq.getQSecondPart());
	qSecondPart.setFont(new Font("Maiandra GD", Font.BOLD, 20));
	panel.add(qSecondPart);
	
    }
    
    public FTBQuestionPanel(FIBQ ftbq, boolean hasStudentAnswers) {
    	new FTBQuestionPanel(ftbq);
    	textField.setEditable(false);
    	if(hasStudentAnswers){
    		textField.setText(ftbq.getGivenAnswer());
    	}
    	else{
    		textField.setText(ftbq.getIndexedAnswer(0).getAnswerText());
    	}
    }
    
   /**
    * Sets the answer to the text entered
    */
    @Override
    public void submitAnswer() {
        ftbq.setGivenAnswer(textField.getText());
    }
    
    /*
     * (non-Javadoc)
     * @see student.QuestionPanel#isAnswered()
     * 
     * Returns true if the student has filled in the blank
     */
    public boolean isAnswered(){
    	return textField.getText().equals("")?false:true;
    }

	@Override
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
		labelQuestionNumber.setText("Question " + Integer.toString(questionNumber));
		labelQuestionNumber.validate();
	}
}