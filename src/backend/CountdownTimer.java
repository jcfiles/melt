package backend;

import javax.swing.JLabel;

/**
 * @author Chondrokoukis Dimitrios
 */
public class CountdownTimer extends Thread{
	private int minutes;
	private volatile boolean isFinished;
	private volatile JLabel jLabel;
	
	public CountdownTimer(int minutes, JLabel jLabel){
		this.minutes = minutes;
		this.isFinished = false;
		this.jLabel = jLabel;
	}
	
	public void run(){
		while((!isFinished)&&(jLabel.isDisplayable())){
			jLabel.setText(Integer.toString(minutes));
			try {
				sleep(1000*60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(minutes==0){
				stops();
			}
			minutes--;
		}
		stops();
	}
	
	public void stops(){
		this.isFinished = true;
	}
}

