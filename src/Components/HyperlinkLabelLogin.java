package Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class HyperlinkLabelLogin extends JPanel { // Navigation
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
                    rootPanel.view("card2");
                    
                } else {
                    System.out.println("RootPanel not found!");
                }
            }
        });

        add(hyperlink);
    }
}
