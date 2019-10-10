package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.Target;

import java.util.List;

public interface TargetRepository extends JpaRepository<Target, Long> {

    Target findByPatient(Patient patient);

    @Override
    void delete(Target target);

    @Override
    List<Target> findAll(Sort sort);
}
