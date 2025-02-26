/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import javax.swing.*;
import java.awt.*;
import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class Register extends JPanel {
    
     public Register() {
        this.setLayout(new FlowLayout());
        this.setBackground(Theme.BACKGROUND);
        
        // Set fixed size of 800x600
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
    }
}
