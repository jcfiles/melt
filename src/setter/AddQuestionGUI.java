package setter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuestionGUI extends JFrame {

	private JPanel contentPane;
	AddQuestionPanel addPanel=new AddQuestionPanel();
	NavigationPanel nav=new NavigationPanel();
	MultichoicePanel multiPanel=new MultichoicePanel();
	FillBlankPanel fillPanel=new FillBlankPanel();
	int buttonType=0;
	int questionType=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestionGUI frame = new AddQuestionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddQuestionGUI() {
		super("Add Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 533, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panel_1);
		
		//Set the name of the Test and Sector
		JLabel lblTitle=new JLabel("TestA: SectorA");
		
		JButton btnSwitch=new JButton("Switch");	//Button to switch preview
		
		panelTitle.add(lblTitle);
		panelTitle.add(btnSwitch);
		
		//The panel in the center
		final JPanel panelCenter=new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));				
		panelCenter.add(addPanel);	
		
		//The navigation panel
		contentPane.add(nav, BorderLayout.SOUTH);
			
		
		//button Listeners
		nav.btnSave.addActionListener(new ActionListener(){  //button to save the question
			public void actionPerformed(ActionEvent e) {
				buttonType=1;
				
				if(questionType==1) //multiple choice question
				{
					panelCenter.removeAll();
					panelCenter.add(multiPanel);
				}
				if(questionType==2)  //fill blank question
				{
					panelCenter.removeAll();
					panelCenter.add(fillPanel);
				}
				
				validate();
				repaint();
			 }
			 
		});
		nav.btnAdd.addActionListener(new ActionListener(){	//button to add new question
			public void actionPerformed(ActionEvent e) {
				 buttonType=2;
				 
				 //which panel to remove
				 if(questionType==1)
					{
					 	panelCenter.remove(multiPanel);
						panelCenter.add(addPanel);
												
						
					}
				 if(questionType==2)
					{
						panelCenter.remove(fillPanel);
						panelCenter.add(addPanel);
						
					}
				 
				panelCenter.validate();
				panelCenter.repaint();
			}
		});
		nav.btnDelete.addActionListener(new ActionListener(){  //Delete the question
			 public void actionPerformed(ActionEvent e) {
				 buttonType=3;
			 }
		});
		nav.btnEdit.addActionListener(new ActionListener(){  //Edit the question
		    public void actionPerformed(ActionEvent e) {
			   buttonType=4;
			   
			 //which panel to remove
			   if(questionType==1)
				{
				 	panelCenter.remove(multiPanel);
					panelCenter.add(addPanel);
					
				}
			   if(questionType==2)
				{
					panelCenter.remove(fillPanel);
					panelCenter.add(addPanel);
					
				}
			   
			  panelCenter.validate();
			  panelCenter.repaint();
				
			 }
		});
				
		//Radio button listeners -- get the question type
		addPanel.rdbtnMultipleChoice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				questionType=1;
			}
		});
		addPanel.rdbtnFillBlanks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				questionType=2;
			}
		});

	}
}
