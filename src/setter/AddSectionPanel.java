package setter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 * @author Erotokritou Zoe
 */
public class AddSectionPanel extends JPanel {
	
	private JLabel lblTitle=new JLabel("Test");
	private JTextField txtTotalTime = new JTextField();
	private JTextField txtSection = new JTextField();
	private JLabel lblNumOfQuestions = new JLabel("0");
	private JLabel lblTotalMarks = new JLabel("0");	
	private JButton btnSave = new JButton("Save");
	private JPanel centerPanel =new JPanel();
	private JPanel titlePanel=new JPanel();
	private JPanel buttonsPanel = new JPanel();
	public Boolean bEdit=false;
	private final JTextArea txtInstructions = new JTextArea();
	

	/**
	 * Create the panel.
	 */
	public AddSectionPanel(final SetterTestController obj, final AddSectionGUI gui, Boolean b) {		
		setLayout(new BorderLayout(0, 0));
		
		bEdit=b;
		
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
		titlePanel.add(lblTitle, gbc_lblCreateTest);
		
		//Title panel
		add(centerPanel, BorderLayout.CENTER);
				
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, txtInstructions, 177, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, txtInstructions, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTotalMarks, -18, SpringLayout.NORTH, txtInstructions);
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 17, SpringLayout.SOUTH, txtTotalTime);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -263, SpringLayout.EAST, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, txtInstructions, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, txtInstructions, 0, SpringLayout.EAST, txtTotalTime);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSection, -13, SpringLayout.NORTH, txtTotalTime);
		springLayout.putConstraint(SpringLayout.WEST, txtTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, txtTotalTime, -10, SpringLayout.EAST, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, txtSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, 0, SpringLayout.EAST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, txtSection, -10, SpringLayout.EAST, centerPanel);
		centerPanel.setLayout(springLayout);
		
				
		JLabel lblSubsection = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		centerPanel.add(lblSubsection);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.NORTH, lblT, 3, SpringLayout.NORTH, txtTotalTime);
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblSubsection);
		centerPanel.add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 0, SpringLayout.NORTH, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 0, SpringLayout.WEST, lblSubsection);
		centerPanel.add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 0, SpringLayout.NORTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblSubsection);
		centerPanel.add(lblM);
		centerPanel.add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 5, SpringLayout.NORTH, txtInstructions);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblSubsection);
		centerPanel.add(lblI);
				
		springLayout.putConstraint(SpringLayout.NORTH, txtTotalTime, 74, SpringLayout.NORTH, this);
		centerPanel.add(txtTotalTime);
		txtTotalTime.setColumns(10);
		centerPanel.add(txtSection);
		txtSection.setColumns(10);
		centerPanel.add(lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, txtTotalTime);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		
		centerPanel.add(txtInstructions);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		if(bEdit==true)
		{
			ArrayList<String> list = new ArrayList<String>();
			list=obj.getSection();
			
			gui.txtTest.setText(list.get(0));
			txtSection.setText(list.get(1));
			txtTotalTime.setText(list.get(2));
			lblNumOfQuestions.setText(list.get(3));
			lblTotalMarks.setText(list.get(4));
			txtInstructions.setText(list.get(5));
		}
		
		
		add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.add(btnSave);		
		
		btnSave.addActionListener(new ActionListener(){  //button to save the question
			public void actionPerformed(ActionEvent e) {
				
				 Boolean flag=false;
		    	  
				 if(txtSection.getText().equals("")|| txtTotalTime.getText().equals("")|| txtInstructions.getText().equals(""))
				 {
		    			//insert all the information, error icon
		    			JOptionPane.showMessageDialog(gui,
		    			      "You have to insert all the information for the Section.",
		    			      "Save Section Error",
		    			      JOptionPane.ERROR_MESSAGE);
		    			flag=true;
				 }
				 
				 if(flag==false)
	    		  {
	    			  try {
	    				  Integer.parseInt(txtTotalTime.getText());
	    					
	    				} catch (Exception ex) {
	    					//insert number for a mark, error icon
	    					JOptionPane.showMessageDialog(gui,
	    		    			      "You have to insert a number for the Total time.",
	    		    			      "Save Mark for Question Error",
	    		    			      JOptionPane.ERROR_MESSAGE);
	    					flag=true;
	    				}			
	    		  }
				 
				 if(gui.txtTest.getText().equals("") && flag==false)
				 {
					//insert all the information, error icon
		    			JOptionPane.showMessageDialog(gui,
		    			      "You have to insert the title of the Test",
		    			      "Create Test Error",
		    			      JOptionPane.ERROR_MESSAGE);
		    			flag=true;
				 }
				 
				if(flag==false){	
				obj.createTest(gui.txtTest.getText());
				obj.setTitle(gui.txtTest.getText());
				gui.lblTest.setText(gui.txtTest.getText());
				
				if(bEdit==true)
				{
					obj.editSection(txtSection.getText(), txtInstructions.getText(), Integer.parseInt(txtTotalTime.getText()));
				}
				else
				{	
					obj.addSection(txtSection.getText(), txtInstructions.getText(), Integer.parseInt(txtTotalTime.getText()));			
				}
				ViewSectionPanel viewPanel=new ViewSectionPanel(obj,gui);
				
				gui.panelCenter.removeAll();
				gui.panelCenter.add(viewPanel);
				
				gui.txtTest.setVisible(false);
				gui.lblTest.setVisible(true);
												
				validate();
				repaint();
				
				} 
			}
			});
	}
}
