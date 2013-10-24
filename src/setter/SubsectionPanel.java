package setter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubsectionPanel extends JPanel {

	private GridBagConstraints gbc_1;
	private EmptyPanel panel_1;
	private JLabel lblTitle =new JLabel("TestA: SectionA");
	/**
	 * Create the panel.
	 */
	public SubsectionPanel(final SetterTestController obj, final SetterGUI gui) {
			
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
		
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		
		GridBagLayout gbl_mainList = new GridBagLayout();
		gbl_mainList.columnWeights = new double[]{0.0};
		gbl_mainList.rowHeights=new int[] {0, 0};
		JPanel mainList = new JPanel(gbl_mainList); 
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		EmptyPanel  panel=new EmptyPanel(obj,gui);
		
		/*gbc_1 = new GridBagConstraints();
		gbc_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_1.anchor = GridBagConstraints.NORTH;
		gbc_1.gridx = 0;
		gbc_1.gridy = 1;
		panel_1=new EmptyPanel(obj,gui);
		panel_1.setPreferredSize(new Dimension(300,130));
		mainList.add(panel_1,gbc_1);
	*/
		
		for (int i=0; i<7; i++){
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx = 0;
		gbc.gridy = i+1;
		panel=new EmptyPanel(obj,gui);
		panel.setPreferredSize(new Dimension(300,130));
		mainList.add(panel,gbc);
		
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane(mainList);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		

	}

}
