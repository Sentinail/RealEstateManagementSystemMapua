/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Louis
 */
public class LoginForm extends JPanel { // Authentication

    public LoginForm() {
        this.setLayout(new FlowLayout());

        this.setPreferredSize(new Dimension(400, 600));
        this.setMinimumSize(new Dimension(400, 600));
        this.setMaximumSize(new Dimension(400, 600));

        this.setBackground(new Theme().getBackground());
    }
}