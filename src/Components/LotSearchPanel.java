/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import Classes.Lot;
import Classes.User;
import Model.LotModel;
import Model.UserModel;
import Utils.CSV;

/**
 *
 * @author Sentinail
 */
public class LotSearchPanel extends JPanel {
    // Variables
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField locationField, minSizeField, maxSizeField, minPriceField, maxPriceField, blockField;
    private JComboBox<String> statusComboBox;
    private List<Object[]> allLots = new ArrayList<>();
    private LotModel lotModel = new LotModel();

    // Constructor
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
        JButton exportButton = new JButton("Export");

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
        
        searchPanel.add(new JLabel());
        searchPanel.add(exportButton);

        tableModel = new DefaultTableModel(new String[]{"ID", "Owner", "Location", "Size", "Price", "Status", "Block", "Process"}, 0);
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
        exportButton.addActionListener(e -> exportTableData());
    }
    
    // Export
    public void exportTableData() {
        List<String[]> data = new ArrayList<>();

        String[] header = {"Block", "Location", "Size", "Price", "Status", "Owner"};
        data.add(header);

        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String block = tableModel.getValueAt(i, 6).toString();
            String location = tableModel.getValueAt(i, 2).toString();  
            String size = tableModel.getValueAt(i, 3).toString();  
            String price = tableModel.getValueAt(i, 4).toString(); 
            String status = tableModel.getValueAt(i, 5).toString(); 
            String owner = tableModel.getValueAt(i, 1) != null ? tableModel.getValueAt(i, 1).toString() : "N/A"; // Assuming Owner is at index 2

            data.add(new String[]{block, location, size, price, status, owner});
        }

        String filePath = "src/report/lots_report.csv";

        try {
            CSV.writeToFile(filePath, data);
            JOptionPane.showMessageDialog(null, "CSV file successfully created at: " + filePath, "Export Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error exporting CSV: " + e.getMessage(), "Export Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Refresh
    public void refreshData() {
        loadLotsFromDatabase();
    }
    
    // Load
    private void loadLotsFromDatabase() {
        tableModel.setRowCount(0);
        allLots.clear();

        try {
            List<Lot> lots = lotModel.readAll();
            for (Lot lot : lots) {
                Object[] row = {
                    lot.getId(),
                    lot.getCustomer(),
                    lot.getLocation(),
                    lot.getSize(),
                    lot.getPrice(),
                    lot.getStatus(),
                    lot.getBlockNumber(),
                    "Process"
                };
                allLots.add(row);
                tableModel.addRow(row);
            }
        } catch (Exception e) { // Catching general exceptions
            JOptionPane.showMessageDialog(this, "Error fetching lots: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Filter
    private void filterLots() {
        tableModel.setRowCount(0);
        
        for (Object[] lot : allLots) {
            if (matchesFilters(lot)) {
                tableModel.addRow(lot);
            }
        }
    }

    // Match
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
        String lotStatus = lot[4].toString();
        int lotBlock = (int) lot[5];

        System.out.print(lotLocation);
        System.out.print(lotSize);
        System.out.print(lotStatus);
        System.out.print(lotBlock);
        System.out.println("-------------------");

        if (!location.isEmpty() && !lotLocation.contains(location)) return false;
        if (!block.isEmpty() && !String.valueOf(lotBlock).equals(block)) return false;
        if (!selectedStatus.equals("ALL") && !lotStatus.equals(selectedStatus)) return false;
        if (minSize != null && lotSize.compareTo(minSize) < 0) return false;
        if (maxSize != null && lotSize.compareTo(maxSize) > 0) return false;
        if (minPrice != null && lotPrice.compareTo(minPrice) < 0) return false;
        if (maxPrice != null && lotPrice.compareTo(maxPrice) > 0) return false;

        return true;
    }

    // Convert
    private BigDecimal getBigDecimal(String value) {
        try {
            return value.trim().isEmpty() ? null : new BigDecimal(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Render
    private class ButtonRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = new JButton("Process");
            button.setBackground(new Color(66, 135, 245));
            button.setForeground(Color.WHITE);
            return button;
        }
    }

    // Edit
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

    // Process
    private void openProcessDialog(int lotId) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Process Lot", true);
        dialog.setSize(400, 250);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel buyerLabel = new JLabel("Buyer:");
        JComboBox<User> buyerDropdown = new JComboBox<>();
        JLabel actionLabel = new JLabel("Action:");
        JComboBox<String> actionBox = new JComboBox<>(new String[]{"Sell", "Reserve"});
        JButton confirmButton = new JButton("Confirm");

        try {
            UserModel userModel = new UserModel();
            List<User> users = userModel.readAll();
            for (User user : users) {
                buyerDropdown.addItem(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(dialog, "Error fetching users: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        buyerDropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof User) {
                    User user = (User) value;
                    setText(user.getFname() + " " + user.getLname());
                }
                return this;
            }
        });

        dialog.add(buyerLabel);
        dialog.add(buyerDropdown);
        dialog.add(actionLabel);
        dialog.add(actionBox);
        dialog.add(new JLabel());
        dialog.add(confirmButton);

        confirmButton.addActionListener(e -> {
            User selectedBuyer = (User) buyerDropdown.getSelectedItem();
            String action = (String) actionBox.getSelectedItem();

            if (selectedBuyer == null) {
                JOptionPane.showMessageDialog(dialog, "Please select a buyer!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                LotModel lotModelInstance = new LotModel();

                Optional<Lot> optionalLot = lotModelInstance.read(lotId);
                if (optionalLot.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Lot not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Lot lot = optionalLot.get();
                lot.setCustomerId(selectedBuyer.getId());
                lot.setStatus(action.equals("Sell") ? Lot.Status.SOLD : Lot.Status.RESERVED);

                Lot updatedLot = lotModelInstance.update(lotId, lot);

                if (updatedLot != null) {
                    this.loadLotsFromDatabase();
                    
                    JOptionPane.showMessageDialog(dialog, "Lot " + lotId + " processed successfully for " +
                            selectedBuyer.getFname() + " " + selectedBuyer.getLname() + "!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Failed to update lot!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(dialog, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
        });

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}

