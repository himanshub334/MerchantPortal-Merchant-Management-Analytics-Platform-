package com.example.merchantportal.merchant;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "merchants", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Merchant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120) private String name;
    @Column(nullable = false, length = 180) private String email;
    @Column(nullable = false, length = 80) private String category;
    @Column(nullable = false, length = 24) private String status = "PENDING";
    @Column(nullable = false) private Instant createdAt = Instant.now();

    protected Merchant() {}
    public Merchant(String name, String email, String category) {
        this.name = name; this.email = email; this.category = category;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
    public void setStatus(String status) { this.status = status; }
}
