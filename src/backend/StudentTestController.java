package backend;

import java.util.Iterator;
import student.FinishTestPanel;
import student.MainGui;
import student.QuestionPanel;
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
    
    /**
     * User starts a section, timer is started and test section panel displayed.
     */
    public void startSection(Section section) {
        TestSectionPanel testSectionPanel = new TestSectionPanel(this, section);
        MainGui.setComposite(testSectionPanel);
        SectionTimer timer = new SectionTimer(this, testSectionPanel, section.getSectionTime());
        CountdownTimer countdownTimer = new CountdownTimer(section.getSectionTime(),testSectionPanel.getLabelForTimer());
    	countdownTimer.start();
    }
    
    /**
     * User or timer stops a section, section is graded and finish test panel displayed.
     */
    public void endSection(TestSectionPanel sectionPanel) {
        Iterator<QuestionPanel> it = sectionPanel.getQuestionPanels().iterator();
        while(it.hasNext()) {
            QuestionPanel questionPanel = it.next();
            questionPanel.submitAnswer(); // Calls method according the subclass of QuestionPanel :)
        }
        String sectionMarks = String.valueOf(sectionPanel.getSection().gradeSection());
        FinishTestPanel finishpanel = new FinishTestPanel(sectionMarks);
        MainGui.setComposite(finishpanel);
    }
}