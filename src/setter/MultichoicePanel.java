package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import backend.MCQ;
import backend.Question;
import backend.Section;

import javax.swing.ImageIcon;

/*
 * @author Erotokritou Zoe
 */
public class MultichoicePanel extends JPanel {

	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	private PossibleAnswers panel;
	private JLabel lblMarks;
	private JLabel lblQuestion;
	private ArrayList<String> list = new ArrayList<String>();
	private SetterTestController obj;
	private SetterGUI gui;
	private JLabel lblTitle=new JLabel("Test");
	
	
	/**
	 * Create the panel.
	 */
	public MultichoicePanel(final SetterTestController o,final SetterGUI g) {
		
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
		
		obj=o;
		gui=g;
		
		//load the marks of the question
		lblMarks = new JLabel("Marks: ");
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
		lblQuestion = new JLabel("Q1");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuestion, 4, SpringLayout.NORTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 39, SpringLayout.EAST, lblQ);
		lblQuestion.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAnswer, 19, SpringLayout.SOUTH, lblQ);
		lblAnswer.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblAnswer, 10, SpringLayout.WEST, centerPanel);
		centerPanel.add(lblAnswer);
		
		
		//Set text to all the labels
		list=obj.getQuestion(gui.current.getUserObject());
		
		lblMarks.setText("Marks: "+ list.get(0));
		lblQuestion.setText(list.get(1));
		panel = new PossibleAnswers(list.size()-2);
		
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, lblAnswer);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblQuestion);
		centerPanel.add(panel);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 10, SpringLayout.WEST, centerPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 440, SpringLayout.WEST, centerPanel);		
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		centerPanel.add(buttonsPanel);
		btnDelete.setFont(new Font("MV Boli", Font.PLAIN, 15));
		buttonsPanel.add(btnDelete);
		btnEdit.setFont(new Font("MV Boli", Font.PLAIN, 15));
		buttonsPanel.add(btnEdit);
		
		JLabel lblPath = new JLabel("Path>sub1");
		springLayout.putConstraint(SpringLayout.NORTH, lblPath, 50, SpringLayout.NORTH, centerPanel);
		lblPath.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.WEST, lblPath, 0, SpringLayout.WEST, lblQ);
		springLayout.putConstraint(SpringLayout.EAST, lblPath, 0, SpringLayout.EAST, lblMarks);
		centerPanel.add(lblPath);
		
		ArrayList<String> path=obj.getQuestionPath(gui.current.getUserObject());
		lblPath.setText(path.get(0));
		lblTitle.setText(obj.getTitle()+": "+ path.get(1));
		
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(MultichoicePanel.class.getResource("/lib/images/plus.png")));
		btnAdd.setBackground(new Color(0, 153, 0));
		btnAdd.setPreferredSize(new Dimension(40,40));
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 10, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, 0, SpringLayout.EAST, lblMarks);
		centerPanel.add(btnAdd);

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
						
						/*if(obj.getCurrentQuestion()==obj.countQuestion())
						{
							obj.setCurrentQuestion(obj.getCurrentQuestion()-1);
						}
						*/
						/*if(obj.getQuestionType()==0)
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
						}*/
					
						
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

	//for each possible answer set a radio button
	 public class PossibleAnswers extends JPanel {

	        private JPanel answers;
	        private int count;

	        public PossibleAnswers(int num) {
	            setLayout(new BorderLayout());

	            answers = new JPanel(new GridBagLayout());
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridwidth = GridBagConstraints.REMAINDER;
	            gbc.weightx = 20;
	            gbc.weighty = 20;
	            
	            answers.add(new JPanel(), gbc);
	            count=num;
	            add(new JScrollPane(answers));

	                	
	                	for (int i=0; i<count; i=i+2)
	                	{
	                		//JRadioButton
		                    JPanel panel = new JPanel();
		                    JCheckBox rdbtn =new JCheckBox(list.get(2+i));	     //set the possible answer ex. true/false           
		                    panel.add(rdbtn);
		                    GridBagConstraints gbc1 = new GridBagConstraints();
		                    gbc1.gridwidth = GridBagConstraints.REMAINDER;
		                    gbc1.weightx = 1;
		                    gbc1.weighty = 1;
		                    gbc1.anchor=GridBagConstraints.NORTHWEST;
		                    answers.add(panel, gbc1, i/2);
		                    
		                    this.validate();
		                    this.repaint();
	                	}
	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(200, 200);
	        }
	    }
}

