package Model;

import Classes.Block;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlockModel extends BaseModel<Block> {
    private static final String URL = Utils.Connection.ENDPOINT;
    private static final String USER = Utils.Connection.USER;
    private static final String PASSWORD = Utils.Connection.PASSWORD;
    
    @Override
    public Block create(Block block) throws SQLException {
        String query = "INSERT INTO Block (number, name, description) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, block.getNumber());
            stmt.setString(2, block.getName());
            stmt.setString(3, block.getDescription());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                block.setId(rs.getInt(1));
            }
            return block;
        }
    }
    
    @Override
    public Optional<Block> read(int id) throws SQLException {
        String query = "SELECT * FROM Block WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return Optional.of(new Block(
                    rs.getInt("id"),
                    rs.getInt("number"),
                    rs.getString("name"),
                    rs.getString("description")
                ));
            }
        }
        return Optional.empty();
    }
    
    @Override
    public List<Block> readAll() throws SQLException {
        List<Block> blocks = new ArrayList<>();
        String query = "SELECT * FROM Block";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                blocks.add(new Block(
                    rs.getInt("id"),
                    rs.getInt("number"),
                    rs.getString("name"),
                    rs.getString("description")
                ));
            }
        }
        return blocks;
    }
    
    public List<Block> getAllBlocks() throws SQLException {
        return readAll();
    }
    
    @Override
    public Block update(int id, Block block) throws SQLException {
        String query = "UPDATE Block SET number = ?, name = ?, description = ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, block.getNumber());
            stmt.setString(2, block.getName());
            stmt.setString(3, block.getDescription());
            stmt.setInt(4, id);
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0 ? block : null;
        }
    }
    
    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM Block WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}