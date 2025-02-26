/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Louis
 */
import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    private ImageIcon logoIcon;
    
    public LogoPanel() {
        setPreferredSize(new Dimension(400, 600));
        setBackground(new Color(254, 244, 234)); // Beige background
        setLayout(new FlowLayout(FlowLayout.LEFT, -50, 50)); // Moves it left slightly

        // Load the image (Make sure it's in src/assets/logo.png)
        logoIcon = new ImageIcon("src/assets/logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        
        // Add the logo with better left alignment
        add(logoLabel);
    }
}