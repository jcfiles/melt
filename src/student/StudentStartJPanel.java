package student;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import backend.Test_;
import java.awt.Insets;

public class StudentStartJPanel extends JPanel { //implements ActionListener{
	/**
	 * 
	 */
    private final Test_ test;
    private static final long serialVersionUID = 5624695781144447672L;

	/**
	 * Create the panel.
	 */
	public StudentStartJPanel(final Test_ test) {
            this.test = test;
            SpringLayout springLayout = new SpringLayout();
            setLayout(springLayout);	
            JPanel panel = new JPanel();
	    springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, this);
            springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, this);
            springLayout.putConstraint(SpringLayout.EAST, panel, 142, SpringLayout.WEST, this);
            add(panel);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]{31, 0};
            gbl_panel.rowHeights = new int[]{29, 0};
            gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	    panel.setLayout(gbl_panel);
	    JPanel panel_1 = new JPanel();
	    springLayout.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panel);
	    springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, this);
	    springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, panel_1);
	    springLayout.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, this);
	    springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, this);
		
            JButton startButton = new JButton("Start");
                startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SectionIndexPanel sectionIndexPanel = new SectionIndexPanel(test);
                    MainGui.setComposite(sectionIndexPanel);}
                });
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_startButton.gridx = 0;
		gbc_startButton.gridy = 0;
		panel.add(startButton, gbc_startButton);
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{175, 0};
		gbl_panel_1.rowHeights = new int[]{16, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to the English test");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

	}
        // NOW WRAPPED IN INNER CLASS
	//@Override
	//public void actionPerformed(ActionEvent e) {
		//TestPanel testpanel = new TestPanel();
		//MainGui.setComposite(testpanel);
	//} 
}