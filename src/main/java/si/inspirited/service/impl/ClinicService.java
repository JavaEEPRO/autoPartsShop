package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import si.inspirited.persistence.dao.ClinicRepository;
import si.inspirited.persistence.model.registry.Clinic;
import si.inspirited.service.IClinicService;
import si.inspirited.web.dto.ClinicDto;

public class ClinicService implements IClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic persistNewClinic(ClinicDto clinicDto) {

        Clinic res = new Clinic();
        res.setAddress(clinicDto.getAddress());
        res.setEdrpou(clinicDto.getEdrpou());
        res.setName(clinicDto.getName());

        res = clinicRepository.save(res);
        return res;
    }
}
