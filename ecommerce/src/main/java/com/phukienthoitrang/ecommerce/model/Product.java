package com.phukienthoitrang.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    // Ví dụ về Getters/Setters (Không đưa hết vào đây để code ngắn gọn)
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private Integer stockQuantity;

    private String imageUrl; // Đường dẫn ảnh

    // Liên kết Many-to-One với Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Constructors, Getters và Setters... (Bạn nên tự thêm hoặc dùng Lombok)

    // ...
}