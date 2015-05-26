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

import backend.Section;
import backend.Subsection;

import java.awt.LayoutManager;

/*
 * @author Erotokritou Zoe
 */
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

		
		int content=0;//obj.getContainerSize(gui.current.getUserObject() );
		
		if(content==0)
		{
			//gui.parent=gui.current;
			
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
		}
		else
		{
		
			SubsectionPanel panelS= new SubsectionPanel(obj, gui,1);
					
			centerPanel.removeAll();
			centerPanel.add(panelS);
								
			centerPanel.validate();
			centerPanel.repaint();
		}		
	}

}
