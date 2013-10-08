package setter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class AddSectionGUI extends JFrame {

	private JPanel contentPane;
	AddSectionPanel addPanel=new AddSectionPanel();
	ViewSectionPanel viewPanel=new ViewSectionPanel();
	SectionNavigationPanel nav=new SectionNavigationPanel();
	
	JLabel lblTitle=new JLabel("Title:");
	JTextField txtTest=new JTextField();
	JLabel lblTest=new JLabel("TestA");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSectionGUI frame = new AddSectionGUI();
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
	public AddSectionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 533, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));				
		panelCenter.add(addPanel);	
		
		//The navigation panel
		contentPane.add(nav, BorderLayout.SOUTH);
		
		//button Listeners
		nav.btnSave.addActionListener(new ActionListener(){  //button to save the question
		public void actionPerformed(ActionEvent e) {
			
			panelCenter.removeAll();
			panelCenter.add(viewPanel);
			
			txtTest.setVisible(false);
			lblTest.setVisible(true);
			
			
			validate();
			repaint();
			} 
		});
		
		nav.btnAdd.addActionListener(new ActionListener(){	//button to add new question
		public void actionPerformed(ActionEvent e) {
			
			panelCenter.removeAll();
			panelCenter.add(addPanel);
			
			panelCenter.validate();
			panelCenter.repaint();
			
			txtTest.setVisible(true);
			lblTest.setVisible(false);
					}
				});
		
		
		nav.btnDelete.addActionListener(new ActionListener(){  //Delete the question
		public void actionPerformed(ActionEvent e) {
			 }
				});
		
		nav.btnEdit.addActionListener(new ActionListener(){  //Edit the question
		public void actionPerformed(ActionEvent e) {
			panelCenter.removeAll();
			panelCenter.add(addPanel);
						
			panelCenter.validate();
			panelCenter.repaint();
			
			txtTest.setVisible(true);
			lblTest.setVisible(false);
		 }
		});
	}

}
