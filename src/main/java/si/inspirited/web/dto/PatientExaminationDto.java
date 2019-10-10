package si.inspirited.web.dto;

import si.inspirited.persistence.model.registry.Doctor;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.pagesObj.PatientRsrch1;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.time.LocalDateTime;
import java.util.List;

public class PatientExaminationDto {

    private Long id;

    Doctor doctor;

    Patient patient;

    List<PatientRsrch1> patientRsrch1;


    List<Tooth> touchedInThisSession;

    String data;    // conclusion of examination

    String costs;

    Boolean showAffected;






    LocalDateTime plannedToStart;
    String strReprOfPlannedToStart;
    LocalDateTime started;

    LocalDateTime plannedToFinish;
    String strReprOfPlannedToFinish;
    LocalDateTime finished;

    public LocalDateTime getPlannedToStart() {
        return plannedToStart;
    }

    public void setPlannedToStart(LocalDateTime plannedToStart) {
        this.plannedToStart = plannedToStart;
    }

    public LocalDateTime getStarted() {
        return started;
    }

    public void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public LocalDateTime getPlannedToFinish() {
        return plannedToFinish;
    }

    public void setPlannedToFinish(LocalDateTime plannedToFinish) {
        this.plannedToFinish = plannedToFinish;
    }

    public LocalDateTime getFinished() {
        return finished;
    }

    public void setFinished(LocalDateTime finished) {
        this.finished = finished;
    }


    //


    public String getStrReprOfPlannedToStart() {
        return strReprOfPlannedToStart;
    }

    public void setStrReprOfPlannedToStart(String strReprOfPlannedToStart) {
        this.strReprOfPlannedToStart = strReprOfPlannedToStart;
    }

    public String getStrReprOfPlannedToFinish() {
        return strReprOfPlannedToFinish;
    }

    public void setStrReprOfPlannedToFinish(String strReprOfPlannedToFinish) {
        this.strReprOfPlannedToFinish = strReprOfPlannedToFinish;
    }


    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<PatientRsrch1> getPatientRsrch1() {
        return patientRsrch1;
    }

    public void setPatientRsrch1(List<PatientRsrch1> patientRsrch1) {
        this.patientRsrch1 = patientRsrch1;
    }

    public List<Tooth> getTouchedInThisSession() {
        return touchedInThisSession;
    }

    public void setTouchedInThisSession(List<Tooth> touchedInThisSession) {
        this.touchedInThisSession = touchedInThisSession;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public Boolean getShowAffected() {
        return showAffected;
    }

    public void setShowAffected(Boolean showAffected) {
        this.showAffected = showAffected;
    }
}
