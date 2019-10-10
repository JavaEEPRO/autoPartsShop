package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Xray;

import java.time.LocalDateTime;
import java.util.List;

public interface XrayRepository extends JpaRepository<Xray, Long> {

    Xray findByTaken(LocalDateTime when);

    @Override
    void delete(Xray xray);

    @Override
    List<Xray> findAll(Sort sort);
}
