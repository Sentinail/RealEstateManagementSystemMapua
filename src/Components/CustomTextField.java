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

public class CustomTextField extends JTextField {
    public CustomTextField(String placeholder) {
        this.setPreferredSize(new Dimension(300, 40)); // Set size
        this.setFont(new Font("Arial", Font.PLAIN, 14)); // Font styling
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Border
        this.setOpaque(true);
    }
}
