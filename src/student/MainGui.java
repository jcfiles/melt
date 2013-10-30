package student;

import backend.StudentTestController;
import backend.Subsection;
import backend.Test_;

import java.awt.Component;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.BoxLayout;

import backend.StudentTestController;

/**
 * 
 * @author Dimitrios Chondrokoukis
 *
 */
public class MainGui {

    private StudentTestController controller;
    private static JFrame frame;
    public static boolean isSetter = false;
    private Test_ test;
    
    
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
    	try {
			this.test = Test_.readFromFile("test2");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	controller = new StudentTestController();
    	controller.setTest(test);
    	System.out.println(((Subsection)test.getSection(0).getContainer().get(0)).getSubsectionTitle());
        initialize();
    }
    
    public MainGui(Test_ test){
    	this.test = test;
    	controller = new StudentTestController();
        controller.setTest(test);
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
