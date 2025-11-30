package service;

import entity.PtaCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PtaCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PtaCategoryService {

    @Autowired
    private PtaCategoryRepository categoryRepository;

    public PtaCategoryService(PtaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy toàn bộ danh sách category
    public List<PtaCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Lấy category theo id
    public Optional<PtaCategory> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Tạo hoặc cập nhật category
    public void saveCategory(PtaCategory category) {
        categoryRepository.save(category);
    }

    // Xóa category theo id
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}