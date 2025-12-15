package com.phukienthoitrang.ecommerce.controller;

import com.phukienthoitrang.ecommerce.model.Product;
import com.phukienthoitrang.ecommerce.service.CategoryService; // Giả định đã tạo
import com.phukienthoitrang.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;
    private final CategoryService categoryService; // Cần thiết để chọn danh mục khi thêm/sửa SP

    public AdminProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // 1. READ: Hiển thị danh sách Sản phẩm (Admin View)
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin/product-list"; // Trả về view: admin/product-list.html
    }

    // 2. CREATE: Hiển thị Form Thêm mới
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        // Lấy danh sách Categories để hiển thị trong dropdown
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/product-form"; // Trả về view: admin/product-form.html
    }

    // 3. CREATE/UPDATE: Xử lý lưu Sản phẩm
    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products"; // Sau khi lưu, quay lại danh sách
    }

    // 4. UPDATE: Hiển thị Form Sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/product-form";
    }

    // 5. DELETE: Xử lý xóa Sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // Giả định đã bổ sung hàm deleteProduct
        return "redirect:/admin/products";
    }
}