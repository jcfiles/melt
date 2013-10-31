package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import backend.Subsection;

/*
 * @author Erotokritou Zoe
 */
public class SubsectionPanel extends JPanel {

	private GridBagConstraints gbc_1;
	private EmptyPanel panel_1;
	private JLabel lblTitle =new JLabel("TestA: SectionA");
	/**
	 * Create the panel.
	 */
	public SubsectionPanel(final SetterTestController obj, final SetterGUI gui, int type) {
			
		setLayout(new BorderLayout(20, 20));
		
		//Title panel
		JPanel titlePanel = new JPanel();		
		add(titlePanel, BorderLayout.NORTH);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0};
		gbl_titlePanel.rowHeights = new int[]{10,10};
		gbl_titlePanel.columnWeights = new double[]{0.0};
		gbl_titlePanel.rowWeights = new double[]{Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
						
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 1;	
		lblTitle.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		titlePanel.add(lblTitle,gbc_lbl);				
		
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		
		GridBagLayout gbl_mainList = new GridBagLayout();
		gbl_mainList.columnWeights = new double[]{};
		gbl_mainList.rowHeights=new int[] {0, 0};
		JPanel ok = new JPanel(gbl_mainList); 
		
		
		GridBagConstraints gbc = new GridBagConstraints();
	
		
		
			int count=obj.getContainerSize(gui.current.getUserObject());
		
		for (int i=0; i<count; i++){
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx = 0;
		gbc.gridy = i;
		ViewSubsectionPanel panel=new ViewSubsectionPanel(gui,obj, obj.getSubsectionTitle(gui.current.getUserObject(), i));
		panel.btnEdit.setActionCommand(i+"");
		panel.btnDelete.setActionCommand(i+"");
		panel.setPreferredSize(new Dimension(400,140));
		ok.add(panel,gbc);
		}
		
		
		
		if(type==0)
		{
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.gridx = 0;
			gbc.gridy = 3;
			//panel=new EmptyPanel(obj,gui);
			AddSubsectionPanel panel=new AddSubsectionPanel(gui,obj,false,0);
			panel.setPreferredSize(new Dimension(400,140));
			ok.add(panel,gbc);
		}
		
		JScrollPane scrollPane = new JScrollPane(ok);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		centerPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(SubsectionPanel.class.getResource("/lib/images/plus.png")));
		btnAdd.setBackground(new Color(0, 153, 0));
		btnAdd.setPreferredSize(new Dimension(40,40));
		panel.add(btnAdd, BorderLayout.EAST);
		
		
		btnAdd.addActionListener(new ActionListener(){	//button to add new subsection
			public void actionPerformed(ActionEvent e) {
				
				
				SubsectionPanel addPanel=new SubsectionPanel(obj,gui,0);
				
				gui.centerPanel.removeAll();
				gui.centerPanel.add(addPanel);
				
				gui.centerPanel.validate();
				gui.centerPanel.repaint();
			}
		});

	}

}
