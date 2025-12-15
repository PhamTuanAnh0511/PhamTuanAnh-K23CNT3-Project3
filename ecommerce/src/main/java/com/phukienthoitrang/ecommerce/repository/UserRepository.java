package com.phukienthoitrang.ecommerce.repository;

import com.phukienthoitrang.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Phương thức cần thiết để Spring Security tìm kiếm user theo username
    Optional<User> findByUsername(String username);
}