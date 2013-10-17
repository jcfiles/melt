package setter;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.SpringLayout;

import student.MainGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * @author Erotokritou Zoe
 */
public class SetterPanel extends JPanel {

	JButton btnNewTest=new JButton("New Test");
	JButton btnPreview=new JButton("Preview Test");
	
	/**
	 * Create the panel.
	 */
	public SetterPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{33, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{91, 33, 33, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_btnNewTest = new GridBagConstraints();
		gbc_btnNewTest.fill = GridBagConstraints.BOTH;
		gbc_btnNewTest.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewTest.gridx = 1;
		gbc_btnNewTest.gridy = 1;
		add(btnNewTest, gbc_btnNewTest);
		GridBagConstraints gbc_btnPreview = new GridBagConstraints();
		gbc_btnPreview.insets = new Insets(0, 0, 0, 5);
		gbc_btnPreview.fill = GridBagConstraints.BOTH;
		gbc_btnPreview.gridx = 1;
		gbc_btnPreview.gridy = 2;
		btnPreview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainGui.isSetter = true;
				MainGui maingui = new MainGui();
				maingui.main(null);
			}
		});
		add(btnPreview, gbc_btnPreview);
	}
}
