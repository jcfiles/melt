package student;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;

import java.awt.CardLayout;

public class TestPanelNew extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TestPanelNew() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		panel.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblTestA = new JLabel("Test A:");
		GridBagConstraints gbc_lblTestA = new GridBagConstraints();
		gbc_lblTestA.anchor = GridBagConstraints.EAST;
		gbc_lblTestA.insets = new Insets(0, 0, 0, 5);
		gbc_lblTestA.gridx = 0;
		gbc_lblTestA.gridy = 0;
		panel_8.add(lblTestA, gbc_lblTestA);
		
		JLabel lblSectionA = new JLabel("Section A");
		GridBagConstraints gbc_lblSectionA = new GridBagConstraints();
		gbc_lblSectionA.anchor = GridBagConstraints.WEST;
		gbc_lblSectionA.gridx = 1;
		gbc_lblSectionA.gridy = 0;
		panel_8.add(lblSectionA, gbc_lblSectionA);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblNewLabel = new JLabel("30");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_9.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("minutes remaining");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_9.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Vocabulary");
		panel_3.add(lblNewLabel_1);
		
		JLabel label = new JLabel(">");
		panel_3.add(label);
		
		JLabel lblHospital = new JLabel("Hospital");
		panel_3.add(lblHospital);
		
		JPanel scrollPane_1 = new JPanel();
		panel_2.add(scrollPane_1, BorderLayout.WEST);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Q1"},
			},
			new String[] {
				"Questions"
			}
		));
		scrollPane_1.add(table);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_5.add(scrollPane, gbc_scrollPane);
		
		JPanel panel_6 = new JPanel();
		scrollPane.setViewportView(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 1;
		panel_5.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JButton btnPrevious = new JButton("Previous");
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrevious.anchor = GridBagConstraints.EAST;
		gbc_btnPrevious.gridx = 0;
		gbc_btnPrevious.gridy = 0;
		panel_7.add(btnPrevious, gbc_btnPrevious);
		
		JButton btnNext = new JButton("Next");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.anchor = GridBagConstraints.WEST;
		gbc_btnNext.gridx = 1;
		panel_7.add(btnNext, gbc_btnNext);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{117, 0};
		gbl_panel_1.rowHeights = new int[]{29, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton = new JButton("Submit");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);

	}

}
