/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.control;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.model.ChemisToolsModel;
import org.view.ChemisFrame;

/**
 *
 * @author guilherme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new GTKLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Windows user... :( hahaha");
            try {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex1) {
                System.out.println(ex1.getMessage() + "\nAre you using Mac?");

            }
        }

        try {
            ChemisFrame cf = new ChemisFrame();
            cf.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger("general_log").addHandler(ChemisToolsModel.getInstance().getLogFileHandler());
            Logger.getLogger("general_log").info(ex.getMessage());
        }
        /*
         DecimalFormat df = new DecimalFormat("####0.0000");
         NumberFormat nf = NumberFormat.getInstance();
         nf.setMaximumFractionDigits(4);
         nf.setMinimumFractionDigits(4);

         Dixon dixon = new Dixon();

         dixon.addValue(0.1128);
         dixon.addValue(0.1145);
         dixon.addValue(0.1152);
         //dixon.addValue(0.1152);
         dixon.addValue(0.1158);
         dixon.addValue(0.1158);
         dixon.addValue(0.1166);
         dixon.addValue(0.1172);
         dixon.addValue(0.1173);
         dixon.addValue(0.1174);
         dixon.addValue(0.1188);
         dixon.addValue(0.1227);



         try {
         Double[] results = DixonControl.getInstance().calc(dixon, 95);
         System.out.println("EI: " + df.format(results[0]) + "\nES: " + df.format(results[1]) + "\nN: " + dixon.getN());

         System.out.println("Removidos: ");
         for (Double d : dixon.getRemoved()) {
         System.out.println(nf.format(d));
         }
         } catch (DixonException ex) {
         System.out.println(ex.getMessage());
         }
         */
    }
}
