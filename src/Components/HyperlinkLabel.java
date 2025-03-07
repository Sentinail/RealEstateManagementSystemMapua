/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Louis
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HyperlinkLabel extends JPanel { // Link
    public HyperlinkLabel(String normalTextStr, String hyperlinkTextStr) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(Color.WHITE);

        JLabel normalText = new JLabel(normalTextStr);
        normalText.setFont(new Font("Arial", Font.PLAIN, 12));
        normalText.setForeground(Color.BLACK);

        JLabel hyperlink = new JLabel(hyperlinkTextStr);
        hyperlink.setFont(new Font("Arial", Font.BOLD, 12));
        hyperlink.setForeground(Color.BLUE);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setForeground(new Color(30, 144, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setForeground(Color.BLUE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Sign Up Clicked!");
            }
        });

        add(normalText);
        add(hyperlink);
    }
}