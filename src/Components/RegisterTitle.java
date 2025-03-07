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
 * @author Sentinail
 */


public class RegisterTitle extends JLabel { // Heading
    public RegisterTitle() {
        super("Register", SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 36));
    }
}

