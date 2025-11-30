package service;

import entity.PtaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PtaProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PtaProductService {

    @Autowired
    private PtaProductRepository productRepository;

    public List<PtaProduct> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<PtaProduct> findById(Long id) {
        return productRepository.findById(id);
    }

    public PtaProduct saveProduct(PtaProduct product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}