package Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sentinail
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String role; // "ADMIN" or "CUSTOMER"

    // Constructor for creating a new user (id is auto-generated)
    public User(String username, String password, String fname, String lname, String role) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    // Constructor with ID (used when retrieving users from the database)
    public User(int id, String username, String password, String fname, String lname, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }
    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', fname='" + fname + "', lname='" + lname + "', role='" + role + "'}";
    }
}

