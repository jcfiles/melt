package setter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/*
 * @author Erotokritou Zoe
 */
public class SectionNavigationPanel extends JPanel {

	JButton btnPrevious = new JButton();
	JButton btnNext = new JButton();
	/**
	 * Create the panel.
	 */
	public SectionNavigationPanel(final SetterTestController obj, final AddSectionGUI gui) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel navigationPanel = new JPanel();
		add(navigationPanel);
		navigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//ImageIcon imgP = new ImageIcon("/images/previous.png");
		//ImageIcon imgN = new ImageIcon(SectionNavigationPanel.class.getResource("lib.images\next.png"));
		
		btnPrevious.setIcon(new ImageIcon(SectionNavigationPanel.class.getResource("/lib/images/previous.png")));
		navigationPanel.add(btnPrevious);		
		
		btnNext.setIcon(new ImageIcon(SectionNavigationPanel.class.getResource("/lib/images/next.png")));
		//btnNext.setIcon(new ImageIcon(SectionNavigationPanel.class.getResource("/images/next.png")));
		navigationPanel.add(btnNext);				
		
		JPanel backPanel = new JPanel();
		add(backPanel);
		SpringLayout sl_backPanel = new SpringLayout();
		backPanel.setLayout(sl_backPanel);
		
		JButton btnBack = new JButton("Back");
		sl_backPanel.putConstraint(SpringLayout.SOUTH, btnBack, -7, SpringLayout.SOUTH, backPanel);
		sl_backPanel.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, backPanel);
		backPanel.add(btnBack);
		
		btnNext.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
								
				int num=obj.getCurrentSection()+1;
				obj.setCurrentSection(num);
				
				ViewSectionPanel viewPanel=new ViewSectionPanel(obj,gui);
				
				gui.panelCenter.removeAll();
				gui.panelCenter.add(viewPanel);
				
				gui.txtTest.setVisible(false);
				gui.lblTest.setVisible(true);
				
				gui.validate();
				gui.repaint();
				
				/*
				if(num==obj.section.size()+1)
				{
					btnNext.setVisible(false);
				}
				else
				{
					btnNext.setVisible(true);
				}
				*/
			 }
			});
		
		btnPrevious.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
							
				int num=obj.getCurrentSection()-1;
				obj.setCurrentSection(num);
				
				ViewSectionPanel viewPanel=new ViewSectionPanel(obj,gui);
				
				gui.panelCenter.removeAll();
				gui.panelCenter.add(viewPanel);
				
				gui.txtTest.setVisible(false);
				gui.lblTest.setVisible(true);
				
				gui.validate();
				gui.repaint();
				
				/*
				if(num==1)
				{
					btnPrevious.setVisible(false);
				}
				else
				{
					btnPrevious.setVisible(true);
				}
				*/
			 }
			});
		

	}
}
