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
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JTree;
import javax.swing.SpringLayout;

import java.awt.Font;

import javax.swing.ImageIcon;

import backend.Question;
import backend.Section;
import backend.Subsection;

/*
 * @author Erotokritou Zoe
 */
public class SetterGUI extends JFrame {

	private JPanel contentPane;
	private JPanel treePanel = new JPanel();
	public JPanel centerPanel = new JPanel();
	private JTree tree = new JTree(new MyTreeModel());
	private JButton saveTest = new JButton("Save Test");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetterGUI frame = new SetterGUI();
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

		// Tree Panel
		contentPane.add(treePanel, BorderLayout.WEST);

		Border lineBorder = BorderFactory
				.createLineBorder(Color.BLACK, 2, false);
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

		SetterTestController obj=new SetterTestController();
		CreateTestPanel panel = new CreateTestPanel(obj,this,false);
		centerPanel.add(panel);

	}
	
	public class MyTreeModel implements TreeModel {
		  // We specify the root directory when we create the model.
		  private Object obj=null;
		  private int type=0;
		  
		  MyTreeModel()
		  {
		  
		  }

		  public void addSection(Section o)
		  {
			  obj=o;
			  type=0;
		  }
		  public void addSubsection(Subsection o)
		  {
			  obj=o;
			  type=1;
		  }
		  
		  public void addQuestion(Question o)
		  {
			  obj=o;
			  type=2;
		  }
		  
		  public Section getSection()
		  {
			  return (Section)obj;
		  }
		  
		  public Subsection getSubsection()
		  {
			  return (Subsection)obj;
		  }
		  
		  public Question getQuestion()
		  {
			  return (Question)obj;
		  }
		  
		  
		  public int getType()
		  {
			  return type;
		  }

		@Override
		public void addTreeModelListener(TreeModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getChild(Object parent, int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getChildCount(Object parent) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIndexOfChild(Object parent, Object child) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getRoot() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isLeaf(Object node) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeTreeModelListener(TreeModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
			// TODO Auto-generated method stub
			
		}

	}

}
