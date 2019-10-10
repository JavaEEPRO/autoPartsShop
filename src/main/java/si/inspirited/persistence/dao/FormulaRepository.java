package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Formula;

import java.time.LocalDateTime;
import java.util.List;

public interface FormulaRepository extends JpaRepository<Formula, Long> {

    Formula findByWhenSnapshotted(LocalDateTime when);

    @Override
    void delete(Formula formula);

    @Override
    List<Formula> findAll(Sort sort);
}
