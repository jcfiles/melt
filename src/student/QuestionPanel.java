/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import javax.swing.JPanel;

/**
 *
 * @author Bruce Steedman
 */
public abstract class QuestionPanel extends JPanel {
    
    public abstract void submitAnswer();
    public abstract boolean isAnswered();
    public abstract void setPath(String path);
    
    /**
     * Sets the question number of the question.
     * @param int questionNumber
     */
    public abstract void setQuestionNumber(int questionNumber);
    
}