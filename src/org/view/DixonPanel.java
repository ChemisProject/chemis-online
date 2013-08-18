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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author guilherme
 */
public class DixonPanel extends javax.swing.JPanel {

    private GridBagConstraints gbc;
    private BoxLayout boxLayoutPanelValues;
    private FlowLayout flowLayoutBottomPanel;
    private JPanel panelBottom,panelValues,panelResults;
    
    //default dimensions of components
    private Dimension dimensionField=new Dimension(200,30);
    private Dimension dimensionDeleteButton=new Dimension(30,30);
    private Dimension maxDimensionRowPanel=new Dimension(500,36);
    
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
        JPanel rowPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,2));
        JTextField field=new JTextField("0.00");
        JButton button=new JButton("-");
        button.setPreferredSize(dimensionDeleteButton);
        
        rowPanel.setMaximumSize(maxDimensionRowPanel);
        rowPanel.setBackground(Color.CYAN);
        
        field.setPreferredSize(dimensionField);
        fields.add(field);
        
        rowPanel.add(fields.get(fields.size()-1));
        rowPanel.add(button);
        panelValues.add(rowPanel);
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
        //panelBottom.setBackground(Color.red);
        
        panelValues =new JPanel();
        boxLayoutPanelValues = new BoxLayout(panelValues, BoxLayout.Y_AXIS);
        panelValues.setLayout(boxLayoutPanelValues);
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
        
        //init components panelValues
        createField();
        createField();
        createField();
    }
}