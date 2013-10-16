package setter;

import java.awt.FlowLayout;
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
	
	private JTextField txtTotalTime = new JTextField();
	private JTextField txtSection = new JTextField();
	private JTextArea txtInstructions = new JTextArea();
	private JLabel lblNumOfQuestions = new JLabel("0");
	private JLabel lblTotalMarks = new JLabel("0");
	
	final private JButton btnSave = new JButton("Save");
	
	public Boolean bEdit=false;
	

	/**
	 * Create the panel.
	 */
	public AddSectionPanel(final SetterTestController obj, final AddSectionGUI gui) {		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
				
		JLabel lblSubsection = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		add(lblSubsection);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblSubsection);
		add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblT, -17, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 20, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblSubsection);
		add(lblM);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 0, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -263, SpringLayout.EAST, this);
		add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 18, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblSubsection);
		add(lblI);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, txtTotalTime, 74, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		add(txtTotalTime);
		txtTotalTime.setColumns(10);
		
		
		springLayout.putConstraint(SpringLayout.SOUTH, txtSection, -13, SpringLayout.NORTH, txtTotalTime);
		springLayout.putConstraint(SpringLayout.EAST, txtTotalTime, 0, SpringLayout.EAST, txtSection);
		springLayout.putConstraint(SpringLayout.WEST, txtSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, txtSection, -10, SpringLayout.EAST, this);
		add(txtSection);
		txtSection.setColumns(10);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 0, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, 118, SpringLayout.EAST, lblM);
		add(lblTotalMarks);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, txtInstructions, 10, SpringLayout.SOUTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, txtInstructions, 65, SpringLayout.EAST, lblI);
		springLayout.putConstraint(SpringLayout.EAST, txtInstructions, 0, SpringLayout.EAST, txtTotalTime);
		txtInstructions.setLineWrap(true);
		txtInstructions.setWrapStyleWord(true);
		add(txtInstructions);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, txtInstructions, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, txtTotalTime);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		if(bEdit==true)
		{
			ArrayList<String> list = new ArrayList<String>();
			list=obj.getSection();
			
			txtSection.setText(list.get(0));
			txtTotalTime.setText(list.get(1));
			txtInstructions.setText(list.get(2));
		}
		
		
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
				obj.createTest(gui.lblTest.getText());
				obj.setTitle(gui.lblTest.getText());
				if(bEdit==true)
				{
					ArrayList<String> list = new ArrayList<String>();
					list=obj.getSection();
					
					txtSection.setText(list.get(0));
					txtTotalTime.setText(list.get(1));
					txtInstructions.setText(list.get(2));
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
	
	public void add() {		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSubsection = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		add(lblSubsection);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblSubsection);
		add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblT, -17, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 20, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblSubsection);
		add(lblM);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 0, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -263, SpringLayout.EAST, this);
		add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 18, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblSubsection);
		add(lblI);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, txtTotalTime, 74, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		add(txtTotalTime);
		txtTotalTime.setColumns(10);
		
		
		springLayout.putConstraint(SpringLayout.SOUTH, txtSection, -13, SpringLayout.NORTH, txtTotalTime);
		springLayout.putConstraint(SpringLayout.EAST, txtTotalTime, 0, SpringLayout.EAST, txtSection);
		springLayout.putConstraint(SpringLayout.WEST, txtSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, txtSection, -10, SpringLayout.EAST, this);
		add(txtSection);
		txtSection.setColumns(10);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 0, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, 118, SpringLayout.EAST, lblM);
		add(lblTotalMarks);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, txtInstructions, 10, SpringLayout.SOUTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, txtInstructions, 65, SpringLayout.EAST, lblI);
		springLayout.putConstraint(SpringLayout.EAST, txtInstructions, 0, SpringLayout.EAST, txtTotalTime);
		txtInstructions.setLineWrap(true);
		txtInstructions.setWrapStyleWord(true);
		add(txtInstructions);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, txtInstructions, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, txtTotalTime);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		
		buttonsPanel.add(btnSave);		
	}
	
}
