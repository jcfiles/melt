package backend;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class SectionTimer here.
 *
 * @author (your name)
 * @version (a version number or a date)  */ 
public class SectionTimer {
    
    private StudentTestController controller;
    private Timer timer;
    private Section section;

    public SectionTimer(StudentTestController controller, Section section, int seconds) {
        this.controller = controller;
        this.section = section;
        timer = new Timer();
        timer.schedule(new EndSection(), seconds*1000);
        //this.section = section;
	}

    class EndSection extends TimerTask {
        public void run() {
            controller.endSection(section);
            timer.cancel(); // kills the thread
        }
    }
}
