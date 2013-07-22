/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.control;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author guilherme
 */
public class ControlDixon {
    
    private static ControlDixon instance=null;
    
    private ControlDixon(){
    }
    
    /**Method to return a singleton object of this class
     * 
     * @return ControlDixon
     */
    public static ControlDixon getInstance(){
        if(instance==null){
            instance=new ControlDixon();
        }
        
        return instance;
    }
    
    
    public void sortValues(ArrayList<Double> values){
        Collections.sort(values);
    }
    
    private double getLowerEnd3_7(ArrayList<Double> values){
        return (values.get(1)-values.get(0))/(values.get(values.size()-1)-values.get(0));
    }
    
    private double getLowerEnd8_12(ArrayList<Double> values){
        return (values.get(1)-values.get(0))/(values.get(values.size()-2)-values.get(0));
    }
    
    private double getLowerEnd13(ArrayList<Double> values){
        return (values.get(2)-values.get(0))/(values.get(values.size()-3)-values.get(0));
    }
    
    //change formules...
    private double getUpperEnd3_7(ArrayList<Double> values){
        return (values.get(2)-values.get(0))/(values.get(values.size()-3)-values.get(0));
    }
    
    private double getUpperEnd8_12(ArrayList<Double> values){
        return (values.get(2)-values.get(0))/(values.get(values.size()-3)-values.get(0));
    }
    
    private double getUpperEnd13(ArrayList<Double> values){
        return (values.get(2)-values.get(0))/(values.get(values.size()-3)-values.get(0));
    }
}
