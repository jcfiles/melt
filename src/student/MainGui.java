package student;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import backend.TestController;

public class MainGui {

    private TestController controller;
    private StudentStartJPanel studentpanel;
    private static JFrame frame;
    public static JFrame getFrame() {
        return frame;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					MainGui.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
        }
	
	public static void setComposite(Component component){
		if(frame.getContentPane().getComponentCount()>0){
			frame.getContentPane().removeAll();
		}
		frame.getContentPane().add(component);
		frame.getContentPane().validate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
            controller = new TestController(this); // Instantiates the TestController & passes a reference to the main gui
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		studentpanel = new StudentStartJPanel(controller); // pass controller to contained panel
		frame.add(studentpanel);
		frame.validate();
	}
        // Accessor method, so contoller can access this from main gui
        public StudentStartJPanel getStudentPanel() {
            return studentpanel;
        }
}