package controller;

import org.springframework.ui.Model;

import entity.PtaCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.PtaCategoryService;

@Controller
public class PtaCategoryController {

    @Autowired
    private PtaCategoryService categoryService;

    @GetMapping("/category")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/category-list";
    }

    @GetMapping("/category/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new PtaCategory());
        return "category/category-form";
    }

    @GetMapping("/category/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category",
                categoryService.getCategoryById(id).orElse(null));
        return "category/category-form";
    }

    @PostMapping("/category/create")
    public String saveCategory(@ModelAttribute("category") PtaCategory category) {
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @PostMapping("/category/create/{id}")
    public String updateCategory(@PathVariable Long id,
                                 @ModelAttribute("category") PtaCategory category) {
        category.setId(id);
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }
}