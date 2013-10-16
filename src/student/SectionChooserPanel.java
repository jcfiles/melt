package student;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import backend.Section;
import backend.StudentTestController;
/**
 * @author Dimitrios Chondrokoukis
 * 
 */
public class SectionChooserPanel extends JPanel {

    StudentTestController controller;
    private JButton buttonSelect;
    
    /**
     * Create the panel.
     */
    public SectionChooserPanel(final StudentTestController controller,
            final Section section, final SectionIndexPanel sectionIndexPanel) {
        this.controller = controller;
        setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	JPanel panel = new JPanel();
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.insets = new Insets(0, 0, 0, 5);
	gbc_panel.fill = GridBagConstraints.BOTH;
	gbc_panel.gridx = 0;
	gbc_panel.gridy = 0;
	add(panel, gbc_panel);
	GridBagLayout gbl_panel = new GridBagLayout();
	gbl_panel.columnWidths = new int[]{0, 0};
	gbl_panel.rowHeights = new int[]{0, 0, 0};
	gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	panel.setLayout(gbl_panel);
        
	JLabel labelSectionTitle = new JLabel(section.getSectionTitle() + ": " + section.getSectionIntroText());
        
	labelSectionTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	GridBagConstraints gbc_labelSectionTitle = new GridBagConstraints();
	gbc_labelSectionTitle.anchor = GridBagConstraints.WEST;
	gbc_labelSectionTitle.insets = new Insets(10, 10, 0, 0);
	gbc_labelSectionTitle.gridx = 0;
	panel.add(labelSectionTitle, gbc_labelSectionTitle);
	JPanel panel_1 = new JPanel();
	GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	gbc_panel_1.anchor = GridBagConstraints.WEST;
	gbc_panel_1.insets = new Insets(0, 20, 10, 0);
	gbc_panel_1.fill = GridBagConstraints.VERTICAL;
	gbc_panel_1.gridx = 0;
	panel.add(panel_1, gbc_panel_1);
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	gbl_panel_1.columnWidths = new int[]{0, 0};
	gbl_panel_1.rowHeights = new int[]{0, 0};
	gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_1.setLayout(gbl_panel_1);
	JLabel labelSubsectionTitle = new JLabel(""); // Unused
	GridBagConstraints gbc_labelSubsectionTitle = new GridBagConstraints();
	gbc_labelSubsectionTitle.gridx = 0;
	gbc_labelSubsectionTitle.gridy = 0;
	panel_1.add(labelSubsectionTitle, gbc_labelSubsectionTitle);
	buttonSelect = new JButton(">");
	buttonSelect.setEnabled(false);
	buttonSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		MainGui.setComposite(new SectionInfoPanel(controller, section, sectionIndexPanel));
            }
	});
	GridBagConstraints gbc_buttonSelect = new GridBagConstraints();
	gbc_buttonSelect.gridx = 1;
	gbc_buttonSelect.gridy = 0;
	add(buttonSelect, gbc_buttonSelect);
    }
    
    /*
     * Sets the selection button enabled or disabled
     */
    public void setbuttonSelectEnabled(boolean enabled){
    	buttonSelect.setEnabled(enabled);
    }
}
