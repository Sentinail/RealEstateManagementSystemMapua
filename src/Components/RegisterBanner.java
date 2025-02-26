/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.*;
import java.awt.*;
import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class RegisterBanner extends JPanel {
    
    public RegisterBanner() {
        // Set layout (CardLayout allows component swapping)
        this.setLayout(new FlowLayout());

        // Set fixed size of 800x600
        this.setPreferredSize(new Dimension(400, 600));
        this.setMinimumSize(new Dimension(400, 600));
        this.setMaximumSize(new Dimension(400, 600));

        // Optional: Set background color
        this.setBackground(Theme.SECONDARY_BACKGROUND);
    }
}
