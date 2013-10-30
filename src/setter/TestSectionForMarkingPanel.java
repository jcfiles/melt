package setter;

import javax.swing.JPanel;

import backend.Question;
import backend.Section;
import backend.StudentTestController;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Font;

/**
 * 
 * @author Dimitrios Chondrokoukis
 *
 */

public class TestSectionForMarkingPanel extends JPanel {
	private JTable table;
	private ArrayList<Question> questions;
	private SetterTestController controller;
	private Section section;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TestSectionForMarkingPanel(SetterTestController controller, Section section, Question question) {
		this.controller = controller;
		this.section = section;
		questions = section.getQuestions();
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		
		JLabel lblSection = new JLabel("Section 1");
		topPanel.add(lblSection);
		
		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.WEST);
		
		String q = "Q";
		Object[][] object = new Object[questions.size()][2];
		for(int i=0; i<questions.size();i++){
	            object[i][0]=q+Integer.toString(i+1);
		}
		
		String[] columnNames = new String[] {"Quest", ""};
		
		DefaultTableModel model = new DefaultTableModel(object, columnNames);
		table = new JTable( model )
	    {
	        //  Returning the Class of each column will allow different
	        //  renderers to be used based on Class
	        public Class getColumnClass(int column)
	        {
	            return getValueAt(0, column).getClass();
	        }
	    };
	    table.setPreferredScrollableViewportSize(table.getPreferredSize());
	    table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	    table.setModel(new DefaultTableModel(
	            object,
	            columnNames
		));
		leftPanel.add(table);
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMark = new JPanel();
		centerPanel.add(panelMark, BorderLayout.NORTH);
		GridBagLayout gbl_panelMark = new GridBagLayout();
		gbl_panelMark.columnWidths = new int[]{290, 0};
		gbl_panelMark.rowHeights = new int[]{16, 0};
		gbl_panelMark.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMark.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelMark.setLayout(gbl_panelMark);
		
		JLabel lblMarks = new JLabel("Marks:");
		lblMarks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblMarks = new GridBagConstraints();
		gbc_lblMarks.anchor = GridBagConstraints.EAST;
		gbc_lblMarks.insets = new Insets(0, 0, 0, 10);
		gbc_lblMarks.fill = GridBagConstraints.VERTICAL;
		gbc_lblMarks.gridx = 0;
		gbc_lblMarks.gridy = 0;
		panelMark.add(lblMarks, gbc_lblMarks);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.1);
		centerPanel.add(splitPane, BorderLayout.CENTER);
		
		JPanel rightAnswerPanel = new JPanel();
		splitPane.setLeftComponent(rightAnswerPanel);
		rightAnswerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		rightAnswerPanel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblThisIsThe = new JLabel("This is the right answer");
		lblThisIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblThisIsThe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		rightAnswerPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		JPanel studentAnswerPanel = new JPanel();
		splitPane.setRightComponent(studentAnswerPanel);
		studentAnswerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		studentAnswerPanel.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblThisIsStudents = new JLabel("This is student's answer");
		lblThisIsStudents.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblThisIsStudents);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		studentAnswerPanel.add(scrollPane_2, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		centerPanel.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{227, 0};
		gbl_panel.rowHeights = new int[]{38, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel totalMarkPanel = new JPanel();
		GridBagConstraints gbc_totalMarkPanel = new GridBagConstraints();
		gbc_totalMarkPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_totalMarkPanel.gridx = 0;
		gbc_totalMarkPanel.gridy = 0;
		panel.add(totalMarkPanel, gbc_totalMarkPanel);
		
		JLabel lblTotalMarks = new JLabel("Total Marks:");
		totalMarkPanel.add(lblTotalMarks);
		
		textField = new JTextField();
		totalMarkPanel.add(textField);
		textField.setColumns(10);
		
		JPanel feedbackPanel = new JPanel();
		GridBagConstraints gbc_feedbackPanel = new GridBagConstraints();
		gbc_feedbackPanel.anchor = GridBagConstraints.NORTH;
		gbc_feedbackPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_feedbackPanel.gridx = 0;
		gbc_feedbackPanel.gridy = 1;
		panel.add(feedbackPanel, gbc_feedbackPanel);
		GridBagLayout gbl_feedbackPanel = new GridBagLayout();
		gbl_feedbackPanel.columnWidths = new int[]{59, 0};
		gbl_feedbackPanel.rowHeights = new int[]{16, 0, 0};
		gbl_feedbackPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_feedbackPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		feedbackPanel.setLayout(gbl_feedbackPanel);
		
		JLabel lblFeedback = new JLabel("Feedback:");
		GridBagConstraints gbc_lblFeedback = new GridBagConstraints();
		gbc_lblFeedback.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFeedback.anchor = GridBagConstraints.NORTH;
		gbc_lblFeedback.gridx = 0;
		gbc_lblFeedback.gridy = 0;
		feedbackPanel.add(lblFeedback, gbc_lblFeedback);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		feedbackPanel.add(scrollPane, gbc_scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(4);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		
		JButton backButton = new JButton("<");
		panel_1.add(backButton);
		
		JButton nextButton = new JButton(">");
		panel_1.add(nextButton);
		
		JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_bottomPanel = new GridBagLayout();
		gbl_bottomPanel.columnWidths = new int[]{75, 0};
		gbl_bottomPanel.rowHeights = new int[]{29, 0};
		gbl_bottomPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_bottomPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bottomPanel.setLayout(gbl_bottomPanel);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		bottomPanel.add(btnBack, gbc_btnBack);
		
		
	}

}
