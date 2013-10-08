package student;

import java.util.ArrayList;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import backend.Test_;


public class TestPanel extends JPanel {

	/**
	 * 
	 */
    private Test_ test;
    private static final long serialVersionUID = 1939041461035877329L;
    private JPanel panel;
    private SectionPanel sectionPanel;
    private ArrayList<SectionPanel> sectionPanels;
    //private ArrayList<QuestionPanel> questionPanels;

	/**
	 * Create the panel.
	 */
	public TestPanel(final Test_ test) { // A Test_ instance passed in as parameter
            sectionPanels = new ArrayList<SectionPanel>();
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
                
		sectionPanel = new SectionPanel(this, test.getSection(0)); //JUST THE ONE FOR NOW!!!!
                
		panel.add(sectionPanel, "name_1380485611736349000");
                
                sectionPanels.add(sectionPanel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		JButton finishButton = new JButton("Finish");
		finishButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        sectionPanels.get(0).getFIBQuestionPanel(0).submitAnswer();
                        
                        test.endTest();
                        String marks = String.valueOf(test.getTotalMarks());
                        FinishTestPanel finishpanel = new FinishTestPanel(marks);
                        MainGui.setComposite(finishpanel);}
                    });
		panel_1.add(finishButton);	
	}
        
        private SectionPanel getSectionPanel(int index) {
            return sectionPanels.get(index);
        }
}
