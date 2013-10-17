package student;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import backend.Test_;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

/**
 * 
 * @author Justin Chan
 *
 */
public class FileChooserPanel extends JFrame {

	Test_ t;
	/**
	 * Create the panel.
	 */
	  public FileChooserPanel() throws FileNotFoundException, IOException, ClassNotFoundException {
		    super("File Chooser Test Frame");
		    setSize(350, 200);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);

		    Container c = getContentPane();
		    c.setLayout(new FlowLayout());
		    
		    JButton openButton = new JButton("Open");
		    JButton saveButton = new JButton("Save");
		    JButton dirButton = new JButton("Pick Dir");
		    final JLabel statusbar = new JLabel("Output of your selection will go here");

		    // Create a file chooser that opens up as an Open dialog
		    openButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        JFileChooser chooser = new JFileChooser();
		        chooser.setMultiSelectionEnabled(true);
		        int option = chooser.showOpenDialog(FileChooserPanel.this);
		        if (option == JFileChooser.APPROVE_OPTION) {
		          File[] sf = chooser.getSelectedFiles();
		          String filelist = "nothing";
		          if (sf.length > 0) filelist = sf[0].getName();
		          for (int i = 1; i < sf.length; i++) {
		            filelist += ", " + sf[i].getName();
		          }
		          statusbar.setText("You chose " + filelist);
		        }
		        else {
		          statusbar.setText("You canceled.");
		        }
		      }
		    });
		    
		    c.add(openButton);
		    c.add(statusbar);
	  }

	  public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		  JFrame frame = new FileChooserPanel();
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  frame.setVisible(true);
	  }

}
