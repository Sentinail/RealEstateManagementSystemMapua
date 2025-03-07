package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public User create(User user) throws SQLException {
    String query = "INSERT INTO user (username, password, fname, lname, role) VALUES (?, ?, ?, ?, ?)";
    
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getFname());
        stmt.setString(4, user.getLname());
        stmt.setString(5, user.getRole());
        
        stmt.executeUpdate();

        // Retrieve generated ID
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            user.setId(rs.getInt(1));
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
        String query = "SELECT * FROM user";

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

public User authenticate(String username, String password) throws SQLException {
    String query = "SELECT * FROM User WHERE username = ? AND password = ?";  // Note 'User' not 'users'
    
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pstmt = connection.prepareStatement(query)) {
        
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fname"),     // Note: column is 'fname' not 'firstname'
                rs.getString("lname"),     // Note: column is 'lname' not 'lastname'
                rs.getString("role")
            );
        }
    }
    return null;
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

