/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sentinail
 */
public class RegisterBannerLogo extends JPanel { // Branding
    private ImageIcon logoIcon;

    public RegisterBannerLogo() {
        setPreferredSize(new Dimension(300, 300));
        setOpaque(false);
        setLayout(new GridBagLayout());

        logoIcon = new ImageIcon(new ImageIcon("src/assets/logo.png")
                .getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));

        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 0, 0));
    }
}
