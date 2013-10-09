package setter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SectionNavigationPanel extends JPanel {

	
	/**
	 * Create the panel.
	 */
	public SectionNavigationPanel() {
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
		

	}
}
