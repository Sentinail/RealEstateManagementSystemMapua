/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Louis
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoPanel extends JPanel { // Branding
    private ImageIcon logoIcon;
    
    public LogoPanel() {
        setPreferredSize(new Dimension(400, 600));
        setBackground(new Color(254, 244, 234));
        setLayout(new FlowLayout(FlowLayout.LEFT, -50, 50));

        logoIcon = new ImageIcon("src/assets/logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        
        add(logoLabel);
    }
}