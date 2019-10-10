package si.inspirited.persistence.model.registry;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patients_doctors", joinColumns = @JoinColumn(name = "doctors_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "patients_id", referencedColumnName = "id"))
    List<Patient> patients;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "doctor_imprints_in_process", joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "imprints_id", referencedColumnName = "id"))
    List<Imprint> inProcess;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "doctor_imprints_history", joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "imprints_id", referencedColumnName = "id"))
    List<Imprint> history;      //OPT

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "doctor_examinations", joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examinations_id", referencedColumnName = "id"))
    List<PatientExamination> examinations;

    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Imprint> getInProcess() {
        return inProcess;
    }

    public void setInProcess(List<Imprint> inProcess) {
        this.inProcess = inProcess;
    }

    public List<Imprint> getHistory() {
        return history;
    }

    public void setHistory(List<Imprint> history) {
        this.history = history;
    }

    public List<PatientExamination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<PatientExamination> examinations) {
        this.examinations = examinations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
