package repository;

import entity.PtaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PtaCategoryRepository extends JpaRepository<PtaCategory, Long> {

}