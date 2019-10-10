package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Commit;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.List;

public interface CommitRepository extends JpaRepository<Commit, Long> {

    Commit findByTooth(Tooth tooth);

    Commit findByPatient(Patient patient);

    @Override
    void delete(Commit commit);

    @Override
    List<Commit> findAll(Sort sort);
}
