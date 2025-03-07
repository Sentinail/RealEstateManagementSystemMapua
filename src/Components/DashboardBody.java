/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class DashboardBody extends JPanel { // Content
    private CardLayout cardLayout;
    
    public DashboardBody() {
        cardLayout = new CardLayout(); 
        this.setLayout(cardLayout);

        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setMaximumSize(new Dimension(600, 600));

        this.setBackground(Theme.BACKGROUND);
    }
    
    public void view(String panelName) {
        cardLayout.show(this, panelName);
    }
}