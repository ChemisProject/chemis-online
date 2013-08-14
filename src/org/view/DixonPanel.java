/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author guilherme
 */
public class DixonPanel extends javax.swing.JPanel {

    private GridBagConstraints gbc;
    private BoxLayout boxLayoutPanelValues;
    private GroupLayout groupLayoutPanelValues;
    private FlowLayout flowLayoutBottomPanel;
    private JPanel panelBottom,panelValues,panelResults;
    private static ArrayList<JTextField> fields = new ArrayList<>();
    
    private JButton buttomCalc,buttomClear;
    private Insets insetsButtons=new Insets(0,5,0,5);
    /**
     * Creates new form DixonPanel
     */
    public DixonPanel() {
        initComponents();
    }

    private void createField() {

        add("valueField" + 1, new TextField("0.00"));
    }

    private void removeField(int index) {
    }

    private void initComponents() {
        //init layouts
        flowLayoutBottomPanel = new FlowLayout(FlowLayout.LEFT, 5, 5);
        gbc=new GridBagConstraints();
        
        //init panels
        panelBottom = new JPanel(flowLayoutBottomPanel);
        panelBottom.setMinimumSize(new Dimension(400,40));
        panelBottom.setPreferredSize(new Dimension(400,40));
        panelBottom.setBackground(Color.red);
        
        panelValues =new JPanel(boxLayoutPanelValues);
        boxLayoutPanelValues = new BoxLayout(panelValues, BoxLayout.PAGE_AXIS);
        panelValues.setPreferredSize(new Dimension(300,400));
        panelValues.setBackground(Color.GREEN);
        
        panelResults=new JPanel();
        panelResults.setPreferredSize(new Dimension(300,400));
        panelResults.setBackground(Color.BLUE);
        
        //init panel
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(400,400));
        
        gbc.fill=GridBagConstraints.BOTH;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1.0;
        gbc.weighty=0.5;
        add(panelValues,gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx=1.0;
        gbc.weighty=0.5;
        add(panelResults,gbc);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.gridheight=40;
        gbc.gridwidth=2;
        add(panelBottom,gbc);
        
        //init panel bottom
        buttomCalc=new JButton("Calc");
        buttomCalc.setMargin(insetsButtons);
        buttomClear=new JButton("Clear fields");
        buttomClear.setMargin(insetsButtons);
        panelBottom.add(buttomCalc);
        panelBottom.add(buttomClear);
        
    }
}