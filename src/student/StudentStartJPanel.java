package student;

import backend.StudentTestController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import setter.MenuGUI;
import setter.SetterGUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

import backend.Test_;

import java.awt.Insets;

/**
 * 
 * @author Dimitrios Chondrokoukis
 *
 */
public class StudentStartJPanel extends JPanel {
	
    private StudentTestController controller;
    private static final long serialVersionUID = 5624695781144447672L;

    /**
     * Create the panel.
     */
    public StudentStartJPanel(final StudentTestController controller) {
        this.controller = controller;
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
        startButton.setFont(new Font("MV Boli", Font.PLAIN, 15));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SectionIndexPanel sectionIndexPanel = new SectionIndexPanel(controller);
            	sectionIndexPanel.EnableNextButton();
            	MainGui.setComposite(sectionIndexPanel);
            }
         });
        GridBagConstraints gbc_startButton = new GridBagConstraints();
        gbc_startButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_startButton.gridx = 0;
	gbc_startButton.gridy = 0;
	panel.add(startButton, gbc_startButton);
	add(panel_1);
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	gbl_panel_1.columnWidths = new int[]{175, 0};
	gbl_panel_1.rowHeights = new int[]{16, 0, 0};
	gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	panel_1.setLayout(gbl_panel_1);
	
	JButton buttonEdit = new JButton("Edit");
	buttonEdit.setFont(new Font("MV Boli", Font.ITALIC, 15));
	GridBagConstraints gbc_buttonEdit = new GridBagConstraints();
	gbc_buttonEdit.anchor = GridBagConstraints.EAST;
	gbc_buttonEdit.gridx = 0;
	gbc_buttonEdit.gridy = 0;
	panel_1.add(buttonEdit, gbc_buttonEdit);
	if(!MainGui.isSetter){
		buttonEdit.setVisible(false);
		buttonEdit.validate();
    }
	
	StringBuilder sb = new StringBuilder();
	sb.append("<html>"+ "<h2>" +controller.getTest().getTestTitle() + "</h2>" + "<h3>" + controller.getTest().getTestIntroText() + "</h3>" +"</html>");
	JLabel lblNewLabel = new JLabel(sb.toString());
	lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 1;
	panel_1.add(lblNewLabel, gbc_lblNewLabel);
	
	
	buttonEdit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			//open the setter GUI
	    MainGui.parent.setVisible(true);
	    
	    //suspend this
	    MainGui.frame.setVisible(false);
		}
	});
	
    }
    
}