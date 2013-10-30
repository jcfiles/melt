package setter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Erotokritou Zoe
 */
public class EmptyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmptyPanel(final SetterTestController obj, final SetterGUI gui) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(173, 216, 230));
		add(centerPanel, BorderLayout.CENTER);
		
		Border raised= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		centerPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, Color.BLACK));
		SpringLayout sl_centerPanel = new SpringLayout();
		centerPanel.setLayout(sl_centerPanel);
		JLabel lblAdd=new JLabel("Add Content");
		lblAdd.setFont(new Font("MV Boli", Font.PLAIN, 15));
		sl_centerPanel.putConstraint(SpringLayout.NORTH, lblAdd, 31, SpringLayout.NORTH, centerPanel);
		sl_centerPanel.putConstraint(SpringLayout.WEST, lblAdd, 84, SpringLayout.WEST, centerPanel);
		sl_centerPanel.putConstraint(SpringLayout.EAST, lblAdd, -81, SpringLayout.EAST, centerPanel);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblAdd);
		
		JButton btnAddQuestion = new JButton("Add Question");
		sl_centerPanel.putConstraint(SpringLayout.NORTH, btnAddQuestion, 78, SpringLayout.NORTH, centerPanel);
		sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblAdd, -16, SpringLayout.NORTH, btnAddQuestion);
		btnAddQuestion.setFont(new Font("MV Boli", Font.PLAIN, 15));
		sl_centerPanel.putConstraint(SpringLayout.WEST, btnAddQuestion, 10, SpringLayout.WEST, centerPanel);
		centerPanel.add(btnAddQuestion);
		
		JButton btnAddSubsection = new JButton("Add Subsection");
		sl_centerPanel.putConstraint(SpringLayout.NORTH, btnAddSubsection, 0, SpringLayout.NORTH, btnAddQuestion);
		sl_centerPanel.putConstraint(SpringLayout.EAST, btnAddSubsection, -10, SpringLayout.EAST, centerPanel);
		btnAddSubsection.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(btnAddSubsection);
		
		
		btnAddQuestion.addActionListener(new ActionListener(){  //button to save the question
			public void actionPerformed(ActionEvent e) {
				
		    	  
				AddQuestionPanel panel=new AddQuestionPanel(obj,gui,false);		
		
				gui.centerPanel.removeAll();
				gui.centerPanel.add(panel);
										
				gui.centerPanel.validate();
				gui.centerPanel.repaint();

			}
		});
		
		
		btnAddSubsection.addActionListener(new ActionListener(){  //button to save the question
			public void actionPerformed(ActionEvent e) {
				
			    
				SubsectionPanel panelS= new SubsectionPanel(obj, gui,0);
		
				gui.centerPanel.removeAll();
				gui.centerPanel.add(panelS);
								
				gui.centerPanel.validate();
				gui.centerPanel.repaint();
					
			}
		});
	}
}
