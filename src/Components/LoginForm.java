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

public class LoginForm extends JPanel {
    public LoginForm() {
        setPreferredSize(new Dimension(400, 600));
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        // Components
        JLabel loginTitle = new JLabel("Login");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        CustomTextField usernameField = new CustomTextField("");

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        CustomTextField passwordField = new CustomTextField("");

        CustomButton loginButton = new CustomButton("Login");
        HyperlinkLabel signUpLink = new HyperlinkLabel("Don't have an account? ", "Sign Up");

        // Layout positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Aligns labels to the left

        // Title
        gbc.insets = new Insets(41, 0, 10, 0);
        gbc.gridwidth = 2; // Center the title
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginTitle, gbc);

        gbc.gridwidth = 1; // Reset width
        gbc.anchor = GridBagConstraints.WEST; // Left-align elements

        // Username Label (Left-Aligned)
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 10, 5, 0); // Add left padding
        add(usernameLabel, gbc);

        // Username Field (Full Width)
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make it expand horizontally
        add(usernameField, gbc);

        // Password Label (Left-Aligned)
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 10, 5, 0);
        gbc.fill = GridBagConstraints.NONE; // Reset fill
        add(passwordLabel, gbc);

        // Password Field (Full Width)
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(passwordField, gbc);

        // Login Button
        gbc.gridy = 5;
        gbc.insets = new Insets(20, 10, 0, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(loginButton, gbc);

        // Sign Up link below button
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER; // Center align only this
        add(signUpLink, gbc);
    }
}