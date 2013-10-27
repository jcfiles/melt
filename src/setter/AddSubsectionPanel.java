package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubsectionPanel extends JPanel {
		
	private JTextField txtSubsection;
	/**
	 * Create the panel.
	 */
	public AddSubsectionPanel() {
		
		Border raised= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		JPanel centerPanel=new JPanel();
		centerPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, Color.BLACK));
		centerPanel.setBackground(new Color(173, 216, 230));
		
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
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -10, SpringLayout.SOUTH, centerPanel);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -10, SpringLayout.EAST, centerPanel);
		btnSave.setPreferredSize(new Dimension(70, 35));
		centerPanel.add(btnSave);
		
		txtSubsection = new JTextField();
		txtSubsection.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.WEST, txtSubsection, 0, SpringLayout.WEST, lblS);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSubsection, 0, SpringLayout.SOUTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, txtSubsection, -8, SpringLayout.WEST, btnSave);
		centerPanel.add(txtSubsection);
		txtSubsection.setColumns(10);
		
		btnSave.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {

		    
		    	/*lblFill.setVisible(false);	    	
		    	typeQuestion=2;		
		    	
		    	AddEssay essayPanel=new AddEssay(obj);
		    	
		    	panel_mult.removeAll();
		    	panel_mult.add(essayPanel);
												
				panel_mult.validate();
				panel_mult.repaint();*/
		    	
			    }
		});
		
		
	}

}
