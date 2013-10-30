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

import backend.Section;

import java.awt.Font;

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
	public ViewSectionPanel(final SetterTestController obj, final SetterGUI gui, final Section section) {
		setLayout(new BorderLayout(20, 20));
		
		//Title panel
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GridBagConstraints gbc_panelA = new GridBagConstraints();
		gbc_panelA.insets = new Insets(0, 0, 0, 5);
		gbc_panelA.gridx = 0;
		gbc_panelA.gridy = 0;
		lblTitle.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		titlePanel.add(lblTitle,gbc_panelA);
		
		
		//Title panel
		add(centerPanel, BorderLayout.CENTER);		
		SpringLayout springLayout = new SpringLayout();
		centerPanel.setLayout(springLayout);
		
		JLabel lblS = new JLabel("Section:");
		lblS.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblS, 47, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblS, 10, SpringLayout.WEST, centerPanel);
		centerPanel.add(lblS);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.NORTH, lblT, 10, SpringLayout.SOUTH, lblS);
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblS);
		lblT.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 10, SpringLayout.SOUTH, lblT);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 0, SpringLayout.WEST, lblS);
		lblQ.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 10, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblS);
		lblM.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblM);
		
		lblNumOfQuestions = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 4, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -232, SpringLayout.EAST, centerPanel);
		lblNumOfQuestions.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 10, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblS);
		lblI.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblI);
		
		lblTotalMarks = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 4, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, -232, SpringLayout.EAST, centerPanel);
		lblTotalMarks.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblTotalMarks);
		
		
		lblSection = new JLabel("Section");
		springLayout.putConstraint(SpringLayout.NORTH, lblSection, 4, SpringLayout.NORTH, lblS);
		springLayout.putConstraint(SpringLayout.WEST, lblSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		lblSection.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblSection);
		
		lblTotalTime = new JLabel("0 mins");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalTime, 4, SpringLayout.NORTH, lblT);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		lblTotalTime.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblTotalTime);
		
		//Title panel
		add(buttonsPanel, BorderLayout.SOUTH);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnDelete.setIcon(new ImageIcon(ViewSectionPanel.class.getResource("/lib/images/cross.png")));
		btnDelete.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		buttonsPanel.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(100,35));
		btnDelete.setBackground(new Color(204, 0, 0));
		btnEdit.setIcon(new ImageIcon(ViewSectionPanel.class.getResource("/lib/images/edit.png")));
		btnEdit.setFont(new Font("MV Boli", Font.PLAIN, 15));
		buttonsPanel.add(btnEdit);
		btnEdit.setPreferredSize(new Dimension(100, 35));
		btnEdit.setBackground(Color.ORANGE);
		btnContent.setIcon(new ImageIcon(ViewSectionPanel.class.getResource("/lib/images/file.png")));
		btnContent.setBackground(new Color(224, 255, 255));
		btnContent.setFont(new Font("MV Boli", Font.PLAIN, 15));		
		buttonsPanel.add(btnContent);
		btnContent.setPreferredSize(new Dimension(120, 35));
				
		lblInstructions = new JLabel("Instructions");
		springLayout.putConstraint(SpringLayout.NORTH, lblInstructions, 0, SpringLayout.NORTH, lblI);
		springLayout.putConstraint(SpringLayout.WEST, lblInstructions, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblInstructions, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, lblInstructions, -10, SpringLayout.EAST, centerPanel);
		lblInstructions.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblInstructions.setVerticalAlignment(SwingConstants.TOP);
		centerPanel.add(lblInstructions);
		
		btnAdd = new JButton();
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -10, SpringLayout.EAST, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, lblSection, -6, SpringLayout.WEST, btnAdd);
		btnAdd.setIcon(new ImageIcon(ViewSectionPanel.class.getResource("/lib/images/plus.png")));
		btnAdd.setBackground(new Color(0, 153, 0));
		btnAdd.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 10, SpringLayout.NORTH, centerPanel);
		centerPanel.add(btnAdd);
		
		//Set the test into the labels
		setTexts(obj,section);
				
		
		btnAdd.addActionListener(new ActionListener(){	//button to add new section
			public void actionPerformed(ActionEvent e) {
				
				
				AddSectionPanel addPanel=new AddSectionPanel(obj,gui,false);
				
				gui.centerPanel.removeAll();
				gui.centerPanel.add(addPanel);
				
				gui.centerPanel.validate();
				gui.centerPanel.repaint();
			}
		});
			
			
			btnDelete.addActionListener(new ActionListener(){  //Delete the question
			public void actionPerformed(ActionEvent e) {
				
				/*
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
				
					ViewSectionPanel viewPanel=new ViewSectionPanel(obj,gui,null);
					
					gui.centerPanel.removeAll();
					gui.centerPanel.add(viewPanel);
					
					gui.validate();
					gui.repaint();
				}
				*/
				}	
				
			});
			
			btnEdit.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
				/*
				addPanel=new AddSectionPanel(obj,gui,true);
				
				gui.centerPanel.removeAll();
				gui.centerPanel.add(addPanel);
				
				gui.centerPanel.validate();
				gui.centerPanel.repaint();
				*/
			 }
			});
			
			btnContent.addActionListener(new ActionListener(){  //Add new question
				public void actionPerformed(ActionEvent e) {
					
					//gui.type=1;
					SubsectionContentPanel panel= new SubsectionContentPanel(obj,gui);
					gui.centerPanel.removeAll();
					gui.centerPanel.add(panel);
						
					gui.centerPanel.validate();
					gui.centerPanel.repaint();
				 }
				});				
		}
	
	
	public void setTexts(SetterTestController obj, Section section)
	{
		/*
		if(section==null)
		{
		if(obj.countSection()!=0){
			ArrayList<String> list = new ArrayList<String>();
			list=obj.getSection();
			
			lblSection.setText(list.get(0)); //= new JLabel(list.get(0));
			lblTotalTime.setText(list.get(1) + "mins"); //= new JLabel(list.get(1)+" mins");
			lblNumOfQuestions.setText(list.get(2)); //= new JLabel(list.get(2));
			lblTotalMarks.setText(list.get(3)); //= new JLabel(list.get(3));
			
			StringBuilder sb = new StringBuilder(64);
			sb.append("<html>"+list.get(4)+"</html>");
			
			lblInstructions.setText(sb.toString()); //= new JLabel(sb.toString());			
		}
		}
		*/
		
		lblSection.setText(section.getSectionTitle()); 
		lblTotalTime.setText(section.getSectionTime() + " mins"); 
		lblNumOfQuestions.setText("0"); 
		lblTotalMarks.setText("0"); 
		
		StringBuilder sb = new StringBuilder(64);
		sb.append("<html>"+section.getSectionIntroText()+"</html>");
		
		lblInstructions.setText(sb.toString()); 
	}
}
