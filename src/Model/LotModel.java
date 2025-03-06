package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Sentinail
 */
import Classes.Lot;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LotModel extends BaseModel<Lot> {

    private static final String URL = Utils.Connection.ENDPOINT;
    private static final String USER = Utils.Connection.USER;
    private static final String PASSWORD = Utils.Connection.PASSWORD;

    @Override
    public Lot create(Lot lot) throws SQLException {
        String query = "INSERT INTO Lot (blockId, customerId, location, size, price, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, lot.getBlockId());
            if (lot.getCustomerId() != null) {
                stmt.setInt(2, lot.getCustomerId());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.setString(3, lot.getLocation());
            stmt.setBigDecimal(4, lot.getSize());
            stmt.setBigDecimal(5, lot.getPrice());
            stmt.setString(6, lot.getStatus().name());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lot.setId(rs.getInt(1));
            }
            return lot;
        }
    }

    @Override
    public Optional<Lot> read(int id) throws SQLException {
        String query = """
            SELECT l.id, l.blockId, b.number AS block, 
                   l.customerId, CONCAT(u.fname, ' ', u.lname) AS customer, 
                   l.location, l.size, l.price, l.status
            FROM Lot l
            LEFT JOIN Block b ON l.blockId = b.id
            LEFT JOIN User u ON l.customerId = u.id
            WHERE l.id = ?
        """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Lot(
                        rs.getInt("id"),
                        rs.getInt("blockId"),
                        rs.getInt("block"),
                        rs.getObject("customerId") != null ? rs.getInt("customerId") : null,
                        rs.getString("customer"),
                        rs.getString("location"),
                        rs.getBigDecimal("size"),
                        rs.getBigDecimal("price"),
                        Lot.Status.valueOf(rs.getString("status"))
                ));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Lot> readAll() throws SQLException {
    List<Lot> lots = new ArrayList<>();
    String query = """
        SELECT l.*, 
               b.number AS block_number, 
               u.fname, u.lname
        FROM Lot l
        LEFT JOIN Block b ON l.blockId = b.id
        LEFT JOIN User u ON l.customerId = u.id
    """;

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String customerName = rs.getString("fname") != null ? rs.getString("fname") + " " + rs.getString("lname") : null;
            lots.add(new Lot(
                    rs.getInt("id"),
                    rs.getInt("blockId"),
                    rs.getInt("block_number"), // Block number
                    rs.getObject("customerId") != null ? rs.getInt("customerId") : null,
                    customerName, // Full customer name
                    rs.getString("location"),
                    rs.getBigDecimal("size"),
                    rs.getBigDecimal("price"),
                    Lot.Status.valueOf(rs.getString("status"))
                ));
            }
        }
        return lots;
    }

    @Override
    public Lot update(int id, Lot lot) throws SQLException {
        String query = "UPDATE Lot SET blockId = ?, customerId = ?, location = ?, size = ?, price = ?, status = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, lot.getBlockId());
            if (lot.getCustomerId() != null) {
                stmt.setInt(2, lot.getCustomerId());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.setString(3, lot.getLocation());
            stmt.setBigDecimal(4, lot.getSize());
            stmt.setBigDecimal(5, lot.getPrice());
            stmt.setString(6, lot.getStatus().name());
            stmt.setInt(7, id);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0 ? lot : null;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM Lot WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean createLot(Lot lot) {
        try {
            // Convert from your method parameters to what Lot constructor expects
            return create(lot) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
