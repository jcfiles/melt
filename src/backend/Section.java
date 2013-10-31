package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of a section
 * 
 * @author Lok Chan, assisted by Bruce
 * @version 2013.09.28
 */
public class Section implements java.io.Serializable
{
    private String sectionTitle;
    private String sectionIntroText;
    private ArrayList<Object[][]> questionsAndPathsWithSection;
    private ArrayList<Object[][]> questionsAndPathsWithoutSection;
    private ArrayList<SubsectionContainer> subsectionContainer;
  //  private int possibleSectionMarks = 0; // Built as questions added/removed
 //   private int sectionMarksAwarded;
    private boolean isLocked;
    private SectionTimer sectionProgram;
    private int sectionTime;
    //private SubsectionContainer subsectionContainer;

    /**
     * Constructor for objects of class Section
     * @param sectionTime in minutes
     */
    public Section(String sectionTitle, String sectionIntroText, int sectionTime)
    {
        this.sectionTitle = sectionTitle;
        this.sectionIntroText = sectionIntroText;
        this.sectionTime = sectionTime;
       // this.questions = new ArrayList<Question>();        
        this.subsectionContainer=new ArrayList<SubsectionContainer>();
    }
    
    public void editSection(String sectionTitle, String sectionIntroText, int sectionTime)
    {
    	this.sectionTitle = sectionTitle;
        this.sectionIntroText = sectionIntroText;
        this.sectionTime = sectionTime;
    }
    
    public ArrayList<SubsectionContainer> getContainer()
    {
    	return subsectionContainer;
    }
    
    public void addQuestion(Question q)
    {
    	subsectionContainer.add(q);
       // possibleSectionMarks += q.getPossibleMarks();
    }
    
    public void removeQuestion(Question q)
    {
    	subsectionContainer.remove(q);
        //possibleSectionMarks -= q.getPossibleMarks();
    }
 
    public void addSubsection(Subsection s)
    {
    	subsectionContainer.add(s);
    }
    
    public void removeSubsection(Subsection s)
    {
    	subsectionContainer.remove(s);
    }
    
    public String getSectionTitle()
    {
        return sectionTitle;
    }
    
    public String getSectionIntroText()
    {
        return sectionIntroText;
    }
    
    public int getSectionTime()
    {
        return sectionTime;
    }
    
    /*
     * Locks the section
     */
    public void lockSection(){
    	isLocked = true;
    }
    
    /*
     * Returns true or false if the section is locked
     */
    public boolean isLocked(){
    	return isLocked;
    }
    
    public void endSection() {
        gradeSection();
    }
    
    /**
     * Grades the section 
     */
    public int gradeSection()
    {
       /* sectionMarksAwarded = 0;
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()) {
            Question q = it.next();
            sectionMarksAwarded += q.getMarksAwarded();
        }
        return sectionMarksAwarded;
        */
    	
    	return 0;
    }
    
    
    
    /*
    public Subsection getSubsectonContainer()
    {
      return subsectionContainer;
    }
    
    public Subsection createSubsection(String subsectionTitle)
    {
      subsectionContainer = new Subsection(subsectionTitle);
      
      return subsectionContainer;
    }
    
    public Subsection createSubsectionWithQuestions(String subsectionTitle, ArrayList<Question> qs)
    {
      subsectionContainer = new Subsection(subsectionTitle, qs);
      
      return subsectionContainer;
    }
    
    public Subsection createQuestionSubsection()
    {
      subsectionContainer = new Subsection(questions);
      return subsectionContainer;
    }
    
    public String getSectionTitle()
    {
        return sectionTitle;
    }
    
    public String getSectionIntroText()
    {
        return sectionIntroText;
    }
    
    public int getSectionTime()
    {
        return sectionTime;
    }
    
    public int getPossibleSectionMarks()
    {
        return possibleSectionMarks;
    }
    
    public void addQuestion(Question q)
    {
        questions.add(q);
        possibleSectionMarks += q.getPossibleMarks();
    }
    
    public void removeQuestion(Question q)
    {
        questions.remove(q);
        possibleSectionMarks -= q.getPossibleMarks();
    }
    
    public void insertQuestion(Question q, int index)
    {
        questions.set(index, q);
    }
    
    public void swapQuestions(Question q1, Question q2){
    	int positionQ1 = 0;
    	int positionQ2 = 0;
    	for(int i=0; i<questions.size(); i++){
    		if(q1.equals(questions.get(i))){
    			positionQ1 = i;
    		}
    		if(q2.equals(questions.get(i))){
    			positionQ2 = i;
    		}
    	}
    	questions.remove(positionQ1);
    	questions.add(positionQ1, q2);
    	questions.remove(positionQ2);
    	questions.add(positionQ2, q1);
    }
    
    /**
     * Returns an question by index, starting at 0
     *
    public Question getQuestion(int questionNum)
    {
        return questions.get(questionNum);
    }
    
    /**
     * Returns a list of all question in the section
     *
    public ArrayList<Question> getQuestionsList()
    {
        return questions;
    }
    
    /**
     * Starts the test
     *
    //public void startSection() 
    //{
      //   new SectionTimer(this, sectionTime);
    //}
    
    public void endSection() {
        gradeSection();
    }
    
    /**
     * Grades the section 
     *
    public int gradeSection()
    {
        sectionMarksAwarded = 0;
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()) {
            Question q = it.next();
            sectionMarksAwarded += q.getMarksAwarded();
        }
        return sectionMarksAwarded;
    }
    
    /**
     * String representation of the test
     * 
     *
    public String toString()
    {
        String s = sectionTitle + "\n" + sectionIntroText + "\n\n";
        Iterator<Question> it = questions.iterator();
        int qNum = 1;
        while (it.hasNext()) {
            s += "Question " + qNum + ": " + it.next().toString() + "\n\n";
            qNum++;
        }
        return s;
    }*/
    public String toString(){
    	return this.getSectionTitle();
    }
    
    
    
    /*
     * Locks the section
     *
    public void lockSection(){
    	isLocked = true;
    }
    
    /*
     * Returns true or false if the section is locked
     *
    public boolean isLocked(){
    	return isLocked;
    }
    */
    private Question getQuestionWithSection(SubsectionContainer sc){
		if((sc instanceof Subsection)==false){
			Object[][] questionAndPath= new Object[1][2]; 
			questionAndPath[0][0]=(Question)sc;
			String path = "";
			Object parent = sc.getParent();
			while(!(parent instanceof Section)){
				if(!path.equals("")){
					path = ((Subsection)parent).getSubsectionTitle()+" > "+path;
				}
				else{
					path = ((Subsection)parent).getSubsectionTitle();
				}
				parent = ((SubsectionContainer) parent).getParent();
			}
			path=((Section)parent).getSectionTitle()+" > "+path;
			questionAndPath[0][1]=path;
			questionsAndPathsWithSection.add(questionAndPath);
			return (Question) sc;
		}
		for(int i=0; i<((Subsection)sc).getContainer().size(); i++){
			getQuestionWithSection(((Subsection)sc).getContainer().get(i));
		}
		
		return null;
	}
	
	/**
	 * This function returns an array list of 2 dimensional Objects. In the 0,0 position of the object is the Question class and in the 0,1 position of the object is the path to the question with the parent section
	 * @param Section s
	 * @return ArrayList<Object[][]>
	 */
	public ArrayList<Object[][]> getQuestionsAndPathsWithSection(){
		questionsAndPathsWithSection = new ArrayList<>();
		for(int i=0; i<getContainer().size(); i++){
			getQuestionWithSection(getContainer().get(i));
		}
		return questionsAndPathsWithSection;
	}
	
	/**
	 * This function returns an array list of 2 dimensional Objects. In the 0,0 position of the object is the Question class and in the 0,1 position of the object is the path to the question without the parent section
	 * @param Section s
	 * @return ArrayList<Object[][]>
	 */
	public ArrayList<Object[][]> getQuestionsAndPathsWithoutSection(){
		questionsAndPathsWithoutSection = new ArrayList<>();
		for(int i=0; i<getContainer().size(); i++){
			getQuestionWithoutSection(getContainer().get(i));
		}
		return questionsAndPathsWithoutSection;
	}
	
	
	private Question getQuestionWithoutSection(SubsectionContainer sc){
		if((sc instanceof Subsection)==false){
			Object[][] questionAndPath= new Object[1][2]; 
			questionAndPath[0][0]=(Question)sc;
			String path = "";
			Object parent = sc.getParent();
			while(!(parent instanceof Section)){
				if(!path.equals("")){
					path = ((Subsection)parent).getSubsectionTitle()+" > "+path;
				}
				else{
					path = ((Subsection)parent).getSubsectionTitle();
				}
				parent = ((SubsectionContainer) parent).getParent();
			}
			questionAndPath[0][1]=path;
			questionsAndPathsWithoutSection.add(questionAndPath);
			return (Question) sc;
		}
		for(int i=0; i<((Subsection)sc).getContainer().size(); i++){
			getQuestionWithoutSection(((Subsection)sc).getContainer().get(i));
		}
		
		return null;
	}

	/**
	 * Returns an array list of questions that are contained within a section
	 * @param Section s
	 * @return ArrayList<Question>
	 */
	public ArrayList<Question> getQuestions(){
		questionsAndPathsWithSection = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();
		for(int i=0; i<getContainer().size(); i++){
			getQuestionWithSection(getContainer().get(i));
		}
		for(int i=0; i<questionsAndPathsWithSection.size(); i++){
			questions.add((Question)questionsAndPathsWithSection.get(i)[0][0]);
		}
		return questions;
	}
}
