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

public class AddQuestionGUI extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 533, 700);
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
		
		JLabel lblTitle=new JLabel("TestA: SectorA");
		JButton btnSwitch=new JButton("Switch");
		
		panelTitle.add(lblTitle);
		panelTitle.add(btnSwitch);
		
		//The panel in the center
		JPanel panelCenter=new JPanel();
		JPanel panelStep=new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		//panelCenter.add(new AddQuestionPanel());
		//panelCenter.add(new MultichoicePanel());
		panelCenter.add(new FillBlankPanel());
		
		NavigationPanel nav=new NavigationPanel();
		contentPane.add(nav, BorderLayout.SOUTH);
		
		
		Component[] comp = nav.getComponents();
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] instanceof JButton) {
                JButton temp = (JButton) comp[i];
                if (temp.getText().equals("Save"))
                {
                	
                }
            }
        }
        
		
		
	

	}
}
