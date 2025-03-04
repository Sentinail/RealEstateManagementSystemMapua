package Views;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class SalesAndReservation extends JPanel {
    
     public SalesAndReservation() {
        this.setLayout(new FlowLayout());
        this.setBackground(Theme.BACKGROUND);
        
        // Set fixed size of 800x600
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setMaximumSize(new Dimension(600, 600));
        this.setName("salesAndReservation");
    }
}
