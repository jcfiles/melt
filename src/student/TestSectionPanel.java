package student;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FontMetrics;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;



import java.awt.CardLayout;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import backend.StudentTestController;
import backend.Question;
import backend.Section;
import java.util.Iterator;
/*
 * @author Chondrokoukis Dimitrios
 * @contributor Steedman Bruce
 */
public class TestSectionPanel extends JPanel {
    private JLabel labelTimeRemaining;
    private StudentTestController controller;
    private Section section;
    private JTable tableQuestions;
    private ArrayList<Question> questions;
    private int questionPanelsIndex;
    private ArrayList<QuestionPanel> questionPanels;
    private JPanel questionHolderPanel;
	
    /**
     * Create the panel.
     */
    public TestSectionPanel(final StudentTestController controller, final Section section) {
	this.controller = controller;
        this.section = section;
        questionPanelsIndex=0;
	questions = section.getQuestionsList();
        
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
		
	JLabel lblTestA = new JLabel("");
	GridBagConstraints gbc_lblTestA = new GridBagConstraints();
	gbc_lblTestA.anchor = GridBagConstraints.EAST;
	gbc_lblTestA.insets = new Insets(0, 0, 0, 5);
	gbc_lblTestA.gridx = 0;
	gbc_lblTestA.gridy = 0;
	panel_8.add(lblTestA, gbc_lblTestA);
		
	JLabel labelSectionTitle = new JLabel(section.getSectionTitle());
	GridBagConstraints gbc_labelSectionTitle = new GridBagConstraints();
	gbc_labelSectionTitle.anchor = GridBagConstraints.WEST;
	gbc_labelSectionTitle.gridx = 1;
	gbc_labelSectionTitle.gridy = 0;
	panel_8.add(labelSectionTitle, gbc_labelSectionTitle);
		
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
		
	labelTimeRemaining = new JLabel("");
	GridBagConstraints gbc_labelTimeRemaining = new GridBagConstraints();
	gbc_labelTimeRemaining.anchor = GridBagConstraints.EAST;
	gbc_labelTimeRemaining.insets = new Insets(0, 0, 0, 5);
	gbc_labelTimeRemaining.gridx = 0;
	gbc_labelTimeRemaining.gridy = 0;
	panel_9.add(labelTimeRemaining, gbc_labelTimeRemaining);
		
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
		
	JLabel labelSubsection = new JLabel("Example Subsection Heading");
	panel_3.add(labelSubsection);
		
	JLabel label = new JLabel(">");
	panel_3.add(label);
		
	JPanel scrollPane_1 = new JPanel();
	panel_2.add(scrollPane_1, BorderLayout.WEST);
		
	String q = "Q";
	Object[][] object = new Object[questions.size()][1];
	for(int i=0; i<questions.size();i++){
            object[i][0]=q+Integer.toString(i+1);
	}
		
	tableQuestions = new JTable();
	tableQuestions.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			((CardLayout)questionHolderPanel.getLayout()).first(questionHolderPanel);
			for(int i=0; i<tableQuestions.rowAtPoint(e.getPoint()); i++){
				((CardLayout)questionHolderPanel.getLayout()).next(questionHolderPanel);
			}
			questionPanelsIndex = tableQuestions.rowAtPoint(e.getPoint());
		}
	});
	tableQuestions.setModel(new DefaultTableModel(
            object,
            new String[] {"Questions"}
	));
	scrollPane_1.add(tableQuestions);
	
	
		
	JPanel panel_5 = new JPanel();
	panel_2.add(panel_5, BorderLayout.CENTER);
	GridBagLayout gbl_panel_5 = new GridBagLayout();
	gbl_panel_5.columnWidths = new int[]{0, 0};
	gbl_panel_5.rowHeights = new int[]{0, 0, 0};
	gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_panel_5.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
	panel_5.setLayout(gbl_panel_5);
		
	final JScrollPane scrollPane = new JScrollPane();
	GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	gbc_scrollPane.fill = GridBagConstraints.BOTH;
	gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
	gbc_scrollPane.gridx = 0;
	gbc_scrollPane.gridy = 0;
	panel_5.add(scrollPane, gbc_scrollPane);
		
	questionHolderPanel = new JPanel();
	scrollPane.setViewportView(questionHolderPanel);
	questionHolderPanel.setLayout(new CardLayout(0, 0));
		
	questionPanels = new ArrayList<QuestionPanel>();
        Iterator<Question> it = questions.iterator();
        int qNum = 0;
        QuestionPanel qp = null;
	while(it.hasNext()){
            try {
                qp = QuestionPanelFactory.getInstance().createQuestionPanel(it.next());
            }
            catch(Exception e) {
                //Handle exceptions if for any reason a panel cannot be instantiated
            }
            questionHolderPanel.add(qp, "name_"+ Integer.toString(qNum++));
            questionPanels.add(qp);
	}
	scrollPane.setMinimumSize(scrollPane.getComponent(0).getSize());	
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
		
	JButton buttonPrevious = new JButton("Previous");
	buttonPrevious.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(questionPanelsIndex>0){
        			//Puts tick in the table
                    if(questionPanels.get(questionPanelsIndex).isAnswered()){
                    	System.out.println(true);
                    }
                    questionPanelsIndex--;
                    ((CardLayout)questionHolderPanel.getLayout()).previous(questionHolderPanel);
                    scrollPane.setMinimumSize(scrollPane.getComponent(0).getSize());
                }
            }
	});
	GridBagConstraints gbc_buttonPrevious = new GridBagConstraints();
	gbc_buttonPrevious.insets = new Insets(0, 0, 0, 5);
	gbc_buttonPrevious.anchor = GridBagConstraints.EAST;
	gbc_buttonPrevious.gridx = 0;
	gbc_buttonPrevious.gridy = 0;
	panel_7.add(buttonPrevious, gbc_buttonPrevious);
		
	JButton buttonNext = new JButton("Next");
	buttonNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(questionPanelsIndex<questions.size()-1){
        			//Puts tick in the table
                    if(questionPanels.get(questionPanelsIndex).isAnswered()){
                    	//System.out.println(true);
                    	BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                    	FontMetrics fm = img.getGraphics().getFontMetrics(getFont());
                    	int width = fm.stringWidth((String) tableQuestions.getModel().getValueAt(questionPanelsIndex,0));
                    	try {
                            BufferedImage img2 = ImageIO.read(TestSectionPanel.class.getResource("/lib/images/tick.png"));
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
			}
                    }
                    questionPanelsIndex++;
                    ((CardLayout)questionHolderPanel.getLayout()).next(questionHolderPanel);
                    scrollPane.setMinimumSize(scrollPane.getComponent(0).getSize());
                }
            }
	});
	GridBagConstraints gbc_buttonNext = new GridBagConstraints();
	gbc_buttonNext.anchor = GridBagConstraints.WEST;
	gbc_buttonNext.gridx = 1;
	panel_7.add(buttonNext, gbc_buttonNext);
		
	JPanel panel_1 = new JPanel();
	add(panel_1, BorderLayout.SOUTH);
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	gbl_panel_1.columnWidths = new int[]{117, 0};
	gbl_panel_1.rowHeights = new int[]{29, 0};
	gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_1.setLayout(gbl_panel_1);
		
	JButton buttonSubmitSection = new JButton("Submit Section");
	buttonSubmitSection.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	controller.endSection(TestSectionPanel.this);
            }
	});
	GridBagConstraints gbc_buttonSubmitSection = new GridBagConstraints();
	gbc_buttonSubmitSection.anchor = GridBagConstraints.NORTH;
	gbc_buttonSubmitSection.gridx = 0;
	gbc_buttonSubmitSection.gridy = 0;
	panel_1.add(buttonSubmitSection, gbc_buttonSubmitSection);
    }
    
    public ArrayList<QuestionPanel> getQuestionPanels() {
        return questionPanels;
    }

    public Section getSection() {
        return section;
    }
    
    /*
     * Return the JLabel that will have the countdown
     */
    public JLabel getLabelForTimer(){
    	return this.labelTimeRemaining;
    }
}
