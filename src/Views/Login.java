/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import javax.swing.*;
import Components.LogoPanel;
import Components.LoginForm;
import java.awt.*;

public class Login extends JPanel {
    public Login() {
        setLayout(new BorderLayout());

        // Left Panel: Logo
        LogoPanel logoPanel = new LogoPanel();
        
        // Right Panel: Login Form
        LoginForm loginForm = new LoginForm();

        // Add both panels to the layout
        add(logoPanel, BorderLayout.WEST);
        add(loginForm, BorderLayout.CENTER);
    }
}