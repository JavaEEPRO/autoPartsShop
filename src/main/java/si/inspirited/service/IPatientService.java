package si.inspirited.service;

import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.web.dto.PatientDto;

import java.util.List;

public interface IPatientService {

    Patient persistNewPatient(PatientDto patientDto);

    Patient findByRegistryNumber(Long registryNumber);

    List<Patient> findAllByFirstNameStartsWithOrderByLastName(String firstNameStartsWith);

    List<Patient> findAllByLastNameStartsWithOrderByLastName(String lastNameStartsWith);

}
