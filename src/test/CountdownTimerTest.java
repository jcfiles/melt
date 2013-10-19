package test;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Test;

import backend.CountdownTimer;

public class CountdownTimerTest {

	@Test(timeout=61000)
	public void testRun61000() {
		CountdownTimer countdownTimer = new CountdownTimer (1, new JLabel() );
		countdownTimer.run();
	}

	@Test
	public void testStops() {
		CountdownTimer countdownTimer = new CountdownTimer (1, new JLabel() );
		countdownTimer.run();
		countdownTimer.stops();
	}

}
