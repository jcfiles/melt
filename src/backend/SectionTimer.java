package backend;

import java.util.Timer;
import java.util.TimerTask;
import student.TestSectionPanel;

/**
 * Write a description of class SectionTimer here.
 *
 * @author (your name)
 * @version (a version number or a date)  */ 
public class SectionTimer {
    
    private StudentTestController controller;
    private Timer timer;
    private TestSectionPanel testSectionPanel;
    

    public SectionTimer(StudentTestController controller, TestSectionPanel testSectionPanel, int seconds) {
        this.controller = controller;
        this.testSectionPanel = testSectionPanel;
        timer = new Timer();
        timer.schedule(new EndSection(), seconds*1000);
	}

    class EndSection extends TimerTask {
        public void run() {
            controller.endSection(testSectionPanel);
            timer.cancel(); // kills the thread
        }
    }
}
