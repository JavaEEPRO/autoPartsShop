package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByRegistryNumber(Long registryNumber);

    List<Patient> findAllByFirstNameStartsWithOrderByLastName(String firstNameStartsWith);



    List<Patient> findAllByLastNameStartsWithOrderByLastName(String lastNameStartsWith);

    @Override
    void delete(Patient patient);
}
