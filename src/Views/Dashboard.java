package Views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class Dashboard extends JPanel {
    public Dashboard() {
        // Layout
        this.setLayout(new FlowLayout());
        // Color
        this.setBackground(Theme.BACKGROUND);
        // Size
        this.setPreferredSize(new Dimension(800, 600));
        // Minimum
        this.setMinimumSize(new Dimension(800, 600));
        // Maximum
        this.setMaximumSize(new Dimension(800, 600));
        // Identifier
        this.setName("dashboard");
    }
}
