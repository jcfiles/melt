package setter;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class NavigationPanel extends JPanel {

	
	final JButton btnDelete = new JButton("Delete");
	final JButton btnEdit = new JButton("Edit");
	final JButton btnSave = new JButton("Save");
	final JButton btnAdd = new JButton("Add New Question");
	
	/**
	 * Create the panel.
	 */
	public NavigationPanel() {
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
		
		/// clickin the Save button
		btnSave.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(true);
			   	btnDelete.setVisible(true);
			   	btnAdd.setVisible(true);  	
			   	btnSave.setVisible(false);			   	
			 }
			});
		
		/// clickin the Ok button
		btnAdd.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(false);
			   	btnDelete.setVisible(false);
			   	btnAdd.setVisible(false);  	
			   	btnSave.setVisible(true);
			 }
			});
		
		btnDelete.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			  
			 }
			});
		
		btnEdit.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(false);
			   	btnDelete.setVisible(false);
			   	btnAdd.setVisible(false);  	
			   	btnSave.setVisible(true);
			 }
			});
	}
}
