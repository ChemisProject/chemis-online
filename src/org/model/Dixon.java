/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author guilherme
 */
public class Dixon {

    private ArrayList<Double> values = null; //list of values to test
    private ArrayList<Double> removed = null;
    
    public Dixon() {
        values=new ArrayList<>();
        removed=new ArrayList<>();
    }

    public Dixon(ArrayList<Double> values) {
        values=new ArrayList<>();
        removed=new ArrayList<>();
        this.values = values;
    }

    public void addValue(double value) {
        this.values.add(value);
    }

    public void removeValue(int index) {
        this.removed.add(values.get(index));
        this.values.remove(index);
    }

    public void removeValue(Double value) {
        this.removed.add(value);
        this.values.remove(value);
    }

    public Double getValue(int index) {
        return values.get(index);
    }

    public Double getFirstValue() {
        return values.get(0);
    }

    public void removeFisrtValue() {
        if (!values.isEmpty()) {
            removeValue(0);
        }
    }

    public Double getLastValue() {
        return values.get(values.size() - 1);
    }

    public void removeLastValue() {
        if (!values.isEmpty()) {
            removeValue(values.size() - 1);
        }
    }
    
    public ArrayList<Double> getValues(){
        return values;
    }
    
    public int getN(){
        return values.size();
    }
    
    public void clear(){
        values.clear();
    }
    
    public void addAll(Collection<Double> collection){
        values.addAll(collection);
    }
    
    public ArrayList<Double> getRemoved(){
        return removed;
    }
}
