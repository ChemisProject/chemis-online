/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.control.ChemisToolsControl;
import org.control.DixonControl;
import org.model.ChemisToolsModel;
import org.model.Dixon;
import org.model.DixonException;

/**
 *
 * @author guilherme
 */
public class DixonPanel extends javax.swing.JPanel {

    //layouts
    private GridBagConstraints gbc;
    
    private FlowLayout flowLayoutBottomPanel;
    //default dimensions of components
    private Dimension dimensionField = new Dimension(200, 30);
    private Dimension dimensionDeleteButton = new Dimension(36, 30);
    private Dimension maxDimensionRowPanel = new Dimension(500, 36);
    private Insets insets = new Insets(0, 3, 0, 3);
    //containers
    private JButton buttonCalc, buttonClear, buttonAdd;
    private JPanel panelBottom;
    private DixonResultPanel resultPanel95, resultPanel99;
    private Box boxValues, boxResults;
    private JScrollPane scrollPaneValues, scrollPaneResults;
    //listeners
    private ActionListener genericActionListener;
    private FocusListener genericFocusListener;
    
    //arrays
    private static ArrayList<JTextField> fields = new ArrayList<>();

    public DixonPanel() {
        initListeners();
        initComponents();

    }

    private void createField() {
        JTextField field = new JTextField("0.0000");
        field.setName("fieldValue");
        field.setPreferredSize(dimensionField);
        field.setMargin(insets);
        field.addFocusListener(genericFocusListener);
        
        fields.add(field);

        JButton buttonDelete = new JButton("-");
        buttonDelete.setName("buttonDelete");
        buttonDelete.setMargin(new Insets(0,0,0,0));
        buttonDelete.setPreferredSize(dimensionDeleteButton);
        buttonDelete.addActionListener(genericActionListener);

        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        rowPanel.setPreferredSize(new Dimension(100, 36));
        rowPanel.setMaximumSize(maxDimensionRowPanel);
        //rowPanel.setBackground(Color.CYAN);
        rowPanel.setName("rowPanel");

        rowPanel.add(field);
        rowPanel.add(buttonDelete);
        boxValues.add(rowPanel);
        boxValues.revalidate();
        boxValues.repaint();
        System.out.println(ChemisToolsControl.getUsedMemory(ChemisToolsControl.MB) + "MB");
    }

    private void removeRow(Component rowPanel) {
        int rowIndex = 0;
        Container parentContainer = rowPanel.getParent();

        for (Component c : parentContainer.getComponents()) {
            if (c.getName().equals("rowPanel")) {
                if (c.equals(rowPanel)) {
                    fields.remove(rowIndex);
                    break;
                }
                rowIndex++;
            }
        }
        parentContainer.remove(rowPanel);
        parentContainer.revalidate();
        boxValues.repaint();
    }

    private ArrayList<Double> getValues() throws NumberFormatException {
        ArrayList<Double> values = new ArrayList<>();
        for (JTextField field : fields) {
            values.add(Double.parseDouble(field.getText()));
        }
        return values;
    }

    private void calcAndShowResult(int percentage) {
        Dixon dixon = new Dixon(getValues());
        Double[] result={0.0,0.0};
        boolean approved = true;
        
        try {
            result = DixonControl.getInstance().calc(dixon, 95);

        } catch (DixonException e) {
            System.out.println(e.getMessage());
            approved = false;
        } catch (Exception ex) {
            Logger.getLogger("DixonPanel").addHandler(ChemisToolsModel.getInstance().getLogFileHandler());
            Logger.getLogger("DixonPanel").info(ChemisToolsModel.getInstance().exceptionToString(ex));
        }


        switch (percentage) {
            case 95: {
                resultPanel95.setAll(approved,result[0],result[1],dixon.getN(),dixon.getRemoved());
                break;
            }
            case 99: {
                resultPanel99.setAll(approved,result[0],result[1],dixon.getN(),dixon.getRemoved());
                break;
            }
            default: {
                System.out.println("Invalid percentage!");
            }
        }


    }

    private void buttonDeleteActionListener(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (fields.size() > 3) {
            removeRow(button.getParent());
        } else {
            System.out.println("Minimo 3 linhas");
        }
    }

    private void buttonClearActionListener(ActionEvent e) {
        for (JTextField field : fields) {
            field.setText("0.00");
        }
    }

    private void buttonCalcActionListener(ActionEvent e) {
        calcAndShowResult(95);
        calcAndShowResult(99);
    }

    private void buttonAddFieldActionListener(ActionEvent e) {
        createField();
    }
    
    private void fieldValueKeyListener(KeyEvent e){
        JTextField field=(JTextField) e.getSource();
        
        int index=fields.indexOf(field);
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:{
                if(index>0){
                    fields.get(index-1).requestFocus();
                }
                break;
            }
            case KeyEvent.VK_DOWN:{
                if(index<fields.size()-1){
                    fields.get(index+1).requestFocus();
                }
                break;
            }
        }
    }

    private void fieldSelectAllFocusListener(FocusEvent e) {
        JTextField field = (JTextField) e.getSource();
        field.selectAll();
    }

    private void initComponents() {

        //init layouts
        flowLayoutBottomPanel = new FlowLayout(FlowLayout.LEFT, 5,3);
        gbc = new GridBagConstraints();

        //init panels
        panelBottom = new JPanel(flowLayoutBottomPanel);
        panelBottom.setMinimumSize(new Dimension(200, 40));
        panelBottom.setPreferredSize(new Dimension(200, 40));

        boxValues = new Box(BoxLayout.Y_AXIS);

        scrollPaneValues = new JScrollPane(boxValues);
        scrollPaneValues.getViewport().setBackground(Color.decode("" + getBackground().getRGB()));

        scrollPaneValues.getVerticalScrollBar().setUnitIncrement(20);
        scrollPaneValues.setMaximumSize(new Dimension(200,1000));
        scrollPaneValues.getHorizontalScrollBar().setUnitIncrement(20);

        boxResults = new Box(BoxLayout.Y_AXIS);

        scrollPaneResults = new JScrollPane(boxResults);
        scrollPaneResults.getViewport().setBackground(Color.decode("" + getBackground().getRGB()));
        scrollPaneResults.setPreferredSize(new Dimension(200,300));
        scrollPaneResults.getVerticalScrollBar().setUnitIncrement(20);
        scrollPaneResults.getHorizontalScrollBar().setUnitIncrement(20);


        resultPanel95 = new DixonResultPanel();
        resultPanel95.setBorder(BorderFactory.createTitledBorder("Test 95%"));

        resultPanel99 = new DixonResultPanel();
        resultPanel99.setBorder(BorderFactory.createTitledBorder("Test 99%"));

        //init panel
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(400, 400));

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 0.5;
        add(scrollPaneValues, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(scrollPaneResults, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridheight = 40;
        gbc.gridwidth = 2;
        add(panelBottom, gbc);

        //init panel bottom
        buttonCalc = new JButton("Calculate");
        buttonCalc.setName("buttonCalc");
        buttonCalc.setMargin(insets);
        buttonCalc.setPreferredSize(new Dimension(100,30));
        buttonCalc.addActionListener(genericActionListener);

        buttonClear = new JButton("Clear all");
        buttonClear.setName("buttonClear");
        buttonClear.setMargin(insets);
        buttonClear.setPreferredSize(new Dimension(100,30));
        
        buttonClear.addActionListener(genericActionListener);

        buttonAdd = new JButton("Add field");
        buttonAdd.setName("buttonAdd");
        buttonAdd.setMargin(insets);
        buttonAdd.setPreferredSize(new Dimension(100,30));
        buttonAdd.addActionListener(genericActionListener);
        

        panelBottom.add(buttonCalc);
        panelBottom.add(buttonClear);

        //init components panelValues
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        rowPanel.setMaximumSize(maxDimensionRowPanel);
        rowPanel.setName("rowPanelFunctions");

        rowPanel.add(buttonAdd);
        boxValues.add(rowPanel);

        //create minimum number of fields 
        createField();
        createField();
        createField();

        //init components panelResults

        boxResults.add(resultPanel95);
        boxResults.add(resultPanel99);
    }

    private void initListeners() {
        genericActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();

                if (component.getName().equals("buttonDelete")) {
                    buttonDeleteActionListener(e);
                } else if (component.getName().equals("buttonClear")) {
                    buttonClearActionListener(e);
                } else if (component.getName().equals("buttonCalc")) {
                    buttonCalcActionListener(e);
                } else if (component.getName().equals("buttonAdd")) {
                    buttonAddFieldActionListener(e);
                }
            }
        };

        genericFocusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Component component = (Component) e.getSource();

                if (component.getName().equals("fieldValue")) {
                    fieldSelectAllFocusListener(e);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        };
        
    }
}