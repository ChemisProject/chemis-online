/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.control;

import java.text.DecimalFormat;
import org.model.ConstantsDixon;

/**
 *
 * @author guilherme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println("Chemis Initialized: Nothing to run yet...");

        for (int i = 3; i < 30; i++) {
            for (int j = 0; j < 1000; j++) {
                System.out.println("95%: #" + i + "- " + ConstantsDixon.REPETITIONS_CONSTANTS.get("95_" + i));
                System.out.println("99%: #" + i + "- " + ConstantsDixon.REPETITIONS_CONSTANTS.get("99_" + i));
            }
        }

    }
}
