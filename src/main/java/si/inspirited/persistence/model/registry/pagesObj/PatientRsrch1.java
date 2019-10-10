package si.inspirited.persistence.model.registry.pagesObj;

import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.PatientExamination;
import si.inspirited.persistence.model.registry.Xray;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class PatientRsrch1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    Patient patient;

    LocalDateTime lastEditedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rsrch1_examinations", joinColumns = @JoinColumn(name = "rsrch1_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examinations_id", referencedColumnName = "id"))
    List<PatientExamination> examinations;

    String data;                                             //information chain, comments added from exam to exam

    @OneToOne
    Xray lastXray;


    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
