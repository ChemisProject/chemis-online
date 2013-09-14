/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import org.view.components.ChemisSideBar;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.model.ChemisToolsModel;
import org.view.components.ChemisLauncher;

/**
 *
 * @author guilherme
 */
public class ChemisFrame extends javax.swing.JFrame {

    private CardLayout cardLayout=new CardLayout();
    private JPanel panelCentral=new JPanel();
    private ChemisSideBar chemisSideBar=new ChemisSideBar();
    private JDialog dialogAbout=null;
    private HashMap<String,JPanel> modules=new HashMap<>();
    private static Dimension rigidAreaDimension=new Dimension(0,8);
    /**
     * Creates new form ChemisFrame
     */
    public ChemisFrame() {
        
        initComponents();
        setTitle("Chemis");
        setSize(750,550);
        setLocationRelativeTo(null);
        setIconImage(ChemisToolsModel.getInstance().getImage("/org/view/icons/chemis-icon.png").getImage());
        
        panelCentral.setLayout(cardLayout);
        
        add(chemisSideBar);
        add(panelCentral);
        
        
        chemisSideBar.addLauncher(new ChemisLauncher("Dixon",ChemisToolsModel.getInstance().getImage("/org/view/icons/dixon-icon.png")));
        chemisSideBar.add(Box.createVerticalGlue());
        chemisSideBar.addLauncher(new ChemisLauncher("Help",ChemisToolsModel.getInstance().getImage("/org/view/icons/help-icon.png")));
        chemisSideBar.add(Box.createRigidArea(rigidAreaDimension));
        openModule(new DixonPanel(),"dixon");
    }
    
    /**
     * Open a JPanel in the component panelCentral.
     * This method also tests if the given module is already saved in cache, 
     * saving memory.
     * 
     * @param panel
     * @param name 
     */
    
    private void openModule(JPanel panel,String name){
        if(!modules.containsKey(name)){
            modules.put(name, panel);
            panelCentral.add(name,panel);
        }
        cardLayout.show(panelCentral,name);
    }

    /**Test if a JPanel of a Chemis' module is already in the cache,
     * returning <code>true</code> if the opened and <code>false</code> if 
     * not running yet.
     * 
     * @param name
     * @return 
     */
    private boolean isModuleOpen(String name){
        return modules.containsKey(name);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuAbout = new javax.swing.JMenu();
        menuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        menuAbout.setText("Help");

        menuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        menuAbout.add(menuItemAbout);

        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        if(dialogAbout==null){
            dialogAbout=new ChemisAboutDialog(this,true);
        }
        dialogAbout.setVisible(true);
    }//GEN-LAST:event_menuItemAboutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuItem menuItemAbout;
    // End of variables declaration//GEN-END:variables
}
