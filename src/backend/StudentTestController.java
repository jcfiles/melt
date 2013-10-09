package backend;

import student.FinishTestPanel;
import student.MainGui;
import student.TestSectionPanel;

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
    
    public void startSection(Section section) {
        MainGui.setComposite(new TestSectionPanel(this, section));
        SectionTimer timer = new SectionTimer(this, section, section.getSectionTime());
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