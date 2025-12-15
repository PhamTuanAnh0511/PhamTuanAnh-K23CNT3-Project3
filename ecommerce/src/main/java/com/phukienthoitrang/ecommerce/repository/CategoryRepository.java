package com.phukienthoitrang.ecommerce.repository;

import com.phukienthoitrang.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Spring Data JPA sẽ tự động triển khai các phương thức CRUD
}