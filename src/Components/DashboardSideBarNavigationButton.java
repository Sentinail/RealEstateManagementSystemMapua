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

public class DashboardSideBarNavigationButton extends JButton {
    
    // Default constructor for Matisse support
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
