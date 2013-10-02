package backend;


/**
 * Write a description of class testingTheTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testingTheTimer
{
    static volatile boolean count=true;
    public static void main (String [] args)
    {
        
        
            new Thread(){
            public void run(){
                int seconds = 30;
                while(count){
                    seconds--;
                    System.out.println(seconds);
                    try{
                        sleep(1000);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    if(seconds==0){
                        count=false;
                    }
                }
            }
        }.start();
    }
}
