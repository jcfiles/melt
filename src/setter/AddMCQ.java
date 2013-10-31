package setter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import student.TestSectionPanel;
import java.awt.Font;

/*
 * @author Erotokritou Zoe
 */
public class AddMCQ extends JPanel {
	
	public JTable possibleAnswers;
	private JButton btnSave = new JButton("Save");
	private String header[] = new String[]{"Answer","Correct"};
	private DefaultTableModel model;
	private ImageIcon correctAnswerImage,wrongAnswerImage;
	private Object[][] data;
	private Boolean bEdit=false;

	/**
	 * Create the panel.
	 */
	public AddMCQ(ArrayList<String> list,final SetterGUI gui, Boolean b) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		bEdit=b;
		correctAnswerImage=new ImageIcon(TestSectionPanel.class.getResource("/lib/images/check.png"));
		wrongAnswerImage=new ImageIcon(TestSectionPanel.class.getResource("/lib/images/delete.png"));
		
		JLabel lblPossibleAnswers = new JLabel("Possible Answers:");
		lblPossibleAnswers.setFont(new Font("MV Boli", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblPossibleAnswers, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPossibleAnswers, 10, SpringLayout.WEST, this);
		add(lblPossibleAnswers);
		
		JButton btnAdd = new JButton();
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 75, SpringLayout.NORTH, this);
		btnAdd.setIcon(new ImageIcon(AddMCQ.class.getResource("/lib/images/plus.png")));
		btnAdd.setBackground(new Color(0, 153, 0));
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -10, SpringLayout.EAST, this);
		btnAdd.setPreferredSize(new Dimension(40,40));
		add(btnAdd);
		
		JButton btnDelete = new JButton();
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 6, SpringLayout.SOUTH, btnAdd);
		btnDelete.setIcon(new ImageIcon(AddMCQ.class.getResource("/lib/images/cross.png")));
		btnDelete.setBackground(new Color(204, 0, 0));
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, btnAdd);
		btnDelete.setPreferredSize(new Dimension(40,40));
		add(btnDelete);
		
		JScrollPane scrollPanel = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPanel, 16, SpringLayout.SOUTH, lblPossibleAnswers);
		springLayout.putConstraint(SpringLayout.WEST, scrollPanel, 0, SpringLayout.WEST, lblPossibleAnswers);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPanel, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPanel, -6, SpringLayout.WEST, btnAdd);
		add(scrollPanel);
		
		possibleAnswers = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, possibleAnswers, 16, SpringLayout.SOUTH, lblPossibleAnswers);
		springLayout.putConstraint(SpringLayout.SOUTH, possibleAnswers, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, possibleAnswers, -6, SpringLayout.WEST, btnAdd);
		
		
		data = new Object[0][0];
		model = new DefaultTableModel(data,header);  		  
		model.setColumnIdentifiers(header);  
		possibleAnswers = new JTable(model) {

            private static final long serialVersionUID = 1L;
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
            
            
        };
        
        possibleAnswers.isEditing();
        possibleAnswers.setRowHeight(30);
        scrollPanel.setViewportView(possibleAnswers);
        
        
        if(bEdit==true)
		{
        	if(list!=null){
        	Object[][] temp = new Object[list.size()-2/2][2];
			
			int num=0;
			for(int i=2; i<list.size(); i=i+2)
			{				
				temp[num][0]=list.get(i);
				if(list.get(i+1).equals(true+""))
				{
					temp[num][1]=correctAnswerImage;
				}
				else
				{
					temp[num][1]=wrongAnswerImage;
				}
				num++;
			}

		     DefaultTableModel model = new DefaultTableModel(temp, header); 	
		     possibleAnswers.setModel(model);
        	}
		}
        
        
        
        possibleAnswers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(possibleAnswers.columnAtPoint(e.getPoint())==1){
					if(possibleAnswers.getModel().getValueAt(possibleAnswers.rowAtPoint(e.getPoint()), 1)==wrongAnswerImage){
						possibleAnswers.getModel().setValueAt(correctAnswerImage, possibleAnswers.rowAtPoint(e.getPoint()), 1);
						possibleAnswers.repaint();
					}
					else{
						possibleAnswers.getModel().setValueAt(wrongAnswerImage, possibleAnswers.rowAtPoint(e.getPoint()), 1);
						possibleAnswers.repaint();
					}
				}
				else
				{
					String temp=possibleAnswers.getModel().getValueAt(possibleAnswers.rowAtPoint(e.getPoint()), 0).toString();
					possibleAnswers.getModel().setValueAt(temp, possibleAnswers.rowAtPoint(e.getPoint()), 0);
					possibleAnswers.repaint();
				}
				
				
			}
		});
		
		
      /// clicking the Add new possible answer
      		btnAdd.addActionListener(new ActionListener(){
      		    public void actionPerformed(ActionEvent e) {

      		    	Object[][] temp = new Object[possibleAnswers.getRowCount()+1][2];
      			     
      		    	int i=0;
      			     for(i=0; i<possibleAnswers.getRowCount(); i++)
      			     {
      			    	 temp[i][0]=possibleAnswers.getModel().getValueAt(i, 0);
      			    	 temp[i][1]=possibleAnswers.getModel().getValueAt(i, 1);
      			     }
      			     temp[i][0]="";
      			     temp[i][1]=wrongAnswerImage;

      			     DefaultTableModel model = new DefaultTableModel(temp, header); 	
      			     possibleAnswers.setModel(model);
      		    	
      			    }
      		});
      		
      		
      		
      		btnDelete.addActionListener(new ActionListener(){
      		    public void actionPerformed(ActionEvent e) {
      		    	
      		    	int n = JOptionPane.showConfirmDialog(
      					    gui,
      					    "Are you sure that you whant to delete ?",
      					    "Delete Answer",
      					    JOptionPane.YES_NO_OPTION);
      					
      		    	if(n==JOptionPane.YES_OPTION)
      				{
      		    	
      		    	Object[][] temp = new Object[possibleAnswers.getRowCount()-1][2];
      			     
      		    	int i=0;
      			     for(i=0; i<possibleAnswers.getRowCount(); i++)
      			     {
      			    	 if(i!=possibleAnswers.getSelectedRow())
      			    	 {
      			    		 temp[i][0]=possibleAnswers.getModel().getValueAt(i, 0);
      			    		 temp[i][1]=possibleAnswers.getModel().getValueAt(i, 1);
      			    	 }
      			    	 else
      			    	 {
      			    		 break;
      			    	 }
      			     }
      			     
      			     for(i=possibleAnswers.getSelectedRow()+1; i<possibleAnswers.getRowCount()-1; i++)
      			     {
      			    	 temp[i-1][0]=possibleAnswers.getModel().getValueAt(i, 0);
      		    		 temp[i-1][1]=possibleAnswers.getModel().getValueAt(i, 1);
      			     }

      			     DefaultTableModel model = new DefaultTableModel(temp, header); 	
      			     possibleAnswers.setModel(model);
      		    	
      			    }
      		    }
      		});
		
		

	}
}
