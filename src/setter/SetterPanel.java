package setter;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.SpringLayout;

import student.MainGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

/*
 * @author Erotokritou Zoe
 */
public class SetterPanel extends JPanel {

	JButton btnNewTest=new JButton("New Test");
	JButton btnPreview=new JButton("Preview Test");
	JButton btnMark=new JButton("Mark Test");
	JButton btnLoadTest = new JButton("Load Test");
	
	/**
	 * Create the panel.
	 */
	public SetterPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 5,0};
		//gridBagLayout.columnWidths = new int[]{77, 95, 0};
		//gridBagLayout.rowHeights = new int[]{132, 23, 0};
		//gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.columnWeights=new double[]{0.0, 0};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_btnNewTest = new GridBagConstraints();
		gbc_btnNewTest.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewTest.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewTest.gridx = 1;
		gbc_btnNewTest.gridy = 0;
		btnNewTest.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnNewTest, gbc_btnNewTest);
		btnNewTest.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewTest.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainGui.isSetter = true;
				MainGui maingui = new MainGui();
				maingui.main(null);
			}
		});
		
		GridBagConstraints gbc_btnLoadTest = new GridBagConstraints();
		gbc_btnLoadTest.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLoadTest.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadTest.gridx = 1;
		gbc_btnLoadTest.gridy = 1;
		add(btnLoadTest, gbc_btnLoadTest);
		GridBagConstraints gbc_btnPreview = new GridBagConstraints();
		gbc_btnPreview.insets = new Insets(0, 0, 5, 5);
		gbc_btnPreview.anchor = GridBagConstraints.WEST;
		gbc_btnPreview.gridx = 1;
		gbc_btnPreview.gridy = 2;
		add(btnPreview, gbc_btnPreview);
		GridBagConstraints gbc_btnMark = new GridBagConstraints();
		gbc_btnMark.insets = new Insets(0, 0, 0, 5);
		gbc_btnMark.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMark.gridx = 1;
		gbc_btnMark.gridy = 3;
		add(btnMark, gbc_btnMark);
	}
}
