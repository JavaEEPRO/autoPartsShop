package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.pagesObj.PatientRsrch1;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class PatientExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Doctor doctor;

    @ManyToOne
    Patient patient;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rsrch1_examinations", joinColumns = @JoinColumn(name = "examinations_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rsrch1_id", referencedColumnName = "id"))
    List<PatientRsrch1> patientRsrch1;

    LocalDateTime plannedToStart;
    LocalDateTime started;

    LocalDateTime plannedToFinish;
    LocalDateTime finished;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "examinations_teeth", joinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"))
    List<Tooth> touchedInThisSession;

    String data;    // conclusion of examination

    String costs;

    boolean showAffected;

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

    public LocalDateTime getStarted() {
        return started;
    }

    public void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public List<Tooth> getTouchedInThisSession() {
        return touchedInThisSession;
    }

    public void setTouchedInThisSession(List<Tooth> touchedInThisSession) {
        this.touchedInThisSession = touchedInThisSession;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getPlannedToStart() {
        return plannedToStart;
    }

    public void setPlannedToStart(LocalDateTime plannedToStart) {
        this.plannedToStart = plannedToStart;
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

    public boolean isShowAffected() {
        return showAffected;
    }

    public void setShowAffected(boolean showAffected) {
        this.showAffected = showAffected;
    }

    public List<PatientRsrch1> getPatientRsrch1() {
        return patientRsrch1;
    }

    public void setPatientRsrch1(List<PatientRsrch1> patientRsrch1) {
        this.patientRsrch1 = patientRsrch1;
    }


}

