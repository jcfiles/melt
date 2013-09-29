package student;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MCQuestionPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public MCQuestionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblQuestion = new JLabel("Question 1");
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 0);
		gbc_lblQuestion.gridx = 0;
		gbc_lblQuestion.gridy = 0;
		add(lblQuestion, gbc_lblQuestion);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JLabel lblHowMuchIs = new JLabel("How much is 2+2?");
		panel.add(lblHowMuchIs);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{225, 225, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JRadioButton radioButton = new JRadioButton("3");
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.fill = GridBagConstraints.BOTH;
		gbc_radioButton.insets = new Insets(0, 0, 0, 5);
		gbc_radioButton.gridx = 0;
		gbc_radioButton.gridy = 0;
		panel_1.add(radioButton, gbc_radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("4");
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.anchor = GridBagConstraints.WEST;
		gbc_radioButton_1.gridx = 0;
		gbc_radioButton_1.gridy = 3;
		panel_1.add(radioButton_1, gbc_radioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("5");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 2;
		panel_1.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		

	}

}
