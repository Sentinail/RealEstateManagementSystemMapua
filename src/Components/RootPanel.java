/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 *
 * @author Sentinail
 */
public class RootPanel extends JPanel { // Container
    private CardLayout cardLayout;
    
    public RootPanel() {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));

        this.setBackground(Color.WHITE);
    }
    
    public void view(String panelName) {
        cardLayout.show(this, panelName);
    }
}
