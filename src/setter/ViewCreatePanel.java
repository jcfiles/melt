package setter;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

public class ViewCreatePanel extends JPanel {

	private JPanel titlePanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JLabel lblCreateTest =new JLabel("Create Test");
	private JLabel lblTitle = new JLabel("Test A");
	private JPanel buttonsPanel=new JPanel();	
	private JLabel lblIntroduction = new JLabel("Intro Text");
	private JButton btnEdit=new JButton("Edit");
	private JButton btnDelete=new JButton("Delete");
	private JButton btnAddSection=new JButton("Add Section");
	private JButton btnPreview=new JButton("Preview");
	
	/**
	 * Create the panel.
	 */
	public ViewCreatePanel(SetterTestController obj, SetterGUI gui) {
		setLayout(new BorderLayout(0, 0));

		//Title panel
		add(titlePanel, BorderLayout.NORTH);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{158, 57, 71, 0};
		gbl_titlePanel.rowHeights = new int[]{23, 0};
		gbl_titlePanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_titlePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
		GridBagConstraints gbc_lblCreateTest = new GridBagConstraints();
		gbc_lblCreateTest.insets = new Insets(0, 0, 0, 5);
		gbc_lblCreateTest.gridx = 1;
		gbc_lblCreateTest.gridy = 0;
		titlePanel.add(lblCreateTest, gbc_lblCreateTest);		
		GridBagConstraints gbc_btnPreview = new GridBagConstraints();
		gbc_btnPreview.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnPreview.gridx = 2;
		gbc_btnPreview.gridy = 0;
		titlePanel.add(btnPreview, gbc_btnPreview);
		
		//Center Panel
		add(centerPanel, BorderLayout.CENTER);
		
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 0, SpringLayout.WEST, lblIntroduction);
		springLayout.putConstraint(SpringLayout.EAST, lblTitle, 0, SpringLayout.EAST, lblIntroduction);
		centerPanel.setLayout(springLayout);
		
		JLabel lblT = new JLabel("Title:");
		springLayout.putConstraint(SpringLayout.NORTH, lblT, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblT, 10, SpringLayout.WEST, this);
		centerPanel.add(lblT);
		
		JLabel lblIntro = new JLabel("Introduction Text:");
		springLayout.putConstraint(SpringLayout.NORTH, lblIntro, 19, SpringLayout.SOUTH, lblT);
		springLayout.putConstraint(SpringLayout.WEST, lblIntro, 0, SpringLayout.WEST, lblT);
		centerPanel.add(lblIntro);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, -3, SpringLayout.NORTH, lblT);
		centerPanel.add(lblTitle);
				
		springLayout.putConstraint(SpringLayout.NORTH, lblIntroduction, 0, SpringLayout.NORTH, lblIntro);
		springLayout.putConstraint(SpringLayout.WEST, lblIntroduction, 38, SpringLayout.EAST, lblIntro);
		springLayout.putConstraint(SpringLayout.SOUTH, lblIntroduction, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, lblIntroduction, -10, SpringLayout.EAST, centerPanel);
		lblIntroduction.setVerticalAlignment(SwingConstants.TOP);
		centerPanel.add(lblIntroduction);
		
		//Buttons Panel
		add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonsPanel.add(btnEdit);
		buttonsPanel.add(btnDelete);
		buttonsPanel.add(btnAddSection);

	}

}
