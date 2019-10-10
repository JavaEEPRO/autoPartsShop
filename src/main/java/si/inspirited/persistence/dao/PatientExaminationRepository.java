package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.PatientExamination;

import java.util.List;

public interface PatientExaminationRepository extends JpaRepository<PatientExamination, Long> {

    PatientExamination findByPatient(Patient patient);

    @Override
    void delete(PatientExamination patientExamination);

    @Override
    List<PatientExamination> findAll(Sort sort);
}
