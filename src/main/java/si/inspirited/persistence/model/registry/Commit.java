package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    LocalDateTime whenAdded;

    @ManyToOne
    Patient patient;

    @ManyToOne
    Tooth tooth;

    @ManyToOne
    Target target;

    String message;



    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getWhenAdded() {
        return whenAdded;
    }

    public void setWhenAdded(LocalDateTime whenAdded) {
        this.whenAdded = whenAdded;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
