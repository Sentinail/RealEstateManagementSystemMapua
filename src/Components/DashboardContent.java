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
public class DashboardContent extends JPanel {
    private CardLayout cardLayout;
    
    public DashboardContent() {
        cardLayout = new CardLayout(); 
        this.setLayout(cardLayout);

        // Set fixed size of 800x600
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setMaximumSize(new Dimension(600, 600));

        this.setBackground(Color.WHITE);
    }
    
    public void view(String panelName) {
        cardLayout.show(this, panelName);
    }
}