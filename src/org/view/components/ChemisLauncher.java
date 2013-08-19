/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import org.model.ChemisToolsModel;

/**
 *
 * @author guilherme
 */
public class ChemisLauncher extends JLabel{
    
    private static Dimension size=new Dimension(80,86);
    
    public ChemisLauncher(){
        super();
        setText("Launcher");
        setIcon(ChemisToolsModel.getInstance().getImage("/org/view/icons/chemis-icon.png"));
        initComponents();
    }
    
    public ChemisLauncher(String text){
        super(text);
        setIcon(ChemisToolsModel.getInstance().getImage("/org/view/icons/chemis-icon.png"));
        initComponents();
    }
    
    public ChemisLauncher(String text, Icon icon){
        super(text);
        initComponents();
        setIcon(icon);
    }
    
    private void initComponents(){
        setHorizontalAlignment(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        setVerticalAlignment(JLabel.CENTER);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {}

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {
                setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });
    }
    
    public void setTarget(){
        
    }
    
    
}
