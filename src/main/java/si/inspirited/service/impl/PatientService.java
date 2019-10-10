package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import si.inspirited.persistence.dao.PatientRepository;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.service.IPatientService;
import si.inspirited.web.dto.PatientDto;

import java.util.List;

@Service
@Transactional
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Patient persistNewPatient(PatientDto patientDto) {

        Patient patient;
        patient = findByRegistryNumber(patientDto.getRegistryNumber());
        if (patient == null) {patient = new Patient();}

        patient.setClinicName(patientDto.getClinicName().trim());
        patient.setClinicAddress(patientDto.getClinicAddress().trim());
        patient.setClinicEdrpou(patientDto.getClinicEdrpou());

        patient.setRegistryNumber(patientDto.getRegistryNumber());
        patient.setYear(patientDto.getYear());

        String firstName = patientDto.getFirstName().trim();
        String firstLetterOfFirstName = "" + firstName.charAt(0);
        firstLetterOfFirstName = firstLetterOfFirstName.toUpperCase();
        firstName = firstName.substring(1).toLowerCase();
        firstName = firstLetterOfFirstName + firstName;
        patient.setFirstName(firstName);

        String secondName = patientDto.getSecondName().trim();
        String firstLetterOfSecondName = "" + secondName.charAt(0);
        firstLetterOfSecondName = firstLetterOfSecondName.toUpperCase();
        secondName = secondName.substring(1).toLowerCase();
        secondName = firstLetterOfSecondName + secondName;
        patient.setSecondName(secondName);

        String lastName = patientDto.getLastName().trim();
        String firstLetterOfLastName = "" + lastName.charAt(0);
        firstLetterOfLastName = firstLetterOfLastName.toUpperCase();
        lastName = lastName.substring(1).toLowerCase();
        lastName = firstLetterOfLastName + lastName;
        patient.setLastName(lastName);

        patient.setGender(patientDto.isGender());
        patient.setBirthDay(patientDto.getBirthDay());

        patient.setPhone(patientDto.getPhone().trim());
        patient.setAddress(patientDto.getAddress().trim());


        patient.setComplaints(patientDto.getComplaints().trim());
        patient.setDiagnosis(patientDto.getDiagnosis().trim());
        patient.setTransferredAndConcomitantDiseases(patientDto.getTransferredAndConcomitantDiseases().trim());
        patient.setGrowthOfPresentDisease(patientDto.getGrowthOfPresentDisease().trim());

        Patient res;

        res = patientRepository.save(patient);
        return res;
    }

    @Override
    public Patient findByRegistryNumber(Long registryNumber) {
        return patientRepository.findByRegistryNumber(registryNumber);
    }

    @Override
    public List<Patient> findAllByFirstNameStartsWithOrderByLastName(String firstNameStartsWith) {
        String firstLetter = "" + firstNameStartsWith.charAt(0);
        firstLetter = firstLetter.toUpperCase();
        firstNameStartsWith = firstNameStartsWith.substring(1).toLowerCase();
        firstNameStartsWith = firstLetter + firstNameStartsWith;

        List<Patient> res = patientRepository.findAllByFirstNameStartsWithOrderByLastName(firstNameStartsWith);
        return res;
    }

    @Override
    public List<Patient> findAllByLastNameStartsWithOrderByLastName(String lastNameStartsWith) {
        String firstLetter = "" + lastNameStartsWith.charAt(0);
        firstLetter = firstLetter.toUpperCase();
        lastNameStartsWith = lastNameStartsWith.substring(1).toLowerCase();
        lastNameStartsWith = firstLetter + lastNameStartsWith;

        List<Patient> res = patientRepository.findAllByLastNameStartsWithOrderByLastName(lastNameStartsWith);
        return res;                                                          //that's U
    }
}
