package Components;

import Theme.Theme;
import java.awt.Dimension;
import java.awt.FlowLayout;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;

/**
 *
 * @author Sentinail
 */
public class DashboardSidebar extends JPanel {
    public DashboardSidebar() {
        this.setLayout(new FlowLayout());
        this.setBackground(Theme.SECONDARY_BACKGROUND);
        this.setPreferredSize(new Dimension(200, 600));
        this.setMinimumSize(new Dimension(200, 600));
        this.setMaximumSize(new Dimension(200, 600));
        this.setName("dashboardSidebar");
    }
}
