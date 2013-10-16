package student;

import backend.StudentTestController;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;

import backend.StudentTestController;

public class MainGui {

    private StudentTestController controller;
    private static JFrame frame;
    public static boolean isSetter = false;
    
    
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
	frame.repaint();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        controller = new StudentTestController();
        frame = new JFrame();
        frame.setBounds(100, 100, 819, 464);
        if(!isSetter){
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        frame.getContentPane().add(new StudentStartJPanel(controller));
        frame.validate();
    }
}
