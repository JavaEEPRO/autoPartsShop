package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    Clinic findByName(String name);

    @Override
    void delete(Clinic clinic);
}
