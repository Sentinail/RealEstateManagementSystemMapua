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
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class CustomButton extends JButton { // Action
    public CustomButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(new Color(164, 136, 115)); 
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(300, 40));
    }
}