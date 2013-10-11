package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AddSectionGUI extends JFrame {

	private JPanel contentPane;
	private AddSectionPanel addPanel;
	private ViewSectionPanel viewPanel;
	private SectionNavigationPanel nav=new SectionNavigationPanel();
	
	private JLabel lblTitle=new JLabel("Title:");
	private JTextField txtTest=new JTextField();
	private JLabel lblTest=new JLabel("TestA");
	
	SetterTestController obj=new SetterTestController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetterTestController obj=new SetterTestController();
					
					AddSectionGUI frame = new AddSectionGUI(obj);
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
	public AddSectionGUI(final SetterTestController obj) {
		super("Create new Test");
		this.obj=obj;			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 533, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addPanel=new AddSectionPanel();
		viewPanel=new ViewSectionPanel(obj);
		nav=new SectionNavigationPanel();
		
		JPanel panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panel_1);
		
		
		//create 2 JPanels for the panelTitle
		JPanel panelA = new JPanel();
		panelA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelTitle.add(panelA);
		
		//Set the name of the Test and Sector
		
		lblTest.setVisible(false);
		txtTest.setColumns(20);
		panelA.add(lblTitle);
		panelA.add(lblTest);
		panelA.add(txtTest);				
		
		//Switch button 
		JButton btnSwitch=new JButton("Switch");
		panelTitle.add(btnSwitch);

		//The panel in the center
		final JPanel panelCenter=new JPanel();
		Border lineBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true);
		panelCenter.setBorder(lineBorder);
		
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));				
		panelCenter.add(addPanel);	
		
		//The navigation panel
		contentPane.add(nav, BorderLayout.SOUTH);
		
		//button Listeners
		addPanel.btnSave.addActionListener(new ActionListener(){  //button to save the question
		public void actionPerformed(ActionEvent e) {
			
			obj.setTitle(lblTest.toString());
			
			
			
			//obj.setSection(addPanel.txtSection.toString(), Integer.parseInt(addPanel.txtTotalTime.toString()), Integer.parseInt(addPanel.lblNumOfQuestions.toString()), Integer.parseInt(addPanel.lblTotalMarks.toString()), addPanel.txtInstructions.toString());
			
			panelCenter.removeAll();
			panelCenter.add(viewPanel);
			
			txtTest.setVisible(false);
			lblTest.setVisible(true);
			
			
			validate();
			repaint();
			} 
		});
		
		viewPanel.btnAdd.addActionListener(new ActionListener(){	//button to add new question
		public void actionPerformed(ActionEvent e) {
			
			panelCenter.removeAll();
			panelCenter.add(addPanel);
			
			panelCenter.validate();
			panelCenter.repaint();
			
			txtTest.setVisible(true);
			lblTest.setVisible(false);
					}
				});
		
		
		viewPanel.btnDelete.addActionListener(new ActionListener(){  //Delete the question
		public void actionPerformed(ActionEvent e) {
			 }
				});
		
		viewPanel.btnEdit.addActionListener(new ActionListener(){  //Edit the question
		public void actionPerformed(ActionEvent e) {
			panelCenter.removeAll();
			panelCenter.add(addPanel);
						
			panelCenter.validate();
			panelCenter.repaint();
			
			txtTest.setVisible(true);
			lblTest.setVisible(false);
		 }
		});
		
		viewPanel.btnAddQuestion.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
				
				AddQuestionGUI frame = new AddQuestionGUI(obj);
				frame.setVisible(true);
			 }
			});
		
		nav.btnNext.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
								
				int num=obj.getCurrentSection()+1;
				obj.setCurrentSection(num);
				if(num==obj.section.size()+1)
				{
					nav.btnNext.setVisible(false);
				}
				else
				{
					nav.btnNext.setVisible(true);
				}
			 }
			});
		
		nav.btnPrevious.addActionListener(new ActionListener(){  //Edit the question
			public void actionPerformed(ActionEvent e) {
				
				int num=obj.getCurrentSection()-1;
						
				obj.setCurrentSection(num);
				if(num==1)
				{
					nav.btnPrevious.setVisible(false);
				}
				else
				{
					nav.btnPrevious.setVisible(true);
				}
				
			 }
			});
	}


}
