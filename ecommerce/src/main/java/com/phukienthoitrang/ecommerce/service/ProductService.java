package com.phukienthoitrang.ecommerce.service;

import com.phukienthoitrang.ecommerce.model.Product;
import com.phukienthoitrang.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Dependency Injection qua Constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Quản lý sản phẩm (ADMIN)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Khách hàng/Người dùng
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Tìm kiếm (CUSTOMER/USER)
    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}