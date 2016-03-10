/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author jamesashford
 */
public class HumidityComponent extends JComponent {
    private int percentage;
    
    public HumidityComponent(int percentage) {
        this.percentage = percentage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawLine(0, 0, 20, 20);
    }
    
}
