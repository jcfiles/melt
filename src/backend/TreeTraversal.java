package backend;

import java.util.ArrayList;

public class TreeTraversal {
	private ArrayList<Object[][]> list = new ArrayList<>();
	
	private Question getQuestion(SubsectionContainer sc){
		if((sc instanceof Subsection)==false){
			Object[][] questionAndPath= new Object[1][2]; 
			questionAndPath[0][0]=(Question)sc;
			String path = "";
			Object parent = sc.getParent();
			while(!(parent instanceof Section)){
				path = ((Subsection)parent).getSubsectionTitle()+" > "+path;
				parent = ((SubsectionContainer) parent).getParent();
			}
			path=((Section)parent).getSectionTitle()+" > "+path;
			questionAndPath[0][1]=path;
			return (Question) sc;
		}
		for(int i=0; i<((Subsection)sc).getContainer().size(); i++){
			getQuestion(((Subsection)sc).getContainer().get(i));
		}
		
		return null;
	}
	
	/**
	 * This function returns an array list of 2 dimensional Objects. In the 0,0 position of the object is the Question class and in the 0,1 position of the object is the path to the question
	 * @param Section s
	 * @return ArrayList<Object[][]>
	 */
	public ArrayList<Object[][]> getQuestionsAndPaths(Section s){
		for(int i=0; i<s.getContainer().size(); i++){
			getQuestion(s.getContainer().get(i));
		}
		return list;
	}
}
