package student;

import java.util.HashMap;

import backend.Question;
import backend.FTBQ;
import backend.MCQ;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Factory t produce question panels according to the question type.
 * @author Bruce Steedman
 * @version 2013.10.12
 */
public class QuestionPanelFactory {
    
    private static final QuestionPanelFactory INSTANCE = new QuestionPanelFactory();
    private static HashMap<Class, Class> questionPanelMap = new HashMap<>();
    static {
       questionPanelMap.put(FTBQ.class, FTBQuestionPanel.class);
       questionPanelMap.put(MCQ.class, MCQuestionPanel.class);  
    }
    
    public static QuestionPanelFactory getInstance() { return INSTANCE; }
    
    public QuestionPanel createQuestionPanel(Question question) {//throws Exception {
        if(question.getClass().getName().equals("backend.FTBQ")) { return new FTBQuestionPanel((FTBQ)question); }
        else if(question.getClass().getName().equals("backend.MCQ")) { return new MCQuestionPanel((MCQ)question); }
        return null;
        //Class questionClass = question.getClass();
        //Class questionPanelClass = questionPanelMap.get(questionClass);
        //Constructor productConstructor = questionPanelClass.getDeclaredConstructor(new Class[] { String.class });
	//return (QuestionPanel)productConstructor.newInstance(new Object[] { });
   }
}