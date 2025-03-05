/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.LotModel;
import Classes.Lot;

/**
 *
 * @author Sentinail
 */
public class LotSearchPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField locationField, minSizeField, maxSizeField, minPriceField, maxPriceField, blockField;
    private JComboBox<String> statusComboBox;
    private List<Object[]> allLots = new ArrayList<>();
    private LotModel lotModel = new LotModel();

    public LotSearchPanel() {
        setLayout(new BorderLayout(5, 5));
        setPreferredSize(new Dimension(580, 580));

        JPanel searchPanel = new JPanel(new GridLayout(3, 4, 5, 5));
        locationField = new JTextField(8);
        minSizeField = new JTextField(5);
        maxSizeField = new JTextField(5);
        minPriceField = new JTextField(5);
        maxPriceField = new JTextField(5);
        blockField = new JTextField(5);
        statusComboBox = new JComboBox<>(new String[]{"ALL", "AVAILABLE", "RESERVED", "SOLD"});
        JButton searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Location:"));
        searchPanel.add(locationField);
        searchPanel.add(new JLabel("Block No:"));
        searchPanel.add(blockField);

        searchPanel.add(new JLabel("Min Size:"));
        searchPanel.add(minSizeField);
        searchPanel.add(new JLabel("Max Size:"));
        searchPanel.add(maxSizeField);

        searchPanel.add(new JLabel("Min Price:"));
        searchPanel.add(minPriceField);
        searchPanel.add(new JLabel("Max Price:"));
        searchPanel.add(maxPriceField);

        searchPanel.add(new JLabel("Status:"));
        searchPanel.add(statusComboBox);
        searchPanel.add(new JLabel());
        searchPanel.add(searchButton);

        tableModel = new DefaultTableModel(new String[]{"ID", "Location", "Size", "Price", "Status", "Block", "Process"}, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setDefaultEditor(Object.class, null);

        table.getColumn("Process").setCellRenderer(new ButtonRenderer());
        table.getColumn("Process").setCellEditor(new ButtonEditor());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(580, 300));

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        if (!java.beans.Beans.isDesignTime()) {
            loadLotsFromDatabase();
            
        }
        
        searchButton.addActionListener(e -> filterLots());
    }

    private void loadLotsFromDatabase() {
        tableModel.setRowCount(0);
        allLots.clear();

        try {
            List<Lot> lots = lotModel.readAll();
            for (Lot lot : lots) {
                Object[] row = {
                    lot.getId(),
                    lot.getLocation(),
                    lot.getSize(),
                    lot.getPrice(),
                    lot.getStatus(),
                    lot.getBlockId(),
                    "Process"
                };
                allLots.add(row);
                tableModel.addRow(row);
            }
        } catch (Exception e) { // Catching general exceptions
            JOptionPane.showMessageDialog(this, "Error fetching lots: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filterLots() {
        tableModel.setRowCount(0);
        
        for (Object[] lot : allLots) {
            if (matchesFilters(lot)) {
                tableModel.addRow(lot);
            }
        }
    }

    private boolean matchesFilters(Object[] lot) {
        String location = locationField.getText().trim().toLowerCase();
        String block = blockField.getText().trim();
        String selectedStatus = statusComboBox.getSelectedItem().toString();
        BigDecimal minSize = getBigDecimal(minSizeField.getText());
        BigDecimal maxSize = getBigDecimal(maxSizeField.getText());
        BigDecimal minPrice = getBigDecimal(minPriceField.getText());
        BigDecimal maxPrice = getBigDecimal(maxPriceField.getText());

        String lotLocation = ((String) lot[1]).toLowerCase();
        BigDecimal lotSize = (BigDecimal) lot[2];
        BigDecimal lotPrice = (BigDecimal) lot[3];
        String lotStatus = lot[4].toString(); // Convert enum to String
        int lotBlock = (int) lot[5]; // int value

        System.out.print(lotLocation);
        System.out.print(lotSize);
        System.out.print(lotStatus);
        System.out.print(lotBlock);
        System.out.println("-------------------");

        if (!location.isEmpty() && !lotLocation.contains(location)) return false;
        if (!block.isEmpty() && !String.valueOf(lotBlock).equals(block)) return false; // Fixed
        if (!selectedStatus.equals("ALL") && !lotStatus.equals(selectedStatus)) return false;
        if (minSize != null && lotSize.compareTo(minSize) < 0) return false;
        if (maxSize != null && lotSize.compareTo(maxSize) > 0) return false;
        if (minPrice != null && lotPrice.compareTo(minPrice) < 0) return false;
        if (maxPrice != null && lotPrice.compareTo(maxPrice) > 0) return false;

        return true;
    }

    private BigDecimal getBigDecimal(String value) {
        try {
            return value.trim().isEmpty() ? null : new BigDecimal(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private class ButtonRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = new JButton("Process");
            button.setBackground(new Color(66, 135, 245));
            button.setForeground(Color.WHITE);
            return button;
        }
    }

    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
        private JButton button;
        private int selectedRow;

        public ButtonEditor() {
            button = new JButton("Process");
            button.setBackground(new Color(66, 135, 245));
            button.setForeground(Color.WHITE);
            button.addActionListener(e -> {
                int lotId = (int) table.getValueAt(selectedRow, 0);
                openProcessDialog(lotId);
                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            selectedRow = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Process";
        }
    }

    private void openProcessDialog(int lotId) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Process Lot", true);
        dialog.setSize(400, 250);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel buyerLabel = new JLabel("Buyer Name:");
        JTextField buyerField = new JTextField();
        JLabel actionLabel = new JLabel("Action:");
        JComboBox<String> actionBox = new JComboBox<>(new String[]{"Sell", "Reserve"});
        JButton confirmButton = new JButton("Confirm");

        dialog.add(buyerLabel);
        dialog.add(buyerField);
        dialog.add(actionLabel);
        dialog.add(actionBox);
        dialog.add(new JLabel());
        dialog.add(confirmButton);

        confirmButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(dialog, "Lot " + lotId + " processed successfully!");
            dialog.dispose();
        });

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}

