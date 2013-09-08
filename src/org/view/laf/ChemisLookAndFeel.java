/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view.laf;

import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.Region;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthPainter;

/**
 *
 * @author guilherme
 */
public class ChemisLookAndFeel {
    
    private SynthLookAndFeel synthChemis=null;
    private static ChemisLookAndFeel instance=null;
    
    private ChemisLookAndFeel(){
    }
    
    public static ChemisLookAndFeel getInstance(){
        if(instance==null){
            instance=new ChemisLookAndFeel();
        }
        return instance;
    }
    
    public void loadAndSetLookAndFeel() throws ParseException, UnsupportedLookAndFeelException{
        if(synthChemis==null){
            synthChemis=new SynthLookAndFeel();
        }
        synthChemis.load(ChemisLookAndFeel.class.getResourceAsStream("synthChemisLaf.xml"),ChemisLookAndFeel.class);
        UIManager.setLookAndFeel(synthChemis);
        
    }
}
