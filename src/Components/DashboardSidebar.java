package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Theme.Theme;

/**
 *
 * @author Sentinail
 */
public class DashboardSidebar extends JPanel { // Navigation

    public DashboardSidebar() {
        initializeLayout();
        addLogo();
    }

    public DashboardSidebar(JPanel cardPanel, ArrayList<JButton> navigationButtons) {
        initializeLayout();
        addLogo();

        // Container for buttons (use BoxLayout to prevent stretching)
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
        buttonContainer.setOpaque(false);
        buttonContainer.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (JButton button : navigationButtons) {
            button.setPreferredSize(new Dimension(180, 40)); // Full width but smaller height
            button.setMaximumSize(new Dimension(180, 40));
            button.setMinimumSize(new Dimension(180, 40));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            buttonContainer.add(button);
            buttonContainer.add(Box.createVerticalStrut(10)); // Space between buttons

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout layout = (CardLayout) cardPanel.getLayout();
                    layout.show(cardPanel, button.getName()); // Switch to the panel with this button's name
                }
            });
        }
        
        JButton logoutButton = new DashboardSideBarNavigationButton("Logout");
        
        logoutButton.setPreferredSize(new Dimension(180, 40)); // Full width but smaller height
        logoutButton.setMaximumSize(new Dimension(180, 40));
        logoutButton.setMinimumSize(new Dimension(180, 40));
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
        });
        
        buttonContainer.add(logoutButton);

        add(buttonContainer);
    }

    private void initializeLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Theme().getSecondaryBackground());
        setPreferredSize(new Dimension(200, 600));
        setMinimumSize(new Dimension(200, 600));
        setMaximumSize(new Dimension(200, 600));
        setName("dashboardSidebar");
    }

    private void addLogo() {
        // Load and scale the image properly
        ImageIcon originalIcon = new ImageIcon("src/assets/logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon logoIcon = new ImageIcon(scaledImage);

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setMaximumSize(new Dimension(200, 180)); // Adjust logo size
        logoLabel.setBorder(BorderFactory.createLineBorder(new Theme().getPrimaryBackground()));

        add(logoLabel);
        add(Box.createVerticalStrut(20)); // Space between the logo and buttons
    }
}
