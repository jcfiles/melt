package setter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ViewSubsectionPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public ViewSubsectionPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSubsection = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSubsection, -64, SpringLayout.SOUTH, this);
		add(lblSubsection);
		
		JButton btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, -39, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, -66, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -10, SpringLayout.EAST, this);
		btnSave.setPreferredSize(new Dimension(40,40));
		add(btnSave);
		
		JLabel lblSubsection_1 = new JLabel("Subsection1");
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection_1, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSubsection_1, -21, SpringLayout.SOUTH, this);
		add(lblSubsection_1);
	}

}
