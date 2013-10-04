package student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class FinishTestPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 389409352371905605L;

	/**
	 * Create the panel.
	 */
	public FinishTestPanel(String marks) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCongratulations = new JLabel("Congratulations!");
		lblCongratulations.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCongratulations = new GridBagConstraints();
		gbc_lblCongratulations.anchor = GridBagConstraints.NORTH;
		gbc_lblCongratulations.insets = new Insets(0, 0, 5, 0);
		gbc_lblCongratulations.gridx = 0;
		gbc_lblCongratulations.gridy = 2;
		add(lblCongratulations, gbc_lblCongratulations);
		
		JLabel lblYouHaveFinished = new JLabel("You have finished your exam!");
		lblYouHaveFinished.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblYouHaveFinished = new GridBagConstraints();
		gbc_lblYouHaveFinished.anchor = GridBagConstraints.NORTH;
		gbc_lblYouHaveFinished.insets = new Insets(0, 0, 5, 0);
		gbc_lblYouHaveFinished.gridx = 0;
		gbc_lblYouHaveFinished.gridy = 3;
		add(lblYouHaveFinished, gbc_lblYouHaveFinished);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		
		JLabel lblYourMarkIs = new JLabel("Your mark is");
		panel.add(lblYourMarkIs);
		
		JLabel label = new JLabel(marks); // pass the marks awarded so it can be displayed
		panel.add(label);

	}

}
