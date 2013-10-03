package student;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.util.List;

public class SectionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3815318201709212642L;
	private List<Questions> questions;
	/**
	 * 
	 */

	/**
	 * Create the panel.
	 */
	public SectionPanel(List<Questions> questions) {
		this.questions = questions;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel lblSection = new JLabel("Section 1");
		lblSection.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSection.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSection);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		JTextArea txtrInThisSection = new JTextArea();
		txtrInThisSection.setBackground(SystemColor.window);
		txtrInThisSection.setText(" In this section you will answer to some random questions");
		panel_1.add(txtrInThisSection);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		MCQuestionPanel questionpanel1 = new MCQuestionPanel();
		GridBagConstraints gbc_questionpanel1 = new GridBagConstraints();
		gbc_questionpanel1.insets = new Insets(0, 0, 5, 0);
		gbc_questionpanel1.fill = GridBagConstraints.BOTH;
		gbc_questionpanel1.gridx = 0;
		gbc_questionpanel1.gridy = 0;
		panel_2.add(questionpanel1, gbc_questionpanel1);
		
		FIBQuestionPanel questionpanel2 = new FIBQuestionPanel();
		GridBagConstraints gbc_questionpanel2 = new GridBagConstraints();
		gbc_questionpanel2.fill = GridBagConstraints.BOTH;
		gbc_questionpanel2.gridx = 0;
		gbc_questionpanel2.gridy = 1;
		panel_2.add(questionpanel2, gbc_questionpanel2);	
	}

	public List<Questions> getQuestions() {
		return questions;
	}
}
