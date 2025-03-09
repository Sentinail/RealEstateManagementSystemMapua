/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class DashboardSideBarLogo extends JPanel { // Branding
    private ImageIcon logoIcon;

    public DashboardSideBarLogo() {
        setPreferredSize(new Dimension(200, 137));
        setOpaque(false);
        setLayout(new GridBagLayout());
        
        this.setBorder(BorderFactory.createLineBorder(new Theme().getPrimaryBackground()));
        

        logoIcon = new ImageIcon(new ImageIcon("src/assets/logo.png")
                .getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));

        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel);
    }
}
