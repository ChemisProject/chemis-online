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
public class ChemisLauncher extends JLabel {

    private static Dimension size = new Dimension(80, 90);
    private static MouseListener mouseListener = null;

    public ChemisLauncher() {
        super();
        setText("Launcher");
        setIcon(ChemisToolsModel.getInstance().getImage("/org/view/icons/chemis-icon.png"));
        initComponents();
    }

    public ChemisLauncher(String text) {
        super(text);
        setIcon(ChemisToolsModel.getInstance().getImage("/org/view/icons/chemis-icon.png"));
        initComponents();
    }

    public ChemisLauncher(String text, Icon icon) {
        super(text);
        initComponents();
        setIcon(icon);
    }

    private void initComponents() {
        setForeground(new Color(0xCD, 0xBF, 0xE3));
        setHorizontalAlignment(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        setVerticalAlignment(JLabel.CENTER);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        setBorder(BorderFactory.createEmptyBorder(10,0,5,0));
        

        if (mouseListener == null) {
            mouseListener=new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    ((ChemisLauncher) me.getSource()).setActive();
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    ((ChemisLauncher) me.getSource()).setHover();
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    ((ChemisLauncher) me.getSource()).setDefault();
                }
            };
        }

        addMouseListener(mouseListener);
    }
    
    protected void setDefault() {
        setOpaque(false);
        repaint();
    }

    protected void setActive() {
        setDefault();
        //#9A69E8
    }

    protected void setHover() {
        this.setOpaque(true);
        this.setBackground(new Color(0x7a,0x53,0xb8));
        repaint();
    }

    protected void setPressed(){
        
    }
    
    protected void setTarget() {
    }
}
