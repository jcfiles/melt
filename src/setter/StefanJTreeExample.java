package setter;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.*;

import backend.*;

public class StefanJTreeExample extends JFrame {

	private JPanel contentPane;
	DefaultTreeModel treeModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StefanJTreeExample frame = new StefanJTreeExample();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InvalidSlotQFormatException 
	 */
	public StefanJTreeExample() throws InvalidSlotQFormatException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Test_ test = Test_.getDemoTest2();
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(test);
    treeModel = new DefaultTreeModel(rootNode);
    
    final JTree tree = new JTree(treeModel);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
    for(int i=0; i<test.getAllSections().size(); i++)
    {
    	//add all sections
      DefaultMutableTreeNode section = new DefaultMutableTreeNode(test.getSection(i));
      treeModel.insertNodeInto(section, rootNode, i);
      //rootNode.add(section);
      
      //to this section node add all its subsections recursively
      ArrayList<SubsectionContainer> s = ((Section)section.getUserObject()).getContainer();
      for(int j=0; j < s.size(); j++)
      {
      	DefaultMutableTreeNode currentNode = new DefaultMutableTreeNode(s.get(j));
      	treeModel.insertNodeInto(currentNode, section, i);
      	recursiveAdd(section, currentNode);
      }
      
    }   
    
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tree.getSelectionPath()!=null){
				  if(((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject() instanceof Test_)
				    System.out.println(((Test_)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getTestIntroText());
				  else if (((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject() instanceof Section)
				    System.out.println(((Section)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getSectionIntroText());
				  else if(((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject() instanceof Subsection)
				    System.out.println(((Subsection)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getSubsectionTitle());
				  else if(((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject() instanceof Question)
				    System.out.println(((Question)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getQuestionText());
				}
				
			}
		});
		contentPane.add(tree, BorderLayout.WEST);
	}
	
	//this will traverse the test structure recursively for subsections and then for each subsection found it will 
	//check whether it is empty or contains questions, if it has another subsection it will call itself in that.
	public void recursiveAdd(DefaultMutableTreeNode parent, DefaultMutableTreeNode currentChild)
	{
		//check if exiting node
		//ie check for no more subsections or questions
		Subsection currentSub = (Subsection) currentChild.getUserObject();
		if(currentSub.isEmpty()) //if it is empty just return
			return;
		else if(currentSub.hasQuestions())
		{
			//if it has questions add them as treeNodes to the tree
			ArrayList<SubsectionContainer> sc = currentSub.getContainer();
			for(int i=0; i < sc.size(); i++)
			{
				DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(sc.get(i));
				treeModel.insertNodeInto(newChild, currentChild, i); //add the question
			}
		}
		else 
		{
			//it will have more subsections so add them recursively
			ArrayList<SubsectionContainer> sc = currentSub.getContainer();
			for(int i=0; i < sc.size(); i++)
			{
				System.out.println(currentSub.toString());
				DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(sc.get(i));
				recursiveAdd(currentChild, newChild); //search this subsection for more subsections so currentChild will become the new parent and newChild the current one for this iteration
				treeModel.insertNodeInto(newChild, currentChild, i); //add the subsection

				
			}
			
		}
	}

}
