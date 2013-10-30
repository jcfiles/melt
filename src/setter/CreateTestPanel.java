package setter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import backend.Test_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

/*
 * @author Erotokritou Zoe
 */
public class CreateTestPanel extends JPanel {

	private JPanel titlePanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JLabel lblCreateTest =new JLabel("Create Test");
	private JTextField txtTitle = new JTextField();
	private JPanel buttonsPanel=new JPanel();
	private JButton btnSave=new JButton("Save");
	private JTextArea txtIntroduction = new JTextArea();
	private SetterTestController obj;

	
	
	/**
	 * Create the panel.
	 */
	public CreateTestPanel(final SetterTestController obj, final SetterGUI gui, Boolean bEdit) {
		setLayout(new BorderLayout(0, 0));

		this.obj=obj;
		
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
		lblCreateTest.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		titlePanel.add(lblCreateTest,gbc_lbl);		
		
		//Center Panel
		add(centerPanel, BorderLayout.CENTER);
		
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, txtTitle, 0, SpringLayout.WEST, txtIntroduction);
		springLayout.putConstraint(SpringLayout.SOUTH, txtTitle, -25, SpringLayout.NORTH, txtIntroduction);
		springLayout.putConstraint(SpringLayout.EAST, txtTitle, 0, SpringLayout.EAST, txtIntroduction);
		centerPanel.setLayout(springLayout);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblTitle);
		
		JLabel lblIntro = new JLabel("Introduction Text:");
		springLayout.putConstraint(SpringLayout.NORTH, lblIntro, 92, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblIntro, 10, SpringLayout.WEST, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 0, SpringLayout.WEST, lblIntro);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitle, -6, SpringLayout.NORTH, lblIntro);
		lblIntro.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblIntro);
		txtTitle.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(txtTitle);
				
		springLayout.putConstraint(SpringLayout.NORTH, txtIntroduction, 0, SpringLayout.NORTH, lblIntro);
		springLayout.putConstraint(SpringLayout.WEST, txtIntroduction, 38, SpringLayout.EAST, lblIntro);
		springLayout.putConstraint(SpringLayout.SOUTH, txtIntroduction, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, txtIntroduction, -10, SpringLayout.EAST, centerPanel);
		txtIntroduction.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtIntroduction.setLineWrap(true);
		txtIntroduction.setWrapStyleWord(true);
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
		gbc_btn.insets = new Insets(0, 0, 5, 5);
		gbc_btn.gridx = 0;
		gbc_btn.gridy = 1;	
		btnSave.setFont(new Font("MV Boli", Font.PLAIN, 15));
		buttonsPanel.add(btnSave,gbc_btn);
		btnSave.setPreferredSize(new Dimension(100, 30));
		
		
		if(bEdit==true)
		{
			setTexts();
		}
		
		btnSave.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
			//check if the Title is not empty
			if(txtTitle.getText().equals(""))
			{
				JOptionPane.showMessageDialog(gui,
		    			      "You have to insert the title of the Test",
		    			      "Save test Error",
		    			      JOptionPane.ERROR_MESSAGE);
			}
			else
			{				
				Test_ t=obj.createTest(txtTitle.getText(),txtIntroduction.getText());
				
				   
				ViewCreatePanel panel=new ViewCreatePanel(obj,gui);
				gui.centerPanel.removeAll();
				gui.centerPanel.add(panel);
				gui.centerPanel.validate();
				gui.centerPanel.repaint();			
				
				gui.setTree(t);
			}		   
		}
		});
	}
	
	public void setTexts()
	{
		txtTitle.setText(obj.getTitle());
		txtIntroduction.setText(obj.getIntroduction());
	}
}
