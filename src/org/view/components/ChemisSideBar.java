/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view.components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;

/**
 *
 * @author guilherme
 */
public class ChemisSideBar extends javax.swing.JPanel {

    private BoxLayout layoutBox;
    private static Dimension rigidAreaDimension=new Dimension(0,8);
    /**
     * Creates new form ChemisSideBar
     */
    public ChemisSideBar() {
        initComponents();
        layoutBox=new BoxLayout(this,BoxLayout.PAGE_AXIS);
        setLayout(layoutBox);
        //#563d7c
        //#291C3E
        setBorder(new MatteBorder(0,0,0,1,new Color(0x29,0x1c,0x3e)));
    }

    public void addLauncher(ChemisLauncher chemisLauncher){
        add(Box.createRigidArea(rigidAreaDimension));
        add(chemisLauncher);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(86, 61, 124));
        setForeground(new java.awt.Color(254, 254, 254));
        setMaximumSize(new java.awt.Dimension(80, 32767));
        setMinimumSize(new java.awt.Dimension(80, 240));
        setPreferredSize(new java.awt.Dimension(80, 300));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
