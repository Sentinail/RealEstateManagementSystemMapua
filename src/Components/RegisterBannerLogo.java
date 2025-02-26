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
public class RegisterBannerLogo extends JPanel {
    private ImageIcon logoIcon;

    public RegisterBannerLogo() {
        setPreferredSize(new Dimension(300, 300)); // Panel size
        setOpaque(false); // Make the panel transparent
        setLayout(new GridBagLayout()); // Center the image

        // Load and scale the image
        logoIcon = new ImageIcon(new ImageIcon("src/assets/logo.png")
                .getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));

        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 0, 0)); // Fully transparent background
    }
}
