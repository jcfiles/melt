package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/*
 * @author Erotokritou Zoe
 */
public class ViewSectionPanel extends JPanel {
	
	
	private JButton btnDelete = new JButton("Delete");
	private JButton btnEdit = new JButton("Edit");
	private JButton btnContent= new JButton("Content");
	private  JButton btnAdd = new JButton("Add");
	AddSectionPanel addPanel;
	private JPanel centerPanel =new JPanel();
	private JPanel titlePanel=new JPanel();
	private JPanel buttonsPanel = new JPanel();
	private JLabel lblTitle=new JLabel("Test");
	private JLabel lblNumOfQuestions;
	private JLabel lblTotalMarks;
	private JLabel lblSection;
	private JLabel lblTotalTime;
	private JLabel lblInstructions;
	
	/**
	 * Create the panel.
	 */
	public ViewSectionPanel(final SetterTestController obj, final AddSectionGUI gui) {
		setLayout(new BorderLayout(0, 0));
		
		//Title panel
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GridBagConstraints gbc_panelA = new GridBagConstraints();
		gbc_panelA.insets = new Insets(0, 0, 0, 5);
		gbc_panelA.gridx = 0;
		gbc_panelA.gridy = 0;
		titlePanel.add(lblTitle,gbc_panelA);
		
		
		//Title panel
		add(centerPanel, BorderLayout.CENTER);		
		SpringLayout springLayout = new SpringLayout();
		centerPanel.setLayout(springLayout);
		
		JLabel lblS = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblS, 47, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblS, 10, SpringLayout.WEST, centerPanel);
		centerPanel.add(lblS);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblS);
		centerPanel.add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblT, -17, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		centerPanel.add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 20, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblS);
		centerPanel.add(lblM);
		
		lblNumOfQuestions = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 0, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -262, SpringLayout.EAST, centerPanel);
		centerPanel.add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 18, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblS);
		centerPanel.add(lblI);
		
		lblTotalMarks = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 0, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, -263, SpringLayout.EAST, centerPanel);
		centerPanel.add(lblTotalMarks);
		
		
		lblSection = new JLabel("Section");
		springLayout.putConstraint(SpringLayout.NORTH, lblSection, 0, SpringLayout.NORTH, lblS);
		springLayout.putConstraint(SpringLayout.WEST, lblSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		centerPanel.add(lblSection);
		
		lblTotalTime = new JLabel("0 mins");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalTime, 0, SpringLayout.NORTH, lblT);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		centerPanel.add(lblTotalTime);
		
		//Title panel
		add(buttonsPanel, BorderLayout.SOUTH);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		buttonsPanel.add(btnDelete);
		buttonsPanel.add(btnEdit);
		buttonsPanel.add(btnContent);
				
		lblInstructions = new JLabel("Instructions");
		springLayout.putConstraint(SpringLayout.NORTH, lblInstructions, 0, SpringLayout.NORTH, lblI);
		springLayout.putConstraint(SpringLayout.WEST, lblInstructions, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblInstructions, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, lblInstructions, -10, SpringLayout.EAST, centerPanel);
		lblInstructions.setVerticalAlignment(SwingConstants.TOP);
		centerPanel.add(lblInstructions);
		
		btnAdd = new JButton();
		btnAdd.setIcon(new ImageIcon(ViewSectionPanel.class.getResource("/lib/images/plus.png")));
		btnAdd.setBackground(new Color(0, 153, 0));
		btnAdd.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 10, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, 0, SpringLayout.EAST, lblInstructions);
		centerPanel.add(btnAdd);
		
		//Set the test into the labels
		setTexts(obj);
				
		
		btnAdd.addActionListener(new ActionListener(){	//button to add new section
			public void actionPerformed(ActionEvent e) {
				
				
				addPanel=new AddSectionPanel(obj,gui,false);
				
				gui.panelCenter.removeAll();
				gui.panelCenter.add(addPanel);
				
				gui.panelCenter.validate();
				gui.panelCenter.repaint();
				
				gui.txtTest.setVisible(true);
				gui.lblTest.setVisible(false);
			}
		});
			
			
			btnDelete.addActionListener(new ActionListener(){  //Delete the question
			public void actionPerformed(ActionEvent e) {
				
				//default icon, custom title
				int n = JOptionPane.showConfirmDialog(
				    gui,
				    "Are you sure that you whant to delete the Section?",
				    "Delete Section",
				    JOptionPane.YES_NO_OPTION);
				
				if(n==JOptionPane.YES_OPTION)
				{
					obj.deleteSection();
					
					if(obj.getCurrentSection()==obj.countSection())
					{
						obj.setCurrentSection(obj.getCurrentSection()-1);
					}
				
					ViewSectionPanel viewPanel=new ViewSectionPanel(obj,gui);
					
					gui.panelCenter.removeAll();
					gui.panelCenter.add(viewPanel);
					
					gui.validate();
					gui.repaint();
				}
				
				}	
			});
			
			btnEdit.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
				
				addPanel=new AddSectionPanel(obj,gui,true);
				
				gui.panelCenter.removeAll();
				gui.panelCenter.add(addPanel);
				
				gui.panelCenter.validate();
				gui.panelCenter.repaint();
				
				gui.txtTest.setVisible(true);
				gui.lblTest.setVisible(false);
			 }
			});
			
			/*btnAddQuestion.addActionListener(new ActionListener(){  //Add new question
				public void actionPerformed(ActionEvent e) {
					
					AddQuestionGUI frame = new AddQuestionGUI(obj,gui);
					frame.setVisible(true);
					
					gui.setVisible(false);
				 }
				});
				*/
				
		}
	
	
	public void setTexts(SetterTestController obj)
	{
		if(obj.countSection()!=0){
			ArrayList<String> list = new ArrayList<String>();
			list=obj.getSection();
			
			lblTitle.setText(list.get(0));
			lblSection = new JLabel(list.get(1));
			lblTotalTime = new JLabel(list.get(2)+" mins");
			lblNumOfQuestions = new JLabel(list.get(3));
			lblTotalMarks = new JLabel(list.get(4));
			
			StringBuilder sb = new StringBuilder(64);
			sb.append("<html>"+list.get(5)+"</html>");
			
			lblInstructions = new JLabel(sb.toString());
			
		}
	}
}
