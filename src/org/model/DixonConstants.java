/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author guilherme
 */
public class DixonConstants {

    /*Key= percentage_n */
    public static final Map<String, Double> REPETITIONS_CONSTANTS;

    static {
        Map<String, Double> map = new HashMap<>();
        
        //95% constants
        map.put("95_3", 0.970);
        map.put("95_4", 0.829);
        map.put("95_5", 0.710);
        map.put("95_6", 0.628);
        map.put("95_7", 0.569);

        map.put("95_8", 0.608);
        map.put("95_9", 0.564);
        map.put("95_10", 0.530);
        map.put("95_11", 0.502);
        map.put("95_12", 0.479);

        map.put("95_13", 0.611);
        map.put("95_14", 0.586);
        map.put("95_15", 0.565);
        map.put("95_16", 0.546);
        map.put("95_17", 0.529);
        map.put("95_18", 0.514);
        map.put("95_19", 0.501);
        map.put("95_20", 0.489);
        map.put("95_21", 0.478);
        map.put("95_22", 0.468);
        map.put("95_23", 0.459);
        map.put("95_24", 0.451);
        map.put("95_25", 0.443);
        map.put("95_26", 0.436);
        map.put("95_27", 0.429);
        map.put("95_28", 0.423);
        map.put("95_29", 0.417);
        map.put("95_30", 0.412);

        //99% constants
        map.put("99_3", 0.994);
        map.put("99_4", 0.926);
        map.put("99_5", 0.821);
        map.put("99_6", 0.740);
        map.put("99_7", 0.608);

        map.put("99_8", 0.717);
        map.put("99_9", 0.672);
        map.put("99_10", 0.635);
        map.put("99_11", 0.605);
        map.put("99_12", 0.579);
        
        map.put("99_13", 0.697);
        map.put("99_14", 0.670);
        map.put("99_15", 0.647);
        map.put("99_16", 0.627);
        map.put("99_17", 0.610);
        map.put("99_18", 0.594);
        map.put("99_19", 0.580);
        map.put("99_20", 0.567);
        map.put("99_21", 0.555);
        map.put("99_22", 0.544);
        map.put("99_23", 0.535);
        map.put("99_24", 0.526);
        map.put("99_25", 0.517);
        map.put("99_26", 0.510);
        map.put("99_27", 0.502);
        map.put("99_28", 0.495);
        map.put("99_29", 0.489);
        map.put("99_30", 0.483);
        
       REPETITIONS_CONSTANTS = Collections.unmodifiableMap(map);
    }
}
