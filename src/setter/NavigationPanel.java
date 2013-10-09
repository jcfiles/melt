package setter;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		
		JPanel navigationPanel = new JPanel();
		add(navigationPanel);
		navigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ImageIcon imgP = new ImageIcon("images\\previous.png");
		ImageIcon imgN = new ImageIcon("images\\next.png");
		JButton btnPrevious = new JButton();
		btnPrevious.setIcon(imgP);
		navigationPanel.add(btnPrevious);		
		JButton btnNext = new JButton();
		btnNext.setIcon(imgN);
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
			 }
			});
		
		/// clicking the Ok button
		btnAdd.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
			    btnEdit.setVisible(false);
			   	btnDelete.setVisible(false);
			   	btnAdd.setVisible(false);  	
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
			   	btnSave.setVisible(true);
			 }
			});
	}
}
