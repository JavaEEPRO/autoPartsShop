package si.inspirited.persistence.model.registry.teeth;

import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.enums.Localizations;

import javax.persistence.*;
import java.util.List;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Patient patient;

    @ManyToOne
    Tooth tooth;

    @ManyToOne
    Root root;

    @ElementCollection(targetClass = Localizations.class)
    @Column(name = "localizations", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Localizations> localizations;



    //new fields
    boolean passedThrough;
    boolean pulpRemoved;
    boolean sealed;
    //end of new fields

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

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public List<Localizations> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(List<Localizations> localizations) {
        this.localizations = localizations;
    }

    public boolean isPassedThrough() {
        return passedThrough;
    }

    public void setPassedThrough(boolean passedThrough) {
        this.passedThrough = passedThrough;
    }

    public boolean isPulpRemoved() {
        return pulpRemoved;
    }

    public void setPulpRemoved(boolean pulpRemoved) {
        this.pulpRemoved = pulpRemoved;
    }

    public boolean isSealed() {
        return sealed;
    }

    public void setSealed(boolean sealed) {
        this.sealed = sealed;
    }
}
