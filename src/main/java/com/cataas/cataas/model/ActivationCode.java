package com.cataas.cataas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @OneToOne
    private User user;

    private LocalDateTime expiryDate;

    public ActivationCode() {
    }

    public ActivationCode(Long id, String code, User user, LocalDateTime expiryDate) {
        this.id = id;
        this.code = code;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
