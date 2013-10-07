package setter;


import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuestionPanel extends JPanel {
	private JTextField txtSubsection;
	private JTextField txtMarks;
	public ButtonGroup group_type = new ButtonGroup();
	JRadioButton rdbtnMultipleChoice = new JRadioButton("Multiple choice");
	JRadioButton rdbtnFillBlanks = new JRadioButton("Fill blanks");

	/**
	 * Create the panel.
	 */
	public AddQuestionPanel() {
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
		
		JTextArea txtQuestion = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtQuestion, 15, SpringLayout.SOUTH, txtSubsection);
		springLayout.putConstraint(SpringLayout.WEST, txtQuestion, 0, SpringLayout.WEST, txtSubsection);
		springLayout.putConstraint(SpringLayout.EAST, txtQuestion, -22, SpringLayout.EAST, this);
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
		
		//Add table of the possible answers
		JTable table = new JTable(new MyTableModel());		
		scrollPane.setViewportView(table);
		
		
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
		
		
		//Panel for new possible answer
		final JPanel panel_new = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_mult, -6, SpringLayout.NORTH, panel_new);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_new, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, panel_new, 419, SpringLayout.NORTH, this);
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
		
		JTextField txtNew = new JTextField();
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
		
		
		//radio button listener to make things visible and unvisible
		rdbtnMultipleChoice.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(true);
		    	panel_new.setVisible(false);
		    	lblFill.setVisible(false);
		    	
			    }
		});
		
		//radio button listener to make things visible and unvisible
		rdbtnFillBlanks.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(false);
		    	panel_new.setVisible(false);
		    	lblFill.setVisible(true);
		    	
			    }
		});
		
		/// clicking the Add new possible answer
		btnAdd.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(true);
		    	panel_new.setVisible(true);
		    	lblFill.setVisible(false);
		    	
			    }
		});
		
		/// clickin the Ok button we save the new possible answer
		btnOk.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	panel_mult.setVisible(true);
		    	panel_new.setVisible(false);
		    	lblFill.setVisible(false);
		    	
			    }
		});
	}
	
	//class for the table with the possible answers
 	 public class MyTableModel extends AbstractTableModel {

	        String[] columns = {"Answer","Corect"};  //columns of the table
	        
	        //all the possible answers of the multiple choice question
			Object[][] data = {{"", new Boolean(false)},{"", new Boolean(false)},{"", new Boolean(false)},{"", new Boolean(false)}};
	 
	        public int getRowCount() {
	            return data.length;
	        }
	 
	        public int getColumnCount() {
	            return columns.length;
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
	            return data[0][columnIndex].getClass();
	        }	    	 
	}
}
