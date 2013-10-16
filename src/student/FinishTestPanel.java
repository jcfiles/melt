package student;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinishTestPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 389409352371905605L;
	private final JButton backButton = new JButton("Finish");

	/**
	 * Create the panel.
         * @param marks is total marks awarded for the test
	 */
	public FinishTestPanel(String marks) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 0, 0, 0, 135, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCongratulations = new JLabel("Congratulations!");
		lblCongratulations.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCongratulations = new GridBagConstraints();
		gbc_lblCongratulations.anchor = GridBagConstraints.NORTH;
		gbc_lblCongratulations.insets = new Insets(0, 0, 5, 0);
		gbc_lblCongratulations.gridx = 0;
		gbc_lblCongratulations.gridy = 2;
		add(lblCongratulations, gbc_lblCongratulations);
		
		JLabel lblYouHaveFinished = new JLabel("You have finished your exam!");
		lblYouHaveFinished.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblYouHaveFinished = new GridBagConstraints();
		gbc_lblYouHaveFinished.anchor = GridBagConstraints.NORTH;
		gbc_lblYouHaveFinished.insets = new Insets(0, 0, 5, 0);
		gbc_lblYouHaveFinished.gridx = 0;
		gbc_lblYouHaveFinished.gridy = 3;
		add(lblYouHaveFinished, gbc_lblYouHaveFinished);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		
		JLabel lblYourMarkIs = new JLabel("Your mark is");
		panel.add(lblYourMarkIs);
		JLabel label = new JLabel(marks);
		panel.add(label);
		
		JButton saveButton = new JButton("Save");
		final JLabel statusbar = new JLabel("");
		
	    // Create a file chooser that opens up as a Save dialog

		// converting parameter "marks" into final, so that it can be used in a nested class.
		final String finalmarks = marks;
		
	    saveButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        JFileChooser chooser = new JFileChooser();
	        int option = chooser.showSaveDialog(FinishTestPanel.this);
	        if (option == JFileChooser.APPROVE_OPTION) {
	        	statusbar.setText("You saved " + ((chooser.getSelectedFile()!=null)?
	        			chooser.getSelectedFile().getName():"nothing"));
	          String fileName = chooser.getSelectedFile().getAbsolutePath();
	          
				try {
					
		            // create a new file with an ObjectOutputStream
					BufferedWriter out = new BufferedWriter(new FileWriter(fileName));			
					
					// record the date and time in the file.
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					out.write(dateFormat.format(date));

					// write the marks in the file.
		            out.write("\n" + finalmarks);

		            // close the stream
		            out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	        }
	        else {
	          statusbar.setText("You canceled.");
	        }
	      }
	    });
		

		
		panel.add(saveButton);
		panel.add(statusbar);
		
		// Back Button 
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 6;
		backButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) { System.exit(0);
		  }
		});
		add(backButton, gbc_backButton);

	}

}
