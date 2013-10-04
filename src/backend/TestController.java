/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import student.FinishTestPanel;
import student.MainGui;
import student.StudentStartJPanel;
import student.TestPanel;

/**
 *
 * @author Bruce Steedman
 * @version 2013.10.03
 */
public class TestController implements ActionListener {
    
    private MainGui mainGui;
    private Test_ t;
    
    /**
     * Constructor for objects of class TestController
     */
    public TestController(MainGui mainGui)
    {
        this.mainGui = mainGui;
    }

    /**
     * Handler for all GUI events
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        switch (cmd) {
            case "Start":
                Test_ test = this.loadTest(); // loads the test into the panel
                TestPanel testpanel = new TestPanel(this, test);
                MainGui.setComposite(testpanel);
                break;
            case "Finish":
                t.endTest();
                double marks = t.getTotalMarks();
                FinishTestPanel finishpanel = new FinishTestPanel(String.valueOf(marks));
                MainGui.setComposite(finishpanel);
                break;
        }
    }
    
    /**
     * Loads a test - WILL LOAD FROM A FILE IN DUE COURSE
     */
    private Test_ loadTest() { // HARD CODED FOR NOW
        t = new Test_("","",5);
        Section s = new Section("Miscellaneous section.", "In this section you will answer to some random questions");
        t.addSection(s);
        Question q1 = new Question("How much is 2+2 ?");
        q1.addAnswer("3", false);
        q1.addAnswer("5", false);
        q1.addAnswer("4", true);
        Question q2 = new Question("You can suck my [thumb] .");
        s.addQuestion(q1);
        s.addQuestion(q2);
        System.out.print(t.toString());
        return t;
    }
}