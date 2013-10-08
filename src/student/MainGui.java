package student;

import backend.StudentTestController;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import backend.Test_;

public class MainGui {

    StudentTestController controller;
    private Test_ test;
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
		frame.getContentPane().validate();
		frame.getContentPane().add(component);
		frame.getContentPane().validate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
            test = Test_.getDemoTest(); // INSTANTIATE THE DEMO TEST
            StudentTestController controller = new StudentTestController(test);
            frame = new JFrame();
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
            studentpanel = new StudentStartJPanel(controller, test);
            frame.add(studentpanel);
            frame.validate();
	}
        
        public StudentStartJPanel getStudentPanel() {
            return studentpanel;
        }
}