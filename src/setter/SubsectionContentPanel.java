package setter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubsectionContentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel titlePanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JLabel lblTitle =new JLabel("TestA: SectionA");
	private JTextField txtTitle = new JTextField();
	private JPanel buttonsPanel=new JPanel();
	private JButton btnSave=new JButton("Save");
	private JTextArea txtIntroduction = new JTextArea();
	private final JPanel contentPanel = new JPanel();
	
	
	/**
	 * Create the panel.
	 */
	public SubsectionContentPanel(final SetterTestController obj, final SetterGUI gui) {
		setLayout(new BorderLayout(0, 0));

		//Title panel
		add(titlePanel, BorderLayout.NORTH);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0};
		gbl_titlePanel.rowHeights = new int[]{10,10};
		gbl_titlePanel.columnWeights = new double[]{0.0};
		gbl_titlePanel.rowWeights = new double[]{Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
		
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 1;	
		titlePanel.add(lblTitle,gbc_lbl);		
		
		//Center Panel
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(contentPanel, BorderLayout.CENTER);
		
		
		
		//Buttons Panel
		add(buttonsPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_buttonsPanel = new GridBagLayout();
		gbl_buttonsPanel.columnWidths = new int[]{0};
		gbl_buttonsPanel.rowHeights = new int[]{0};
		gbl_buttonsPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_buttonsPanel.rowWeights = new double[]{Double.MIN_VALUE};
		buttonsPanel.setLayout(gbl_buttonsPanel);
		
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.insets = new Insets(0, 0, 5, 5);
		gbc_btn.gridx = 0;
		gbc_btn.gridy = 1;	
		buttonsPanel.add(btnSave,gbc_btn);


	}

}
