package setter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddSubsectionPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddSubsectionPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSubsection = new JLabel("Subsection:");
		add(lblSubsection);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSubsection, -18, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -26, SpringLayout.SOUTH, this);
		add(textField);
		textField.setColumns(10);
		
		JButton btnEdit = new JButton("");
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.setIcon(new ImageIcon(AddSubsectionPanel.class.getResource("/lib/images/edit.png")));		
		btnEdit.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -10, SpringLayout.EAST, this);
		add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(AddSubsectionPanel.class.getResource("/lib/images/cross.png")));
		btnDelete.setBackground(new Color(204, 0, 0));
		btnDelete.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, btnEdit);
		add(btnDelete);

	}
}
