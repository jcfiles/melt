package setter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.InvalidSlotQFormatException;
import backend.Test_;

public class MarkingGui extends JFrame {

	private JPanel contentPane;
	private MarkingGui frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarkingGui frame = new MarkingGui();
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
	public MarkingGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		try {
			contentPane.add(new SectionIndexForMarkingPanel(new SetterTestController(Test_.getDemoTest2())));
		} catch (InvalidSlotQFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setComposite(Component component){
		if(contentPane.getComponentCount()>0){
			contentPane.removeAll();
		}
		contentPane.validate();
		contentPane.add(component);
		contentPane.validate();
		contentPane.repaint();
	    }
}
