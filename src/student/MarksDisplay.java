package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import setter.MenuGUI;
import setter.SetterGUI;
import backend.*;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class MarksDisplay extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MarksDisplay frame = new MarksDisplay();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MarksDisplay()
	{
		setTitle("Marks Display");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane marksOutput = new JScrollPane();
		marksOutput.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(marksOutput, BorderLayout.CENTER);
		
		JTextPane reportPane = new JTextPane();
		reportPane.setEditable(false);
		marksOutput.setViewportView(reportPane);
		
		JButton btnSaveResults = new JButton("Save Results");
		contentPane.add(btnSaveResults, BorderLayout.SOUTH);
		
		JLabel testLabel = new JLabel("");
		contentPane.add(testLabel, BorderLayout.NORTH);
		
		
		//open test
		Test_ test = null; 
  	MarkingResultGenerator mrg = null;
		
  	JFileChooser chooser = new JFileChooser();
		int option = chooser.showOpenDialog(MarksDisplay.this);
		if (option == JFileChooser.APPROVE_OPTION) 
		{
			String sourceFile = chooser.getSelectedFile().getAbsolutePath();
			try 
			{
				//load test
				test = Test_.readFromFile(sourceFile);
			} catch (Exception ex) {
	   		 // TODO Auto-generated catch block
	   		 ex.printStackTrace();
			}
			
			mrg = new MarkingResultGenerator(test);
			testLabel.setText("Showing results for: " + test.getTestTitle());
			reportPane.setText(mrg.getMarksReport());
			
		}//if	
		else
		{
			//TODO open error window
		}
		
		final String report = mrg.getMarksReport();
		
		//saveButton
		btnSaveResults.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
      	String fileName = null;
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(MarksDisplay.this);
        if (option == JFileChooser.APPROVE_OPTION) {
          fileName = chooser.getSelectedFile().getAbsolutePath();
          
        try {
				
        	// creates a FileWriter Object
        	PrintWriter out = new PrintWriter(fileName);
			      
        	// Record the date and time in the file.
        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        	DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        	Date date = new Date();
				
        	// write the date and time taken the test
        	out.println("Date: " + dateFormat.format(date) + "\n");
				
        	out.println(report);
        	
        	out.close();

        } catch (Exception e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }


        } else {
        	//TODO open error window
        }//else
      }//actionPerformed
    }); //addActionListener
	}//MarksDisplay constructor

}//class
