/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Louis
 */
public class LoginTitle extends JLabel { // Heading
    public LoginTitle() {
        super("Login", SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 36));
    }
}
