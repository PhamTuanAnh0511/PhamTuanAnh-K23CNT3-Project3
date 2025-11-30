package repository;

import entity.PtaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtaProductRepository extends JpaRepository<PtaProduct, Long> {
}