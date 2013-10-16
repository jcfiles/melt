package student;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import backend.Section;
import backend.StudentTestController;

public class SectionInfoPanel extends JPanel {

    StudentTestController controller;
	
    /**
     * Create the panel.
     */
    public SectionInfoPanel(final StudentTestController controller, final Section section, final SectionIndexPanel sectionIndexPanel) {
        this.controller = controller;
        setLayout(new BorderLayout(0, 0));
        JLabel labelSectionTitle = new JLabel(section.getSectionTitle());
	labelSectionTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	labelSectionTitle.setHorizontalAlignment(SwingConstants.CENTER);
	add(labelSectionTitle, BorderLayout.NORTH);
	JScrollPane scrollPane = new JScrollPane();
	add(scrollPane, BorderLayout.CENTER);
	JPanel panel = new JPanel();
	scrollPane.setViewportView(panel);
	GridBagLayout gbl_panel = new GridBagLayout();
	gbl_panel.columnWidths = new int[]{0, 0};
	gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
	gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	panel.setLayout(gbl_panel);
	JPanel panel_2 = new JPanel();
	GridBagConstraints gbc_panel_2 = new GridBagConstraints();
	gbc_panel_2.insets = new Insets(0, 10, 5, 0);
	gbc_panel_2.fill = GridBagConstraints.BOTH;
	gbc_panel_2.gridx = 0;
	gbc_panel_2.gridy = 0;
	panel.add(panel_2, gbc_panel_2);
	GridBagLayout gbl_panel_2 = new GridBagLayout();
	gbl_panel_2.columnWidths = new int[]{0, 0};
	gbl_panel_2.rowHeights = new int[]{0, 0, 0};
	gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	panel_2.setLayout(gbl_panel_2);
	JLabel lblInstructions = new JLabel("Instructions");
	lblInstructions.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
	gbc_lblInstructions.anchor = GridBagConstraints.WEST;
	gbc_lblInstructions.insets = new Insets(0, 0, 5, 0);
	gbc_lblInstructions.gridx = 0;
	gbc_lblInstructions.gridy = 0;
	panel_2.add(lblInstructions, gbc_lblInstructions);
	JTextArea textAreaInstructions = new JTextArea();
	textAreaInstructions.setEditable(false);
	textAreaInstructions.setText(section.getSectionIntroText());
	GridBagConstraints gbc_textAreaInstructions = new GridBagConstraints();
	gbc_textAreaInstructions.anchor = GridBagConstraints.WEST;
	gbc_textAreaInstructions.gridx = 0;
	gbc_textAreaInstructions.gridy = 1;
	panel_2.add(textAreaInstructions, gbc_textAreaInstructions);
	JPanel panel_3 = new JPanel();
	GridBagConstraints gbc_panel_3 = new GridBagConstraints();
	gbc_panel_3.insets = new Insets(0, 10, 5, 0);
	gbc_panel_3.fill = GridBagConstraints.BOTH;
	gbc_panel_3.gridx = 0;
	gbc_panel_3.gridy = 1;
	panel.add(panel_3, gbc_panel_3);
	GridBagLayout gbl_panel_3 = new GridBagLayout();
	gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
	gbl_panel_3.rowHeights = new int[]{0, 0};
	gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_3.setLayout(gbl_panel_3);
        
	JLabel lblTotalTime = new JLabel("Total Time:");
	lblTotalTime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	GridBagConstraints gbc_lblTotalTime = new GridBagConstraints();
	gbc_lblTotalTime.anchor = GridBagConstraints.WEST;
	gbc_lblTotalTime.insets = new Insets(0, 0, 0, 5);
	gbc_lblTotalTime.gridx = 0;
	gbc_lblTotalTime.gridy = 0;
	panel_3.add(lblTotalTime, gbc_lblTotalTime);
        
	JLabel labelTime = new JLabel(String.valueOf(section.getSectionTime()));
	GridBagConstraints gbc_labelTime = new GridBagConstraints();
	gbc_labelTime.anchor = GridBagConstraints.WEST;
	gbc_labelTime.insets = new Insets(0, 0, 0, 5);
	gbc_labelTime.gridx = 1;
	gbc_labelTime.gridy = 0;
	panel_3.add(labelTime, gbc_labelTime);
		
	JLabel lblMin = new JLabel("min.");
	GridBagConstraints gbc_lblMin = new GridBagConstraints();
	gbc_lblMin.anchor = GridBagConstraints.WEST;
	gbc_lblMin.gridx = 2;
	gbc_lblMin.gridy = 0;
	panel_3.add(lblMin, gbc_lblMin);
		
	JPanel panel_4 = new JPanel();
	GridBagConstraints gbc_panel_4 = new GridBagConstraints();
	gbc_panel_4.fill = GridBagConstraints.BOTH;
	gbc_panel_4.gridx = 0;
	gbc_panel_4.gridy = 2;
	panel.add(panel_4, gbc_panel_4);
	GridBagLayout gbl_panel_4 = new GridBagLayout();
	gbl_panel_4.columnWidths = new int[]{0, 0, 0};
	gbl_panel_4.rowHeights = new int[]{0, 0};
	gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_4.setLayout(gbl_panel_4);
		
	JLabel lblTotalMarks = new JLabel("Total Marks:");
	lblTotalMarks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	GridBagConstraints gbc_lblTotalMarks = new GridBagConstraints();
	gbc_lblTotalMarks.anchor = GridBagConstraints.WEST;
	gbc_lblTotalMarks.insets = new Insets(0, 10, 0, 5);
	gbc_lblTotalMarks.gridx = 0;
	gbc_lblTotalMarks.gridy = 0;
	panel_4.add(lblTotalMarks, gbc_lblTotalMarks);
		
        JLabel labelPoints = new JLabel(String.valueOf(section.getPossibleSectionMarks()));
	GridBagConstraints gbc_labelPoints = new GridBagConstraints();
	gbc_labelPoints.anchor = GridBagConstraints.WEST;
	gbc_labelPoints.gridx = 1;
	gbc_labelPoints.gridy = 0;
	panel_4.add(labelPoints, gbc_labelPoints);
		
	JPanel panel_1 = new JPanel();
	add(panel_1, BorderLayout.SOUTH);
		
	JButton buttonBack = new JButton("Back");
	buttonBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {MainGui.setComposite(sectionIndexPanel);}
	});
	panel_1.add(buttonBack);
	JButton buttonStart = new JButton("Start");
	buttonStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {controller.startSection(section);}
	});
	panel_1.add(buttonStart);
    }
}