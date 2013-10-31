package setter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import backend.Subsection;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Erotokritou Zoe
 */
public class ViewSubsectionPanel extends JPanel {

	JButton btnEdit = new JButton("");
	JButton btnDelete = new JButton("");
	
	/**
	 * Create the panel.
	 */
	public ViewSubsectionPanel(final SetterGUI  gui,final SetterTestController obj, String title) {
		
	
		Border raised= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		JPanel centerPanel=new JPanel();
		centerPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
		centerPanel.setBackground(Color.WHITE);
		
		setLayout(new BorderLayout(10, 10));
		
		add(new JPanel(),BorderLayout.NORTH);
		add(new JPanel(),BorderLayout.SOUTH);
		add(new JPanel(),BorderLayout.WEST);
		add(new JPanel(),BorderLayout.EAST);
		
		add(centerPanel,BorderLayout.CENTER);
		
		SpringLayout springLayout = new SpringLayout();
		centerPanel.setLayout(springLayout);
		
		JLabel lblS = new JLabel("Subsection:");
		springLayout.putConstraint(SpringLayout.NORTH, lblS, 10, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblS, 10, SpringLayout.WEST, centerPanel);
		lblS.setFont(new Font("MV Boli", Font.PLAIN, 15));
		centerPanel.add(lblS);
		
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.setIcon(new ImageIcon(ViewSubsectionPanel.class.getResource("/lib/images/edit.png")));		
		btnEdit.setPreferredSize(new Dimension(35, 35));
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 10, SpringLayout.NORTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -10, SpringLayout.EAST, centerPanel);
		centerPanel.add(btnEdit);
				
		btnDelete.setIcon(new ImageIcon(ViewSubsectionPanel.class.getResource("/lib/images/cross.png")));
		btnDelete.setBackground(new Color(204, 0, 0));
		btnDelete.setPreferredSize(new Dimension(35, 35));
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, btnEdit);
		centerPanel.add(btnDelete);
		
		JLabel lblSubsection = new JLabel(title);
		springLayout.putConstraint(SpringLayout.NORTH, lblSubsection, 20, SpringLayout.SOUTH, lblS);
		springLayout.putConstraint(SpringLayout.WEST, lblSubsection, 0, SpringLayout.WEST, lblS);
		springLayout.putConstraint(SpringLayout.EAST, lblSubsection, -6, SpringLayout.WEST, btnDelete);
		lblSubsection.setFont(new Font("Verdana", Font.PLAIN, 13));
		centerPanel.add(lblSubsection);
		
		
		
		btnEdit.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	
			    }
		});
		
		btnDelete.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    	String index=e.getActionCommand();
		    	int num=Integer.parseInt(index);
		    	
		    	Subsection s=obj.deleteSubsection(gui.current.getUserObject(),num);
		    	
		    	gui.removeSubsection(s);
		    	
			    }
		});
	}	
}
