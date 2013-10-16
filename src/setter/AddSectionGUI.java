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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/*
 * @author Erotokritou Zoe
 */
public class AddSectionGUI extends JFrame {

	private JPanel contentPane;
	private AddSectionPanel addPanel;
	private ViewSectionPanel viewPanel;
	private SectionNavigationPanel nav;
	
	private JLabel lblTitle=new JLabel("Title:");
	public JTextField txtTest=new JTextField();
	public JLabel lblTest=new JLabel("TestA");
	public JPanel panelCenter=new JPanel();
	private SetterTestController obj=new SetterTestController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetterTestController obj=new SetterTestController();
					MenuGUI gui=new MenuGUI();
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
					MenuGUI menu=new MenuGUI();
					AddSectionGUI frame = new AddSectionGUI(obj, menu);
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
	public AddSectionGUI(final SetterTestController obj, MenuGUI menu) {
		super("Create new Test");
		this.obj=obj;			
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
		Border lineBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true);
		panelCenter.setBorder(lineBorder);
		
		addPanel=new AddSectionPanel(obj,this);
		
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));				
		panelCenter.add(addPanel);	
		
		//The navigation panel
		nav=new SectionNavigationPanel(obj,this,menu);
		contentPane.add(nav, BorderLayout.SOUTH);
			
		
	}


}