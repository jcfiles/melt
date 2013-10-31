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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import backend.SlotQ;

public class SlotQPanel extends JPanel {
	private JButton btnDelete = new JButton("Delete");
	private JButton btnEdit = new JButton("Edit");
	private JLabel lblTitle=new JLabel("Test");
	private ArrayList<JTextField> textFields;
	private SlotQ slotq;
	/**
	 * Create the panel.
	 */
	public SlotQPanel(final SetterTestController obj, final SetterGUI gui) {

		setLayout(new BorderLayout(20, 20));
		textFields = new ArrayList<>();
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
		
		slotq=(SlotQ)gui.current.getUserObject();
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, lblQ);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, lblPath);
		centerPanel.add(panel_1);
		
		String delimiter = "<BLANK>";
		String question = "";
		for(int i=0; i<slotq.getSlotQ().length(); i++){
			boolean found = true;
			for(int j=0; j<delimiter.length(); j++){
				if(i+j<slotq.getSlotQ().length()){
					if(delimiter.charAt(j)!=slotq.getSlotQ().charAt(j+i)){
						found = false;
						break;
					}
				}
			}
			if(found == false){
				question = question + Character.toString(slotq.getSlotQ().charAt(i));
			}
			else{
				JLabel questionText = new JLabel(new StringBuilder().append(question).toString());
				questionText.setHorizontalAlignment(SwingConstants.LEFT);
				panel_1.add(questionText);
				question = "";
				JTextField emptyField = new JTextField(10);
				panel_1.add(emptyField);
				textFields.add(emptyField);
				i=i+delimiter.length();
			}
		}
		if(!question.equals("")){
			JLabel questionText = new JLabel(new StringBuilder().append(question).toString());
			questionText.setHorizontalAlignment(SwingConstants.LEFT);
			panel_1.add(questionText);
		}
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, buttonsPanel);
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
						obj.deleteQuestion(gui.current.getUserObject());
						gui.removeQuestion();
					
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
