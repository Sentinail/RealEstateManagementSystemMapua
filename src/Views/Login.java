package Views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import Theme.Theme;

public class Login extends JPanel {
    public Login() {
        // Layout
        this.setLayout(new FlowLayout());
        // Coloring
        this.setBackground(new Theme().getBackground());

        // Dimensions
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        // Identification
        this.setName("login");
    }
}
