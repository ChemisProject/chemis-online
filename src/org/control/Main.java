/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.control;

import java.util.logging.Logger;
import javax.swing.UIManager;
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
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger("general_log").addHandler(ChemisToolsModel.getInstance().getLogFileHandler());
            Logger.getLogger("general_log").info(ChemisToolsModel.getInstance().exceptionToString(ex));
            try {
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex1) {
                Logger.getLogger("general_log").addHandler(ChemisToolsModel.getInstance().getLogFileHandler());
                Logger.getLogger("general_log").info(ChemisToolsModel.getInstance().exceptionToString(ex));
                System.out.println(ex1.getMessage() + "\nAre you using Mac?");

            }
        }

        try {
            ChemisFrame cf = new ChemisFrame();
            cf.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger("general_log").addHandler(ChemisToolsModel.getInstance().getLogFileHandler());
            Logger.getLogger("general_log").info(ChemisToolsModel.getInstance().exceptionToString(ex));
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
         dixon.addValue(0.1152);
         dixon.addValue(0.1158);
         dixon.addValue(0.1158);
         dixon.addValue(0.1166);
         dixon.addValue(0.1172);
         dixon.addValue(0.1173);
         dixon.addValue(0.1174);
         dixon.addValue(0.1188);
         dixon.addValue(0.1227);



         try {
         Double[] results = DixonControl.getInstance().calc(dixon, 99);
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
