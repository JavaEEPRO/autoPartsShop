package si.inspirited.service;

import si.inspirited.persistence.model.registry.Clinic;
import si.inspirited.web.dto.ClinicDto;

public interface IClinicService {

    Clinic persistNewClinic(ClinicDto clinicDto);
}
