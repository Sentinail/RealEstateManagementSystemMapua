package Components;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class DashboardSidebar extends JPanel { // Navigation
    public DashboardSidebar() {
        this.setLayout(new FlowLayout());
        this.setBackground(Theme.SECONDARY_BACKGROUND);
        this.setPreferredSize(new Dimension(200, 600));
        this.setMinimumSize(new Dimension(200, 600));
        this.setMaximumSize(new Dimension(200, 600));
        this.setName("dashboardSidebar");
    }
}
