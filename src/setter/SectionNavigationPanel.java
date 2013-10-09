package setter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SectionNavigationPanel extends JPanel {

	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	final JButton btnSave = new JButton("Save");
	final JButton btnAddQuestion= new JButton("Add Question");
	final JButton btnAdd = new JButton("Add New Section");
	
	/**
	 * Create the panel.
	 */
	public SectionNavigationPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel buttonsPanel =new JPanel();
		add(buttonsPanel);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		btnAdd.setVisible(false);
		buttonsPanel.add(btnAdd);
		
		btnDelete.setVisible(false);
		buttonsPanel.add(btnDelete);
		
		btnEdit.setVisible(false);
		buttonsPanel.add(btnEdit);
		
		btnAddQuestion.setVisible(false);
		buttonsPanel.add(btnAddQuestion);
		
		buttonsPanel.add(btnSave);
		
		JPanel navigationPanel = new JPanel();
		add(navigationPanel);
		navigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrevious = new JButton("Previous");
		navigationPanel.add(btnPrevious);		
		JButton btnNext = new JButton("   Next   ");
		navigationPanel.add(btnNext);				
		
		JPanel backPanel = new JPanel();
		add(backPanel);
		SpringLayout sl_backPanel = new SpringLayout();
		backPanel.setLayout(sl_backPanel);
		
		JButton btnBack = new JButton("Back");
		sl_backPanel.putConstraint(SpringLayout.SOUTH, btnBack, -7, SpringLayout.SOUTH, backPanel);
		sl_backPanel.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, backPanel);
		backPanel.add(btnBack);
		
		/// clicking the Save button
		btnSave.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(true);
			   	btnDelete.setVisible(true);
			   	btnAdd.setVisible(true);  	
			   	btnSave.setVisible(false);	
			   	btnAddQuestion.setVisible(true);
			 }
			});
		
		/// clicking the Ok button
		btnAdd.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(false);
			   	btnDelete.setVisible(false);
			   	btnAdd.setVisible(false); 
			   	btnAddQuestion.setVisible(false);
			   	btnSave.setVisible(true);
			 }
			});
		
		//clicking the Delete button
		btnDelete.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			  
			 }
			});
		
		//clicking the edit button
		btnEdit.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(false);
			   	btnDelete.setVisible(false);
			   	btnAdd.setVisible(false);  	
			   	btnAddQuestion.setVisible(false);
			   	btnSave.setVisible(true);
			 }
			});
		
		btnAddQuestion.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    AddQuestionGUI q=new AddQuestionGUI();
			    q.setVisible(true);
			 }
			});
	}
}
