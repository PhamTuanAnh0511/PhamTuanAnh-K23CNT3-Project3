package com.phukienthoitrang.ecommerce.model;

import jakarta.persistence.*;
import java.util.Set;
// ... (các import khác)

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // <-- Thuộc tính này

    // ... (các thuộc tính khác: password, email, fullName, roles)

    // ----------------------------------------------------
    // PHẦN CẦN KIỂM TRA/BỔ SUNG
    // ----------------------------------------------------

    // Getter cho username (Cần thiết cho CustomUserDetailsService)
    public String getUsername() {
        return username;
    }

    // Setter cho username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter/Setter cho password
    public String getPassword() {
        // ...
        return "";
    }
    public void setPassword(String password) {
        // ...
    }

    // Getter/Setter cho roles
    public Set<Role> getRoles() {
        // ...
        return Set.of();
    }
    public void setRoles(Set<Role> roles) {
        // ...
    }

    public void setEmail(String mail) {
    }

    public void setFullName(String quảnTrịViênHệThống) {
    }

    // ... (các Getters/Setters khác cho id, email, fullName)
}