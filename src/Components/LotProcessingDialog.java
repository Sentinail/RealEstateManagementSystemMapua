/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sentinail
 */
public class LotProcessingDialog extends JDialog {
    private JTextField buyerNameField, contactField;
    private JButton sellButton, reserveButton, cancelButton;

    public LotProcessingDialog(int lotId) {
        setTitle("Process Lot ID: " + lotId);
        setModal(true);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);

        add(new JLabel("Buyer Name:"));
        buyerNameField = new JTextField();
        add(buyerNameField);

        add(new JLabel("Contact Number:"));
        contactField = new JTextField();
        add(contactField);

        sellButton = new JButton("Sell");
        reserveButton = new JButton("Reserve");
        cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sellButton);
        buttonPanel.add(reserveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel);

        sellButton.addActionListener(e -> processLot("SOLD", lotId));
        reserveButton.addActionListener(e -> processLot("RESERVED", lotId));
        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void processLot(String action, int lotId) {
        String buyerName = buyerNameField.getText().trim();
        String contact = contactField.getText().trim();

        if (buyerName.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Buyer details must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Lot " + lotId + " is now " + action + " under " + buyerName, "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}