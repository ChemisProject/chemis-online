/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class Dixon {
    
    private ArrayList<Double> values=null; //list of values to test
    
    public Dixon(){
    }
    
    public Dixon(ArrayList<Double> values){
        this.values=values;
    }
    
    public void addValue(double value){
        this.values.add(value);
    }
    
    public void removeValue(int index){
        this.values.remove(index);
    }
    
    public void removeValue(Double value){
        this.values.remove(value);
    }
}
