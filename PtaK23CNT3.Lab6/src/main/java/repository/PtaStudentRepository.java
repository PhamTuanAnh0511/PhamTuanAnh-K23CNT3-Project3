package repository;

import entity.PtaStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtaStudentRepository extends JpaRepository<PtaStudent, Integer> {
}
