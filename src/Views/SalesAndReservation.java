package Views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class SalesAndReservation extends JPanel {
    
     public SalesAndReservation() {
        // Layout
        this.setLayout(new FlowLayout());
        // Background
        this.setBackground(Theme.BACKGROUND);
        
        // Size
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setMaximumSize(new Dimension(600, 600));
        // Identifier
        this.setName("salesAndReservation");
    }
}
