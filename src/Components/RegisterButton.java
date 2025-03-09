/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Font;

import javax.swing.JButton;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class RegisterButton extends JButton { // Submit
    public RegisterButton() {
        super("Register");
        setBackground(new Theme().getPrimaryBackground());
        setForeground(new Theme().getPrimaryForeground());
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 14));
    }
}
