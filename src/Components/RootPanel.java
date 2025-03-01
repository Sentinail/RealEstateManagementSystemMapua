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
    private CardLayout cardLayout;
    
    public RootPanel() {
        cardLayout = new CardLayout(); // Initialize CardLayout
        this.setLayout(cardLayout);

        // Set fixed size of 800x600
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));

        this.setBackground(Color.WHITE);
    }
    
    public void view(String panelName) {
        cardLayout.show(this, panelName);
    }
}
