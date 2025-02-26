/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Sentinail
 */
public class RootPanel extends JPanel {
    
    public RootPanel() {
        // Set layout (CardLayout allows component swapping)
        this.setLayout(new CardLayout());

        // Set fixed size of 800x600
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));

        // Optional: Set background color
        this.setBackground(Color.WHITE);
    }
}
