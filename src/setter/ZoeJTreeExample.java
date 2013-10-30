package setter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import backend.Question;
import backend.Section;
import backend.Subsection;
import backend.Test_;

import javax.swing.JButton;

public class ZoeJTreeExample extends JFrame {

	private JPanel contentPane;
	private Object mainObject;
	private DefaultMutableTreeNode node;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZoeJTreeExample frame = new ZoeJTreeExample();
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
	public ZoeJTreeExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*static DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		TeacherUI.treeModel.insertNodeInto(dmtn, parentNode, currentSection.getContents().indexOf(question));
		*/
		
		node=new DefaultMutableTreeNode("Test");
		final DefaultTreeModel treeModel=new DefaultTreeModel(node);
		
		
		
		final JTree tree = new JTree(treeModel);
		/*
		Section s=new Section("Section 1", "blah blah intro", 3);
		DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
		treeModel.insertNodeInto(temp, node, node.getChildCount());
		
		
		treeModel.reload();
		
		DefaultMutableTreeNode z=new DefaultMutableTreeNode();
		z=(DefaultMutableTreeNode) temp.getParent();
		
		DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
		treeModel.insertNodeInto(temp1, z, z.getChildCount());
		
		
		
		treeModel.reload();
		*/
		
		
		
		/*
		final JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
						Section s = new Section("Section 1", "blah blah intro", 3);
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(s);
						node_1.add(node);
						node_1.add(new DefaultMutableTreeNode("j"));
					add(node_1);
				}
			}
		));
		*/
		
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tree.getSelectionPath()!=null){
					//System.out.println(((Section)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getSectionTime());
				
					mainObject=((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject();
					
					//mainObject=null;
				
				}
				
			}
		});
		contentPane.add(tree, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnB = new JButton("Button");
		panel.add(btnB);
		
		/*static DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		TeacherUI.treeModel.insertNodeInto(dmtn, parentNode, currentSection.getContents().indexOf(question));
		*/
		btnB.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				  
				   
				   
				   if(node.isRoot()==true)
				   {
					   Test_ s=new Test_("test1", "");
					   DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
					   treeModel.insertNodeInto(temp, node, node.getChildCount());
					   node=temp;
				   }
				   else
				   {
					   Section s=new Section("Section 2", "intro", 4);
					   DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
					   
					   DefaultMutableTreeNode z=new DefaultMutableTreeNode();
						z=(DefaultMutableTreeNode) node.getParent();
						
						DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
						treeModel.insertNodeInto(temp1, z, z.getChildCount());
						node=temp;
				   }
					
				   treeModel.reload();
				   
				   
				   
				 
			   }
			});
	}

}