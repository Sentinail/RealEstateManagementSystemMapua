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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HyperlinkLabelRegister extends JPanel {

    public HyperlinkLabelRegister() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // No gaps in FlowLayout
        setBackground(Color.WHITE);

        // Hyperlink label
        JLabel hyperlink = new JLabel("Sign In");
        hyperlink.setFont(new Font("Arial", Font.BOLD, 14));
        hyperlink.setForeground(Color.BLUE);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Mouse hover effect for hyperlink
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setForeground(new Color(30, 144, 255)); // Lighter blue on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setForeground(Color.BLUE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Find RootPanel dynamically
                RootPanel rootPanel = (RootPanel) SwingUtilities.getAncestorOfClass(RootPanel.class, HyperlinkLabelRegister.this);

                if (rootPanel != null) {
                    // Find login1 inside rootPanel1
                    Component[] components = rootPanel.getComponents();
                    JPanel loginPanel = null;

                    for (Component comp : components) {
                        if (comp instanceof JPanel && "login".equals(comp.getName())) {
                            loginPanel = (JPanel) comp;
                            break;
                        }
                    }

                    // Switch to login1 panel
                    if (loginPanel != null) {
                        rootPanel.removeAll();
                        rootPanel.add(loginPanel);
                        rootPanel.repaint();
                        rootPanel.revalidate();
                    } else {
                        System.out.println("login panel not found!");
                    }
                } else {
                    System.out.println("RootPanel not found!");
                }
            }
        });

        // Add components
        add(hyperlink);
    }
}