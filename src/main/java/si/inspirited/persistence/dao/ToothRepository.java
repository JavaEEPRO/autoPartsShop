package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.List;

public interface ToothRepository extends JpaRepository<Tooth, Long> {

    Tooth findByPatient(Patient patient);

    @Override
    void delete(Tooth tooth);

    @Override
    List<Tooth> findAll(Sort sort);
}
