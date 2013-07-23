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
public class ConstantsDixon {

    public static final Map<String,Double> REPETITIONS_CONSTANTS;

    static {
        Map<String,Double> map = new HashMap<>();
        
        map.put("95_3",0.970);
        map.put("95_4",0.829);
        map.put("95_5",0.710);
        map.put("95_6",0.628);
        map.put("95_7",0.569);
        
        map.put("95_8",0.608);
        map.put("95_9",0.564);
        map.put("95_10",0.530);
        map.put("95_11",0.502);
        map.put("95_12",0.479);
        
        map.put("95_13",0.611);
        map.put("95_14",0.586);
        map.put("95_15",0.565);
        map.put("95_16",0.546);
        map.put("95_17",0.529);
        map.put("95_18",0.514);
        map.put("95_19",0.501);
        map.put("95_20",0.489);
        map.put("95_21",0.478);
        map.put("95_22",0.468);
        map.put("95_23",0.459);
        map.put("95_24",0.451);
        map.put("95_25",0.443);
        map.put("95_26",0.436);
        map.put("95_27",0.429);
        map.put("95_28",0.423);
        map.put("95_29",0.417);
        map.put("95_30",0.412);
        
        REPETITIONS_CONSTANTS = Collections.unmodifiableMap(map);
    }
}
