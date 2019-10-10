package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.pagesObj.PatientRsrch1;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientRsrch1Repository extends JpaRepository<PatientRsrch1, Long> {

    PatientRsrch1 findByLastEditedAt(LocalDateTime when);

    @Override
    void delete(PatientRsrch1 patientRsrch1);

    @Override
    List<PatientRsrch1> findAll(Sort sort);
}
