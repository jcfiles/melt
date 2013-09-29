package student;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.JTextField;

public class FIBQuestionPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FIBQuestionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 0};
		gridBagLayout.rowHeights = new int[]{0, 10, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblQuestion = new JLabel("Question 3");
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
		
		JLabel lblYouCan = new JLabel("You can");
		panel.add(lblYouCan);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMyDick = new JLabel("my dick");
		panel.add(lblMyDick);

	}

}
