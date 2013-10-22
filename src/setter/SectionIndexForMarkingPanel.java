package setter;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;

import backend.Section;

/**
 * @author Dimitrios Chondrokoukis
 * 
 */

public class SectionIndexForMarkingPanel extends JPanel {
	private ArrayList<Section> sections;
	private ArrayList<SectionChooserForMarkingPanel> sectionChooserPanels = new ArrayList<>();
	
	/**
	 * Create the panel.
	 */
	public SectionIndexForMarkingPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel lblMarkTest = new JLabel("Mark Test");
		panel.add(lblMarkTest);
		
		JPanel panelSections = new JPanel();
		GridBagConstraints gbc_panelSections = new GridBagConstraints();
		gbc_panelSections.insets = new Insets(0, 0, 5, 0);
		gbc_panelSections.fill = GridBagConstraints.BOTH;
		gbc_panelSections.gridx = 0;
		gbc_panelSections.gridy = 1;
		add(panelSections, gbc_panelSections);
		GridBagLayout gbl_panelSections = new GridBagLayout();
		gbl_panelSections.columnWidths = new int[]{0};
		gbl_panelSections.rowHeights = new int[]{0};
		gbl_panelSections.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelSections.rowWeights = new double[]{Double.MIN_VALUE};
		panelSections.setLayout(gbl_panelSections);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.EAST;
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		
		JButton btnEndMarking = new JButton("End Marking");
		panel_2.add(btnEndMarking);

	}

}
