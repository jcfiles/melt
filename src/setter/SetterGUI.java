package setter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;
import javax.swing.JTree;
import javax.swing.SpringLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import backend.FIBQ;
import backend.MCQ;
import backend.Question;
import backend.Section;
import backend.Subsection;
import backend.SubsectionContainer;
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
					//frame = new SetterGUI(Test_.getDemoTest2());
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
		
		//save test to file
		saveTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				JFileChooser chooser = new JFileChooser();
				int option = chooser.showSaveDialog(SetterGUI.this);
				if (option == JFileChooser.APPROVE_OPTION) 
				{
					String fileName = chooser.getSelectedFile().getAbsolutePath();
					try 
					{
						//get reference to controller
						obj.saveTest(fileName);
						// TODO add savetest to the controller
					} catch (Exception e) {
		    		 // TODO Auto-generated catch block
		    		 e.printStackTrace();
					}
				}//if
		  }//actionPerformed
		});

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
							if(current.getUserObject() instanceof Question)
							{
							
								if(current.getUserObject() instanceof MCQ)
								{
									
								}
								
								if(current.getUserObject() instanceof FIBQ)
								{
									
								}
								
								if(current.getUserObject() instanceof Question)
								{
									
								}
								
								if(current.getUserObject() instanceof Question)
								{
									
								}
								
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
			 //parent=current;
			// current=temp;
		}
		else
		{
			/*DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
				
			DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
			treeModel.insertNodeInto(temp1, parent, parent.getChildCount());
			parent=temp;*/
			
			DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			 treeModel.insertNodeInto(temp, (MutableTreeNode) current, current.getChildCount());
			 
			 //current=temp;
		}
		
		   
			
		treeModel.reload();
		   
	}
	
	public void setTree(Question s)
	{
		DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
		 treeModel.insertNodeInto(temp, (MutableTreeNode) current, current.getChildCount());
		 if(!(current.getUserObject() instanceof Question))
		 {
			 parent=current;
		 }		 
		 current=temp;
		 
		/*
		  DefaultMutableTreeNode temp=new DefaultMutableTreeNode(s);
			   
		  DefaultMutableTreeNode z=new DefaultMutableTreeNode();
		  z=(DefaultMutableTreeNode) parent.getParent();
				
		  DefaultMutableTreeNode temp1=new DefaultMutableTreeNode(s);
		  treeModel.insertNodeInto(temp1, z, z.getChildCount());
		  parent=temp;

		  
		   treeModel.reload();
		   
		   */
		   
	}

	
	public SetterGUI(Test_ test) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 733, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		obj=new SetterTestController(test);
		
		//tree initialisation
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(test);
    treeModel = new DefaultTreeModel(rootNode);
    
    final JTree tree = new JTree(treeModel);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
    //recursive insert
    for(int i=0; i<test.getAllSections().size(); i++)
    {
    	//add all sections
      DefaultMutableTreeNode section = new DefaultMutableTreeNode(test.getSection(i));
      treeModel.insertNodeInto(section, rootNode, i);
      //rootNode.add(section);
      
      //to this section node add all its subsections recursively
      ArrayList<SubsectionContainer> s = ((Section)section.getUserObject()).getContainer();
      
      //check if section is empty
      if(s.size() == 0)
        continue;
      else if(s.get(0) instanceof Question) //check if this section contains questions directly
      {
        for(int j=0; j < s.size(); j++)
        {
          //add questions
          DefaultMutableTreeNode currentNode = new DefaultMutableTreeNode(s.get(j));
          treeModel.insertNodeInto(currentNode, section, j);
        }
      }
      else // it will contain subsections so add them recursively
        for(int j=0; j < s.size(); j++)
        {
          DefaultMutableTreeNode currentNode = new DefaultMutableTreeNode(s.get(j));
          treeModel.insertNodeInto(currentNode, section, j);
          recursiveAdd(section, currentNode);
        }
    }   
		
		// Tree Panel
		contentPane.add(treePanel, BorderLayout.WEST);

		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2, false);
		treePanel.setBorder(lineBorder);
		treePanel.setLayout(new BorderLayout(0, 0));
		tree.setFont(new Font("Calibri", Font.PLAIN, 13));
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
		
		//save test to file
		saveTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				JFileChooser chooser = new JFileChooser();
				int option = chooser.showSaveDialog(SetterGUI.this);
				if (option == JFileChooser.APPROVE_OPTION) 
				{
					String fileName = chooser.getSelectedFile().getAbsolutePath();
					try 
					{
						//get reference to controller
						obj.saveTest(fileName);
						// TODO add savetest to the controller
					} catch (Exception e) {
		    		 // TODO Auto-generated catch block
		    		 e.printStackTrace();
					}
				}//if
		  }//actionPerformed
		});

		//TODO add mouseListener for tree like in the constructor above
		
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

				
			}//for
		}//else
	}//recursiveAdd
}
