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
 * @author Louis
 */
public class LoginButton extends JButton {
    public LoginButton() {
        super("Login");
        setBackground(Theme.PRIMARY_BACKGROUND);
        setForeground(Theme.PRIMARY_FOREGROUND);
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 14));
    }
}
