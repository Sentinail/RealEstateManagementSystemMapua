package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import Classes.Block;
import Model.BlockModel;
import Theme.Theme;

public class BlockCreator extends javax.swing.JPanel {

    // Colors
    private static final Color BORDER_COLOR = new Color(200, 200, 200);
    private static final Color SUCCESS_COLOR = new Color(76, 175, 80);
    private static final Color ERROR_COLOR = new Color(211, 47, 47);

    // Initialize
    public BlockCreator() {
        initComponents();
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        setupUI();
        adjustComponentSizes();
        setupHoverEffects();
    }

    // Layout
    private void setupUI() {
        setBackground(Theme.BACKGROUND);
        setLayout(new GridBagLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Theme.BACKGROUND);
        headerPanel.setPreferredSize(new Dimension(800, 60));
        headerPanel.setLayout(null);

        remove(jLabel1);
        JLabel titleLabel = new JLabel("Create New Property Block");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Theme.PRIMARY_FOREGROUND);
        titleLabel.setBounds(30, 15, 300, 30);
        headerPanel.add(titleLabel);

        // Form
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Theme.BACKGROUND);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(35, 50, 35, 50)
        ));
        formPanel.setLayout(new GridBagLayout());
        formPanel.setPreferredSize(new Dimension(550, 520));

        // Constraints
        GridBagConstraints formConstraints = new GridBagConstraints();
        formConstraints.fill = GridBagConstraints.HORIZONTAL;
        formConstraints.anchor = GridBagConstraints.WEST;
        formConstraints.insets = new Insets(12, 10, 12, 10);
        
        // Fields
        formConstraints.gridx = 0;
        formConstraints.gridy = 0;
        formConstraints.weightx = 0.3;
        formPanel.add(jLabel2, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 0;
        formConstraints.weightx = 0.7;
        formPanel.add(txtBlockNumber, formConstraints);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 1;
        formConstraints.weightx = 0.3;
        formPanel.add(jLabel3, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 1;
        formConstraints.weightx = 0.7;
        formPanel.add(txtBlockName, formConstraints);

        formConstraints.gridx = 0;
        formConstraints.gridy = 2;
        formConstraints.weightx = 0.3;
        formConstraints.anchor = GridBagConstraints.NORTHWEST;
        formConstraints.fill = GridBagConstraints.NONE;
        formPanel.add(jLabel4, formConstraints);
        
        JScrollPane scrollPane = new JScrollPane(txtDescription);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(250, 250));
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 2;
        formConstraints.weightx = 0.7;
        formConstraints.fill = GridBagConstraints.BOTH;
        formConstraints.weighty = 1.5;
        formPanel.add(txtDescription, formConstraints);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Theme.BACKGROUND);

        buttonPanel.add(btnCreate);

        formConstraints.gridx = 0;
        formConstraints.gridy = 3;
        formConstraints.gridwidth = 2;
        formConstraints.weighty = 0;
        formConstraints.anchor = GridBagConstraints.EAST;
        formConstraints.fill = GridBagConstraints.HORIZONTAL;
        formConstraints.insets = new Insets(25, 10, 5, 10);
        formPanel.add(buttonPanel, formConstraints);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 3;
        formConstraints.gridwidth = 2;
        formConstraints.weighty = 0;
        formConstraints.anchor = GridBagConstraints.EAST;
        formConstraints.fill = GridBagConstraints.HORIZONTAL;
        formConstraints.insets = new Insets(25, 10, 5, 10);
        formPanel.add(buttonPanel, formConstraints);
        
        // Messages
        formConstraints.gridx = 0;
        formConstraints.gridy = 4;
        formConstraints.gridwidth = 2;
        formConstraints.insets = new Insets(0, 10, 0, 10);
        formConstraints.anchor = GridBagConstraints.WEST;
        formPanel.add(lblMessage, formConstraints);

        // Header
        GridBagConstraints headerConstraints = new GridBagConstraints();
        headerConstraints.gridx = 0;
        headerConstraints.gridy = 0;
        headerConstraints.gridwidth = GridBagConstraints.REMAINDER;
        headerConstraints.fill = GridBagConstraints.HORIZONTAL;
        headerConstraints.anchor = GridBagConstraints.NORTH;
        headerConstraints.weightx = 1.0;
        headerConstraints.insets = new Insets(0, 0, 10, 0);
        add(headerPanel, headerConstraints);
        
        // Container
        GridBagConstraints containerConstraints = new GridBagConstraints();
        containerConstraints.gridx = 0;
        containerConstraints.gridy = 1;
        containerConstraints.weightx = 1.0;
        containerConstraints.weighty = 1.0;
        containerConstraints.fill = GridBagConstraints.NONE;
        containerConstraints.anchor = GridBagConstraints.CENTER;
        containerConstraints.insets = new Insets(0, 0, 20, 0);
        add(formPanel, containerConstraints);

        styleLabels();
        styleInputFields();
        styleButton();

        lblMessage.setForeground(ERROR_COLOR);
        lblMessage.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblMessage.setText(" ");
    }

    // Dimensions
    private void adjustComponentSizes() {
        int textFieldWidth = 250;
        int textFieldHeight = 40;
        
        txtBlockNumber.setMinimumSize(new Dimension(textFieldWidth, textFieldHeight));
        txtBlockNumber.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));

        txtBlockName.setMinimumSize(new Dimension(textFieldWidth, textFieldHeight));
        txtBlockName.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));

        txtDescription.setRows(12);
        txtDescription.setColumns(22);

        btnCreate.setMinimumSize(new Dimension(140, 45));
        btnCreate.setPreferredSize(new Dimension(140, 45));
    }

    // Typography
    private void styleLabels() {
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);

        jLabel2.setFont(labelFont);
        jLabel3.setFont(labelFont);
        jLabel4.setFont(labelFont);

        jLabel2.setForeground(Theme.SECONDARY_FOREGROUND);
        jLabel3.setForeground(Theme.SECONDARY_FOREGROUND);
        jLabel4.setForeground(Theme.SECONDARY_FOREGROUND);
    }

    // Fields
    private void styleInputFields() {
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);

        CompoundBorder textBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR),
                BorderFactory.createEmptyBorder(12, 15, 12, 15));

        txtBlockNumber.setFont(inputFont);
        txtBlockNumber.setBorder(textBorder);
        txtBlockNumber.setBackground(Theme.BACKGROUND);

        txtBlockName.setFont(inputFont);
        txtBlockName.setBorder(textBorder);
        txtBlockName.setBackground(Theme.BACKGROUND);

        txtDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtDescription.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR),
                BorderFactory.createEmptyBorder(12, 15, 12, 15)));
        txtDescription.setBackground(Theme.BACKGROUND);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setForeground(new Color(60, 60, 60));
        
        txtDescription.setText("Enter detailed description of the property block...");
        txtDescription.setForeground(new Color(150, 150, 150));
    }

    // Button
    private void styleButton() {
        btnCreate.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCreate.setBackground(Theme.PRIMARY_BACKGROUND);
        btnCreate.setForeground(Theme.PRIMARY_FOREGROUND);
        btnCreate.setFocusPainted(false);
        btnCreate.setBorderPainted(false);
        btnCreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCreate.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnCreate.setContentAreaFilled(true);

        txtDescription.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtDescription.getText().equals("Enter detailed description of the property block...")) {
                    txtDescription.setText("");
                    txtDescription.setForeground(new Color(60, 60, 60));
                }
                txtDescription.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Theme.PRIMARY_BACKGROUND, 2),
                    BorderFactory.createEmptyBorder(12, 15, 12, 15)));
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (txtDescription.getText().isEmpty()) {
                    txtDescription.setText("Enter detailed description of the property block...");
                    txtDescription.setForeground(new Color(150, 150, 150));
                }
                txtDescription.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_COLOR),
                    BorderFactory.createEmptyBorder(12, 15, 12, 15)));
            }
        });
    }

    // Interactivity
    private void setupHoverEffects() {
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Color lighterBrown = new Color(
                        Math.min(Theme.PRIMARY_BACKGROUND.getRed() + 20, 255),
                        Math.min(Theme.PRIMARY_BACKGROUND.getGreen() + 20, 255),
                        Math.min(Theme.PRIMARY_BACKGROUND.getBlue() + 20, 255)
                );
                btnCreate.setBackground(lighterBrown);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCreate.setBackground(Theme.PRIMARY_BACKGROUND);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Color darkerBrown = new Color(
                        Math.max(Theme.PRIMARY_BACKGROUND.getRed() - 20, 0),
                        Math.max(Theme.PRIMARY_BACKGROUND.getGreen() - 20, 0),
                        Math.max(Theme.PRIMARY_BACKGROUND.getBlue() - 20, 0)
                );
                btnCreate.setBackground(darkerBrown);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btnCreate.setBackground(Theme.PRIMARY_BACKGROUND);
            }
        });
    }

    // Notifications
    private void showMessage(String message, boolean isError) {
        lblMessage.setText(message);
        lblMessage.setForeground(isError ? ERROR_COLOR : SUCCESS_COLOR);
    }

    // Reset
    private void clearFields() {
        txtBlockNumber.setText("");
        txtBlockName.setText("");
        txtDescription.setText("");
        lblMessage.setText(" ");
    }

    // Components
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBlockNumber = new javax.swing.JTextField();
        txtBlockName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Create New Block");
        add(jLabel1);

        jLabel2.setText("Block Number:");
        add(jLabel2);

        jLabel3.setText("Block Name:");
        add(jLabel3);

        jLabel4.setText("Description:");
        add(jLabel4);

        txtBlockNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBlockNumberActionPerformed(evt);
            }
        });
        add(txtBlockNumber);

        txtBlockName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBlockNameActionPerformed(evt);
            }
        });
        add(txtBlockName);

        btnCreate.setText("Create Block");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate);

        lblMessage.setText("   ");
        add(lblMessage);
    }

    private void txtBlockNumberActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtBlockNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    // Save
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Validation
            if (txtBlockNumber.getText().isEmpty() || txtBlockName.getText().isEmpty()) {
                showMessage("Block number and name are required", true);
                return;
            }

            int blockNumber;
            try {
                blockNumber = Integer.parseInt(txtBlockNumber.getText());
                if (blockNumber <= 0) {
                    showMessage("Block number must be a positive number", true);
                    return;
                }
            } catch (NumberFormatException e) {
                showMessage("Block number must be a valid integer", true);
                return;
            }

            String blockName = txtBlockName.getText();
            String description = txtDescription.getText();

            // Database
            Block newBlock = new Block(blockNumber, blockName, description);
            BlockModel blockModel = new BlockModel();
            Block createdBlock = blockModel.create(newBlock);

            if (createdBlock != null && createdBlock.getId() > 0) {
                JOptionPane.showMessageDialog(this,
                        "Block created successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                showMessage("Block created successfully", false);
            } else {
                showMessage("Failed to create block", true);
            }
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
                showMessage("A block with this number already exists", true);
            } else {
                showMessage("Error: " + e.getMessage(), true);
                e.printStackTrace();
            }
        }
    }

    // Variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtBlockName;
    private javax.swing.JTextField txtBlockNumber;
    private javax.swing.JTextArea txtDescription;
}