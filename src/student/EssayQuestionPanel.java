package student;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextArea;

import java.awt.FlowLayout;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import backend.EssayQ;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Dimitrios Chondrokoukis
 *
 */
public class EssayQuestionPanel extends QuestionPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3471776243315218349L;
	private int questionNumber = 0;
	private JLabel labelQuestionNumber;
	private EssayQ essayQ;
	private JTextArea textPane;

	/**
	 * Create the panel.
	 */
	public EssayQuestionPanel(final EssayQ essayQ) {
		this.essayQ = essayQ;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		labelQuestionNumber = new JLabel("Question " + Integer.toString(questionNumber));
		labelQuestionNumber.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		panel.add(labelQuestionNumber);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 10);
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		JLabel labelMarks = new JLabel("Marks: " + essayQ.getPossibleMarks());
		labelMarks.setFont(new Font("MV Boli", Font.PLAIN, 15));
		panel_1.add(labelMarks);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 10);
		gbc_panel_2.anchor = GridBagConstraints.EAST;
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		
		final JLabel labelNumberOfWords = new JLabel("Number of words: "+Integer.toString(essayQ.getStudentAnswer().length())+"/" + Integer.toString(essayQ.getMaxWords()));
		labelNumberOfWords.setFont(new Font("MV Boli", Font.PLAIN, 15));
		panel_2.add(labelNumberOfWords);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 10, 5, 0);
		gbc_panel_3.anchor = GridBagConstraints.WEST;
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		JLabel labelQuestionTitle = new JLabel("New label");
		labelQuestionTitle.setFont(new Font("MV Boli", Font.PLAIN, 15));
		panel_3.add(labelQuestionTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 10, 0, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		textPane = new JTextArea();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 13));
		textPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				new Thread(){
					public void run(){
						if(textPane.isDisplayable()){
							if(labelNumberOfWords.isDisplayable()){
								int numberOfWords = textPane.getText().split(" ").length;
								if((textPane.getText().split(" ").length==1)&&((textPane.getText().split(" ")[0].equals("")))){
									numberOfWords=0;
								}
								labelNumberOfWords.setText("Number of words: " + Integer.toString(numberOfWords) + "/" + Integer.toString(essayQ.getMaxWords()));
							}
						}
					}
				}.start();
			}
		});
		textPane.setLineWrap(true);
		scrollPane.setViewportView(textPane);

	}

	@Override
	public void submitAnswer() {
		essayQ.setStudentAnswer(textPane.getText());
		System.out.println(essayQ.getStudentAnswer());
	}

	@Override
	public boolean isAnswered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
		labelQuestionNumber.setText("Question " + Integer.toString(questionNumber));
		labelQuestionNumber.validate();
	}

	@Override
	public void setPath(String path) {
		labelQuestionNumber.setText(path + " > " +labelQuestionNumber.getText());
		labelQuestionNumber.validate();
	}

}
