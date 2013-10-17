package setter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Erotokritou Zoe
 */
public class AddQuestionGUI extends JFrame {

  private JPanel contentPane;
  private AddQuestionPanel addPanel;
  private NavigationPanel nav;
  private MultichoicePanel multiPanel;
  private FillBlankPanel fillPanel;
  private int questionType=1;
  
  final public JPanel panelCenter=new JPanel();
  
  SetterTestController obj=new SetterTestController();
  private JButton btnHelp;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SetterTestController obj=new SetterTestController();
          MenuGUI menu=new MenuGUI();
          AddSectionGUI sec=new AddSectionGUI(obj,menu);
          AddQuestionGUI frame = new AddQuestionGUI(obj,sec);
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
  public AddQuestionGUI(SetterTestController obj, AddSectionGUI sec) {   
    super("Add Question to Section");
    this.obj=obj;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 0, 533, 720);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    
    
    JPanel panelTitle = new JPanel();
    contentPane.add(panelTitle, BorderLayout.NORTH);
    GridBagLayout gbl_panel_1 = new GridBagLayout();
    gbl_panel_1.columnWidths = new int[]{0, 0};
    gbl_panel_1.rowHeights = new int[]{0};
    gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE, 0.0};
    gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
    panelTitle.setLayout(gbl_panel_1);
    
    //Set the name of the Test and Sector
    String s=obj.getTitle()+ ": " + obj.getCurrertSectionTitle();
    JLabel lblTitle=new JLabel(s);
    JButton btnSwitch=new JButton("Switch");  //Button to switch preview
    
    GridBagConstraints gbc_lblTitle = new GridBagConstraints();
    gbc_lblTitle.insets = new Insets(0, 0, 0, 5);
    gbc_lblTitle.gridx = 0;
    gbc_lblTitle.gridy = 0;
    panelTitle.add(lblTitle, gbc_lblTitle);
    
    btnHelp = new JButton("Help");
    GridBagConstraints gbc_btnHelp = new GridBagConstraints();
    gbc_btnHelp.insets = new Insets(0, 0, 0, 5);
    gbc_btnHelp.gridx = 1;
    gbc_btnHelp.gridy = 0;
    panelTitle.add(btnHelp, gbc_btnHelp);
    GridBagConstraints gbc_btnSwitch = new GridBagConstraints();
    gbc_btnSwitch.gridx = 2;
    gbc_btnSwitch.gridy = 0;
    panelTitle.add(btnSwitch, gbc_btnSwitch);
    
    //The panel in the center   
    Border lineBorder=BorderFactory.createLineBorder(Color.GRAY, 2, true);
    panelCenter.setBorder(lineBorder);
    contentPane.add(panelCenter, BorderLayout.CENTER);
    panelCenter.setLayout(new GridLayout(1, 0, 0, 0));     
    addPanel=new AddQuestionPanel(obj,this, false);
    panelCenter.add(addPanel);  
    
    //The navigation panel
    nav=new NavigationPanel(obj,this,sec);
    contentPane.add(nav, BorderLayout.SOUTH);
      
    btnHelp.addActionListener(new ActionListener(){  //Edit the question
        public void actionPerformed(ActionEvent e) {
        	
        	Help help=new Help(2);
        	help.setVisible(true);
       }
    });

  }
}