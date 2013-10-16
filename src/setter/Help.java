package setter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

public class Help extends JFrame implements TreeSelectionListener
{

  private JPanel contentPane;
  
  JTree tree;
  Map<String, String> helpContents;
  
  //jlabels that change on actionlistener event
  JLabel title;
  JTextPane description; 
  
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
          Help frame = new Help(2);
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
   * int exp chooses which subsection to expand
   * 0 = Main, 1 = Section, 2 = Question
   */
  public Help(int exp) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 600, 400);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    setTitle("Help");
    
    JScrollPane indexPane = new JScrollPane();
    indexPane.setBorder(BorderFactory.createTitledBorder("Index"));
    contentPane.add(indexPane, BorderLayout.WEST);
    
    //set elements inside the tree
    Object[] hierarchy =
      {"Help",
      
        new Object[] { "Main",
                       "Create Test",
                       "Preview"},
        new Object[] { "Section",
                "New Section",
                "Edit Sections",
                "Add Questions",
                "Switch View"},
      new Object[] { "Question",
          "New Question",
          "Edit Questions",
          "Add Sections",
          "Switch View" }};
    DefaultMutableTreeNode root = processHierarchy(hierarchy);
    tree=new JTree(root);
    indexPane.setViewportView(tree);
    tree.setRootVisible(false); 
    tree.expandRow(exp);
    //images of tree
    DefaultTreeCellRenderer renderer2 = new DefaultTreeCellRenderer();
    renderer2.setOpenIcon(null);
    renderer2.setClosedIcon(null); // null means disabled, put pictures here though
    renderer2.setLeafIcon(null);
    tree.setCellRenderer(renderer2);
    
    //actionListener
    tree.addTreeSelectionListener(this);
    
    //Add Help Information to the Map TODO put this in a separate Class or file that holds the information 
    helpContents = new HashMap<String, String>();
    helpContents.put("Main", "Select one of the subsections on the left to find help for the Main GUI.");
    helpContents.put("Create Test", "To start creating a new Test, log in as a 'Setter' by clicking the 'Setter' Button on the left of the main GUI. Then Select 'New Test'. This will open the 'Create Section' GUI. You can also name the test at the top of that Window.");
    helpContents.put("Preview", "To preview the Test from the Student view, hit 'Preview Test'.");
    
    helpContents.put("Section", "Select one of the subsections on the left to find help for the Section GUI.");
    helpContents.put("New Section", "To add a new Section, fill out the necessary information in the Section Window. This includes: Section Name, Total Time and the Instructions for the Student. Once the information is provided, you can hit the 'Save' Buttton at the bottom of the Window. This will preview the section before moving on. You now have the choice between adding another section by clicking 'Add New Section', deleting this section by hitting 'delete', edit it in case tehre is a mistake, or just proceed to add Questions to this Section by hitting 'Add Question'.");
    helpContents.put("Edit Sections", "You can Scroll between existing Sections of the Test by using the Arrow Buttons at the bottom of the page. The information for each section will be displayed in the middle of the window. For each Section you can Edit, Delete or add/edit Questions in it.");
    helpContents.put("Add Questions", "Once you are happy with the layout of a Section hit 'Save' and then 'Add Question' to add questions to this section. This will take you to the Add Question GUI.");
    helpContents.put("Switch View", "You can switch to the Student view at anytime by hitting the 'Switch' Button at the top right of the window.");
    
    helpContents.put("Question", "Select one of the subsections on the left to find help for the Question GUI");
    helpContents.put("New Question", "To create a new question we first have to assign it a valid subsection. Formulate the Question in the window labeled as 'Question'. There are 2 Types of questions supported so far: \n\nMultiple Choice: You can add Possible answers by clicking the 'Add' Button next to the fiels labelled 'Possible Answers'. Formulate the answer in the 'Answer' field and choose whether it is correct by toggling the x or the tick in the 'Correct' Field. \n\nFill in the Blanks: Here the answer will be inserte into the question text. When formulating the answer put the correct answer into the question text surrounded by Square Brackets '[]'.\nExample: The kids were [having] fun.\n\nAt last put in the number of marks that question is worth into the field labelled 'Marks'. After hitting Save button the question is displayed. You can now choose to add another question, edit it in case there is a mistake or delete it.");
    helpContents.put("Edit Questions", "You can cycle through the existing questions of the subsection by using the arrow buttons. Hit 'Edit' at the bottom to switch into editing mode or just delete the given question by hitting 'Delete'.");
    helpContents.put("Add Sections", "To add sections, hit the 'Back' Button at the bottom of the window to go back to the Section GUI.");
    
    JScrollPane infoPane = new JScrollPane();
    infoPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    contentPane.add(infoPane, BorderLayout.CENTER);

    title = new JLabel("");
    infoPane.setColumnHeaderView(title);
    
    description = new JTextPane();
    infoPane.setViewportView(description);
    
    if(exp == 0)
    {
      title.setText("Main");
      description.setText(helpContents.get("Main"));
    }
    else if (exp == 1)
    {
      title.setText("Section");
      description.setText(helpContents.get("Section"));
    }
    else if (exp == 2)
    {
      title.setText("Question");
      description.setText(helpContents.get("Question"));
    }
    else
    {
      title.setText("Help");
      description.setText("Select one of the help topics on the left.");
    }
  }
  
  @Override
  public void valueChanged(TreeSelectionEvent arg0) {
  	System.out.println(tree.getLastSelectedPathComponent().toString());
  	System.out.println(helpContents.get(tree.getLastSelectedPathComponent().toString()));
  	title.setText(tree.getLastSelectedPathComponent().toString());
  	description.setText(helpContents.get(tree.getLastSelectedPathComponent().toString()));
  }
  
  private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
    DefaultMutableTreeNode node =
      new DefaultMutableTreeNode(hierarchy[0]);
    DefaultMutableTreeNode child;
    for(int i=1; i<hierarchy.length; i++) {
      Object nodeSpecifier = hierarchy[i];
      if (nodeSpecifier instanceof Object[])  // Ie node with children
        child = processHierarchy((Object[])nodeSpecifier);
      else
        child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
      node.add(child);
    }
    return(node);
  }



}
