package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.enums.Constructions;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Imprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    LocalDateTime taken;
    String material;

    @ManyToOne
    Patient patient;
    @ManyToOne
    Doctor doctor;

    @OneToOne
    Formula formula;

    Constructions construction;

    LocalDateTime deadLine;
    LocalDateTime correctionAgreed;

    String message;

    public Boolean isCorrectionPlanned() {
        return correctionAgreed != null;
    }

    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTaken() {
        return taken;
    }

    public void setTaken(LocalDateTime taken) {
        this.taken = taken;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public Constructions getConstruction() {
        return construction;
    }

    public void setConstruction(Constructions construction) {
        this.construction = construction;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public LocalDateTime getCorrectionAgreed() {
        return correctionAgreed;
    }

    public void setCorrectionAgreed(LocalDateTime correctionAgreed) {
        this.correctionAgreed = correctionAgreed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
