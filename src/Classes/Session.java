/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 * Singleton Session class to store the logged-in user.
 */
public class Session {
    private static Session instance;
    private User user;

    // Private constructor to prevent instantiation
    private Session() {}

    // Get the single instance of Session
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // Set the logged-in user
    public void setUser(User user) {
        this.user = user;
    }

    // Get the logged-in user
    public User getUser() {
        return user;
    }

    // Check if a user is logged in
    public boolean isLoggedIn() {
        return user != null;
    }

    // Clear the session (logout)
    public void clearSession() {
        user = null;
    }
}

