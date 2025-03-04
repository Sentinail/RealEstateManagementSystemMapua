/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class DashboardSideBarLogo extends JPanel {
    private ImageIcon logoIcon;

    public DashboardSideBarLogo() {
        setPreferredSize(new Dimension(200, 137)); // Panel size
        setOpaque(false); // Make the panel transparent
        setLayout(new GridBagLayout()); // Center the image
        
        this.setBorder(BorderFactory.createLineBorder(Theme.PRIMARY_BACKGROUND));
        

        // Load and scale the image
        logoIcon = new ImageIcon(new ImageIcon("src/assets/logo.png")
                .getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));

        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel);
    }
}
