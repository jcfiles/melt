package setter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import java.awt.LayoutManager;

public class SubsectionContentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel titlePanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JLabel lblTitle =new JLabel("TestA: SectionA");
	private JTextArea txtIntroduction = new JTextArea();
	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private GridBagConstraints gbc_1;
	private EmptyPanel panel_1;
	
	
	/**
	 * Create the panel.
	 */
	public SubsectionContentPanel(final SetterTestController obj, final SetterGUI gui) {
		setLayout(new BorderLayout(20, 20));

		//Title panel
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
		centerPanel.setBorder(null);
		
		//Center Panel
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(20, 20));
		
		
		GridBagLayout gbl_mainList = new GridBagLayout();
		gbl_mainList.columnWeights = new double[]{0.0};
		gbl_mainList.rowHeights=new int[] {0, 0};
		JPanel mainList = new JPanel(gbl_mainList); 
		mainList.setPreferredSize(new Dimension(500,500));
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		EmptyPanel  panel=new EmptyPanel(obj,gui);
	
		/*
		for (int i=0; i<5; i++){
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = i+1;
		panel=new EmptyPanel();
		panel.setPreferredSize(new Dimension(300,125));
		mainList.add(panel,gbc);
		
		}*/
		
		gbc_1 = new GridBagConstraints();
		gbc_1.anchor = GridBagConstraints.NORTH;
		gbc_1.gridx = 0;
		gbc_1.gridy = 1;
		panel_1=new EmptyPanel(obj,gui);
		panel_1.setBorder(null);
		panel_1.setPreferredSize(new Dimension(300,130));
		mainList.add(panel_1,gbc_1);
		
		JScrollPane scrollPane = new JScrollPane(mainList);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
				
		
		int content=0;

		
		if(content==1)
		{
			//find the type
			
		}
		
		if(content==2)
		{		
			SubsectionPanel panelS= new SubsectionPanel(obj, gui);
			
			gui.centerPanel.removeAll();
			gui.centerPanel.add(panelS);
									
			gui.centerPanel.validate();
			gui.centerPanel.repaint();
		}
		
		
		
		
		
		
		/*
		//Buttons Panel
		add(buttonsPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_buttonsPanel = new GridBagLayout();
		gbl_buttonsPanel.columnWidths = new int[]{0};
		gbl_buttonsPanel.rowHeights = new int[]{0};
		gbl_buttonsPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_buttonsPanel.rowWeights = new double[]{Double.MIN_VALUE};
		buttonsPanel.setLayout(gbl_buttonsPanel);
		
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.insets = new Insets(0, 0, 5, 5);
		gbc_btn.gridx = 0;
		gbc_btn.gridy = 1;	
		buttonsPanel.add(btnSave,gbc_btn);
		btnSave.setFont(new Font("MV Boli", Font.PLAIN, 15));
		btnSave.setPreferredSize(new Dimension(100, 35));
		 */

	}

}
