package setter;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.*;

import backend.*;

public class StefanJTreeExample extends JFrame {

	private JPanel contentPane;

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
    DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    
    final JTree tree = new JTree(treeModel);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
    for(int i=0; i<test.getAllSections().size(); i++)
    {
      DefaultMutableTreeNode section = new DefaultMutableTreeNode(test.getSection(i));
      rootNode.add(section);
    }
    
    DefaultMutableTreeNode currentParent = rootNode;
    while(true)
    {
      if(currentParent.getChildCount() == 0)
        break;
      
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
	
	

}
