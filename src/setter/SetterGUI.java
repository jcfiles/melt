package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;
import javax.swing.JTree;
import javax.swing.SpringLayout;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import backend.Question;
import backend.Section;
import backend.Subsection;
import backend.Test_;

import javax.swing.JScrollPane;

/*
 * @author Erotokritou Zoe
 */
public class SetterGUI extends JFrame {

	private JPanel contentPane;
	private JPanel treePanel = new JPanel();
	public JPanel centerPanel = new JPanel();
	public JTree tree;
	private SetterTestController obj;
	private JButton saveTest = new JButton("Save Test");
	//public Object parent;
	//public Object currentObject;
	public DefaultMutableTreeNode current;
	public DefaultMutableTreeNode parent;
	private DefaultTreeModel treeModel;
	private static SetterGUI frame ;
	//public int type=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SetterGUI();
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
	public SetterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 733, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		obj=new SetterTestController();
		
		/*
		//tree initialisation
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(obj.getTest());
		DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		*/
		
		//tree initialisation
		current=new DefaultMutableTreeNode("Create Test");
		treeModel=new DefaultTreeModel(current);
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		
		
		
		
		// Tree Panel
		contentPane.add(treePanel, BorderLayout.WEST);

		Border lineBorder = BorderFactory
				.createLineBorder(Color.BLACK, 2, false);
		treePanel.setBorder(lineBorder);
		treePanel.setLayout(new BorderLayout(0, 0));
		
		treePanel.add(tree, BorderLayout.CENTER);
		saveTest.setIcon(new ImageIcon(SetterGUI.class.getResource("/lib/images/save-icon.png")));
		saveTest.setBackground(new Color(100, 149, 237));
		saveTest.setFont(new Font("MV Boli", Font.PLAIN, 15));
		treePanel.add(saveTest, BorderLayout.SOUTH);
		saveTest.setPreferredSize(new Dimension(200, 40));

		// Center Panel
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout((new BorderLayout(0, 0)));

		CreateTestPanel panel = new CreateTestPanel(obj,this,false);
		centerPanel.add(panel);
		

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				if(tree.getSelectionPath()!=null){
					//System.out.println(((Section)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getSectionTime());
				
					currentObject=tree.getSelectionPath().getLastPathComponent();
							
					currentObject=((DefaultMutableTreeNode)currentObject).getUserObject();
							
					//parentObject=((DefaultMutableTreeNode)currentObject).getParent();	
					
					parent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
							
					/*		
					currentObject=((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject();
		
					parentObject=((DefaultMutableTreeNode) currentObject).getParent();
					*
					
					//parentObject=null;
					
					if(currentObject instanceof Test_)
					{
						
					}				
					if(currentObject instanceof Section)
					{
						ViewSectionPanel panelS= new ViewSectionPanel(obj,frame,(Section)currentObject );
					
						centerPanel.removeAll();
						centerPanel.add(panelS);
										
						centerPanel.validate();
						centerPanel.repaint();
					}
					
					if(currentObject instanceof Subsection)
					{
						
					}
					
					if(currentObject instanceof Question)
					{
						
					}
					
					
					
				}*/
				
				if(tree.getSelectionPath()!=null){
					//System.out.println(((Section)((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent()).getUserObject()).getSectionTime());
				
					current=(DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
					
					parent=(DefaultMutableTreeNode) current.getParent();
							
					//currentObject=((DefaultMutableTreeNode)currentObject).getUserObject();
							
					//parentObject=((DefaultMutableTreeNode)currentObject).getParent();	
					
					//parent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					
					
					if(current.getUserObject() instanceof Section)
					{
						ViewSectionPanel panel=new ViewSectionPanel(obj,frame,(Section)current.getUserObject());
						
						centerPanel.removeAll();
						centerPanel.add(panel);
					
						centerPanel.validate();
						centerPanel.repaint();
					}
					else
						if(current.getUserObject() instanceof Subsection)
							{
							//type=1;
							SubsectionContentPanel panel=new SubsectionContentPanel(obj,frame);
						
							centerPanel.removeAll();
							centerPanel.add(panel);
						
							centerPanel.validate();
							centerPanel.repaint();
							}
						else
						{
							ViewCreatePanel panel=new ViewCreatePanel(obj,frame);
							
							centerPanel.removeAll();
							centerPanel.add(panel);
						
							centerPanel.validate();
							centerPanel.repaint();
						}
				}
				
			}
		});

	}
	
	public void setTree(Test_ t)
	{
		DefaultMutableTreeNode d = (DefaultMutableTreeNode) treeModel.getRoot();
		d.setUserObject(t);
		treeModel.reload();
		repaint();
		revalidate();
	}
	
	public void setTree(Section s)
	{
		 /*if(parent.isRoot()==true)
		   {
			   DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			   treeModel.insertNodeInto(temp, parent, parent.getChildCount());
			   parent=temp;
		   }
		   else
		   {
			   DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			   
			   DefaultMutableTreeNode z=new DefaultMutableTreeNode();
				z=(DefaultMutableTreeNode) parent.getParent();
				
				DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
				treeModel.insertNodeInto(temp1, z, z.getChildCount());
				parent=temp;
		   }*/
		
		if(parent==null)
		{
			DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			 treeModel.insertNodeInto(temp, (MutableTreeNode) current, current.getChildCount());
			 parent=current;
			 current=temp;
		}
		else
		{
			DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			 treeModel.insertNodeInto(temp, (MutableTreeNode) parent, parent.getChildCount());
			
			 //current=temp;
		}
		
		
			
		 treeModel.reload();
		   
	}
	
	public void setTree(String title, Boolean bEdit, int type)
	{
		//parent=current;
		
		Subsection s=null;
		
		
		if(bEdit==false){			
			s=new Subsection(title,current.getUserObject());
			obj.addSubsection(s);
		}
		else
		{
			//s=new Subsection(title,parent.getParent());
			//type=obj.addSubsection(s);
		}
		
			
		if(type!=0)
		{/*
			DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			   
			DefaultMutableTreeNode z=new DefaultMutableTreeNode();
			z=(DefaultMutableTreeNode) parent.getParent();
				
			DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
			treeModel.insertNodeInto(temp1, z, z.getChildCount());
			parent=temp;
			*/
			DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			 treeModel.insertNodeInto(temp, (MutableTreeNode) current, current.getChildCount());
			 parent=current;
			 current=temp;
		}
		else
		{
			/*DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
				
			DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
			treeModel.insertNodeInto(temp1, parent, parent.getChildCount());
			parent=temp;*/
			
			DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			 treeModel.insertNodeInto(temp, (MutableTreeNode) parent, parent.getChildCount());
			 
			 //current=temp;
		}
		
		   
			
		treeModel.reload();
		   
	}
	
	public void setTree(Question s)
	{
		  DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			   
		  DefaultMutableTreeNode z=new DefaultMutableTreeNode();
		  z=(DefaultMutableTreeNode) parent.getParent();
				
		  DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
		  treeModel.insertNodeInto(temp1, z, z.getChildCount());
		  parent=temp;

		  
		   treeModel.reload();
		   
	}

}
