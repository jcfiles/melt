package setter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuGUI extends JFrame {

	private JPanel contentPane;
	SetterPanel setterPanel=new SetterPanel();
	JButton btnStudent=new JButton("Student");
	JButton btnSetter=new JButton("Setter");
	JPanel panelCenter = new JPanel();
	
	SetterTestController obj=new SetterTestController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
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
	public MenuGUI() {
		super("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		Border lineBorder=BorderFactory.createLineBorder(Color.GRAY, 2, false);	
		
		JPanel panel = new JPanel();
		panel.setBorder(lineBorder);
		
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		
		GridBagConstraints gbc_btnStudent = new GridBagConstraints();
		gbc_btnStudent.anchor = GridBagConstraints.SOUTH;
		gbc_btnStudent.insets = new Insets(0, 0, 5, 0);
		gbc_btnStudent.gridx = 0;
		gbc_btnStudent.gridy = 0;
		panel.add(btnStudent, gbc_btnStudent);
		
		
		GridBagConstraints gbc_btnSetter = new GridBagConstraints();
		gbc_btnSetter.anchor = GridBagConstraints.NORTH;
		gbc_btnSetter.gridx = 0;
		gbc_btnSetter.gridy = 1;
		panel.add(btnSetter, gbc_btnSetter);

		
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));
		panelCenter.add(setterPanel);
		
		//cliking the Student button
		btnSetter.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    	
		    	panelCenter.removeAll();
				panelCenter.add(setterPanel);
				
				panelCenter.validate();
				panelCenter.repaint();		   	
			 }
			});
		
		//cliking the Student button
		btnStudent.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
				   	
				   panelCenter.removeAll();
				   //panelCenter.add(setterPanel);
						
				   panelCenter.validate();
				   panelCenter.repaint();		   	
					 }
					});
		
		setterPanel.btnNewTest.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
			   
				   AddSectionGUI gui=new AddSectionGUI(obj);
				   obj.setCurrentSection(1);
				   gui.setVisible(true);
				   
				   
					 }
					});
		
		
	}

}
