package backend;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class TestTimer here.
 *
 * @author (your name)
 * @version (a version number or a date)  */ 
public class TestTimer {
    
    Timer timer;
    Test_ t;

    public TestTimer(Test_ t, int seconds) {
        timer = new Timer();
        timer.schedule(new EndTest(), seconds*1000);
        this.t = t;
	}

    class EndTest extends TimerTask {
        public void run() {
            t.endTest(); // REPLACE THIS WITH: t.endTest();
            timer.cancel(); // kills the thread
        }
    }
}
