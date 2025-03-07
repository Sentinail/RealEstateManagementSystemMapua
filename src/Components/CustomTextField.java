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

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class CustomTextField extends JTextField { // Input
    public CustomTextField(String placeholder) {
        this.setPreferredSize(new Dimension(300, 40));
        this.setFont(new Font("Arial", Font.PLAIN, 14));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(true);
    }
}
