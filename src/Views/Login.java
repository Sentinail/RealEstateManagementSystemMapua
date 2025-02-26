/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import javax.swing.*;
import Theme.Theme;
import java.awt.*;

public class Login extends JPanel {
    public Login() {
        this.setLayout(new FlowLayout());
        this.setBackground(Theme.BACKGROUND);
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        this.setName("login");
    }
}