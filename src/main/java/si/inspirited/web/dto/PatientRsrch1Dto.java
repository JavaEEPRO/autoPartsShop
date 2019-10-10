package si.inspirited.web.dto;

import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.PatientExamination;
import si.inspirited.persistence.model.registry.Xray;

import java.time.LocalDateTime;
import java.util.List;

public class PatientRsrch1Dto {

    private Long id;

    Patient patient;

    LocalDateTime lastEditedAt;

    List<PatientExamination> examinations;

    String data;                                             //information chain, comments added from exam to exam

    Xray lastXray;


    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }

    public void setLastEditedAt(LocalDateTime lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
    }

    public List<PatientExamination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<PatientExamination> examinations) {
        this.examinations = examinations;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Xray getLastXray() {
        return lastXray;
    }

    public void setLastXray(Xray lastXray) {
        this.lastXray = lastXray;
    }
}
