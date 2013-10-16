package setter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import backend.StudentTestController;
import student.StudentStartJPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Erotokritou Zoe
 */
public class MenuGUI extends JFrame {
	private StudentTestController studentTestController;
	private JPanel contentPane;
	private SetterPanel setterPanel;
	private JButton btnStudent=new JButton("Student");
	private JButton btnSetter=new JButton("Setter");
	private static JPanel panelCenter = new JPanel();
	
	SetterTestController obj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
					    // If Nimbus is not available, you can set the GUI to another look and feel.
					}
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
		
		setterPanel=new SetterPanel();
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));
		panelCenter.add(setterPanel);
		
		//cliking the Student button
		btnStudent.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    	studentTestController = new StudentTestController();
		    	panelCenter.removeAll();
				panelCenter.add(new StudentStartJPanel(studentTestController));
				panelCenter.validate();
				panelCenter.repaint();		   	
			 }
			});
		
		//cliking the Setter button
		btnSetter.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
				   panelCenter.removeAll();
				   panelCenter.add(setterPanel);
				   panelCenter.validate();
				   panelCenter.repaint();		   	
					 }
					});
		
		setterPanel.btnNewTest.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
			   
		     obj=new SetterTestController();
		     obj.createTest("");
		     obj.setCurrentSection(0);
		     AddSectionGUI gui=new AddSectionGUI(obj);
		     gui.setVisible(true);
		     
		     MenuGUI.this.dispose();
				   
					 }
					});
		
		
	}
	/*public static void setComposites(JPanel jPanel){
		if(panelCenter.getComponentCount()>0){
			panelCenter.removeAll();
		}
		panelCenter.add(jPanel);
		panelCenter.validate();
		panelCenter.repaint();
	}*/

}
