package controller;

import entity.PtaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.PtaCategoryService;
import service.PtaProductService;

@Controller
public class PtaProductController {

    @Autowired
    private PtaProductService productService;

    @Autowired
    private PtaCategoryService categoryService;

    // GET /products
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/product-list";
    }

    // GET /products/create
    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new PtaProduct());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/product-form";
    }

    // GET /products/edit/{id}
    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        PtaProduct product = productService.findById(id).orElse(null);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/product-form";
    }

    // POST /products/create (create)
    @PostMapping("/products/create")
    public String saveProduct(@ModelAttribute("product") PtaProduct product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // POST /products/create/{id} (update)
    @PostMapping("/products/create/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute("product") PtaProduct product) {
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // GET /products/delete/{id}
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
