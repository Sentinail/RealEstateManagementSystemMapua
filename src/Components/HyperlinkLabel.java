/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Louis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HyperlinkLabel extends JPanel {
    public HyperlinkLabel(String normalTextStr, String hyperlinkTextStr) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // No gaps in FlowLayout
        setBackground(Color.WHITE);

        // Normal text label
        JLabel normalText = new JLabel(normalTextStr);
        normalText.setFont(new Font("Arial", Font.PLAIN, 12));
        normalText.setForeground(Color.BLACK);

        // Hyperlink label
        JLabel hyperlink = new JLabel(hyperlinkTextStr);
        hyperlink.setFont(new Font("Arial", Font.BOLD, 12));
        hyperlink.setForeground(Color.BLUE);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Mouse hover effect for hyperlink
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setForeground(new Color(30, 144, 255)); // Lighter blue on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setForeground(Color.BLUE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Sign Up Clicked!"); // Replace with navigation logic
            }
        });

        // Add components
        add(normalText);
        add(hyperlink);
    }
}