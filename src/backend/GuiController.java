/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.event.*;
import student.MainGui;

    
    /**
 *
 * @author me
 */
public class GuiController implements ActionListener {
 
    private MainGui gui;
    /**
     * Constructor for GuiController
     */
    public GuiController (MainGui gui) {
        this.gui = gui;
        }

    /**
     * Handle the events from the function buttons.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        if(cmd.equals("Start")) {
            Test_ t = new Test_("", "", 5);
            t.main(null);
        }
    }

}