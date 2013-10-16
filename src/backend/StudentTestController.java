package backend;

import java.util.Iterator;
import student.FinishTestPanel;
import student.MainGui;
import student.QuestionPanel;
import student.SectionIndexPanel;
import student.TestSectionPanel;

/**
 * This class delegates all UI functionality to the application 'backend' for
 * the use case of a student taking a test.
 * 
 * @author Bruce Steedman, Dimitrios Chondrokoukis
 *
 * @version 2013.10.08
 */
public class StudentTestController {
    
    private Test_ test;
    private SectionIndexPanel sectionIndexPanel;
    
    /**
     * Constructor instantiates a demo test.
     */
    public StudentTestController() {
        this.test = Test_.getDemoTest();
        this.sectionIndexPanel = sectionIndexPanel;
    }
    
    public Test_ getTest() {
        return test;
    }
    
    /**
     * User starts a section, timer is started and test section panel displayed.
     */
    public void startSection(Section section) {
    	section.lockSection();
        TestSectionPanel testSectionPanel = new TestSectionPanel(this, section);
        MainGui.setComposite(testSectionPanel);
        SectionTimer timer = new SectionTimer(this, testSectionPanel, section.getSectionTime());
        CountdownTimer countdownTimer = new CountdownTimer(section.getSectionTime(),testSectionPanel.getLabelForTimer());
    	countdownTimer.start();
    }
    
    /**
     * User or timer stops a section, section is graded and user is returned to the section chooser panel.
     */
    public void endSection(TestSectionPanel sectionPanel) {
        Iterator<QuestionPanel> it = sectionPanel.getQuestionPanels().iterator();
        while(it.hasNext()) {
            QuestionPanel questionPanel = it.next();
            questionPanel.submitAnswer(); // Calls method according the subclass of QuestionPanel :)
        }
        boolean areAllSectionsCompleted = true;
        for(int i=0; i<test.getAllSections().size(); i++){
        	if(!test.getSection(i).isLocked()){
        		areAllSectionsCompleted = false;
        	}
        }
        if(areAllSectionsCompleted){
        	String sectionMarks = String.valueOf(sectionPanel.getSection().gradeSection());
            FinishTestPanel finishpanel = new FinishTestPanel(sectionMarks);
            MainGui.setComposite(finishpanel);
        }
        else{
        	sectionIndexPanel.EnableNextButton();
            MainGui.setComposite(sectionIndexPanel);
        }
    }
    
    /**
     * User opts to end the test.
     */
    public void endTest() {
        String testMarks = String.valueOf(test.endTest());
        FinishTestPanel finishpanel = new FinishTestPanel(testMarks);
        MainGui.setComposite(finishpanel);
    }

    /**
     * Passes a reference to the section index panel, so submit section can return user to the section index panel.
     */
    public void setSectionIndexPanel(SectionIndexPanel sectionIndexPanel) {
        this.sectionIndexPanel = sectionIndexPanel;
    }
}