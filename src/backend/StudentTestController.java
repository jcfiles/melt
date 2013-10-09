package backend;

import student.FinishTestPanel;
import student.MainGui;

/**
 * This class delegates all UI functionality to the application 'backend' for
 * the use case of a student taking a test.
 * 
 * @author Bruce Steedman
 * @version 2013.10.08
 */
public class StudentTestController {
    
    private Test_ test;
    
    /**
     * Constructor instantiates a demo test.
     */
    public StudentTestController() {
        this.test = Test_.getDemoTest();
    }
    
    public Test_ getTest() {
        return test;
    }
    
    /**
     * TBC.
     */
    public void endSection(Section section) {
        String sectionMarks = String.valueOf(section.gradeSection());
        FinishTestPanel finishpanel = new FinishTestPanel(sectionMarks);
        MainGui.setComposite(finishpanel);
    }
}