/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iwander;

import iwander.Database.Connect;
import iwander.View.MainUI;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author AnDylek
 */
public class Iwander {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> {
            MainUI mainUI = new MainUI();
            mainUI.setVisible(true);
        });
    }
    
}
