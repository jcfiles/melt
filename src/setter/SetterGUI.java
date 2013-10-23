package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.SpringLayout;

public class SetterGUI extends JFrame {

	private JPanel contentPane;
	private JPanel treePanel = new JPanel();
	public JPanel centerPanel=new JPanel();
	private JTree tree = new JTree();
	private JButton saveTest=new JButton("Save Test");
	private SetterTestController obj=new SetterTestController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetterGUI frame = new SetterGUI();
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
	public SetterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 733, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
				
		//Tree Panel
		contentPane.add(treePanel, BorderLayout.WEST);		
		
		Border lineBorder=BorderFactory.createLineBorder(Color.GRAY, 2, false);	
		treePanel.setBorder(lineBorder);
		treePanel.setLayout(new BorderLayout(0, 0));
		treePanel.add(tree, BorderLayout.CENTER);
		treePanel.add(saveTest, BorderLayout.SOUTH);
		saveTest.setPreferredSize(new Dimension(200, 40));
		
		//Center Panel
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout((new BorderLayout(0, 0)));
		
		CreateTestPanel panel=new CreateTestPanel(obj,this);
		centerPanel.add(panel);
		
		
		
		
	}

}
