package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Imprint;

import java.time.LocalDateTime;
import java.util.List;

public interface ImprintRepository extends JpaRepository<Imprint, Long> {

    Imprint findByTaken(LocalDateTime when);

    @Override
    void delete(Imprint imprint);

    @Override
    List<Imprint> findAll(Sort sort);
}
