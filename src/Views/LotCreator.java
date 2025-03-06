/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.border.*;
import Classes.Block;
import Classes.Lot;
import Model.BlockModel;
import Model.LotModel;
import Theme.Theme;

/** 
 *
 * @author Louis
 */
public class LotCreator extends javax.swing.JPanel {

    private Components.LotSearchPanel lotSearchPanel;

    // Constants
    private static final Color BORDER_COLOR = new Color(200, 200, 200);
    private static final Color SUCCESS_COLOR = new Color(76, 175, 80);
    private static final Color ERROR_COLOR = new Color(211, 47, 47);

    // Constructor
    public LotCreator(Components.LotSearchPanel lotSearchPanel) {
        this.lotSearchPanel = lotSearchPanel;
        initComponents();
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        Styling1();
        cmbBlock.setModel(new DefaultComboBoxModel<Classes.Block>());
        cmbStatus.setModel(new DefaultComboBoxModel<>(new String[]{"AVAILABLE", "RESERVED", "SOLD"}));
        adjustComponentSizes();
        loadBlocks();
        setupHoverEffects();
    }

    // Sizing
    private void adjustComponentSizes() {

        int textFieldWidth = 170;
        int comboBoxWidth = 180;
        
        txtLotNumber.setMinimumSize(new Dimension(textFieldWidth, 40));
        txtLotNumber.setPreferredSize(new Dimension(textFieldWidth, 40));

        txtSize.setMinimumSize(new Dimension(textFieldWidth, 40));
        txtSize.setPreferredSize(new Dimension(textFieldWidth, 40));

        txtPrice.setMinimumSize(new Dimension(textFieldWidth, 40));
        txtPrice.setPreferredSize(new Dimension(textFieldWidth, 40));

        cmbBlock.setMinimumSize(new Dimension(comboBoxWidth, 38));
        cmbBlock.setPreferredSize(new Dimension(comboBoxWidth, 38));

        cmbStatus.setMinimumSize(new Dimension(comboBoxWidth, 38));
        cmbStatus.setPreferredSize(new Dimension(comboBoxWidth, 38));

        btnCreate.setMinimumSize(new Dimension(120, 40));
        btnCreate.setPreferredSize(new Dimension(120, 40));
    }

    // Styling
    private void Styling1() {
        setBackground(Theme.BACKGROUND);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Theme.BACKGROUND);
        headerPanel.setPreferredSize(new Dimension(800, 40));
        headerPanel.setLayout(null);

        remove(jLabel1);
        JLabel titleLabel = new JLabel("Create New Property Lot");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Theme.PRIMARY_FOREGROUND);
        titleLabel.setBounds(20, 8, 300, 24);
        headerPanel.add(titleLabel);

        // Add form container with border to make it look more compact
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Theme.BACKGROUND);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(25, 40, 25, 40) // Increased horizontal padding
        ));
        formPanel.setLayout(new GridBagLayout());
        formPanel.setPreferredSize(new Dimension(450, 350));

        // Create constraints for the form panel content
        GridBagConstraints formConstraints = new GridBagConstraints();
        formConstraints.fill = GridBagConstraints.HORIZONTAL;
        formConstraints.anchor = GridBagConstraints.WEST;
        formConstraints.insets = new Insets(8, 5, 8, 5); // Tighter spacing
        
        // Add label-field pairs to form panel
        formConstraints.gridx = 0;
        formConstraints.gridy = 0;
        formPanel.add(jLabel2, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 0;
        formPanel.add(cmbBlock, formConstraints);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 1;
        formPanel.add(jLabel3, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 1;
        formPanel.add(txtLotNumber, formConstraints);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 2;
        formPanel.add(jLabel4, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 2;
        formPanel.add(txtSize, formConstraints);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 3;
        formPanel.add(jLabel5, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 3;
        formPanel.add(txtPrice, formConstraints);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 4;
        formPanel.add(jLabel6, formConstraints);
        
        formConstraints.gridx = 1;
        formConstraints.gridy = 4;
        formPanel.add(cmbStatus, formConstraints);
        
        // Add button in its own panel for better alignment
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Theme.BACKGROUND);
        buttonPanel.add(btnCreate);
        
        formConstraints.gridx = 0;
        formConstraints.gridy = 5;
        formConstraints.gridwidth = 2;
        formConstraints.anchor = GridBagConstraints.EAST;
        formPanel.add(buttonPanel, formConstraints);
        
        // Add message label
        formConstraints.gridx = 0;
        formConstraints.gridy = 6;
        formConstraints.anchor = GridBagConstraints.WEST;
        formPanel.add(lblMessage, formConstraints);

        // Header constraints
        GridBagConstraints headerConstraints = new GridBagConstraints();
        headerConstraints.gridx = 0;
        headerConstraints.gridy = 0;
        headerConstraints.gridwidth = GridBagConstraints.REMAINDER;
        headerConstraints.fill = GridBagConstraints.HORIZONTAL;
        headerConstraints.anchor = GridBagConstraints.NORTH;
        headerConstraints.weightx = 1.0;
        headerConstraints.insets = new Insets(0, 0, 10, 0);
        add(headerPanel, headerConstraints);
        
        // Form panel constraints - center it in the available space
        GridBagConstraints containerConstraints = new GridBagConstraints();
        containerConstraints.gridx = 0;
        containerConstraints.gridy = 1;
        containerConstraints.weightx = 1.0;
        containerConstraints.weighty = 1.0;
        containerConstraints.fill = GridBagConstraints.NONE;
        containerConstraints.anchor = GridBagConstraints.CENTER;
        containerConstraints.insets = new Insets(20, 20, 20, 20);
        add(formPanel, containerConstraints);

        styleLabels();
        styleInputFields();
        styleButton();

        lblMessage.setForeground(ERROR_COLOR);
        lblMessage.setFont(new Font("Segoe UI", Font.BOLD, 12));
    }

    // Labels
    private void styleLabels() {
        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);

        jLabel2.setFont(labelFont);
        jLabel3.setFont(labelFont);
        jLabel4.setFont(labelFont);
        jLabel5.setFont(labelFont);
        jLabel6.setFont(labelFont);

        jLabel2.setForeground(Theme.SECONDARY_FOREGROUND);
        jLabel3.setForeground(Theme.SECONDARY_FOREGROUND);
        jLabel4.setForeground(Theme.SECONDARY_FOREGROUND);
        jLabel5.setForeground(Theme.SECONDARY_FOREGROUND);
        jLabel6.setForeground(Theme.SECONDARY_FOREGROUND);
    }

    // Inputs
    private void styleInputFields() {
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);

        CompoundBorder textBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR),
                BorderFactory.createEmptyBorder(12, 10, 12, 10));

        txtLotNumber.setFont(inputFont);
        txtLotNumber.setBorder(textBorder);
        txtLotNumber.setBackground(Theme.BACKGROUND);
        txtLotNumber.setPreferredSize(new Dimension(180, 40)); // Changed from 200 to 180

        txtSize.setFont(inputFont);
        txtSize.setBorder(textBorder);
        txtSize.setBackground(Theme.BACKGROUND);
        txtSize.setPreferredSize(new Dimension(180, 40)); // Changed from 200 to 180

        txtPrice.setFont(inputFont);
        txtPrice.setBorder(textBorder);
        txtPrice.setBackground(Theme.BACKGROUND);
        txtPrice.setPreferredSize(new Dimension(180, 40)); // Changed from 200 to 180

        cmbBlock.setFont(inputFont);
        cmbBlock.setBackground(Theme.BACKGROUND);
        cmbBlock.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        cmbBlock.setPreferredSize(new Dimension(180, 38)); // Changed from 200 to 180
        ((JComponent) cmbBlock.getRenderer()).setBackground(Theme.BACKGROUND);

        cmbStatus.setFont(inputFont);
        cmbStatus.setBackground(Theme.BACKGROUND);
        cmbStatus.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        cmbStatus.setPreferredSize(new Dimension(180, 38)); // Changed from 200 to 180
        ((JComponent) cmbStatus.getRenderer()).setBackground(Theme.BACKGROUND);

        // Renderer
        cmbBlock.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JComponent) {
                    ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
                }
                if (isSelected) {
                    setBackground(Theme.PRIMARY_BACKGROUND);
                    setForeground(Theme.PRIMARY_FOREGROUND);
                }
                return this;
            }
        });

        // Renderer
        cmbStatus.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JComponent) {
                    ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
                }
                if (isSelected) {
                    setBackground(Theme.PRIMARY_BACKGROUND);
                    setForeground(Theme.PRIMARY_FOREGROUND);
                }
                return this;
            }
        });

        cmbBlock.setMaximumRowCount(6);
        cmbStatus.setMaximumRowCount(4);
    }

    // Button
    private void styleButton() {
        btnCreate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCreate.setBackground(Theme.PRIMARY_BACKGROUND);
        btnCreate.setForeground(Theme.PRIMARY_FOREGROUND);
        btnCreate.setFocusPainted(false);
        btnCreate.setBorderPainted(false);
        btnCreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCreate.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnCreate.setContentAreaFilled(true);

    // Hover
    }
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

    // Feedback
    private void showMessage(String message, boolean isError) {
        lblMessage.setText(message);
        lblMessage.setForeground(isError ? ERROR_COLOR : SUCCESS_COLOR);
    }

    // Data
    private void loadBlocks() {
        try {
            BlockModel blockModel = new BlockModel();
            java.util.List<Block> blocks = blockModel.getAllBlocks();

            DefaultComboBoxModel<Block> model = new DefaultComboBoxModel<>();
            for (Block block : blocks) {
                model.addElement(block);
            }

            cmbBlock.setModel(model);
        } catch (Exception e) {
            showMessage("Error loading blocks: " + e.getMessage(), true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBlock = new javax.swing.JComboBox<>();
        txtLotNumber = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Create New Lot");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Select Block:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 76, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabel3.setText("Lot Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 75, 0, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Size (sqm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 75, 0, 0);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Price (PHP):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 75, 0, 0);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 75, 0, 0);
        add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 77);
        add(cmbBlock, gridBagConstraints);

        txtLotNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLotNumberActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 77);
        add(txtLotNumber, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 77);
        add(txtSize, gridBagConstraints);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 77);
        add(txtPrice, gridBagConstraints);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 77);
        add(cmbStatus, gridBagConstraints);

        btnCreate.setText("Create Lot");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 13, 77);
        add(btnCreate, gridBagConstraints);

        lblMessage.setText("   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 70, 0, 0);
        add(lblMessage, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
    }//GEN-LAST:event_txtPriceActionPerformed

    // Submit
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            // Validation
            if (txtLotNumber.getText().isEmpty()
                    || txtSize.getText().isEmpty()
                    || txtPrice.getText().isEmpty()
                    || cmbBlock.getSelectedItem() == null) {

                lblMessage.setText("All fields are required");
                return;
            }
            Block selectedBlock = (Block) cmbBlock.getSelectedItem();
            double sizeDouble, priceDouble;

            // Parsing
            try {
                sizeDouble = Double.parseDouble(txtSize.getText());
                priceDouble = Double.parseDouble(txtPrice.getText());
            } catch (NumberFormatException e) {
                lblMessage.setText("Size and price must be valid numbers");
                return;
            }

            // Validation
            if (sizeDouble <= 0 || priceDouble <= 0) {
                lblMessage.setText("Size and price must be positive values");
                return;
            }

            // Conversion
            BigDecimal size = new BigDecimal(sizeDouble);
            BigDecimal price = new BigDecimal(priceDouble);

            // Status
            String statusString = (String) cmbStatus.getSelectedItem();
            Lot.Status status = Lot.Status.valueOf(statusString);

            // Creation
            Lot newLot = new Lot(
                    selectedBlock.getId(), // blockId
                    null, // customerId (null for new lots)
                    selectedBlock.getLocation(),
                    size,
                    price,
                    status
            );

            // Save
            LotModel lotModel = new LotModel();
            boolean success = lotModel.createLot(newLot);
            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Lot created successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } 

            if (lotSearchPanel != null) {
                lotSearchPanel.refreshData();
            }
            else {
                lblMessage.setText("Failed to create lot. It may already exist.");
            }
        } catch (IllegalArgumentException e) {
            lblMessage.setText("Invalid status value");
            e.printStackTrace();
        } catch (Exception e) {
            lblMessage.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Reset
    private void clearFields() {
        txtLotNumber.setText("");
        txtSize.setText("");
        txtPrice.setText("");
        cmbStatus.setSelectedIndex(0);
        lblMessage.setText(" ");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtLotNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLotNumberActionPerformed
    }//GEN-LAST:event_txtLotNumberActionPerformed


    // Components
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<Classes.Block> cmbBlock;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtLotNumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
