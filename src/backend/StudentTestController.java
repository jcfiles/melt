/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import student.FinishTestPanel;
import student.MainGui;

/**
 *
 * @author me
 */
public class StudentTestController {
    
    private Test_ test;
    
    public StudentTestController(Test_ test) {
        this.test = test;
    }

    public void endSection(Section section) {
        String sectionMarks = String.valueOf(section.gradeSection());
        FinishTestPanel finishpanel = new FinishTestPanel(sectionMarks);
        MainGui.setComposite(finishpanel);
    }
}