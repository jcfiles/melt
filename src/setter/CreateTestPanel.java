package setter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTestPanel extends JPanel {

	private JPanel titlePanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JLabel lblCreateTest =new JLabel("Create Test");
	private JTextField txtTitle = new JTextField();
	private JPanel buttonsPanel=new JPanel();
	private JButton btnSave=new JButton("Save");
	private JTextArea txtIntroduction = new JTextArea();
	
	
	/**
	 * Create the panel.
	 */
	public CreateTestPanel(final SetterTestController obj, final SetterGUI gui) {
		setLayout(new BorderLayout(0, 0));

		//Title panel
		add(titlePanel, BorderLayout.NORTH);
		
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0};
		gbl_titlePanel.rowHeights = new int[]{10,10};
		gbl_titlePanel.columnWeights = new double[]{0.0};
		gbl_titlePanel.rowWeights = new double[]{Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
		
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 1;	
		titlePanel.add(lblCreateTest,gbc_lbl);		
		
		//Center Panel
		add(centerPanel, BorderLayout.CENTER);
		
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, txtTitle, 0, SpringLayout.WEST, txtIntroduction);
		springLayout.putConstraint(SpringLayout.EAST, txtTitle, 0, SpringLayout.EAST, txtIntroduction);
		centerPanel.setLayout(springLayout);
		
		JLabel lblTitle = new JLabel("Title:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, this);
		centerPanel.add(lblTitle);
		
		JLabel lblIntro = new JLabel("Introduction Text:");
		springLayout.putConstraint(SpringLayout.NORTH, lblIntro, 19, SpringLayout.SOUTH, lblTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblIntro, 0, SpringLayout.WEST, lblTitle);
		centerPanel.add(lblIntro);
		
		springLayout.putConstraint(SpringLayout.NORTH, txtTitle, -3, SpringLayout.NORTH, lblTitle);
		centerPanel.add(txtTitle);
				
		springLayout.putConstraint(SpringLayout.NORTH, txtIntroduction, 0, SpringLayout.NORTH, lblIntro);
		springLayout.putConstraint(SpringLayout.WEST, txtIntroduction, 38, SpringLayout.EAST, lblIntro);
		springLayout.putConstraint(SpringLayout.SOUTH, txtIntroduction, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, txtIntroduction, -10, SpringLayout.EAST, centerPanel);
		centerPanel.add(txtIntroduction);
		
		//Buttons Panel
		add(buttonsPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_buttonsPanel = new GridBagLayout();
		gbl_buttonsPanel.columnWidths = new int[]{0};
		gbl_buttonsPanel.rowHeights = new int[]{0};
		gbl_buttonsPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_buttonsPanel.rowWeights = new double[]{Double.MIN_VALUE};
		buttonsPanel.setLayout(gbl_buttonsPanel);
		
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 1;	
		buttonsPanel.add(btnSave,gbc_btn);
		
		btnSave.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   
				   ViewCreatePanel panel=new ViewCreatePanel(obj,gui);
				   gui.centerPanel.removeAll();
				   gui.centerPanel.add(panel);
				   gui.centerPanel.validate();
				   gui.centerPanel.repaint();
						   
							 }
							});

	}
}
