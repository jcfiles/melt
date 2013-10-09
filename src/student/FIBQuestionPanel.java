package student;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import backend.FTBQ;
import backend.Answer;

public class FIBQuestionPanel extends QuestionPanel {
	
    private static final long serialVersionUID = -2289297585604116875L;
    private JTextField textField;
    private FTBQ ftbq;

   /**
    * Create the panel.
    */
    public FIBQuestionPanel(FTBQ ftbq) {
        this.ftbq = ftbq;
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{10, 0};
	gridBagLayout.rowHeights = new int[]{0, 10, 0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
		
	JLabel lblQuestion = new JLabel(""); // GETS THE QUESTION TEXT
	GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
	gbc_lblQuestion.insets = new Insets(0, 0, 5, 0);
	gbc_lblQuestion.gridx = 0;
	gbc_lblQuestion.gridy = 0;
	add(lblQuestion, gbc_lblQuestion);
		
	JPanel panel = new JPanel();
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.insets = new Insets(0, 0, 5, 0);
	gbc_panel.anchor = GridBagConstraints.NORTHWEST;
	gbc_panel.gridx = 0;
	gbc_panel.gridy = 1;
	add(panel, gbc_panel);
		
	JLabel qFirstPart = new JLabel(ftbq.getQFirstPart());
	panel.add(qFirstPart);
		
	textField = new JTextField();
	panel.add(textField);
	textField.setColumns(10);
		
	JLabel qSecondPart = new JLabel(ftbq.getQSecondPart());
	panel.add(qSecondPart);
    }
    
   /**
    * Sets the answer to the text entered
    */
    @Override
    public void submitAnswer() {
        ftbq.setGivenAnswer(textField.getText());
    }
}