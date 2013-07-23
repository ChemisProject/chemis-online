/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.control;

import java.util.ArrayList;
import java.util.Collections;
import org.model.Dixon;
import org.model.DixonConstants;
import org.model.DixonException;

/**
 *
 * @author guilherme
 */
public class DixonControl {

    private static DixonControl instance = null;

    private DixonControl() {
    }

    /**
     * Method to return a singleton object of this class
     *
     * @return ControlDixon
     */
    public static DixonControl getInstance() {
        if (instance == null) {
            instance = new DixonControl();
        }

        return instance;
    }

    public void calc(Dixon dixon, boolean sortValues) throws DixonException {
        //sort list of values
        if (sortValues) {
            sortValues(dixon.getValues());
        }

        //initialize results
        double lowerEnd = 0;
        double upperEnd = 0;

        //test and find the proper equation to use
        if (dixon.getN() < 3) {
            throw new DixonException("'n' is less than 3");
        } else if (dixon.getN() >= 3 && dixon.getN() <= 7) {
            lowerEnd = getLowerEnd3_7(dixon.getValues());
            upperEnd = getUpperEnd3_7(dixon.getValues());
        } else if (dixon.getN() >= 8 && dixon.getN() <= 12) {
            lowerEnd = getLowerEnd8_12(dixon.getValues());
            upperEnd = getUpperEnd8_12(dixon.getValues());
        } else if (dixon.getN()>=13){
            lowerEnd=getLowerEnd13(dixon.getValues());
            upperEnd=getUpperEnd13(dixon.getValues());
        }
        
        
    }

    //continuar aqui! Resolver lógica aprovação
    private boolean approved(double value,int percent){
        return (value== DixonConstants.REPETITIONS_CONSTANTS.get(""));
    }
    
    public void sortValues(ArrayList<Double> values) {
        Collections.sort(values);
    }

    //lower end functions
    private double getLowerEnd3_7(ArrayList<Double> values) {
        return (values.get(1) - values.get(0)) / (values.get(values.size() - 1) - values.get(0));
    }

    private double getLowerEnd8_12(ArrayList<Double> values) {
        return (values.get(1) - values.get(0)) / (values.get(values.size() - 2) - values.get(0));
    }

    private double getLowerEnd13(ArrayList<Double> values) {
        return (values.get(2) - values.get(0)) / (values.get(values.size() - 3) - values.get(0));
    }

    //Upper end functions
    private double getUpperEnd3_7(ArrayList<Double> values) {
        return (values.get(values.size() - 1) - values.get(values.size() - 2)) / (values.get(values.size() - 1) - values.get(0));
    }

    private double getUpperEnd8_12(ArrayList<Double> values) {
        return (values.get(values.size() - 1) - values.get(values.size() - 2)) / (values.get(values.size() - 1) - values.get(1));
    }

    private double getUpperEnd13(ArrayList<Double> values) {
        return (values.get(values.size() - 1) - values.get(values.size() - 3)) / (values.get(values.size() - 1) - values.get(2));
    }
}
