package Views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class Register extends JPanel {
    
     public Register() {
        // Initialize
        this.setLayout(new FlowLayout());
        // Theme
        this.setBackground(Theme.BACKGROUND);
        
        // Dimensions
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        // Identifier
        this.setName("register");
    }
}
