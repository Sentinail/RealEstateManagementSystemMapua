/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */

public class DashboardSideBarNavigationButton extends JButton { // Menu
    
    public DashboardSideBarNavigationButton() {
        this.setText("Navigation");
        setPreferredSize(new Dimension(160, 20));
        setBackground(Theme.PRIMARY_BACKGROUND);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    public DashboardSideBarNavigationButton(String label) {
        this.setText(label);
        setPreferredSize(new Dimension(160, 20));
        setBackground(Theme.PRIMARY_BACKGROUND);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
    }
}
