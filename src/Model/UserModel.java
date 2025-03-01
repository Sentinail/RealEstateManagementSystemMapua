package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Classes.User;

/**
 *
 * @author Sentinail
 */
public class UserModel extends BaseModel<User> {
    private static final String URL = Utils.Connection.ENDPOINT;
    private static final String USER = Utils.Connection.USER;
    private static final String PASSWORD = Utils.Connection.PASSWORD;

    @Override
    public User create(User user) throws SQLException { // Let the exception propagate
    String query = "INSERT INTO user (username, password, fname, lname, role) VALUES (?, ?, ?, ?, ?)";
    
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword()); // Store hashed password in real applications
        stmt.setString(3, user.getFname());
        stmt.setString(4, user.getLname());
        stmt.setString(5, user.getRole());
        
        stmt.executeUpdate();

        // Retrieve generated ID
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            user.setId(rs.getInt(1)); // Set the auto-generated ID
        }
        return user;
    }
}

    @Override
    public Optional<User> read(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
    
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getString("role")
                ));
            }
        }

        return Optional.empty();
    }

    @Override
    public List<User> readAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getString("role")
                ));
            }
        }

        return users;
    }

    @Override
    public User update(int id, User user) throws SQLException {
        String query = "UPDATE users SET username = ?, password = ?, fname = ?, lname = ?, role = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword()); // Store hashed password in real applications
            stmt.setString(3, user.getFname());
            stmt.setString(4, user.getLname());
            stmt.setString(5, user.getRole());
            stmt.setInt(6, id);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0 ? user : null;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
