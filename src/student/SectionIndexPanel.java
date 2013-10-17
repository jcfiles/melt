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
import java.awt.Insets;

/**
 * 
 * @author Dimitrios Chondrokoukis
 * @contributor Bruce Steedman
 */
public class SectionIndexPanel extends JPanel {
	
    private StudentTestController controller;
    private ArrayList<Section> sections;
    private ArrayList<SectionChooserPanel> sectionChooserPanels = new ArrayList<>();
    private JPanel panelSections;
    private int index;

    /**
     * Create the panel.
     */
    public SectionIndexPanel(final StudentTestController controller) {
        this.controller = controller;
        controller.setSectionIndexPanel(this); // Passes a reference to section index panel to the controller
        
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	panelSections = new JPanel();
    sections = controller.getTest().getAllSections();
    
	GridBagConstraints gbc_panelSections = new GridBagConstraints();
	gbc_panelSections.anchor = GridBagConstraints.NORTH;
	gbc_panelSections.insets = new Insets(0, 0, 5, 0);
	gbc_panelSections.fill = GridBagConstraints.HORIZONTAL;
	gbc_panelSections.gridx = 0;
	gbc_panelSections.gridy = getComponentCount();
	add(panelSections, gbc_panelSections);
	GridBagLayout gbl_panelSections = new GridBagLayout();
	gbl_panelSections.columnWidths = new int[]{0, 0};
	gbl_panelSections.rowHeights = new int[]{0, 0, 0};
	gbl_panelSections.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_panelSections.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	panelSections.setLayout(gbl_panelSections);
	
	JPanel panelBack = new JPanel();
	GridBagConstraints gbc_panelBack = new GridBagConstraints();
	gbc_panelBack.fill = GridBagConstraints.BOTH;
	gbc_panelBack.gridx = 0;
	gbc_panelBack.gridy = getComponentCount();
	add(panelBack, gbc_panelBack);
	GridBagLayout gbl_panelBack = new GridBagLayout();
	gbl_panelBack.columnWidths = new int[]{75, 0};
	gbl_panelBack.rowHeights = new int[]{29, 0};
	gbl_panelBack.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_panelBack.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panelBack.setLayout(gbl_panelBack);
	
	JButton buttonBack = new JButton("Back");
	GridBagConstraints gbc_buttonBack = new GridBagConstraints();
	gbc_buttonBack.gridx = 0;
	gbc_buttonBack.gridy = 0;
	panelBack.add(buttonBack, gbc_buttonBack);
	buttonBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {controller.endTest();}
	});
	
	int i=0;
	for(Section section: sections){
            buildSectionChooserPanel(i++);
        }
    }
    
    private void buildSectionChooserPanel(int index) {
        SectionChooserPanel panel = new SectionChooserPanel(controller, sections.get(index), this);
        sectionChooserPanels.add(panel);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.anchor = GridBagConstraints.NORTH;
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = index;
        panelSections.add(panel, gbc_panel);
    }
    
    public void EnableNextButton(){
    	if(index>0){
    		sectionChooserPanels.get(index-1).setbuttonSelectEnabled(false);
    	}
    	sectionChooserPanels.get(index).setbuttonSelectEnabled(true);
    	index++;
    }
}