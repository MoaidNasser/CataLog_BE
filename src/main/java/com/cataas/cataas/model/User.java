package com.cataas.cataas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private String email; // username

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // "USER" أو "ADMIN"

    @Column(nullable = false)
    private boolean enabled = false;

    public User() {}

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = false;
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
