package setter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class EmptyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmptyPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		SpringLayout sl_centerPanel = new SpringLayout();
		centerPanel.setLayout(sl_centerPanel);
		JLabel lblAdd=new JLabel("Add Content");
		sl_centerPanel.putConstraint(SpringLayout.NORTH, lblAdd, 41, SpringLayout.NORTH, centerPanel);
		sl_centerPanel.putConstraint(SpringLayout.WEST, lblAdd, 84, SpringLayout.WEST, centerPanel);
		sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblAdd, -53, SpringLayout.SOUTH, centerPanel);
		sl_centerPanel.putConstraint(SpringLayout.EAST, lblAdd, -81, SpringLayout.EAST, centerPanel);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblAdd);
		
		JButton btnAddQuestion = new JButton("Add Question");
		sl_centerPanel.putConstraint(SpringLayout.NORTH, btnAddQuestion, 6, SpringLayout.SOUTH, lblAdd);
		sl_centerPanel.putConstraint(SpringLayout.WEST, btnAddQuestion, 10, SpringLayout.WEST, centerPanel);
		centerPanel.add(btnAddQuestion);
		
		JButton btnAddSubsection = new JButton("Add Subsection");
		sl_centerPanel.putConstraint(SpringLayout.NORTH, btnAddSubsection, 4, SpringLayout.SOUTH, lblAdd);
		sl_centerPanel.putConstraint(SpringLayout.EAST, btnAddSubsection, -10, SpringLayout.EAST, centerPanel);
		centerPanel.add(btnAddSubsection);

	}

}
