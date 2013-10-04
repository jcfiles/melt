package student;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import backend.TestController;
import backend.Test_;


public class TestPanel extends JPanel {

	/**
	 * 
	 */
    private TestController controller;
    private static final long serialVersionUID = 1939041461035877329L;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public TestPanel(TestController controller, Test_ test) { // A Test_ instance passed in as parameter
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblYouHave = new JLabel("You have 20 minutes remaining");
		GridBagConstraints gbc_lblYouHave = new GridBagConstraints();
		gbc_lblYouHave.insets = new Insets(0, 0, 5, 0);
		gbc_lblYouHave.gridx = 0;
		gbc_lblYouHave.gridy = 0;
		add(lblYouHave, gbc_lblYouHave);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new CardLayout(0, 0));
		
		SectionPanel sectionpanel = new SectionPanel(null);
		panel.add(sectionpanel, "name_1380485611736349000");
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(controller); //(new ActionListener() { // Replaced new actionListener wiht 'controller'
			//public void actionPerformed(ActionEvent e) {
			//	FinishTestPanel finishpanel = new FinishTestPanel();
			//	MainGui.setComposite(finishpanel);
			//}
		//});
		panel_1.add(btnNewButton);	
	}
	//private void addSection(Questions[] questions){
		
	//}
}
