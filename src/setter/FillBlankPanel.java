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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

import java.awt.Font;

/*
 * @author Erotokritou Zoe
 */
public class FillBlankPanel extends JPanel {
	
	private JTextField txtQuestion;
	private JButton btnDelete = new JButton("Delete");
	private JButton btnEdit = new JButton("Edit");
	private JLabel lblTitle=new JLabel("Test");
	/**
	 * Create the buttonsPanel.
	 */
	public FillBlankPanel(final SetterTestController obj, final SetterGUI gui) {
		setLayout(new BorderLayout(20, 20));
		
		//Title panel
		JPanel titlePanel = new JPanel();		
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
		lblTitle.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		titlePanel.add(lblTitle,gbc_lbl);				
		
		
		JPanel centerPanel = new JPanel();	
		add(centerPanel, BorderLayout.CENTER);
		
		SpringLayout springLayout = new SpringLayout();
		centerPanel.setLayout(springLayout);
		
		JLabel lblPath = new JLabel("Path>sub1");
		springLayout.putConstraint(SpringLayout.NORTH, lblPath, 50, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblPath, 10, SpringLayout.WEST, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, lblPath, -10, SpringLayout.EAST, centerPanel);
		lblPath.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblPath);	
		
		ArrayList<String> path=obj.getQuestionPath(gui.current.getUserObject());
		lblPath.setText(path.get(0));
		lblTitle.setText(obj.getTitle()+": "+ path.get(1));
		
		//load the marks of the question
		JLabel lblMarks=new JLabel("Marks");
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 70, SpringLayout.NORTH, centerPanel);
		lblMarks.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.EAST, lblMarks, -10, SpringLayout.EAST, centerPanel);
		centerPanel.add(lblMarks);
		
		JLabel lblQ = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQ, 107, SpringLayout.NORTH, centerPanel);
		lblQ.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblQ, 10, SpringLayout.WEST, centerPanel);
		centerPanel.add(lblQ);
		
		//load the question
		JLabel lblPartA=new JLabel("PartA");
		springLayout.putConstraint(SpringLayout.NORTH, lblPartA, 4, SpringLayout.NORTH, lblQ);
		lblPartA.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblPartA);
		
		txtQuestion = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtQuestion, -139, SpringLayout.EAST, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, lblPartA, -7, SpringLayout.WEST, txtQuestion);
		springLayout.putConstraint(SpringLayout.NORTH, txtQuestion, 1, SpringLayout.NORTH, lblQ);
		txtQuestion.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(txtQuestion);
		txtQuestion.setColumns(10);
		
		JLabel lblPartB=new JLabel("PartB");
		springLayout.putConstraint(SpringLayout.NORTH, lblPartB, 4, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblPartB, 5, SpringLayout.EAST, txtQuestion);
		lblPartB.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblPartB);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, centerPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH,centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, lblMarks);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		centerPanel.add(buttonsPanel);
		btnDelete.setFont(new Font("MV Boli", Font.PLAIN, 15));
		buttonsPanel.add(btnDelete);
		btnEdit.setFont(new Font("MV Boli", Font.PLAIN, 15));
		buttonsPanel.add(btnEdit);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(FillBlankPanel.class.getResource("/lib/images/plus.png")));
		btnAdd.setBackground(new Color(0, 153, 0));
		btnAdd.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 10, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, 0, SpringLayout.EAST, lblMarks);
		centerPanel.add(btnAdd);
		
	
		//Set information about the question
		ArrayList<String> list = new ArrayList<String>();
		list=obj.getQuestion(gui.current.getUserObject());
			
		lblMarks.setText("Marks: "+ list.get(0));
		lblPartA.setText(list.get(1));
		lblPartB.setText(list.get(3));
		
		btnDelete.addActionListener(new ActionListener(){  //Delete the question
		       public void actionPerformed(ActionEvent e) {
		         
		    	   //default icon, custom title
					int n = JOptionPane.showConfirmDialog(
					    gui,
					    "Are you sure that you whant to delete the Question?",
					    "Delete Question",
					    JOptionPane.YES_NO_OPTION);
					
					if(n==JOptionPane.YES_OPTION)
					{
						obj.deleteQuestion();
						/*
						if(obj.getCurrentQuestion()==obj.countQuestion())
						{
							obj.setCurrentQuestion(obj.getCurrentQuestion()-1);
						}
						*/
						if(obj.getQuestionType()==0)
						{
							MultichoicePanel panel=new MultichoicePanel(obj,gui);
							gui.centerPanel.removeAll();
							gui.centerPanel.add(panel);
						}
						else
						{
							FillBlankPanel panel=new FillBlankPanel(obj,gui);
							gui.centerPanel.removeAll();
							gui.centerPanel.add(panel);
						}
					
						
						gui.validate();
						gui.repaint();
					}										
		       }
		    });
		
		btnEdit.addActionListener(new ActionListener(){  //Edit the question
	        public void actionPerformed(ActionEvent e) {

	        	AddQuestionPanel addPanel=new AddQuestionPanel(obj,gui,true);
	        	gui.centerPanel.removeAll();
	        	gui.centerPanel.add(addPanel);
	         
	        	gui.centerPanel.validate();
	        	gui.centerPanel.repaint();
	        
	       }
	    });
		
		btnAdd.addActionListener(new ActionListener(){  //Edit the question
	        public void actionPerformed(ActionEvent e) {

	        	AddQuestionPanel addPanel=new AddQuestionPanel(obj,gui,false);
	        	gui.centerPanel.removeAll();
	        	gui.centerPanel.add(addPanel);
	         
	        	gui.centerPanel.validate();
	        	gui.centerPanel.repaint();
	        
	       }
	    });
		
		}
}
