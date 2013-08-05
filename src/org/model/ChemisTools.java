/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author guilherme
 */
public class ChemisTools {
    
    private static ChemisTools instance;
    private HashMap<String, ImageIcon> images;
    
    private ChemisTools(){
        images=new HashMap<>();
    }
    
    public static ChemisTools getInstance(){
        if(instance==null){
            instance=new ChemisTools();
        }
        return instance;
    }
    
    public ImageIcon getImage(String url){
        if(images.containsKey(url)){
            return images.get(url);
        }else{
            images.put(url,new ImageIcon(getClass().getResource(url)));
            return images.get(url);
        }
    }
}
