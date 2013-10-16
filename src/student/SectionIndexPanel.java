package student;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import backend.StudentTestController;
import backend.Test_;
import backend.Section;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class SectionIndexPanel extends JPanel {
	
    private StudentTestController controller;
    private ArrayList<Section> sections;

    /**
     * Create the panel.
     */
    public SectionIndexPanel(final StudentTestController controller) {
        this.controller = controller;
        
        controller.setSectionIndexPanel(this); // Passes a reference to section index panel to the controller
        
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
        sections = controller.getTest().getAllSections();
        int i=0;
	for(Section section: sections){
            buildSectionChooserPanel(i++);
        }
        
        JButton buttonSubmitTest = new JButton("Submit Test");
	buttonSubmitTest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {controller.endTest();}
	});
	GridBagConstraints gbc_buttonSubmitTest = new GridBagConstraints();
	//gbc_buttonSubmitTest.anchor = GridBagConstraints.NORTH;
	gbc_buttonSubmitTest.gridx = 0;
	gbc_buttonSubmitTest.gridy = 1000;
	this.add(buttonSubmitTest, gbc_buttonSubmitTest); 
    }
    
    private void buildSectionChooserPanel(int index) {
        SectionChooserPanel panel = new SectionChooserPanel(controller, sections.get(index), this);
        if(index!=0){
        	//panel.setbuttonSelectEnabled(false);
        }
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = index;
        add(panel, gbc_panel);
    }
}