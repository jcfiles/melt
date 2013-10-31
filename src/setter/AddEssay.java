package setter;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.util.ArrayList;

/*
 * @author Erotokritou Zoe
 */
public class AddEssay extends JPanel {
	public JTextField txtHeight;
	public JTextField txtWordLimit;
	private JLabel lblHeight;
	public JTextField txtWidth;

	/**
	 * Create the panel.
	 */
	public AddEssay(ArrayList<String> list, Boolean bEdit) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblSize = new JLabel("Size of the text box:");
		lblSize.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblSize, 21, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSize, 10, SpringLayout.WEST, this);
		add(lblSize);
		
		txtHeight = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtHeight, 18, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtHeight, 34, SpringLayout.EAST, lblSize);
		springLayout.putConstraint(SpringLayout.EAST, txtHeight, -174, SpringLayout.EAST, this);
		txtHeight.setFont(new Font("Verdana", Font.PLAIN, 13));
		add(txtHeight);
		txtHeight.setColumns(10);
		
		JLabel lblWordLimit = new JLabel("Word limit:");
		springLayout.putConstraint(SpringLayout.NORTH, lblWordLimit, 60, SpringLayout.SOUTH, lblSize);
		lblWordLimit.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblWordLimit, 0, SpringLayout.WEST, lblSize);
		add(lblWordLimit);
		
		txtWordLimit = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtWordLimit, 104, SpringLayout.EAST, lblWordLimit);
		txtWordLimit.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.NORTH, txtWordLimit, -3, SpringLayout.NORTH, lblWordLimit);
		springLayout.putConstraint(SpringLayout.EAST, txtWordLimit, -33, SpringLayout.EAST, this);
		add(txtWordLimit);
		txtWordLimit.setColumns(10);
		
		lblHeight = new JLabel("height");
		springLayout.putConstraint(SpringLayout.WEST, lblHeight, 6, SpringLayout.EAST, txtHeight);
		springLayout.putConstraint(SpringLayout.SOUTH, lblHeight, -253, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblHeight, -126, SpringLayout.EAST, this);
		lblHeight.setFont(new Font("MV Boli", Font.PLAIN, 15));
		add(lblHeight);
		
		txtWidth = new JTextField();
		txtWidth.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.NORTH, txtWidth, 20, SpringLayout.SOUTH, txtHeight);
		springLayout.putConstraint(SpringLayout.WEST, txtWidth, 0, SpringLayout.WEST, txtHeight);
		springLayout.putConstraint(SpringLayout.EAST, txtWidth, 0, SpringLayout.EAST, txtHeight);
		add(txtWidth);
		txtWidth.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("width");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.SOUTH, lblHeight);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblHeight);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 39, SpringLayout.WEST, lblHeight);
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		add(lblNewLabel);
		
		 if(bEdit==true)
		{
			 txtHeight.setText(list.get(1));
			 txtWidth.setText(list.get(2));
			 txtWordLimit.setText(list.get(3));
		}
	}
}
