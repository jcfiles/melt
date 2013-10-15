package setter;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import student.TestSectionPanel;
import backend.Answer;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;


/*
 * @author Erotokritou Zoe
 */

public class AddQuestionPanel extends JPanel {
	private JTextField txtSubsection;
	private JTextField txtMarks;
	private JTextArea txtQuestion = new JTextArea();
	private JTextField txtNew = new JTextField();
	private Boolean bMCQ=true,bCorrect=false;
	private JTable table = new JTable(new MyTableModel());
	private JTable possibleAnswers;
	public ButtonGroup group_type = new ButtonGroup();
	private JRadioButton rdbtnMultipleChoice = new JRadioButton("Multiple choice");
	private JRadioButton rdbtnFillBlanks = new JRadioButton("Fill blanks");
	private JButton btnSave = new JButton("Save");
	private String header[] = new String[]{"Answer","Correct"};
	private DefaultTableModel model;
	private ImageIcon correctAnswerImage,wrongAnswerImage;
	private Object[][] data;
	//ArrayList<Answer> possible=new ArrayList<Answer>();
	//Object[][] d=new Object[possible.size()][possible.size()];


	/**
	 * Create the buttonsPanel.
	 */
	public AddQuestionPanel(final SetterTestController obj, final AddQuestionGUI gui) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		final JLabel lblFill = new JLabel("*insert the answer like e.x[answer]");
		lblFill.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblFill, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblFill, -10, SpringLayout.EAST, this);
		add(lblFill);
		
		JLabel lblSubsection = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 10, SpringLayout.WEST, this);
		add(lblSubsection);
		
		txtSubsection = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtSubsection, -3, SpringLayout.NORTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, txtSubsection, 32, SpringLayout.EAST, lblSubsection);
		springLayout.putConstraint(SpringLayout.EAST, txtSubsection, -22, SpringLayout.EAST, this);
		add(txtSubsection);
		txtSubsection.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question:");
		springLayout.putConstraint(SpringLayout.NORTH, lblQuestion, 18, SpringLayout.SOUTH, lblSubsection);
		springLayout.putConstraint(SpringLayout.WEST, lblQuestion, 10, SpringLayout.WEST, this);
		add(lblQuestion);
		
		springLayout.putConstraint(SpringLayout.NORTH, txtQuestion, 15, SpringLayout.SOUTH, txtSubsection);
		springLayout.putConstraint(SpringLayout.WEST, txtQuestion, 0, SpringLayout.WEST, txtSubsection);
		springLayout.putConstraint(SpringLayout.EAST, txtQuestion, -22, SpringLayout.EAST, this);
		txtQuestion.setLineWrap(true);
		txtQuestion.setWrapStyleWord(true);
		add(txtQuestion);
		
		JLabel lblType = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblType, 84, SpringLayout.SOUTH, lblQuestion);
		springLayout.putConstraint(SpringLayout.WEST, lblType, 0, SpringLayout.WEST, lblSubsection);
		add(lblType);
		
		
		rdbtnMultipleChoice.setSelected(true);
		springLayout.putConstraint(SpringLayout.SOUTH, txtQuestion, -12, SpringLayout.NORTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMultipleChoice, -4, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMultipleChoice, 52, SpringLayout.EAST, lblType);
		add(rdbtnMultipleChoice);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFillBlanks, 11, SpringLayout.SOUTH, rdbtnMultipleChoice);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnFillBlanks, 91, SpringLayout.WEST, this);
		add(rdbtnFillBlanks);
		
		//Add to button group		
		group_type.add(rdbtnFillBlanks);
		group_type.add(rdbtnMultipleChoice);
		
		JLabel lblMarks = new JLabel("Marks:");
		springLayout.putConstraint(SpringLayout.NORTH, lblMarks, 58, SpringLayout.SOUTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, lblMarks, 0, SpringLayout.WEST, lblSubsection);
		add(lblMarks);
		
		txtMarks = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtMarks, 13, SpringLayout.SOUTH, rdbtnFillBlanks);
		springLayout.putConstraint(SpringLayout.WEST, txtMarks, 56, SpringLayout.EAST, lblMarks);
		springLayout.putConstraint(SpringLayout.EAST, txtMarks, 0, SpringLayout.EAST, txtSubsection);
		add(txtMarks);
		txtMarks.setColumns(10);
		
		//If the user selects multiple choice
		final JPanel panel_mult = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_mult, 16, SpringLayout.SOUTH, lblMarks);
		springLayout.putConstraint(SpringLayout.WEST, panel_mult, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.EAST, panel_mult, 0, SpringLayout.EAST, txtSubsection);
		add(panel_mult);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_mult.setLayout(sl_panel_1);
		
		//Add scrollPane for table
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel_mult);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, -96, SpringLayout.EAST, panel_mult);
		panel_mult.add(scrollPane);
		
		/*
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.columnAtPoint(e.getPoint())==1){
					if((boolean)table.getModel().getValueAt(table.rowAtPoint(e.getPoint()), 1)==true){
						table.getModel().setValueAt(new Boolean(false), table.rowAtPoint(e.getPoint()), 1);
						table.repaint();
					}
					else{
						table.getModel().setValueAt(new Boolean(true), table.rowAtPoint(e.getPoint()), 1);
						table.repaint();
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		*/
		data = new Object[0][0];
		model = new DefaultTableModel(data,header);  		  
		model.setColumnIdentifiers(header);  
		possibleAnswers = new JTable(model) {

            private static final long serialVersionUID = 1L;
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
		scrollPane.setViewportView(possibleAnswers);
		
		possibleAnswers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(possibleAnswers.columnAtPoint(e.getPoint())==1){
					if(possibleAnswers.getModel().getValueAt(possibleAnswers.rowAtPoint(e.getPoint()), 1)==wrongAnswerImage){
						possibleAnswers.getModel().setValueAt(correctAnswerImage, possibleAnswers.rowAtPoint(e.getPoint()), 1);
						possibleAnswers.repaint();
					}
					else{
						possibleAnswers.getModel().setValueAt(wrongAnswerImage, possibleAnswers.rowAtPoint(e.getPoint()), 1);
						possibleAnswers.repaint();
					}
				}
			}
		});
		
		
		
		
		correctAnswerImage=new ImageIcon(TestSectionPanel.class.getResource("/lib/images/check.png"));
		wrongAnswerImage=new ImageIcon(TestSectionPanel.class.getResource("/lib/images/check.png"));
		
		
		
		
			
		
		//Add buttons
		JButton btnAdd = new JButton("Add");
		sl_panel_1.putConstraint(SpringLayout.WEST, btnAdd, 6, SpringLayout.EAST, scrollPane);
		btnAdd.setPreferredSize(new Dimension(80, 27));
		panel_mult.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnAdd, -6, SpringLayout.NORTH, btnEdit);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnEdit, 6, SpringLayout.EAST, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnEdit, -10, SpringLayout.EAST, panel_mult);
		btnEdit.setPreferredSize(new Dimension(80, 27));
		panel_mult.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnEdit, -6, SpringLayout.NORTH, btnDelete);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, btnDelete);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, panel_mult);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnDelete, -10, SpringLayout.EAST, panel_mult);
		btnDelete.setPreferredSize(new Dimension(80, 27));
		panel_mult.add(btnDelete);
		
		JLabel lblPossibleAnswers = new JLabel("Possible answers:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblPossibleAnswers);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblPossibleAnswers, 10, SpringLayout.NORTH, panel_mult);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblPossibleAnswers, 10, SpringLayout.WEST, panel_mult);
		panel_mult.add(lblPossibleAnswers);
		
		
		//buttonsPanel for new possible answer
		final JPanel panel_new = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_new, 419, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_mult, -6, SpringLayout.NORTH, panel_new);
		springLayout.putConstraint(SpringLayout.WEST, panel_new, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.EAST, panel_new, 0, SpringLayout.EAST, txtSubsection);
		panel_new.setVisible(false);
		add(panel_new);
		SpringLayout sl_panel_new = new SpringLayout();
		panel_new.setLayout(sl_panel_new);
		
		JLabel lblEnterNewPossible = new JLabel("Enter new possible answer:");
		sl_panel_new.putConstraint(SpringLayout.NORTH, lblEnterNewPossible, 10, SpringLayout.NORTH, panel_new);
		sl_panel_new.putConstraint(SpringLayout.WEST, lblEnterNewPossible, 10, SpringLayout.WEST, panel_new);
		panel_new.add(lblEnterNewPossible);
	
		sl_panel_new.putConstraint(SpringLayout.NORTH, txtNew, 46, SpringLayout.SOUTH, lblEnterNewPossible);
		sl_panel_new.putConstraint(SpringLayout.WEST, txtNew, 57, SpringLayout.WEST, panel_new);
		sl_panel_new.putConstraint(SpringLayout.NORTH, txtNew, -3, SpringLayout.NORTH, lblEnterNewPossible);
		sl_panel_new.putConstraint(SpringLayout.WEST, txtNew, 6, SpringLayout.EAST, lblEnterNewPossible);
		panel_new.add(txtNew);
		txtNew.setColumns(10);
		
		JLabel lblCorrect = new JLabel("Correct:");
		sl_panel_new.putConstraint(SpringLayout.NORTH, lblCorrect, 16, SpringLayout.SOUTH, lblEnterNewPossible);
		sl_panel_new.putConstraint(SpringLayout.WEST, lblCorrect, 10, SpringLayout.WEST, panel_new);
		panel_new.add(lblCorrect);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		sl_panel_new.putConstraint(SpringLayout.NORTH, rdbtnYes, -4, SpringLayout.NORTH, lblCorrect);
		sl_panel_new.putConstraint(SpringLayout.WEST, rdbtnYes, 94, SpringLayout.EAST, lblCorrect);
		panel_new.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		sl_panel_new.putConstraint(SpringLayout.NORTH, rdbtnNo, 6, SpringLayout.SOUTH, rdbtnYes);
		sl_panel_new.putConstraint(SpringLayout.WEST, rdbtnNo, 0, SpringLayout.WEST, rdbtnYes);
		panel_new.add(rdbtnNo);
		
		//Make a button group
		ButtonGroup group_correct = new ButtonGroup();
		group_correct.add(rdbtnNo);
		group_correct.add(rdbtnYes);
		
		JButton btnOk = new JButton("Ok");
		sl_panel_new.putConstraint(SpringLayout.EAST, btnOk, -10, SpringLayout.EAST, panel_new);
		sl_panel_new.putConstraint(SpringLayout.EAST, txtNew, 0, SpringLayout.EAST, btnOk);
		sl_panel_new.putConstraint(SpringLayout.SOUTH, btnOk, -10, SpringLayout.SOUTH, panel_new);
		panel_new.add(btnOk);
		
		JPanel buttonsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_new, -6, SpringLayout.NORTH, buttonsPanel);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, txtSubsection);
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, -43, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 0, SpringLayout.WEST, lblSubsection);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, -10, SpringLayout.SOUTH, this);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttonsPanel);
		
		buttonsPanel.add(btnSave);
		
		
		//radio button listener to make things visible and unvisible
		rdbtnMultipleChoice.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(true);
		    	panel_new.setVisible(false);
		    	lblFill.setVisible(false);
		    	
		    	bMCQ=true;
		    	
			    }
		});
		
		//radio button listener to make things visible and unvisible
		rdbtnFillBlanks.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(false);
		    	panel_new.setVisible(false);
		    	lblFill.setVisible(true);
		    	
		    	bMCQ=false;
		    	
			    }
		});
		
		//radio button listener to make things visible and unvisible
		rdbtnYes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				    	
				bCorrect=true;
				    	
			}
		});
		//radio button listener to make things visible and unvisible
		rdbtnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
						    	
				 bCorrect=false;
						    	
			}
		});

		
		//button Listeners
	    btnSave.addActionListener(new ActionListener(){  //button to save the question
	      public void actionPerformed(ActionEvent e) {
	    	  
	        if(bMCQ==true) //multiple choice question
	        {	        	
	        	obj.addMCQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()), possibleAnswers);
	        	MultichoicePanel multiPanel=new MultichoicePanel(obj,gui);
	        	gui.panelCenter.removeAll();
	        	gui.panelCenter.add(multiPanel);
	        }
	        else
	        {	        	
	        	obj.addFTBQ(txtSubsection.getText(), txtQuestion.getText(), Integer.parseInt(txtMarks.getText()));
	        	FillBlankPanel fillPanel=new FillBlankPanel(obj,gui);
	        	gui.panelCenter.removeAll();
	        	gui.panelCenter.add(fillPanel);
	        }
	        
	        gui.validate();
	        gui.repaint();
	       }
	       
	    });

	    
		
		/// clicking the Add new possible answer
		btnAdd.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(true);
		    	panel_new.setVisible(true);
		    	lblFill.setVisible(false);
		    	
		    	
		    	Object[][] temp = new Object[data.length+1][2];
			     
		    	int i=0;
			     for(i=0; i<data.length; i++)
			     {
			    	 temp[i][0]=data[i][0];
			    	 temp[i][1]=data[i][1];
			     }
			     temp[i][0]="";
			     temp[i][1]=wrongAnswerImage;
			     
			     data=new Object[temp.length][2];
			     data=temp;
			     
			     

			     DefaultTableModel model = new DefaultTableModel(data, header); 	
			     
			     
			    // model.fireTableDataChanged();
			     possibleAnswers.setModel(model);
		    	
			    }
		});
		
		
		/// clicking the Ok button we save the new possible answer
				btnOk.addActionListener(new ActionListener(){
				    public void actionPerformed(ActionEvent e) {

				    	panel_mult.setVisible(true);
				    	panel_new.setVisible(false);
				    	lblFill.setVisible(false);
				    	
				    	/*Answer a=new Answer(txtNew.getText(),bCorrect);
				    	possible.add(a);
				    	
				    	Object[][] temp=new Object[1][possible.size()];
				    	
				    	int i=0;
				    	for(i=0; i<d.length; i++)
				    	{
				    		temp[i][0]=d[i][0];
				    		temp[0][i]=d[0][i];
				    	}
				    	temp[i][0] = txtNew.getText();
				    	temp[0][i] = new Boolean(bCorrect);
				    	
				    	d=temp;
				    	
				    	table.repaint();
			        	*/
				    	//table = new JTable(new MyTableModel());
				    	
				    	Object[] temp={txtNew.getText(),(Boolean)(bCorrect)};
				    	
				    	table.getModel().setValueAt(temp, table.getModel().getRowCount()-1, 1);
						table.repaint();
				    	
					    }
				});

				
	}
	
	//class for the table with the possible answers
 	 public class MyTableModel extends AbstractTableModel {

	        String[] columns = {"Answer","Corect"};  //columns of the table
	        
	        //all the possible answers of the multiple choice question
			Object[][] data = {{"", new Boolean(false) },{"", new Boolean(false)},{"", new Boolean(false)},{"", new Boolean(false)}};
	 
	        public int getRowCount() {
	            return data.length;
	        }
	 
	        public int getColumnCount() {
	            return columns.length;
	        }
	        
	        public void setValueAt(Object object, int rowIndex, int columnIndex){
	        	data[rowIndex][columnIndex] = object;
	        }
	 
	        public Object getValueAt(int rowIndex, int columnIndex) {
	            return data[rowIndex][columnIndex];
	        }
	 
	        @Override
	        public String getColumnName(int column) {
	            return columns[column];
	        }

	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            return getValueAt(0, columnIndex).getClass();
	        }	    	 
	}
}
