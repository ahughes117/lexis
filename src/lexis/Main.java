/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lexis;

import gui.MainFrame;

/**
 *
 * @author Alex Hughes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //optionally setting look and feel...
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        RL util = new RL("123456!@#$%^QWERTASDFGZXCVBqwertasdfgzxcvb", 
                "7890-=&*()_+YUIOP{}HJKL:\"|NM<>?yuiop[]hjkl;'\nm,./");
        
        util.rateInput(util.cleanChars("my name i1s al23e23x/ hughes and i am proud of myself for developing nonsense"));
        util.printResults();
        
        new MainFrame();
    }
}
