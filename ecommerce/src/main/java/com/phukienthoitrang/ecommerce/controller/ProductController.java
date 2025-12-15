package com.phukienthoitrang.ecommerce.controller;

import com.phukienthoitrang.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Hiển thị danh sách sản phẩm (Trang chủ/ Trang duyệt SP)
    @GetMapping("/")
    public String listProducts(Model model) {
        // Thêm danh sách sản phẩm vào Model để truyền sang View (Thymeleaf)
        model.addAttribute("products", productService.getAllProducts());
        return "index"; // Trả về tên file HTML: index.html
    }

    // Hiển thị chi tiết sản phẩm
    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> {
            model.addAttribute("product", product);
        });
        return "product-detail"; // Trả về file HTML: product-detail.html
    }

    // TODO: Bổ sung Controller cho Giỏ hàng, Đơn hàng, Quản trị (Admin)
}