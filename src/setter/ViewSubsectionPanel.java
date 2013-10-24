package setter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class ViewSubsectionPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ViewSubsectionPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSubsection = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		lblSubsection.setFont(new Font("MV Boli", Font.PLAIN, 15));
		add(lblSubsection);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.SOUTH, lblSubsection, -18, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -26, SpringLayout.SOUTH, this);
		add(textField);
		textField.setColumns(10);
		
		JButton btnEdit = new JButton("");
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.setIcon(new ImageIcon(ViewSubsectionPanel.class.getResource("/lib/images/edit.png")));		
		btnEdit.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -10, SpringLayout.EAST, this);
		add(btnEdit);
		
		JButton btnDelete = new JButton("");
		springLayout.putConstraint(SpringLayout.EAST, textField, -6, SpringLayout.WEST, btnDelete);
		btnDelete.setIcon(new ImageIcon(ViewSubsectionPanel.class.getResource("/lib/images/cross.png")));
		btnDelete.setBackground(new Color(204, 0, 0));
		btnDelete.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, btnEdit);
		add(btnDelete);

	}
}
