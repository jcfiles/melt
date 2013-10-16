package setter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 * @author Erotokritou Zoe
 */
public class ViewSectionPanel extends JPanel {
	
	
	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	final JButton btnAddQuestion= new JButton("Add Question");
	final JButton btnAdd = new JButton("Add New Section");
	AddSectionPanel addPanel;
	
	/**
	 * Create the panel.
	 */
	public ViewSectionPanel(final SetterTestController obj, final AddSectionGUI gui) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		if(obj.countSection()!=0){
		ArrayList<String> list = new ArrayList<String>();
		list=obj.getSection();
		
		JLabel lblS = new JLabel("Section:");
		springLayout.putConstraint(SpringLayout.NORTH, lblS, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblS, 10, SpringLayout.WEST, this);
		add(lblS);
		
		JLabel lblT = new JLabel("Total time:");
		springLayout.putConstraint(SpringLayout.WEST, lblT, 0, SpringLayout.WEST, lblS);
		add(lblT);
		
		JLabel lblQ = new JLabel("Number of Questions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblT, -17, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, this);
		add(lblQ);
		
		JLabel lblM = new JLabel("Total marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 20, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblS);
		add(lblM);
		
		JLabel lblNumOfQuestions = new JLabel(list.get(2));
		//JLabel lblNumOfQuestions = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, lblNumOfQuestions, 0, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblNumOfQuestions, 21, SpringLayout.EAST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblNumOfQuestions, -263, SpringLayout.EAST, this);
		add(lblNumOfQuestions);
		
		JLabel lblI = new JLabel("Instructions:");
		springLayout.putConstraint(SpringLayout.NORTH, lblI, 18, SpringLayout.SOUTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblI, 0, SpringLayout.WEST, lblS);
		add(lblI);
		
		JLabel lblTotalMarks = new JLabel(list.get(3));
		//JLabel lblTotalMarks = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalMarks, 0, SpringLayout.NORTH, lblM);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalMarks, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalMarks, 118, SpringLayout.EAST, lblM);
		add(lblTotalMarks);
		
		
		JLabel lblSection = new JLabel(list.get(0));
		//JLabel lblSection = new JLabel();
		springLayout.putConstraint(SpringLayout.WEST, lblSection, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSection, 0, SpringLayout.SOUTH, lblS);
		add(lblSection);
		
		JLabel lblTotalTime = new JLabel(list.get(1)+" mins");
		//JLabel lblTotalTime = new JLabel(" mins");
		springLayout.putConstraint(SpringLayout.WEST, lblTotalTime, 0, SpringLayout.WEST, lblNumOfQuestions);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTotalTime, 0, SpringLayout.SOUTH, lblT);
		add(lblTotalTime);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -33, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 0, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		buttonsPanel.add(btnAdd);
		buttonsPanel.add(btnDelete);
		buttonsPanel.add(btnEdit);
		buttonsPanel.add(btnAddQuestion);
		

		StringBuilder sb = new StringBuilder(64);
		sb.append("<html>"+list.get(4)+"</html>");
		
		JLabel lblNewLabel = new JLabel(sb.toString());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 32, SpringLayout.SOUTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 65, SpringLayout.EAST, lblI);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 46, SpringLayout.SOUTH, lblTotalMarks);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, buttonsPanel);
		add(lblNewLabel);
		
		btnAdd.addActionListener(new ActionListener(){	//button to add new section
			public void actionPerformed(ActionEvent e) {
				
				
				addPanel=new AddSectionPanel(obj,gui);
				
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
				
				addPanel=new AddSectionPanel(obj,gui);
				
				gui.panelCenter.removeAll();
				gui.panelCenter.add(addPanel);
				
				gui.panelCenter.validate();
				gui.panelCenter.repaint();
				
				gui.txtTest.setVisible(true);
				gui.lblTest.setVisible(false);
			 }
			});
			
			btnAddQuestion.addActionListener(new ActionListener(){  //Add new question
				public void actionPerformed(ActionEvent e) {
					
					AddQuestionGUI frame = new AddQuestionGUI(obj,gui);
					frame.setVisible(true);
					
					gui.setVisible(false);
				 }
				});
				
		}
	}
	
}
