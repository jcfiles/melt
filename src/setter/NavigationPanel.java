package setter;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.Dimension;

/*
 * @author Erotokritou Zoe
 */

public class NavigationPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public NavigationPanel(final SetterTestController obj, final AddQuestionGUI gui, final AddSectionGUI sec) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel navigationPanel = new JPanel();
		add(navigationPanel);
		navigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrevious = new JButton();
		btnPrevious.setIcon(new ImageIcon(SectionNavigationPanel.class.getResource("/lib/images/previous.png")));
		navigationPanel.add(btnPrevious);		
		JButton btnNext = new JButton();
		btnNext.setIcon(new ImageIcon(SectionNavigationPanel.class.getResource("/lib/images/next.png")));
		navigationPanel.add(btnNext);	
		
		JPanel backPanel = new JPanel();
		add(backPanel);
		SpringLayout sl_backPanel = new SpringLayout();
		backPanel.setLayout(sl_backPanel);
		
		JButton btnBack = new JButton("Back");
		sl_backPanel.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, backPanel);
		sl_backPanel.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, backPanel);
		backPanel.add(btnBack);
		
		JButton btnSaveTest = new JButton("Save Test");
		sl_backPanel.putConstraint(SpringLayout.SOUTH, btnSaveTest, 0, SpringLayout.SOUTH, btnBack);
		sl_backPanel.putConstraint(SpringLayout.EAST, btnSaveTest, -10, SpringLayout.EAST, backPanel);
		backPanel.add(btnSaveTest);
		
		btnNext.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
			/*					
				int num=obj.getCurrentQuestion()+1;
				
				if(num!=obj.countQuestion()){
				
					obj.setCurrentQuestion(num);
					int type=obj.getQuestionType();
				
					if(type==0)
					{
						MultichoicePanel panel=new MultichoicePanel(obj,gui);
						gui.panelCenter.removeAll();
						gui.panelCenter.add(panel);
					}
					else
					{
						FillBlankPanel panel=new FillBlankPanel(obj,gui);
						gui.panelCenter.removeAll();
						gui.panelCenter.add(panel);
					}
				
					gui.validate();
					gui.repaint();
				}*/
			}
		});
		
		btnPrevious.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
							
			/*	int num=obj.getCurrentQuestion()-1;
				
				if(num!=-1){
					
					obj.setCurrentQuestion(num);				
					int type=obj.getQuestionType();
				
					if(type==0)
					{
						MultichoicePanel panel=new MultichoicePanel(obj,gui);
						gui.panelCenter.removeAll();
						gui.panelCenter.add(panel);
					}
					else
					{
						FillBlankPanel panel=new FillBlankPanel(obj,gui);
						gui.panelCenter.removeAll();
						gui.panelCenter.add(panel);
					}
				
					gui.validate();
					gui.repaint();
					}	*/
			 	}
			});	
		btnBack.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
				/*
				gui.dispose();
				
				ViewSectionPanel view=new ViewSectionPanel(obj,sec);
				
				sec.panelCenter.removeAll();
				sec.panelCenter.add(view);
				
				sec.validate();
				sec.repaint();
				sec.setVisible(true);
				
				*/
			}
		});
	}
}
