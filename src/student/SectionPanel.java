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
import java.util.ArrayList;
import java.util.Iterator;

import backend.Section;
import backend.Question;
import backend.FTBQ;

public class SectionPanel extends JPanel {
    
    private TestPanel testPanel;
    private static final long serialVersionUID = 3815318201709212642L;
    //private ArrayList<QuestionPanel> questionPanels;
    private ArrayList<FIBQuestionPanel> fibQuestionPanels;
    private Section section;
    private ArrayList<Question> questions;
    private double sectionMarks = 0;
    
   /**
    * Create the panel.
    */
    public SectionPanel(TestPanel testPanel, Section section) {
        this.testPanel = testPanel;
        fibQuestionPanels = new ArrayList<FIBQuestionPanel>();
        this.section = section;
        questions = section.getQuestionsList(); // This section's questions
        //this.questionPanels = questionPanels;
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
		
	JLabel lblSection = new JLabel();
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
	txtrInThisSection.setText(section.getSectionIntroText()); // GET THE INTRO TEXT
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
		
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()) {
            Question q = it.next();
            if(q instanceof FTBQ) {
                FIBQuestionPanel ftbqPanel = new FIBQuestionPanel((FTBQ)q);
                
                fibQuestionPanels.add(ftbqPanel);
                
		GridBagConstraints gbc_ftbqPanel = new GridBagConstraints();
		gbc_ftbqPanel.fill = GridBagConstraints.BOTH;
		gbc_ftbqPanel.gridx = 0;
		gbc_ftbqPanel.gridy = 1;
		panel_2.add(ftbqPanel, gbc_ftbqPanel);
            }
            else // Must be a MCQ
            {
                MCQuestionPanel mcqPanel = new MCQuestionPanel(q);
		GridBagConstraints gbc_mcqPanel = new GridBagConstraints();
		gbc_mcqPanel.insets = new Insets(0, 0, 5, 0);
		gbc_mcqPanel.fill = GridBagConstraints.BOTH;
		gbc_mcqPanel.gridx = 0;
		gbc_mcqPanel.gridy = 0;
		panel_2.add(mcqPanel, gbc_mcqPanel);
            }
        }
    }
    
    public FIBQuestionPanel getFIBQuestionPanel(int index) {
            return fibQuestionPanels.get(index);
        }
    

      	//MCQuestionPanel questionpanel1 = new MCQuestionPanel();
		//GridBagConstraints gbc_questionpanel1 = new GridBagConstraints();
		//gbc_questionpanel1.insets = new Insets(0, 0, 5, 0);
		//gbc_questionpanel1.fill = GridBagConstraints.BOTH;
		//gbc_questionpanel1.gridx = 0;
		//gbc_questionpanel1.gridy = 0;
		//panel_2.add(questionpanel1, gbc_questionpanel1);
		
		//FIBQuestionPanel questionpanel2 = new FIBQuestionPanel();
		//GridBagConstraints gbc_questionpanel2 = new GridBagConstraints();
		//gbc_questionpanel2.fill = GridBagConstraints.BOTH;
		//gbc_questionpanel2.gridx = 0;
		//gbc_questionpanel2.gridy = 1;
		//panel_2.add(questionpanel2, gbc_questionpanel2);	
}