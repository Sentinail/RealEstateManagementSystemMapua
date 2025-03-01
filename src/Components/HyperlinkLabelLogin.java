package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HyperlinkLabelLogin extends JPanel {
    public HyperlinkLabelLogin() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(Color.WHITE);

        JLabel hyperlink = new JLabel("Sign Up");
        hyperlink.setFont(new Font("Arial", Font.BOLD, 14));
        hyperlink.setForeground(Color.BLUE);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setForeground(new Color(30, 144, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setForeground(Color.BLUE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                RootPanel rootPanel = (RootPanel) SwingUtilities.getAncestorOfClass(RootPanel.class, HyperlinkLabelLogin.this);

                if (rootPanel != null) {
                    Component[] components = rootPanel.getComponents();
                    JPanel registerPanel = null;

                    for (Component comp : components) {
                        if (comp instanceof JPanel && "register".equals(comp.getName())) {
                            registerPanel = (JPanel) comp;
                            break;
                        }
                    }

                    if (registerPanel != null) {
                        rootPanel.removeAll();
                        rootPanel.add(registerPanel);
                        rootPanel.repaint();
                        rootPanel.revalidate();
                    } else {
                        System.out.println("Register panel not found!");
                    }
                } else {
                    System.out.println("RootPanel not found!");
                }
            }
        });

        add(hyperlink);
    }
}
