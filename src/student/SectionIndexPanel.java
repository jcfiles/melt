package student;

import javax.swing.JPanel;

import backend.Section;
import backend.StudentTestController;
import backend.Test_;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

public class SectionIndexPanel extends JPanel {
	
	private ArrayList<Section> sections;
        StudentTestController controller;

	/**
	 * Create the panel.
	 */
	public SectionIndexPanel(StudentTestController controller, Test_ test) {
            this.controller = controller;	
            sections = test.getAllSections();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		int i=0;
		for(Section section: sections){
			SectionForChoosePanel panel = new SectionForChoosePanel(controller, section, SectionIndexPanel.this);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = i;
			add(panel, gbc_panel);
			i++;
		}
	}
}
